package com.sfac.javaSe.base.jdk8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description: Stream API
 * @author: HymanHu
 * @date: 2020年10月6日
 */
public class StreamAPI {
	
	public void streamApiTest() {
		System.out.println("========= 创建流 ==========");
		// 集合创建流
		List<Integer> list = Arrays.asList(1, 2, 4, 5, 6, 12, 34, 8);
		list.stream().forEach(System.out :: print);
		System.out.println();
		// 数组创建流
		String[] array1 = new String[]{"cdas", "cdscf", "vvfd", "rrr"};
		Arrays.stream(array1).forEach(System.out :: print);
		System.out.println();
		// 值创建流
		Stream.of("cdsa", "vfds", "vgsv").forEach(System.out :: print);
		System.out.println();
		// 函数创建流
		Stream.iterate(0, i -> i + 2).limit(10).forEach(System.out :: print);
		System.out.println();
		Stream.generate(new Random() :: nextInt).limit(10).forEach(System.out :: print);
		System.out.println();
		Stream.generate(UUID :: randomUUID).limit(10).forEach(item -> System.out.print(item + "="));
		System.out.println();
		IntStream.range(0, 10).forEach(System.out :: print);
		System.out.println();
		// 集合不存储基本数据类型，boxed 将基本数据类型转化为包装类
		list = IntStream.range(1, 10).boxed().collect(Collectors.toList());
		System.out.println(list);
		
		System.out.println("========= 流操作 ==========");
		Integer first = list.stream().filter(i -> i == 4).findFirst().orElse(null);
		System.out.println(first);
		List<Integer> list2 = Arrays.asList(1, 2, 4, 5, 6, 12, 34, 8);
		list2 = list2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		list2 = list2.stream().sorted(Comparator.comparing(Integer :: intValue).reversed())
				.collect(Collectors.toList());
		System.out.println(list2);
		list2 = list2.stream().peek(i -> System.out.println(i + 2)).collect(Collectors.toList());
		System.out.println(list2);
		System.out.println(list2.stream().map(i -> i + 2).reduce((i, j) -> i + j).get());
		
		// list
		List<String> list1 = Stream.of("cdsa", "cdsa", null, "fdads", "", "cdsac")
			.filter(Objects :: nonNull) // 不能过滤""
			.filter(item -> StringUtils.isNotBlank(item))
			.distinct()
			.map(item -> item.replaceAll("a", "9"))
			.map(item -> item.toUpperCase())
			.collect(Collectors.toList());
		System.out.println(list1);
		
		// map
		Map<String, String> map = new HashMap<String, String>();
		map.put("ccccc", "c_c_c_c");
		map.put("aaaaa", "a_a_a_a");
		map.put("ddddd", "d_d_d_d");
		map.put("bbbbb", "b_b_b_b");
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out :: println);
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(item -> {
			System.out.println(item.getKey() + "--" + item.getValue());
		});
		Map<String, String> resultMap = map.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(
						Map.Entry :: getKey, 
						Map.Entry :: getValue, 
						(oldValue, newValue) -> oldValue, LinkedHashMap :: new));
		System.out.println(resultMap);
		String key = map.entrySet().stream()
				.filter(item -> item.getValue().equals("c_c_c_c"))
				.map(item -> item.getKey())
				.collect(Collectors.joining());
		System.out.println("result key: " + key);
	}
	
	public static void main(String[] args) {
		StreamAPI streamAPI = new StreamAPI();
		streamAPI.streamApiTest();
	}
}
