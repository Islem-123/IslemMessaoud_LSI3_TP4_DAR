package Act4_1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
	private static final int PORT = 1234;
	private static byte[] buffer = new byte[1024];
	public static void main(String[] args) {
		try {
			// creation d'une socket
			DatagramSocket socket = new DatagramSocket(); 
			//crée une nouvelle instance de la classe InetAddress  et lui attribue l'adresse IP correspondant au nom d'hôte "localhost".
			InetAddress inetAddress = InetAddress.getByName("localhost"); 
			Scanner scanner = new Scanner(System.in);
			System.out.println("Ecrivez votre nom et prénom: ");
			String msg = scanner.nextLine();
			// utilisée pour préparer et envoyer des données via le protocole UDP.
			DatagramPacket sendPacket = new DatagramPacket(msg.getBytes(), msg.length(), inetAddress, PORT);
			socket.send(sendPacket); // envoit du datagram au serveur
			// reçoit du reponse
			DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
			socket.receive(receivePacket); // la reception du datagram envoyer par le serveur
			String reponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
			System.out.println(" reponse du serveur :" + reponse);
			socket.close();// fermeture du socket
		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}






