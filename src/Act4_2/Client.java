package Act4_2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
	private static final int PORT = 5000;
	private static byte[] buffer = new byte[1024];
	public static void main(String[] args) {
		try {
			// creation d'une socket
			DatagramSocket socket = new DatagramSocket(); 
			//Crée une nouvelle instance de la classe InetAddress  et lui attribue l'adresse IP correspondant au nom d'hôte "localhost".
			InetAddress inetAddress = InetAddress.getByName("localhost"); 
			String message = "qu'elle heure est-il?";
			//Envoyer les données au serveur.
			DatagramPacket sendPacket = new DatagramPacket(message.getBytes(), message.length(), inetAddress, PORT);
			//Envoie le paquet au serveur en utilisant la socket UDP créée précédemment.
			socket.send(sendPacket);
			//recevoir des données du serveur
			DatagramPacket r_Packet=new DatagramPacket(buffer,buffer.length);
			//utilise le socket UDP (socket) pour recevoir des données du serveur.
			socket.receive(r_Packet);
			//extrait les données reçues dans un paquet UDP (r_Packet) et les convertit en une chaîne de caractères :
			String reponse = new String(r_Packet.getData(),0,r_Packet.getLength());
			System.out.println("reponse du serveur:"+reponse);
			socket.close();// fermeture du socket
		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}


