/**
* ����AOE��������������ϵͳ
* Author: FruitBasket
* Time: 2013/4/1
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/

package workflow;

import java.util.List;
import java.util.Scanner;

public class UseWorkFlow {
	private AOE[] aoeArray={null,null,null};//��ഴ��3��������
	private int count=0;
	public void initialInterface(){
		
		System.out.println("*****************************************");
		System.out.println("       ����AOE����������������ϵͳ");
		System.out.println("*****************************************");
		System.out.println("         1.����Ĭ�ϵĹ���������ѧ���������");
		System.out.println("         2.����ָ���Ĺ�����");
		System.out.println("         3.�鿴�Ѵ����Ĺ�����");
		System.out.println("         4.�������й�����");
		System.out.println("         0.�˳�����");
		System.out.println("*****************************************");
		
		int choice;
		Scanner scan=new Scanner(System.in);
		System.out.println("��ѡ��");
		choice=scan.nextInt();
		while(choice>0){
			switch(choice){
			case 1:
				createDufaultAOE();
				break;
			case 2:
				System.out.println("��ģ����ʱ�����ã�");
				break;
			case 3:
				showWorkFlow();
				break;
			case 4:
				useWorkFlow();
				break;
			}
			System.out.println("��ѡ��");
			choice=scan.nextInt();
		}
	}
	public void createDufaultAOE(){
		if(count>3){
			System.out.println("���ֻ�ܴ���3����������");
			return;
		}
		System.out.println("���ڴ���������...");
		int indexOfAOE=count;
		aoeArray[count++]=new AOE();
		List<String> verticesList;
		verticesList=aoeArray[indexOfAOE].weightedGraph.getVertices();
		int size=verticesList.size();
		
		System.out.println("��������㣺");
		for(int i=0;i<size;i++){
			System.out.print(i+"."+verticesList.get(i)+"  ");
			if(i%5==0&&i!=0)
				System.out.println();
		}
		System.out.println();
		System.out.println("�߼���");
		aoeArray[indexOfAOE].weightedGraph.printWeightedEdge();
		System.out.println("������������ɣ�");
	}
	
	public void showWorkFlow(){
		if(count<=0){
			System.out.println("���ڻ�û�й�������");
			return ;
		}
		List<String> verticesList;
		int indexOfAOE=count-1;
		verticesList=aoeArray[indexOfAOE].weightedGraph.getVertices();
		int size=verticesList.size();
		for(int i=0;i<=indexOfAOE;i++){
			System.out.println(i+"."+aoeArray[i].getName());
			System.out.println("��������㣺");
			for(int j=0;j<size;j++){
				System.out.print(j+"."+verticesList.get(j)+"  ");
				if(j%5==0&&j!=0)
					System.out.println();
			}
			System.out.println();
			System.out.println("�߼���");
			aoeArray[indexOfAOE].weightedGraph.printWeightedEdge();
		}
	}
	
	public void useWorkFlow(){
		showWorkFlow();
		int choice;
		Scanner scan=new Scanner(System.in);
		
		System.out.println("������Ҫ���ȵĹ�������");
		choice=scan.nextInt();
		switch(choice){
		case 0:
			if(count<=0)
			{
				System.out.println("��������");
				return;
			}
			work(0);
			break;
		case 1:
			if(count<=1)
			{
				System.out.println("��������");
				return;
			}
			work(1);
			break;
		case 2:
			if(count<=2)
			{
				System.out.println("��������");
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
		
		currentVertex="ѧ������д���������";
		System.out.println("�����������ݺ�Ҫ�������飬�硰ѧ������д���������:");
		
		Scanner scan=new Scanner(System.in);
		inputVertex=scan.next();
		if(inputVertex.equals(currentVertex)){
			if(currentVertex=="ѧ������д���������"){
			  System.out.println("���! ���������������");
			  int days=scan.nextInt();
			  if(days<=3){
				  currentVertex="����Ա���������������";
			  }
			  else{
				  currentVertex="��ǣ��������������";
			  }
			  //System.out.println("hello");
			}
			if(currentVertex=="����Ա���������������"){
				System.out.println("����Ա,���!");
				System.out.println("�Ƿ�������\n1.��\n2.��");
				int choice=scan.nextInt();
				if(choice==1){
					currentVertex="�೤���Ǽ����������";
				}
				else{
					System.out.println("������������");
					return;
				}
			}
			if(currentVertex=="��ǣ��������������"){
				System.out.println("���,���!");
			    System.out.println("�Ƿ�������\n1.��\n2.��");
			    int choice=scan.nextInt();
			    if(choice==1){
				    currentVertex="�೤���Ǽ����������";
			    }
			    else{
				    System.out.println("������������");
				    return;
			    }
			}
			if(currentVertex=="�೤���Ǽ����������"){
				System.out.println("����೤�Ǽǹ����Ѿ���ɣ�");
				System.out.println("������������");
				return;
			}
		}
		else
			System.out.println("�㵱ǰû�¿�����");
	}
}
