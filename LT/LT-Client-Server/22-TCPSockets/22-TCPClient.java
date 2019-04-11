import java.io.*;
import java.net.*;

/**
 * Mohamad-Jaafar NEHME
 * Cours "Client-Server" pour la Licence
 * Technique au Liban (Java Applications)
 * Chapter 2 - Exercise 2 - TCP Sockets
 * The Client Connects to a localhost Server listening on port 6789
 * The Client sends a text message to the Server, and receives the message modified
 */

public class TCPClient {
	
	public static void main(String argv[]) throws Exception {

		/*
		 * Create Socket to Server
		 */
		Socket clientSocket = new Socket("localhost", 6789);
		
		/*
		 * Read from keyboard a Message
		 * Note: we can replace the following three lines code
		 * with the traditional reader Scanner. There exists a difference
		 * that you may yourself surf for.		 * 
		 */
		InputStreamReader ISR = new InputStreamReader(System.in);	// Reads bytes from keyboard
										// and converts them to character-based InputStreams
										// InputStreamReader is alternative for scanner
		
		BufferedReader inFromUser = new BufferedReader(ISR);		// BufferedReader puts the character-based InputStreams
										// into Buffer 
		
		String sentence = inFromUser.readLine();			// Converts the buffer line into String

		/*
		 * Write the Message to socket
		 */
		OutputStream OSR = clientSocket.getOutputStream();		// Point to the OutputStream of the socket
										// OutputStream: Output stream of bytes
		
		DataOutputStream outToServer = new DataOutputStream(OSR);	// DataOutputStream: Adapter for converting string into OutputStream
		
		outToServer.writeBytes(sentence + '\n');			// Write OutputStream to Socket via outToServer

		/*
		 * Read a Response Message from Server
		 * Easy: Similar to Above
		 */
		InputStream IS = clientSocket.getInputStream();
		InputStreamReader ISR2 = new InputStreamReader(IS);
		BufferedReader inFromServer = new BufferedReader(ISR2);
		String modifiedSentence = inFromServer.readLine();

		/*
		 * Print Message from Server on Screen
		 */
		System.out.println(modifiedSentence);
		Thread.sleep(1000);
		
		/*
		 * Close Socket
		 */
		clientSocket.close();
	}
}
