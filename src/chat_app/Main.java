/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package quickchat;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {

    static Scanner input = new Scanner(System.in);

    static String firstname;
    static String lastname;

    static int totalMessagesSent = 0;

    static ArrayList<Message> sentMessages = new ArrayList<>();
    static ArrayList<Message> disregardedMessages = new ArrayList<>();
    static ArrayList<Message> storedMessages = new ArrayList<>();
    static ArrayList<String> messageHashes = new ArrayList<>();
    static ArrayList<String> messageIDs = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("===== REGISTRATION =====");
        Userregistration();

        System.out.println("\n===== LOGIN =====");
        Userlogin();

        startQuickChat();
    }

    public static void Userregistration() {

        System.out.print("Enter First Name: ");
        firstname = input.nextLine();

        System.out.print("Enter Last Name: ");
        lastname = input.nextLine();

        String username;
        boolean validUsername = false;

        while (!validUsername) {

            System.out.print("Enter Username: ");
            username = input.nextLine();

            boolean isLongEnough = username.length() >= 5;
            boolean hasUnderscore = username.contains("_");

            if (isLongEnough && hasUnderscore) {
                validUsername = true;
            } else {
                System.out.println("Username is NOT valid.");
            }
        }

        String password;
        boolean validPassword = false;

        while (!validPassword) {

            System.out.print("Enter Password: ");
            password = input.nextLine();

            boolean isLongEnough = password.length() >= 8;
            boolean hasUpperCase = false;
            boolean hasLowerCase = false;
            boolean hasDigit = false;
            boolean hasSpecial = false;

            for (int i = 0; i < password.length(); i++) {

                char c = password.charAt(i);

                if (Character.isUpperCase(c))
                    hasUpperCase = true;
                else if (Character.isLowerCase(c))
                    hasLowerCase = true;
                else if (Character.isDigit(c))
                    hasDigit = true;
                else
                    hasSpecial = true;
            }

            if (isLongEnough && hasUpperCase && hasLowerCase
                    && hasDigit && hasSpecial) {

                validPassword = true;
                System.out.println("Password successfully captured.");
            } else {
                System.out.println("Password is NOT valid.");
            }
        }

        String pattern = "\\+27[0-9]{9}$";
        boolean validPhone = false;

        while (!validPhone) {

            System.out.print("Enter Phone Number: ");
            String phoneNumber = input.nextLine();

            if (phoneNumber.matches(pattern)) {
                validPhone = true;
                System.out.println("Valid phone number.");
            } else {
                System.out.println("Invalid phone number.");
            }
        }

        System.out.println("\nRegistration Successful!");
    }

    public static void Userlogin() {

        String username;
        boolean validUsername = false;

        while (!validUsername) {

            System.out.print("Enter Username: ");
            username = input.nextLine();

            boolean isLongEnough = username.length() >= 5;
            boolean hasUnderscore = username.contains("_");

            if (isLongEnough && hasUnderscore) {
                validUsername = true;
            } else {
                System.out.println("Username is NOT valid.");
            }
        }

        String password;
        boolean validPassword = false;

        while (!validPassword) {

            System.out.print("Enter Password: ");
            password = input.nextLine();

            boolean isLongEnough = password.length() >= 8;
            boolean hasUpperCase = false;
            boolean hasLowerCase = false;
            boolean hasDigit = false;
            boolean hasSpecial = false;

            for (int i = 0; i < password.length(); i++) {

                char c = password.charAt(i);

                if (Character.isUpperCase(c))
                    hasUpperCase = true;
                else if (Character.isLowerCase(c))
                    hasLowerCase = true;
                else if (Character.isDigit(c))
                    hasDigit = true;
                else
                    hasSpecial = true;
            }

            if (isLongEnough && hasUpperCase && hasLowerCase
                    && hasDigit && hasSpecial) {

                validPassword = true;
            } else {
                System.out.println("Password is NOT valid.");
            }
        }

        System.out.println("\nLOGIN SUCCESSFUL");
        System.out.println("Welcome " + firstname + " " + lastname);
    }

    public static void startQuickChat() {

        System.out.println("\nWelcome to QuickChat");

        System.out.print("How many messages do you wish to enter? ");
        int messageLimit = input.nextInt();
        input.nextLine();

        int messagesSentCount = 0;
        boolean running = true;

        while (running && messagesSentCount < messageLimit) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Send Message");
            System.out.println("2. Show Recently Sent Messages");
            System.out.println("3. Stored Messages");
            System.out.println("4. Quit");
            System.out.print("Choose Option: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    sendMessage(messagesSentCount + 1);
                    messagesSentCount++;
                    break;

                case 2:
                    showSentMessages();
                    break;

                case 3:
                    storedMessagesMenu();
                    break;

                case 4:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid Option.");
            }
        }

        System.out.println("\nTotal Messages Sent: "
                + totalMessagesSent);
    }

    public static void sendMessage(int messageNumber) {

        System.out.print("Enter Recipient Number: ");
        String recipient = input.nextLine();

        if (recipient.length() > 15 || !recipient.startsWith("+")) {

            System.out.println(
                    "Cell number is incorrectly formatted.");
            return;
        }

        System.out.print("Enter Message: ");
        String messageContent = input.nextLine();

        if (messageContent.length() > 250) {

            System.out.println(
                    "Please enter a message less than 250 characters.");
            return;
        }

        Random rand = new Random();

        String messageID =
                String.format("%010d",
                        rand.nextInt(1000000000));

        String[] words = messageContent.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        String messageHash =
                messageID.substring(0, 2)
                        + ":" + messageNumber
                        + ":" + firstWord + lastWord;

        messageHash = messageHash.toUpperCase();

        Message newMessage =
                new Message(
                        messageID,
                        firstname + " " + lastname,
                        recipient,
                        messageContent,
                        messageHash);

        System.out.println("\n===== MESSAGE DETAILS =====");
        System.out.println("Message ID: " + messageID);
        System.out.println("Message Hash: " + messageHash);
        System.out.println("Recipient: " + recipient);
        System.out.println("Message: " + messageContent);

        System.out.println("\n1. Send Message");
        System.out.println("2. Disregard Message");
        System.out.println("3. Store Message");
        System.out.print("Choose: ");

        int action = input.nextInt();
        input.nextLine();

        if (action == 1) {

            sentMessages.add(newMessage);
            messageHashes.add(messageHash);
            messageIDs.add(messageID);

            totalMessagesSent++;

            System.out.println("Message successfully sent.");
        }
        else if (action == 2) {

            disregardedMessages.add(newMessage);

            System.out.println(
                    "Message disregarded and deleted.");
        }
        else if (action == 3) {

            storedMessages.add(newMessage);

            System.out.println(
                    "Message successfully stored.");
        }
        else {

            System.out.println("Invalid choice.");
        }
    }

    public static void showSentMessages() {

        if (sentMessages.isEmpty()) {

            System.out.println("No messages sent.");
            return;
        }

        for (Message msg : sentMessages) {

            System.out.println(msg);
        }
    }

    public static void storedMessagesMenu() {

        System.out.println("\n===== STORED MESSAGES =====");
        System.out.println("1. Display Sender and Recipient");
        System.out.println("2. Display Longest Message");
        System.out.println("3. Search Message ID");
        System.out.println("4. Search Recipient");
        System.out.println("5. Delete Message Using Hash");
        System.out.println("6. Display Full Report");

        System.out.print("Choose Option: ");
        int option = input.nextInt();
        input.nextLine();

        switch (option) {

            case 1:
                displaySenderRecipient();
                break;

            case 2:
                displayLongestMessage();
                break;

            case 3:
                searchByMessageID();
                break;

            case 4:
                searchByRecipient();
                break;

            case 5:
                deleteByHash();
                break;

            case 6:
                displayFullReport();
                break;

            default:
                System.out.println("Invalid option.");
        }
    }

    public static void displaySenderRecipient() {

        if (storedMessages.isEmpty()) {

            System.out.println("No stored messages.");
            return;
        }

        for (Message msg : storedMessages) {

            System.out.println("Sender: "
                    + msg.sender
                    + " | Recipient: "
                    + msg.recipient);
        }
    }

    public static void displayLongestMessage() {

        if (storedMessages.isEmpty()) {

            System.out.println("No stored messages.");
            return;
        }

        Message longest = storedMessages.get(0);

        for (Message msg : storedMessages) {

            if (msg.message.length()
                    > longest.message.length()) {

                longest = msg;
            }
        }

        System.out.println("\nLongest Message:");
        System.out.println(longest);
    }

    public static void searchByMessageID() {

        System.out.print("Enter Message ID: ");
        String id = input.nextLine();

        for (Message msg : storedMessages) {

            if (msg.messageID.equals(id)) {

                System.out.println(
                        "Recipient: " + msg.recipient);

                System.out.println(
                        "Message: " + msg.message);

                return;
            }
        }

        System.out.println("Message not found.");
    }

    public static void searchByRecipient() {

        System.out.print("Enter Recipient Number: ");
        String recipient = input.nextLine();

        boolean found = false;

        for (Message msg : storedMessages) {

            if (msg.recipient.equalsIgnoreCase(recipient)) {

                System.out.println(msg);
                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No messages found for recipient.");
        }
    }

    public static void deleteByHash() {

        System.out.print("Enter Message Hash: ");
        String hash = input.nextLine();

        for (int i = 0; i < storedMessages.size(); i++) {

            if (storedMessages.get(i)
                    .messageHash.equals(hash)) {

                storedMessages.remove(i);

                System.out.println(
                        "Message deleted successfully.");

                return;
            }
        }

        System.out.println("Hash not found.");
    }

    public static void displayFullReport() {

        if (storedMessages.isEmpty()) {

            System.out.println("No stored messages.");
            return;
        }

        System.out.println("\n===== FULL REPORT =====");

        for (Message msg : storedMessages) {

            System.out.println(msg);
        }
    }
}

class Message {

    String messageID;
    String sender;
    String recipient;
    String message;
    String messageHash;

    public Message(String messageID,
                   String sender,
                   String recipient,
                   String message,
                   String messageHash) {

        this.messageID = messageID;
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.messageHash = messageHash;
    }

    @Override
    public String toString() {

        return "Message ID: " + messageID
                + "\nSender: " + sender
                + "\nRecipient: " + recipient
                + "\nMessage: " + message
                + "\nHash: " + messageHash
                + "\n------------------------";
    }
}
