import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Ens1Test extends AbstractTest {
	private Field fieldTab;
	private Field fieldCard;

	
	public Ens1Test(){
		super(Ens1.class);
		Field[] champs = getCls().getDeclaredFields();
		if (champs.length > 2) {
			System.out.println("Il est inutile de déclarer des champs supplémentaire dans Ens1.");
			System.exit(0);
		}
		for (Field f : champs){
			if (f.getType() == boolean[].class){
				fieldTab = f;
			}
			else if (f.getType() == int.class){
				fieldCard = f;
			}
			else {
				System.out.println("Que représente le champ " + f.getName() + " de type " + f.getType().getName() + " ?");
				System.exit(0);
			}
		}
		if (fieldTab == null||fieldCard==null) {
			System.out.println("Vous avez supprimé un attribut de la classe Ens1");
			System.exit(0);
		}
		fieldTab.setAccessible(true);
		fieldCard.setAccessible(true);
	}
	
	@Override
	public boolean testEstVide() throws IllegalArgumentException,
			IllegalAccessException {
		boolean testOK = super.testEstVide();
		EnsembleInterface ens = creerEnsVide();
		if (!ens.estVide()){
			testOK = false;
			System.out.println("On a créé un ensemble vide et votre méthode dit qu'il ne l'est pas !");
		}
		return testOK;
	}
	
	@Override
	public boolean testCardinal() throws IllegalArgumentException,
			IllegalAccessException {
		boolean testOK = super.testCardinal();
		EnsembleInterface ens = creerEnsVide();
		if (ens.cardinal()!= 0){
			testOK = false;
			System.out.println("On a créé un ensemble vide.");
			System.out.println("Votre méthode cardinal dit qu'il contient " + ens.cardinal() + " élément(s).");
		}
		return testOK;
	}
	
	@Override
	public void visualiserToString() throws IllegalArgumentException,
			IllegalAccessException {
		super.visualiserToString();
		EnsembleInterface ens = creerEnsVide();
		System.out.println("Ensemble à afficher : ");
		System.out.println("{}");
		System.out.println("Chaîne de caractères renvoyée par votre toString : ");
		System.out.println(ens);
	}

	private EnsembleInterface creerEnsVide() throws IllegalArgumentException, IllegalAccessException{
		EnsembleInterface ens = creerEnsemble(new Elt[0]);
		boolean[] tabB = (boolean[]) fieldTab.get(ens);
		tabB[0] = true;
		return ens;
	}
	
	@Override
	protected HashSet<Elt> toSet() throws IllegalArgumentException,
			IllegalAccessException {
		HashSet<Elt> elem = new HashSet<Elt>();
		boolean[] tab = (boolean[]) fieldTab.get(getEnsemble());
		for (int i = 1; i <= Elt.MAXELT.val();i++){
			if (tab[i])  elem.add(new Elt(i));
		}
		return elem;
	}
	
	@Override
	protected int card() throws IllegalArgumentException, IllegalAccessException {
		return fieldCard.getInt(getEnsemble());
	}

	private boolean[] initTab(Elt... elts){
		boolean[] tab = new boolean[Elt.MAXELT.val()+1];
		for (Elt e : elts){
			tab[e.val()] = true;
		}
		return tab;
	}
	
	@Override
	protected EnsembleInterface creerEnsemble(Elt... elts) throws IllegalArgumentException, IllegalAccessException {
		HashSet<Elt> ens = new HashSet<Elt>();
		for (Elt elt : elts) ens.add(elt);
		EnsembleInterface ensemble = new Ens1();
		boolean[] tabB = initTab(elts);
		fieldTab.set(ensemble, tabB);
		fieldCard.setInt(ensemble, ens.size());
		return ensemble;
	}
	

	
	protected boolean verifInit() throws IllegalAccessException{
		boolean[] tabTrouve = (boolean[]) fieldTab.get(getEnsemble());
		if (tabTrouve == null){
			System.out.println("Le tableau de booleens n'a pas été initialisé !");
			return false;
		}
		else if (tabTrouve.length!= Elt.MAXELT.val()+1){
			System.out.println("Le tableau de booleens n'a pas la bonne dimension !");
			return false;
		} 
		return true;
	}
	
}
