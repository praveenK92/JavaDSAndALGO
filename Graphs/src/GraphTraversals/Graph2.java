package GraphTraversals;
import java.lang.*;
import java.io.*;
import java.util.*;

public class Graph2 {
	
	private final int maxVertices=20;
	private Vertex vertices[];
	private int adjMatrix[][];
	private int vertexCount;
	private Queue<Integer> Q;
	
	public Graph2(){
		vertices=new Vertex[maxVertices];
		adjMatrix=new int[maxVertices][maxVertices];
		vertexCount=0;
		/*for(int i=0;i<maxVertices;i++)
			for(int j=0;j<maxVertices;j++)
				adjMatrix[i][j]=0;*/
		Q=new LinkedList();
		//Object. You cannot create an instance of Queue as it is abstract
	}
	
	public void addVertex(char lab){
		vertices[vertexCount++]=new Vertex(lab);
		//vertices[vertexCount++].label=lab;
	}
	public void addEdge(int i,int j){
		adjMatrix[i][j]=1;
		adjMatrix[j][i]=1; // thats only for undirected graphs
	}
	public void displayVertex(int v){
		System.out.println(vertices[v].label);
	}
	
	public void deleteEdge(int i,int j){
		adjMatrix[i][j]=0;
		adjMatrix[j][i]=0;
	}
	
	public void bfs(){
		vertices[0].visited=true;
		displayVertex(0);
		Q.add(0);
		int a;
		while(!Q.isEmpty()){
			int b=Q.remove();
			a=getAdjUnvisitedVertex(b);
			while(a!=-1){
				vertices[a].visited=true;
				displayVertex(a);
				Q.add(a);
				a=getAdjUnvisitedVertex(b);
			}
		}
		for(int i=0;i<vertexCount;i++)vertices[i].visited=false;
	}
	
	// helper function for BFS
	public int getAdjUnvisitedVertex(int v){
		for(int i=0;i<vertexCount;i++){
			if(adjMatrix[v][i]==1 && vertices[i].visited==false)
				return i;
		}
		return -1;
	}
	// this aint working bitch!
	public void bfsRecursive(int v){
		vertices[v].visited=true;
		displayVertex(v);
		Queue<Integer> Ql=new LinkedList();
		int un=getAdjUnvisitedVertex(v);
		while(un!=-1){
			Ql.add(un);
			un=getAdjUnvisitedVertex(v);
		}
		while(!Ql.isEmpty()){
			System.out.println("pika");
			bfsRecursive(Ql.remove());
		}
	}
}
