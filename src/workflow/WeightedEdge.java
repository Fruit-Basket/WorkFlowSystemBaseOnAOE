/**
* ����AOE��������������ϵͳ
* Author: FruitBasket
* Time: 2013/4/1
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/

package workflow;

/**
 * ������ʾ��Ȩ��
 * @author FruitBasket
 *
 */
public class WeightedEdge extends AbstractGraph.Edge
    implements Comparable<WeightedEdge>{
	public int weight;
	
	public WeightedEdge(int u,int v,int weigth){
		super(u,v);
		this.weight=weigth;
	}
	
	public int compareTo(WeightedEdge edge) {
		if(weight>edge.weight)
			return 1;
		else if(weight==edge.weight)
			return 0;
		else
			return -1;
	}

}
