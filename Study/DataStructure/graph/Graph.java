class AdjMatrix {
	private int matrix[][]=new int [10][10];
	private int totalV=0;
	
	public void insertVertex(int v) {
		totalV++;
	}
	
	public void insertEdge(int v1,int v2) {
		if(v1>=totalV || v2>=totalV) {
			System.out.println("그래프에 없는 정점입니다!!");
		} else {
			matrix[v1][v2]=1;
		}
	}
	
	public void printMatrix() {
		for(int i=0;i<totalV;i++) {
			System.out.printf("\n\t\t");
			for(int j=0;j<totalV;j++) {
				System.out.printf("%2d",matrix[i][j]);
			}
		}
	}
	
}

class GraphNode {
	int vertex;
	GraphNode link;
}

class AdjList {
	private GraphNode head[]=new GraphNode[10];
	private int totalV=0;
	
	public void insertVertex(int v) {
		totalV++;
	}
	
	public void insertEdge(int v1,int v2) {
		if(v1>=totalV || v2>=totalV) {
			System.out.println("그래프에 없는 정점입니다!");
		} else {
			GraphNode gNode=new GraphNode();
			gNode.vertex=v2;
			gNode.link=head[v1];
			head[v1]=gNode;
		}
	}
	
	public void printAdjList() {
		GraphNode gNode=new GraphNode();
		for(int i=0;i<totalV;i++) {
			System.out.printf("\n정점 %c의 인접리스트",i+65);
			gNode=head[i];
			while(gNode!=null) {
				System.out.printf("-> %c",gNode.vertex+65);
				gNode=gNode.link;
			}
		}
	}
}
public class Graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjMatrix MG1=new AdjMatrix();
		
		for(int i=0;i<3;i++) {
			MG1.insertVertex(i);
		}
			MG1.insertEdge(0, 2);
			MG1.insertEdge(0, 1);
			MG1.insertEdge(1, 2);
			MG1.insertEdge(1, 0);
		MG1.printMatrix();
		System.out.println();
		
		AdjList LG1=new AdjList();
		for(int i=0;i<4;i++) {
			LG1.insertVertex(i);
		}
		LG1.insertEdge(0, 3);
		LG1.insertEdge(0, 1);
		LG1.insertEdge(1, 3);
		LG1.insertEdge(1, 2);
		LG1.printAdjList();
	}

}
