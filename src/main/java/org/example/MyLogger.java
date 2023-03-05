package org.example;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;

public class MyLogger implements Runnable {
    private ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
    ;
    private File file;
    private PrintWriter printWriter;
    private FileWriter fw;


    public MyLogger() {
    }

    public void addToQue(String string) {
        try {
            this.queue.put(string);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayBlockingQueue<String> getQueue() {
        return queue;
    }

    @Override
    public void run() {
        if (this.file == null) {
            this.file = new File("log.txt");
            if (!this.file.exists()) {
                try {
                    this.file.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (this.printWriter == null && this.fw == null) {
            try {
                this.fw = new FileWriter(this.file, true);
                this.printWriter = new PrintWriter(this.fw, true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        while (true) {
            try {
                String string = this.queue.take();
                this.printWriter.println(string);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}