package Inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class DisplayAllStocks {
   
	String date,label,brand,number,status;
    
    public DisplayAllStocks(String date,String label, String brand, String number, String status){//constructor 
        this.date=date;
        this.label=label;
        this.brand=brand;
        this.number=number;
        this.status=status;
    } 
     public DisplayAllStocks(){ //to access functions without changing values
    }
    
    public void printStack() throws FileNotFoundException{
        Stack<DisplayAllStocks> stackDisplay = new Stack<>();//create a stack
        String[] element=new String[5];//array to save each element from text file

        File file =new File("Products.txt");
        Scanner scan = new Scanner(file);//scan file content

       
        while(scan.hasNext()){ //loops on each element per line and assigns it to array element
            for(int i=0;i<5;i++){
               element[i]=scan.next(); 
            }
            //push each line to stack
            stackDisplay.push(new DisplayAllStocks(element[0],element[1],element[2],element[3],element[4])); 
        }
        System.out.printf("%-15s%-15s%-15s%-15s%-15s","Date Entered","Stock Label",
                "Stock's Brand","Engine Number","Status");//for printing labels of columns
        System.out.println();
        while(!stackDisplay.isEmpty()){//sum is used to know how many lines to read and pop
            DisplayAllStocks display = stackDisplay.peek(); //assign the top file to display object
            System.out.printf("%-15s%-15s%-15s%-15s%-15s",display.date,display.label
                    ,display.brand,display.number,display.status);//prints each element on top of stack
            stackDisplay.pop();//removes the current top stock to access elements at the bottom
            System.out.println();
        }
        scan.close();
    }
}