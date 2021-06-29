package view;

import java.util.Scanner;

public class View {

    private Scanner scanner;


    public View() {
        scanner = new Scanner(System.in);
    }

    public int ShowMenu(){
        System.out.println("====Chat-Java=====");
        System.out.println("1. enviar mensaje (usuario destino, mensaje) \n 2. Ver mensaje (quien eres) \n 3. salir");
        return Integer.parseInt(scanner.nextLine());
    }

    public String clientDestiny(){
        return scanner.nextLine();
    }

    public String message(){
        return scanner.nextLine();
    }

    public String setIp() {
        return scanner.nextLine();
    }

   /* public String setMessage(String clientDestiny, String message){
        for (ClientOne client : clients) {
            if (client.getIdClient().equals(clientDestiny)){
                client.addToInbox(message);
            }
        }
        return "Mensaje: " + scanner.nextLine();
    }*/

    /*public void showMessage(String idClient){
//        ArrayList<ClientOne> clients = managerMessages.getClients();
        for (ClientOne client : clients) {
            if (client.getIdClient().equals(idClient)){
                int lastMessage = client.getInbox().size()-1;
                System.out.println(client.getInbox().get(lastMessage));
            }
        }
    }*/



}
