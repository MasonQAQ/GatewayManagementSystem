package gateway.controller;

import com.alibaba.fastjson.JSONObject;
import gateway.model.User;
import gateway.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yangyue on 2016/9/10.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * login view
     * @return
     */
    @RequestMapping("")
    public String index(){
        return "login/login.html";
    }

    /**
     * check the username and password
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/check")
    public @ResponseBody
    JSONObject check(
            @RequestParam(value = "username",required = true)String username,
            @RequestParam(value = "password",required = true)String password,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        request.getSession().removeAttribute("username");
        System.out.println("11111-----"+request.getSession().getAttribute("username"));
        JSONObject result=new JSONObject();
        try {
            User user = userDao.getByUsername(username);
            //we should judge [user ?= null]
            //to avoid NullPointerException,write[null != user] instead of [user != null]
            //use [ && ] not [ & ]
            if (null!=user && password.equals(user.getPassword())){
                System.out.println("登陆成功");
                result.put("code","1");
                result.put("status","success");
                //set session hear
                request.getSession().setAttribute("username",username);
            }else{
                System.out.println("登陆失败");
                result.put("code","0");
                result.put("status","fail");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("登陆失败"+e);
            result.put("code","-1");
            result.put("status","fail");
        }
        return result;
    }

    @RequestMapping("/logout")
    public String  logout(
            HttpSession session, SessionStatus status
    ){
        status.setComplete();
        session.removeAttribute("username");
        return "redirect:/login";
    }

    @Autowired
    private UserDao userDao;
}
