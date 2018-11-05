
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;

import java.util.ArrayList;

/**
 *
 * @author 1605216
 */
public class Kruskal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int INF = 999;
        int[][] Matrix = {
            // A  B   C    D    E    F    G   H   I
            // a
            {INF, 4, INF, INF, INF, INF, INF, 8, INF},
            // b
            {4, INF, 8, INF, INF, INF, INF, 11, INF},
            // c
            {INF, 8, INF, 7, INF, 4, INF, INF, 2},
            // d
            {INF, INF, 7, INF, 9, 14, INF, INF, INF},
            // e
            {INF, INF, INF, 9, INF, 10, INF, INF, INF},
            // f
            {INF, INF, 4, 14, 10, INF, 2, INF, INF},
            // g 
            {INF, INF, INF, INF, INF, 2, INF, 1, 6},
            // h
            {8, 11, INF, INF, INF, INF, 1, INF, 7},
            // i
            {INF, INF, 2, INF, INF, INF, 6, 7, INF}};

        Kruskal(Matrix, INF);

    }

    public static void Kruskal(int[][] Matrix, int INF) {

        /*
         Kruskal’s Algorithm
        
        
         - Description:
        
        
         - Parameters:
        
        
        
         - Output:
        
        
         */
        int[] parent = new int[Matrix.length];
        int min;
        int u = 0;
        int v = 0;
        int noOfEdges = 1;
        int total = 0;
        int[] visited = new int[Matrix[0].length];
        int[] isParent = new int[Matrix[0].length];
        char[][] minHeap = new char[Matrix[0].length][2];
        int[] distances = new int[Matrix[0].length];

        int source = 0;
        for (int i = 0; i < Matrix.length; i++) {

            parent[i] = 0;
            visited[i] = 0;
            isParent[i] = 0;

        }
                visited[source]=1;

                

        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] labels = new char[Matrix.length];
        ArrayList<Integer> parentNodes = new ArrayList<Integer>();

        int destinationNode = 0;

        for (int i = 0; i < Matrix.length; i++) {
            labels[i] = alphabet[i];
        }

        while (noOfEdges < Matrix.length) {

            min = INF;

            for (int i = 0; i < Matrix.length; i++) {

                for (int j = 0; j < Matrix.length; j++) {

                    if (Matrix[i][j] < min && visited[j] != 1) {

                        min = Matrix[i][j];
                        u = i;
                        v = j;
                        destinationNode = i;

                    }

                }

            }

//            while (parent[u] != 0) {
//                //   System.out.println("ininite loop!!");
//               // System.out.println("u = " + labels[u] + "\tparent[u] = " + labels[parent[u]]);
//
//                u = parent[u];
//                // System.out.println("u = "+ u +"\tparent[u] = "+parent[u]);
//                //parent[u] = 0;
//            }
//
//            while (parent[v] != 0) {
//                //  System.out.println("infinite loop 2!!!!!");
//
//              //  System.out.println("v = " + labels[v] + "\tparent[v] = " + labels[parent[v]]);
//
//                v = parent[v];
//
//            }
            // make sure destination is not a parent node:
//            for (int i = 0; i < parentNodes.length; i++) {
//                if (parentNodes[i] == destinationNode) {
//                    parentNodes[i] = v;
//                    break;
//                } else {
//
//                    noOfEdges++;
//                    System.out.println("Edge Found: " + labels[u] + "->" + labels[v] + " Min : " + min);
//                    total += min;
//                    parent[v] = u;
//
//                    visited[v] = 1; //doesn't visit e 
//
//            //visited[u] = 1; // doesn't visit c
//                    // parent[u] = v;
//                    Matrix[u][v] = INF;
//                    Matrix[v][u] = INF;
//                }
//
//            }
// !parentNodes.contains(destinationNode)||
        //    if (isParent[u] != 1) {
                noOfEdges++;
                minHeap[v][0] = labels[u];
                minHeap[v][1] = labels[v];
                distances[v] = min;
                System.out.println("Edge Found: " + minHeap[v][0] + "->" + minHeap[v][1] + " Min : " + distances[v]);

                total += min;
                //  parent[v] = u;
                // parentNodes.add(parent[v]);//            System.out.println("Parent: "+labels[parent[v]]);
                isParent[u] = 1;
                visited[v] = 1;

//  visited[u] = 1; //doesn't visit e 
           // }

            //visited[u] = 1; // doesn't visit c
            // parent[u] = v;
            Matrix[u][v] = INF;
            Matrix[v][u] = INF;

        }

        System.out.println("The weight of the minimum spanning tree is " + total);
    }

//    public static void print(int[][] MST, int[] distances) {
//        for (int i = 0; i < MST.length; i++) {
//            for (int j = 0; j < MST[i].length; j++) {
//                System.out.println("Edge Found: " + MST[i][j] + "->" + MST[i][j] + " Min : " + distances[j]);
//
//            }
//
//        }
//
//    }
}
