import java.io.*;
import java.net.*;

/**
 * Mohamad-Jaafar NEHME
 * Cours "Client-Server" pour la Licence
 * Technique au Liban (Java Applications)
 * Chapter 2 - Exercise 3 - UDP Sockets
 * The Client sends a message  to a localhost
 * Server listening on port 9876. Thereafter,
 * the client receives the message capitalized.
 */

class UDPClient {
	
	public static void main(String args[]) throws Exception {
		
		try {
			// Define serverHostname by localhost
			String serverHostname = new String("127.0.0.1");

			// Define the destination port number (The server side)
			int destination_port = 9876;
			
			/*
			 *  If the number of arguments provided is more than 0
			 *  (there exists arguments), then consider the first
			 *  argument as the server host name.
			 */
			if (args.length > 0)
				serverHostname = args[0];

			// Define new InputStreamReader that reads from keyboard
			InputStreamReader ISR = new InputStreamReader(System.in);

			// Define new BufferedReader that reads from ISR (Consequently from keyboard)
			BufferedReader inFromUser = new BufferedReader(ISR);

			// Define new clientSocket
			DatagramSocket clientSocket = new DatagramSocket();

			// Define IPAddress of serverHostname (Which is here the localhost)
			InetAddress IPAddress = InetAddress.getByName(serverHostname);
			
			System.out.println("Attemping to connect to " + IPAddress+ ") via UDP port " + destination_port);
			
			// Create a buffer to send data via (The buffer size is 1024 bytes)
			byte[] sendData = new byte[1024];
			
			// Create a buffer to receive data via (The buffer size is 1024 bytes)
			byte[] receiveData = new byte[1024];
			
			System.out.print("Enter Message: ");
			
			// Read a message from keyboard into BufferedReader inFromUser
			String sentence = inFromUser.readLine();
			
			// Convert the message "sentence" from string into bytes
			sendData = sentence.getBytes();
			
			System.out.println("Sending data to " + sendData.length + " bytes to server.");
			
			/*
			 * Create the DatagramPacket to be sent, with
			 * identifying the destination IP address and port
			 */
			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, destination_port);
			
			// Send the message via clientSocket
			clientSocket.send(sendPacket);
			
			/*
			 *  Wait to receive the response from the server.
			 *  Create a DatagramPacket to put the received
			 *  packet in. The designed packet is of the same size
			 */
			DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
			
			System.out.println("Waiting for return packet");
			
			// Set the timeout to 10 seconds (10000 milliseconds)
			clientSocket.setSoTimeout(10000);
			
			try {
				
				// Receive Packet from Server via clientSocket
				clientSocket.receive(receivePacket);
				
				// Convert data bytes to String and put it in modifiedSentence
				String modifiedSentence = new String(receivePacket.getData());
				
				// Get the source IP of the packet header
				InetAddress returnIPAddress = receivePacket.getAddress();

				/*
				 * Get the source port from the packet header.
				 * This should be not necessarily the same port
				 * as the destination_port
				 */
				int source_port = receivePacket.getPort();
				
				System.out.println("From server at: " + returnIPAddress + ":"+ source_port);
				System.out.println("Message: " + modifiedSentence);
				
			} catch (SocketTimeoutException ste) {
				System.out.println("Timeout Occurred: Packet assumed lost");
			}
			
			// Close the socket
			clientSocket.close();
			
		} catch (UnknownHostException ex) {
			System.err.println(ex);
			
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}