package net.iliabvf.fixedFifoCollection;

import java.util.LinkedList;
import java.util.Scanner;

public class FixedFifoCollection {

    private int maxSize;
    private LinkedList<Integer> intList;

    public FixedFifoCollection() {
        this.maxSize = 16;
        this.intList = new LinkedList<Integer>();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getSize() {
        return this.intList.size();
    }

    public void setSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public LinkedList<Integer> getIntList() {
        return intList;
    }

    public void setIntList(LinkedList<Integer> intList) {
        this.intList = intList;
    }

    public void add(Integer value) {
        if(this.intList.size() < this.maxSize)
            this.intList.add(value);
        else
        {
            this.intList.removeFirst();
            this.intList.add(value);
        }
    }


}
