package com.wipro.eb.main;

import com.wipro.eb.service.connectionService;
import java.util.*;

public class EBmain{
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        System.out.println("===============================================");
        System.out.println(" WELCOME TO TNEB BILL GENERATOR APPLICATION ");
        System.out.println("===============================================");

        System.out.print("Enter your id (example: TN-XXXXXXXX ) : ");

        String customerID = sc.next();

        ArrayList<Integer> num = new ArrayList<>();

        int flag=0;

        for(int i=0 ; i<10 ; i++){
            num.add(i);
        }

        for(int i=3 ; i<customerID.length() ; i++){
            if(!num.contains(Character.getNumericValue(customerID.charAt(i)))){
                flag = 1;
            }
        }


        if((customerID.substring(0,3)).equals("TN-") && customerID.length()==11 && flag==0) {
                System.out.print("Enter the Previous Month Reading :  ");
            int prevRead = sc.nextInt();
                System.out.print("Enter the Current Month Reading :  ");
            int currRead = sc.nextInt();
                System.out.print("Enter the Connection Type :  ");

            String cType = sc.next();

            System.out.println("===============================================");
            System.out.println("                 BILL AMOUNT                   ");
            System.out.println("              -----------------                ");
            System.out.println("CUSTOMER ID : "+customerID);
            System.out.println("TYPE        : "+cType);
            connectionService con = new connectionService();
            System.out.println(con.generateBill(currRead, prevRead, cType));
            System.out.println("===============================================");
        }
        else if(customerID.length() != 11) {
            System.out.println("===============================================");
            System.out.println("CUSTOMER ID LENGTH MUST BE 11  ! PLEASE TRY AGAIN !!");
            System.out.println("===============================================");
        }
        else if(flag==1){
            System.out.println("===============================================");
            System.out.println("LAST EIGHT DIGIT MUST BE NUMBERIC VALUE ! PLEASE TRY AGAIN !!");
            System.out.println("===============================================");
        }
        else{
            System.out.println("===============================================");
            System.out.println("INCORRECT CUSTOMER ID ! PLEASE TRY AGAIN !!");
            System.out.println("===============================================");
        }
    }
}


