package com.bgi.ms.engine.base.bean.log;

import java.util.Observable;

/**
 * 日志被观察者
 * @author yeyuanchun
 *
 */
public class LoggerObservable extends Observable {
	public void send(EngineLog engineLog) {
		this.setChanged();
		this.notifyObservers(engineLog);
	}

	
}
