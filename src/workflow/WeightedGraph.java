/**
* 基于AOE网的轻量工作流系统
* Author: FruitBasket
* Time: 2013/4/1
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/

package workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class WeightedGraph extends AbstractGraph{

	private List <PriorityQueue<WeightedEdge>> queues;
	
	protected WeightedGraph(int[][] edges, String[] vertices) {
		super(edges, vertices);
		createQueue(edges,vertices.length);
	}
	
	private void createQueue(int [][] edges,int numberOfVertices){
	    queues=new ArrayList<PriorityQueue <WeightedEdge>>();
	    for(int i=0;i<numberOfVertices;i++){
	       queues.add(new PriorityQueue<WeightedEdge>());
	    }
	    for(int i=0;i<edges.length;i++){
	    	int u=edges[i][0];
	    	int v=edges[i][1];
	    	int weight=edges[i][2];
	    	queues.get(u).offer(new WeightedEdge(u,v,weight));
	    }
	}
	
	public String getStartVertex(){//设开始顶点一定是序号最小的顶点
		int i=0;
		while(true){
			if(queues.get(i)!=null)
				return this.getVertex(queues.get(i).poll().u);
			i++;
		}
	}
	
	public void printWeightedEdge(){
		for(int i=0;i<queues.size();i++){
			System.out.print("Vertex"+i+":");
			for(WeightedEdge edge:queues.get(i)){
				System.out.print("("+edge.u+","+edge.v+","+edge.weight+")");
			}
			System.out.println();
		}
	}


}
