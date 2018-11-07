
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
        int[][] Matrix = {
            {INF, 3, INF, INF, 6, 5},
            {3, INF, 1, INF, INF, 4},
            {INF, 1, INF, 6, INF, 4},
            {INF, INF, 6, INF, 8, 5},
            {6, INF, INF, 8, INF, 2},
            {5, 4, 4, 5, 2, INF}

        };

        Kruskal(Matrix, INF);


        System.out.println("\n\n\n");

    }

    public static void Kruskal(int[][] Matrix, int INF) {

        /*
         Kruskal’s Algorithm
        
        
         - Description:
        
        
         - Parameters:
        
        
        
         - Output:
         */
        ArrayList<Edge> sortedEdges = new ArrayList<>();

        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] labels = new char[Matrix.length];

        int[] added = new int[Matrix.length];

        for (int i = 0; i < Matrix.length; i++) {

            labels[i] = alphabet[i];
            added[i] = 0;

        }
        int[][] visited = new int[Matrix.length][Matrix[0].length];

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                visited[i][j] = 0;

            }
        }

        //"Now adding edges (without sorting)
        //System.out.println("Now adding edges (without sorting)");
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[i].length; j++) {
                if (Matrix[i][j] != INF && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    visited[j][i] = 1;

                    LLnode source = new LLnode(i, labels[i]);
                    LLnode destination = new LLnode(j, labels[j]);
                    Edge edge = new Edge(source, destination, Matrix[i][j]);
                    sortedEdges.add(edge);
                  // System.out.println(edge.getSource().getLabel() + " -> " + edge.getDestination().getLabel() + " with the cost of " + edge.getDistance());

                }

            }
        }
       // System.out.println("\n\n\n\n\n\n\n");
        Collections.sort(sortedEdges, new Comparator<Edge>() {
            @Override
            public int compare(Edge Edge1, Edge Edge2) {
                int edge1 = Edge1.distance;
                int edge2 = Edge2.distance;
                return Integer.valueOf(edge1).compareTo(edge2);

            }
        });

        System.out.println("Now printing sorted edges... \n");
        for (int i = 0; i < sortedEdges.size(); i++) {
            Edge This = sortedEdges.get(i);
            System.out.println(This.getSource().getLabel() + " -> " + This.getDestination().getLabel() + " with the cost of " + This.getDistance());

        }

        // get size of largest edge:
        LinkedList[] MST = new LinkedList[Matrix.length];
        for (int i = 0; i < MST.length; i++) {
            MST[i] = new LinkedList();
        }
//
//        System.out.println("\n\n\nEdges have been sorted. Now creating a new set for each edge: \n");
//        System.out.println("makeSet()");
//        LinkedList[] set = new LinkedList[Matrix.length];
//        for (int i = 0; i < set.length; i++) {
//            set[i] = new LinkedList();
//            set[i].makeSet(i, labels[i]);
//            System.out.println("[" + set[i].getSource().getLabel() + "]");
//        }

        System.out.println("\nKruskal running... Edges connected:");

        int ecounter = 0;
        int k = 0;
        int row = 0;
        int column = 0;
        int totalWeight = 0;
       // LLnode[][] union = new LLnode[Matrix.length - 1][2];

        while (ecounter < Matrix.length - 1) {

            if (k < sortedEdges.size()) {

                LLnode u = sortedEdges.get(k).getSource();
                LLnode v = sortedEdges.get(k).getDestination();
                int uINDX = u.getIndex();
                int vINDX = v.getIndex();
                if (MST[uINDX].isEmpty()) {

                    System.out.println(u.getLabel() + "->" + v.getLabel());

                    MST[uINDX].InsertNeighborNODE(v);
                    MST[vINDX].InsertNeighborNODE(u);
                    added[vINDX] = 1;
                    added[uINDX] = 1;

//
//                // union
//                union[k][0] = u;
//                union[k][1] = v;
//
                    // 
                    totalWeight += sortedEdges.get(k).getDistance();

                } else {
                    if (uINDX < MST.length && vINDX < MST.length) {

                        LinkedList uList = MST[uINDX];
                        LinkedList vList = MST[vINDX];
                        boolean theresACycle = MST[0].findCycle(u, v, uList, vList);

                        if (theresACycle) {
                            row = +1;
                            column = +1;
                            k += 1;
                            continue;

                        } else {

/// if next edge nodes have been visited
// but there is at least one node from the next + 1 edge that has not been visited
// and does not create a cycle,
// then choose the next +1 edge in the next iteration
                            boolean current_u_is_visited = added[uINDX] == 1;
                            boolean current_v_is_visited = added[vINDX] == 1;

                            int nextINDX = k + 1;

                            LLnode nextINDX_u = sortedEdges.get(nextINDX).getSource();
                            LLnode nextINDX_v = sortedEdges.get(nextINDX).getDestination();

                            boolean next_u_is_Visited = added[nextINDX_u.getIndex()] == 1;
                            boolean next_v_is_Visited = added[nextINDX_v.getIndex()] == 1;


                            if ((current_u_is_visited || current_v_is_visited) && (!next_u_is_Visited || !next_v_is_Visited)) //       
                            {

                                row = +1;
                                column = +1;
                                k += 1;
                                continue;
                            }

                            if (added[Matrix.length - 1] != 1) {
                                added[vINDX] = 1;
                                added[uINDX] = 1;

                                MST[uINDX].InsertNeighborNODE(v);
                                MST[vINDX].InsertNeighborNODE(u);


                                totalWeight += sortedEdges.get(k).getDistance();

                            }

                            int afterNXTINDX = nextINDX + 1;

                            if (sortedEdges.get(afterNXTINDX).getSource().getIndex() < added.length) {

                                LLnode afterNXTINDX_u = sortedEdges.get(afterNXTINDX).getSource();
                                LLnode afterNXTINDX_v = sortedEdges.get(afterNXTINDX).getDestination();

                                boolean after_next_u_is_Visited = added[afterNXTINDX_u.getIndex()] == 1;
                                boolean after_next_v_is_Visited = added[afterNXTINDX_v.getIndex()] == 1;
  if ((next_u_is_Visited || next_v_is_Visited) && (!after_next_u_is_Visited || !after_next_v_is_Visited)) //                                if (== 1 && added[afterNXTINDX] == 0) {
                             
                                {
                                    row = +2;
                                    column = +2;
                                    k += 2;
                                    continue;

                                }
                            }
                                added[vINDX] = 1;
                                added[uINDX] = 1;

                                MST[uINDX].InsertNeighborNODE(v);
                                MST[vINDX].InsertNeighborNODE(u);

                                System.out.println(u.getLabel() + "->" + v.getLabel());

                                totalWeight += sortedEdges.get(k).getDistance();


                        }

                    }

                }

            }

            ecounter += 1;
            row = +1;
            column = +1;
            k += 1;

        }

        System.out.println("Final MST: \n\n");
        for (int i = 0; i < MST.length; i++) {
            System.out.print(labels[i] + "-> ");
            MST[i].PrintNeighbors();
            System.out.println("\n\n\n\n");
        }
        System.out.println("Total weight = " + totalWeight);

}}
