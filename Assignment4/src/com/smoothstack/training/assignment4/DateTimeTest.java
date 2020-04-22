package com.smoothstack.training.assignment4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class DateTimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int year = LocalDateTime.now().getYear();

	
	public List<Integer> monthDays() {

		LocalDate firstInYear = LocalDate.now().with(TemporalAdjusters.firstDayOfYear());
		List<Integer> days = new ArrayList<Integer>();

		  for (int i = 0; i< 12; i++){
		  Month tempMonth = firstInYear.getMonth().plus(i);
		  
		  days.add(tempMonth.length(firstInYear.isLeapYear()));
		  }

		  return days;
	}
	
	public List<LocalDate> mondays() {
		LocalDate firstInYear = LocalDate.now().with(TemporalAdjusters.firstDayOfYear());
		
		List<LocalDate> mondays = new ArrayList<LocalDate>();
		
		for (int i = 1; i <= 5; i++) {
			LocalDate tempDate = firstInYear.plusWeeks(i).with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
			mondays.add(tempDate);
		}
		
		return mondays;
	}
	
	public boolean isFriday13() {
		LocalDate firstInYear = LocalDate.now().with(TemporalAdjusters.firstDayOfYear());
		
		if((firstInYear.getDayOfWeek().equals(DayOfWeek.FRIDAY) && (firstInYear.getDayOfMonth() == 13))){
			return true;
		}
		
		return false;
	}

}
