package com.bgi.ms.engine.base.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


/**
 * 工具类:转换
 * 
 *
 */
public final class ConvertUtil {
	
	
	/**字符编码:UTF-8*/
	public static final String CHARSET = "UTF-8";
	
	/**分隔符:逗号*/
	public static final String SEPARATOR_COMMA = ",";
	
	/**分隔符:分号*/
	public static final String SEPARATOR_SEMICOLON = ";";
	
	/**分隔符:冒号*/
	public static final String SEPARATOR_COLON = ":";
	
	/**ASCII码:半角空白*/
	public static final char ASCII_BLANK_DBC = 32;
	
	/**ASCII码:全角空白*/
	public static final char ASCII_BLANK_SBC = 12288;
	
	/**
	 * 将字符转换为字节数组
	 * 
	 * @param c
	 * @return
	 */
	public static byte[] toByteArray(char c) {
		
		byte[] array = new byte[2];
		array[0] = (byte) ((c & 0xFF00) >> 8);
		array[1] = (byte) (c & 0xFF);
		return array;
	}
	
	/**
	 * 将普通字符串转换为UNICODE字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String toUnicode(String str) {
		
		if (null == str) {
			
			return null;
		}
		int len = str.length();
		if (len < 1) {
			
			return null;
		}
		StringBuilder sb = new StringBuilder();
		char c;
		for (int i = 0; i < len; i++) {
			
			c = str.charAt(i);
			if (c > 255) {
				
				sb.append("\\u").append(Integer.toHexString(c));
			} else {
				
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 将UNICODE字符串转换为普通字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String unicodeToString(String str) {
		
		if (ValidatorUtil.isNotContains(str, "\\u")) {
			
			return str;
		}
		String[] array = str.split("\\\\u");
		if (ValidatorUtil.isEmptyArray(array)) {
			
			return str;
		}
		StringBuilder sb = new StringBuilder();
		for (String tmp : array) {
			
			if (ValidatorUtil.isEmptyIgnoreBlank(tmp)) {
				
				sb.append(tmp);
				continue;
			}
			int data = Integer.parseInt(tmp, 16);
			sb.append((char) data);
		}
		return sb.toString();
	}
	
	/**
	 * JavaBean转换为Map
	 * 
	 * @param obj
	 * @return
	 * @throws IntrospectionException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Map<Object, Object> beanToMap(Object obj) throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		
		if (null == obj) {
			
			return null;
		}
		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		
		Map<Object, Object> resultMap = new HashMap<Object, Object>();
		String key = null;
		Object value = null;
		for (PropertyDescriptor property : propertyDescriptors) {
			
			key = property.getName();
			if ("class".equals(key)) {
				
				continue;
			}
			value = property.getReadMethod().invoke(obj);
//			if ("java.math.BigDecimal".equals(property.getPropertyType().getName())) {
//				
//				value = String.valueOf(value);
//			}
//			System.out.println(String.format("key:value = %s:%s", key, value));
			resultMap.put(key, value);
		}
		return resultMap;
	}
	
	/**
	 * 将对象或对象数组转换为List
	 * 
	 * @param array
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> toList(T... array) {
		
		return ValidatorUtil.isEmpty(array) ? null : Arrays.asList(array);
	}
	
	/**
	 * 将字符串转换为字符串数组
	 * 
	 * @param str
	 * @return
	 */
	public static String[] toArray(String str) {
		
		return toArray(str, SEPARATOR_COMMA);
	}
	
	/**
	 * 将字符串转换为字符串数组
	 * 
	 * @param str
	 * @param separator
	 * @return
	 */
	public static String[] toArray(String str, String separator) {
		
		if (null == str || null == separator) {
			
			return null;
		}
		return str.replaceAll("\\s*", "").replaceAll("　", "").split(separator);// 替换空白字符和全角空格
	}
	
	/**
	 * 将字符串转换为整数数组
	 * 
	 * @param str
	 * @return
	 */
	public static Integer[] toArrayInteger(String str) {
		
		return toArrayInteger(toArray(str));
	}
	
	/**
	 * 将字符串转换为整数数组
	 * 
	 * @param str
	 * @param separator
	 * @return
	 */
	public static Integer[] toArrayInteger(String str, String separator) {
		
		return toArrayInteger(toArray(str, separator));
	}
	
