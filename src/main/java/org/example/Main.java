package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> result;
        System.out.println(result = getRandomList(25, 1, 100));
        System.out.println(bubbleSort(result));
    }

    public static ArrayList<Integer> getRandomList(int n, int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt((max - min) + 1) + min);
        }

        return list;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> list) {
        int count = 1;
        int temp;
        while (count > 0) {
            count = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i + 1) < list.get(i)) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    count++;
                }
            }
        }
        return list;
    }
}