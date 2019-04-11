import java.net.*;
import java.io.*;
import java.util.*;

public class HTTPRequest {
	
	private Socket ClientConn;
	private String filepath;

	// Class Constructor
	public HTTPRequest(Socket ClientConn) throws Exception {
		
		// Define the Global Variable socket ClientConn
		this.ClientConn = ClientConn;
		filepath = "D:\\Teaching\\index.html";
	}

	/*
	 * Function process, the core of the server.
	 * Reads REQUEST from Client and sends back
	 * a RESPONSE.
	 */
	public void process() throws Exception {

		// Explained in previous exercises
		DataInputStream DIN = new DataInputStream(ClientConn.getInputStream());
		OutputStream ot = ClientConn.getOutputStream();
		BufferedOutputStream out = new BufferedOutputStream(ot);
		
		// Define InputStream "fin" that reads from file
		FileInputStream fin = null;
			
		try {

			// "fin" reads a file on the path "filepath"
			fin = new FileInputStream(filepath);
			
		} catch (Exception ex) {
			
			System.out.println("Cannot open file");
			System.out.println(ex.getMessage());
		}
		
		// Define some header variables
		String StatusLine = "HTTP/1.0 200 OK\n";;
		String ContentTypeLine = "Content-type:text/html\n";;
		String ContentLengthLine = "Content-Length: " + (new Integer(fin.available()).toString()) + "\n";;
		String NewLine = "\n";

		// Write the header to the socket
		out.write(StatusLine.getBytes(), 0, StatusLine.length());
		out.write(ContentTypeLine.getBytes(), 0, ContentTypeLine.length());
		out.write(ContentLengthLine.getBytes(), 0, ContentLengthLine.length());
		out.write(NewLine.getBytes(), 0, NewLine.length());

		byte[] buffer = new byte[1024];
		int bytes = 0;

		/*
		 *  While not EOF, read from file buffer amount
		 *  Moving cursor is done automatically by the
		 *  read function
		 */
		while ((bytes = fin.read(buffer)) != -1) {

			// Write from buffer into out socket
			out.write(buffer, 0, bytes);
		}
		
		fin.close();
		out.close();
		ClientConn.close();
	}
}