	public static Integer[] toArrayInteger(String[] array) {
		
		if (null != array) {
			
			int len = array.length;
			if (len > 0) {
				
				try {
					
					Integer[] result = new Integer[len];
					for (int i=0; i<len; i++) {
						
						result[i] = Integer.valueOf(array[i]);
					}
					return result;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/**
	 * 将字符串转换为整数数组
	 * 
	 * @param str
	 * @return
	 */
	public static Long[] toArrayLong(String str) {
		
		return toArrayLong(toArray(str));
	}
	
	/**
	 * 将字符串转换为整数数组
	 * 
	 * @param str
	 * @param separator
	 * @return
	 */
	public static Long[] toArrayLong(String str, String separator) {
		
		return toArrayLong(toArray(str, separator));
	}
	
	public static Long[] toArrayLong(String[] array) {
		
		if (null != array) {
			
			int len = array.length;
			if (len > 0) {
				
				try {
					
					Long[] result = new Long[len];
					for (int i=0; i<len; i++) {
						
						result[i] = Long.valueOf(array[i]);
					}
					return result;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
//	/**
//	 * 将字节数组转换为十六进制字符串
//	 * 
//	 * @param array
//	 * @return
//	 */
//	public static String toHexString(byte[] array) {
//		
//		String tmp = "";
//		for (int i=0; i<array.length; i++) {
//			
//			tmp += toHexString(array[i]);
//		}
//		return tmp;
//	}
//	
//	private static String toHexString(byte b) {
//		
//		char[] array = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
//		char[] tmpArray = new char[2];
//		tmpArray[0] = array[(b >>> 4) & 0X0F];
//		tmpArray[1] = array[b & 0X0F];
//		return new String(tmpArray);
//	}
	
	/**
	 * 将字节数组转换为十六进制字符串
	 * 
	 * @param array
	 * @return
	 */
	public static String toHexString(byte[] array) {
		
		StringBuilder sb = new StringBuilder();
		for (byte b : array) {
			
			sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString().toUpperCase();
	}
	
	/**
	 * 将对象转换为字符串(忽略指定值)
	 * 
	 * @param obj
	 * @param ignoreValues
	 * @return
	 */
	public static String toStringIgnoreValues(Object obj, String[] ignoreValues) {
		
		return toStringIgnoreValues(obj, ignoreValues, "");
	}
	
	/**
	 * 将对象转换为字符串(忽略指定值)
	 * 
	 * @param obj
	 * @param ignoreValues
	 * @param defaultValue
	 * @return
	 */
	public static String toStringIgnoreValues(Object obj, String[] ignoreValues, String defaultValue) {
		
		if (null != obj) {
			
			String str = String.valueOf(obj);
			if (ValidatorUtil.isNotAllEquals(str, ignoreValues)) {
				
				return str;
			}
		}
		return defaultValue;
	}
	
	/**
	 * 将对象转换为字符串(忽略空值：半角空白、全角空白)
	 * 
	 * @param obj
	 * @return
	 */
	public static String toStringIgnoreBlank(Object obj) {
		
		return toStringIgnoreBlank(obj, "");
	}
	
	/**
	 * 将对象转换为字符串(忽略空值：半角空白、全角空白)
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static String toStringIgnoreBlank(Object obj, String defaultValue) {
		
		if (null != obj) {
			
			String str = String.valueOf(obj);
			if (ValidatorUtil.isNotEmptyIgnoreBlank(str)) {
				
				return trim(str);
			}
		}
		return defaultValue;
	}
	
	/**
	 * 将集合转换为字符串，默认以逗号分隔每项
	 * 
	 * @param <T>
	 * @param collection
	 * @return
	 */
	public static <T> String toString(Iterable<T> collection) {
		
		return toString(collection, SEPARATOR_COMMA);
	}
	
	/**
	 * 将集合转换为字符串
	 * 
	 * @param <T>
	 * @param collection
	 * @param separator
	 * @return
	 */
	public static <T> String toString(Iterable<T> collection, String separator) {
		
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (T item : collection) {
			
			if (isFirst) {
				
				isFirst = false;
			} else {
				
				sb.append(separator);
			}
			sb.append(item);
		}
		return sb.toString();
	}
	
	/**
	 * 将数组转换为字符串，默认以逗号分隔每项
	 * 
	 * @param array
	 * @return
	 */
	public static String toString(Object[] array) {
		
		return toString(array, SEPARATOR_COMMA);
	}
	
	/**
	 * 将数组转换为字符串
	 * 
	 * @param array
	 * @param separator
	 * @return
	 */
	public static String toString(Object[] array, String separator) {
		
		if (ValidatorUtil.isEmpty(array)) {
			
			return null;
		}
		if (array.length == 1) {
			
			return String.valueOf(array[0]);
		}
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (Object obj : array) {
			
			if (isFirst) {
				
				isFirst = false;
			} else {
				
				sb.append(separator);
			}
			sb.append(obj);
		}
		return sb.toString();
	}
	
	/**
	 * 将半角字符串转换成全角字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String toSBC(String str) {

		char[] array = str.toCharArray();
		for (int i=0; i<array.length; i++) {
			
			if (array[i] == ' ') {
				
				array[i] = '\u3000';
			} else if (array[i] < '\177') {
				
				array[i] = (char) (array[i] + 65248);
			}
		}
		return new String(array);
	}
	
	/**
	 * 将全角字符串转换成半角字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String toDBC(String str) {

		char[] array = str.toCharArray();
		for (int i=0; i<array.length; i++) {
			
			if (array[i] == '\u3000') {
				
				array[i] = ' ';
			} else if (array[i] > '\uFF00' && array[i] < '\uFF5F') {
				
				array[i] = (char) (array[i] - 65248);
			}
		}
		return new String(array);
	}
	
	/**
	 * 将对象转换为整数，如果转换失败，则返回空
	 * 
	 * @param obj
	 * @return
	 */
	public static Integer toInteger(Object obj) {
		
		return toInteger(obj, null);
	}
	
	/**
	 * 将对象转换为整数，如果转换失败，则返回默认值
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static Integer toInteger(Object obj, Integer defaultValue) {
		
		String str = String.valueOf(obj);
		if (ValidatorUtil.isNotInteger(str)) {
			
			return defaultValue;
		}
		return Integer.valueOf(str);
	}
	
	/**
	 * 将对象转换为长整数，如果转换失败，则返回空
	 * 
	 * @param obj
	 * @return
	 */
	public static Long toLong(Object obj) {
		
		return toLong(obj, null);
	}
	
	/**
	 * 将对象转换为长整数，如果转换失败，则返回默认值
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static Long toLong(Object obj, Long defaultValue) {
		
		String str = String.valueOf(obj);
		if (ValidatorUtil.isNotInteger(str)) {
			
			return defaultValue;
		}
		return Long.valueOf(str);
	}
	
	/**
	 * 将对象类型强制转换为指定类型
	 * 
	 * @param clazz
	 * @param value
	 * @return
	 */
	public static Object cast(Class<?> clazz, Object value) {
		
		try {
			
			return clazz.cast(value);
		} catch (ClassCastException e) {
			
			String str = String.valueOf(value);
			switch (ValueTypeEnum.valueOf(clazz.getSimpleName().toUpperCase())) {
				
				case SHORT: return Short.parseShort(str);
				case INT: return Integer.parseInt(str);
				case INTEGER: return Integer.parseInt(str);
				case LONG: return Long.parseLong(str);
				case DOUBLE: return Double.parseDouble(str);
				case FLOAT: return Float.parseFloat(str);
				case BOOLEAN: return Boolean.parseBoolean(str);
				case STRING: return str;
				default: return value;
			}
		}
	}
	
	private static enum ValueTypeEnum {
		
		SHORT("short"),
		INT("int"),
		INTEGER("integer"),
		LONG("long"),
		DOUBLE("double"),
		FLOAT("float"),
		BOOLEAN("boolean"),
		CHAR("char"),
		STRING("string");
		
		private String value;
		private ValueTypeEnum(String value) {
			
			this.value = value;
		}
		
		@Override
		public String toString() {
			
			return this.name().concat(":").concat(value);
		}
	}
	
	/**
	 * 将流转换为字符串
	 * 
	 * @param is
	 * @return
	 */
//	public static String streamToString(InputStream is) {
//		
//		return streamToString(is, CHARSET);
//	}
	
	/**
	 * 将流转换为字符串
	 * 
	 * @param is
	 * @param charset
	 * @return
	 */
//	public static String streamToString(InputStream is, String charset) {
//		
//		try {
//			
//			return IOUtils.toString(is, charset);
//		} catch (IOException e) {
//			
//			throw new IllegalArgumentException();
//		}
//	}
	
	/**
	 * 将对象转换为BigDecimal
	 * 
	 * @param obj
	 * @return
	 */
	public static BigDecimal toBigDecimal(Object obj) {
		
		return toBigDecimal(String.valueOf(obj));
	}
	
	/**
	 * 将字符串转换为BigDecimal
	 * 
	 * @param str
	 * @return
	 */
	public static BigDecimal toBigDecimal(String str) {
		
		if (ValidatorUtil.isNotNumeric(str)) {
			
			return null;
		}
		return BigDecimal.valueOf(Double.parseDouble(str));
	}
	
	/**
	 * 截取字符串
	 * 
	 * @param str
	 * @param endIndex
	 * @return
	 */
	public static String substring(String str, int endIndex) {
		
		if (null == str) {
			
			return str;
		}
		int len = str.length();
		if (len < 1) {
			
			return str;
		}
		int index = endIndex > len ? len : endIndex;
		return str.substring(0, index);
	}
	
	/**
	 * 截取字符串
	 * 
	 * @param str
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public static String substring(String str,int startIndex, int endIndex) {
		
		if (null == str) {
			
			return str;
		}
		int len = str.length();
		if (len < 1) {
			
			return str;
		}
		if(startIndex < 0){
			return str;
		}
		int index = endIndex > len ? len : endIndex;
		if(startIndex > index){
			return str;
		}
		return str.substring(startIndex, index);
	}
	
	/**
	 * 去掉两端空格(半角空格、全角空格)
	 * 
	 * @param str
	 * @return
	 */
	public static String trim(String str) {
		
		if (null != str) {
			
			int len = str.length();
			if (len > 0) {
				
				int start = 0;
				int end = len - 1;
				while (start <= end && (str.charAt(start) == ASCII_BLANK_DBC || str.charAt(start) == ASCII_BLANK_SBC)) {
					
					start++;
				}
				while (start <= end && (str.charAt(end) == ASCII_BLANK_DBC || str.charAt(end) == ASCII_BLANK_SBC)) {
					
					end--;
				}
				return str.substring(start, end + 1);
			}
		}
		return str;
	}
	
	/**
	 * 将二进制转换十六进制
	 * 
	 * @param binary
	 * @return
	 */
	public static char binaryToHex(int binary) {
		
		char ch = ' ';
		switch (binary) {
		
			case 0:
				
				ch = '0';
				break;
			case 1:
				
				ch = '1';
				break;
			case 2:
				
				ch = '2';
				break;
			case 3:
				
				ch = '3';
				break;
			case 4:
				
				ch = '4';
				break;
			case 5:
				
				ch = '5';
				break;
			case 6:
				
				ch = '6';
				break;
			case 7:
				
				ch = '7';
				break;
			case 8:
				
				ch = '8';
				break;
			case 9:
				
				ch = '9';
				break;
			case 10:
				
				ch = 'a';
				break;
			case 11:
				
				ch = 'b';
				break;
			case 12:
				
				ch = 'c';
				break;
			case 13:
				
				ch = 'd';
				break;
			case 14:
				
				ch = 'e';
				break;
			case 15:
				
				ch = 'f';
				break;
			default:
				
				ch = ' ';
		}
		return ch;
	}

	/**
	 * 将含特殊字符的字符串转换为驼峰字符串
	 *
	 * @param str
	 * @return
	 */
	public static String stringToHump(String str) {
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='_'){
				arr[i+1]=Character.toUpperCase(arr[i+1]);
			}
		}
		String rStr = new String(arr);
		rStr = rStr.replaceAll("_","");
		return new String(rStr);
	}
	
	/**
     * 把map按key进行正序排列，之间以&相连成String
     * <功能描述>
     * @param params
     * @return String
     */
    public static String getSortParams(Map<Object, Object> params) {
        Map<Object, Object> map = new TreeMap<Object, Object>(
                new Comparator<Object>() {
                    public int compare(Object obj1, Object obj2) {
                        // 升序排序
                        return String.valueOf(obj1).compareTo(String.valueOf(obj2));
                    }
                });
        for (Object key: params.keySet()) {
            map.put(key, params.get(key));
        }
        
        Set<Object> keySet = map.keySet();
        Iterator<Object> iter = keySet.iterator();
        StringBuilder str = new StringBuilder();
        while (iter.hasNext()) {
        	Object key = iter.next();
            Object value = map.get(key);
            str.append(key).append("=").append(value).append("&");
        }
        String result = "";
        if(str.length()>0){
        	result = str.substring(0, str.length()-1);
        }
        return result;
    }

	private ConvertUtil() {}
}
