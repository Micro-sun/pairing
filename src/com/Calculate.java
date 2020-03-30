package com;

public class Calculate {
	private Calculate() {	
	}
	 
	public static String calcu(String str){
		String daan=str;
		if(str.indexOf('(')==-1){
			do{
				daan=Find.find(daan);
			}while(daan!=Find.find(daan));
		}
		return daan;
	}
}
