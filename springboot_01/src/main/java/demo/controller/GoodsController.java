package demo.controller;

import demo.model.MiaoshaUser;
import demo.model.User;
import demo.result.Result;
import demo.service.MiaoshaUserService;
import demo.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    MiaoshaUserService miaoshaUserService;

	private static Logger log = LoggerFactory.getLogger(GoodsController.class);
	
    @RequestMapping("/to_list")
    public String toLogin(Model model,MiaoshaUser user) {
        model.addAttribute("user",user);
        return "goods_list";
    }
    

}
