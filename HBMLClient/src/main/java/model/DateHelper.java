package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


public class DateHelper 
{
		public static String dateToString(Date date)
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return dateFormat.format(date);
		}
		
		public static Date localDateToDate(LocalDate localDate) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = dateFormat.parse(localDate.toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return date;
		}
		
		public static LocalDate dateToLocalDate(Date date)
		{
			String dateStr = dateToString(date);
			int year = Integer.parseInt(dateStr.substring(0, 4));
			int month = Integer.parseInt(dateStr.substring(5, 7));
			int day = Integer.parseInt(dateStr.substring(8, 10));
			LocalDate localDate = LocalDate.of(year, month, day);
			return localDate;
		}
}
