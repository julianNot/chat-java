import model.ClientOne;
import model.DateConnection;
import model.ManagerMessages;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerChat extends Thread{

    private final ServerSocket serverSocket;
    private Socket socket;
    private boolean running;

    public ServerChat() throws IOException {
        int port = 12345;
        this.running = true;
        this.serverSocket = new ServerSocket(port);
    }

    public void run(){
        conecting();
    }

    /*public void entranceBridge() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        System.out.println(dataInputStream.readUTF());
    }*/

    public void conecting(){
        System.out.println("Chat-Java...");
        try {
            String idCLient, ip, message;

            DateConnection dateConnection;

            while (running) {

                System.out.println("Esperando conexion ...");
                socket = serverSocket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                dateConnection = (DateConnection) objectInputStream.readObject();
                idCLient = dateConnection.getIdClient();
                ip = dateConnection.getIp();
                message = dateConnection.getMessage();

                System.out.println(idCLient +" " + ip +" " + message);

                Socket sendInfo = new Socket(ip,4321);

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(sendInfo.getOutputStream());
                objectOutputStream.writeObject(dateConnection);

                objectOutputStream.close();

                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF("Conexion aceptada: " + socket.getInetAddress().getHostName());
            }
            serverSocket.close();
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Error de conexion: " + socket.getInetAddress().getCanonicalHostName());
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
