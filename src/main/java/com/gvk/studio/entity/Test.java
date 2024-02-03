package com.gvk.studio.entity;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.println("***Enter Student Marks ***");
		System.out.println("Telugu subject");
		int telugu= scanner.nextInt();
		System.out.println("English subject");
		int english= scanner.nextInt();
		
		//print subject marks
		System.out.println("Telugu Marks :"+telugu);
		System.out.println("English Marks :"+english);
	}

}
