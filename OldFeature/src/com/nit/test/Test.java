package com.nit.test;

public class Test
{
	public static void main(String[] args) 
	{
		Test.add(10, 20);
		Test t = new Test();
		t.mul(10, 5);
		
	}
	public static void add(int x,int y)
	{
		System.out.println("Sum is : "+(x+y));
	}
	public void mul(int a,int b)
	{
		System.out.println("Multiplication is: "+(a*b));
	}

}
