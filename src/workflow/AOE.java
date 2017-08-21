/**
* 基于AOE网的轻量工作流系统
* Author: FruitBasket
* Time: 2013/4/1
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/

package workflow;

public class AOE{
	public WeightedGraph weightedGraph;
	private String name;
	
	//构建指定的aoe网
	protected AOE(int[][] edges,String[] vertices){
		int i,j;
		for(i=0;i<edges.length;i++){
			for(j=0;j<edges.length;j++){
				if(edges[i][0]==edges[j][1]){
					System.out.println("aoe网中存在回路！");
					System.out.println("aoe构建失败！");
					return;
				}	
			}
		}
		weightedGraph=new WeightedGraph(edges,vertices);
	}
	//构建构建默认的aoe工作流
	protected AOE(){
		this.setName("学生请假审批");
		String[] vertices={"学生：填写请假审批表","辅导员：审批请假审批表","书记：审批请假审批表","班长：登记请假审批表"};
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
