package com.evil.activemq.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author qinhulin
 * @date 2020-08-15
 */
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage)
        {
            TextMessage textMsg = (TextMessage) message;
            try {
                String msgBody = textMsg.getText();
                System.out.println(msgBody);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
