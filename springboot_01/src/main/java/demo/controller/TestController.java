package demo.controller;

import demo.model.User;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pa")
public class TestController {

    @Autowired
    private UserService userService;

    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping("/query/{id}")    //
    public String getById(@PathVariable("id") String id)
    {
        try {
            User user = userService.getById(Integer.parseInt(id));
            return user.toString();
        }catch (Exception e)
        {
            return "请输入正确的id";
        }
    }











}
