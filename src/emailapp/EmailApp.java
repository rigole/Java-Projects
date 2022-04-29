package emailapp;
import java.util.*;

public class EmailApp {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // User info
        System.out.println("Enter First Name");
        String f_name = scanner.next();

        System.out.println("Enter last name: ");
        String l_name = scanner.next();
        int choice =-1;

        Email email = new Email(f_name, l_name);
        do {
            System.out.println("\n****\nEnter your choice\n1.Show Info\n2.Change password\n3.Change mailbox capacity\n4.Set Alternate mail\n5.Store Data in file\n6.Display from file\n7.Exit");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    email.getInfo();
                    break;
                case 2:
                    email.set_password();
                    break;
                case 3:
                    email.set_mailCap();
                    break;
                case 4:
                    email.alternate_email();
                    break;
                case 5:
                    email.storefile();
                    break;
                case 6:
                    email.read_file();
                case 7:
                    System.out.println("Thanks for trying our program");
                    break;
                default:
                    System.out.println("Invalid choice!!!  \nEnter proper choice again..");

            }
        }while (choice!=7);
    }
}
