import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;

/*
 * Write a Ping-Pong client and server application using TCP sockets.
 * When a client sends a “ping” message to the server,
 * the server responds with a “pong” message.
 * Other messages sent by the client can be safely
 * dropped by the server. When a “boom” message is sent by the client,
 * both the client and the server stop and print the
 * number of messages sent and received on each side.   
 */

public class Server {

	// Declare Consumer Socket Variable
	// This variable is declared on each thread creation
	protected static ServerSocket serverSocket;
	private static int port = 2016;
	
	public static void main(String[] args) throws IOException {

		// A socket of type ServerSocket is created on the port 2020.
		serverSocket = new ServerSocket(port);
			
		// Listen on socket for incoming connections
		// The server waits for a client connection request, then accepts it.
		Socket connectionSocket = serverSocket.accept();
		
		// The server reads a message sent by the client.
		InputStream IS = connectionSocket.getInputStream();
		
		// Define new InputStreamReader that reads from echoSocket
		InputStreamReader ISR = new InputStreamReader(IS);
		
		// Define new BufferedReader that reads from ISR (Consequently from keyboard)
		BufferedReader stdIn = new BufferedReader(ISR);
		
		String inputLine;
		int counter = 0;

		while ((inputLine = stdIn.readLine())!= null){

			if (inputLine.equals("ping")){

				// Define new PrintWriter and specify the output socket to write on
				PrintWriter out = new PrintWriter(connectionSocket.getOutputStream(), true);

				// Echo the message back to the same client.
				out.println("pong");
				counter ++;
			}
			else if (inputLine.equals("boom")){

				break;
			}
			else {

				// Do nothing
			}
		}

		// print the message coming from client in addition to his address
		System.out.println("Ping is received: " + counter + " times");

		stdIn.close();

		// Close server socket
		serverSocket.close();
	}
}
