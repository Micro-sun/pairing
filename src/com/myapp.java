package com;

import java.util.Scanner;

public class myapp {
	  public static void main(String[] args) {
		  while(true){
				System.out.println("������Ҫ���õ�������");
				Scanner input=new Scanner(System.in); //�Ӽ���������ָ�ִ��
				String number=input.nextLine();
				if(number != null){
					int num=Integer.valueOf(number);
					System.out.println("������r���÷�Χ��");
					Scanner text2=new Scanner(System.in); //�Ӽ���������ָ�ִ��
					String round=text2.nextLine();
					if(round!=null){
						int round2=Integer.valueOf(round);
						for(int i = 0;i<num;i++){
							String s = fanwei.make(round2);
							System.out.println(s+"="+Calculate.calcu(s));
						}
						break;
					}
				}
		
		  }
	  }
}
			
