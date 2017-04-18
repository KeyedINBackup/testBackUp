package test;

import java.lang.reflect.Method;

public class test020 {

	public static void main(String[] args) throws ReflectiveOperationException{
		
		Class<?> n=Class.forName("test.test015");
		Method[] m=n.getDeclaredMethods();
		for(int i=0; i<m.length; i++){
		String S=m[i].getName();
		System.out.println(S);
		}
	}
}
