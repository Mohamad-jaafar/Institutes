import java.net.*;
import java.io.*;

/**
 * Solved By Mohamad-Jaafar NEHME
 * Cours "Consumer-Provider" pour la Licence
 * Technique au Liban (Java Applications)
 * 
 * The Lebanese Official Exams for the Academic year 2017
 * Second Session - Exercise 4
 * 
 * Question:
 * *********
 * Create two Java programs named Provider.java (server) and Consumer.java (client) that communicate with each other as specified bellow:											(10 pts)
 *      a. The server is called localhost.
 *      b. A socket of type ServerSocket is created on the port 2016.
 *      c. The server waits for a client connection request, then accept it.
 *      d. The client connects to the server.
 *      e. Once the client is connected, the server displays on the screen the following message: “Connection request received from xxx”, where xxx is the host name of the client.
 *      f. After that, the server sends the message “Server >YaHaLa” to the client.
 *      g. The client displays on the screen the message sent by the server.
 *      h. After that, the client sends the message “Client>Bye!” to the server.
 *      i. Finally, the server displays on the screen the message sent by the client.
 */
public class Provider extends Thread {
	
	// Declare Consumer Socket Variable
	// This variable is declared on each thread creation
	protected static ServerSocket serverSocket;
	private static int port = 2016;

	public static void main(String[] args) throws IOException {
		
		// b) A socket of type ServerSocket is created on the port 2020.
		serverSocket = new ServerSocket(port);
			
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
		 *  message “Provider > Welcome” to the client.
		 */

		// Define new PrintWriter and specify the output socket to write on
		PrintWriter out = new PrintWriter(connectionSocket.getOutputStream(), true);

		// Echo the message back to the same client.
		out.println("Server >YaHaLa");
						
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

		// Close server socket
		serverSocket.close();
	}
}