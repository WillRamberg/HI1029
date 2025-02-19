package com.example.hi1029.F12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Item {
    int weight, value, nrOfIndex;
    double valuePerWeight;

    public Item(int weight, int value, int nrOfIndex) {
        this.weight = weight;
        this.value = value;
        this.nrOfIndex = nrOfIndex;
        this.valuePerWeight = (double) value / weight;
    }
}

public class NB35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange kappsäckens maxvikt: ");
        int maxWeight = scanner.nextInt();

        System.out.print("Ange antal föremål: ");
        int n = scanner.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ange vikt för föremål " + (i + 1) + ": ");
            int weight = scanner.nextInt();

            System.out.print("Ange värde för föremål " + (i + 1) + ": ");
            int value = scanner.nextInt();

            items[i] = new Item(weight, value, i+1);
        }

        Arrays.sort(items, Comparator.comparingDouble((Item i) -> -i.valuePerWeight));

        int totalValue = 0;
        int[] itemCount = new int[n];
        int remainingWeight = maxWeight;

        for (int i = 0; i < n; i++) {
            if (remainingWeight >= items[i].weight) {
                int count = remainingWeight / items[i].weight;
                itemCount[i] = count;
                totalValue += count * items[i].value;
                remainingWeight -= count * items[i].weight;
            }
        }

        System.out.println("\nResultat:");
        System.out.println("Totalt värde i kappsäcken: " + totalValue);
        for (int i = 0; i < n; i++) {
            System.out.println("Föremål " + (items[i].nrOfIndex) + ": " + itemCount[i] + " st");
        }

        scanner.close();
    }
}

