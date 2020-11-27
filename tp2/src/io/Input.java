package io ;


import java.io.IOException;
import java.util.Scanner;

/**
 * tool class for inputs (String or int)
 *
 * @author <a href="mailto:routier@univ-lille.fr">Jean-Christophe Routier</a>
 */
public class Input {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * reads a string in standard input
	 * 
	 * @return the read string
	 */
	public static String readString() {
	    return Input.scanner.next();
	}

	/**
	 * reads an int in standard input
	 * 
	 * @return the read int
	 * @exception java.io.IOException if input does not correspond to an int
	 */
	public static int readInt() throws java.io.IOException {
	    try {
		return Input.scanner.nextInt();
	    } catch (Exception e) {
		Input.scanner.skip(".*");
		throw new java.io.IOException();
	    }
	}

	
	// example of use
	public static void main(String[] args) {
		
	    System.out.print(" give a tring : ? ");
	    String userString = Input.readString();
	    
	    System.out.println("read int => " + userString);
	    int userInt;
	    try {
		System.out.print(" give an int : ? ");
		userInt = Input.readInt();
		System.out.println("read int => " + userInt);
	    } catch (java.io.IOException e) {
		//"exception... : input does not correspond to an integer
		// here we choose to provide a default value 
		userInt = 0;
		System.out.println("corrected value  => " + userInt);	
	    }
	    System.out.println(" value  (read or corrected) => " + userInt);
	    
	}
}// Input
