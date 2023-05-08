package Inventory;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MotorPHMainInventory {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        DisplayAllStocks display = new DisplayAllStocks();//create object of display
        AddStocks add = new AddStocks();
        SortStocks sort = new SortStocks();
        SearchStocks search = new SearchStocks();
        DeleteStocks deleted = new DeleteStocks();
        
        //add.AddingStocks();
        deleted.DeleteStocks();
        //search.SearchingStocks();
        //sort.SortingStocks();
        //display.printStack();//call function to print stack
        
        
            
            
            
          

    }
}
