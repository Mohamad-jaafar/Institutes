
import java.net.*;

/**
 * Mohamad-Jaafar NEHME
 * Cours "Client-Server" pour la Licence
 * Technique au Liban (Java Applications)
 * Chapter 2 - Exercise 3 - UDP Sockets
 * The Server listens on port 9876 for Clients connections
 * The Server receives a text message from a Client, 
 * Capitalize it and resend it Capitalized to the Client.
 */

class UDPServer {
	
	public static void main(String args[]) throws Exception {
		
		try {

			// Define the destination port 9876 (The server side)
			int listening_port = 9876;
			
			// Define new serverSocket to listen on port 9876
			DatagramSocket serverSocket = new DatagramSocket(listening_port);

			// Create a buffer to receive data via (The buffer size is 1024 bytes)
			byte[] receiveData;

			/*
			 *  Create (Declare and initialize an array) a buffer
			 *  to send data via (The buffer size is 1024 bytes)
			 */
			byte[] sendData = new byte[1024];
			
			/*
			 *  Start listening without stop on the port
			 *  for any client connection
			 */
			while (true) {
				
				// Create a buffer receiveData of size 1024 bytes 
				receiveData = new byte[1024];

				/*
				 *  Wait to receive a message from a client.
				 *  Create a DatagramPacket to put the received
				 *  packet in. The designed packet is of the same size.
				 */
				DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
				System.out.println("Waiting for datagram packet");

				// Receive Packet from Client via serverSocket
				serverSocket.receive(receivePacket);

				// Convert data bytes to String and put it in sentence
				String sentence = new String(receivePacket.getData());

				// Get the source IP of the packet header
				InetAddress IPAddress = receivePacket.getAddress();

				/*
				 * Get the source port from the packet header.
				 * This should be not necessarily the same port
				 * as the listening_port
				 */
				int client_port = receivePacket.getPort();
				
				System.out.println("From: " + IPAddress + ":" + client_port);
				System.out.println("Message: " + sentence);
				
				// Capitalize the received message
				String capitalizedSentence = sentence.toUpperCase();
				
				// Convert the message "capitalizedSentence" from string into bytes
				sendData = capitalizedSentence.getBytes();
				
				/*
				 * Create the DatagramPacket to be sent, with
				 * identifying the destination IP address and port
				 */
				DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, client_port);

				// Send the message via serverSocket
				serverSocket.send(sendPacket);
			}
			
		// Catch Errors
		} catch (SocketException ex) {
			System.out.println("UDP Port 9876 is occupied.");
			System.exit(1);
		}
	}
}