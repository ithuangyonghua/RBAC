package com.ithuangyonghua.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
   public static String formatDate(Date date){
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   return format.format(date);
   }
}
