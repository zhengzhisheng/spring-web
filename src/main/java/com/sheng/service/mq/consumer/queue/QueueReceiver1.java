
package com.sheng.service.mq.consumer.queue;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author 郑志胜
 * @description 队列消息监听器
 */
@Component("queueReceiver1")
public class QueueReceiver1 implements MessageListener {

    public void onMessage(Message message) {
        try {
            System.out.println("QueueReceiver1接收到消息:" + ((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
