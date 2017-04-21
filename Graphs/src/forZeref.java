import java.lang.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import GraphTraversals.Vertex;
public class forZeref {

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
	
	public class AdjacencyMatrix {
		
		private boolean AdjMatrix[][];
		private int vertexCount;
		
		public AdjacencyMatrix(int v){
			this.vertexCount=v;
			AdjMatrix=new boolean[vertexCount][vertexCount];
		}
		public void addEdge(int i,int j){
			if(i>=0 && i<vertexCount && j>=0 && j<vertexCount){
				AdjMatrix[i][j]=true;
				AdjMatrix[j][j]=true;  // this is for undirected graphs
				// for directed graph only 1 edge
			}
		}
		public void removeEdge(int i,int j){
			if(i>=0 && i<vertexCount && j>=0 && j<vertexCount){
				AdjMatrix[i][j]=false;
				AdjMatrix[j][j]=false;  // this is for undirected graphs
				// for directed graph only 1 edge
			}
		}
		public boolean isEdge(int i,int j){
			if(i>=0 && i<vertexCount && j>=0 && j<vertexCount)
				return AdjMatrix[i][j];
			else return false;
		}
	}
	
	public class Graph{
		
		private final int maxVertices=20;
		private Vertex vertices[];
		private int adjMatrix[][];
		private int vertexCount;
		private Stack<Integer> theStack;
		
		public Graph(){
			vertices=new Vertex[maxVertices];
			adjMatrix=new int[maxVertices][maxVertices];
			vertexCount=0;
			/*for(int i=0;i<maxVertices;i++)
				for(int j=0;j<maxVertices;j++)
					adjMatrix[i][j]=0;*/
			theStack=new Stack();
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
		
		public void dfsIterative(){
			vertices[0].visited=true;
			displayVertex(0);
			theStack.push(0);
			
			while(!theStack.isEmpty()){
				int v=getAdjUnvisitedVertex(theStack.peek());
				if(v==-1)theStack.pop();
				else{
					vertices[v].visited=true;
					displayVertex(v);
					theStack.push(v);
				}
			}
			for(int i=0;i<vertexCount;i++)vertices[i].visited=false;
			
		}
		// helper function for DFS & dfsIterative
		public int getAdjUnvisitedVertex(int v){
			for(int i=0;i<vertexCount;i++){
				if(adjMatrix[v][i]==1 && vertices[i].visited==false)
					return i;
			}
			return -1;
		}
		public void DFS(int v){
			vertices[v].visited=true;
			displayVertex(v);
			int i=getAdjUnvisitedVertex(v);
			while(i!=-1){
				DFS(i);
				i=getAdjUnvisitedVertex(v);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
