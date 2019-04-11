import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * A TCP server that runs on port 9090. When a client connects, it sends the
 * client the current date and time, then closes the connection with that
 * client. Arguably just about the simplest server you can write.
 */
public class DateServer {
	
	public static void main(String[] args) throws IOException {

		// Define the port number to listen on (The server side)
		int port = 9090;
		
		// Create server socket and bind it on port 9090
		ServerSocket listener = new ServerSocket(port);
		
		try {
			
			// Keep waiting for client connections until aborted
			while (true) {
				
				// Listen on port for incoming connections from client
				Socket socket = listener.accept();
				
				try {
					
					// Point to the OutputStream of the socket and name it "out"
					// OutputStream: Output stream of bytes
					PrintWriter out = new PrintWriter(socket.getOutputStream(),	true);
					
					// Write date to output socket via out
					out.println(new Date().toString());
					
				} finally {

					// Close socket after finish in all cases (Success or failure)
					socket.close();
				}
			}
			
		} finally {
			
			// Close socket after finish in all cases (Success or failure)
			listener.close();
		}
	}
}