package com.sfac.javaSe.base.jdk8;

/**
 * Description: jdk8 接口，新增了“默认方法”、“静态方法”
 * @author HymanHu
 * @date 2020-09-30 15:37:30
 */
public interface Interface8 {
	
	void helloWorld();
	
	public static void staticMethod( ) {
		System.out.println("This is a static method.");
	}
	
	default public void defaultMethod1() {
		System.out.println("This is default method 1.");
	}
	
	default public String defaultMethod2() {
		System.out.println("This is default method 2.");
		return "defaultMethod";
	}
}
