package com.wipro.eb.entity;

public class commercial extends connection {
    public commercial(int currentReading, int previousReading,float[] slabs){
       super(currentReading,previousReading,slabs);
    }
    public float computeBill(){
        int unit=currentReading-previousReading;
        float ed;
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

        if(amount<5000){
            ed= amount*0.02f;
        }
        else if(amount>=5000 && amount<10000){
            ed=amount*0.06f;
        }
        else{
            ed=amount*0.09f;
        }

        return amount+ed;
    }
}
