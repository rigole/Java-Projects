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

}
