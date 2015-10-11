package org.paypal.hackathon.project.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class PaypalHackathonUtils {

	public static final String DATE_FORMAT_1 = "MM/dd/yyyy HH:mm";

	public static String convertDateToString(Date date, String format) {
		final SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}

	public static Date convertStringToDate(String date, String format) {
		final SimpleDateFormat formatter = new SimpleDateFormat(format);

		try {
			final Date dateObject = formatter.parse(date);
			return dateObject;
		} catch (final ParseException e) {
			return null;
		}
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		@SuppressWarnings("unchecked")
		final Map.Entry<K, V>[] array = map.entrySet().toArray(new Map.Entry[map.size()]);

		Arrays.sort(array, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
				return e1.getValue().compareTo(e2.getValue());
			}
		});

		final Map<K, V> result = new LinkedHashMap<K, V>();
		for (final Map.Entry<K, V> entry : array) {
			result.put(entry.getKey(), entry.getValue());
		}

		return result;
	}
}
