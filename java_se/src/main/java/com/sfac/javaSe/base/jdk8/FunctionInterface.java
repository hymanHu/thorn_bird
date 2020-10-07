package com.sfac.javaSe.base.jdk8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Description: Function Interface
 * @author: HymanHu
 * @date: 2020年10月6日
 */
public class FunctionInterface {
	
	public static void main(String[] args) {
		
		// 供给型接口
		Supplier<Person> personSupplier = Person :: new;
		personSupplier.get();
		Supplier<Integer> integerSupplier =  () -> (int) (Math.random() * 100);
		System.out.println(integerSupplier.get());
		
		// 消费型接口
		Consumer<Person> personConsumer = (p) -> System.out.println(p.getName());
		personConsumer.accept(new Person("hyman", 44));
		
		// 函数型接口
		Function<Integer, Integer> increase = x -> x + 1;
		Function<Integer, Integer> multiply = x -> 2 * x;
		System.out.println(String.format("%d----%d", increase.apply(3), multiply.apply(3)));
		// 组合函数，compose 先执行，andThen 后执行
		System.out.println(String.format("%d----%d", 
				increase.compose(multiply).apply(3), multiply.andThen(increase).apply(3)));
		
		// 断言型接口
		Predicate<String> stringPredicate = x -> x.length() > 2;
		System.out.println(stringPredicate.test("cdsacas"));
		
	}

}
