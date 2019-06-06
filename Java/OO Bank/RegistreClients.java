import java.util.ArrayList;

public class RegistreClients {
	private ArrayList<Client> clients;
	
	public RegistreClients(){
		this.clients = new ArrayList<Client>();
	}
	
	public boolean ajouter(Client client){
		return clients.add(client);
	}
	
	public boolean retirer(Client client){
		return clients.remove(client);
	}
	
	public Client rechercher(String numRegistre){
		for (Client client : clients) {
			if (client.getNumeroRegistreNational().equals(numRegistre))
				return client;
		}
		return null;
	}

	public int nombreClient(){
		return clients.size();
	}

	@Override
	public String toString() {
		return "RegistreClients [clients=" + clients + "]";
	}
}