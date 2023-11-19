package Act4_3;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.HashSet;
public class Server {
    private static final int PORT = 1234; // Port sur lequel le serveur écoute
    private static byte [] buffer = new byte [1024]; // Tampon pour les données reçues
    private static HashSet<InetSocketAddress> clients = new HashSet<>(); // Ensemble pour stocker les adresses des clients connectés
    public static void main(String[] args) {
        try {	
            DatagramSocket serverSocket = new DatagramSocket(PORT);
            System.out.println("Démarrage du Serveur sur le port " + PORT);
            while (true) { // Boucle infinie pour accepter plusieurs clients
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                // Attends la réception d'un message d'un client
                serverSocket.receive(receivePacket);
                // Extrait le message et l'adresse du client expéditeur
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                InetSocketAddress senderAddress = new InetSocketAddress(receivePacket.getAddress(), receivePacket.getPort());

                
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
