package com.bgi.ms.engine.base.utils;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.codehaus.jettison.json.JSONObject;

/**
 * 工具类:校验
 * 
 *
 */
public final class ValidatorUtil {
	
	private static final Log logger = LogFactory.getLog(ValidatorUtil.class);

	/**字符串:"null"*/
	public static final String NULL = "null";
	
	/**字符串:"."*/
	public static final String DOT = ".";
	
	/**字符串:"/"*/
	public static final String SLASH = "/";
	
	/**字符串:"\r\n"*/
	public static final String CRLF = "\r\n";
	
	/**字符串:"\n"*/
	public static final String NEWLINE = "\n";
	
	/**字符串:"0"*/
	public static final String ZERO = "0";
	
	/**ASCII码:半角空白*/
	public static final char ASCII_BLANK_DBC = 32;
	
	/**ASCII码:全角空白*/
	public static final char ASCII_BLANK_SBC = 12288;
	
	public static final int MOBILE_LENGTH = 11;
	
	/**中国移动手机号码段*/
	public static final String MOBILE_CMCC = "134, 135, 136, 137, 138, 139, 147, 150, 151, 152, 157, 158, 159, 178, 182, 183, 184, 187, 188";
	
	/**中国联通手机号码段*/
	public static final String MOBILE_CUCC = "130, 131, 132, 145, 155, 156, 175, 176, 185, 186";
	
	/**中国电信手机号码段*/
	public static final String MOBILE_CTCC = "133, 149, 153, 173, 177, 180, 181, 189";
	
	
	/**
	 * 判断字符串是否为有效的手机号码(支持虚拟运营商)
	 * 
	 * <br>各运营商手机号段, 更新日期:2016-06-17
	 * <br>移动:134, 135, 136, 137, 138, 139, 147, 150, 151, 152, 157, 158, 159, 178, 182, 183, 184, 187, 188
	 * <br>联通:130, 131, 132, 145, 155, 156, 175, 176, 185, 186
	 * <br>电信:133, 149, 153, 173, 177, 180, 181, 189
	 * <br>虚拟:170, 171
	 * 
	 * @param str
	 * @return
	 */
	
	
	/**
	 * 判断字符串是否为正整数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPositiveInteger(String str) {

		if (null != str) {
			
			int len = str.length();
			if (len > 0 && str.charAt(0) != '0') {
				
				for (int i=0; i<len; i++) {
					
					if (!Character.isDigit(str.charAt(i))) {
						
						return false;
					}
				}
				return true;
			}
		}
		return false;
		//return null == str ? false : str.matches("^[1-9]\\d*$");
	}
	
	/**
	 * 判断字符串是否不为正整数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotPositiveInteger(String str) {
		
		return !isPositiveInteger(str);
	}
	
	/**
	 * 判断字符串是否为正整数，并且正整数的大小不能超过指定范围
	 * 
	 * @param str
	 * @param min
	 * @param max
	 * @return
	 */
	public static boolean isPositiveInteger(String str, int min, int max) {
		
		if (isNotPositiveInteger(str) || min < 1 || max < min) {
			
			return false;
		}
		int v = Integer.parseInt(str);
		if (v < min || v > max) {
			
			return false;
		}
		return true;
	}
	
