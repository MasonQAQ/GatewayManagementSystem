package gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yangyue on 2016/9/10.
 */
@Controller
public class MainController {

    /**
     * this is your website content
     * ！！！ NEED login
     * @return
     */
    @RequestMapping("main")
    public String index(){
        return "main/index.html";
    }

}
