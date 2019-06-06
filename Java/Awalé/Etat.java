//IPL, algorithmique (I1010), projet awale
//
// Q1, 2014
//
// Thibaut Janssens :
// Sébastien Place :

public class Etat {
  int n;
  int[] plateau;
  int[] captures;
  
  public Etat() {
    /*
    Constructeur vide qui initialise une état de départ avec toutes les valeurs par defaut.
    */
    this.n = 0;
    this.plateau = new int[12];
    for (int i = 0; i<12; i++){
      this.plateau[i] = 4;
    }
    this.captures = new int[2];
  }
  
  public Etat(Etat etat) {
    /*
    Constructeur de copie,
    Un état est passé en paramètres, on en fait une copie profonde dans un nouvel objet Etat.
    */
    this.n = etat.n;
    this.plateau = new int[12];
    for (int i = 0; i<etat.plateau.length; i++) {
      this.plateau[i] = etat.plateau[i];
    }
    this.captures = new int[2];
    this.captures[0] = etat.captures[0];
    this.captures[1] = etat.captures[1];
  }

  // constructeur pour les tests
  public Etat(int n, int[] plateau, int[] captures) {
    this.n = n;
    this.plateau = plateau;
    this.captures = captures;
  }

  public String toString(){
    /*
    Affichage de l'état actuel du jeu.
    */
	 String res = "Nombre de tours :"+this.n+"\n\tNord("+this.captures[0]+")\n";
   for (int i = 0; i<6; i++){
    res+=""+ i + " , ";
   }
   res+="\n";
   for (int i = 0; i<24; i++){
    res+="*";
   }
   res+="\n";
   for (int i = 0; i<6; i++) {
    res+=this.plateau[i];
    res+=" , ";
   }
   res+="\n";
   for (int i = 11; i>5; i--) {
     res+=this.plateau[i];
     res+=" , ";
   }
   res+="\n";
   for (int i = 0; i<24; i++){
    res+="*";
   }
   res+="\n";
   for (int i = 11; i>5; i--){
    res+=""+ i + " , ";
   }
   res+="\n\tSud("+this.captures[1]+")\n";
   return res;
  }
  
  public int egrene(int t) throws IllegalArgumentException{
    /*
    Egrenage, on commence à la case t et on place les pois pris dans la case t
    et on les redistribue dans l'odre horloger.
    */
    // on vérifie si la case se trouve dans le plateau de jeu
    if(t<0)
      throw new IllegalArgumentException("Le nombre choisi est trop petit");
    if (t>=12)
      throw new IllegalArgumentException("Le nombre choisi est trop grand");
    // la vérification est terminée on peut commencer à déplacer les pois
    int nombreGraines = this.plateau[t];
    this.plateau[t] = 0;
    int indice = t;
    while(nombreGraines>0){
        indice++;
        this.plateau[indice%12]++;
        nombreGraines--;
    }
    return indice%12;
  }
  
  public boolean estNourri() {
    /*
    Si le tour est pair, le joueur Nord est actif.
    Si le tour est impair, le joueur Sud est actif.
    */
    //Joueur Nord car le tour est pair
    if(this.n%2 != 0){
      int zeroGraine = 0;
      for (int i = 0; i<6; i++) {
        if (this.plateau[i]==0)
          zeroGraine++;
      }
      if (zeroGraine==6)
        return false;

      return true;
    }

    // Joeur Sud car le tour est impair
    int zeroGraine = 0;
      for (int i = 6; i<12; i++) {
        if (this.plateau[i]==0)
          zeroGraine++;
      }
      if (zeroGraine==6)
        return false;

      return true;
  }
  
  public boolean estAffame(int t){
    Etat copie = new Etat(this);
    int indice = copie.egrene(t);
    int points = copie.capture(indice);
    if(copie.estNourri())
      return true;

    return false;
  }
  
  public int capture(int t){
    if(this.n%2 == 0 && t > 5 && t < 12){
      int indice = t;
      int pointCapture = 0;
      while(this.plateau[indice] == 2 || this.plateau[indice] == 3){
        pointCapture += this.plateau[indice];
        this.plateau[indice] = 0;
        indice--;
        if (indice < 6)
          return pointCapture;
      }
    return pointCapture;
    }
    if (this.n%2 == 1 && t > -1 && t < 6){
      int indice = t;
      int pointCapture = 0;
      while(this.plateau[indice] == 2 || this.plateau[indice] == 3){
        pointCapture += this.plateau[indice];
        this.plateau[indice] = 0;
        indice--;
        if (indice<0)
          return pointCapture;
      }
      return pointCapture;
    }
    return 0;
  }
  
  public boolean estLegal(int t) {
    if(this.n%2 == 0 && t >= 0 && t <= 5)
      return true;

    if (this.n%2 == 1 && t >= 6 && t <= 11)
      return true;

    return false;
  }
  
  /*
  
  */
    public Etat joue(int t){
    Etat recopie = new Etat(this);
    int points = 0;
    int numTrou = recopie.egrene(t);
    if (!(recopie.estAffame(t))){
      points = recopie.capture(numTrou);
    }
    recopie.captures[n%2] += points;
    recopie.n++;
    return recopie;
    }
    
  /*
  Vérifie si la partie est terminée.
  */
  public boolean estTerminee() {
    if (this.captures[0]>= 25 || this.captures[1] >= 25)
      return true;
    if (this.estNourri()==false){
        return true;
    }
    return false;
  }
  

  /*
  Renvoie le nombre de pièces capturées.
  */
  public int[] piecesCapturees() { 
      int[] piecesCapturees = new int[12];
      for(int i = 0; i < piecesCapturees.length; i++){
         if(estLegal(i))
            piecesCapturees[i] = capture(i); 
         if(estLegal(i) == false)
            piecesCapturees[i] = -1;
      }
      return piecesCapturees;
  }
  
  /*
  Cette fonction renvoie le Classement des Trous.
  Elle renvoie un tableau avec tout les trous jouable pour le joueur.
  Et qui permettrais de potentiellement capturer des pièces.
  */
  public int[] classementDesTrous() {
      int nombreTrou = 0;
      int[] tmp = new int[12];
      for(int i = 0; i < plateau.length; i++){
         if(estLegal(i)){
            tmp[i] = plateau[i];
            nombreTrou++;
         }
      }
      for(int i = 1; i < tmp.length-1; i++){
         int elem = tmp[i-1];
         if(capture(i-1) < capture(i)){
            tmp[i-1] = tmp[i];
            tmp[i] = elem;
            i--;
         }
      }
      int[] classementDesTrous = new int[12];
      for(int i = 0; i < tmp.length; i++){
         classementDesTrous[i] = tmp[i];
      }
      return classementDesTrous;
   }
}