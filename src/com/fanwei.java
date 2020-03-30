package com;

import java.util.Random;

public class fanwei {
	private fanwei(){}
	
	public static String make(int fanwei2){
		Random rd = new Random();
		int b4 = rd.nextInt(fanwei2);
		int b5 = rd.nextInt(fanwei2);
		int b1 = rd.nextInt(20);
		if(b1<=5){
			return b4+"+"+b5;
		}else 
		if(b1<=10){
			if(b4<b5) { b4=b4+b5; b5=b4-b5; b4=b4-b5;}
			return b4+"-"+b5;
	    }else 
	    if(b1<=15){
	    	return b4+"¡Á"+b5;
	    }else 
	    {
	    	if(b5<b4) { b4=b4+b5; b5=b4-b5; b4=b4-b5;}
	    	return b4+"¡Â"+b5;
	    }
	}
}
