package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description TODO
 **/
@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    //形参位置的request表示当前请求
    public String testServletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username+", password: " + password);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(@RequestParam(value = "user_name",required = false,defaultValue = "hehhe") String username,
                            String password, String[] hobby
    , @RequestHeader(value = "hostdd",required = true,defaultValue = "haha") String host
    , @CookieValue("JSESSIONID") String JSESSIONID){
        //若请求参数中刚出现多个同名的请求参数，可以再控制器方法的形参位置设置字符串类型或字符串数组接收此请求参数
        //若使用字符串类型的形参，最终结为请求参数的每一个值之间使用逗号进行拼接
        System.out.println("username: " + username+", password: " + password+",hobby: " + Arrays.toString(hobby));
        System.out.println("host: " + host);
        System.out.println("JSESSIONID: " + JSESSIONID);
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        System.out.println("男性");
        return "success";
    }

}