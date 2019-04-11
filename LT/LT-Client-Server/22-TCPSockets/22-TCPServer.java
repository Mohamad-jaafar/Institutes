import java.io.*;
import java.net.*;

/**
 * Mohamad-Jaafar NEHME
 * Cours "Client-Server" pour la Licence
 * Technique au Liban (Java Applications)
 * Chapter 2 - Exercise 2 - TCP Sockets
 * The Server listens on port 6789 for Clients
 * The Server receives a text message from a Client, 
 * Capitalize it and resend it modified to the Client.
 * Note: Additional Comments on Client's Code
 */

public class TCPServer {
	public static void main(String args[]) throws Exception {
		
		String clientSentence;
		String capitalizedSentence;
		
		/*
		 * Create Socket and bind it on port 6789
		 */
		ServerSocket welcomeSocket = new ServerSocket(6789);

		/*
		 * Create a loop to listen on several clients
		 * Otherwise, the socket will accept just one client
		 */
		while (true) {

			Socket connectionSocket = welcomeSocket.accept(); 			// Listen on socket for incoming connections
			System.out.println("Received a Connection from " 
						+ connectionSocket.getRemoteSocketAddress());	    // Print on Connection Receive
			
			/*
			 * Read a Request Message from Client
			 */
			InputStream IS = connectionSocket.getInputStream();
			InputStreamReader ISR = new InputStreamReader(IS);
			BufferedReader inFromClient = new BufferedReader(ISR);
			clientSentence = inFromClient.readLine();

			/*
			 * Capitalize Received Sentence
			 */
			capitalizedSentence = clientSentence.toUpperCase() + '\n';

			/*
			 * Send the Capitalized Message back to the Client
			 */
			OutputStream OS = connectionSocket.getOutputStream();
			DataOutputStream outToClient = new DataOutputStream(OS);
			outToClient.writeBytes(capitalizedSentence);
		}
	}
}
