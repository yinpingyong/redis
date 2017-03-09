package cn.com.bestpay.redisdemo.controller;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 *
 * 提供NG调用
 *
 * Created by Administrator on 2017/3/9.
 */
@Slf4j
@Controller
public class NgController {

    @RequestMapping(value = "/")
    public void login(PrintWriter printWriter, String sum) {
        log.info("sum : "+ sum);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code","000000");
        printWriter.print(jsonObject.toString());
    }

}
