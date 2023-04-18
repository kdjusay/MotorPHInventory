package Inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class AddStocks {
String date,label,brand,number,status;
    
    Queue<AddStocks> StocksQueue = new LinkedList<>();
    Queue<AddStocks> helperStocksQueue = new LinkedList<>();
    
    public AddStocks(String date, String label, String brand, String number, String status){//constructor 
        this.date=date;
        this.label=label;
        this.brand=brand;
        this.number=number;
        this.status=status;
    }
     public AddStocks(){ //to access functions without changing values
    }
    public void AddingStocks() throws FileNotFoundException{
        
        String[] element=new String[5];//array to save each element from text file
        File file =new File("Data.txt");
        Scanner scan = new Scanner(file);//scan file content
        
        
        while(scan.hasNext()){ //loops on each element per line and assigns it to array element
            
            for(int i=0;i<5;i++){
               element[i]=scan.next(); 
            }
            //push each line to stack
            StocksQueue.add(new AddStocks(element[0],element[1],element[2],element[3],element[4]));
            helperStocksQueue.add(new AddStocks(element[0],element[1],element[2],element[3],element[4]));
            
        }
        System.out.println("Before Adding: ");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s","Date Entered","Stock Label",
                "Stock's Brand","Engine Number","Status");//for printing labels of columns
        System.out.println();
        while(!helperStocksQueue.isEmpty()){
            AddStocks oldStocks = helperStocksQueue.poll();
            System.out.printf("%-15s%-15s%-15s%-15s%-15s",oldStocks.date,oldStocks.label
                ,oldStocks.brand,oldStocks.number,oldStocks.status);
            System.out.println();
        }
        
        
        Scanner inputscan = new Scanner(System.in);
        Scanner newinputscan = new Scanner(System.in);
        
        System.out.println("====================================================================\n"+
                                                  "Adding New Stock\n");
        
        
        boolean loop = false;
        
        while(!loop){ //loops on each element per line and assigns it to array element
            
           System.out.println("Enter Date: ");
           element[0]=inputscan.nextLine();
           System.out.println("Enter Stock Label: ");
           element[1]=inputscan.nextLine();
           System.out.println("Enter Stock Brand: ");
           element[2]=inputscan.nextLine();
           System.out.println("Enter Stock Engine Number: ");
           element[3]=inputscan.nextLine();
           System.out.println("Enter Stock Purchase Status: ");
           element[4]=inputscan.nextLine();
            
            //push each line to stack
            StocksQueue.add(new AddStocks(element[0],element[1],element[2],element[3],element[4]));
            
            
            System.out.println("Continue adding stocks? If Yes Enter 1 if No Enter 0: ");
            
            int c = newinputscan.nextInt();
            if(c==0){
                loop= true;
            }
           
        }
        
        
        System.out.println("After Adding Stocks: ");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s","Date Entered","Stock Label",
                "Stock's Brand","Engine Number","Status");//for printing labels of columns
        
        while(!StocksQueue.isEmpty()){
            AddStocks addedStocks = StocksQueue.poll();
            System.out.printf("%-15s%-15s%-15s%-15s%-15s",addedStocks.date,addedStocks.label
                ,addedStocks.brand,addedStocks.number,addedStocks.status);
            System.out.println();
 
        }
        
        System.out.println();
        System.out.println("The Stock is added");
        
        
    }
  
   
}