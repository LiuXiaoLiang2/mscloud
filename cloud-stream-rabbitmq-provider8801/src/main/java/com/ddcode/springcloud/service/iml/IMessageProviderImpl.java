package com.ddcode.springcloud.service.iml;

import com.ddcode.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 创建发送消息的实现类
 * 1、@EnableBinding：可以理解为是一个消息的发送管道的定义, 指定使用的是 Source, 说明是消息生产者
 * 2、@EnableBinding：注解内部已经有 @Component, 所以已经在spring容器中了
 */
@EnableBinding(Source.class)
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    @Output(Source.OUTPUT)//指定使用哪个消息通道
    private MessageChannel outMessageChannel;

    @Override
    public String sendMessage() {
        String msg = UUID.randomUUID().toString();
        //需要将消息包装成stream认识的对象
        Message<String> channelMessage = MessageBuilder.withPayload(msg).build();
        boolean send = outMessageChannel.send(channelMessage);
        log.info("消息 {}, 发送结果 {}", msg, send);
        return msg;
    }
}
