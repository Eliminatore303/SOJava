package test;

import java.util.ArrayList;
import java.util.Iterator;

public class test {
//trying to builnd an arraylist of string in wich i can read all data and modify them
	public static void main(String[] args) {
		// creating the array list
		ArrayList<String> type= new ArrayList<String>();
		boolean flag=true;
		int x=0;
		//adding some data
		for (int i = 0; i < 10; i++) {
			type.add(""+i);
		}
		//printing that data
		System.out.println("Printing start array!");
		for (int i = 0; i < type.size(); i++) {
			System.out.println("i: "+i+" value: "+type.get(i));
		}
		//modifing a specific data
		type.set(2, ""+12);//-> 2 is the 3° position because it start from 0
		//printing modified arraylist
		System.out.println("Printing modified array!");
		for (int i = 0; i < type.size(); i++) {
			System.out.println("i: "+i+" value: "+type.get(i));
		}
		//searcing for a specific value and printing it
		System.out.println("searcing for the element: 12");
		while (flag) {
			if (x<type.size()) {
				if (type.get(x).compareTo("12")==0) {
					flag=false;
					System.out.println("find the element I was searcing for: "+type.get(x)+" at position: "+x);
				}else {
					x++;
				}
			}else {
				flag=false;
				System.out.println("I didn't find the element I was searcing for: 12");
			}
		}
	}

}
