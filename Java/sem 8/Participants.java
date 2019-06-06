/**
 * 
 * @author Janssens Thibaut - IPL - 10/11/2015
 *
 */
public class Participants {

	private String[] tableParticipants; // table contenant les noms des
										// participants. TABLE SANS TROU!

	private int nombreInscrits; // taille logique

	// Les nombreInscrits participants occupent les nombreInscrits premieres
	// cases du tableau!

	public Participants(int nombreMaxParticipants) {
		this.tableParticipants = new String[nombreMaxParticipants];
		this.nombreInscrits = 0;
	}

	/**
	 * Construit un objet Participants en copiant tous les participants a partir de la table passee en parametre.
	 * @param tableARecopier table contenant les participants a ajouter
	 */
	public Participants(int nombreParticipants, String[] tableARecopier) {
		// A NE PAS MODIFIER
		// VA SERVIR POUR LES TESTS
		if (nombreParticipants < tableARecopier.length)
			throw new IllegalArgumentException();
		this.tableParticipants = new String[nombreParticipants];
		this.nombreInscrits = tableARecopier.length;
		for (int i = 0; i < nombreInscrits; i++)
			this.tableParticipants[i] = tableARecopier[i];
	}

	public String toString() {
		// A NE PAS MODIFIER
		// VA SERVIR POUR LES TESTS
		if(this.nombreInscrits==0)
			return"aucun inscrit";
		String aRenvoyer = "\nLes inscrits :";
		for (int i = 0; i < nombreInscrits; i++)
			aRenvoyer = aRenvoyer + "\n    " + this.tableParticipants[i];
		return aRenvoyer;
	}

	public int getNombreInscrits() {
		return this.nombreInscrits;
	}

	/**
	 * Ajoute un participant a la table des participants. On peut retrouver
	 * plusieurs fois le meme nom.
	 * 
	 * @param participant
	 * @return false si le nombre maximum de participants est atteint, true
	 *         sinon
	 */
	public boolean ajouterUnParticipant(String participant) {
		if (nombreInscrits >= tableParticipants.length)
			return false;
		else{
			tableParticipants[nombreInscrits] = participant;
			nombreInscrits ++;
			return true;
		}
	}

	/**
	 * Supprime le participant passe en parametre Si le nom se trouve plusieurs
	 * fois, on ne le supprime qu'une fois
	 * @param participant Le participant a supprimer
	 * @return false si la suppression n'a pas pu etre faite car la table ne contient pas le participant, true sinon
	 */
	public boolean supprimerUnParticipant(String participant) {
		if(nombreInscrits == 0) 
			return false;
		
		if(!contient(participant))
			return false;
		
		else{
			for (int i = 0; i<nombreInscrits; i++){
				if (tableParticipants[i].compareTo(participant) == 0){
					tableParticipants[i] = tableParticipants[nombreInscrits-1];
					nombreInscrits --;
					return true;
				}
			}
			return false;
		}
	}

	
	/**
	 * Verifie si la table contient le participant passe en parametre
	 * @param participant Le participant recherche
	 * @return true si le participant est present dans la table, false sinon
	 */
	public boolean contient(String participant) {
		for (int i = 0; i < nombreInscrits; i++){
			if (tableParticipants[i].compareTo(participant) == 0)
				return true;
		}
		return false;
	}
	
	/**
	 * Supprime le participant passe en parametre autant de fois qu'il y est
	 * @param Participant
	 * @return le nombre de suppressions effectuees
	 */
	public int supprimerTousLesParticipants(String participant) { 
		int nbreSuppression = 0;
		
		if (!contient(participant))
			return 0;
		
		for (int i = 0; i < nombreInscrits ; i++){
			while (nombreInscrits > 0 && tableParticipants[nombreInscrits-1].compareTo(participant) == 0){
				nombreInscrits --;
				nbreSuppression ++;
			}
			if (supprimerUnParticipant(participant))
				nbreSuppression ++;
		}
		return nbreSuppression;
	}

	/**
	 * Verifie si la table est triee par ordre alphabetique
	 * @return true si la table est triee, false sinon
	 */
	public boolean estTrie() {
		for (int i = 0; i < nombreInscrits - 1; i++){ 
			if(tableParticipants[i].compareTo(tableParticipants[i+1])>0)
				return false;
		}
		return true;
	}

	/**
	 * Verifie si la table contient des ex-aequos
	 * @return true si la table contient des ex-aequos, false sinon
	 */
	public boolean contientExAequo() {
		String participantTest;
		for (int i = 1; i < nombreInscrits; i++){
			for (int j = 0; j < nombreInscrits; j++){
				participantTest = tableParticipants[i];
				if (participantTest.compareTo(tableParticipants[i]) == 0)
					return true;
			}
		}
		return false;
	}

	/**
	 * Supprime tous les ex-aequos, en gardant un exemplaire de chaque
	 * @return le nombre de suppressions effectuees
	 */
	public int supprimerTousLesExAequos() { 
		int nbreSuppression = 0;
		String original = "";
		
		if (!contientExAequo())
			return 0;
	
		for (int i = nombreInscrits-1; i > 0; i--){
			original = tableParticipants[i];
			nbreSuppression += supprimerTousLesParticipants(original) - 1;
			ajouterUnParticipant(original);
		}
		return nbreSuppression;
	}
}