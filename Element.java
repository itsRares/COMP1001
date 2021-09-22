import java.util.*;

public abstract class Element
{
    //CLASSFIELDS
      private String name, symbol;
      private double mass;
      private int atomicNum;

    //CONSTRUCTORS
    /*****************************************
 *   *Default Constructor:
 *   *IMPORT: none
 *   *EXPORT: ?
 *   *ASSERTION: Defaults are set for each value
 *  *****************************************/
    public Element()
    {
        atomicNum = 0; 
        name = new String();
        symbol = "NE";
        mass = 0;        
    }

    /*****************************************
 *   *Alternative #1 Constructor:
 *   *IMPORT: inAtomicNum (integer), inName (String), inSymbol (String), inMass (double)
 *   *EXPORT: ?
 *   *ASSERTION: Creates the object if imports are valid and FAILS otherwise
 *  *****************************************/
    public Element(int inAtomicNum, String inName, String inSymbol, double inMass)
    {
        if ((validateAN(inAtomicNum)) && (validateSymbol(inSymbol)) && (validateMass(inMass)))
          {
            atomicNum = inAtomicNum; 
            name = new String(inName);   
            symbol = new String(inSymbol);   
            mass = inMass; 
          }
          else 
          {
            throw new IllegalArgumentException("Invalid Import Values");
        }
    }

    /*****************************************
 *   *Copy Constructor:
 *   *IMPORT: inElement (Element)
 *   *EXPORT: ?
 *   *ASSERTION: Creates the object with an identical object state as the import
 *  *****************************************/
    public Element(Element inElement)
    {
        atomicNum = inElement.getAN(); 
        name = inElement.getName();
        symbol = inElement.getSymbol(); 
        mass = inElement.getMass();
    }

    //ACCESSORS
    public int getAN()
    {
        return atomicNum;
    }

    public String getName()
    {
        return name;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public double getMass()
    {
        return mass;
    }

    /*****************************************
 *   *SUBMODULE equals (object)
 *   *IMPORT: inShape (ShapeClass)
 *   *EXPORT: isEqual
 *   *ASSERTION: Triangles are interchangeable if they have the same base and height
 *  *****************************************/
    public boolean equals(Object inObj)
    {
        boolean isEqual = false;
        Element inElement = (Element)inObj;
        if (inObj instanceof Element)
        {
          if (atomicNum == inElement.getAN())
          {
            if (name.equals(inElement.getName()))
            {
              if (symbol.equals(inElement.getSymbol()))
              {
                if (mass == inElement.getMass())
                {
                  isEqual = true;
                }
              }
            }
          }
        }
        return isEqual;
    }

    /*****************************************
 *   *SUBMODULE toString
 *   *IMPORT: none
 *   *EXPORT: str
 *   *ASSERTION: Outputs it to the string
 *  *****************************************/
    public String toString()
    {
        return (symbol + "," + name + "," + atomicNum + "," + mass);
    }

    //MUTATORS
    /*****************************************
 *   *SUBMODULE setAN
 *   *IMPORT: inAN (integer)
 *   *EXPORT: none
 *   *ASSERTION: Sets the atomicNum if the imports are valid and FAILS otherwise
 *  *****************************************/
    public void setAN(int inAN)
    {
        if (validateAN(inAN))
        {
          atomicNum = inAN;
        }
        else 
        {
          throw new IllegalArgumentException("Invalid AtomicNum");
        }
    }

    /*****************************************
 *   *SUBMODULE setName
 *   *IMPORT: inName (String)
 *   *EXPORT: none
 *   *ASSERTION: Sets the Name if the imports are valid and FAILS otherwise
 *  *****************************************/
    public void setName(String inName)
    {
        name = inName;
    }

    /*****************************************
 *   *SUBMODULE setSymbol
 *   *IMPORT: inSymbol (String)
 *   *EXPORT: none
 *   *ASSERTION: Sets the symbol if the imports are valid and FAILS otherwise
 *  *****************************************/
    public void setSymbol(String inSymbol)
    {
        if (validateSymbol(inSymbol))
        {
          symbol = inSymbol;
        }
        else
        {
          throw new IllegalArgumentException("Invalid symbol");
        }
    }

    /*****************************************
 *   *SUBMODULE setMass
 *   *IMPORT: inMass (double)
 *   *EXPORT: none
 *   *ASSERTION: Sets the mass if the imports are valid and FAILS otherwise
 *   *****************************************/
    public void setMass(double inMass)
    {
        if (validateMass(inMass))
        {
          mass = inMass;
        }
        else
        {
          throw new IllegalArgumentException("Invalid Mass");
        }
    }

    //PRIVATE SUBMODULES
    /*****************************************
 *   *SUBMODULE validateAN
 *   *IMPORT: inAtomicNum (int)
 *   *EXPORT: valid (boolean)
 *   *ASSERTION: Checks that the atomicNum is greater than 0 and less than 101
 *  *****************************************/
    public boolean validateAN(int inAtomicNum)
    {
        boolean valid;
        if ((inAtomicNum > 0) && (inAtomicNum < 101))
        {
          valid = true;
        }
        else
        {
          valid = false;
        }
        return valid;
    }

    /*****************************************
 *   *SUBMODULE validateSymbol
 *   *IMPORT: inSymbol (String)
 *   *EXPORT: valid (Boolean)
 *   *ASSERTION: Checks that the symbol has no longer than 2 characters
 *  *****************************************/
    public boolean validateSymbol(String inSymbol)
    {
        boolean valid;
        if (inSymbol.length() <= 2)
        {
          valid = true;
        }
        else
        {
          valid = false;
        }
        return valid;
    }

    /*****************************************
 *   *SUBMODULE validateMass
 *   *IMPORT: inMass (double)
 *   *EXPORT: valid (Boolean)
 *   *ASSERTION: Checks that the mass is greater than 0.00
 *  *****************************************/
    public boolean validateMass(double inMass)
    {
        boolean valid;
        if (inMass >= 0)
        {
          valid = true;
        }
        else
        {
          valid = false;
        }
        return valid;
    }

}


