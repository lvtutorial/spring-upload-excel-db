package com.hlv.utils;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.xml.bind.DatatypeConverter;

public class Utils {

	static String formatDateToStringDefault = "dd/MM/yyyy";
	static String formatYearMonth = "yyyyMM";
	static String formatymd = "yyyyMMdd";
	static String formatStringToDate = "EEE MMM dd HH:mm:ss z yyyy"; // "dd-MM-yyyy";
	static NumberFormat format = NumberFormat.getInstance(Locale.US);


	/**
	 * Generate a CRON expression is a string comprising 6 or 7 fields separated
	 * by white space.
	 * 
	 * @param seconds
	 *            mandatory = yes. allowed values = {@code  0-59    * / , -}
	 * @param minutes
	 *            mandatory = yes. allowed values = {@code  0-59    * / , -}
	 * @param hours
	 *            mandatory = yes. allowed values = {@code 0-23   * / , -}
	 * @param dayOfMonth
	 *            mandatory = yes. allowed values = {@code 1-31  * / , - ? L W}
	 * @param month
	 *            mandatory = yes. allowed values =
	 *            {@code 1-12 or JAN-DEC    * / , -}
	 * @param dayOfWeek
	 *            mandatory = yes. allowed values =
	 *            {@code 0-6 or SUN-SAT * / , - ? L #}
	 * @param year
	 *            mandatory = no. allowed values = {@code 1970–2099    * / , -}
	 * @return a CRON Formatted String.
	 */

	public static String convertDateToStringYM(Date date) {
		try {
			SimpleDateFormat ft = new SimpleDateFormat(formatYearMonth);
			// System.out.println("sss " + ft.format(date));
			return ft.format(date);
		} catch (Exception ex) {
			// Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null,
			// ex);
			return null;
		}
	}
	
	public static String convertDateToStringYMD(Date date) {
		try {
			SimpleDateFormat ft = new SimpleDateFormat(formatymd);
			// System.out.println("sss " + ft.format(date));
			return ft.format(date);
		} catch (Exception ex) {
			// Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null,
			// ex);
			return null;
		}
	}

	public static Number convertStringToNumber(String sNum) {
		try {
			return format.parse(sNum).doubleValue();
		} catch (ParseException ex) {
			// Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null,
			// ex);
			return null;
		}
	}

	public static Float convertStringToFloat(String sNum) {
		try {
			return Float.valueOf(sNum);
		} catch (Exception ex) {
			// Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null,
			// ex);
			return null;
		}
	}

	public static java.sql.Date convertStringExcelToSqlDate(String sDate) {
		try {
			DateFormat df2 = new SimpleDateFormat(formatStringToDate);
			// set exception if date incorrect
			df2.setLenient(false);
			Date startDate = df2.parse(sDate);
			java.sql.Date sql = new java.sql.Date(startDate.getTime());
			return sql;
		} catch (ParseException ex) {
			// Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null,
			// ex);
			return null;
		}
	}

	public static String generateCronDefault(String str) {
		try {
			String[] strArr = str.split(" ");
			String cron = generateCronExpression("0", strArr[0], strArr[1],
					strArr[2], strArr[3], "?", strArr[4]);
			;
			return cron;
		} catch (Exception ex) {
			return null;
		}

	}

