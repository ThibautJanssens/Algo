public class Ens1 extends EnsembleAbstrait {

	private boolean[] tabB; // e appartient � l'ensemble courant ssi tabE[e.val()] est � true.
	private int cardinal;

	public Ens1() {
		this.tabB = new boolean[MAX+1];
		this.cardinal = 0;
	}

	public Ens1(EnsembleInterface a){
		if(a == null) throw new IllegalArgumentException();
		this.tabB = new boolean[MAX+1];
		this.cardinal = 0;
		for(int i=1; i < MAX+1;i++){
			if(a.contient(new Elt(i)))
				this.ajouter(new Elt(i));
		}
	}
	
	public Ens1(Elt e){
		if (e == null) throw new IllegalArgumentException();
		this.cardinal = 1;
		this.tabB = new boolean[MAX+1];
		this.tabB[e.val()] = true;
	}
	
	public boolean estVide() {
		return cardinal == 0;
	}

	public boolean contient(Elt e) {
		if(e == null)throw new IllegalArgumentException();
		if (e.val() <= 0)
			return false;
		if(estVide())
			return false;
		
		return tabB[e.val()];
	}

	public void ajouter(Elt e) {
		if (!contient(e)){
			if(cardinal == MAX)
				System.out.println("Ensemble plein.");
			else{
				tabB[e.val()]= true;
				cardinal ++;
			}
		}
	}

	public void enlever(Elt e) {
		if(contient(e)){
			tabB[e.val()] = false;
			cardinal --;
		}
	}

	public int cardinal() {
		return cardinal;
	}

	public void complementer() {
		if (estVide()){
			cardinal = MAX;
			for (int i = 1; i < MAX+1; i++){
				tabB[i]=true;
			}
		}
		else{
			for (int i = 1; i < MAX+1; i++){
				if (tabB[i]){
					tabB[i] = false;
				}
				else{
					tabB[i] = true;
				}
			}
			this.cardinal = this.MAX-this.cardinal;
		}
	}

	public String toString() {
		String res = "{";
		for (int i = 1; i < MAX+1; i++){
			if(tabB[i])
				res += ""+ i + ",";
		}
		if(this.cardinal !=0) res = res.substring(0, res.length()-1);
		res+="}";
		return res;
	}
}