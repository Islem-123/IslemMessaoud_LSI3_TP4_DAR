package Act4_1;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
	//spécifier le port sur lequel le serveur écoutera les connexions entrantes.
	private static final int PORT = 1234;
	//un tableau de bytes'receiveData' pour stocker les données reçues du client. 
	private static byte[] receiveData = new byte[1024]; 
	public static void main(String[] args) {
		try {
			//Socket sur lequel le serveur écoutera les connexions entrantes.
			DatagramSocket socket = new DatagramSocket(PORT);
			System.out.println("Demarrage du serveur:");
			while (true) {
				//Il sera utilisé pour stocker les données reçues du client. Il utilise le tableau receiveData comme tampon de réception et spécifie sa longueur.
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 																			
				//permet d'attendre et de recevoir un paquet de données du client																					
				socket.receive(receivePacket); 
				//Extrait les données brutes du paquet reçu, les convertit en une chaîne de caractères et les stocke dans la variable message.
				String message = new String(receivePacket.getData(), 0, receivePacket.getLength()); 
				System.out.println(receivePacket.getAddress() + " : " + message);
				String reponse = "Bienvenue " + message;
				DatagramPacket sendPacket = new DatagramPacket(reponse.getBytes(), reponse.length(), receivePacket.getAddress(),receivePacket.getPort());
				socket.send(sendPacket); // envoit du reponse au client*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}










