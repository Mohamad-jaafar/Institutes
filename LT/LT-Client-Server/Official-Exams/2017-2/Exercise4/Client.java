import java.io.*;
import java.net.*;

/**
 * Solved By Mohamad-Jaafar NEHME
 * Cours "Client-Server" pour la Licence
 * Technique au Liban (Java Applications)
 * 
 * The Lebanese Official Exams for the Academic year 2017
 * Second Session - Exercise 4
 * 
 * Question:
 * *********
 *   Create two Java programs named Server.java and Client.java that communicate with each other as specified below: 	(8 pts)
 *      a) The server is called localhost.
 *      b) A socket of type ServerSocket is created on the port 2020.
 *      c) The server waits for a client connection request, then accepts it.
 *      d) The client connects to the server.
 *      e) Once the client is connected, the server displays on the screen the following message: “Connection request received from xxx”, where xxx is the host name of the client.
 *      f) After that, the server sends the message “Server > Welcome” to the client.
 *      g) The client displays on the screen the message sent by the server.
 *      h) After that, the client sends the message “Client > Thank You!” to the server.
 *      i) Finally, the server displays on the screen the message sent by the client.
 */

public class Client {

	public static void main(String[] args) throws IOException {

		// Define the server host name.
		// a) The server is called localhost.
		String serverHostname = new String("localhost");
		int port = 2020;
		PrintWriter out = null;
		BufferedReader stdIn = null;
		
		/*
		 *  If the number of arguments provided are more than 0
		 *  (there exists arguments), then consider the first
		 *  argument as the server host name.
		 */
		if (args.length > 0)
			serverHostname = args[0];
		
		// Define Socket, Reader and Writer
		Socket echoSocket = null;
		
		try {
			
			// d) The client connects to the server.
			echoSocket = new Socket(serverHostname, port);

			/*
			 * g) The client displays on the screen
			 * the message sent by the server.
			 */

			InputStream IS = echoSocket.getInputStream();
			
			// Define new InputStreamReader that reads from echoSocket
			InputStreamReader ISR = new InputStreamReader(IS);

			// Define new BufferedReader that reads from ISR (Consequently from keyboard)
			stdIn = new BufferedReader(ISR);
			
			// While the server is sending messages, print them
			String inputLine = stdIn.readLine();
				
			// print the message coming from client in addition to his address
			System.out.println(inputLine);

			/* 
			 * h) After that, the client sends the message
			 * “Client > Thank You!” to the server.
			 */
			
			// Define new PrintWriter and specify the output socket to write on
			out = new PrintWriter(echoSocket.getOutputStream(), true);

			// Echo the message back to the same client.
			out.println("Client > Thank You!");
			
		} catch (UnknownHostException e) {
			
			System.err.println("Don't know about host: " + serverHostname);
			System.exit(1);
			
		} catch (IOException e) {
			
			System.err.println("Couldn't get I/O for " + "the connection to: "	+ serverHostname);
			System.exit(1);
		}

		// Close sockets
		out.close();
		stdIn.close();
		echoSocket.close();
	}
}