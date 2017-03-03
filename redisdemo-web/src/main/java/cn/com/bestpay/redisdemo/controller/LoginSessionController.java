package cn.com.bestpay.redisdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/3/3.
 */
@Slf4j
@Controller
public class LoginSessionController {

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

}
