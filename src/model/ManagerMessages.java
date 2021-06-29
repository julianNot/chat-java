package model;

import view.View;

import java.util.ArrayList;

public class ManagerMessages {
    private final ArrayList<ClientOne> clients;

    public ManagerMessages() {
        this.clients = new ArrayList<>();
        clients();
        startClients();
    }

    public void clients(){
        this.clients.add(new ClientOne());
        this.clients.add(new ClientOne());
        this.clients.add(new ClientOne());
        this.clients.add(new ClientOne());
        this.clients.add(new ClientOne());
    }

    /*PRUEBA*/
    public void conectClient(ClientOne client) {
        clients.add(client);
        client.start();
    }

    public void startClients(){
        for (ClientOne client : clients) {
            client.start();
        }
    }

   /* public String sendMessage(String nameClient, String message){
        String status = "";
        for (ClientOne client : clients) {
            if (client.getIdClient().equals(nameClient)){
                if (client.isAlive()){
                    client.inbox(message);
                    status = "enviado";
                }else {
                    status = "no enviado";
                }
            }
        }
        return status;
    }*/

    public ArrayList<ClientOne> getClients() {
        return clients;
    }

    /*public static void main(String[] args) {
        new ManagerMessages();

    }*/

}