	/**
	 * 判断字符串是否为自然数
	 * @param str
	 * @return
	 */
	public static boolean isNaturalInteger(String str) {
		if(isInteger(str) && Integer.valueOf(str) >= 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不为为自然数
	 * @param str
	 * @return
	 */
	public static boolean isNotNaturalInteger(String str) {
		
		return !isNaturalInteger(str);
	}

	/**
	 * 判断多个字符串是否都为自然数
	 * @param params
	 * @return
	 */
	public static boolean isAllNaturalInteger(String... params) {
		for (String tmp : params) {
			
			if (isNotNaturalInteger(tmp)) {
				
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断多个字符串是否都不为自然数
	 * @param params
	 * @return
	 */	
	public static boolean isNotAllNaturalInteger(String... params) {
		for (String tmp : params) {
			
			if (isNaturalInteger(tmp)) {
				
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断字符串是否不为正整数，或者正整数的大小超过指定范围
	 * 
	 * @param str
	 * @param min
	 * @param max
	 * @return
	 */
	public static boolean isNotPositiveInteger(String str, int min, int max) {
		
		return !isPositiveInteger(str, min, max);
	}
	
	/**
	 * 判断字符串是否为正整数，并且正整数的大小不能超过最大值
	 * 
	 * @param str
	 * @param max
	 * @return
	 */
	public static boolean isPositiveInteger(String str, int max) {
		
		return !isNotPositiveInteger(str, max);
	}
	
	/**
	 * 判断字符串是否不为正整数，或者正整数的大小超过最大值
	 * 
	 * @param str
	 * @param max
	 * @return
	 */
	public static boolean isNotPositiveInteger(String str, int max) {
		
		return isNotPositiveInteger(str) || max < 1 || Integer.parseInt(str) > max;
	}
	
	/**
	 * 判断整数是否为正整数
	 * 
	 * @param v
	 * @return
	 */
	public static boolean isPositiveInteger(Integer v) {
		
		return !isNotPositiveInteger(v);
	}
	
	/**
	 * 判断整数是否不为正整数
	 * 
	 * @param v
	 * @return
	 */
	public static boolean isNotPositiveInteger(Integer v) {
		
		return null == v || v < 1;
	}
	
	/**
	 * 判断整数是否为正整数
	 * 
	 * @param v
	 * @return
	 */
	public static boolean isPositiveInteger(Long v) {
		
		return !isNotPositiveInteger(v);
	}
	
	/**
	 * 判断整数是否不为正整数
	 * 
	 * @param v
	 * @return
	 */
	public static boolean isNotPositiveInteger(Long v) {
		
		return null == v || v < 1;
	}
	
	/**
	 * 判断多个字符串至少有一个为正整数
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isPositiveInteger(String... params) {
		
		for (String tmp : params) {
			
			if (isPositiveInteger(tmp)) {
				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断多个字符串中至少有一个不为正整数
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isNotPositiveInteger(String... params) {
		
		for (String tmp : params) {
			
			if (isNotPositiveInteger(tmp)) {
				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断多个字符串是否都为正整数
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isAllPositiveInteger(String... params) {
		
		for (String tmp : params) {
			
			if (isNotPositiveInteger(tmp)) {
				
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断多个字符串是否都不为正整数
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isNotAllPositiveInteger(String... params) {
		
		for (String tmp : params) {
			
			if (isPositiveInteger(tmp)) {
				
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断字符串是否为整数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {
		
		return null == str ? false : str.matches("^0|(-?[1-9]\\d*)$");
	}
	
	/**
	 * 判断字符串是否不为整数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotInteger(String str) {
		
		return !isInteger(str);
	}
	
	/**
	 * 判断字符串是否为指定范围内的整数(取值范围:大于等于min或小于等于max)
	 * 
	 * @param str
	 * @param min
	 * @param max
	 * @return
	 */
	public static boolean isInteger(String str, int min, int max) {
		
		if (isNotInteger(str)) {
			
			return false;
		}
		int v = Integer.parseInt(str);
		if (v < min || v > max) {
			
			return false;
		}
		return true;
	}
	
	/**
	 * 判断字符串是否不为指定范围内的整数(取值范围:大于等于min或小于等于max)
	 * 
	 * @param str
	 * @param min
	 * @param max
	 * @return
	 */
	public static boolean isNotInteger(String str, int min, int max) {
		
		return !isInteger(str, min, max);
	}
	
	/**
	 * 判断整数是否在指定范围内(取值范围:大于等于min或小于等于max)
	 * 
	 * @param v
	 * @param min
	 * @param max
	 * @return
	 */
	public static boolean isInteger(Integer v, int min, int max) {
		
		return !isNotInteger(v, min, max);
	}
	
	/**
	 * 判断整数是否不在指定范围内(取值范围:大于等于min或小于等于max)
	 * 
	 * @param v
	 * @param min
	 * @param max
	 * @return
	 */
	public static boolean isNotInteger(Integer v, int min, int max) {
		
		return null == v || min >= max || v < min || v > max;
	}
	
	/**
	 * 判断多个字符串中至少有一个为整数
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isInteger(String... params) {
		
		for (String tmp : params) {
			
			if (isInteger(tmp)) {
				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断多个字符串中至少有一个不为整数
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isNotInteger(String... params) {
		
		for (String tmp : params) {
			
			if (isNotInteger(tmp)) {
				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断多个字符串是否都为整数
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isAllInteger(String... params) {
		
		for (String tmp : params) {
			
			if (isNotInteger(tmp)) {
				
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断多个字符串是否都不为整数
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isNotAllInteger(String... params) {
		
		for (String tmp : params) {
			
			if (isInteger(tmp)) {
				
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断字符串是否为非零的整数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isIntegerNotZero(String str) {
		
		return null == str ? false : str.matches("^-?[1-9]\\d*$");
	}
	
	/**
	 * 判断字符串是否为小数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDecimal(String str) {
		
		return null == str ? false : str.matches("^-?(0|[1-9]\\d*)\\.\\d+$");
	}
	
	/**
	 * 判断字符串是否不为小数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotDecimal(String str) {
		
		return !isDecimal(str);
	}
	
	/**
	 * 判断字符串是否为数字(整数或小数)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		
		return null == str ? false : str.matches("^-?(0|[1-9]\\d*)(\\.\\d+)?$");
	}
	
	/**
	 * 判断字符串是否不为数字(整数或小数)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNumeric(String str) {
		
		return !isNumeric(str);
	}
	
	/**
	 * 判断多个字符串中至少有一个为数字(整数或小数)
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isNumeric(String... params) {
		
		for (String tmp : params) {
			
			if (isNumeric(tmp)) {
				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断多个字符串中至少有一个不为数字(整数或小数)
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isNotNumeric(String... params) {
		
		for (String tmp : params) {
			
			if (isNotNumeric(tmp)) {
				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断字符串是否为有效的中国大陆身份证号码(不含港澳台)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isID(String str) {
		
		String regex = "^((1[1-5])|(2[1-3])|(3[1-7])|(4[1-6])|(5[0-4])|(6[1-5]))(\\d{13}|\\d{16}|(\\d{15}[x|X]))$";
		return null == str ? false : str.matches(regex);
	}
	
	/**
	 * 判断字符串是否为无效的中国大陆身份证号码(不含港澳台)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotID(String str) {
		
		return !isID(str);
	}
	
	/**
	 * 判断字符串是否为有效的中国大陆行政区划代码(不含港澳台)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isAreaCode(String str) {
		
		String regex = "^((1[1-5])|(2[1-3])|(3[1-7])|(4[1-6])|(5[0-4])|(6[1-5]))\\d{4}$";
		return null == str ? false : str.matches(regex);
	}
	
	/**
	 * 判断字符串是否为无效的中国大陆行政区划代码(不含港澳台)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotAreaCode(String str) {
		
		return !isAreaCode(str);
	}

	/**
	 * 判断字符串是否为有效的电子邮箱地址
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		// 建议使用该正则String regex = "^(\\w)+(\\.\\w+)*@[a-zA-Z0-9]\\w+\\.[a-z]{2,}(\\.[a-z]{2,})?$";
		// 当前使用的正则和APP端的正则保持一致
		//String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		String regex = "^(\\w)+([-|\\.]\\w+)*@[a-zA-Z0-9]\\w+\\.[a-z]{2,}(\\.[a-z]{2,})?$";
		return null == str ? false : str.matches(regex);
	}
	
	/**
	 * 判断字符串是否为无效的电子邮箱地址
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmail(String str) {
		
		return !isEmail(str);
	}

	/**
	 * 判断字符串是否为有效的手机号码(不支持虚拟运营商)
	 * 
	 * <br>各运营商手机号段, 更新日期: 2016-06-17
	 * <br>移动: 134, 135, 136, 137, 138, 139, 147(上网卡), 150, 151, 152, 157, 158, 159, 178(4G), 182, 183, 184, 187, 188
	 * <br>联通: 130, 131, 132, 145(上网卡), 155, 156, 175, 176(4G), 185, 186
	 * <br>电信: 133, 149, 153, 173, 177(4G), 180, 181, 189
	 * <br>其他(不在匹配规则内): 1349(电信卫星通信); 170, 171(虚拟运营商); 1700(虚拟运营商电信号段); 1705(虚拟运营商移动号段); 1707, 1708, 1709(虚拟运营商联通号段)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isMobile(String str) {
		/**
		 * 手机号码格式
		 * 
		 * 1-3位: 网络识别号
		 * 4-7位: 地区编码(HLR归属位置寄存器)
		 * 8-11位: 用户号码(随机分配)
		 */
		return null == str ? false : str.matches("^1(3(4[0-8]\\d{7}|[0-3,5-9]\\d{8})|(4[579]|5[0-3,5-9]|7[3,5-8]|8\\d)\\d{8})$");// 2016-06-17
		//return null == str ? false : str.matches("^1(3\\d|4[57]|5[0-3,5-9]|7[6-8]|8\\d)\\d{8}$");// 2014-05-01
	}
	
	/**
	 * 判断字符串是否为无效的手机号码
	 * 
	 * <br>各运营商手机号段, 更新日期: 2016-06-17
	 * <br>移动: 134, 135, 136, 137, 138, 139, 147(上网卡), 150, 151, 152, 157, 158, 159, 178(4G), 182, 183, 184, 187, 188
	 * <br>联通: 130, 131, 132, 145(上网卡), 155, 156, 175, 176(4G), 185, 186
	 * <br>电信: 133, 149, 153, 173, 177(4G), 180, 181, 189
	 * <br>其他(不在匹配规则内): 1349(电信卫星通信); 170, 171(虚拟运营商); 1700(虚拟运营商电信号段); 1705(虚拟运营商移动号段); 1707, 1708, 1709(虚拟运营商联通号段)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotMobile(String str) {
		
		return !isMobile(str);
	}
	
	/**
	 * 判断字符串是否为有效的手机号码(支持虚拟运营商)
	 * 
	 * <br>各运营商手机号段, 更新日期:2016-06-17
	 * <br>移动:134, 135, 136, 137, 138, 139, 147, 150, 151, 152, 157, 158, 159, 178, 182, 183, 184, 187, 188
	 * <br>联通:130, 131, 132, 145, 155, 156, 175, 176, 185, 186
	 * <br>电信:133, 149, 153, 173, 177, 180, 181, 189
	 * <br>虚拟:170, 171
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isMobileVirtual(String str) {
		
		return null == str ? false : str.matches("^1(3(4[0-8]\\d{7}|[0-3,5-9]\\d{8})|(4[579]|5[0-3,5-9]|7[0,1,3,5-8]|8\\d)\\d{8})$");
	}
	
	/**
	 * 判断字符串是否为无效的手机号码
	 * 
	 * <br>各运营商手机号段, 更新日期:2016-06-17
	 * <br>移动:134, 135, 136, 137, 138, 139, 147, 150, 151, 152, 157, 158, 159, 178, 182, 183, 184, 187, 188
	 * <br>联通:130, 131, 132, 145, 155, 156, 175, 176, 185, 186
	 * <br>电信:133, 149, 153, 173, 177, 180, 181, 189
	 * <br>虚拟:170, 171
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotMobileVirtual(String str) {
		
		return !isMobileVirtual(str);
	}
	
	/**
	 * 判断字符串是否为虚拟运营商手机号码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isVirtualMobile(String str) {
		// 以170,171开头
		return null == str ? false : str.matches("^17[0,1]\\d{8}$");
	}
	
	/**
	 * 判断字符串是否不为虚拟运营商手机号码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotVirtualMobile(String str) {
		
		return !isVirtualMobile(str);
	}
	
	/**
	 * 判断字符串是否为中国移动手机号码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isMobileCMCC(String str) {
		
		boolean flag = null == str ? false : str.matches("^1\\d{10}$");
		if (flag) {
			
			return MOBILE_CMCC.contains(str.substring(0, 3));
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不为中国移动手机号码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotMobileCMCC(String str) {
		
		return !isMobileCMCC(str);
	}
	
	/**
	 * 判断字符串是否为中国联通手机号码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isMobileCUCC(String str) {
		
		boolean flag = null == str ? false : str.matches("^1\\d{10}$");
		if (flag) {
			
			return MOBILE_CUCC.contains(str.substring(0, 3));
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不为中国联通手机号码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotMobileCUCC(String str) {
		
		return !isMobileCUCC(str);
	}
	
	/**
	 * 判断字符串是否为中国电信手机号码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isMobileCTCC(String str) {
		
		boolean flag = null == str ? false : str.matches("^1\\d{10}$");
		if (flag) {
			
			return MOBILE_CTCC.contains(str.substring(0, 3));
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不为中国电信手机号码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotMobileCTCC(String str) {
		
		return !isMobileCTCC(str);
	}
	
	/**
	 * 判断字符串是否为有效的固定电话号码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isTel(String str) {
		
		return null == str ? false : str.matches("^(\\d{3}-\\d{8}|\\d{4}-\\d{7,8})(-\\d{1,10})?$");
	}
	/**
	 * 判断字符串是否包含特殊的固定电话号码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isSpTel(String str) {
		
		return null == str ? false : str.matches("^(\\d{3}-\\d{8}|(0\\d{2,3})\\d{7,8}|\\d{4}-\\d{7,8})(-\\d{1,10})?$");
	}
	
	/**
	 * 判断字符串是否为无效的固定电话号码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotTel(String str) {
		
		return !isTel(str);
	}
	
	/**
	 * 判断字符串是否为有效的电话号码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str) {
		
		return isMobile(str) || isTel(str);
	}
	
	/**
	 * 判断字符串是否为无效的电话号码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotPhone(String str) {
		
		return !isPhone(str);
	}
	
	/**
	 * 判断字符串是否为有效的邮政编码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPostcode(String str) {
		
		return null == str ? false : str.matches("^[0-9]\\d{5}$");
	}
	
	/**
	 * 判断字符串是否为无效的邮政编码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotPostCode(String str) {
		
		return !isPostcode(str);
	}
	
	/**
	 * 判断字符串是否为有效的IP地址
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isIP(String str) {
		
		return null == str ? false : str.matches("^(?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))$");
	}
	
	/**
	 * 判断字符串是否为无效的IP地址
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotIP(String str) {
		
		return !isIP(str);
	}

	/**
	 * 判断字符串是否为空值(空值:null, "")
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		
		return null == str || str.length() < 1;
	}
	
	/**
	 * 判断字符串是否为非空值(空值:null, "")
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		
		return !isEmpty(str);
	}
	
	/**
	 * 判断多个字符串中是否存在空值(空值:null, "")
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isEmpty(String... params) {
		
		if (null != params && params.length > 0) {
			
			for (String str : params) {
				
				if (isEmpty(str)) {
					
	        		return true;
	        	}
			}
			return false;
		}
		return true;
	}
	
	/**
	 * 判断多个字符串中是否存在非空值(空值:null, "")
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isNotEmpty(String... params) {
		
		if (null != params && params.length > 0) {
			
			for (String str : params) {
				
				if (isNotEmpty(str)) {
					
	        		return true;
	        	}
			}
		}
		return false;
	}
	
	/**
	 * 判断多个字符串是否都为空值(空值:null, "")
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isAllEmpty(String... params) {
		
		if (null != params && params.length > 0) {
			
			for (String str : params) {
				
				if (isNotEmpty(str)) {
					
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 判断多个字符串是否都不为空值(空值:null, "")
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isNotAllEmpty(String... params) {
		
		if (null != params && params.length > 0) {
			
			for (String str : params) {
				
				if (isEmpty(str)) {
					
	        		return false;
	        	}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否为空值(空值:null, "", "半角空白", "全角空白", "null")
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmptyIgnoreBlank(String str) {
		
		str = ConvertUtil.trim(str);
		if (isEmpty(str) || NULL.equalsIgnoreCase(str)) {
			
			return true;
		}
		char[] array = str.toCharArray();
		int len = array.length;
		int count = 0;
		for (int i=0; i<len; i++) {
			
			if (array[i] == ASCII_BLANK_DBC || array[i] == ASCII_BLANK_SBC) {
				
				count++;
			}
		}
		return count == len ? true : false;
	}
	
	/**
	 * 判断字符串是否为非空值(空值:null, "", "半角空白", "全角空白", "null")
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmptyIgnoreBlank(String str) {
		
		return !isEmptyIgnoreBlank(str);
	}
	
	/**
	 * 判断多个字符串中是否存在空值(空值:null, "", "半角空白", "全角空白", "null")
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isEmptyIgnoreBlank(String... params) {
		
		for (String tmp : params) {
			
			if (isEmptyIgnoreBlank(tmp)) {
				
        		return true;
        	}
		}
		return false;
	}
	
	/**
	 * 判断多个字符串中是否存在非空值(空值:null, "", "半角空白", "全角空白", "null")
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isNotEmptyIgnoreBlank(String... params) {
		
		for (String tmp : params) {
			
        	if (isNotEmptyIgnoreBlank(tmp)) {
        		
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断多个字符串是否都为空值(空值:null, "", "半角空白", "全角空白", "null")
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isAllEmptyIgnoreBlank(String... params) {
		
		for (String tmp : params) {
			
			if (isNotEmptyIgnoreBlank(tmp)) {
				
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断多个字符串是否都不为空值(空值:null, "", "半角空白", "全角空白", "null")
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isNotAllEmptyIgnoreBlank(String... params) {
		
		for (String tmp : params) {
			
			if (isEmptyIgnoreBlank(tmp)) {
				
        		return false;
        	}
		}
		return true;
	}
	
	/**
	 * 判断两个字符串是否相等(忽略大小写)
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isEqualsIgnoreCase(String str1, String str2) {
		
		return null == str1 ? null == str2 : str1.equalsIgnoreCase(str2);
	}
	
	/**
	 * 判断两个字符串是否不相等(忽略大小写)
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isNotEqualsIgnoreCase(String str1, String str2) {
		
		return !isEqualsIgnoreCase(str1, str2);
	}
	
	/**
	 * 判断字符串是否与多个字符串中的某一个相等
	 * 
	 * @param str
	 * @param params
	 * @return
	 */
	public static boolean isEquals(String str, String... params) {
		
		for (String tmp : params) {
			
			if (isEquals(str, tmp)) {
				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断字符串是否与多个字符串都不相等
	 * 
	 * @param str
	 * @param params
	 * @return
	 */
	public static boolean isNotAllEquals(String str, String... params) {
		
		for (String tmp : params) {
			
			if (isEquals(str, tmp)) {
				
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断字符串是否与多个字符串都相等
	 * 
	 * @param str
	 * @param params
	 * @return
	 */
	public static boolean isAllEquals(String str, String... params) {
		
		for (String tmp : params) {
			
			if (!isEquals(str, tmp)) {
				
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断字符串是否与多个字符串中的某一个相等(忽略大小写)
	 * 
	 * @param str
	 * @param params
	 * @return
	 */
	public static boolean isEqualsIgnoreCase(String str, String... params) {
		
		for (String tmp : params) {
			
			if (isEqualsIgnoreCase(str, tmp)) {
				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断字符串是否与多个字符串都不相等(忽略大小写)
	 * 
	 * @param str
	 * @param params
	 * @return
	 */
	public static boolean isNotEqualsIgnoreCase(String str, String... params) {
		
		for (String tmp : params) {
			
			if (isEqualsIgnoreCase(str, tmp)) {
				
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断字符串数组是否为空
	 * 
	 * @param array
	 * @return
	 */
	public static boolean isEmptyArray(String... array) {
		
		return null == array || array.length < 1 || (array.length == 1 && isEmpty(array[0]));
	}
	
	/**
	 * 判断字符串数组是否不为空
	 * 
	 * @param array
	 * @return
	 */
	public static boolean isNotEmptyArray(String... array) {
		
		return !isEmptyArray(array);
	}
	
	/**
	 * 判断对象是否为空
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isEmpty(T t) {
		
		return null == t;
	}
	
	/**
	 * 判断对象是否不为空
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isNotEmpty(T t) {
		
		return null != t;
	}
	
	/**
	 * 判断数组是否为空
	 * 
	 * @param <T>
	 * @param objs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> boolean isEmpty(T... objs) {
		
		return null == objs || objs.length < 1 || (objs.length == 1 && null == objs[0]);
	}
	
	/**
	 * 判断数组是否不为空
	 * 
	 * @param <T>
	 * @param objs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> boolean isNotEmpty(T... objs) {
		
		return !isEmpty(objs);
	}
	
	/**
	 * 判断多个对象是否都为空
	 * 
	 * @param <T>
	 * @param objs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> boolean isAllEmpty(T... objs) {
		
		for (T obj : objs) {
			
			if (null != obj) {
				
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断多个对象是否都不为空
	 * 
	 * @param <T>
	 * @param objs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> boolean isNotAllEmpty(T... objs) {
		
		for (T obj : objs) {
			
			if (null == obj) {
				
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断Map是否为空
	 * 
	 * @param <K>
	 * @param <V>
	 * @param map
	 * @return
	 */
	public static <K, V> boolean isEmpty(Map<K, V> map) {
		
		return null == map || map.isEmpty();
	}
	
	/**
	 * 判断Map是否不为空
	 * 
	 * @param <K>
	 * @param <V>
	 * @param map
	 * @return
	 */
	public static <K, V> boolean isNotEmpty(Map<K, V> map) {
		
		return !isEmpty(map);
	}
	
	/**
	 * 判断多个Map是否都为空
	 * 
	 * @param <K>
	 * @param <V>
	 * @param maps
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> boolean isAllEmpty(Map<K, V>... maps) {
		
		for (Map<K, V> map : maps) {
			
			if (isNotEmpty(map)) {
				
        		return false;
        	}
		}
		return true;
	}
	
	/**
	 * 判断多个Map是否都不为空
	 * 
	 * @param <K>
	 * @param <V>
	 * @param maps
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> boolean isNotAllEmpty(Map<K, V>... maps) {
		
		for (Map<K, V> map : maps) {
			
			if (isEmpty(map)) {
				
        		return false;
        	}
		}
		return true;
	}
	
	/**
	 * 判断Collection是否为空
	 * 
	 * @param <T>
	 * @param collection
	 * @return
	 */
	public static <T> boolean isEmpty(Collection<T> collection) {
		
		return null == collection || collection.isEmpty();
	}
	
	/**
	 * 判断Collection是否不为空
	 * 
	 * @param <T>
	 * @param collection
	 * @return
	 */
	public static <T> boolean isNotEmpty(Collection<T> collection) {
		
		return !isEmpty(collection);
	}
	
	/**
	 * 判断多个Collection是否都为空
	 * 
	 * @param <T>
	 * @param collections
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> boolean isAllEmpty(Collection<T>... collections) {
		
		for (Collection<T> collection : collections) {
			
			if (isNotEmpty(collection)) {
				
        		return false;
        	}
		}
		return true;
	}
	
	/**
	 * 判断多个Collection是否都不为空
	 * 
	 * @param <T>
	 * @param collections
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> boolean isNotAllEmpty(Collection<T>... collections) {
		
		for (Collection<T> collection : collections) {
			
			if (isEmpty(collection)) {
				
        		return false;
        	}
		}
		return true;
	}
	
	/**
	 * 判断字符串是否以指定前缀开头
	 * 
	 * @param str
	 * @param prefix
	 * @return
	 */
	public static boolean isStartsWith(String str, String prefix) {
		
		return (null == str || null == prefix) ? false : str.startsWith(prefix);
	}
	
	/**
	 * 判断字符串是否不以指定前缀开头
	 * 
	 * @param str
	 * @param prefix
	 * @return
	 */
	public static boolean isNotStartsWith(String str, String prefix) {
		
		return !isStartsWith(str, prefix);
	}
	
	/**
	 * 判断字符串是否以多个指定前缀中的任何一个开头
	 * 
	 * @param str
	 * @param prefixs
	 * @return
	 */
	public static boolean isStartsWith(String str, String... prefixs) {

		if (null != str && isNotEmptyArray(prefixs)) {
			
			for (String prefix : prefixs) {
				
				if (isStartsWith(str, prefix)) {
					
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不以多个指定前缀中的任何一个开头
	 * 
	 * @param str
	 * @param prefixs
	 * @return
	 */
	public static boolean isNotStartsWith(String str, String... prefixs) {
		
		return !isStartsWith(str, prefixs);
	}
	
	/**
	 * 判断字符串是否以多个指定后缀中的任何一个结尾
	 * 
	 * @param str
	 * @param suffixs
	 * @return
	 */
	public static boolean isEndsWith(String str, String... suffixs) {

		if (null != str && isNotEmptyArray(suffixs)) {
			
			for (String suffix : suffixs) {
				
				if (isEndsWith(str, suffix)) {
					
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不以多个指定后缀中的任何一个结尾
	 * 
	 * @param str
	 * @param suffixs
	 * @return
	 */
	public static boolean isNotEndsWith(String str, String... suffixs) {
		
		return !isEndsWith(str, suffixs);
	}
	
	/**
	 * 判断字符串是否以指定后缀结尾
	 * 
	 * @param str
	 * @param suffix
	 * @return
	 */
	public static boolean isEndsWith(String str, String suffix) {
		
		return (null == str || null == suffix) ? false : str.endsWith(suffix);
	}
	
	/**
	 * 判断字符串是否不以指定后缀结尾
	 * 
	 * @param str
	 * @param suffix
	 * @return
	 */
	public static boolean isNotEndsWith(String str, String suffix) {
		
		return !isEndsWith(str, suffix);
	}
	
	/**
	 * 判断字符串是否包含指定关键字
	 * 
	 * @param str
	 * @param keyword
	 * @return
	 */
	public static boolean isContains(String str, String keyword) {
		
		return isEmpty(str, keyword) ? false : str.indexOf(keyword) > -1;
	}
	
	/**
	 * 判断字符串是否不包含指定关键字
	 * 
	 * @param str
	 * @param keyword
	 * @return
	 */
	public static boolean isNotContains(String str, String keyword) {
		
		return !isContains(str, keyword);
	}
	
	/**
	 * 判断字符串是否至少包含多个指定关键字中的一个
	 * 
	 * @param str
	 * @param keywords
	 * @return
	 */
	public static boolean isContains(String str, String... keywords) {
		
		if (null != str && isNotEmptyArray(keywords)) {
			
			for (String keyword : keywords) {
				
				if (isNotEmpty(keyword) && str.indexOf(keyword) > -1) {
					
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不包含任何指定关键字
	 * 
	 * @param str
	 * @param keywords
	 * @return
	 */
	public static boolean isNotContains(String str, String... keywords) {
		
		return !isContains(str, keywords);
	}
	
	/**
	 * 判断字符串是否至少包含多个指定关键字中的一个
	 * 
	 * @param str
	 * @param collection
	 * @return
	 */
	public static boolean isContains(String str, Collection<String> collection) {
		
		if (null != str && isNotEmpty(collection)) {
			
			for (String item : collection) {
				
				if (isNotEmpty(item) && str.indexOf(item) > -1) {
					
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不包含任何指定关键字
	 * 
	 * @param str
	 * @param collection
	 * @return
	 */
	public static boolean isNotContains(String str, Collection<String> collection) {
		
		return !isContains(str, collection);
	}
	
	/**
	 * 判断字符串是否包含指定关键字(忽略大小写)
	 * 
	 * @param str
	 * @param keyword
	 * @return
	 */
	public static boolean isContainsIgnoreCase(String str, String keyword) {
		
		if (isEmpty(str, keyword)) {
			
			return false;
		}
		int len = keyword.length();
		int max = str.length() - len;
		for (int i=0; i<=max; i++) {
			
			if (str.regionMatches(true, i, keyword, 0, len)) {
				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不包含指定关键字(忽略大小写)
	 * 
	 * @param str
	 * @param keyword
	 * @return
	 */
	public static boolean isNotContainsIgnoreCase(String str, String keyword) {
		
		return !isContainsIgnoreCase(str, keyword);
	}
	
	/**
	 * 判断字符串是否包含半角空白或全角空白
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isContainsBlank(String str) {
		
		if (isNotEmpty(str)) {
			
			char[] array = str.toCharArray();
			for (char c : array) {
				
				if (c == ASCII_BLANK_DBC || c == ASCII_BLANK_SBC) {
					
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不包含半角空白或全角空白
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotContainsBlank(String str) {
		
		return !isContainsBlank(str);
	}
	
	/**
	 * 判断字符串是否包含半角空白
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isContainsBlankDBC(String str) {
		
		if (isNotEmpty(str)) {
			
			char[] array = str.toCharArray();
			for (char c : array) {
				
				if (c == ASCII_BLANK_DBC) {
					
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不包含半角空白
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotContainsBlankDBC(String str) {
		
		return !isContainsBlankDBC(str);
	}
	
	/**
	 * 判断字符串是否包含全角空白
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isContainsBlankSBC(String str) {
		
		if (isNotEmpty(str)) {
			
			char[] array = str.toCharArray();
			for (char c : array) {
				
				if (c == ASCII_BLANK_DBC) {
					
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不包含全角空白
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotContainsBlankSBC(String str) {
		
		return !isContainsBlankSBC(str);
	}
	
	/**
	 * 判断字符串是否为中文
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isChinese(String str) {
		
		return null == str ? false : str.matches("^[\\u4e00-\\u9fa5]+$");
	}
	
	/**
	 * 判断字符串是否不为中文
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotChinese(String str) {
		
		return !isChinese(str);
	}
	
	/**
	 * 判断字符串是否为中文，并且中文个数不能小于指定个数
	 * 
	 * @param str
	 * @param start
	 * @return
	 */
	public static boolean isChinese(String str, int start) {
		
		return null == str || start < 1 ? false : str.matches(String.format("^[\u4e00-\u9fa5]{%s,}$", start));
	}
	
	/**
	 * 判断字符串是否不为中文，或者中文个数小于指定个数
	 * 
	 * @param str
	 * @param start
	 * @return
	 */
	public static boolean isNotChinese(String str, int start) {
		
		return !isChinese(str, start);
	}
	
	/**
	 * 判断字符串是否为中文，并且中文个数不能超过指定范围
	 * 
	 * @param str
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean isChinese(String str, int start, int end) {
		
		return null == str || start < 1 || end <= start ? false : str.matches(String.format("^[\u4e00-\u9fa5]{%s,%s}$", start, end));
	}
	
	/**
	 * 判断字符串是否不为中文，或者中文个数超过指定范围
	 * 
	 * @param str
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean isNotChinese(String str, int start, int end) {
		
		return !isChinese(str, start, end);
	}
	
	/**
	 * 判断字符串是否为中文姓名(2至15个汉字)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isChineseName(String str) {
		
		return isChinese(str, 2, 15);
	}
	
	/**
	 * 判断字符串是否不为中文姓名(2至15个汉字)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotChineseName(String str) {
		
		return !isChineseName(str);
	}
	
	/**
	 * 判断字符串是否为双字节字符
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDBCS(String str) {
		
		return null == str ? false : str.matches("^[^\\x00-\\xff]+$");
	}
	
	/**
	 * 判断字符串是否不为双字节字符
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotDBCS(String str) {
		
		return !isDBCS(str);
	}
	
	/**
	 * 判断对象是否为枚举
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isEnum(T t) {
		
		return null == t ? false : t.getClass().isEnum();
	}
	
	/**
	 * 判断对象是否不为枚举
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isNotEnum(T t) {
		
		return !isEnum(t);
	}
	
	/**
	 * 判断对象是否为java.lang.String
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isString(T t) {
		
		return null == t ? false : String.class.isAssignableFrom(t.getClass());
	}
	
	/**
	 * 判断对象是否不为java.lang.String
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isNotString(T t) {
		
		return !isString(t);
	}
	
	/**
	 * 判断对象是否为org.w3c.dom.Document
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isDocument(T t) {
		
		return null == t ? false : org.w3c.dom.Document.class.isAssignableFrom(t.getClass());
	}
	
	/**
	 * 判断对象是否不为org.w3c.dom.Document
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isNotDocument(T t) {
		
		return !isDocument(t);
	}
	
	/**
	 * 判断对象是否为数组
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isArray(T t) {
		
		return null == t ? false : t.getClass().isArray();
	}
	
	/**
	 * 判断对象是否不为数组
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isNotArray(T t) {
		
		return !isArray(t);
	}
	
	/**
	 * 判断对象是否为字节数组
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isByteArray(T t) {
		
		return null == t ? false : byte[].class.isAssignableFrom(t.getClass());
	}
	
	/**
	 * 判断对象是否不为字节数组
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isNotByteArray(T t) {
		
		return !isByteArray(t);
	}
	
	/**
	 * 判断对象是否为字符串数组
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isStringArray(T t) {
		
		return null == t ? false : String[].class.isAssignableFrom(t.getClass());
	}
	
	/**
	 * 判断对象是否不为字符串数组
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isNotStringArray(T t) {
		
		return !isStringArray(t);
	}
	
	/**
	 * 判断对象是否为java.util.Map
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isMap(T t) {
		
		return null == t ? false : Map.class.isAssignableFrom(t.getClass());
	}
	
	/**
	 * 判断对象是否不为java.util.Map
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isNotMap(T t) {
		
		return !isMap(t);
	}
	
	/**
	 * 判断对象是否为java.util.Collection
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isCollection(T t) {
		
		return null == t ? false : Collection.class.isAssignableFrom(t.getClass());
	}
	
	/**
	 * 判断对象是否不为java.util.Collection
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isNotCollection(T t) {
		
		return !isCollection(t);
	}
	
	/**
	 * 判断对象是否为java.util.List
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isList(T t) {
		
		return null == t ? false : List.class.isAssignableFrom(t.getClass());
	}
	
	/**
	 * 判断对象是否不为java.util.List
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isNotList(T t) {
		
		return !isList(t);
	}
	
	/**
	 * 判断对象是否为java.util.Set
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isSet(T t) {
		
		return null == t ? false : Set.class.isAssignableFrom(t.getClass());
	}
	
	/**
	 * 判断对象是否不为java.util.Set
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isNotSet(T t) {
		
		return !isSet(t);
	}
	
	/**
	 * 判断对象是否为InputStream
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isInputStream(T t) {
		
		return null == t ? false : InputStream.class.isAssignableFrom(t.getClass());
	}
	
	/**
	 * 判断对象是否不为InputStream
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isNotInputStream(T t) {
		
		return !isInputStream(t);
	}
	
	/**
	 * 判断对象是否为File
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isFile(T t) {
		
		return null == t ? false : File.class.isAssignableFrom(t.getClass());
	}
	
	/**
	 * 判断对象是否不为File
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> boolean isNotFile(T t) {
		
		return !isFile(t);
	}
	
	/**
	 * 判断字符串是否为小写字母
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isLowerCase(String str) {
		
		if (isEmptyIgnoreBlank(str)) {
			
			return false;
		}
		for (int i=0; i<str.length(); i++) {
			
			if (!Character.isLowerCase(str.charAt(i))) {
				
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断字符串是否不为小写字母
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotLowerCase(String str) {
		
		return !isLowerCase(str);
	}
	
	/**
	 * 判断字符串是否为大写字母
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isUpperCase(String str) {
		
		if (isEmptyIgnoreBlank(str)) {
			
			return false;
		}
		for (int i=0; i<str.length(); i++) {
			
			if (!Character.isUpperCase(str.charAt(i))) {
				
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断字符串是否不为大写字母
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotUpperCase(String str) {
		
		return !isUpperCase(str);
	}
	
	/**
	 * 判断两个对象是否相等
	 * 
	 * @param <T>
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static <T> boolean isEquals(T t1, T t2) {
		
		return null == t1 ? null == t2 : t1.equals(t2);
	}
	
	/**
	 * 判断两个对象是否不相等
	 * 
	 * @param <T>
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static <T> boolean isNotEquals(T t1, T t2) {
		
		return !isEquals(t1, t2);
	}
	
	/**
	 * 判断对象是否与多个对象中的某一个相等
	 * 
	 * @param <T>
	 * @param t
	 * @param objs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> boolean isEquals(T t, T... objs) {
		
		for (T obj : objs) {
			
			if (isEquals(t, obj)) {
				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断对象是否与多个对象都不相等
	 * 
	 * @param <T>
	 * @param t
	 * @param objs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> boolean isNotAllEquals(T t, T... objs) {
		
		for (T obj : objs) {
			
			if (isEquals(t, obj)) {
				
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断字符串是否为有效的组织机构代码(全国组织机构代码中心提供校验规则)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isOrgCode(String str) {
		
		if (null == str || str.length() != 9) {
			
			return false;
		}
		int[] codeArray = new int[8];
		int[] codeFactor = new int[8];
		String verifyChar;
		for (int i=0; i<8; i++) {
			
			String tmpChar = str.substring(i, i + 1);
			codeArray[i] = isInteger(tmpChar) ? Integer.parseInt(tmpChar) : (int)tmpChar.charAt(0) - 65 + 10;
		}
		String endChar = str.substring(8, 9);
		codeFactor[0] = 3;
		codeFactor[1] = 7;
		codeFactor[2] = 9;
		codeFactor[3] = 10;
		codeFactor[4] = 5;
		codeFactor[5] = 8;
		codeFactor[6] = 4;
		codeFactor[7] = 2;
		int j = 0;
		for (int i=0; i<8; i++) {
			
			j += codeArray[i] * codeFactor[i];
		}
		j = 11 - j % 11;
		switch (j) {
			
			case 11:
				
				verifyChar = "0";
				break;
			case 10:
				
				verifyChar = "X";
				break;
			default:
				
				verifyChar = String.valueOf(j);
		}
		return endChar.equals(verifyChar);
	}
	
	/**
	 * 判断字符串是否为无效的组织机构代码(全国组织机构代码中心提供校验规则)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotOrgCode(String str) {
		
		return !isOrgCode(str);
	}
	
	/**
	 * 判断字符串是否为升序的数字串(格式:0123456789)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumericAsc(String str) {
		
		return null == str ? false : str.matches("^(0(?=1|$)|1(?=2|$)|2(?=3|$)|3(?=4|$)|4(?=5|$)|5(?=6|$)|6(?=7|$)|7(?=8|$)|8(?=9|$)|9(?=$))*$");
	}
	
	/**
	 * 判断字符串是否不为升序的数字串(格式:0123456789)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNumericAsc(String str) {
		
		return !isNumericAsc(str);
	}
	
	/**
	 * 判断字符串是否为降序的数字串(格式:9876543210)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumericDesc(String str) {
		
		return null == str ? false : str.matches("^(9(?=8|$)|8(?=7|$)|7(?=6|$)|6(?=5|$)|5(?=4|$)|4(?=3|$)|3(?=2|$)|2(?=1|$)|1(?=0|$)|0(?=$))*$");
	}
	
	/**
	 * 判断字符串是否不为降序的数字串(格式:9876543210)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNumericDesc(String str) {
		
		return !isNumericDesc(str);
	}
	
	/**
	 * 判断字符串是否为重复的数字串(格式:6666)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumericRepeat(String str) {
		
		return null == str || str.length() < 2 ? false : str.matches("^(0(?=0|$)|1(?=1|$)|2(?=2|$)|3(?=3|$)|4(?=4|$)|5(?=5|$)|6(?=6|$)|7(?=7|$)|8(?=8|$)|9(?=9|$))*$");
	}
	
	/**
	 * 判断字符串是否不为重复的数字串(格式:6666)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNumericRepeat(String str) {
		
		return !isNumericRepeat(str);
	}
	
	/**
	 * 判断字符串是否为字符串"null"
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		
		return NULL.equals(str);
	}
	
	/**
	 * 判断字符串是否不为字符串"null"
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		
		return !isNull(str);
	}
	
	/**
	 * 判断字符串是否为字符串"null"(忽略大小写)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullIgnoreCase(String str) {
		
		return NULL.equalsIgnoreCase(str);
	}
	
	/**
	 * 判断字符串是否不为字符串"null"(忽略大小写)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNullIgnoreCase(String str) {
		
		return !isNullIgnoreCase(str);
	}
	
	/**
	 * 判断字符串是否为字符串"null"(忽略两端半角空白)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullIgnoreTrim(String str) {
		
		return null != str && NULL.equals(str.trim());
	}
	
	/**
	 * 判断字符串是否不为字符串"null"(忽略两端半角空白)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNullIgnoreTrim(String str) {
		
		return !isNullIgnoreTrim(str);
	}
	
	/**
	 * 判断字符串是否为字符串"null"(忽略大小写和两端半角空白)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullIgnoreAll(String str) {
		
		return null != str && NULL.equalsIgnoreCase(str.trim());
	}
	
	/**
	 * 判断字符串是否不为字符串"null"(忽略大小写和两端半角空白)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNullIgnoreAll(String str) {
		
		return !isNullIgnoreAll(str);
	}
	
	/**
	 * 判断数组中是否有重复的元素
	 * 
	 * @param array
	 * @return
	 */
	public static boolean isRepeat(String[] array) {
		
		if (null != array && array.length > 1) {
			
			int len = array.length;
			for (int i=0; i<len; i++) {
				
				for (int j=0; j<len; j++) {
					
					if (i == j) {
						
						continue;
					}
					if (isEquals(array[i], array[j])) {
						
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断数组中是否没有重复的元素
	 * 
	 * @param array
	 * @return
	 */
	public static boolean isNotRepeat(String[] array) {
		
		return !isRepeat(array);
	}
	
	/**
	 * 判断字符串是否符合指定的日期格式
	 * 
	 * @param str
	 * @param format
	 * @return
	 */
	public static boolean isDateFormat(String str, String format) {
		
		if (isEmptyIgnoreBlank(str, format) || str.length() != format.length()) {
			
			return false;
		}
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			sdf.setLenient(false);
			sdf.parse(str);
			return true;
		} catch (Exception e) {
			
			logger.warn(e);
			return false;
		}
	}
	
	/**
	 * 判断字符串是否不符合指定的日期格式
	 * 
	 * @param str
	 * @param format
	 * @return
	 */
	public static boolean isNotDateFormat(String str, String format) {
		
		return !isDateFormat(str, format);
	}
	
	/**
	 * 判断出生日期是否有效
	 * 
	 * @param birthdate
	 * @param format
	 * @return
	 */
	public static boolean isBirthdate(String birthdate, String format) {
		
		Date date = null;
		try {
			
			date = new SimpleDateFormat(format).parse(birthdate);
		} catch (Exception e) {
			
			logger.warn(e);
			return false;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		return isBirthdate(year, month, day);
	}
	
	/**
	 * 判断出生日期是否无效
	 * 
	 * @param birthdate
	 * @return
	 */
	public static boolean isNotBirthdate(String birthdate, String format) {
		
		return !isBirthdate(birthdate, format);
	}
	
	/**
	 * 判断出生日期是否有效
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static boolean isBirthdate(int year, int month, int day) {
		
		Calendar c = Calendar.getInstance();
		int currentYear = c.get(Calendar.YEAR);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		int currentDay = c.get(Calendar.DAY_OF_MONTH);
		if (year < 1900 || year > currentYear || month < 1 || month > 12 || day < 1) {
			
			return false;
		}
		if (year == currentYear && (month > currentMonth || day > currentDay)) {
			
			return false;
		}
		int lastDayOfMonth;
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			
			lastDayOfMonth = 30;
			break;
		case 2:
			
			lastDayOfMonth = isLeapYear(year) ? 29 : 28;
			break;
		default:
			
			lastDayOfMonth = 31;
		}
		return day <= lastDayOfMonth;
	}
	
	/**
	 * 判断出生日期是否无效
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static boolean isNotBirthdate(int year, int month, int day) {
		
		return !isBirthdate(year, month, day);
	}
	
	/**
	 * 判断第一个对象是否大于第二个对象
	 * 
	 * @param <T>
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static <T extends Comparable<T>> boolean isGreater(T t1, T t2) {
		
		return t1.compareTo(t2) > 0;
	}
	
	/**
	 * 判断第一个对象是否大于等于第二个对象
	 * 
	 * @param <T>
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static <T extends Comparable<T>> boolean isGreaterAndEqual(T t1, T t2) {
		
		return t1.compareTo(t2) >= 0;
	}
	
	
	/**
	 * 判断第一个对象是否不大于第二个对象
	 * 
	 * @param <T>
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static <T extends Comparable<T>> boolean isNotGreater(T t1, T t2) {
		
		return t1.compareTo(t2) <= 0;
	}
	
	/**
	 * 判断第一个对象是否小于第二个对象
	 * 
	 * @param <T>
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static <T extends Comparable<T>> boolean isLess(T t1, T t2) {
		
		return t1.compareTo(t2) < 0;
	}
	
	/**
	 * 判断第一个对象是否不小于第二个对象
	 * 
	 * @param <T>
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static <T extends Comparable<T>> boolean isNotLess(T t1, T t2) {
		
		return t1.compareTo(t2) >= 0;
	}
	
	/**
	 * 判断是否为闰年
	 * 
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(int year) {
		
		return year < 1 ? false : (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
	}
	
	/**
	 * 判断是否不为闰年
	 * 
	 * @param year
	 * @return
	 */
	public static boolean isNotLeapYear(int year) {
		
		return !isLeapYear(year);
	}
	
	/**
	 * 判断字符串是否为JSON格式
	 * 
	 * @param str
	 * @return
	 */
//	public static boolean isJSON(String str) {
//		
//		try {
//			
//			new JSONObject(str);
//			return true;
//		} catch (Exception e) {
//			
//			logger.warn(e);
//			return false;
//		}
//	}
	
	/**
	 * 判断字符串是否不为JSON格式
	 * 
	 * @param str
	 * @return
	 */
//	public static boolean isNotJSON(String str) {
//		
//		return !isJSON(str);
//	}
	
	/**
	 * 判断字符串是否包含表情符号
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isContainsEmoji(String str) {

		int len = str.length();
		for (int i = 0; i < len; i++) {
			
			char codePoint = str.charAt(i);
			if (isEmoji(codePoint)) {

				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不包含表情符号
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotContainsEmoji(String str) {
		
		return !isContainsEmoji(str);
	}
	
	/**
	 * 判断字符是否为表情符号
	 * 
	 * @param codePoint
	 * @return
	 */
	public static boolean isEmoji(char codePoint) {
		
		return !isNotEmoji(codePoint);
	}
	
	/**
	 * 判断字符是否不为表情符号
	 * 
	 * @param codePoint
	 * @return
	 */
	public static boolean isNotEmoji(char codePoint) {
		
		return (codePoint == 0x0)
				|| (codePoint == 0x9)
				|| (codePoint == 0xA)
				|| (codePoint == 0xD)
				|| ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
				|| ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
				|| ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
	}
	
	private ValidatorUtil() {}
	
}