	private static String generateCronExpression(final String seconds,
			final String minutes, final String hours, final String dayOfMonth,
			final String month, final String dayOfWeek, final String year) {
		return String.format("%1$s %2$s %3$s %4$s %5$s %6$s %7$s", seconds,
				minutes, hours, dayOfMonth, month, dayOfWeek, year);
	}

	

	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<String>();
		for (java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

	// then use Spring BeanUtils to copy and ignore null
	public static void copyNonNullProperties(Object src, Object target) {
		BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}

	public static String convertTimestampToString(Timestamp date) {
		try {
			DateFormat df = new SimpleDateFormat(formatDateToStringDefault);
			String result = df.format(date);
			return result;
		} catch (Exception ex) {
			// Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null,
			// ex);
			return null;
		}
	}

	public static void copyProperties(Object frombean, Object tobean,
			List<String> include) {
		final ArrayList<String> excludes = new ArrayList<String>();
		final PropertyDescriptor[] propertyDescriptors = PropertyUtils
				.getPropertyDescriptors(frombean.getClass());
		for (final PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			String propName = propertyDescriptor.getName();
			if (!include.contains(propName)) {
				excludes.add(propName);
			}
		}
		BeanUtils.copyProperties(frombean, tobean,
				excludes.toArray(new String[excludes.size()]));
	}

	public static boolean contains(List<?> coll, Object o) {
		return coll.contains(o);
	}

	

	public static String generateSaltedMD5(String password, String saltPhrase) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			if (saltPhrase != null) {
				md.update(saltPhrase.getBytes());
				byte[] salt = md.digest();

				md.reset();
				md.update(password.getBytes());
				md.update(salt);
			} else

			{
				md.update(password.getBytes());
			}

			byte[] raw = md.digest();
			return convertByteToHex(raw);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String generateSaltedHash(String password, String saltPhrase) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			if (saltPhrase != null) {
				md.update(saltPhrase.getBytes());
				byte[] salt = md.digest();

				md.reset();
				md.update(password.getBytes());
				md.update(salt);
			} else

			{
				md.update(password.getBytes());
			}

			byte[] raw = md.digest();
			// return raw.toString();
			// return Base64.encodeBytes(raw);
			// return convertByteToHex(raw);
			/*
			 * System.out.println(convertByteToHex(raw)); // String s =
			 * "c64bb2fcf888ea957fd70f672ce1600c"; // byte[] b = new
			 * BigInteger(s,16).toByteArray(); byte[] b =
			 * toByteArray(convertByteToHex(raw));
			 * System.out.println(toBase64String(b));
			 */
			// return Base64.encodeBytes(raw);
			return convertByteToHex(raw);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static byte[] toBase64ByteArray(String s) {
		return DatatypeConverter.parseBase64Binary(s);
	}

	public static String toBase64String(byte[] array) {
		return DatatypeConverter.printBase64Binary(array);
	}

	public static String toHexString(byte[] array) {
		return DatatypeConverter.printHexBinary(array);
	}

	public static byte[] toByteArray(String s) {
		return DatatypeConverter.parseHexBinary(s);
	}

	private static String convertByteToHex(byte[] byteData) {

		StringBuilder sb = new StringBuilder();
		// System.out.println("byteData.length " + byteData.length);
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		return sb.toString();
	}

	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
					.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

	public static XSSFWorkbook uploadFileXLSX(String filename,
			byte[] uploadedFile) {
		try {
			System.out.println(uploadedFile);
			if (uploadedFile != null) {
				Date dt = new Date();
				SimpleDateFormat dtfm = new SimpleDateFormat("yyyymmddhhmmss");
				String fileName = filename + "_" + dtfm.format(dt);
				String pathFile = "C:\\" + fileName + ".xlsx";

				FileOutputStream fos = new FileOutputStream(pathFile);
				fos.write(uploadedFile);
				fos.close();

				File file = new File(pathFile);
				FileInputStream fis = new FileInputStream(file);

				XSSFWorkbook wb = new XSSFWorkbook(fis);

				System.out.println("File path name: " + pathFile);

				return wb;
			} else {

				return null;
			}
		} catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException : " + ex);
			return null;
		} catch (IOException ioe) {
			System.out.println("IOException : " + ioe);
			return null;
		} catch (Exception e) {
			System.out.println("IOException : " + e);
			return null;
		}
	}

	private static void log(String aMessage){
	    System.out.println(aMessage);
	  }
	
	public static void main(String[] args) {
		
		log("Generating 6 random integers in range 1..45.");

	    log("Done.");
	}

	public static void importFileXLS(File file) {
		// DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		// df.setLenient(false); // set exception if date incorrect
		try {

			// File file = new File(pathFile);
			FileInputStream fis = new FileInputStream(file);

			String fileName = file.getName();
			System.out.println(fileName);

			List<Object> lst = new ArrayList<Object>();
			String ext = fileName.substring(fileName.lastIndexOf("."));
			if (ext.toUpperCase().equals(".XLSX")) {

				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet = wb.getSheetAt(0);
				int rows = sheet.getLastRowNum() + 1;
				lst.clear();
				for (int row = 1; row < rows; row++) {
					XSSFRow _xrow = sheet.getRow(row);
					for (int col = 1; col < 11; col++) {
						System.out.println("_xrow.getCell: "
								+ _xrow.getCell(col));
					}
					// String accountCode =
					// utility.getCellValue(_xrow.getCell(0));

				}
				wb.close();
			} else {
				System.out.println("22222222222");
			}
		} catch (Exception e) {
			System.out.println("IOException : " + e);
		}

	}
}
