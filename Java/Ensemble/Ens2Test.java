import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Ens2Test extends AbstractTest {
	
	private Field fieldTab;
	private Field fieldCard;
 
	public Ens2Test() {
		super(Ens2.class);
		Field[] champs = getCls().getDeclaredFields();
		if (champs.length > 2) {
			System.out.println("Il est inutile de déclarer des champs supplémentaire dans Ens2");
			System.exit(0);
		}
		for (Field f : champs){
			if (f.getType() == Elt[].class){
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
			System.out.println("Vous avez supprimé un attribut de la classe Ens2");
			System.exit(0);
		}
		fieldTab.setAccessible(true);
		fieldCard.setAccessible(true);
	}
	
	@Override
	public boolean testEstVide() throws IllegalArgumentException,
			IllegalAccessException {
		boolean testOK =  super.testEstVide();
		EnsembleInterface ens = creerEnsemble(ELTS);
		fieldCard.set(ens, 0);
		if (!ens.estVide()){
			testOK = false;
			System.out.println("On a créé un ensemble vide et votre méthode dit qu'il ne l'est pas !");
		}
		return testOK;
	}

	@Override
	public boolean testContient() throws IllegalArgumentException,
			IllegalAccessException {
		boolean testOK = super.testContient();
		EnsembleInterface ens = creerEnsemble(ELTS);
		fieldCard.set(ens,ELTS.length-1);
		Elt[] tab = (Elt[]) fieldTab.get(ens);
		if (ens.contient(tab[ELTS.length-1])){
			testOK = false;
			System.out.println("Ensemble créé : " + enChaine(Arrays.copyOf(tab, ELTS.length-1)));
			System.out.println("Votre méthode contient dit que l'élément " + tab[ELTS.length-1] + " est dans l'ensemble");
		}
		return testOK;
	}
	
	
	@Override
	protected HashSet<Elt> toSet() throws IllegalArgumentException,
			IllegalAccessException {
		HashSet<Elt> elem = new HashSet<Elt>();
		Elt[] tab = (Elt[]) fieldTab.get(getEnsemble());
		int card = fieldCard.getInt(getEnsemble());
		for (int i = 0; i < card;i++){
			 elem.add(tab[i]);
		}
		return elem;
	}
	
	@Override
	protected int card() throws IllegalArgumentException, IllegalAccessException {
		return fieldCard.getInt(getEnsemble());
	}
	
	@Override
	protected EnsembleInterface creerEnsemble(Elt... elts) throws IllegalArgumentException, IllegalAccessException {
		HashSet<Elt> liste = new HashSet<>();
		for (Elt e : elts) liste.add(e);
		Elt[] tab = new Elt[Elt.MAXELT.val()];
		int card = 0;
		for (Elt elt : liste){
			tab[card++] = elt;
		}
		EnsembleInterface ensemble = new Ens2();
		fieldTab.set(ensemble, tab);
		fieldCard.setInt(ensemble, card);
		return ensemble;
	}
	
	protected boolean verifInit() throws  IllegalAccessException{
		Elt[] tabTrouve = (Elt[]) fieldTab.get(getEnsemble());
		if (tabTrouve == null){
			System.out.println("Le tableau d'éléments n'a pas été initialisé !");
			return false;
		}
		else if (tabTrouve.length!= Elt.MAXELT.val()){
			System.out.println("Le tableau d'éléments n'a pas la bonne dimension !");
			return false;
		} 
		return true;
	}
	
	
}
