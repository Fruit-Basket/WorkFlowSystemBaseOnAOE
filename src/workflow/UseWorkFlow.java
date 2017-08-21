/**
* 基于AOE网的轻量工作流系统
* Author: FruitBasket
* Time: 2013/4/1
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/

package workflow;

import java.util.List;
import java.util.Scanner;

public class UseWorkFlow {
	private AOE[] aoeArray={null,null,null};//最多创建3个工作流
	private int count=0;
	public void initialInterface(){
		
		System.out.println("*****************************************");
		System.out.println("       基于AOE网的轻量级工作流系统");
		System.out.println("*****************************************");
		System.out.println("         1.创建默认的工作流——学生请假审批");
		System.out.println("         2.创建指定的工作流");
		System.out.println("         3.查看已创建的工作流");
		System.out.println("         4.调度现有工作流");
		System.out.println("         0.退出程序");
		System.out.println("*****************************************");
		
		int choice;
		Scanner scan=new Scanner(System.in);
		System.out.println("请选择：");
		choice=scan.nextInt();
		while(choice>0){
			switch(choice){
			case 1:
				createDufaultAOE();
				break;
			case 2:
				System.out.println("此模快暂时不可用！");
				break;
			case 3:
				showWorkFlow();
				break;
			case 4:
				useWorkFlow();
				break;
			}
			System.out.println("请选择：");
			choice=scan.nextInt();
		}
	}
	public void createDufaultAOE(){
		if(count>3){
			System.out.println("最多只能创建3个工作流！");
			return;
		}
		System.out.println("正在创建工作流...");
		int indexOfAOE=count;
		aoeArray[count++]=new AOE();
		List<String> verticesList;
		verticesList=aoeArray[indexOfAOE].weightedGraph.getVertices();
		int size=verticesList.size();
		
		System.out.println("工作流结点：");
		for(int i=0;i<size;i++){
			System.out.print(i+"."+verticesList.get(i)+"  ");
			if(i%5==0&&i!=0)
				System.out.println();
		}
		System.out.println();
		System.out.println("边集：");
		aoeArray[indexOfAOE].weightedGraph.printWeightedEdge();
		System.out.println("工作流创建完成！");
	}
	
	public void showWorkFlow(){
		if(count<=0){
			System.out.println("现在还没有工作流！");
			return ;
		}
		List<String> verticesList;
		int indexOfAOE=count-1;
		verticesList=aoeArray[indexOfAOE].weightedGraph.getVertices();
		int size=verticesList.size();
		for(int i=0;i<=indexOfAOE;i++){
			System.out.println(i+"."+aoeArray[i].getName());
			System.out.println("工作流结点：");
			for(int j=0;j<size;j++){
				System.out.print(j+"."+verticesList.get(j)+"  ");
				if(j%5==0&&j!=0)
					System.out.println();
			}
			System.out.println();
			System.out.println("边集：");
			aoeArray[indexOfAOE].weightedGraph.printWeightedEdge();
		}
	}
	
	public void useWorkFlow(){
		showWorkFlow();
		int choice;
		Scanner scan=new Scanner(System.in);
		
		System.out.println("请输入要调度的工作流：");
		choice=scan.nextInt();
		switch(choice){
		case 0:
			if(count<=0)
			{
				System.out.println("输入有误！");
				return;
			}
			work(0);
			break;
		case 1:
			if(count<=1)
			{
				System.out.println("输入有误！");
				return;
			}
			work(1);
			break;
		case 2:
			if(count<=2)
			{
				System.out.println("输入有误！");
				return;
			}
			work(2);
			break;
		}
	}
	
	public void work(int index){
		List<String> vertices=aoeArray[index].weightedGraph.getVertices();
		int size=vertices.size();
		String currentVertex,inputVertex;
		
		currentVertex="学生：填写请假审批表";
		System.out.println("请输入你的身份和要做的事情，如“学生：填写请假审批表”:");
		
		Scanner scan=new Scanner(System.in);
		inputVertex=scan.next();
		if(inputVertex.equals(currentVertex)){
			if(currentVertex=="学生：填写请假审批表"){
			  System.out.println("你好! 请输入请假天数：");
			  int days=scan.nextInt();
			  if(days<=3){
				  currentVertex="辅导员：审批请假审批表";
			  }
			  else{
				  currentVertex="书记：审批请假审批表";
			  }
			  //System.out.println("hello");
			}
			if(currentVertex=="辅导员：审批请假审批表"){
				System.out.println("辅导员,你好!");
				System.out.println("是否审批？\n1.是\n2.否");
				int choice=scan.nextInt();
				if(choice==1){
					currentVertex="班长：登记请假审批表";
				}
				else{
					System.out.println("工作流结束！");
					return;
				}
			}
			if(currentVertex=="书记：审批请假审批表"){
				System.out.println("书记,你好!");
			    System.out.println("是否审批？\n1.是\n2.否");
			    int choice=scan.nextInt();
			    if(choice==1){
				    currentVertex="班长：登记请假审批表";
			    }
			    else{
				    System.out.println("工作流结束！");
				    return;
			    }
			}
			if(currentVertex=="班长：登记请假审批表"){
				System.out.println("假设班长登记工作已经完成！");
				System.out.println("工作流结束！");
				return;
			}
		}
		else
			System.out.println("你当前没事可做！");
	}
}
