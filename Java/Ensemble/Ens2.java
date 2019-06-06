public class Ens2 extends EnsembleAbstrait {

	private Elt[] elements; // contient les elements de l'ensemble. Il ne peut pas y avoir de doublon.
	private int cardinal;

	public Ens2() {
		this.elements = new Elt[MAX];
		this.cardinal = 0;
	}
	
	public Ens2(EnsembleInterface a){
		if(a == null) throw new IllegalArgumentException();
		this.elements = new Elt[MAX];
		this.cardinal = 0;
		for(int i=1; i < MAX+1;i++){
			if(a.contient(new Elt(i)))
				this.ajouter(new Elt(i));
		}
	}
	
	public Ens2(Elt e){
		if (e == null) throw new IllegalArgumentException();
		this.cardinal=0;
		this.elements = new Elt[MAX];
		this.ajouter(e);
	}

	public boolean estVide() {
		return this.cardinal == 0;
	}

	public boolean contient(Elt e) {
		if(e == null)throw new IllegalArgumentException();
		for(int i=0;i<cardinal;i++){
			if (elements[i].equals(e))
				return true;
		}
		return false;
	}

	public void ajouter(Elt e) {
		if (!contient(e)){
			if(cardinal == MAX)
				System.out.println("Ensemble plein.");
			else{
				elements[cardinal] = e;
				cardinal ++;
			}
		}
	}

	public void enlever(Elt e) {
		for(int i=0;i<cardinal;i++){
			if(elements[i].equals(e))
				elements[i] = elements[cardinal-1];
		}
		cardinal --;
	}

	public int cardinal() {
		return this.cardinal;
	}

	public void complementer() {
		Ens2 tmp  = new Ens2();
		for(int i=1;i < MAX+1; i++){
			if(!this.contient(new Elt(i)))
				tmp.ajouter(new Elt(i));
		}
		this.elements = tmp.elements;
		this.cardinal = tmp.cardinal;
	}

	public String toString() {
		return null;
	}

}
