package graph;

/**
*  Cette classe représente un arc reliant deux noeuds dans
*  un graphe.
*/
public class Arc{

  /**
  *  Attribut noeudDepart, le noeud source
  */
  private Node noeudDepart;

  /**
  *  Attribut noeudArrive, le noeud de destination
  */
  private Node noeudArrive;

  /**
  *  Attribut cost, un entier représentant le coût
  */
  private int cost;

  /**
  * Constructeur de la classe
  * @param noeudDepart Noeud source
  * @param noeudArrive Noeud de destination
  * @param cost        Entier de coût
  */
  public Arc(Node noeudDepart, Node noeudArrive, int cost){
    this.noeudDepart = noeudDepart;
    this.noeudArrive = noeudArrive;
    this.cost = cost;
  }

  /**
  * Méthode qui retourne le coût
  * @return Un entier représentant le coût
  */
  public int getCost(){
    return this.cost;
  }

  /**
  * Méthode qui retourne le noeud de départ
  * @return Un Node correspondant au noeud de départ
  */
  public Node getNoeudDepart(){
    return this.noeudDepart;
  }

  /**
  * Méthode qui retourne le noeud d'arrivé
  * @return Un Node correspondant au noeud d'arrivé
  */
  public Node getNoeudArrive(){
    return this.noeudArrive;
  }

  /**
  * Override de la méthode toString()
  * @return Un String comportant les noeuds de départ et d'arrivé ainsi que le coût
  */
  @Override
  public String toString(){
    return ("From node : " + this.noeudDepart.getName() + " | to node : " + this.noeudArrive.getName() + " | cost : " + this.cost);
  }

}
