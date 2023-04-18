package Inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DeleteStocks {
    String date,label,brand,number,status;
    Queue<DeleteStocks> mainList = new LinkedList<>();
    Queue<DeleteStocks> helperList = new LinkedList<>();
    
    public DeleteStocks(String date, String label, String brand, String number, String status){//constructor 
        this.date=date;
        this.label=label;
        this.brand=brand;
        this.number=number;
        this.status=status;
    }
     public DeleteStocks(){ //to access functions without changing values
    }
   
    public void DeleteStocks() throws FileNotFoundException{
        String[] element=new String[5];//array to save each element from text file
        
        
        File file =new File("Data.txt");
        Scanner scan = new Scanner(file);//scan file content
        Scanner searchscan = new Scanner(System.in); 
        
            int sum = 0;
            while(scan.hasNext()){ //loops on each element per line and assigns it to array element
            for(int i=0;i<5;i++){
               element[i]=scan.next();
               
            }
            //push each line to stack
           mainList.add(new DeleteStocks(element[0],element[1],element[2],element[3],element[4]));
           helperList.add(new DeleteStocks(element[0],element[1],element[2],element[3],element[4]));
           sum+=1;
        }
        
        System.out.println();
        System.out.println("Before Deleting: ");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s","Date Entered","Stock Label",
                "Stock's Brand","Engine Number","Status");//for printing labels of columns
        System.out.println();
        for(int i = 0; i < sum;i++){    
            DeleteStocks beforedelete = helperList.poll();
            System.out.printf("%-15s%-15s%-15s%-15s%-15s",beforedelete.date,beforedelete.label
                ,beforedelete.brand,beforedelete.number,beforedelete.status);//prints each element on top of stack  
            System.out.println();
        }
         System.out.println();
        
        
        System.out.println("Enter Engine Number to be Deleted: ");
        String enterNum = searchscan.nextLine();
        
        System.out.printf("%-15s%-15s%-15s%-15s%-15s","Date Entered","Stock Label",
                "Stock's Brand","Engine Number","Status");//for printing labels of columns
        System.out.println();
        for(int i = 0; i < sum;i++){    
            DeleteStocks main = mainList.poll();
            if(main.number.compareTo(enterNum)!=0){
                helperList.add(main);
                System.out.println();            
                DeleteStocks deleted = helperList.poll(); //assign the top file to diplay object
                System.out.printf("%-15s%-15s%-15s%-15s%-15s",deleted.date,deleted.label
                ,deleted.brand,deleted.number,deleted.status);//prints each element on top of stack  
            }  
        }
        System.out.println();
        System.out.println("Stock with Engine Number "+enterNum+" is deleted.");

    }    
   
}