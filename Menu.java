import java.util.*;
import java.io.*;

public class Menu {

    /*******************************************
 *  *SUBMODULE run
 *  *IMPORT: 
 *  *EXPORT: none
 *  *ASSERTION: The menu for the periodicTable
 *  ******************************************/
    public static void run() {
        Scanner sc = new Scanner( System.in );
        String choice;
        PeriodicTable table = new PeriodicTable();
        boolean run = true;
        while(run) {
        System.out.println("----------------------------------------\nWelcome to the Periodic Table!\n----------------------------------------");
        System.out.println("Select an option:");
        System.out.println("1. Display all Elements");
        System.out.println("2. Add a Element");
        System.out.println("3. Read in File");
        System.out.println("4. Write to File");
        System.out.println("5. Exit\n----------------------------------");
        System.out.print("Your Choice: ");
        choice = sc.nextLine();
          switch(choice)
          {
            case "1":
              System.out.println("----------------------------------");
              System.out.println(table);
              break;
            case "2":
              System.out.println("----------------------------------\nPlease Element type you would like you add:\n(N for NonMetal and M for Metal)");
              System.out.print("Your Choice: ");
              String type = sc.nextLine();
              elementType(type, table);
              break;
            case "3":
              System.out.println("----------------------------------\nPlease input a file you would like");
              fileCalc(table);
              break;
            case "4":
              System.out.println("----------------------------------\nPlease input the following:\n(N for NonMetal and M for Metal)");
              System.out.print("Your Choice: ");
              writeCalc();
              break;
            case "5":
              System.out.println("----------------------------------\nThanks for using Periodic Table! Goodbye o/");
              run = false;
              break;
            default:
              System.out.println("----------------------------------\nError: Please input 1,2,3,4 or 5");
          }
        }
    }

    /*******************************************
 *   *SUBMODULE elementType
 *   *IMPORT: type (String), table (PeriodicTable)
 *   *EXPORT: none
 *   *ASSERTION: Calculates the elementType, gets user to input details
 *  ******************************************/
    public static void elementType(String type, PeriodicTable table)
    {
        int atomicNum;
        double mass, conductivity;
        String name, symbol;
        char state;
        Scanner sc = new Scanner( System.in );
        switch(type)
        {
          case "N":
            System.out.println("----------------------------------\nInput a Symbol:");
            symbol = sc.nextLine();
            System.out.println("Input a Name:");
            name = sc.nextLine();
            System.out.println("Input a Atomic Number:");
            atomicNum = sc.nextInt();
            System.out.println("Input a Mass:");
            mass = sc.nextDouble();
            System.out.println("Input a State:\n(G for gas, S for solid and L for liquid)");
            sc.nextLine();
            state = sc.next().charAt(0);
            NonMetal nonMetal = new NonMetal(atomicNum, name, symbol, mass, state);
            table.addElement(nonMetal);
            break;
          case "M":
            System.out.println("----------------------------------\nInput a Symbol:");
            symbol = sc.nextLine();
            System.out.println("Input a Name:");
            name = sc.nextLine();
            System.out.println("Input a Atomic Number:");
            atomicNum = sc.nextInt();
            System.out.println("Input a Mass:");
            mass = sc.nextDouble();
            System.out.println("Input a Conductivity:");
            conductivity = sc.nextDouble();
            Metal metal = new Metal(atomicNum, name, symbol, mass, conductivity);
            table.addElement(metal);
            break;
          default:
            System.out.println("----------------------------------\nError: Please input N or M");
        }      
    }

