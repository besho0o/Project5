
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;

import java.util.*;

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

        int[][] test = {
            {INF, 1, 1},
            {1, INF, 1},
            {1, 1, INF},};
//
//        int[][] test2 = {
//            {INF, 1, INF},
//            {1, INF, 1},
//            {INF, 1, INF},};

        LinkedList[] AdjacencyList = new LinkedList[test.length];

        char[] alphabetTST = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] labelsTST = new char[test.length];

        for (int i = 0; i < test.length; i++) {
            AdjacencyList[i] = new LinkedList();

            labelsTST[i] = alphabetTST[i];

        }

        //  int[][] adjacentNodes = new int[test.length][test.length];
//
//        for (int i = 0; i < parentTEST.length; i++) {
//            for (int j = 0; j < parentTEST[i].length; j++) {
//                parentTEST[i][j] = 1000;
//
//            }
//
//        }
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test.length; j++) {
                if (test[i][j] != INF) {
//                    if (adjacentNodes[i][j] == 1000) {
//                        adjacentNodes[j][i] = i;
//                        adjacentNodes[i][j] = j;
//
//                    }

// AdjacencyList[j].setHead(head);
                    AdjacencyList[j].InsertNeighbor(i, labelsTST[i]);

                }

            }

        }

        for (int i = 0; i < AdjacencyList.length; i++) {
            System.out.println(labelsTST[i] + "'s neighbors: ");
            AdjacencyList[i].PrintNeighbors();
            System.out.println("\n\n\n");

        }
//
//        for (int i = 0; i < AdjacencyList.length; i++) {
//
//            LLnode parentHead = AdjacencyList[i].getHead();
//
//
//                int destINDEX = parentHead.getNext().getIndex();
//                LLnode destinationHead = AdjacencyList[destINDEX].getHead();
//
//                System.out.println("Checking cyclicity from " + parentHead.getLabel() + " to " + destinationHead.getLabel() + "...\n");
//                System.out.println(AdjacencyList[i].findCycle(parentHead, destinationHead, AdjacencyList[i], AdjacencyList[destINDEX]));
//            
//
//        }
        for (int i = 0; i < test.length; i++) {
            LLnode parentHead = AdjacencyList[i].getHead();
           // System.out.println("p = "+parentHead.getLabel());

            for (int j = 0; j < test[i].length; j++) {
                if (i == j) {
                    continue;
                }

                LLnode destinationHead = AdjacencyList[j].getHead();
                System.out.println("Checking cyclicity at edge " + labelsTST[i] + "->" + labelsTST[j] + "...\n");

                //                        System.out.println(AdjacencyList[i].findCycle(i, j,  AdjacencyList[i],  AdjacencyList[j]));
//boolean isCycle = AdjacencyList[i].findCycle(parentHead, destinationHead, AdjacencyList[i], AdjacencyList[j])
                System.out.println(AdjacencyList[i].findCycle(parentHead, destinationHead, AdjacencyList[i], AdjacencyList[j]));

                System.out.println("\n\n");
            }
            System.out.println("\n\n");
        }
//        
//     LLnode parentHead = pList.getHead();
//        LLnode destinationHead = dList.getHead();
//        
//        
//        
//        
//        findCycle();
//        
//        
//
//        for (int i = 0; i < test.length; i++) {
//            System.out.println(labelsTST[i] + "'s parents are: ");
//
//            for (int j = 0; j < adjacentNodes.length; j++) {
//                if (adjacentNodes[i][j] != 1000) {
//                    System.out.println(labelsTST[adjacentNodes[i][j]]);
//
//                }
//            }
//            System.out.println("   \n\n");
//
//        }
        System.out.println("\n\n\n");
//
//        for (int i = 0; i < test.length; i++) {
//            for (int j = 0; j < test[i].length; j++) {
//                System.out.println("\n");
//
//                System.out.println("Now at edge: " + labelsTST[i] + " " + labelsTST[j]);
//
//                System.out.println("_________________________________");
//                if (findCycle(adjacentNodes, i, j)) {
//
//                    System.out.println("There's a cycle.");
//                } else {
//                    System.out.println("NO CYCLE!!!!!!!!!!!!");
//                }
//            }
//            System.out.println("\n\n\n");
//
//        }

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

