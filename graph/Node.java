package graph;
import java.util.*;

/**
* Cette classe représente un noeud dans un graphe.
* Le noeud possède un nom ainsi qu'une valeur entière correspondant,
* à l'heuristic pour aller au noeud final.
*/
public class Node implements Comparable<Node>{

  /**
  * Attribut name, nom du nom
  */
  private String name;

  /**
  * Attribut heuristic, entier déffinissant l'heuristique jursqu'au but
  */
  private int heuristic;

  /**
  * Attribut listOfChild, la liste de tout les arcs connectés à celui-ci
  */
  private ArrayList<Arc> listOfChild = new ArrayList<Arc>();

  /**
  * Attribut listOfChildNode, la liste de tout les noeuds connectés à celui-ci
  */
  private ArrayList<Node> listOfChildNode = new ArrayList<Node>();

  /**
  * Attribut f, nombre qui est égal au calcul de f = g + h, pour le calcul du chemin
  */
  private int f;

  /**
  * Attribut g
  */
  private int g;

  /**
  * Attribut listArc
  */
  private ArrayList<Arc> listArc = new ArrayList<Arc>();

  /**
  * Constructeur de la classe
  * @param name Nom
  * @param heuristic heuristique
  */
  public Node(String name, int heuristic){
    this.name = name;
    this.heuristic = heuristic;
    this.f = f;
    this.g = Integer.MAX_VALUE;
  }

  /**
  * Second constructeur de classe
  * @param name Nom
  * @param cost Coût
  */
  public Node(int cost, Node name){
    this.name = name.getName();
    this.g = Integer.MAX_VALUE;
  }

  /**
  * Méthode qui permet de retourner la liste des arcs du noeud
  * @return La liste des arcs pour le noeud
  */
  public ArrayList<Arc> getArc(){
    return listArc;
  }

  /**
  * Méthode qui retourne le nom du noeud
  * @return Un String contenant le nom du noeud
  */
  public String getName(){
    return this.name;
  }

  /**
  * Méthode qui retourne l'heuristic pour aller au but
  * @return Un int contenant l'heuristic
  */
  public int getHeuristic(){
    return this.heuristic;
  }

  /**
  * Getteur de l'attribut f
  * @return Un int qui est la valeur de f
  */
  public int getF(){
    return this.f;
  }

  /**
  * Getteur de l'attribut g
  * @return Un int qui est la valeur de g
  */
  public int getG(){
    return this.g;
  }

  /**
  * Setteur de l'attribut f
  * @param f La nouvelle valeur de f
  */
  public void setF(int f){
    this.f = f;
  }

  /**
  * Setteur de l'attribut g
  * @param g La nouvelle valeur de g
  */
  public void setG(int g){
    this.g = g;
  }

  /**
  * Méthode qui permet de rattacher un arc au noeud
  * @param noeudDepart Noeud de départ
  * @param noeudArrive Noeud d'arrivé
  * @param cost Coût
  */
  public void setArc(Node noeudDepart, Node noeudArrive, int cost){
    Arc tmp = new Arc(noeudDepart, noeudArrive, cost);
    listArc.add(tmp);
  }

  /**
  * Override de la méthode compareTo afin de pouvoir
  * comparer deux noeuds entre eux. Retourne -1 si
  * le noeud est plus petit, 0 si les deux noeuds ont la
  * même valeur, sinon retourne 1 si le noeud est plus grand
  * @param  n Un noeud
  * @return   Un int compris entre [-1;1]
  */
  @Override
  public int compareTo(Node n){
    int compareF = ((Node)n).getF();
    return this.f - compareF;
  }

  /**
  * Méthode permettant d'afficher la liste des Arcs du noeud
  * @return Un String avec la liste des Arcs du noeud
  */
  public String toStringArc(){
    String res = "";
    for (int i = 0; i < listOfChild.size() ; i++ ) {
      res += (listOfChild.get(i).toString() + "\n");
    }
    return res;
  }
}
