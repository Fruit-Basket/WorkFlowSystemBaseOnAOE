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

/**
 * 使用边的数组来存放边
 * @author FruitBasket
 *
 */
public abstract class AbstractGraph implements Graph {
    protected List<String> vertices;
    protected List<List<Integer>> neighbors;
    
    protected AbstractGraph(int [][] edges,String[] vertices){
    	this.vertices=new ArrayList<String>();
    	for(int i=0;i<vertices.length;i++)
    		this.vertices.add(vertices[i]);
    	createAdjacencyLists(edges,vertices.length);
    }
    
	
    /**Create adjacency lists for each vertex*/
    private void createAdjacencyLists(int[][] edges,int numberOfVertices){
    	neighbors=new ArrayList<List<Integer>>();
    	for(int i=0;i<numberOfVertices;i++){
    		neighbors.add(new ArrayList<Integer>());
    	}
    	for(int i=0;i<edges.length;i++){
    		int u=edges[i][0];
    		int v=edges[i][1];
    		neighbors.get(u).add(u);
    	}
    }
    
    /**Return the number of vertices in the graph*/
	public int getSize() {
		return vertices.size();
	}
	
	/**Return all the vertices in the graph*/
	public List<String> getVertices() {
		return vertices;
	}

    /**Return the object for the specified vertex*/
	public String getVertex(int index) {
		return vertices.get(index);
	}
    
	public int getIntex(String v) {
		return vertices.indexOf(v);
	}
	
	/**Return the neighbors of vertax with the specified index*/
	public List<Integer> getNeighbors(int index) {
		return neighbors.get(index);
	}
	
	/**Return the out-degreee for a specified vertex*/
	public int getDegree(int v) {
		return neighbors.get(v).size();
	}

	/**An inner class inside the AbstarctGraph class,which to mean a edge*/
	public static class Edge{
		public int u;//starting vertex of the edge
		public int v;//ending vertex of the edge
		
		public Edge(int u,int v){
			this.u=u;
			this.v=v;
		}
	}
}
