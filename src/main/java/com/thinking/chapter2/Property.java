package com.thinking.chapter2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

/**
 * @author Huangcz
 * @date 2018-12-29 10:44
 * @desc xxx
 */
public class Property {

	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	private static final DateTimeFormatter DATE_TIME_FORMATTER1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH");

	public static void main(String[] args) {
//		System.out.println(new Date());
//
//		Properties properties = System.getProperties();
//
//		properties.list(System.out);
//
//		System.out.println("- - - Memory Usage:");
//		Runtime rt = Runtime.getRuntime();
//		System.out.println("Total Memory = " + rt.totalMemory() + " Free Memory:" + rt.freeMemory());
//


//		// 当前时间 （时分秒）
//		LocalTime localTime = LocalTime.now().withNano(0);
//		String currentHour = localTime.format(TIME_FORMATTER);
//
//		System.out.println(Integer.parseInt(currentHour));



		// 当天零点
		LocalDateTime todayStart = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
		System.out.println(todayStart.format(DATE_TIME_FORMATTER1));

		// 当天零点
		LocalDateTime todayEnd = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
		LocalDateTime settingDateTime = todayEnd.plusHours(1);


		System.out.println(settingDateTime.format(DATE_TIME_FORMATTER1));


		System.out.println(todayFirstDate(2));
		System.out.println(todayLastDate(2));

	}

	/**
	 * 获取当天的1点0分0秒
	 * <p>
	 * 注：需判断当前时间是否在 0点-1点
	 * 若是——当前时间减1天的01点00分00秒
	 * 若否——当前时间的01点00分00秒
	 * 例如：当前时间为 2019-01-08 00:53，则返回 "2019-01-07 01:00:00"
	 *
	 * @return 2019-01-07 01:00:00
	 */
	public static String todayFirstDate(Integer beginHour) {
		//        Calendar calendar = Calendar.getInstance();
		//        calendar.set(Calendar.HOUR_OF_DAY, 0);
		//        calendar.set(Calendar.MINUTE, 0);
		//        calendar.set(Calendar.SECOND, 0);
		//        calendar.set(Calendar.MILLISECOND, 0);
		//        return sdf.format(calendar.getTime());

		String result = "";

		// 当天零点
		LocalDateTime todayStart = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
		LocalDateTime settingDateTime = todayStart.plusHours(beginHour);

		if (belongTime(0, beginHour)) {
			result = settingDateTime.minusDays(1).format(DATE_TIME_FORMATTER1);
		} else {
			result = settingDateTime.format(DATE_TIME_FORMATTER1);
		}
		return result;
	}

	/**
	 * 获取当前第二天的01点00分00秒
	 * <p>
	 * 注：需判断当前时间是否在 0点-1点
	 * 若是——当前第二天时间减1天的01点00分00秒
	 * 若否——当前第二天时间的01点00分00秒
	 * 例如：当前时间为 2019-01-08 00:53，则返回 "2019-01-08 01:00:00"
	 *
	 * @return 2019-01-08 01:00:00
	 */
	public static String todayLastDate(Integer endHour) {
		//        Calendar calendar = Calendar.getInstance();
		//        calendar.set(Calendar.HOUR_OF_DAY, 23);
		//        calendar.set(Calendar.MINUTE, 59);
		//        calendar.set(Calendar.SECOND, 59);
		//        calendar.set(Calendar.MILLISECOND, 999);
		//        return sdf.format(calendar.getTime());
		//		  return LocalDate.now().plusDays(1).format(DATE_FORMATTER) + " 01:00:00";

		String result = "";
		// 第二天日期 （年月日）
		LocalDate secondDayDate = LocalDate.now().plusDays(1);

		// 当天零点
		LocalDateTime todayEnd = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
		LocalDateTime settingDateTime = todayEnd.plusHours(endHour);

		if (belongTime(0, endHour)) {
			result = settingDateTime.minusDays(1).format(DATE_TIME_FORMATTER1);
		} else {
			result = settingDateTime.format(DATE_TIME_FORMATTER1);
		}
		return result;
	}
	/**
	 * 判断当前时间是否在范围内（判断当前时间的小时即可）
	 *
	 * @param beginTimeInt 开始时间，例如：0 时
	 * @param endTimeInt   结束时间，例如：1 时
	 * @return
	 */
	public static boolean belongTime(int beginTimeInt, int endTimeInt) {
		// 当前时间 （时分秒）
		LocalTime localTime = LocalTime.now().withNano(0);
		int currentHour = Integer.parseInt(localTime.format(TIME_FORMATTER));

		if (currentHour >= beginTimeInt && currentHour <= endTimeInt) {
			return true;
		} else {
			return false;
		}
	}
}
