package emailapp;
import java.util.*;
import java.io.*;


public class Email {
    public Scanner s = new Scanner(System.in);

    private String firstname;
    private String lastname;
    private String department;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;

    public Email(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
        System.out.println("New Employee: " + this.firstname + " " + this.lastname);

        // calling method
        this.department = this.setDepartment();
        this.password = this.generate_password(8);
        this.email = this.generate_email();

    }

    private String generate_email() {
        return this.firstname.toLowerCase()+"."+this.lastname.toLowerCase()+"@"+this.department.toLowerCase()+".company.com";
    }

    private String setDepartment(){
        System.out.println("Department codes \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none");
        boolean flag = false;
        do {
            System.out.println("Enter Department Code: ");
            int choice = s.nextInt();

            switch (choice){
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid Choice Please choose again");
            }
        }while (!flag);

        return null;
    }

    private String generate_password(int length){
        Random random = new Random();
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&?";
        String values = Capital_chars+Small_chars+numbers+symbols;
        String password ="";
        for (int i=0; i<length;i++){
            password = password + values.charAt(random.nextInt(values.length()));
        }
        return password;
    }

    public void set_password(){
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password");
            char choice = s.next().charAt(0);
            if(choice == 'Y' || choice =='y'){
                System.out.println("Enter current password :");
                String temp = s.next();
                if(temp.equals(this.password)){
                    System.out.println("Enter new password: ");
                    this.password = s.next();
                    System.out.println("Password changed Successfully");
                }
                else{
                    System.out.println("Incorrect Password");
                }
            }else if (choice == 'N' || choice == 'n'){
                flag = true;
                System.out.println("Password changed option cancelled!");
            }
            else {
                System.out.println("Enter a valid choice ");
            }
        }while (!flag);
    }

    // Setting the mailbox capacity method
    public void set_mailCap(){
        System.out.println("Current capacity= "+this.mailCapacity+"mb");
        System.out.println("Enter new mailbox capacity: ");
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }

    // set alternate mail

    public void alternate_email(){
        System.out.println("Enter new alternate mail: ");
        this.alter_email = s.next();
        System.out.println("Alternate email is set");
    }

    // Display user information method
    public void getInfo(){
        System.out.println("New:"+this.firstname+" "+this.lastname);
        System.out.println("Department: "+this.department);
        System.out.println("Email:"+this.email);
        System.out.println("Password:"+this.password);
        System.out.println("Mailbox capacity"+this.mailCapacity+"mb");
        System.out.println("Alternate mail"+this.alter_email);
    }

    public void storefile() {
        try {
            FileWriter in = new FileWriter("C:\\Users\\Plass\\Desktop\\info.txt");
            in.write("First name: "+this.firstname);
            in.append("\nLast name: "+this.lastname);
            in.append("\nEmail: "+this.email);
            in.append("\nPassword: "+this.password);
            in.append("\nCapacity "+this.mailCapacity);
            in.append("\nAlternate mail "+this.alter_email);
            in.close();
            System.out.println("Data Stored");

        }catch(Exception e){
            System.out.println(e);
        }

    }

    // Reading file method
    public void read_file(){
        try {

            FileReader fileReader = new FileReader("C:\\Users\\Plass\\Desktop\\info.txt");
            int i;

            while ((i=fileReader.read())!=-1){
                System.out.println((char)i);
            }
            System.out.println("");
            fileReader.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
