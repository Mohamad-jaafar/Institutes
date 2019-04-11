import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

public class DateClient {
	
	/**
	 * Runs the client as an application. First it displays a dialog box asking
	 * for the IP address or hostname of a host running the date server, then
	 * connects to it and displays the date that it serves.
	 */
	
	public static void main(String[] args) throws IOException {

		// Define the port number (The server side)
		int port = 9090;
		
		// Ask for the Server Address
		String serverAddress = JOptionPane
				.showInputDialog("Enter IP Address of a machine that is\n"
						+ "running the date service on port " + port + ": ");
		
		// Create a new socket to connect to server
		Socket s = new Socket(serverAddress, port);

		// Point to the InputStream of the socket and name it "ISR"
		InputStreamReader ISR = new InputStreamReader(s.getInputStream());
		
		// BufferedReader puts the character-based InputStreams into Buffer
		BufferedReader input = new BufferedReader(ISR);
		
		// Read line from socket via input via ISR.
		String answer = input.readLine();
		
		// Show answer in a dialog box
		JOptionPane.showMessageDialog(null, answer);
		
		// Exit normally (Without errors)
		System.exit(0);
	}
}