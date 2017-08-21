/**
* ����AOE��������������ϵͳ
* Author: FruitBasket
* Time: 2013/4/1
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/

package workflow;

/**
 * ͼ�Ľӿڣ�ʹ��String��Ϊͼ�������������
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
	
	/**Return the neighbors of vertex with the specified index������ָ��������ڽӵ����飩*/
	public java.util.List<Integer> getNeighbors(int index);
	
	/**Return the degree for a specified vertex*/
	public int getDegree(int v);

}
