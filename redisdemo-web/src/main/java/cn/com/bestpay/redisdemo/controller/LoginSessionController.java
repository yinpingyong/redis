package cn.com.bestpay.redisdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Key;

/**
 * Created by Administrator on 2017/3/3.
 */
@Slf4j
@Controller
public class LoginSessionController {

    public static  final String KEY = "Value";

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value =  "/addValue")
    public ModelAndView addValue(String value, HttpSession session){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");

        /**
         * 方式一：向Redis中直接存入数据
         */
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(KEY,value);
        ValueOperations<String,Object> valueOperations1 = redisTemplate.opsForValue();
        // 用于页面显示
        mav.addObject("v1",valueOperations1.get(KEY));
        log.info(valueOperations1.get(KEY).toString());

        session.setAttribute("v2",value);
        log.info(session.getAttribute("v2").toString());

        return mav;
    }

}
