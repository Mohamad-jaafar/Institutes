import java.net.*;
import java.io.*;

/**
 * Mohamad-Jaafar NEHME
 * Cours "Client-Server" pour la Licence
 * Technique au Liban (Java Applications)
 * Chapter 2 - Exercise 3 - TCP Sockets.
 * The Server listens on port 10008 for several simultaneous Clients.
 * The Server receives text messages from each Client,
 * and echo it back to the client.
 */

public class EchoServer extends Thread {
	
	// Declare Client Socket Variable
	// This variable is declared on each thread creation
	protected Socket clientSocket;

	public static void main(String[] args) throws IOException {

		// Define Server Socket Variable
		ServerSocket serverSocket = null;
		
		// Try is used to handle errors and print them
		try {
			
			// Initialize Server Socket Variable and bind it on port 10008
			serverSocket = new ServerSocket(10008);

			// Print on screen "Connection Socket Created"
			System.out.println("Connection Socket Created");
			
			try {

				/*
				 * Create a loop to listen on several clients.
				 * Otherwise, the socket will accept just one client.
				 */
				while (true) {
					System.out.println("Waiting for Connection");
					
					/*
					 * Create a new thread for each client
					 * The serverSocket acts like temporary socket.
					 * On new accept, clientSocket = serverSocket;
					 */
					new EchoServer(serverSocket.accept());
				}
			
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
		 *  any other cause that ban from listening on port
		 *  10008. Print error on screen and exit with error 1.
		 */
		} catch (IOException e) {
			System.err.println("Could not listen on port: 10008.");
			System.exit(1);

		/*
		 *  Finally: is executed in all cases, Success or Failure
		 */
		} finally {
			
			try {
				
				// Close server socket
				serverSocket.close();
				
			} catch (IOException e) {
				
				System.err.println("Could not close port: 10008.");
				System.exit(1);
			}
		}
	}

	/*
	 * Define EchoServer Constructor
	 * The echo server is in charge of creating
	 * a new thread for each client socket.
	 */
	private EchoServer(Socket clientSoc) {

		// Initialize Client Socket Variable
		clientSocket = clientSoc;
		
		// Start the new thread
		start();
	}

	/*
	 * Override Method run (Thread.run)
	 * This method runs for every thread (For every client
	 * connection) simultaneously.
	 */
	public void run() {
		
		System.out.println("New Communication Thread Started");
		
		try {

			// Define a pipe to read from client
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			// Define a pipe to write to client
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			
			String inputLine;
			
			/*
			 *  While the client is sending messages, print
			 *  them in addition to his address. Then, echo
			 *  the message back to the same client.
			 */
			while ((inputLine = in.readLine()) != null) {
				
				// print the message coming from client in addition to his address
				System.out.println("Client (" 
						+ clientSocket.getInetAddress().getHostName() + " - " +
						clientSocket.getRemoteSocketAddress() + "): " + inputLine);
				
				// Echo the message back to the same client.
				out.println(inputLine);
				
				// If the client sends "Bye.", stop reading and close sockets
				if (inputLine.equals("Bye."))
					break;
			}

			// Close sockets
			out.close();
			in.close();
			clientSocket.close();
			
		} catch (IOException e) {
			System.err.println("Problem with Communication Server");
			System.exit(1);
		}
	}
}