//        int[][] Matrix = {
//            // A  B   C    D    E    F    G   H   I
//            // a
//            {INF, 4, INF, INF, INF, INF, INF, 8, INF},
//            // b
//            {4, INF, 8, INF, INF, INF, INF, 11, INF},
//            // c
//            {INF, 8, INF, 7, INF, 4, INF, INF, 2},
//            // d
//            {INF, INF, 7, INF, 9, 14, INF, INF, INF},
//            // e
//            {INF, INF, INF, 9, INF, 10, INF, INF, INF},
//            // f
//            {INF, INF, 4, 14, 10, INF, 2, INF, INF},
//            // g 
//            {INF, INF, INF, INF, INF, 2, INF, 1, 6},
//            // h
//            {8, 11, INF, INF, INF, INF, 1, INF, 7},
//            // i
//            {INF, INF, 2, INF, INF, INF, 6, 7, INF}};
//
//        int[][] parents = new int[Matrix.length][Matrix[0].length];
//
//        for (int i = 0; i < parents.length; i++) {
//            for (int j = 0; j < parents[i].length; j++) {
//                parents[i][j] = 1000;
//
//            }
//
//        }
//        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
//        char[] labels = new char[Matrix.length];
//
//        for (int i = 0; i < Matrix.length; i++) {
//            labels[i] = alphabet[i];
//        }
//
//        for (int i = 0; i < Matrix.length; i++) {
//            for (int j = 0; j < Matrix.length; j++) {
//                if (Matrix[i][j] != INF) {
//                    if (parents[j][i] == 1000) {
//                        parents[j][i] = i;
//                    }
//                }
//
//            }
//
//        }
//
//        for (int i = 0; i < Matrix.length; i++) {
//            System.out.println(labels[i] + "'s parents are: ");
//
//            for (int j = 0; j < parents.length; j++) {
//                if (parents[i][j] != 1000) {
//                    System.out.println(labels[parents[i][j]]);
//
//                }
//            }
//            System.out.println("   \n\n");
//
//        }
//
//        for (int i = 0; i < Matrix.length; i++) {
//            for (int j = 0; j < Matrix[i].length; j++) {
//                System.out.println("\n");
//
//                System.out.println("Now at edge: " + labels[i] + " " + labels[j]);
//
//                System.out.println("_________________________________\nChecking Cycle...");
//                if (findCycle(parents, i, j)) {
//
//                    System.out.println("There's a cycle.");
//                } else {
//                    System.out.println("NO CYCLE!!!!!!!!!!!!");
//                }
//            }
//            System.out.println("\n\n\n");
//
//        }
//        Kruskal(Matrix, INF);
    }

