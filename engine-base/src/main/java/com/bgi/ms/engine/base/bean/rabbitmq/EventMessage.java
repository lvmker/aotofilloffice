package com.bgi.ms.engine.base.bean.rabbitmq;
import java.io.IOException;

import org.springframework.amqp.core.Message;

import com.bgi.ms.engine.base.utils.ToolUtil;

/**
 * RMQ消息
 * @author yeyuanchun
 * @date 2018-5-31
 */
public class EventMessage extends Message{
  /**
   * 获取消息中的对象
   * @return
   * @throws IOException
   * @throws ClassNotFoundException
   */
  public Object getObject() throws IOException, ClassNotFoundException{
      byte[] inputBody=getBody();
      if(inputBody!=null){
	  Object object=ToolUtil.byteArrayToObject(inputBody);
	  return object;
      }
      return null;
  }  
  public EventMessage(byte[] body, EventMessageProperties messageProperties){
    super(body, messageProperties);
  }
  
  public EventMessage(Object object){
      super(ToolUtil.objectToByteArray(object), new EventMessageProperties());
  }
}