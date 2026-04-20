/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chat_app;

/**
 *
 * @author Thabo
 */
import java.util.Scanner;
public class Main
{
    static Scanner input = new Scanner(System.in);
    
    static String firstname;
    static String lastname;
    
    public static void main(String[] args) 
	{
		System.out.println("=Registration=");
		Userregistration();
		
		System.out.println("=Login=");
		Userlogin();
                 
	}
	public static void Userregistration()
	{
	    System.out.print("Enter First Name: ");
        firstname = input.nextLine();
        
        System.out.print("Enter Last Name: ");
        lastname = input.nextLine();
        
        System.out.println(" ");
        
	    String username;
		boolean validUsername = false;
		
		while(!validUsername)
		{
		    System.out.print("Enter Username: ");
		    username = input.nextLine();
		    
		    boolean isLongEnough = username.length() >=5;
		    boolean hasUnderscore = username.contains("_");
		    
		    if(isLongEnough && hasUnderscore)
		    {
		        validUsername = true;
		    }
		    else
		    {
		        System.out.println("Username is NOT valid");
		    }
		}
		
		String password;
        boolean validpassword = false;
        
        while (!validpassword) 
        {
            System.out.print("Enter password: ");
            password = input.nextLine();

            boolean isLongEnough = password.length() >= 8;
            boolean hasUpperCase = false;
            boolean hasLowerCase = false;
            boolean hasDigit = false;
            boolean hasSpecial = false;

            for (int i = 0; i < password.length(); i++) 
            {
                char c = password.charAt(i);
                if (Character.isUpperCase(c)) hasUpperCase = true;
        
                else if (Character.isLowerCase(c)) hasLowerCase = true;
        
                else if (Character.isDigit(c)) hasDigit = true;
        
                else hasSpecial = true;
            }

            boolean meetsRequirements = isLongEnough && hasUpperCase && hasLowerCase && hasDigit && hasSpecial;

            if (meetsRequirements) 
            {
                System.out.println("Password successfully captured");
                validpassword = true;
               
                System.out.println(" ");
            } 
            else 
            {
                System.out.println("Password is NOT valid.");
            }
        }    

		String pattern = "\\+27[0-9]{9}$";
        boolean isValid = false;

        while (!isValid)
	    {
            System.out.print("Enter your number: ");
            String phoneNumber = input.nextLine();

            if (phoneNumber.matches(pattern)) 
            {
                System.out.println("Valid phone number.");
                isValid = true;
            } 
            else 
            {
                System.out.println("Invalid phone number. Please try again.");
            }
            System.out.println(" "); 
        }
    
		{
		    System.out.println(" ");
		}
	
	}
	
    public static void Userlogin()
    {
	    String username;
	    boolean validUsername = false;
		
	    while(!validUsername)
	    {
	        System.out.print("Enter Username: ");
		    username = input.nextLine();
		    
		    boolean isLongEnough = username.length() >=5;
		    boolean hasUnderscore = username.contains("_");
		    
		    if(isLongEnough && hasUnderscore)
		    {
		        validUsername = true;
                       

		    }
		    else
		    {
		        System.out.println("Username is NOT valid");
		    }
                    
	    }

	    String password;
        boolean validpassword = false;

        while (!validpassword) 
        {
            System.out.print("Enter password: ");
            password = input.nextLine();

            boolean isLongEnough = password.length() >= 8;
            boolean hasUpperCase = false;
            boolean hasLowerCase = false;
            boolean hasDigit = false;
            boolean hasSpecial = false;

            for (int i = 0; i < password.length(); i++) 
            {
                char c = password.charAt(i);
                if (Character.isUpperCase(c)) hasUpperCase = true;
        
                else if (Character.isLowerCase(c)) hasLowerCase = true;
        
                else if (Character.isDigit(c)) hasDigit = true;
        
                else hasSpecial = true;
            }

            boolean meetsRequirements = isLongEnough && hasUpperCase && hasLowerCase && hasDigit && hasSpecial;

            if (meetsRequirements) 
            {
                validpassword = true;
                System.out.println(" ");
            } 
            else 
            {
                System.out.println("Password is NOT valid.");
            }
        }
        {
            System.out.println("LOGIN SUCCESSFULL");
        }
        {
            System.out.println("Welcome back " +firstname+ " " +lastname+ " it is greet to see you  "); 
        }
    }
}
