package GraphTraversals;
import java.lang.*;
import java.io.*;
import java.util.*;

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
