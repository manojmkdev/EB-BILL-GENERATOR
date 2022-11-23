package com.wipro.eb.service;

import com.wipro.eb.exception.InvalidReadingException;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.entity.commercial;
import com.wipro.eb.entity.domestic;

public class connectionService {
    static int R=0,c=0;
    public boolean validate(int currRead, int prevRead, String cType ){
        if(currRead < prevRead || prevRead <= 0){
            R=2;
            try{
                 throw new InvalidReadingException("InvalidReadingException");
            } catch (InvalidReadingException e){
                System.out.println(e);
            }
        }
       if(!cType.equals("Domestic") && !cType.equals("Commercial")){
           c=1;
            try {
                throw new InvalidConnectionException();
            }
            catch (InvalidConnectionException e) {
                System.out.println(e);
            }
        }
        return currRead > prevRead && prevRead >0 && (cType.equals("Domestic") || cType.equals("Commercial"));
    }

    public float calculateBillAmt(int currRead,int prevRead, String cType){
       if(validate(currRead,prevRead,cType)) {
           if(cType.equals("Domestic")){
               float[] slap ={2.3f,4.2f,5.5f};
               domestic dom=new domestic(currRead,prevRead,slap);
               return dom.computeBill();
           }
           else {
               float[] slap ={5.2f,6.8f,8.3f};
               commercial com=new commercial(currRead,prevRead,slap);
               return com.computeBill();
           }
       }
       else{
         if(R==2) return -1f;
         else return -2f;
       }
    }
    public String generateBill(int currentReading, int previousReading, String cType){
       float val=calculateBillAmt(currentReading,previousReading,cType);
       if(val==-1f){
           return "Incorrect Reading";
       }
       else if(val==-2f){
           return "Incorrect Connection Type";
       }
       else {
           return "Final Amount Payable : Rs "+val;
       }
    }
}
