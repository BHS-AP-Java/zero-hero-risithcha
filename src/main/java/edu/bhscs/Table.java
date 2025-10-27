package edu.bhscs;

public class Table {
    private int legs;
    private int size;

    public Table(int legs, int size) {
        this.legs = legs;
        this.size = size;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Table with " + legs + " legs and size " + size;
    }
}