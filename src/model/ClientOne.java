package model;

import view.View;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ClientOne extends Thread{

    private String ip;
    private int port;
    private Socket socket;
    private ServerSocket serverSocket;
    private View view;

    private ArrayList<String> inbox;


    public ClientOne() {
        this.ip = "localhost";
        this.port = 12345;
        this.inbox = new ArrayList<>();
        view = new View();
    }

    public void run(){
        connectingServer();
        try {
            serverSocket = new ServerSocket(4321);
            Socket client;

            DateConnection dateConnection;
            while (true){
                client = serverSocket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
                dateConnection = (DateConnection) objectInputStream.readObject();
                System.out.println(dateConnection.getIdClient() +" mensaje: "+ dateConnection.getMessage());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String conectingClient(String idClient){
        return idClient;
    }

    /*public void sendingChat(String message) throws IOException {

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF(message);
    }

    public void readChar() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        while (true){
            inbox.add(dataInputStream.readUTF());
        }
    }*/

    public void connectingServer()  {
        try {
            this.socket = new Socket(ip,port);
            DateConnection dates = new DateConnection();
            dates.setIdClient("julio");
            dates.setIp("127.0.0.1");
            dates.setMessage("hola");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(dates);

            socket.close();


            //DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            /*DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            System.out.println(dataInputStream.readUTF());*/

        } catch (IOException e) {
            System.out.println("Error de conexion con el servidor");
        }
    }

    public static void main(String[] args) {
        new ClientOne().start();
        //new ClientOne().start();
        //new ClientOne().start();
    }
}
