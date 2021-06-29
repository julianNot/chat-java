package controller;

import model.ClientOne;
import model.ManagerMessages;
import view.View;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    private View view;
    private ManagerMessages managerMessages;
    private ArrayList<ClientOne> clients;

    public Controller() throws InterruptedException, IOException {
        view = new View();
        managerMessages = new ManagerMessages();
        clients = managerMessages.getClients();
        Thread.sleep(1000);
        menu();
    }

    private void menu() throws IOException {
        int option = view.ShowMenu();
        switch (option){
            case 1:
                //setMessage(view.clientDestiny(), view.message());
            case 2:
                //showMessage(view.clientDestiny());
                break;
            case 3:
                return;
        }
        menu();
    }


    /*public void setMessage(String clientDestiny, String message) throws IOException {
        for (ClientOne client : clients) {
            if (client
                    m.getIdClient().equals(clientDestiny)){
                client.sendingChat(message);
            }
        }
    }

    public void showMessage(String idClient){
//        ArrayList<ClientOne> clients = managerMessages.getClients();
        for (ClientOne client : clients) {
            if (client.getIdClient().equals(idClient)){
                int lastMessage = client.getInbox().size()-1;
                System.out.println(client.getInbox().get(lastMessage));
            }
        }
    }
*/
    public void showActiveClients(){
        int count = 0;
        for (int i = 0; i < managerMessages.getClients().size(); i++) {
            if (managerMessages.getClients().get(i).isAlive()){
                count++;
            }
        }
        System.out.println("Usuarios activos: " + count);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        new Controller();
    }
}
