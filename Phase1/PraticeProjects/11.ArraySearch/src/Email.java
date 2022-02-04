import java.util.Scanner;
class Email
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        String mail[]= new String[4];
        
        System.out.println("Enter Four Email IDs: ");
        for(int i=0;i<mail.length;i++)
        {
            mail[i]=in.nextLine();
        }
        
        System.out.println("Entry Filled Ready To Search");
        
        int pos =0; // to store the location if element is found
       
        System.out.println("Enter Email ID To Search");
         String search = in.nextLine(); 
         
           for(int i=0; i<mail.length; i++)
              {
              if(search.equals(mail[i]))
                           pos = i;
              }
               if(pos != 0)
               System.out.println("This Email ID is Validated: " + mail[pos]);
               else
               System.out.println("Not Found - Invalid Email ID");
                   
                    
           
        }
    }
        