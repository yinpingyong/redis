package cn.com.bestpay.redisdemo.controller;

import cn.com.bestpay.redisdemo.setters.kafka.KafkaProducerConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/3/9.
 */
@Slf4j
@Controller
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private PollableChannel pollableChannel;

    @RequestMapping(value = "/setMsg")
    public ModelAndView setMsg(String msg) {

        ModelAndView modelAndView = new ModelAndView();

        kafkaTemplate.send("test.topic1",msg);

        modelAndView.addObject("msg","新增成功");

        modelAndView.setViewName("kafka");

        return modelAndView;
    }

    @RequestMapping(value = "/getMsg")
    public ModelAndView getMsg(String msg) {

        ModelAndView modelAndView = new ModelAndView();

        Message<?> received = pollableChannel.receive(80000);

       StringBuffer stringBuffer = new StringBuffer();
        System.out.println(received.getPayload());
        while (received != null) {
            stringBuffer.append(received.getPayload());
            System.out.println(received.getPayload());
            received = pollableChannel.receive(80000);
        }

        modelAndView.addObject("msg",stringBuffer.toString());

        modelAndView.setViewName("kafka");

        return modelAndView;
    }
}
