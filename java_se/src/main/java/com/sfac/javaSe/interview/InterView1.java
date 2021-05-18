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
	
	// 获取对象类型
	public static String getType(Object o) {
		return o.getClass().toString();
	}
	
	/**
	 * 把 M 个同样的苹果放在 N 个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法
	 */
	public static int applePlate(int m, int n) {
		if (m == 0 || n == 1) {
			// 如果碟子只有 1 个，无论苹果有多少个都只有一种放法
			return 1;
		} else if (n > m) {
			// 如果碟子的个数大于苹果的个数，必定有 n-m 个盘子永远空着，去掉它们对摆放苹果方法数目不产生影响
			return applePlate(m, m);
		} else {
			// 当 n <= m 时，放法可以分成两类：含有 0 的方案数，不含有 0 的方案数
			// 含有 0 的方案数：即有至少一个盘子空着，相当于 f(m,n) = f(m,n-1);
			// 不含有 0 的方案数，即所有的盘子都有苹果，相当于可以从每个盘子中拿掉一个苹果，不影响不同放法的数目，即 f(m,n) = f(m-n,n)
			return applePlate(m, n - 1) + applePlate(m - n, n);
		}
	}
	
	public static void main(String[] args) {
//		InterView1.sortSet();
//		System.out.println(Short.SIZE);
//		System.out.println(Integer.SIZE);
//		System.out.println(InterView1.getType(Short.parseShort("11") - 1));
		System.out.println(InterView1.applePlate(7, 3));
	}
}
