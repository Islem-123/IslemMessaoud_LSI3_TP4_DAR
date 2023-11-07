package Act4_2;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
	//spécifier le port sur lequel le serveur écoutera les connexions entrantes.
	private static final int PORT = 5000;
	//un tableau de bytes'buffer' pour stocker les données reçues du client. 
	private static byte[] buffer = new byte[1024]; 
	public static void main(String[] args) {
		try {
			//Socket sur lequel le serveur écoutera les connexions entrantes.
			DatagramSocket socket = new DatagramSocket(PORT);
			System.out.println("Demarrage du serveur:");
			while (true) {
				//Il sera utilisé pour stocker les données reçues du client. Il utilise le tableau receiveData comme tampon de réception et spécifie sa longueur.
				DatagramPacket r_Packet = new DatagramPacket(buffer, buffer.length); 																			
				//permet d'attendre et de recevoir un paquet de données du client																					
				socket.receive(r_Packet); 
				//Extrait les données brutes du paquet reçu, les convertit en une chaîne de caractères et les stocke dans la variable message.
				String message = new String(r_Packet.getData(), 0, r_Packet.getLength()); 
				//une fonction getCurrentTime() pour obtenir l'heure actuelle au format "yyyy-MM-dd HH:mm:ss"
				String currentTime = getCurrentTime();		
				DatagramPacket sendPacket = new DatagramPacket(currentTime.getBytes(), currentTime.length(), r_Packet.getAddress(),r_Packet.getPort());
				socket.send(sendPacket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
public static String getCurrentTime() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date currentDate = new Date();
    return dateFormat.format(currentDate);
}}