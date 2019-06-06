import java.util.Arrays;
import java.util.stream.Stream;

public class Matrice {
	private final int nbLignes; // nombre de lignes
	private final int nbColonnes; // nombre de colonnes
	private final double[][] data; // matrice (nbLignes,nbColonnes)

	// ce constructeur cree la matrice nulle de genre (a,b)
	public Matrice(int a, int b) throws IllegalArgumentException {
		if (a <= 0 || b <= 0)
			throw new IllegalArgumentException();

		this.nbLignes = a;
		this.nbColonnes = b;
		this.data = new double[nbLignes][nbColonnes];
	}

	// Ce constructeur permet de construire la matrice correspondant
	// au tableau en parametre.
	public Matrice(double[][] tab) throws IllegalArgumentException {
		if (tab == null || tab.length == 0 || tab[0] == null || tab[0].length == 0)
			throw new IllegalArgumentException();

		this.nbLignes = tab.length;
		this.nbColonnes = tab[0].length;
		for (int i = 1; i < tab.length; i++) {
			if (tab[i] == null || tab[i].length != nbColonnes)
				throw new IllegalArgumentException();
		}

		this.data = new double[nbLignes][nbColonnes];
		for (int k = 0; k < nbLignes; k++) {
			for (int l = 0; l < nbColonnes; l++) {
				data[k][l] = tab[k][l];
			}
		}
	}

	// constructeur par recopie
	public Matrice(Matrice a) throws IllegalArgumentException {
		if (a == null)
			throw new IllegalArgumentException();
		this.nbLignes = a.nbLignes;
		this.nbColonnes = a.nbColonnes;
		this.data = new double[nbLignes][nbColonnes];

		for (int k = 0; k < a.nbLignes; k++) {
			for (int l = 0; l < a.nbColonnes; l++) {
				this.data[k][l] = a.data[k][l];
			}
		}
	}

	// cree la matrice identite d'ordre a
	public static Matrice identite(int a) throws IllegalArgumentException {
		if (a <= 0)
			throw new IllegalArgumentException();

		Matrice mat = new Matrice(a, a);

		for (int i = 0; i < a; i++) {
			mat.data[i][i] = 1;
		}

		return mat;
	}

	// Cette methode renvoie l'element de la ligne numLigne et de la
	// colonne numColonne de la matrice. Si cet element n'existe pas, la
	// methode lance une IllegalArgumentException
	public double getElement(int numLigne, int numColonne) throws IllegalArgumentException {
		if (numLigne <= 0 || numLigne > this.nbLignes || numColonne <= 0 || numColonne > this.nbColonnes)
			throw new IllegalArgumentException();
		return this.data[numLigne - 1][numColonne - 1];
	}

	// ajoute b a la matrice courante si c'est possible
	public Matrice somme(Matrice b) throws IllegalArgumentException {
		if (b == null)
			throw new IllegalArgumentException();
		if (b.nbLignes != this.nbLignes || b.nbColonnes != this.nbColonnes)
			throw new IllegalArgumentException();
		Matrice mat = new Matrice(this.nbLignes, this.nbColonnes);
		for (int i = 0; i < b.nbLignes; i++) {
			for (int j = 0; j < b.nbColonnes; j++) {
				mat.data[i][j] = data[i][j] + b.data[i][j];
			}
		}
		return mat;
	}

	// calcule le produit scalaire.this de la matrice courante avec scalaire
	public Matrice produitParScalaire(double scalaire) {
		Matrice mat = new Matrice(this.data);
		for (int i = 0; i < mat.nbLignes; i++) {
			for (int j = 0; j < mat.nbColonnes; j++) {
				mat.data[i][j] *= scalaire;
			}
		}
		return mat;
	}

	// calcule le produit this*b de la matrice courante avec b si possible
	public Matrice produitAGauche(Matrice b) throws IllegalArgumentException {
		if (b == null)
			throw new IllegalArgumentException();
		if (this.nbColonnes != b.nbLignes)
			throw new IllegalArgumentException();
		Matrice mat = new Matrice(this.nbLignes, b.nbColonnes);
		for (int i = 0; i < this.nbLignes; i++) {
			for (int j = 0; j < b.nbColonnes; j++) {
				for (int k = 0; k < this.nbColonnes; k++) {
					mat.data[i][j] += this.data[i][k] * b.data[k][j];
				}
			}
		}
		return mat;
	}

