package graph;

import java.util.*;

/**
* Cette classe représente un graphe basique avec des noeuds
* attachés par des arcs.
*/
public class Graph{

  /**
  * Attribut listNode, la liste de tout les nodes
  */
  LinkedList<Node> listNode = new LinkedList<Node>();

  /**
  * Constructeur de la classe
  */
  public Graph(){
  }

  /**
  * Méthode permettant d'avoir la liste des noeuds
  * @return Une liste avec tout les noeuds dedans
  */
  public LinkedList<Node> getListNode(){
    return listNode;
  }

  /**
  * Méthode qui permet d'ajouter un noeud à la liste de node
  * @param a Node
  */
  public void setListNode(Node a){
    listNode.add(a);
  }

  /**
  * Méthode qui permet d'afficher les arcs d'un noeud
  * @return Un String avec le nom des arcs du noeud
  */
  public String afficheArc(){
    String res = "";
    for (Node noeud : this.getListNode()) {
      res += (" Liste des Arcs du noeud : " + noeud.getName() + "\n\n" + noeud.toStringArc() + "\n");
    }
    return res;
  }
}
