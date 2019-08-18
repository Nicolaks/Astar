package graph;

import java.util.*;

/**
* Cette classe représente l'algorithme A* qui permet de calculer
* le plus court chemin dans un graphe.
*/
public class Astar{

  /**
  * Attribut closedSet, qui est la liste des noeuds déja visités
  */
  private ArrayList<Node> closedSet = new ArrayList<Node>();

  /**
  * Attribut erreur, qui est de type node permettant de gérer une erreur
  */
  private ArrayList<Node> erreur = new ArrayList<Node>();
  Node err = new Node("Pas de chemin optimal !", 0);

  /**
  * Constructeur de la classe
  */
  public Astar(){
  }

  /**
  * Méthode qui permet de reconstruire le chemin
  * @param cameFrom HashMap contenant tous les noeuds du chemin le plus court
  * @param current Node actuel
  * @param start Node de départ du graphe
  * @return Une ArrayList de Node dans l'ordre contenant le chemin le plus court
  */
  public ArrayList<Node> reconstruct_path(HashMap<Node,Node> cameFrom, Node current, Node start){
    ArrayList<Node> totalPath = new ArrayList<Node>();
    int i = 0;
    totalPath.add(current);
    while(current != start){
      Node tmp = null;
      tmp = cameFrom.get(current);
      totalPath.add(tmp);

      current = tmp;
    }
    Collections.reverse(totalPath);
    return totalPath;
  }

  /**
  * Méthode qui permet de calculer le chemin le plus court dans un graphe
  * @param start Node de départ
  * @param goal Node d'arrivé
  * @return Une ArrayList de Node contenant la chemin le plus court
  */
  public ArrayList<Node> a_star(Node start, Node goal){

    ArrayList<Node> openSet = new ArrayList<Node>();
    openSet.add(start);

    HashMap<Node,Node> cameFrom = new HashMap<Node,Node>();

    ArrayList<Node> gScore = new ArrayList<Node>();

    gScore.add(start);
    gScore.get(0).setG(0);

    ArrayList<Node> fScore = new ArrayList<Node>();


    while(openSet.size() > 0){
      Collections.sort(openSet);
      Node current = openSet.get(0);
      if(current.getName() == goal.getName()){
        return reconstruct_path(cameFrom, current, start);
      }
      else{
        openSet.remove(current);
        closedSet.add(current);
        for(Arc neighbor : current.getArc()){
          int tentative_gScore = current.getG() + neighbor.getCost();
          if(! openSet.contains(neighbor.getNoeudArrive())){
            openSet.add(neighbor.getNoeudArrive());
          }
          if(tentative_gScore < neighbor.getNoeudArrive().getG()){
            cameFrom.put(neighbor.getNoeudArrive(), current);
            neighbor.getNoeudArrive().setG(tentative_gScore);
            neighbor.getNoeudArrive().setF(neighbor.getNoeudArrive().getHeuristic() + neighbor.getNoeudArrive().getG());
          }
        }
      }
    }
    erreur.add(err);
    return erreur;
  }

}
