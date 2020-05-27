package com.github.linsfilipe.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class Util {
	public static String formatarData(LocalDate date) {
		if (date != null) {
			return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}
		return "";
	}
	
	public static LocalDate dateStringToLocalDate(String date) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		dtf = dtf.withLocale(Locale.getDefault());
		return LocalDate.parse(date, dtf);
	}
}
