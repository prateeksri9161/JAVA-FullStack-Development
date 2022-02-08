import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class LockedMe {
    static String PATH;
    File F_name;

    public LockedMe() {
        PATH = System.getProperty("user.dir");
        F_name = new File(PATH+"/FileList");
        if (!F_name.exists())
            F_name.mkdirs();
        System.out.println("Location : "+ F_name.getAbsolutePath());
    }

    private static final String WELCOME_SCREEN =
            "\n----------------------  LockedMe.com  -------------------------"+
                    "\n----------------------  Prateek Srivastava  -------------------------\n";

    private static final String MAIN_MENU_PROMPT =
            "\nWELCOME TO MAIN MENU  \n"+
				"Enter any of the following options:\n"+
                    "1 => For Getting the List of Files\n"+
                    "2 => For Business Operations\n"+
                    "3 => Close The Application";

    private static final String BUSINESS_OPS =
            "   \nEnter any of the following options: \n"+
                    "   a => Adding a new file\n"+
                    "   b => Deleting an existing file\n"+
                    "   c => Searching an existing file\n"+
                    "   d => Go Back To MAIN MENU";

    void displayMain() {
        System.out.println(MAIN_MENU_PROMPT);
        try{
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option){
                case 1 : { 
					System.out.println("PATH : "+ F_name.getAbsolutePath());
                    showFiles();
                    displayMain();
                }
                case 2 : {
                    displayBusiness();
                }
                case 3 : {
                    System.out.println("Application Closing...Thank You");
                    System.exit(0);
                }
                default: {
					System.out.println("Wrong Choice!! Try Again...");
					displayMain();
				}
            }
        }
        catch (Exception e){
            System.out.println("Please enter 1, 2 or 3");
            displayMain();
        }
    }

    void displayBusiness() {
        System.out.println(BUSINESS_OPS);
        try{
            Scanner scanner = new Scanner(System.in);
            char[] input = scanner.nextLine().toLowerCase().trim().toCharArray();
            char option = input[0];

            switch (option){
                case 'a' : {
                    System.out.println(" Adding a file...");
					System.out.println(" Please Enter a File Name with file extension : ");
                    String filename = scanner.next().trim().toLowerCase();
                    addFile(filename);
                    break;
                }
                case 'b' : {
                    System.out.println(" Deleting a file...");
					System.out.println(" Please Enter a File Name with file extension : ");
                    String filename = scanner.next().trim();
                    deleteFile(filename);
                    break;
                }
                case 'c' : {
                    System.out.println(" Searching a file...");
					System.out.println(" Please Enter a File Name with file extension : ");
                    String filename = scanner.next().trim();
                    searchFile(filename);
                    break;
                }
                case 'd' : {
                    System.out.println("Going Back to MAIN menu");
                    displayMain();
                    break;
                }
                default : System.out.println("Wrong Option!!! Please enter a, b, c or d");
            }
            displayBusiness();
        }
        catch (Exception e){
            System.out.println("Exception occured...Please enter a, b, c or d");
            displayBusiness();
        }
    }

    void showFiles() {
        if (F_name.list().length==0)
            System.out.println("The List folder is empty...There is no file");
        else {
            String[] list = F_name.list();
            System.out.println("The files in "+ F_name +" are :");
            Arrays.sort(list);
            for (String str:list) {
                System.out.println(str);
            }
        }
    }

    void addFile(String filename) throws IOException {
        File filepath = new File(F_name +"/"+filename);
        String[] list = F_name.list();
        for (String file: list) {
            if (filename.equalsIgnoreCase(file)) {
                System.out.println("File " + filename + " already exists at " + F_name);
                return;
            }
        }
        filepath.createNewFile();
        System.out.println("File "+filename+" added to "+ F_name);
    }

    void deleteFile(String filename) {
        File filepath = new File(F_name +"/"+filename);
        String[] list = F_name.list();
        for (String file: list) {
            if (filename.equals(file) && filepath.delete()) {
                System.out.println("File " + filename + " deleted from " + F_name);
                return;
            }
        }
        System.out.println("Delete Operation failed. FILE NOT FOUND");
    }

    void searchFile(String filename) {
        String[] list = F_name.list();
        for (String file: list) {
            if (filename.equals(file)) {
                System.out.println("Search Successfull : File " + filename + " exists at " + F_name);
                return;
            }
        }
        System.out.println("File NOT found");
    }

    public static void main(String[] args) {
        System.out.println(WELCOME_SCREEN);
        LockedMe menu = new LockedMe();
        menu.displayMain();
    }
}
