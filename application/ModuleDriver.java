
package application;

import java.util.Scanner; 

import util.LinkedList;  /* I want to use MY version of a LinkedList */

/**
 * Driver class that uses the Module class with an LinkedList
 */
public class ModuleDriver
{
    LinkedList<Module> list; //Global variable

    /**
     * Constructor for objects of class ModuleDriver
     */
    public ModuleDriver()
    {
    	Scanner scan = new Scanner(System.in);
        list = new LinkedList<Module>();
        inputModules();       
        displayModules();
        
        scan.nextLine();
        removeFirstModule();
        displayModules();
    }

    public void inputModules()
    {
        Module m; //local variables
        String name, code;
        int credits;
        
        Scanner scan = new Scanner(System.in);
        for (int count=1; count <=3; count++)
        {
            System.out.print("\nEnter name for module " + count + " : ");
            name = scan.nextLine();
            System.out.print("Enter code for module " + count + " : ");
            code = scan.nextLine();
            System.out.print("Enter number of credits for module " + count + " : ");
            credits = scan.nextInt();
            scan.nextLine();

            //Create a module
            m = new Module(name, code, credits);

            //Add to LinkedList
            list.add(m);
        }
    }

    public void displayModules()
    {
        System.out.println("\nDisplaying all modules....");
       
        System.out.println(list.toString());       
    }

    public void removeFirstModule()
    {
    	System.out.println("\nRemoving the first element in the list...");
    	Module m = list.remove();
    	System.out.println("\n" + m.getName() + " has been deleted");
    }
    
    
    public static void main(String[] args)
    {
        new ModuleDriver();
    }
}
