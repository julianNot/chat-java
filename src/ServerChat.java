import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat extends Thread{

    private ServerSocket serverSocket;
    private Socket socket;
    private final int port;
    private boolean running;

    public ServerChat() throws IOException {
        this.port = 12345;
        this.running = true;
        this.serverSocket = new ServerSocket(port);
    }

    public void run(){
        conecting();
    }

    public void conecting(){
        System.out.println("Chat-Java...");
        try {
            while (running) {
                System.out.println("Esperando conexion ...");
                socket = serverSocket.accept();
                System.out.println("Se conectó : " + socket.getInetAddress().getHostName());
            }
        }catch (IOException e){
            System.out.println("Error de conexion: " + socket.getInetAddress().getHostName());
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
