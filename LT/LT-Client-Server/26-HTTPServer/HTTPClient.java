import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.InetSocketAddress;

public class HTTPClient {
	
	public static void main(String[] args) throws Exception {
		
		// Server port
		int port = 8080;

		// Create Socket to Connect to Server
		Socket socket = new Socket();
		
		// autoFlush A boolean; if true, the println, printf, or format methods will flush the output buffer
		boolean autoflush = true;
		
		// Define localhost as the server, change it otherwise
		String host = "127.0.0.1";
		
		// Explained in previous exercises
		InetAddress addr = InetAddress.getByName(host);
		InetSocketAddress s = new InetSocketAddress(addr, port);
		socket.connect(s);

		// Explained in previous exercises as well
		PrintWriter out = new PrintWriter(socket.getOutputStream(), autoflush);
		InputStream IS = socket.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(IS));

		/*
		 *  Send GET HTTP request header to the web server
		 *  The header contains
		 *  (1) Request-Line and HTTP version
		 *  (2) Uniform Resource Identifiers
		 *  (3) Connection Status
		 *  (4) An Empty Line
		 *  A lot of other optional fields could be sent as well
		 */
		out.println("GET / HTTP/1.1");
		out.println("Host: " + host);
		out.println("Connection: Close");
		out.println();
		
		// Create a new string builder to read the response
		StringBuilder sb = new StringBuilder(8096);
		
		/*
		 * Reading RESPONSE
		 */
		
		// Wait until the reading is ready
		// Enter a loop until it gets ready
		// It would be better to create a handler
		while (!in.ready()) {}

		char chr = 0;
		
		try{
			// while not EOF (End Of File), read characters
			while (chr != -1) {
				
				/*
				 * The character read, as an integer in
				 * the range 0 to 65535 (0x00-0xffff),
				 * or -1 if the end of the stream has been reached.
				 * Convert to char by casting it 
				 */
				chr = (char) in.read();
				
				// Append the read char to StringBuilder "sb"
				sb.append(chr);
			}
		}catch(SocketException se){
			
		}
		
		// Print out the read RESPONSE
		System.out.println(sb.toString());
			
		socket.close();
	}
}