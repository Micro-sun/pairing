package com;

import java.util.Scanner;

public class myapp {
	  public static void main(String[] args) {
		  while(true){
				System.out.println("请输入要设置的数量：");
				Scanner input=new Scanner(System.in); //从键盘上输入指令并执行
				String number=input.nextLine();
				if(number != null){
					int num=Integer.valueOf(number);
					System.out.println("请输入r设置范围：");
					Scanner text2=new Scanner(System.in); //从键盘上输入指令并执行
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
			
