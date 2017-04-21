package GraphTraversals;
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
