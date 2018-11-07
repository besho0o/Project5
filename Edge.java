/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;

/**
 *
 * @author maha
 */
public class Edge {
//
//    int srcINDX, desINDX;
//    char srcLBL, desLBL;
    int distance;
    
    
    LLnode source;
    LLnode destination; 
    

    public Edge( LLnode source, LLnode destination, int distance) {
        this.distance = distance;
        this.source = source;
        this.destination = destination;
    }

    public LLnode getSource() {
        return source;
    }

    public void setSource(LLnode source) {
        this.source = source;
    }

    public LLnode getDestination() {
        return destination;
    }

    public void setDestination(LLnode destination) {
        this.destination = destination;
    }

    public Edge() {
    }
    
    
    



//    public int getSrcINDX() {
//        return srcINDX;
//    }
//
//    public void setSrcINDX(int srcINDX) {
//        this.srcINDX = srcINDX;
//    }
//
//    public int getDesINDX() {
//        return desINDX;
//    }
//
//    public void setDesINDX(int desINDX) {
//        this.desINDX = desINDX;
//    }
//
//    public char getSrcLBL() {
//        return srcLBL;
//    }
//
//    public void setSrcLBL(char srcLBL) {
//        this.srcLBL = srcLBL;
//    }
//
//    public char getDesLBL() {
//        return desLBL;
//    }
//
//    public void setDesLBL(char desLBL) {
//        this.desLBL = desLBL;
//    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
