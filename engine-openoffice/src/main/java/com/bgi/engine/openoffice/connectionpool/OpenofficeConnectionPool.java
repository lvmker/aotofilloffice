package com.bgi.engine.openoffice.connectionpool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;


public class OpenofficeConnectionPool extends GenericObjectPool<OpenOfficeConnection>{

	public OpenofficeConnectionPool(PooledObjectFactory<OpenOfficeConnection> factory) {
		super(factory);
		// TODO Auto-generated constructor stub
	}
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public OpenofficeConnectionPool(PooledObjectFactory<OpenOfficeConnection> factory, GenericObjectPoolConfig config) {
        super(factory, config);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public OpenofficeConnectionPool(PooledObjectFactory<OpenOfficeConnection> factory, GenericObjectPoolConfig config, AbandonedConfig abandonedConfig) {
        super(factory, config, abandonedConfig);
    }
    
    @Override
    public OpenOfficeConnection borrowObject() throws Exception {
    	// TODO Auto-generated method stub
    	OpenOfficeConnection openOfficeConnection= super.borrowObject();
//    	openOfficeConnection.connect();
    	return openOfficeConnection;
    }
    
    @Override
    public void returnObject(OpenOfficeConnection obj) {
    	// TODO Auto-generated method stub
//    	obj.disconnect();
    	super.returnObject(obj);
    }
    
    public String getPoolStateInfo() {
//    	getBlockWhenExhausted();
//    	getBorrowedCount();
//    	getCreatedCount();
//    	getDestroyedByBorrowValidationCount();
//    	getDestroyedByEvictorCount();
//    	getDestroyedCount();
//    	getEvictionPolicyClassName();
//    	getEvictorShutdownTimeoutMillis();
//    	getFactoryType();
//    	getFairness();
//    	getLifo();
//    	getLogAbandoned();
//    	getMaxBorrowWaitTimeMillis();
//    	getMaxIdle();
//    	getMaxTotal();
//    	getMaxWaitMillis();
//    	getMeanActiveTimeMillis();
//    	getMinEvictableIdleTimeMillis();
//    	getMeanBorrowWaitTimeMillis();
//    	getMinIdle();
//    	getNumActive();
//    	getNumIdle();
//    	getNumTestsPerEvictionRun();
//    	getNumWaiters();
//    	getRemoveAbandonedOnBorrow();
//    	getRemoveAbandonedOnMaintenance();
//    	getRemoveAbandonedTimeout();
//    	getReturnedCount();
//    	getSoftMinEvictableIdleTimeMillis();
//    	getSwallowedExceptionListener();
//    	getTestOnBorrow();
    	return "BorrowedCount="+getBorrowedCount()+",CreatedCount="+getCreatedCount()+",DestroyedCount="+getDestroyedCount()+",MaxIdle="+getMaxIdle()+",MaxTotal="+getMaxTotal()+",NumActive="+getNumActive()+",NumIdle="+getNumIdle()+",ReturnedCount="+getReturnedCount();
    }
}
