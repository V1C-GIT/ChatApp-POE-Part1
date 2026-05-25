/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quickchat;
import java.util.Scanner;
import java.util.Random;

public class Main
{
    static Scanner input = new Scanner(System.in);
    
    static String firstname;
    static String lastname;
    
    public static void main(String[] args) 
	{
		System.out.println("=====Registration=====");
		Userregistration();
		
		System.out.println("=====Login====");
		Userlogin();
		
		// Object calling
		startQuickChat();
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
                System.out.println("Welcome back " + firstname + " " + lastname + ", it is great to see you");
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
    }
    
    // mathod tha displays message class
    
    public static void startQuickChat()
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nWelcome to QuickChat.");
        
        System.out.print("How many messages do you wish to enter? ");
        int messageLimit = scanner.nextInt();
        scanner.nextLine();
        
        int messagesSentCount = 0;
        boolean running = true;
        
        while (running && messagesSentCount < messageLimit)
        {
            System.out.println(" ");
            System.out.println("Menu Option");
            System.out.println("Option 1: Send Messages");
            System.out.println("Option 2: Show recently sent messages");
            System.out.println("Option 3: Quit");
            System.out.print("Choose Option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1)
            {
                sendMessage(messagesSentCount + 1, scanner);
                messagesSentCount++;
            }
            else if (choice == 2)
            {
                System.out.println("Coming Soon.");
            }
            else if (choice == 3)
            {
                System.out.println("Goodbye!");
                running = false;
            }
            else
            {
                System.out.println("Option not available, Please select one from the above only");
            }
        }
        
        System.out.println(" ");
        System.out.println("Total number of messages sent: " + totalMessagesSent);
        System.out.println(" ");
    }
    
    static int totalMessagesSent = 0;
    
    public static void sendMessage(int messageNumber, Scanner scanner)
    {
        System.out.print("Enter recipient number: ");
        String recipient = scanner.nextLine();
        
        if (recipient.length() > 15)
        {
            System.out.println("Cell number is incorrectly formated or does not contain an international code.try again");
            return;
        }
        
        if (!recipient.startsWith("+"))
        {
            System.out.println("Cell number is incorrectly formated or does not contain an international code. try again");
            return;
        }
        
        System.out.print("Enter your text message: ");
        String messageContent = scanner.nextLine();
        
        if (messageContent.length() > 250)
        {
            System.out.println("Please enter a message of less than 250 characters.");
            return;
        }
        
        Random rand = new Random();
        int randomNum = rand.nextInt(1000000000);
        String messageID = String.format("%010d", randomNum);
        
        String[] words = messageContent.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        String firstTwoNumbers = messageID.substring(0, 2);
        String messageHash = firstTwoNumbers + ":" + messageNumber + ":" + firstWord + lastWord;
        messageHash = messageHash.toUpperCase();
        
        System.out.println(" ");
        System.out.println(" Message Details ");
        System.out.println("Message ID: " + messageID);
        System.out.println("Message Hash: " + messageHash);
        System.out.println("Recipient: " + recipient);
        System.out.println("Message: " + messageContent);
        
         System.out.println(" ");
        System.out.println("Choose what you want to do witth your message:");
        System.out.println("Option 1: Send Message");
        System.out.println("Option 2: Disregard Message");
        System.out.println("Option 3: Store Message to send later");
        System.out.print(" :");
        int action = scanner.nextInt();
        scanner.nextLine();
        
        if (action == 1)
        {
            totalMessagesSent++;
            System.out.println("Message successfully sent");
            System.out.println("\n");
            System.out.println("Message ID: " + messageID);
            System.out.println("Message Hash: " + messageHash);
            System.out.println("Recipient: " + recipient);
            System.out.println("Message: " + messageContent);
        }
        else if (action == 2)
        {
            System.out.println("Message disregarded and deleted");
        }
        else if (action == 3)
        {
            System.out.println("Message successfully stored");
        }
        else
        {
            System.out.println("Invalid choice. choose between the above options");
        }
    }
}
