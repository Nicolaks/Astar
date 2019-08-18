package graph;

import java.util.*;

/**
* Cette classe est la classe test pour pouvoir essayer les graphes.
*/
public class Demo{

  public static void main(String[] args){

    ArrayList<Node> resultat = new ArrayList<Node>();

    Node s = new Node("S", 6);
    Node a = new Node("A", 6);
    Node b = new Node("B", 2);
    Node c = new Node("C", 1);
    Node g = new Node("G", 0);

    Graph graph = new Graph();

    s.setArc(s,a,1);
    s.setArc(s,b,4);

    a.setArc(a,b,2);
    a.setArc(a,c,5);
    a.setArc(a,g,12);

    b.setArc(b,c,2);

    c.setArc(c,g,3);

    graph.setListNode(s);
    graph.setListNode(a);
    graph.setListNode(b);
    graph.setListNode(c);
    graph.setListNode(g);

    Astar astar = new Astar();
    resultat = astar.a_star(s, g);
    String res = "";
    for(Node node : resultat){
      res += " " + node.getName();
    }
    System.out.println("Meilleur chemin : " + res);

  }

}
