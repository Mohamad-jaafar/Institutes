import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer {
	
	public static void main(String[] args) {
		
		try {
			
			int port = 8080;
			System.out.println("\n\n\t\tThe HTTP Server is running..");
			System.out.println("\n\n\t\tStop server using Ctrl + C");

			// Explained in previous exercises
			ServerSocket soc = new ServerSocket(port);
			Socket inSoc = soc.accept();

			HTTPRequest request;
			try {
				/*
				 * Create a new HTTPRequest instance. The
				 * Class is explained in its file
				 */
				request = new HTTPRequest(inSoc);
				
				// Run the "process" function in the HTTPRequest class.
				request.process();
				
			} catch (Exception ex) {
				
				System.out.println("Error1");
			}
			
		} catch (IOException ex) {
			
			/*
			 * Unable to reserve port. Almost it means
			 * that the port is in use.
			 */
			System.out.println("Unable to reserve port");
		}
	}
}