    /*******************************************
 *   *SUBMODULE fileCalc
 *   *IMPORT: table (PeriodicTable)
 *   *EXPORT: none
 *   *ASSERTION: Opens file, reads it and calculates array
 *  ******************************************/
    public static void fileCalc(PeriodicTable table)
    {
       Scanner sc = new Scanner(System.in);
       String fileName;
       System.out.print("File: ");
       fileName = sc.nextLine();
       int lines = getNumLines(fileName);
       int[] arrayAN = new int[lines];
       String[] arrayName = new String[lines];
       String[] arraySymbol = new String[lines];
       double[] arrayMass = new double[lines];
       double[] arrayConduct = new double[lines];
       char[] arrayState = new char[lines];
       readFile(arrayAN, arrayName, arraySymbol, arrayMass, arrayConduct, arrayState, fileName);
       showArea(arrayAN, arrayName, arraySymbol, arrayMass, arrayConduct, arrayState, table);
    }

    /*******************************************
 *   *SUBMODULE getNumLines
 *   *IMPORT: fileName
 *   *EXPORT: numLine
 *   *ASSERTION: Open the file and get the number of lines
 *   ******************************************/
    public static int getNumLines(String fileName)
    {
        Scanner sc = new Scanner(System.in);
        FileInputStream fileStrm = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum = 0;
        String line;

        //try catch block which detects any errors and outputs them
        try
        {
          fileStrm = new FileInputStream(fileName);
          rdr = new InputStreamReader(fileStrm);
          bufRdr = new BufferedReader(rdr);

          line = bufRdr.readLine();
          while (line != null) {
            lineNum++;
            line = bufRdr.readLine();
          }
          fileStrm.close();
         }
         catch (IOException e)
         {
           if (fileStrm != null)
           {
             try
             {
               fileStrm.close();
             }
             catch (IOException ex2){ }
           }
           System.out.println("Error in file processing: " + e.getMessage());
         }
         return lineNum;
     }

    /*******************************************
 *   *SUBMODULE readFile
 *   *IMPORT: arrayAN (integer), arrayName (String), arraySymbol (String), arrayMass (real), arrayConduct (real), arrayState (char), fileName (String)
 *   *EXPORT: none
 *   *ASSERTION: Open and read the file by every line
 *  ******************************************/
    public static void readFile(int[] arrayAN, String[] arrayName, String[] arraySymbol, double[] arrayMass, double[] arrayConduct, char[] arrayState, String fileName)
    {
        Scanner sc = new Scanner(System.in);
        FileInputStream fileStrm = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line;

        //try catch block which detects any errors and outputs them
        try
        {
          fileStrm = new FileInputStream(fileName);
          rdr = new InputStreamReader(fileStrm);
          bufRdr = new BufferedReader(rdr);

          for (int i = 0; i < arrayAN.length; i++)
          {
            line = bufRdr.readLine();
            arrayAN[i] = processAN(line);
            arrayName[i] = processName(line);
            arraySymbol[i] = processSymbol(line);
            arrayMass[i] = processMass(line);
            String test = processConduct(line);
            if (test.equals("G") || test.equals("S") || test.equals("L"))
            {
              char c = test.charAt(0);
              arrayState[i] = c;
            }
            else
            {
              double d = Double.parseDouble(test);
              arrayConduct[i] = d;
            }
          }
        }
        catch (IOException e)
        {
          if (fileStrm != null)
          {
            try
            {
              fileStrm.close();
            }
            catch (IOException ex2){ }
          }
          System.out.println("Error in file processing: " + e.getMessage());
        }
    }

    /*******************************************
 *   *SUBMODULE array*Depends*
 *   *IMPORT: line
 *   *EXPORT: String
 *   *ASSERTION: Process the file into string
 *  ******************************************/
    public static int processAN(String line)
    {
        int integer;
        line = line.replace("<", "");
        String[] lineArray = line.split(",");
        return integer = Integer.parseInt(lineArray[2]);
    }

    public static String processName(String line)
    {
        String string;
        String[] lineArray = line.split(",");
        return string = lineArray[1];
    }

    public static String processSymbol(String line)
    {
        String string;
        line = line.replace("<", "");
        String[] lineArray = line.split(",");
        return string = lineArray[0];
    }

