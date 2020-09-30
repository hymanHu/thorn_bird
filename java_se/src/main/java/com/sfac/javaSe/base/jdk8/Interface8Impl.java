package com.sfac.javaSe.base.jdk8;

/**
 * Description: Interface8 Impl
 * @author HymanHu
 * @date 2020-09-30 15:44:15
 */
public class Interface8Impl implements Interface8, Interface82 {

	@Override
	public void helloWorld() {
		System.out.println("Hello World.");
	}
	
	@Override
	public void defaultMethod1() {
		Interface82.super.defaultMethod1();
	}

	public static void main(String[] args) {
		Interface8.staticMethod();
		Interface8 interface8 = new Interface8Impl();
		interface8.helloWorld();
		interface8.defaultMethod1();
		interface8.defaultMethod2();
	}

}
