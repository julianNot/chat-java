import java.io.IOException;
import java.net.Socket;

public class ClientOne extends Thread{

    private String ip;
    private int port;
    private Socket socket;

    public ClientOne() {
        this.ip = "localhost";
        this.port = 12345;
    }

    public void run(){
        connectingServer();
    }

    public void connectingServer()  {
        try {
            this.socket = new Socket(ip,port);
            System.out.println("Conectado con el servidor");
        } catch (IOException e) {
            System.out.println("Erro de conexion con el servidor");
        }
    }

    public static void main(String[] args) {
        new ClientOne().start();
    }
}