	// calcule le produit b*this de b avec la matrice courante si possible
	public Matrice produitADroite(Matrice b) throws IllegalArgumentException {
		if (b == null)
			throw new IllegalArgumentException();
		Matrice mat = b.produitAGauche(this);
		return mat;
	}

	// renvoie true si la matrice courante est carree
	public boolean carree() {
		return this.nbLignes == this.nbColonnes;
	}

	// Calcule this^n. Lance une Mathexception si this n'est pas carree
	public Matrice puissance(int n) throws IllegalArgumentException {
		if (!this.carree())
			throw new MathException();
		if (n < 0)
			throw new IllegalArgumentException("lol nope.");
		Matrice mat = identite(this.nbLignes);
		for (int i = 0; i < n; i++) {
			mat = this.produitADroite(mat);
		}
		return mat;
	}

	// affiche la matrice en format standard
	public String toString() {
		String res = "";
		for (int i = 0; i < nbLignes; i++) {
			for (int j = 0; j < nbColonnes; j++) {
				res += this.data[i][j] + "\t\t";
			}
			res += "\n";
		}
		return res;
	}
	
	   public Matrice pageRank(){
	    	if(!this.carree()) throw new MathException();
	    	
	    	
	    	//verification que des 1 et des 0
	    	for(int i = 0 ; i < this.nbLignes; i ++){
	    		for(int j = 0 ; j < this.nbColonnes ; j++){
	    			if(this.data[i][j] != 0 && this.data[i][j] != 1)
	    				throw new MathException();
	    		}
	    	}
	    	
	    	//Matrice de transition
	    	Matrice matriceT = new Matrice(this.nbLignes, this.nbColonnes);
	    	int somme;
	    	int nbElement;
	    	for(int i = 0 ; i < this.nbColonnes ; i ++){
	    		somme = 0;
	    		nbElement = 0;
	    		for(int j = 0 ; j < this.nbLignes ; j ++){
	    			somme+=this.data[j][i];
	    			if(this.data[j][i] == 1)
	    				nbElement++;
	    		}
	    		if(somme == 0){
	    			for(int k = 0 ; k < this.nbLignes ; k++)
	    				matriceT.data[k][i] =(double) 1/this.nbLignes;
	    		}
	    		else{
	    			for(int l = 0 ; l < this.nbLignes ; l++){
	    				if(this.data[l][i] == 1)
	    					matriceT.data[l][i] =(double) 1/nbElement;
	    			}
	    		}
	    	}
	    	
	    	
	    	//Matrice google
	    	Matrice matriceG = new Matrice(this.nbLignes, this.nbColonnes);
	    	Matrice matriceRandom = new Matrice(this.nbLignes, this.nbColonnes);
	    	for(int i = 0 ; i < this.nbLignes ; i ++){
	    		for(int j = 0 ; j < this.nbColonnes ; j++){
	    			matriceRandom.data[i][j] = (double) 1/this.nbLignes;
	    		}
	    	}
	    	matriceG = matriceT.produitParScalaire(0.85).somme(matriceRandom.produitParScalaire(0.15));
	    	
	    	//Matrice d'état initial
	    	Matrice matriceI = new Matrice(this.nbLignes, 1);
	    	for(int i = 0 ; i < this.nbLignes ; i++){
	    		matriceI.data[i][0] = (double) 1/this.nbLignes;
	    	}
	    	
	    	//théorème de convergence
	    	Matrice matriceConverg = new Matrice(this.nbLignes, this.nbColonnes);
	    	matriceConverg = matriceG.produitAGauche(matriceI);
	    	//normalisation
	    	double total = 0;
	     	for(int i = 0 ; i < 85; i ++){
	    		total = 0;
	    		for (int j = 0; j < matriceConverg.nbLignes; j++) {
	        		total += matriceConverg.data[j][0];
	    		}
	        	for (int j = 0; j < matriceConverg.nbLignes; j++) {
	        		matriceConverg.data[j][0] = (double) matriceConverg.data[j][0]/total;
	    		}
	        	matriceConverg = matriceG.produitAGauche(matriceConverg);
	    	}
	    	return matriceConverg;
	    }
}