package com.wipro.eb.entity;

public class domestic extends connection{
    public domestic(int currentReading, int previousReading,float[] slabs){
        super(currentReading, previousReading,slabs);
    }
    public float computeBill(){
        int unit=currentReading-previousReading;
        float amount=0;
        if(unit<=50){
            amount=amount+(unit*slabs[0]);
        }
        else if(unit<=100){
               amount=amount+(50*slabs[0])+((unit-50)*slabs[1]);
        }
        else {
            amount=amount+(50*slabs[0])+(50*slabs[1])+((unit-100)*slabs[2]);
        }
        return amount;
    }
}




