package com.bjtu.hmh;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String args[]) throws ParseException{
		MainPath mainPath = new MainPath(2);//��ͣ10������
		SidePath sidePath = new SidePath(2);//��ͣ5��
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String carNumber;
		String state;
		int date;
		do{
			System.out.println("�������������պ��룺");
			carNumber = scan.next();
			System.out.println("�������������������ȥ����Ϣ��A��ʾ���D��ʾ��ȥ��");
			state = scan.next();
			System.out.println("�������������������ȥ��ʱ�䣺");
			/*DateFormat dt = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date date = dt.parse(scan.next());*/
			date = scan.nextInt();

			Car car = new Car(carNumber);
			car.setState(state);
			car.setDate(date);

			//A-��ջ��D-��ջ
			if(state.equals("A")){
				if(!mainPath.IsFull()){
					mainPath.push(car);
					System.out.println("ͣ���ɹ�");
				}else if(!sidePath.IsFull()){
					sidePath.insert(car);
					System.out.println("ͣ�ڱ����");
				}else{
					System.out.println("��ǰû�п�λ");
				}
			}else if(state.equals("D")){
				boolean flag = false;
				//�����Ƿ���ջ�У��ǵĻ�������ĳ��浽һ����ʱջ
				Car[] temp = mainPath.getCarArray();
				//��ջ�в�������
				for(int i=0;i<mainPath.getCarArray().length;i++){
					//���ҵ��ˣ�����һ����ʱջ
					while(car.getCarNumber().equals(temp[i].getCarNumber())){
						flag = true;
						TempStack tempStack = new TempStack(10);
						int count = i;
						//��i���������ѹ����ʱջ
						for(int j=0;j<temp.length-count-1;j++){
							tempStack.push(mainPath.getTop());
							mainPath.pop();	
						}
						//��mainPathջ��ɾ������i,�������
						int totalMin = car.getDate() - temp[i].getDate();
						mainPath.pop();
						System.out.println("������ջ�ɹ�");
						double totalFee = mainPath.getFeePerMin()*(totalMin);
						System.out.println("����"+car.getCarNumber()+"����ͣ��ʱ��Ϊ"+ totalMin+"����");
						System.out.println("����"+car.getCarNumber()+"����ͣ������Ϊ"+ totalFee+"Ԫ");
						
						for(int m=0;m<temp.length-count-1;m++){
							mainPath.push(tempStack.getTop());
							tempStack.pop();
						}
						//���������������������������ջ
						if(!sidePath.IsEmpty()){
							Car newCar = sidePath.delete();
							newCar.setDate(temp[i].getDate());
							mainPath.push(newCar);
							System.out.println("�����ӱ����������");
						}
					}
					
					break;
				}
				if(flag==false){
					System.out.println("������û��ͣ��������");
				}
			}
		}while(!state.equals("E"));
	}
}
