package br.com.caelum.vraptor.converters;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.enterprise.inject.Specializes;

import br.com.caelum.vraptor.Convert;

@Specializes
@Convert(Calendar.class)
public class CalendarConverter extends br.com.caelum.vraptor.converter.CalendarConverter {

	@Override
	public Calendar convert(String value, Class<? extends Calendar> type) {
		
		// Convert Date Format YYYY-MM-DD
		String[] split = value.split("-");
		GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(split[0]), Integer.parseInt(split[1]) - 1, Integer.parseInt(split[2]));
		return calendar;
	}

}