package com.bgi.ms.engine.base.bean.log;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

@Scope(value =ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LoggerObserver implements Observer {
	public LoggerObserver(IEngineLogger engineLogger) {
		 this.engineLogger=engineLogger;
	}
	private IEngineLogger engineLogger;
    private ExecutorService executorService = Executors.newFixedThreadPool(5);
    @Override
    public void update(final Observable o, final Object engineLog) {
        //用多线程去发消息
        executorService.execute(
        		new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
			            if (o instanceof LoggerObservable) {
//			            	LoggerObservable loggerObservable = (LoggerObservable) o;
			            	engineLogger.logger((EngineLog) engineLog);
			            }
					}
				});
    }
}