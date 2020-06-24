package com.bgi.engine.openoffice.utils;

import java.net.ConnectException;

import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.bgi.ms.engine.base.exception.BaseException;

public class OpenofficeUtils {

	public static OpenOfficeConnection getOpenOfficeConnection(String ip,Integer port) throws BaseException {
        OpenOfficeConnection connection = new SocketOpenOfficeConnection(ip,port);
        try {
            connection.connect();
        } catch (ConnectException e) {
        	throw new BaseException(BaseException.ERROR_CODE.SERVICE_UNAVAILABLE, "连接Openoffice服务出现异常，请确认Openoffice服务是否已经开启");
        }
        return connection;
	}
}
