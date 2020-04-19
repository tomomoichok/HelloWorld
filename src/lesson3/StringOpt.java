package lesson3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringOpt {
	public static void main(String[] args) {
//		String str;
//		System.out.println(str);
		String str = null;

//		if (!str.isEmpty()) {
//			//hogehoge
//		}
//		str = "";
//		System.out.println(str == null);

//		String str1 = "hogehoge";
//		String str2 = "hogehoge";
//
//		if (str1.equals(str2)) {
//			System.out.println("str1とstr2は一緒です。");
//		} else {
//			System.out.println("str1とstr2は違います。");
//		}
//
//		if (str1 == str2) {
//			System.out.println("str1とstr2は一緒です。");
//		} else {
//			System.out.println("str1とstr2は違います。");
//		}

//		String str1 = "hogehoge";
//		String str2 = new String("hogehoge");
//		if (str1.equals(str2)) {
//			System.out.println("str1とstr2は一緒です。");
//		} else {
//			System.out.println("str1とstr2は違います。");
//		}
//
//		if (str1 == str2) {
//			System.out.println("str1とstr2は一緒です。");
//		} else {
//			System.out.println("str1とstr2は違います。");
//		}
//		String aa = "aaa";
////		System.out.println(aa.length());
//		String bb = "bb";
//		System.out.println(aa + bb);
//
//		StringBuilder sb = new StringBuilder();
//		sb.append("aaa");
//		sb.append("bb");
//		sb.append("ccc");
//		System.out.println(sb.toString());

//		System.out.println(aa.length());
//		String aa = "qwertywe";
//		System.out.println(aa.replaceAll("[a-z]", "aa"));

//		String aa = "123";
//		int b = Integer.parseInt(aa);
//		String cc = String.valueOf(b);
//		Integer dd = 123;
//		String ee = dd.toString();
//		System.out.println(ee);



		try {
			String strd = "20200418 12:00:00";
	        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
	        Date d = sd.parse(strd);
	        System.out.println("d : " + sd.format(d));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
