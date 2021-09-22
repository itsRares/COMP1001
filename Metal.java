import java.util.*;

public class Metal extends Element
{
    //CLASSFIELDS
      private double conductivity;

    //CONSTRUCTORS
    /*****************************************
 *   *Default Constructor:
 *   *IMPORT: none
 *   *EXPORT: ?
 *   *ASSERTION: The default state of conductivity is 1.0
 *  *****************************************/
    public Metal()
    {
        super();
        conductivity = 1.0;
    }

    /*****************************************
 *   *Alternative #1 Constructor:
 *   *IMPORT: inAtomicNum (integer), inName (String), inSymbol (String), inMass (double), inConduct (double)
 *   *EXPORT: ?
 *   *ASSERTION: Creates the object if imports are valid and FAILS otherwise
 *  *****************************************/
    public Metal(int inAtomicNum, String inName, String inSymbol, double inMass, double inConduct)
    {
        super(inAtomicNum, inName, inSymbol, inMass);
        if (validateConduct(inConduct))
        {
          conductivity = inConduct;
        }
        else 
        {
          throw new IllegalArgumentException("Invalid Import Values");
        }
    }

    /*****************************************
 *   *Copy Constructor:
 *   *IMPORT: inMetal (Metal)
 *   *EXPORT: ?
 *   *ASSERTION: Creates the object with an identical object state as the import
 *  *****************************************/
    public Metal(Metal inMetal)
    {
        super(inMetal);
        conductivity = inMetal.getConduct();
    }

    //ACCESSORS
    public double getConduct()
    {
        return conductivity;
    }

    /******************************************
 *   *SUBMODULE equals
 *   *IMPORT: inObject (object)
 *   *EXPORT: isEqual
 *   *ASSERTION: Metals are interchangeable if they have the same conductivity
 *  *****************************************/
    public boolean equals(Object inObj)
    {
        boolean isEqual = false;
        if (inObj instanceof Metal)
        {
          Metal inMetal = (Metal)inObj;
          if (super.equals(inMetal))
          {
            if(conductivity == inMetal.getConduct())
            {
              isEqual = true;
            }
          }
        }
        return isEqual;
    }

    /*****************************************
 *   *SUBMODULE clone
 *   *IMPORT: none
 *   *EXPORT: cloneMetal
 *   *ASSERTION: Returns a cloned object of the current object
 *  *****************************************/
    public Object clone()
    {
        Metal cloneMetal;
        cloneMetal = new Metal(this);
        return cloneMetal;
    }

    /*****************************************
 *   *SUBMODULE toString
 *   *IMPORT: none
 *   *EXPORT: str
 *   *ASSERTION: Outputs it to the string
 *  *****************************************/
    public String toString()
    {
        return (super.toString() + "," + conductivity);
    }

    //MUTATORS
    /******************************************
 *   *SUBMODULE setConduct
 *   *IMPORT: inConduct (double)
 *   *EXPORT: none
 *   *ASSERTION: Sets the conductivity if the imports are valid and FAILS otherwise
 *  *****************************************/
    public void setConduct(double inConduct)
    {
        if (validateConduct(inConduct))
        {
          conductivity = inConduct;
        }
        else 
        {
          throw new IllegalArgumentException("Invalid Conductivity");
        }
    }

    //PRIVATE SUBMODULES
    /*****************************************
 *   *SUBMODULE validateConduct
 *   *IMPORT: inConduct (double)
 *   *EXPORT: valid (boolean)
 *   *ASSERTION: Checks that the conductivity is above 0
 *  *****************************************/
    public boolean validateConduct(double inConduct)
    {
        return (inConduct > 0);
    }

}

