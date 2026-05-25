package quickchat;

import java.util.Random;

public class message {
    // Variables
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageContent;
    private String messageHash;
    private static int totalMessagesSent = 0;
    
    // Constructor
    public message(int messageNumber, String recipient, String messageContent) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageContent = messageContent;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }
    
    // Method that checks if the messageID created 10 random numbers
    public boolean checkMessageID() {
        if (messageID.length() == 10) {
            return true;
        } else {
            return false;
        }
    }
    
    // Method that checks if the recipient number is what the system wants
    public String checkRecipientCell() {
        if (recipient.length() <= 10 && recipient.startsWith("+")) {
            return "Valid";
        } else {
            return "Invalid recipient. Must be ≤10 chars and start with +";
        }
    }
    
    //Method that create the Message Hash
    public String createMessageHash() {
        //Breaks the spaces of the message into a proper array
        String[] words = messageContent.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        
        // Get first two numbers of random messageID numbers
        String firstTwoNumbers = messageID.substring(0, 2);
        
        // Sets the variable hash with required formate
        String hash = firstTwoNumbers + ":" + messageNumber + ":" + firstWord + lastWord;
        
        hash = hash.toUpperCase();
        
        return hash;
    }
    
    // Method that provides the user the options about the messages
    public String sendMessage() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.println("Choose what to do:");
        System.out.println("1) Send Message");
        System.out.println("2) Disregard Message");
        System.out.println("3) Store Message to send later");
        
        int action = scanner.nextInt();
        
        if (action == 1) {
            totalMessagesSent++;
            return "Message successfully sent";
        } 
        else if (action == 2) {
            return "Message deleted";
        } 
        else if (action == 3) {
            return "Message successfully stored";
        } 
        else {
            return "Invalid choice.";
        }
    }
    
    // Method that displays details for all the meassages
    public String printMessages() {
        return "Message ID: " + messageID + "\n" +
               "Message Hash: " + messageHash + "\n" +
               "Recipient: " + recipient + "\n" +
               "Message: " + messageContent;
    }
    
    //Methd that returns total messages that the user used
    public static int returnTotalMessages() {
        return totalMessagesSent;
    }
    
    // Heps the method to create the 10 random numbers
    private String generateMessageID() {
        Random rand = new Random();
        // Creats random numbers
        int randomNum = rand.nextInt(1000000000);
        // Converts the random set of numbers into a one single string
        String messageID = String.format("%010d", randomNum);
        return messageID;
    }
}
