package com.sfac.javaSe.base.jdk8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @Description: DateTime API
 * @author: HymanHu
 * @date: 2020年10月7日
 */
public class DateTimeAPI {

	public void dateTimeAPITest() {
		
		System.out.println("============ Year | YearMonth | MonthDay ==============");
		Year year = Year.of(2020);
		System.out.println(year.length());
		System.out.println(year.isLeap());
		YearMonth yearMonth = YearMonth.of(2020, 2);
		System.out.println(yearMonth.lengthOfMonth());
		MonthDay monthDay = MonthDay.of(9, 14);
		System.out.println(monthDay);
		System.out.println("============ LocalDate ==============");
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate + "||" + localDate.getYear() + "||" + 
				localDate.getMonth() + "||" + localDate.getMonthValue() + "||" + 
				localDate.getDayOfMonth() + "||" + localDate.getDayOfYear() + "||" + 
				localDate.getDayOfWeek() + "||" + localDate.getDayOfWeek().getValue());
		// 日期赋值与比较
		LocalDate birthday = LocalDate.of(1980, Month.SEPTEMBER, 14);
		System.out.println(birthday);
		System.out.println(birthday.getDayOfYear());
		System.out.println(LocalDate.parse("2020-02-02"));
		System.out.println(LocalDate.parse("20200202", DateTimeFormatter.ofPattern("yyyyMMdd")));
		// 日期比较
		System.out.println(localDate.equals(birthday));
		System.out.println(localDate.isBefore(birthday));
		// 日期修改
		System.out.println(localDate.minusYears(1));
		System.out.println(localDate.minusMonths(1));
		System.out.println(localDate.minusWeeks(1));
		System.out.println(localDate.minusDays(1));
		System.out.println(localDate.plusYears(1));
		System.out.println(localDate.plusMonths(1));
		System.out.println(localDate.plusWeeks(1));
		System.out.println(localDate.plusDays(1));
		System.out.println("============ LocalTime ==============");
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime + "||" + localTime.getHour() + "||" + 
				localTime.getMinute() + "||" + localTime.getSecond() + "||" + 
				localTime.toSecondOfDay() + "||" + localTime.getNano() + "||" + 
				localTime.getLong(ChronoField.NANO_OF_DAY));
		System.out.println(LocalTime.of(18, 20));
		System.out.println(LocalTime.of(18, 20, 33));
		System.out.println(LocalTime.of(18, 20, 33, 555));
		System.out.println(LocalTime.parse("18:09:23"));
		System.out.println(LocalTime.parse("180923", DateTimeFormatter.ofPattern("HHmmss")));
		System.out.println("============ LocalDateTime ==============");
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime + "||" + localDateTime.getYear() + "||" + 
				localDateTime.getMonthValue() + "||" + localDateTime.getDayOfMonth() + "||" + 
				localDateTime.getHour() + "||" + localDateTime.getMinute() + "||" + 
				localDateTime.getSecond() + "||" + localDateTime.getNano());
		LocalDateTime birthday2 = LocalDateTime.of(1980, 9, 14, 11, 22, 33);
		System.out.println(birthday2);
		System.out.println(LocalDateTime.parse("2020-10-07T14:33:35"));
		System.out.println(LocalDateTime.parse("2020-10-07 14:33:35", 
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		System.out.println("============ Instant时间戳 ==============");
		Instant instant = Instant.now();
		System.out.println(instant);
		System.out.println("============ DateTimeFormatter ==============");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(dtf.format(localDateTime));
		System.out.println("============ 计算时间差 ==============");
		Period period = Period.between(birthday, localDate);
		System.out.println(period.getYears() + "||" + period.getMonths() + "||" + period.getDays());
		Duration duration = Duration.between(birthday2, localDateTime);
		System.out.println(duration.toDays() + "||" + duration.toHours());
		System.out.println(ChronoUnit.YEARS.between(birthday2, localDateTime));
		System.out.println(ChronoUnit.MONTHS.between(birthday2, localDateTime));
		System.out.println(ChronoUnit.DAYS.between(birthday2, localDateTime));
	}
	
	public static void main(String[] args) {
		DateTimeAPI dateTimeAPI = new DateTimeAPI();
		dateTimeAPI.dateTimeAPITest();
	}
}
