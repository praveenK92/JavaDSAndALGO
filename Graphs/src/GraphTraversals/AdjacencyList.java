package GraphTraversals;
import java.util.*;
import java.lang.*;

public class AdjacencyList {
	
	private ArrayList<Integer> vertices;
	private int vertexCount=0;
	private List<Integer>[] edges;
	
	public AdjacencyList(int v){
		this.vertexCount=v;
		vertices=new ArrayList<Integer>();
		edges=new List[vertexCount];
		for(int i=0;i<v;i++){
			vertices.add(i);
			edges[i]=new LinkedList();
		}
	}
	
	public void addEdge(int source,int destination){
		int i=vertices.indexOf(source);
		int j=vertices.indexOf(destination);
		if(i!=-1 || j!=-1){
			edges[i].add(destination);
			edges[j].add(source);
		}
	}
	public void removeEdge(int source,int destination){
		int i=vertices.indexOf(source);
		int j=vertices.indexOf(destination);
		if(i!=-1 || j!=-1){
			edges[i].remove((Integer)destination);
			edges[j].remove((Integer)source);
		}
	}
	public boolean isEdge(int source,int destination){
		int i=vertices.indexOf(source);
		int j=vertices.indexOf(destination);
		if(edges[i].contains((Integer)j))return true;
		else return false;
	}
	
}
