package com.bgi.ms.engine.base.utils;
import com.alibaba.fastjson.JSONObject;
import com.bgi.ms.engine.base.bean.sample.CpiTables;
import org.apache.commons.lang.StringUtils;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author
 * @date 19-12-3 14:53
 * @Description
 */
public class CalculateFuncUtils {
    /**
     * 功能描述:
     *
     * @param   p1
     * @param   p2
     * @return  java.lang.String
     * @auther  mengyuan zhang
     * @date    19-10-23 上午10:32
     */
    public static String getProcessPiPairs(String p1, String p2, String p3){
        if((StringUtils.isNotEmpty(p1) && Objects.isNull(p2)) || ("".equals(p1) && "".equals(p2))){
            return ("-");
        } else if(StringUtils.isNotEmpty(p1) && StringUtils.isNotEmpty(p2) && p1.equals(p2)){
            return (p1);
        } else if(StringUtils.isNotEmpty(p3)){
            return (p1 + "," + p2 + "," + p3);
        } else {
            return (p1 + "," + p2);
        }
    }

    /**
     * 功能描述: 判断字符串是不是数字
     *
     * @param   str
     * @return  boolean
     * @auther  mengyuan zhang
     * @date    19-11-6 上午10:45
     */
    public static boolean isNumericzidai(String str) {

        String regPattern = "-?[0-9]+\\.?[0-9]*";
        Pattern pattern = Pattern.compile(regPattern);
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 功能描述: 把长小数指定保留位数:
     *    保留4位小数:
     *    里面有E或e的:    1.325426357568E12 ---> 1.3254E12
     *    纯数字没有E或e的: 123.12325436546   ---> 123.1232
     *
     * @param   numberStr
     * @param   floatLen
     * @return
     * @auther  mengyuan zhang
     * @date    19-10-18 下午4:59
     */
    public static String getFloatRemain(String numberStr, int floatLen){
        // 不能处理的条件
        if(ValidatorUtil.isEmpty(numberStr) || "".equals(numberStr) || ValidatorUtil.isEmpty(floatLen) || "".equals(floatLen) || floatLen <0){
            return "";
        }
        String returnNumStr = numberStr;
        // 有E | e的
        numberStr.toUpperCase();
        if(numberStr.contains("E")){
            String[] numberStrArray = numberStr.split("E");
            if(numberStrArray.length != 2){
                return returnNumStr;
            }
            // 取前面的小数
            String numberStrFront = numberStrArray[0];
            float ft = Float.valueOf(numberStrFront);
            BigDecimal bd  = new BigDecimal((double)ft);
            bd = bd.setScale(4,4);
            String numberStrRear = numberStrArray[1];
            // 前面的小数部分按没有E的递归处理
            String numberStrFrontFormat = getFloatRemain(String.valueOf(bd), floatLen);
            // 拼接完成
            returnNumStr = numberStrFrontFormat.concat("E".concat(numberStrRear));

        }
        // 没有E | e的
        else if(CalculateFuncUtils.isNumericzidai(numberStr)){
            if(numberStr.contains(".")){
                // 当前原始长度大于要保留位数后的长度才处理
                if(numberStr.indexOf(".")+floatLen < numberStr.length()){
                    if(floatLen != 0){
                        returnNumStr = numberStr.substring(0,numberStr.indexOf(".")+floatLen+1);
                    }
                    // float==0. 不保留小数的,也不能要"."
                    else {
                        returnNumStr = numberStr.substring(0,numberStr.indexOf("."));
                    }
                }else {
                    int zeroCount = numberStr.indexOf(".")+floatLen-numberStr.length()+1;
                    String zeroStr = new String(new char[zeroCount]).replace("\0", "0");
                    returnNumStr = numberStr+zeroStr;
                }
                float ft = Float.valueOf(numberStr);
                BigDecimal bd  = new BigDecimal((double)ft);
                bd = bd.setScale(4,4);
                returnNumStr = String.valueOf(bd);
                int zeroCount = returnNumStr.indexOf(".")+floatLen-returnNumStr.length()+1;
                String zeroStr = new String(new char[zeroCount]).replace("\0", "0");
                returnNumStr = returnNumStr+zeroStr;
            }
            // 整数
            else {
                String zeroStr = new String(new char[floatLen]).replace("\0", "0");
                returnNumStr = numberStr+"."+zeroStr;
            }
        }
        return returnNumStr;
    }

    /**
     * 功能描述:  numberStr: 传入的String类型的数字, max, min: 超过Max或小于Min 的转为科学计数法
     *          eg: max = 10000, min = 0.00001
     *          1. numberStr = 1.1234567 ==> 1.1234567   | 不处理
     *          2. numberStr = 1123456.7 ==> 1.1234567E6   | 处理, 大于max,且不含e,E
     *          3. numberStr = 1.123456E12 ==> 1.123456E12  | 不处理, 已经含 e,E
     *          4. numberStr = 0.000001123 ==> 1.123E-5   | 处理, 小于min,且不含e ,E
     * @param   numberStr, Max, Min
     * @return  java.lang.String
     * @auther  mengyuan zhang
     * @date    19-10-23 上午10:50
     */
    public static String getSciFormat(String numberStr, double max, double min){
        String returnStr;
        // 判空处理
        if(Objects.isNull(numberStr) || "".equals(numberStr)){
            return "";
        } else if((Objects.isNull(max) && Objects.isNull(min)) || max <1.0 || min>1.0){
            return numberStr;
        } else if (max < min){
            return numberStr;
        }
        // 开始处理
        // 字符串转double格式
        Double numberDouble;
        try{
            numberDouble = Double.valueOf(numberStr);
            if(numberDouble-0 == 0.0){
                return numberStr;
            }
        } catch (Exception e){
            return numberStr;
        }
        String posOrNeg = "";
        Double absNumberDouble = numberDouble;
        if(numberDouble.compareTo(0.0)<0){
            posOrNeg = "-";
            absNumberDouble = numberDouble * -1;
            numberStr = numberStr.substring(1);
        }
        // 带e的处理
        if(numberStr.contains("e") || numberStr.contains("E")){
            returnStr = numberStr;
            if((absNumberDouble.compareTo(max) < 0 && absNumberDouble.compareTo(1.0) > 0 ) || (absNumberDouble.compareTo(min) > 0 && absNumberDouble.compareTo(1.0) < 0)){
                returnStr = BigDecimal.valueOf(numberDouble).toString();
            }
            return returnStr.replaceAll("e","E");
        }
        String numberToString;
        // 指数
        int numberPower=0;
        // 大于max
        if(absNumberDouble.compareTo(max) > 0){
            if(numberStr.contains(".")){
                numberPower = numberStr.indexOf(".") -1;
                numberToString = numberStr.replace(".","");
            } else {
                numberPower = numberStr.length() -1;
                numberToString = numberStr;
            }
            // 加小数点
            StringBuilder numberBase = new StringBuilder(numberToString);
            numberBase.insert(1, ".");
            // 拼接
            returnStr = numberBase.toString()+"E"+numberPower;

        } else if(absNumberDouble.compareTo(min) < 0){
            int flag = 0;
            StringBuilder numberBase = new StringBuilder();
            for(int i =0;i< numberStr.length();i++){
                String numTemp = numberStr.substring(i,i+1);
                if("0".equals(numTemp) && flag==0){
                    numberPower++;
                }else if(".".equals(numTemp)){
                    continue;
                }
                else {
                    flag=1;
                    numberBase.append(numTemp);
                }
            }
            numberBase.insert(1, ".");
            // 拼接
            returnStr = numberBase.toString() + "E-" +numberPower;
        } else {
            returnStr = numberStr;
        }

        return posOrNeg+returnStr;
    }


    public  static CpiTables objectToCpitables(Object object){
        CpiTables cpiTableT = new CpiTables();
        CpiTables cpiTables = new CpiTables();
        if(ValidatorUtil.isEmpty(object)){
            return cpiTables;
        }
        Map<String ,Object> cT = (Map<String ,Object>)object;
        Field[] field = cpiTableT.getClass().getDeclaredFields();
        for(Field i : field){
            if(ValidatorUtil.isEmpty(cT.get(i.getName()))){
                cT.put(i.getName(),null);
            }
        }
        cpiTables = JSONObject.parseObject(JSONObject.toJSONString(cT), CpiTables.class);
        return cpiTables;
    }

}



