package com.sfac.javaSe.base.jdk8;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

/**
 * Description: Lambda Expression
 * @author HymanHu
 * @date 2020-09-30 11:22:23
 */
public class LambdaExpression {
	
	public void listApply() {
		IntStream.range(0, 10).forEach(System.out :: print);
		System.out.println();
		List<String> list1 = Stream.of("cdsa", null, "fdads", "", "cdsac")
			.filter(Objects :: nonNull) // 不能过滤""
			.filter(item -> StringUtils.isNotBlank(item))
			.map(item -> item.replaceAll("a", "9"))
			.collect(Collectors.toList());
		list1.stream().map(item -> item.toUpperCase()).forEach(System.out :: print);
	}
	
	public static void main(String[] args) {
		LambdaExpression lambdaExpression = new LambdaExpression();
		lambdaExpression.listApply();
	}

}
