/**
 * 
 * @author Janssens Thibaut  - IPL - 1/12/15
 *
 */
public class Guerrier {
    private String nom;
    private int pointsDeVie;
    private int[] privileges;
     
    //constructeur pour un guerrier.
    public Guerrier(String nom, int pointsDeVie) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        int position = Utilitaires.lancerDe(0,5);
        this.privileges = new int[6];
        this.privileges[position] = 1;
    }
     
    //Constructeur qui sert pour les test.
    public Guerrier(String nom, int pointsDeVie, int[] privileges){
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.privileges = privileges;
    }
     
    //attribue une force max a un guerrier.
    public int donnerForceDeFrappe(){
        return this.getPointsDeVie()/3;
    }
     
    //permet de recuperer le nom d'un guerrier.
    public String getNom() {
        return nom;
    }
     
    //sert pour les tests.
    public int[] getPrivilege(){
        return this.privileges;
    }
     
    //permet de recupere les points de vie d'un guerrier.
    public int getPointsDeVie() {
        return pointsDeVie;
    }
     
    //modifie les points de vie d'un guerrier.
    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }
     
    //verifie qu'un guerrier possede le privilege.
    public boolean possede(int privilege){
        if(privileges[privilege-1] == 1)
            return true;
        return false;
    }
     
    //verifie si un guerrier possede tout les privileges demandes en parametre.
    public boolean possedeTous(int[] privilege){  
        if(privilege == null) throw new IllegalArgumentException("La table est vide");
        for(int i =0; i < privilege.length;i++){
            if(privilege[i] == 0 || privilege[i] > 6) throw new IllegalArgumentException("Les privilèges sont compris entre 1 et 6");
            if(privileges[privilege[i]-1] != 1)
                return false;
        }
        return true;
    }
    
    //verifie si un guerrier ne possede aucun des privileges demandes en parametre.
    public boolean possedeAucun(int[] privilege){
        if(privilege == null) throw new IllegalArgumentException("La table est vide");
        for(int i =0; i < privilege.length;i++){
            if(privilege[i] == 0 || privilege[i] > 6) throw new IllegalArgumentException("Les privilèges sont compris entre 1 et 6");
            if(privileges[privilege[i]-1] != 0)
                return false;
        }
        return true;
    }
     
    //permet a un guerrier d'obtenir un privilege.
    public boolean donnerPrivilege(int privilege){
        if (privilege <= 0 || privilege > 6) throw new IllegalArgumentException("Veuillez entrez un numéro de privilege correct. (1-6)");
        if(privileges[privilege-1] == 0){
            privileges[privilege-1] = 1;
            return true;
        }
        else
            return false;
    }
    
    //retire un priviliege a un guerrier.
    public boolean retirePrivilege(int privilege){
        if(privileges[privilege-1] == 1){
            privileges[privilege-1] = 0;
            return true;
        }
        else
            return false;
    }
     
    public String toString() {
        return "Guerrier [nom=" + nom + ", pointsDeVie=" + pointsDeVie +"]";
    }
}
