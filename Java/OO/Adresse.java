
public class Adresse {
	private String rue, numero, codePostal, ville;
	
	public Adresse(String rue, String numero, String codePostal, String ville){
		if (rue==null)throw new IllegalArgumentException("Veuillez entrer une rue valide.");
		if(numero == null)throw new IllegalArgumentException("Veuillez entrer un numéro valide.");
		if (codePostal == null)throw new IllegalArgumentException("Veuillez entrer un code postal valide.");
		if (ville == null)throw new IllegalArgumentException("Veuillez entrer une ville valide.");
		this.rue = rue;
		this.numero = numero;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String toString(){
		return "Habite "+rue+" "+numero+", "+codePostal+" "+ville;
	}
}
