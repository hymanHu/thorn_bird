package com.sfac.javaSe.base.jdk8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Description: Lambda Expression
 * @author HymanHu
 * @date 2020-09-30 11:22:23
 */
public class LambdaExpression {
	
	static String b = "33";
	String c = "cdsa";
	
	@SuppressWarnings("unused")
	public void lambdaTest() {
		// 匿名内部类 ---- Lambda 表达式
		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("匿名内部类原始写法。");
			}
		};
		runnable1.run();
		Runnable runnable2 = () -> System.out.println("Lambda 表达式写法。");
		runnable2.run();
		
		// 匿名内部类作为参数传递
		new Thread(() -> System.out.println("dada")).start();
		TreeSet<String> treeSet1 = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});
		treeSet1.add("cd");
		treeSet1.add("a");
		treeSet1.add("vfd");
		System.out.println(Arrays.toString(treeSet1.toArray()));
		TreeSet<String> treeSet2 = new TreeSet<String>((o1, o2) -> Integer.compare(o1.length(), o2.length()));
		treeSet2.add("gre");
		treeSet2.add("re");
		treeSet2.add("e");
		System.out.println(Arrays.toString(treeSet2.toArray()));
		
		// 方法引用
		Function<Person, String> fun1 = (Person person) -> person.getName();
		Function<Person, String> fun2 = Person :: getName;
		Function<Integer, Integer[]> fun3 = (n) -> new Integer[n];
		Function<Integer, Integer[]> fun4 = Integer[] :: new;
		Consumer<String> con1 = x -> System.out.println(x);
		Consumer<String> con2 = System.out :: println;
		Supplier<Integer> sup1 = () -> new Random().nextInt();
		
		// 变量作用域
		int a = 22;
		new Thread(() -> System.out.println(a)).start();
		new Thread(() -> System.out.println(b)).start();
		new Thread(() -> System.out.println(c)).start();
	}
	
	public static void main(String[] args) {
		LambdaExpression lambdaExpression = new LambdaExpression();
//		lambdaExpression.listApply();
		lambdaExpression.lambdaTest();
	}

}
