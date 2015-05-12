package com.bjtu.hmh;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String args[]) throws ParseException{
		MainPath mainPath = new MainPath(2);//能停10辆汽车
		SidePath sidePath = new SidePath(2);//能停5辆
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String carNumber;
		String state;
		int date;
		do{
			System.out.println("请输入汽车牌照号码：");
			carNumber = scan.next();
			System.out.println("请输入汽车到达或者离去的信息，A表示到达，D表示离去：");
			state = scan.next();
			System.out.println("请输入汽车到达或者离去的时间：");
			/*DateFormat dt = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date date = dt.parse(scan.next());*/
			date = scan.nextInt();

			Car car = new Car(carNumber);
			car.setState(state);
			car.setDate(date);

			//A-入栈，D-出栈
			if(state.equals("A")){
				if(!mainPath.IsFull()){
					mainPath.push(car);
					System.out.println("停车成功");
				}else if(!sidePath.IsFull()){
					sidePath.insert(car);
					System.out.println("停在便道上");
				}else{
					System.out.println("当前没有空位");
				}
			}else if(state.equals("D")){
				boolean flag = false;
				//查找是否在栈中，是的话将后面的车存到一个临时栈
				Car[] temp = mainPath.getCarArray();
				//在栈中查找汽车
				for(int i=0;i<mainPath.getCarArray().length;i++){
					//当找到了，创建一个临时栈
					while(car.getCarNumber().equals(temp[i].getCarNumber())){
						flag = true;
						TempStack tempStack = new TempStack(10);
						int count = i;
						//将i后面的汽车压入临时栈
						for(int j=0;j<temp.length-count-1;j++){
							tempStack.push(mainPath.getTop());
							mainPath.pop();	
						}
						//从mainPath栈中删除汽车i,计算费用
						int totalMin = car.getDate() - temp[i].getDate();
						mainPath.pop();
						System.out.println("汽车出栈成功");
						double totalFee = mainPath.getFeePerMin()*(totalMin);
						System.out.println("汽车"+car.getCarNumber()+"的总停车时间为"+ totalMin+"分钟");
						System.out.println("汽车"+car.getCarNumber()+"的总停车费用为"+ totalFee+"元");
						
						for(int m=0;m<temp.length-count-1;m++){
							mainPath.push(tempStack.getTop());
							tempStack.pop();
						}
						//如果便道上有汽车，便道上汽车进栈
						if(!sidePath.IsEmpty()){
							Car newCar = sidePath.delete();
							newCar.setDate(temp[i].getDate());
							mainPath.push(newCar);
							System.out.println("汽车从便道进入主道");
						}
					}
					
					break;
				}
				if(flag==false){
					System.out.println("汽车并没有停在主道上");
				}
			}
		}while(!state.equals("E"));
	}
}
