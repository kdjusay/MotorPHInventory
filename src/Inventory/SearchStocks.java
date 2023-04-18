package Inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SearchStocks {
    
	String date,label,brand,number,status;
    Queue<SearchStocks> searchList = new LinkedList<>();
    
    public SearchStocks(String date, String label, String brand, String number, String status){//constructor 
        this.date=date;
        this.label=label;
        this.brand=brand;
        this.number=number;
        this.status=status;
    }
     public SearchStocks(){ //to access functions without changing values
    }
   
    public void SearchingStocks() throws FileNotFoundException{
        String[] element=new String[5];//array to save each element from text file

        File file =new File("Products.txt");
        Scanner scan = new Scanner(file);//scan file content
        Scanner searchscan = new Scanner(System.in); 

        while(scan.hasNext()){ //loops on each element per line and assigns it to array element
            for(int i=0;i<5;i++){
               element[i]=scan.next();
               
            }
            //push each line to stack
            searchList.add(new SearchStocks(element[0],element[1],element[2],element[3],element[4]));
        }
        
        System.out.println("Enter Engine Number to Search: ");
        String enterNum = searchscan.nextLine();
        
        System.out.println();
        while(!searchList.isEmpty()){   
            SearchStocks search = searchList.poll();
            
            if(search.number.equals(enterNum)){
                
                System.out.println("Details of stock with Engine Number "+enterNum+":\n");
                System.out.println("Date Entered: "+search.date);
                System.out.println("Stock Label: "+search.label);
                System.out.println("Stock's Brand: "+search.brand);
                System.out.println("Stock's Engine Number: "+search.number);
                System.out.println("Purchase Status: "+search.status);
                break;
            } 
            
        }
        if(searchList.isEmpty()){
            System.out.println("Stock is not found.");
        }
        
    }
    
}