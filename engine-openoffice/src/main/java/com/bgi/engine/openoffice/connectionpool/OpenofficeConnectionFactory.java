package com.bgi.engine.openoffice.connectionpool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;

public class OpenofficeConnectionFactory extends BasePooledObjectFactory<OpenOfficeConnection>{

	private String openofficeHost;
	public OpenofficeConnectionFactory(String host) {
		// TODO Auto-generated constructor stub
		this.openofficeHost=host;
	}

	@Override
	public OpenOfficeConnection create() throws Exception {
		// TODO Auto-generated method stub
        OpenOfficeConnection connection = new SocketOpenOfficeConnection(openofficeHost,8100);
        connection.connect();
        return connection;
	}

	@Override
	public PooledObject<OpenOfficeConnection> wrap(OpenOfficeConnection obj) {
		// TODO Auto-generated method stub
		return new DefaultPooledObject<>(obj);
	}

}
