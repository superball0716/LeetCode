package huawei410;

import java.util.Scanner;

/**
*
*@author superball
*@time 2018年4月10日下午7:40:29
*/
public class Main3 {
	public static void main(String [] args){
		Scanner scanner = new Scanner(System.in);
		String aString = scanner.nextLine();
		String bString = scanner.nextLine();
		int [] res = new int [aString.length()+bString.length()];
		for(int i=0;i<aString.length();i++){
			for(int j=0;j<bString.length();j++){
				res[i+j+1] += Integer.parseInt(aString.substring(i,i+1))*Integer.parseInt(bString.substring(j,j+1));
			}
		}
		for(int i=res.length-1;i>0;i--){
			if(res[i]>=10){
				res[i-1] += res[i]/10;
				res[i] = res[i]%10;
			}
		}
		StringBuilder sb = new StringBuilder();
		int i=0;
		while(res[i]==0){
			i++;
		}
		while(i<res.length){
			sb.append(String.valueOf(res[i]));
			i++;
		}
		System.out.println(sb.toString());
	}
}
