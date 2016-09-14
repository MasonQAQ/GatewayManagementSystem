package gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yangyue on 2016/9/10.
 */
@Controller
public class HomeController {
    @RequestMapping("")
    public String index(){
        return "redirect:/login";
    }
}
