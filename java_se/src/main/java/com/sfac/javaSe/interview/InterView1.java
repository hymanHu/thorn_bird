package com.sfac.javaSe.interview;

import java.util.HashSet;
import java.util.Set;

public class InterView1 {

	/**
	 * set remove 方法移除元素，该题中，set 元素类型是 Short, Short - 1 转化为 Integer 类型，remove 无法删除 
	 */
	public static void sortSet() {
		Set<Short> set = new HashSet<Short>();
		for (Short i = 0; i < 100; i++) {
			set.add(i);
//			set.remove(Short.parseShort((i - 1) + ""));
			set.remove(i - 1);
		}
		System.out.println(set.size());
	}
	
	public static String getType(Object o) {
		return o.getClass().toString();
	}
	
	public static void main(String[] args) {
		InterView1.sortSet();
		System.out.println(Short.SIZE);
		System.out.println(Integer.SIZE);
		System.out.println(InterView1.getType(Short.parseShort("11") - 1));
	}
}
