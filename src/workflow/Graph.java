/**
* 基于AOE网的轻量工作流系统
* Author: FruitBasket
* Time: 2013/4/1
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/

package workflow;

/**
 * 图的接口，使用String作为图顶点的数据类型
 * @author FruitBasket
 *
 */
public interface Graph {
	/**Return the number of vertices in the graph*/
	public int getSize();
	
	/**Return the vertices in the graph*/
	public java.util.List<String> getVertices();
	
	/**Return the object for the specified vertex index*/
	public String getVertex(int index);
	
	/**Return the index for the specified vertex object*/
	public int getIntex(String v);
	
	/**Return the neighbors of vertex with the specified index（返回指定定点的邻接点数组）*/
	public java.util.List<Integer> getNeighbors(int index);
	
	/**Return the degree for a specified vertex*/
	public int getDegree(int v);

}
