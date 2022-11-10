package robotwar.communication;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer implements Runnable {
	private final int PORT_NUMBER = 5555;
	private boolean listening;
	private DataOutputStream out;
	
	public SocketServer() {
		listening = true;
	}
	
	public void startListening() {
		Thread t = new Thread(this);
		t.start();
	}
	
	public void stopListening() {
		listening = false;
		
	}
	
	public void run() {
		try {
			// este es el server especifico que escucha los entrantes
			ServerSocket socketListener = new ServerSocket(PORT_NUMBER);
			
			while (listening) {
				
				// la conexion del que se acaba de conectar
				Socket connection = socketListener.accept();
				SocketClient client = new SocketClient(connection);
				out = new DataOutputStream (client.getBinOutput());
				out.writeUTF("YO SE QUE EN EL AMOR SOY UN FARSANTE, BEBE");
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
