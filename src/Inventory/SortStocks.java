package Inventory;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.String.format;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class SortStocks {
    String date,label,brand,number,status;
    LinkedList<SortStocks> sortList = new LinkedList<>();
    
    public SortStocks(String date, String label, String brand, String number, String status){//constructor 
        this.date=date;
        this.label=label;
        this.brand=brand;
        this.number=number;
        this.status=status;
    }
     public SortStocks(){ //to access functions without changing values
    }
    @Override
    public String toString(){

            // Returning attributes of Student
            return format("%-15s%-15s%-15s%-15s%-15s",this.date,this.label
                ,this.brand,this.number,this.status);
    }
    class Sortbybrand implements Comparator<SortStocks> {

	// Method
	// Sorting in ascending order of name
        @Override
	public int compare(SortStocks a, SortStocks b)
	{

		return a.brand.compareTo(b.brand);
	}
    }
    public void SortingStocks() throws FileNotFoundException{
        String[] element=new String[5];//array to save each element from text file

        File file =new File("Prodicts.txt");
        Scanner scan = new Scanner(file);//scan file content

        while(scan.hasNext()){ //loops on each element per line and assigns it to array element

            for(int i=0;i<5;i++){
               element[i]=scan.next(); 
            }
            //push each line to stack
            sortList.add(new SortStocks(element[0],element[1],element[2],element[3],element[4]));
        }
        
        System.out.println("Unsorted");
        for (int i = 0; i < sortList.size(); i++)
                System.out.println(sortList.get(i));
        
        Collections.sort(sortList, new Sortbybrand());

        // Display message on console for better readability
        System.out.println("\nSorted by brand");

        // // Again iterating over entries to print them
        for (int i = 0; i < sortList.size(); i++)
                System.out.println(sortList.get(i));
                
    }           

}