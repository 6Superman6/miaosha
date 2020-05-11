package demo.controller;

import demo.model.User;
import demo.redis.RedisService;
import demo.redis.UserKey;
import demo.result.Result;
import demo.service.UserService;
import demo.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    RedisService redisService;

    // 添加数据
    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public ServerResponse add(@Valid User user)
    {
        return userService.insert(user);
    }

    // 删除数据
    @RequestMapping(path = "/del/{id}",method = RequestMethod.DELETE)
    public ServerResponse del(@PathVariable("id") int id)
    {
        return userService.delete(id);
    }

    // 修改数据
    @RequestMapping(path = "/do",method = RequestMethod.POST)
    public ServerResponse update(@Valid User user)
    {
        return userService.update(user);
    }

    // 获取数据--通过编号
    @RequestMapping(path = "/do/{id}",method = RequestMethod.GET)
    public ServerResponse get(@PathVariable("id") int id)
    {
        return userService.get(id);
    }

    // 获取全部数据
    @RequestMapping(path = "/do",method = RequestMethod.GET)
    public ServerResponse findAll()
    {
        return userService.findAll();
    }

    // 获取数据--通过用户名
    @RequestMapping(path = "/name",method = RequestMethod.GET)
    public ServerResponse getByName(@RequestParam("name") String name)
    {
        return userService.getyName(name);
    }


    @RequestMapping("/redis/get")
    public Result<User> redisGet()
    {
        User user = redisService.get(UserKey.getById,""+1,User.class);// UserKey: id1(1前面加了个id前缀)
        return Result.success(user);
    }

    @RequestMapping("/redis/set")
    public Result<Boolean> redisSet()
    {
//        boolean b = redisService.set("key2", "hello");         // 这样写容易被覆盖掉
//        String str = redisService.get("key2",String.class);  // 所以需要解决这个容易被覆盖的问题
//        return Result.success(str);                                  // 解决方案 加一个前缀 Prefix,比如：公司、部门
        User user = new User();
        user.setId(1);
        user.setName("Super");
        redisService.set(UserKey.getById,""+1,user); // UserKey: id1(1前面加了个id前缀)
        return Result.success(true);
    }

//    public static void main(String[] args)
//    {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        for(Integer o : list)
//        {
//            if (o==1)
//            {
//                list.remove(o);
//            }
//        }
//        System.out.println(list);
//    }



}
