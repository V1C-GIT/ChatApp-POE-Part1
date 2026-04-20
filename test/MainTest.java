/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thabo
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest 
{

    @Test
    public void testValidUsername() 
    {
        assertTrue(Main.isValidUsername("user_"));
    }

    @Test
    public void testInvalidUsername()
    {
        assertFalse(Main.isValidUsername("usr"));
    }

    @Test
    public void testValidPassword()
    {
        assertTrue(Main.isValidPassword("Password1!"));
    }

    @Test
    public void testInvalidPassword()
    {
        assertFalse(Main.isValidPassword("password"));
    }

    @Test
    public void testValidPhone() 
    {
        assertTrue(Main.isValidPhone("+27831234567"));
    }

    @Test
    public void testInvalidPhone() 
    {
        assertFalse(Main.isValidPhone("0831234567"));
    }
}
