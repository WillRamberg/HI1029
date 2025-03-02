/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.hi1029.F11;

import java.util.Arrays;

/**
 *
 * @author bfelt
 */

public class Prim {


	
	public static void main(String[] args) {
		int X = Integer.MAX_VALUE;
		int[][] w = {	
						{	X, 2, X, X, X, 1, X, X},
						{	2, X, 2, 2, 4, X, X, X},
						{	X, 2, X, X, 3, X, X, 1},
						{	X, 2, X, X, 4, 1, X, X},
						{	X, 4, 3, 4, X, X, 7, X},
						{	1, X, X, 1, X, X, 5, X},
						{	X, X, X, X, 7, 5, X, 6},
						{	X, X, 1, X, X, X, 6, X}};
		int[] p = prim(w);
		System.out.println("Node A var startnode");
		for(int i=1; i<p.length;i++)
			System.out.println("Nod "+(char)(i+'A')+" anslöts via "+(char)(p[i]+'A'));
		int distance =0;
		for(int i=1;i<w.length;i++)
			distance+=w[i][p[i]];
		System.out.println("Totalvikt: "+distance);
	}

	public static int minSpanTree(int[][] w, int[] connections){
		int[] p = prim(w);

		System.arraycopy(p,0,connections,0,connections.length);

		int distance =0;
		for(int i=1;i<w.length;i++)
			distance+=w[i][p[i]];

		return distance;
	}

	private static int[] prim(int[][] w) {
		int n = w.length;
		int[] p = new int[n]; // p[v] håller föräldern till v i MST
		int[] key = new int[n]; // Nyckelvärde för att välja min viktkant
		boolean[] inMST = new boolean[n]; // Markerar om noden är med i MST

		Arrays.fill(key, Integer.MAX_VALUE);
		Arrays.fill(p, -1);
		key[0] = 0; // Startnoden sätts till 0

		for (int i = 0; i < n - 1; i++) {
			int u = minKey(key, inMST, n);
			inMST[u] = true;

			for (int v = 0; v < n; v++) {
				if (w[u][v] != Integer.MAX_VALUE && !inMST[v] && w[u][v] < key[v]) {
					key[v] = w[u][v];
					p[v] = u;
				}
			}
		}
		return p;
	}

	private static int minKey(int[] key, boolean[] inMST, int n) {
		int min = Integer.MAX_VALUE, minIndex = -1;

		for (int v = 0; v < n; v++) {
			if (!inMST[v] && key[v] < min) {
				min = key[v];
				minIndex = v;
			}
		}
		return minIndex;
	}

}
