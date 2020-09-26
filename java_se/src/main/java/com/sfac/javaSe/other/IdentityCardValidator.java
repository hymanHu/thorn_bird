package com.sfac.javaSe.other;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Description: 身份证验证器
 * @author: HymanHu
 * @date: 2020年9月26日
 */
public class IdentityCardValidator {
	
	/**
	 * 身份证验证器，公式：(∑(Ai×Wi) ≡ 1 mod 11
	 * ≡：同余，表示余数相同；
	 * mod：模，表述除数，示例： 2 ≡ 9 mod 7 ---- 2 除以 7 余 2，9 除以 7 余 2，两者是同余的；
	 * Ai：身份证号从右向左第 i 位数字；
	 * Wi：加权因子，计算公式：Wi = 2 ^(i - 1) mod 11 ---- 2 的 i - 1 次幂 模 11；
	 * (∑(Ai×Wi)，表示 ai*wi 之和，i 从 0 到 17；
	 */
	public static boolean identityCardValidator(String identityCardNumber) {
		StringBuffer sb = new StringBuffer(identityCardNumber);
		final List<String> ai = Arrays.asList(sb.reverse().toString().split(""));
		System.out.println(String.format("Ai: %s", String.join("-", ai)));
		
		final List<String> wi = Stream.iterate(0, i -> i + 1).limit(ai.size())
				.map(i -> {return (int)Math.pow(2.0, i) % 11 + "";})
				.collect(Collectors.toList());
		System.out.println(String.format("Wi: %s", String.join("-", wi)));
		
		int count = IntStream.range(0, ai.size())
				.map(i -> {
					return Integer.parseInt(ai.get(i).equalsIgnoreCase("x") ? "10" : ai.get(i)) * 
						Integer.parseInt(wi.get(i));
				}).reduce((i, j) -> i + j).getAsInt();
		System.out.println(String.format("(∑(Ai×Wi): %d", count));
		
		return count % 11 == 1;
	}
	
	public static void main(String[] args) {
		System.out.println(identityCardValidator("220202202002020022"));
	}

}
