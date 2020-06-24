package com.bgi.ms.engine.base.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.BitSet;

public class EncodeUtils {
    private static final int BYTE_SIZE = 8;
    private static final String CODE_UTF8 = "UTF-8";
    private static final String CODE_UTF16 = "UTF-16";//Unicode
    private static final String CODE_UTF16LE = "UTF-16LE";//Unicode big endian
    private static final String CODE_GBK = "GBK"; //ABSU


    public static String getEncode(String fileUrl) {
        try {
			URLConnection uc=new URL(fileUrl).openConnection();
			 BufferedInputStream bis = new BufferedInputStream(uc.getInputStream());
			 return getEncode(bis, CODE_GBK);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
		return null;
    	
    }
    
    
    /**
     * 通过文件全名称获取编码集名称
     */
    public static String getEncode(String fullFileName, String defaultEncoding) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fullFileName));
        return getEncode(bis, defaultEncoding);
    }

    /**
     * 通过文件缓存流获取编码集名称，文件流必须为未曾
     *
     * @param bis 文件流
     */
    public static String getEncode(BufferedInputStream bis, String defaultEncoding) throws Exception {
        bis.mark(0);
        String encodeType;
        byte[] head = new byte[3];
        bis.read(head);
        if (head[0] == -1 && head[1] == -2 && head[2] == (byte) 0x41) {
            encodeType = CODE_UTF16;
        } else if (head[0] == -2 && head[1] == -1 && head[2] == 0) {
            //encodeType = "Unicode";
            encodeType = CODE_UTF16LE;
        } else if (head[0] == -17 && head[1] == -69 && head[2] == -65) {
            //带BOM的UTF8 (CODE_UTF8_BOM)
            encodeType = CODE_UTF8;
        } else {
            if (isUTF8(bis)) {
                encodeType = CODE_UTF8;
            } else {
                encodeType = defaultEncoding;
            }
        }

        return encodeType;
    }

    /**
     * 是否是无BOM的UTF8格式，不判断常规场景，只区分无BOM UTF8和GBK
     */
    private static boolean isUTF8(BufferedInputStream bis) throws Exception {
        bis.reset();

        //读取第一个字节
        int code = bis.read();
        do {
            BitSet bitSet = convert2BitSet(code);
            //判断是否为单字节
            if (bitSet.get(0)) {//多字节时，再读取N个字节
                if (!checkMultiByte(bis, bitSet)) {//未检测通过,直接返回
                    return false;
                }
            }
            code = bis.read();
        } while (code != -1);
        return true;
    }

    /**
     * 检测多字节，判断是否为utf8，已经读取了一个字节
     */
    private static boolean checkMultiByte(BufferedInputStream bis, BitSet bitSet) throws Exception {
        int count = getCountOfSequential(bitSet);
        byte[] bytes = new byte[count - 1];//已经读取了一个字节，不能再读取
        bis.read(bytes);
        for (byte b : bytes) {
            if (!checkUtf8Byte(b)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检测bitSet中从开始有多少个连续的1
     */
    private static int getCountOfSequential(BitSet bitSet) {
        int count = 0;
        for (int i = 0; i < BYTE_SIZE; i++) {
            if (bitSet.get(i)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * 检测单字节，判断是否为utf8
     */
    private static boolean checkUtf8Byte(byte b) throws Exception {
        BitSet bitSet = convert2BitSet(b);
        return bitSet.get(0) && !bitSet.get(1);
    }

    /**
     * 将整形转为BitSet
     */
    private static BitSet convert2BitSet(int code) {
        BitSet bitSet = new BitSet(BYTE_SIZE);

        for (int i = 0; i < BYTE_SIZE; i++) {
            int tmp3 = code >> (BYTE_SIZE - i - 1);
            int tmp2 = 0x1 & tmp3;
            if (tmp2 == 1) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    
    
    
    public static void main(String[] args) {

    }
}