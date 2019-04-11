import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * Write a Ping-Pong client and server application using TCP sockets.
 * When a client sends a “ping” message to the server,
 * the server responds with a “pong” message.
 * Other messages sent by the client can be safely
 * dropped by the server. When a “boom” message is sent by the client,
 * both the client and the server stop and print the
 * number of messages sent and received on each side.   
 */

public class Client {

	public static void main(String[] args) throws IOException{

		// Define the server host name.
		// a) The server is called localhost.
		String serverHostname;
		int port = 2016;
		PrintWriter out = null;
		
		/*
		 *  If the number of arguments provided are more than 0
		 *  (there exists arguments), then consider the first
		 *  argument as the server host name.
		 */
		if (args.length > 0)
			serverHostname = args[0];
		else serverHostname = new String("localhost");
		
		// Define Socket, Reader and Writer
		Socket echoSocket = null;
			
		// d) The client connects to the server.
		echoSocket = new Socket(serverHostname, port);
		
		// Define new PrintWriter and specify the output socket to write on
		out = new PrintWriter(echoSocket.getOutputStream(), true);

		// Echo the message back to the same client.
		Scanner in = new Scanner (System.in);
		String text;
		while ((text = in.nextLine()) != null){

			out.println(text);
			if (text.equals("boom")){

				break;
			}
		}
		
		// Close sockets
		out.close();
		echoSocket.close();
	}
}
