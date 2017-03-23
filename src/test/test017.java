package test;

import java.lang.reflect.Method;

public class test017 {

	public static void main(String[] args) throws ReflectiveOperationException{
		// This is an Example of Reflection class
		Class<?> Class = java.lang.Class.forName("test.test015");
		Method[] m=Class.getDeclaredMethods();
		for(int i=0; i<m.length; i++){
			String s=m[i].getName();
			System.out.println(s);
		}
		
		
	}
}
