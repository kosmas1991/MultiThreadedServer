import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {

	public static void main(String[] args) {
		try {
			boolean loop = false;
			ServerSocket server = new ServerSocket(8080);
			System.out.println("Waiting for clinets ...");
			while (!loop) {
				Socket socket = server.accept();
				System.out.println("Client connected! ");
				ThreadClient threadClient = new ThreadClient(socket);
				threadClient.start();
			}
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