//    public static boolean findCycle(int[][] parents, int parentNode, int destinationNode) {
//
//        // if we've reached the end of the array:
//        //|| (parentNode > parents.length - 1) || (destinationNode > parents.length - 1)
//        // decrement parentNode pointer until reaching parentNode == null
//        if (parentNode - 1 < 0 && !(destinationNode - 1 < 0)) {
//
//            return findCycle(parents, parentNode, destinationNode);
//            //return false;
//
//        }
//
//        if (!(parentNode - 1 < 0) && destinationNode - 1 < 0) {
//
//            return findCycle(parents, parentNode - 1, destinationNode);
//            // return false;
//
//        }
//        if (parentNode - 1 < 0 && destinationNode - 1 < 0) {
//
//            return findCycle(parents, parentNode, destinationNode);
//            // return false;
//
//        } else {
//
//            if (parents[parentNode] == parents[destinationNode] && parentNode != destinationNode) {
//                return true;
//
//            } else {
//                return findCycle(parents, parentNode - 1, destinationNode - 1);
//
//            }
//        }
//
////        if (parentNode < 0 && !(destinationNode < 0)) {
////
////            return findCycle(parents, parentNode + 1, destinationNode);
////            //return false;
////
////        }
////
////        if (!(parentNode < 0) && destinationNode < 0) {
////
////            return findCycle(parents, parentNode, destinationNode + 1);
////            // return false;
////
////        }
////        if (parentNode < 0 && destinationNode < 0) {
////
////            return findCycle(parents, parentNode + 1, destinationNode + 1);
////            // return false;
////
////        } else {
////
////            if (parents[parentNode] == parents[destinationNode] && parentNode != destinationNode) {
////                return true;
////
////            } else {
////                return findCycle(parents, parentNode - 1, destinationNode - 1);
////
////            }
////        }
////    public static void Kruskal(int[][] Matrix, int INF) {
////
////        /*
////         Kruskal’s Algorithm
////        
////        
////         - Description:
////        
////        
////         - Parameters:
////        
////        
////        
////         - Output:
////        
////        
////         */
////        int[] parent = new int[Matrix.length];
////        int min;
////        int parentNode = 0, destinationNode = 0, noOfEdges = 1, total = 0;
////        int[] visited = new int[Matrix[0].length];
////        int[] isParent = new int[Matrix[0].length];
////        char[][] minHeap = new char[Matrix[0].length][2];
////        int[] distances = new int[Matrix[0].length];
////        int[][] children = new int[Matrix.length][Matrix[0].length];
////
////        int[] isConnected = new int[Matrix[0].length];
////
////        int source = 0;
////        for (int i = 0; i < children.length; i++) {
////            for (int j = 0; j < children[i].length; j++) {
////                children[i][j] = 0;
////
////            }
////
////        }
////        for (int i = 0; i < Matrix.length; i++) {
////
////            parent[i] = 0;
////            visited[i] = 0;
////            isParent[i] = 0;
////            isConnected[i] = 0;
////
////        }
////        visited[source] = 1;
////
////        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
////        char[] labels = new char[Matrix.length];
////        ArrayList<Integer> parentNodes = new ArrayList<Integer>();
////
////        for (int i = 0; i < Matrix.length; i++) {
////            labels[i] = alphabet[i];
////        }
////
////        while (noOfEdges < Matrix.length) {
////
////            min = INF;
////
////            for (int i = 0; i < Matrix.length; i++) {
////
////                for (int j = 0; j < Matrix.length; j++) {
////
////                    if (Matrix[i][j] < min && visited[j] != 1) {
////
////                        min = Matrix[i][j];
////                        parentNode = i;
////                        destinationNode = j;
////
////                    }
////
////                }
////
////            }
////
////            // insert edge to edge array
////            // sort edges
////            // print to make sure all edges are inserted:
////            // insert edge into MST:
////            // check for cycles using DFS:
//////            while (parent[u] != 0) {
//////                //   System.out.println("ininite loop!!");
//////               // System.out.println("u = " + labels[u] + "\tparent[u] = " + labels[parent[u]]);
//////
//////                u = parent[u];
//////                // System.out.println("u = "+ u +"\tparent[u] = "+parent[u]);
//////                //parent[u] = 0;
//////            }
//////
//////            while (parent[v] != 0) {
//////                //  System.out.println("infinite loop 2!!!!!");
//////
//////              //  System.out.println("v = " + labels[v] + "\tparent[v] = " + labels[parent[v]]);
//////
//////                v = parent[v];
//////
//////            }
////            // make sure destination is not a parent node:
//////            for (int i = 0; i < parentNodes.length; i++) {
//////                if (parentNodes[i] == destinationNode) {
//////                    parentNodes[i] = v;
//////                    break;
//////                } else {
//////
//////                    noOfEdges++;
//////                    System.out.println("Edge Found: " + labels[u] + "->" + labels[v] + " Min : " + min);
//////                    total += min;
//////                    parent[v] = u;
//////
//////                    visited[v] = 1; //doesn't visit e 
//////
//////            //visited[u] = 1; // doesn't visit c
//////                    // parent[u] = v;
//////                    Matrix[u][v] = INF;
//////                    Matrix[v][u] = INF;
//////                }
//////
//////            }
////// !parentNodes.contains(destinationNode)||
////            //    if (isParent[u] != 1) {
////            noOfEdges++;
////            minHeap[destinationNode][0] = labels[parentNode];
////            minHeap[destinationNode][1] = labels[destinationNode];
////            distances[destinationNode] = min;
////            System.out.println("Edge Found: " + minHeap[destinationNode][0] + "->" + minHeap[destinationNode][1] + " Min : " + distances[destinationNode]);
////            total += min;
////            parent[destinationNode] = parentNode;
////            // parentNodes.add(parent[v]);//            System.out.println("Parent: "+labels[parent[v]]);
////            isParent[parentNode] = 1;
////            visited[destinationNode] = 1;
////
//////            for (int i = 0; i < children[parentNode].length; i++) {
//////                if (children[parentNode][i] == 0) {
//////                    children[parentNode][i] = destinationNode;
//////                    break;
//////                }
//////
//////            }
//////  visited[u] = 1; //doesn't visit e 
////            // }
////            //visited[u] = 1; // doesn't visit c
////            // parent[u] = v;
////            Matrix[parentNode][destinationNode] = INF;
////            Matrix[destinationNode][parentNode] = INF;
////
////        }
////
////        // print children:
////        System.out.println("\n\n\n\n\n");
////
////        for (int parentINDX = 0; parentINDX < children.length; parentINDX++) {
////            System.out.println(labels[parentINDX] + "'s children are: ");
////            for (int i = 0; i < children[parentINDX].length; i++) {
////                if (children[parentINDX][i] != 0) {
////                    System.out.println(labels[children[parentINDX][i]]);
////                }
////
////            }
////            System.out.println("");
////
////        }
////
////        System.out.println("The weight of the minimum spanning tree is " + total);
////    }
////    public static void print(int[][] MST, int[] distances) {
////        for (int i = 0; i < MST.length; i++) {
////            for (int j = 0; j < MST[i].length; j++) {
////                System.out.println("Edge Found: " + MST[i][j] + "->" + MST[i][j] + " Min : " + distances[j]);
////
////            }
////
////        }
////
////    }
////    public static int findParent(int[] parents, int node) {
////        // returns index of parent 
////
////        if (parents[node] != 1000) {
////
////            findParent(parents, node - 1);
////        }
////
////        if (node - 1 < 0) {
////
////            return node;
////
////        }
////        return findParent(parents, node - 1);
////
////    }
////        
////        
////        
////        
////        if (parentNode - 1 < 0) {
////
////            return parentNode;
////
////        }
////        if (destinationNode - 1 < 0) {
////            return destinationNode;
////        } else {
////            findCycle(parents, parentNode - 1, destinationNode - 1);
////
////            if (parents[parentNode] != parents[destinationNode]) {
////                return 0;
////            }
////
////        }
////        return 1;
//    }
}
