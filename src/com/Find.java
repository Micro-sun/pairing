package com.liu;

public class Find {
	private  Find() {
		
	}
	
	//计算两项的算式
	public static String find(String str) {
		int index;
		int index2 = str.indexOf('/');
		int a;
		int b;
		int sum;
		if(str.indexOf('×')!=-1||str.indexOf('÷')!=-1){
			if(str.indexOf('÷')!=-1){
				index = str.indexOf('÷');
				if(index2!=-1){
					str = str.replace(str, fenshu(str, index, index2));
				}else{
					a = leftLinkNum(str,index-1);
					b = rightLinkNum(str,index+1);
					String s = a+"÷"+b;
					String s1 = makeEasy(a+"/"+b);
					str = str.replace(s, s1);
				}
				return str;
			}else{
				index = str.indexOf('×');
				if(index2!=-1){
					System.out.println("我到这了");
					str = str.replace(str, fenshu(str, index, index2));
				}else{
					a = leftLinkNum(str,index-1);
					b = rightLinkNum(str,index+1);
					sum = a*b;
					String s = a+"×"+b;
					str = str.replace(s, Integer.toString(sum));
				}
				return str;
			}
		}else if(str.indexOf('+')!=-1||str.indexOf('-')!=-1){
			if(str.indexOf('-')!=-1){
				index = str.indexOf('-');
				if(index2!=-1){
					str = str.replace(str, fenshu(str, index, index2));
				}else{
					a = leftLinkNum(str,index-1);
					b = rightLinkNum(str,index+1);
					sum = a-b;
					String s = a+"-"+b;
					str = str.replace(s, Integer.toString(sum));
				}
				return str;
			}else{
				index = str.indexOf('+');
				if(index2!=-1){
					str = str.replace(str, fenshu(str, index, index2));
				}else{
					a = leftLinkNum(str,index-1);
					b = rightLinkNum(str,index+1);
					sum = a+b;
					String s = a+"+"+b;
					str = str.replace(s, Integer.toString(sum));
				}
				return str;
			}
		}else return str;
		
		
	}
	
	//符号左边的数字连接成为一个int
	public static int leftLinkNum(String str,int index) {   
		int num = 0;
		int i =0;
		int[] arr = new int[10];
		while(str.charAt(index)<='9'&&str.charAt(index)>='0'){
			arr[i] = str.charAt(index)-48;
			i++;
			if(index==0) break;
			index--;
		}
		for (int j = 0; j < i; j++) {
			num =num + arr[j]*(int)Math.pow(10, j);
		}
		return num;
	}
	
	//符号右边边的数字连接成为一个int
	public static int rightLinkNum(String str,int index) {
		int num = 0;
		int i = 0;
		int b = 0;
		int[] arr = new int[10];
		while(str.charAt(index)<='9'&&str.charAt(index)>='0'){
			arr[i] = str.charAt(index)-48;
			i++;
			if(index>=str.length()-1) break;
			index++;
		}
		for (int j = i; j > 0; j--) {
			num =num + arr[b]*(int)Math.pow(10, j-1);
			b++;
		}
		return num;
	}
	
	//分数化简
	public static String makeEasy(String str){
		int index = str.indexOf('/');
		int a = leftLinkNum(str,index-1);
		int b = rightLinkNum(str,index+1);
		int gcd = gcd(a,b);
		if(b/gcd==1) return a/gcd+"";
		else
		return a/gcd + "/" + b/gcd;
	}
	
	public static int gcd(int x, int y){ // 这个是运用辗转相除法求 两个数的 最大公约数 
		if(y == 0)
		return x;
		else
		return gcd(y,x%y);
	}
	
	//计算带有分数的式子，index1为运算符的索引，index2是“/”的索引
	public static String fenshu(String str , int index1 ,int index2){
		int[] arr = {0,0,0,0};
		int k;
		String sum;
		if(index1>index2) {
			arr[0]=leftLinkNum(str, index2-1);
			arr[1]=rightLinkNum(str, index2+1);
			arr[2]=rightLinkNum(str, index1+1);
			arr[3]=1;
			k=str.indexOf('/', index1);
			if(k!=-1){
				arr[3]=rightLinkNum(str, k+1);
			}
		}else {
			arr[3] = rightLinkNum(str, index2+1);
			arr[2] = leftLinkNum(str, index2-1);
			arr[0]=leftLinkNum(str, index1-1);
			arr[1]=1;
		}
		if(str.charAt(index1)=='+'){
			arr[0]=arr[0]*arr[3];
			arr[2]=arr[2]*arr[1];
			arr[1]=arr[1]*arr[3];
			arr[3]=arr[1];
			arr[0]=arr[0]+arr[2];
			sum=makeEasy(arr[0]+"/"+arr[1]);
		}else if(str.charAt(index1)=='-'){
			arr[0]=arr[0]*arr[3];
			arr[2]=arr[2]*arr[1];
			arr[1]=arr[1]*arr[3];
			arr[3]=arr[1];
			arr[0]=arr[0]-arr[2];
			sum=makeEasy(arr[0]+"/"+arr[1]);
		}else if(str.charAt(index1)=='*'){
			arr[0]=arr[0]*arr[2];
			arr[1]=arr[1]*arr[3];
			sum=makeEasy(arr[0]+"/"+arr[1]);
		}else{
			arr[2]=arr[2]+arr[3];
			arr[3]=arr[2]-arr[3];
			arr[2]=arr[2]-arr[3];
			arr[0]=arr[0]*arr[2];
			arr[1]=arr[1]*arr[3];
			sum=makeEasy(arr[0]+"/"+arr[1]);
		}
		return sum;
	}
	
}
