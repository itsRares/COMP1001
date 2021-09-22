import java.util.*;
import java.io.*;

public class PeriodicTable {
    
    //CONSTANTS
    public static final int MAX_ELEMENTS = 100;
    
    //CLASSFIELDS
    private Element[] box = new Element[MAX_ELEMENTS];
    private int count;
    private String fileName;

    //CONSTRUCTORS
    /*****************************************
 *  *Default Constructor:
 *  *IMPORT: none
 *  *EXPORT: ?
 *  *ASSERTION: Defaults of count, box and fileName are set
 *  *****************************************/
    public PeriodicTable() 
    {
        count = 0;
        box = new Element[MAX_ELEMENTS];
        fileName = new String();
    }

    /*****************************************
 *  *Alternative #1 Constructor:
 *  *IMPORT: inFileName (String)
 *  *EXPORT: ?
 *  *ASSERTION: Creates the object if imports are valid and FAILS otherwise
 *  *****************************************/
    public PeriodicTable(String inFileName) 
    {
        count = 0;
        box = new Element[MAX_ELEMENTS];
        fileName = inFileName;
    }

    /*****************************************
 *  *Copy Constructor:
 *  *IMPORT: inTable(Element) 
 *  *EXPORT: ?
 *  *ASSERTION: Creates the object with an identical object state as the import
 *  *****************************************/    
    public PeriodicTable(PeriodicTable inTable)
    { 
        count = inTable.getCount();
        box = inTable.getTable();
        fileName = inTable.getFile();
    }

    //ACCESSOR
    public int getCount()
    {
        return count;
    }

    public Element[] getTable()
    {
        return box;
    }

    public String getFile()
    {
        return fileName;
    }

    /*****************************************
 *  *SUBMODULE equals:
 *  *IMPORT: inObject (object)
 *  *EXPORT: ?
 *  *ASSERTION: Elements are equal if they have the same obj
 *  *****************************************/
    public boolean equals(Object inObj)
    {
        boolean isEqual = false;
        if(inObj instanceof PeriodicTable)
        {
          PeriodicTable inBox = (PeriodicTable)inObj;
          if(count == inBox.getCount())
          {
            isEqual = true;
          }   
        }
        return isEqual;
    }

    /*****************************************
 *  *SUBMODULE clone:
 *  *IMPORT: none
 *  *EXPORT: cloneTable
 *  *ASSERTION: Creates a clone of the periodic table 
 *  *****************************************/
    public PeriodicTable clone()
    {
        PeriodicTable cloneTable;
        cloneTable = new PeriodicTable();
        return cloneTable;
    }    

    /*****************************************
 *  *SUBMODULE toString:
 *  *IMPORT: none
 *  *EXPORT: str
 *  *ASSERTION: Outputs it to the String
 *  *****************************************/
    @Override
    public String toString()
    {
        String str = "Here are all the Elements:\n";
        if(count != 0) 
        {
          for(int x=0;x<count;x++)
          {
            str += box[x] + "\n";
          }
        } 
        else 
        {
          return "No Elements found!";
        }
        return str;
    }

    //Mutators
    /*****************************************
 *  *SUBMODULE setCount:
 *  *IMPORT: inCount
 *  *EXPORT: none
 *  *ASSERTION: Sets the count if the imports are valid and FAILS otherwise
 *  *****************************************/
    public void setCount(int inCount)
    {
        if (inCount > 0)
        {
          count = inCount;
        }
        else 
        {
          throw new IllegalArgumentException("Invalid number: Must be above 0");
        }
    }

    /*****************************************
 *  *SUBMODULE setFile:
 *  *IMPORT: inFile
 *  *EXPORT: none
 *  *ASSERTION: Sets the fileName if the imports are valid and FAILS otherwise
 *  *****************************************/
    public void setFile(String inFile)
    {
        if (inFile != null)
        {
          fileName = inFile;
        }
        else
        {
          throw new IllegalArgumentException("Invalid filename, please try again!");
        }
    }

    /*****************************************
 *  *SUBMODULE addShape:
 *  *IMPORT: obj (Element)
 *  *EXPORT: none
 *  *ASSERTION: Adds the element to the array, if the array is full then an error displayed
 *  *****************************************/
    public void addElement(Element obj)
    {
        if(count < box.length)
        {
            box[count] = obj;
            System.out.println(box[count] + " added!");
            count++;
        }
        else
        {
            System.out.println("Error: Element Array is full!");
        }
    }

}
