package com.bgi.ms.engine.base.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ToolUtil
{
  public static String[] generateServiceUrl(String hostList, String defaultPort)
  {
    String[] serviceAddressStr = null;
    String hostStr = "";
    String portStr = "";
    if ((hostList == null) || (hostList.length() == 0)) {
      return serviceAddressStr;
    }
    for (String hoststuff : hostList.split(" "))
    {
      int finalColon = hoststuff.lastIndexOf(':');
      if (finalColon < 1)
      {
        hostStr = hoststuff.substring(0, hoststuff.length()).trim();
        portStr = defaultPort;
      }
      else
      {
        hostStr = hoststuff.substring(0, finalColon).trim();
        portStr = hoststuff.substring(finalColon + 1).trim();
      }
      serviceAddressStr = new String[] { hostStr, portStr };
    }
    return serviceAddressStr;
  }
  /**
   * 对象转成byte数组
   * @param obj
   * @return
   * @throws IOException
   */
  public static byte[] object2byteArray(Object obj) throws IOException{
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(baos);
      oos.writeObject(obj);
      oos.close();
      baos.close();
      return baos.toByteArray();
  }
  
  public static byte[] objectToByteArray(Object obj) {
      byte[] bytes = null;
      ByteArrayOutputStream byteArrayOutputStream = null;
      ObjectOutputStream objectOutputStream = null;
      try {
          byteArrayOutputStream = new ByteArrayOutputStream();
          objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
          objectOutputStream.writeObject(obj);
          objectOutputStream.flush();
          bytes = byteArrayOutputStream.toByteArray();
      } catch (IOException e) {
	  e.printStackTrace();
      } finally {
          if (objectOutputStream != null) {
              try {
                  objectOutputStream.close();
              } catch (IOException e) {
        	  e.printStackTrace();
              }
          }
          if (byteArrayOutputStream != null) {
              try {
                  byteArrayOutputStream.close();
              } catch (IOException e) {
        	  e.printStackTrace();
              }
          }
      }
      return bytes;
  }
  
  
  public static Object byteArrayToObject(byte[] bytes) {
      Object obj = null;
      ByteArrayInputStream byteArrayInputStream = null;
      ObjectInputStream objectInputStream = null;
      try {
          byteArrayInputStream = new ByteArrayInputStream(bytes);
          objectInputStream = new ObjectInputStream(byteArrayInputStream);
          obj = objectInputStream.readObject();
      } catch (Exception e) {
	  e.printStackTrace();
      } finally {
          if (byteArrayInputStream != null) {
              try {
                  byteArrayInputStream.close();
              } catch (IOException e) {
        	  e.printStackTrace();
              }
          }
          if (objectInputStream != null) {
              try {
                  objectInputStream.close();
              } catch (IOException e) {
        	  e.printStackTrace();
              }
          }
      }
      return obj;
  }
}