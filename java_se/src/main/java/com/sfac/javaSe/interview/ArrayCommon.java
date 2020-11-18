package com.sfac.javaSe.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Description: Array Common
 * @author HymanHu
 * @date 2020-11-18 09:47:55
 */
public class ArrayCommon {

	/**
	 * -嵌套循环
	 */
	public static List<Integer> findCommon1(int[] arr1, int[] arr2) {
		long start = System.currentTimeMillis();
		
		List<Integer> list = new ArrayList<Integer>();
		if (ArrayUtils.isEmpty(arr1) || ArrayUtils.isEmpty(arr2)) {
			return list;
		}
		
		for (int i : arr1) {
			for (int j : arr2) {
				if (i == j) {
					list.add(i);
				}
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start));
		
		return list;
	}
	
	/**
	 * -并归思想，查找之前先排序，用下标控制两个数组，比较每一位的值是否相等，相等则添加，不等则将数值小的下标++
	 */
	public static List<Integer> findCommon2(int[] arr1, int[] arr2) {
		long start = System.currentTimeMillis();
		
		List<Integer> list = new ArrayList<Integer>();
		if (ArrayUtils.isEmpty(arr1) || ArrayUtils.isEmpty(arr2)) {
			return list;
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int i = 0, j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] == arr2[j]) {
				list.add(arr1[i]);
				i ++;
				j ++;
			} else if(arr1[i] < arr2[j]) {
				i ++;
			} else {
				j ++;
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start));
		
		return list;
	}
	
	/**
	 * -使用 list contains 方法进行判断，比较耗时
	 */
	public static List<Integer> findCommon3(int[] arr1, int[] arr2) {
		long start = System.currentTimeMillis();
		
		if (ArrayUtils.isEmpty(arr1) || ArrayUtils.isEmpty(arr2)) {
			return new ArrayList<Integer>();
		}
		
		List<Integer> temp = Arrays.stream(arr1).boxed().collect(Collectors.toList());
		List<Integer> list =  Arrays.stream(arr2).filter(item -> temp.contains(item)).boxed().collect(Collectors.toList());
		
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start));
		
		return list;
	}
	
	public static void main(String[] args) {
		int[] arr1 = IntStream.range(1, 10001).toArray();
		int[] arr2 = IntStream.range(10000, 20002).toArray();
		System.out.println(findCommon1(arr1, arr2));
		System.out.println(findCommon2(arr1, arr2));
		System.out.println(findCommon3(arr1, arr2));
	}
}
