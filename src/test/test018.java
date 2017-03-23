package test;

import java.lang.reflect.Method;

public class test018 {

	public static void main(String[] args) throws ReflectiveOperationException{
		
		Class<?> c=java.lang.Class.forName("test.test015");
		Method[] m=c.getDeclaredMethods();
		for(int i=0; i<m.length; i++){
			String s=m[i].getName();
			System.out.println(s);
		}
		
	}
}
