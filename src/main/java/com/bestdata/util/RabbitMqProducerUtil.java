package com.bestdata.util;

import com.bestdata.WrsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RabbitMq生产者工具类
 *
 * @author chenyuanheng
 */
@SpringBootTest(classes = WrsApplication.class)
@RunWith(SpringRunner.class)
public class RabbitMqProducerUtil {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        Dog dog = new Dog();
        dog.setName("大黄55");
        dog.setColor("yellow");
        dog.setAge(3);
        // 生产者（交换机名，队列名，消息实体）
        rabbitTemplate.convertAndSend("direct", "animal", dog);
    }


}
