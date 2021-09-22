import java.util.*;

public class NonMetal extends Element
{
    //CLASSFIELDS
      private char state;
   
    //CONSTRUCTORS
    /*******************************************
 *   *Default Constructor:
 *   *IMPORT: none
 *   *EXPORT: ?
 *   *ASSERTION: The default state of state is 1.0
 *   *******************************************/
    public NonMetal()
    {
        super();
        state = 'D';
    }

    /*******************************************
 *   *Alternative #1 Constructor:
 *   *IMPORT: inAtomicNum (integer), inName (String), inSymbol (String), inMass (double), inState (char)
 *   *EXPORT: ?
 *   *ASSERTION: Creates the object if imports are valid and FAILS otherwise
 *  *******************************************/
    public NonMetal(int inAtomicNum, String inName, String inSymbol, double inMass, char inState)
    {
        super(inAtomicNum, inName, inSymbol, inMass);
        if (validateState(inState))
        {
          state = inState;
        }
        else 
        {
          throw new IllegalArgumentException("Invalid Import Values");
        }
    }

    /*******************************************
 *   *Copy Constructor:
 *   *IMPORT: inNonMetal (NonMetal)
 *   *EXPORT: ?
 *   *ASSERTION: Creates the object with an identical object state as the import
 *  *******************************************/
    public NonMetal(NonMetal inNonMetal)
    {
        super(inNonMetal);
        state = inNonMetal.getState();
    }

    //ACCESSORS
    public char getState()
    {
        return state;
    }

    /*******************************************
 *   *SUBMODULE equals
 *   *IMPORT: inObject (object)
 *   *EXPORT: isEqual
 *   *ASSERTION: NonMetals are interchangeable if they have the same state
 *  *******************************************/
    public boolean equals(Object inObj)
    {
        boolean isEqual = false;
        if (inObj instanceof NonMetal)
        {
          NonMetal inNonMetal = (NonMetal)inObj;
          if (super.equals(inNonMetal))
          {       
           if (state == inNonMetal.getState())
           {
             isEqual = true; 
           }
          }
        }
        return isEqual;
    }

    /*******************************************
 *  *SUBMODULE clone
 *  *IMPORT: none
 *  *EXPORT: cloneNonMetal
 *  *ASSERTION: Returns a cloned object of the current object
 * *******************************************/
    public Object clone()
    {
        NonMetal cloneNonMetal;
        cloneNonMetal = new NonMetal(this);
        return cloneNonMetal;
    }

    /*******************************************
 *   *SUBMODULE toString
 *   *IMPORT: none
 *   *EXPORT: str
 *   *ASSERTION: Outputs it to the string
 *  *******************************************/
    public String toString()
    {
        return (super.toString() + "," + state);
    }

    //MUTATORS
    /*******************************************
*    *SUBMODULE setState
*    *IMPORT: inState (char)
*    *EXPORT: none
*    *ASSERTION: Sets the State if the imports are valid and FAILS otherwise
    *******************************************/
    public void setState(char inState)
    {
        if (validateState(inState))
        {
          state = inState;
        }
        else 
        {
          throw new IllegalArgumentException("Invalid State");
        }
    }

    //PRIVATE SUBMODULES
    /*******************************************
 *   *SUBMODULE validateDiameter
 *   *IMPORT: inDiameter (integer)
 *   *EXPORT: valid (boolean)
 *   *ASSERTION: Checks that the Diameter is above 0
 *   *******************************************/
    public boolean validateState(char inState)
    {
        boolean valid;
        switch(inState)
        { 
          case 'G':
            valid = true;
            break;
          case 'S':
            valid = true;
            break;
          case 'L':
            valid = true;
            break;
          default:
            valid = false;
        } 
        return valid;   
    }

}




