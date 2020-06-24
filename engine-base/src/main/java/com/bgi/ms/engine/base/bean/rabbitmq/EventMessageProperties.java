package com.bgi.ms.engine.base.bean.rabbitmq;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;

public class EventMessageProperties extends MessageProperties {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public EventMessageProperties() {
	setMessageId(UUID.randomUUID().toString());
	setTimestamp(new Date());
	setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
    }

    public EventMessageProperties(String messageId, Date timestamp) {
	setMessageId(messageId);
	setTimestamp(timestamp);
	setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
    }

    public String toString() {
	return "messageId=" + getMessageId() + "|userId=" + getUserId()
		+ "|appId=" + getAppId() + "|clusterId=" + getClusterId()
		+ "|type=" + getType() + "|replyTo=" + getReplyTo()
		+ "|priority=" + getPriority() + "|messageCount="
		+ getMessageCount();
    }
}