package com.sfac.springBoot.util;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Description: Date Time Util
 * @author HymanHu
 * @date 2021-04-13 10:37:35
 */
public class DateTimeUtil {
	/**
	 * - 传入两个时间段，计算两个时间段时间重叠小时数
	 */
	public static int calculateOverlappingTime(LocalDateTime aStart, LocalDateTime aEnd, 
			LocalDateTime bStart, LocalDateTime bEnd) {
		int hour = 0;
		if (aStart.isBefore(bEnd) && aEnd.isAfter(bStart)) {
			long overlappingMinutes = 0;
			// 用 bEnd - aStart 作为重叠基础时间
			Duration baseOverlapping = Duration.between(aStart, bEnd);
			overlappingMinutes = baseOverlapping.toMinutes();
			
			// 计算 aStart、bStart 偏差，如果为正则在基础时间上减去 start 偏差，为负数则忽略
			Duration startBias = Duration.between(aStart, bStart);
			long startBiasMinutes = startBias.toMinutes();
			if (startBiasMinutes > 0) {
				overlappingMinutes -= startBiasMinutes;
			}
			
			// 计算 aEnd、bEnd 偏差，如果为负数忽略，如果为正数则在基础时间上减去 end 偏差
			Duration endBias = Duration.between(aEnd, bEnd);
			long endBiasMinutes = endBias.toMinutes();
			if (endBiasMinutes > 0) {
				overlappingMinutes -= endBiasMinutes;
			}
			
			hour = (overlappingMinutes % 60) > 0 ? (int)(overlappingMinutes / 60) + 1 : (int)(overlappingMinutes / 60);
		}
		
		return hour;
	}
	
	public static void main(String[] args) {
		System.out.println(DateTimeUtil.calculateOverlappingTime(
				LocalDateTime.parse("2021-04-03T00:00:00"), 
				LocalDateTime.parse("2021-04-03T23:59:59"), 
				LocalDateTime.parse("2021-04-02T20:00:00"), 
				LocalDateTime.parse("2021-04-03T05:00:00")));
		System.out.println(DateTimeUtil.calculateOverlappingTime(
				LocalDateTime.parse("2021-04-03T00:00:00"), 
				LocalDateTime.parse("2021-04-03T23:59:59"), 
				LocalDateTime.parse("2021-04-03T03:00:00"), 
				LocalDateTime.parse("2021-04-03T05:00:00")));
		System.out.println(DateTimeUtil.calculateOverlappingTime(
				LocalDateTime.parse("2021-04-03T00:00:00"), 
				LocalDateTime.parse("2021-04-03T23:59:59"), 
				LocalDateTime.parse("2021-04-03T20:00:00"), 
				LocalDateTime.parse("2021-04-04T02:00:00")));
		System.out.println(DateTimeUtil.calculateOverlappingTime(
				LocalDateTime.parse("2021-04-03T00:00:00"), 
				LocalDateTime.parse("2021-04-03T23:59:59"), 
				LocalDateTime.parse("2021-04-02T20:00:00"), 
				LocalDateTime.parse("2021-04-04T02:00:00")));
		System.out.println(DateTimeUtil.calculateOverlappingTime(
				LocalDateTime.parse("2021-04-01T00:00"), 
				LocalDateTime.parse("2021-04-30T23:59:59"), 
				LocalDateTime.parse("2021-04-13T13:37:11"), 
				LocalDateTime.parse("2021-04-14T13:38:41")));
	}
}
