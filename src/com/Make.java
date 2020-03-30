package com;

import java.util.Random;

public class Make {
	int[] num = new int[8];
	StringBuilder sb = new StringBuilder();
	char[] mychar = new char[3];
	public Make(int i){
		Random r= new Random();
		for (int j = 0; j < 3; j++) {
			num[j]=r.nextInt(i);
			sb.append(num[j]);
			switch (r.nextInt(3)) {
			case 0:mychar[j]='+'; break;
			case 1:mychar[j]='-'; break;
			case 2:mychar[j]='*'; break;
			default: mychar[j]='/'; break;
			}
			sb.append(mychar[j]);
			
		}
		num[3]=r.nextInt(i);
		sb.append(num[3]);
		
	}
}
