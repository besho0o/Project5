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
public class LLnode {

    // declare 
    private int index;
    private char label;
    private int weight;
    private LLnode next;
    private int order;
    private boolean checked = false;

    // create constructors:
    // empty constructor:
    public LLnode() {
        // initialize
        index = 0;
        weight = -1;
        next = null;
        checked = false;
    }

    // create constructor for weighted nodes
    public LLnode(int index, char label, LLnode next) {
        // initialize
        this.index = index;
        this.next = next;
        this.label = label;
        checked = false;
    }

    // create constructor for weighted nodes
    public LLnode(int index, char label, int weight, LLnode next) {
        // initialize
        this.index = index;
        this.weight = weight;
        this.next = next;
        this.label = label;
        checked = false;
    }

    // getters + setters:
    public int getIndex() {
        return index;
    }

    public LLnode getNext() {
        return next;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setNext(LLnode next) {
        this.next = next;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isNull() {
        return this.index == 0;
    }

}// class 
