import java.net.*;
import java.io.*;

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
public class Server extends Thread {
	
	// Declare Client Socket Variable
	// This variable is declared on each thread creation
	protected static ServerSocket serverSocket;
	private static int port = 2020;

	public static void main(String[] args) throws IOException {
		
		// Try is used to handle errors and print them
		try {
						
			// b) A socket of type ServerSocket is created on the port 2020.
			serverSocket = new ServerSocket(port);
			
			try {
				
	 			// Listen on socket for incoming connections
				// c) The server waits for a client connection request, then accepts it.
				Socket connectionSocket = serverSocket.accept();
			
				/*
				 * e) Once the client is connected, the server
				 * displays on the screen the following message:
				 * “Connection request received from xxx”,
				 * where xxx is the host name of the client.
				 */
				System.out.println("Connection request received from " 
							+ connectionSocket.getRemoteSocketAddress());
			
				/*
				 *  f) After that, the server sends the
				 *  message “Server > Welcome” to the client.
				 */

				// Define new PrintWriter and specify the output socket to write on
				PrintWriter out = new PrintWriter(connectionSocket.getOutputStream(), true);

				// Echo the message back to the same client.
				out.println("Server > Welcome");
								
				/*
				 * i) Finally, the server displays on the
				 * screen the message sent by the client.
				 */

				InputStream IS = connectionSocket.getInputStream();
				
				// Define new InputStreamReader that reads from echoSocket
				InputStreamReader ISR = new InputStreamReader(IS);

				// Define new BufferedReader that reads from ISR (Consequently from keyboard)
				BufferedReader stdIn = new BufferedReader(ISR);
				
				// While the server is sending messages, print them
				String inputLine = stdIn.readLine();
					
				// print the message coming from client in addition to his address
				System.out.println(inputLine);
				
				stdIn.close();
				
			/*
			 *  Catch/Handle errors and print on screen
			 *  "Accept failed." in case of any Accept error.
			 *  Exit with error 1.
			 */
			} catch (IOException e) {
				System.err.println("Accept failed.");
				System.exit(1);
			}
			
		/*
		 *  Catch/Handle errors if the port is in use, or 
		 *  any other cause that ban from listening on port.
		 *  Print error on screen and exit with error 1.
		 */
		} catch (IOException e) {
			System.err.println("Could not listen on port: " + port);
			System.exit(1);

		/*
		 *  Finally: is executed in all cases, Success or Failure
		 */
		} finally {
			
			try {
				
				// Close server socket
				serverSocket.close();
				
			} catch (IOException e) {
				
				System.err.println("Could not close port: " + port);
				System.exit(1);
			}
		}
	}
}