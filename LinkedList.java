/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;

/**
 *
 * @author Lenovo-Hanaa
 */
public class LinkedList {

    // declare
    private LLnode head;
    int neighbor;
    int length;

    // create constructor
    public LinkedList() {

        // initialize
        this.head = null;
        this.length = 0;
        this.neighbor = -1;
    }

    // getters + setters
    public LLnode getHead() {
        return head;
    }

    public void setHead(LLnode head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public LLnode getNeighborNot(char x) {
        LLnode hlpptr = this.head;

        while (hlpptr != null && !hlpptr.isChecked()) {

            if (hlpptr.getLabel() == x) {

                hlpptr.setChecked(true);
                hlpptr.getNext();
            } else {
                return hlpptr;
            }

        }
        return null;

    }

    // this method inserts a node and its weight to the list (weighted graph) 
    public void InsertNeighbor(int index, char label) {
        head = InsertNeighbor(head, index, label);
    }

    private LLnode InsertNeighbor(LLnode head, int index, char label) {

        // if the list is empty OR if the node value is less than the head
        // we insert in the beginning
        if (head == null) {
            head = new LLnode(index, label, head);
            return head;
        } else {
            // create a help pointer to traverse down the list

            LLnode helpPtr = head;

            while (helpPtr.getNext() != null) {
                // if the value is less than the node's value, 
                // then exit the while loop because we will insert at the end 

                helpPtr = helpPtr.getNext();
            }
            // create new node and insert it at the end of the list
            LLnode newNode = new LLnode(index, label, helpPtr.getNext());
            helpPtr.setNext(newNode);
        }
        // Return head
        return head;
    }

    public void InsertNeighborNODE(LLnode v) {
        head = InsertNeighborNODE(head, v);
    }

    private LLnode InsertNeighborNODE(LLnode head, LLnode v) {

        // if the list is empty OR if the node value is less than the head
        // we insert in the beginning
        if (head == null) {
            head = new LLnode(v.getIndex(), v.getLabel(), head);
            return head;
        } else {
            // create a help pointer to traverse down the list

            LLnode helpPtr = head;

            while (helpPtr.getNext() != null) {
                // if the value is less than the node's value, 
                // then exit the while loop because we will insert at the end 

                helpPtr = helpPtr.getNext();
            }
            // create new node and insert it at the end of the list
            helpPtr.setNext(v);
        }
        // Return head
        return head;
    }


    // this method prints the list
    public void PrintNeighbors() {
        PrintNeighbors(head);
    }

    private void PrintNeighbors(LLnode head) {

        LLnode helpPtr = head;

        while (helpPtr != null) {
            // print the index of the helpPtr
            System.out.print(helpPtr.getLabel() + " ");
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
        System.out.println("");

    }

    public boolean findCycle(LLnode parent, LLnode destination, LinkedList pList, LinkedList dList) {

        // || parent==null && destination==null
        //
        if (parent == null && destination != null) {
            return false;

        }
        if (parent != null && destination == null) {
            return false;
        }
        if (parent == null && destination == null) {
            return false;
        }

        if (parent == destination) {

            return true;

        }

        LLnode ParentNeighbor = pList.getNeighborNot(destination.getLabel());
        LLnode DestNeighbor = dList.getNeighborNot(parent.getLabel());
        if (ParentNeighbor != null && DestNeighbor != null) {
            if (ParentNeighbor == DestNeighbor) {
                return true;
            }

        }
        return findCycle(parent.getNext(), destination.getNext(), pList, dList);

    }

    // set methods + constructors + everything else:
    private LLnode source;


    public void makeSet(int index, char label) {
        LLnode v = new LLnode(index, label);

        this.source = v;

    }

    public boolean find(LLnode v) {

        LLnode hlpptr = new LLnode();
        hlpptr = this.source;
        while (hlpptr != null) {
            if (hlpptr.getIndex() == v.getIndex()) {
                return true;
            }
            hlpptr = hlpptr.getNext();
        }
        return false;
    }

    public void union(LLnode newNeighbor) {

        LLnode hlpptr = this.source;
        while (hlpptr.getNext() != null) {
            hlpptr = hlpptr.getNext();

        }

        hlpptr.setNext(newNeighbor);

    }

    public LLnode getSource() {
        return source;
    }

    public void setSource(LLnode source) {
        this.source = source;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

}// class
