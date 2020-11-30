import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadClient extends Thread {
	private Socket socket;
	public ThreadClient(Socket socket) {
		this.socket=socket;
	}
	public void run() {
		try {
			PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
			output.println("Hello Malakidi");
			output.println("Grapse mou kati");
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String clientSays = input.readLine();
			System.out.println("O clinet leei " + clientSays);
			output.close();
			input.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
