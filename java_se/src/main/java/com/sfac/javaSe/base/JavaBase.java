package com.sfac.javaSe.base;

/**
 * @Description: Java Base
 * @author: HymanHu
 * @date: 2020年12月12日
 */
public class JavaBase {

	// 基本数据类型和包装类
	public void baseData () {
		System.out.println("byte size:" + Byte.SIZE / 8);
		System.out.println("short size:" + Short.SIZE /8);
		System.out.println("int size:" + Integer.SIZE /8);
		System.out.println("long size:" + Long.SIZE /8);
		System.out.println("float size:" + Float.SIZE /8);
		System.out.println("double size:" + Double.SIZE /8);
		System.out.println("char size:" + Character.SIZE /8);
		System.out.println("boolean size:" + Boolean.toString(true));
		
		Integer a = new Integer(1);
		System.out.println(a.intValue());
		a = new Integer("2");
		System.out.println(a.intValue());
		System.out.println(Integer.parseInt("3"));
	}
	
	public static void main(String[] args) {
		JavaBase javaBase = new JavaBase();
		javaBase.baseData();
	}
}
