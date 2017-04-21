import GraphTraversals.Graph2;

public class bakchodi {
	
	public static void main(String[] args) {
		//Graph g=new Graph();
		Graph2 g=new Graph2();
		char ch[]={'a','b','c','d','e','f','g','h','i','j'};
		for(char c:ch)g.addVertex(c);
		
		/*for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(i%2==0 && i!=j)
				g.addEdge(i, j);
			}
		}*/
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 4);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(2, 5);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(3, 6);
		g.addEdge(4, 6);
		g.addEdge(5, 6);		
		
		//g.DFS(0);
		g.bfs();
		//g.bfsRecursive(0);
	}

}
