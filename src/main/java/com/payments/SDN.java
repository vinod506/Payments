package com.payments;

import java.util.*;

public class SDN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		String s1=sc.nextLine();
		s1 = s1.replaceAll("[^a-zA-Z0-9 ]", "");
		s1=s1.toLowerCase();
		String[] arrOfStr = s1.split(" ");
		Arrays.sort(arrOfStr);
		StringBuffer sb = new StringBuffer();
	    for(int i = 0; i < arrOfStr.length; i++)
	       sb.append(arrOfStr[i]);
	    String str = sb.toString();
	    System.out.println(str);
//        for (String a : arrOfStr)
//            System.out.println(a);
		
	}

}
