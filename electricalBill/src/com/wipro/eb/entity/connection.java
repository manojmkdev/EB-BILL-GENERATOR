package com.wipro.eb.entity;

abstract class connection {
    public int getPreviousReading() {
        return previousReading;
    }

    public void setPreviousReading(int previousReading) {
        this.previousReading = previousReading;
    }
    int previousReading;

    public int getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(int currentReading) {
        this.currentReading = currentReading;
    }

    int currentReading;

    public float[] getSlabs() {
        return slabs;
    }

    public void setSlabs(float[] slabs) {
        this.slabs = slabs;
    }

    float[] slabs;
    public connection(int currentReading, int previousReading,float[] slabs){
        this.currentReading=currentReading;
        this.previousReading=previousReading;
        this.slabs=slabs;
    }

    public abstract float computeBill();

}
