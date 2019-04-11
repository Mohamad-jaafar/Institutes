import java.io.*;
import java.net.*;

/**
 * Mohamad-Jaafar NEHME
 * Cours "Client-Server" pour la Licence
 * Technique au Liban (Java Applications)
 * Chapter 2 - Exercise 3 - UDP Sockets
 * The Client Connects to a localhost Server
 * listening on port 10008 The Client sends a text message
 * to the Server and receives the message echoed.
 */

public class EchoClient {

	public static void main(String[] args) throws IOException {

		// Define the server host name.
		String serverHostname = new String("127.0.0.1");
		
		/*
		 *  If the number of arguments provided are more than 0
		 *  (there exists arguments), then consider the first
		 *  argument as the server host name.
		 */
		if (args.length > 0)
			serverHostname = args[0];

		System.out.println("Attemping to connect to host "
			+ serverHostname + " on port 10008.");
		
		// Define Socket, Reader and Writer
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		
		try {
			
			// Connect to server serverHostname on port 10008 
			echoSocket = new Socket(serverHostname, 10008);
			
			// Define new PrintWriter and specify the output socket to write on
			out = new PrintWriter(echoSocket.getOutputStream(), true);

			// Define new BufferedReader and specify the input socket to write on
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
			
		} catch (UnknownHostException e) {
			
			System.err.println("Don't know about host: " + serverHostname);
			System.exit(1);
			
		} catch (IOException e) {
			
			System.err.println("Couldn't get I/O for " + "the connection to: "	+ serverHostname);
			System.exit(1);
		}

		// Define new InputStreamReader that reads from keyboard
		InputStreamReader ISR = new InputStreamReader(System.in);

		// Define new BufferedReader that reads from ISR (Consequently from keyboard)
		BufferedReader stdIn = new BufferedReader(ISR);
		
		String userInput;
		System.out.println("Type Message (\"Bye.\" to quit)");
		
		/*
		 * While Client is typing in terminal (on keyboard),
		 * send them to the server
		 */
		while ((userInput = stdIn.readLine()) != null) {
			
			// Print what is read into the output socket
			out.println(userInput);
			
			// If the client types "Bye.", end the loop and close connections
			if (userInput.equals("Bye."))
				break;
			
			// Otherwise, print it back
			System.out.println("echo: " + in.readLine());
		}

		// Close sockets
		out.close();
		in.close();
		stdIn.close();
		echoSocket.close();
	}
}