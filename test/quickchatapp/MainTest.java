/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package quickchatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import quickchat.Main;

/**
 *
 * @author Thabo
 */
public class MainTest {
    
    public MainTest() {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Main.main(args);
        fail("The test case is a prototype.");
    }

    /**
     * Test of Userregistration method, of class Main.
     */
    @Test
    public void testUserregistration() {
        System.out.println("Userregistration");
        Main.Userregistration();
        fail("The test case is a prototype.");
    }

    /**
     * Test of Userlogin method, of class Main.
     */
    @Test
    public void testUserlogin() {
        System.out.println("Userlogin");
        Main.Userlogin();
        fail("The test case is a prototype.");
    }

    /**
     * Test of startQuickChat method, of class Main.
     */
    @Test
    public void testStartQuickChat() {
        System.out.println("startQuickChat");
        Main.startQuickChat();
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMessage method, of class Main.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        int messageNumber = 0;
        Main.sendMessage(messageNumber);
        fail("The test case is a prototype.");
    }

    /**
     * Test of showSentMessages method, of class Main.
     */
    @Test
    public void testShowSentMessages() {
        System.out.println("showSentMessages");
        Main.showSentMessages();
        fail("The test case is a prototype.");
    }

    /**
     * Test of storedMessagesMenu method, of class Main.
     */
    @Test
    public void testStoredMessagesMenu() {
        System.out.println("storedMessagesMenu");
        Main.storedMessagesMenu();
        fail("The test case is a prototype.");
    }

    /**
     * Test of displaySenderRecipient method, of class Main.
     */
    @Test
    public void testDisplaySenderRecipient() {
        System.out.println("displaySenderRecipient");
        Main.displaySenderRecipient();
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayLongestMessage method, of class Main.
     */
    @Test
    public void testDisplayLongestMessage() {
        System.out.println("displayLongestMessage");
        Main.displayLongestMessage();
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByMessageID method, of class Main.
     */
    @Test
    public void testSearchByMessageID() {
        System.out.println("searchByMessageID");
        Main.searchByMessageID();
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByRecipient method, of class Main.
     */
    @Test
    public void testSearchByRecipient() {
        System.out.println("searchByRecipient");
        Main.searchByRecipient();
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteByHash method, of class Main.
     */
    @Test
    public void testDeleteByHash() {
        System.out.println("deleteByHash");
        Main.deleteByHash();
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayFullReport method, of class Main.
     */
    @Test
    public void testDisplayFullReport() {
        System.out.println("displayFullReport");
        Main.displayFullReport();
        fail("The test case is a prototype.");
    }
    
}
