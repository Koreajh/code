/**
 * 플로이드-워셜 알고리즘(Floyd-Warshall Algorithm)은 그래프에서 모든 꼭짓점 사이의 최단 경로의 거리를
 * 구하는 알고리즘이다. 음수 가중치를 갖는 간선도 순환만 없다면 잘 처리된다. 제일 바깥쪽 반복문은 거쳐가는 꼭짓점
 * 이고, 두 번째 반복문은 출발하는 꼭짓점, 세 번째 반복문은 도착하는 꼭짓점이다. 이 알고리즘은 플로이드 알고리즘
 * 이라고도 알려져 있다.
 * 
 * 플로이드-워셜 알고리즘은 동적 계획법 접근으로, 그래프 상의 모든 두 정점을 잇는 경로의 최소 비용을 구한다. 
 * 여기에 경유지를 기록하면 최소 비용 경로까지 구할 수 있다. 플로이드-워셜 알고리즘은 다음과 같은 접근으로 설계되었다.
 *   -두 정점을 잇는 최소 비용 경로는 경유지를 거치거나 거치지 않는 경로 중 하나에 속한다.
 *   -만약 경유지를 거친다면 그것을 이루는 부분 경로 역시 최소 비용 경로여야 한다.
 * 
 */

import java.util.Scanner;

class AdjMatrix {
	public int matrix[][]; //정점으로 갈수있는 최소값 저장

	public AdjMatrix(int cNum) {
		matrix=new int[cNum+1][cNum+1];
		for(int i=1;i<cNum+1;i++) {
			for(int j=1;j<cNum+1;j++) {
				matrix[i][j]=(i==j ? 0:100001);
			}
		}
	}
	
	

	public void insertEdge(int v1,int v2,int cost) {
		if(matrix[v1][v2]!=0) {
			if(cost<matrix[v1][v2]) {
				matrix[v1][v2]=cost;
			}
		}
	}	
}


public class graph_11404_플로이드 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start;
		int end;
		int cost;
		
		Scanner sc=new Scanner(System.in);
		int cNum=sc.nextInt();
		AdjMatrix adj=new AdjMatrix(cNum); 
		int costNum=sc.nextInt();
		
		for(int i=0;i<costNum;i++) {
			start=sc.nextInt();
			end=sc.nextInt();
			cost=sc.nextInt();
			adj.insertEdge(start, end, cost);
		}
		
		// Do Floyd-Warshall Algorithm
	    for (int k =1; k < cNum+1; k++)	//경유
	    {
	        for (int i = 1; i < cNum+1; i++)	//출발
	        {
	            for (int j = 1; j < cNum+1; j++)	//도착
	            {	//경유한게 더 작으면 경유값을 최소값으로
	                if (adj.matrix[i][j] > adj.matrix[i][k] + adj.matrix[k][j]) 
	                {
	                	adj.matrix[i][j] = adj.matrix[i][k] + adj.matrix[k][j];
	                }
	            }
	        }
	    }
	    
	    for(int i=1;i<cNum+1;i++) {
			for(int j=1;j<cNum+1;j++) {
				System.out.print(adj.matrix[i][j]+" ");
			}
			System.out.println();
		}

	}
}