    public static double processMass(String line)
    {
        double real;
        String[] lineArray = line.split(",");
        return real = Double.parseDouble(lineArray[3]);
    }

    public static String processConduct(String line)
    {
        String string;
        line = line.replace("/>", "");
        String[] lineArray = line.split(",");
        return string = lineArray[4];
    }

    /*******************************************
 *   *SUBMODULE showArea
 *   *IMPORT: arrayAN (integer), arrayName (String), arraySymbol (String), arrayMass (real), arrayConduct (real), arrayState (char), fileName (String)
 *   *EXPORT: none
 *   *ASSERTION: Gets the element for the selected student
 *  ******************************************/
    public static void showArea(int[] arrayAN, String[] arrayName, String[] arraySymbol, double[] arrayMass, double[] arrayConduct, char[] arrayState, PeriodicTable table)
    {
        System.out.println("----------------------------------\nAll of the following have been added:");
        for(int i = 0; i < arrayAN.length; i++){
            if(arrayConduct[i] > 0)
            {
              Metal metal = new Metal(arrayAN[i], arrayName[i], arraySymbol[i], arrayMass[i], arrayConduct[i]);
              table.addElement(metal);
            }
            else if(arrayState[i] == 'G' || arrayState[i] == 'S' || arrayState[i] == 'L')
            {
              NonMetal nonMetal = new NonMetal(arrayAN[i],arrayName[i],arraySymbol[i],arrayMass[i],arrayState[i]);
              table.addElement(nonMetal);
            }
            else
            {
              System.out.println("Error: Element not found!");
            }
        }
    }

    /*******************************************
 *   *SUBMODULE writeCalc
 *   *IMPORT: none
 *   *EXPORT: none
 *   *ASSERTION: Write to file
 *  ******************************************/
    public static void writeCalc()
    {
        int atomicNum;
        double mass, conductivity;
        String name, symbol, type;
        char state;
        boolean loop = true;
        Scanner sc = new Scanner( System.in );

        FileOutputStream fileStrm = null;
        PrintWriter pw;

        try {
          fileStrm = new FileOutputStream("output.csv");
          pw = new PrintWriter(fileStrm);

        while (loop) {
          type = sc.nextLine();
        switch(type)
        {
          case "N":
            System.out.println("----------------------------------\nInput a Symbol:");
            symbol = sc.nextLine();
            System.out.println("Input a Name:");
            name = sc.nextLine();
            System.out.println("Input a Atomic Number:");
            atomicNum = sc.nextInt();
            System.out.println("Input a Mass:");
            mass = sc.nextDouble();
            System.out.println("Input a State:\n(G for gas, S for solid and L for liquid)");
            sc.nextLine();
            state = sc.next().charAt(0);
            pw.println(symbol + "," + name + "," + atomicNum + "," + mass + "," + state);
            System.out.println("Add another? (Enter true or false):");
            loop = sc.nextBoolean();
            break;
          case "M":
            System.out.println("----------------------------------\nInput a Symbol:");
            symbol = sc.nextLine();
            System.out.println("Input a Name:");
            name = sc.nextLine();
            System.out.println("Input a Atomic Number:");
            atomicNum = sc.nextInt();
            System.out.println("Input a Mass:");
            mass = sc.nextDouble();
            System.out.println("Input a Conductivity:");
            conductivity = sc.nextDouble();
            pw.println(symbol + "," + name + "," + atomicNum + "," + mass + "," + conductivity);
            System.out.println("Add another? (Enter true or false):");
            loop = sc.nextBoolean();
            break;
          default:
            System.out.println("----------------------------------\nPlease input the following:\n(N for NonMetal and M for Metal)");
            System.out.print("Your Choice: ");
        }
        }
          pw.close();
        }
        catch (IOException e) {
          if (fileStrm != null) {
            try { fileStrm.close(); } catch (IOException ex2) {}
          }
          System.out.println("Error in writing to file: " + e.getMessage());
        }
    }

}
