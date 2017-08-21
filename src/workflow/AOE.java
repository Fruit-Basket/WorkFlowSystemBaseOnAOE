/**
* ����AOE��������������ϵͳ
* Author: FruitBasket
* Time: 2013/4/1
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/

package workflow;

public class AOE{
	public WeightedGraph weightedGraph;
	private String name;
	
	//����ָ����aoe��
	protected AOE(int[][] edges,String[] vertices){
		int i,j;
		for(i=0;i<edges.length;i++){
			for(j=0;j<edges.length;j++){
				if(edges[i][0]==edges[j][1]){
					System.out.println("aoe���д��ڻ�·��");
					System.out.println("aoe����ʧ�ܣ�");
					return;
				}	
			}
		}
		weightedGraph=new WeightedGraph(edges,vertices);
	}
	//��������Ĭ�ϵ�aoe������
	protected AOE(){
		this.setName("ѧ���������");
		String[] vertices={"ѧ������д���������","����Ա���������������","��ǣ��������������","�೤���Ǽ����������"};
		int[][] edges={
			{0,1,0},{0,2,3},
			{1,3,0},
			{2,3,0}
		};
		weightedGraph=new WeightedGraph(edges,vertices);
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
}
