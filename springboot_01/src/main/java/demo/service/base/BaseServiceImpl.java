package demo.service.base;

import demo.mapper.MiaoshaUserMapper;
import demo.mapper.UserMapper;
import demo.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl<T> implements BaseService<T> {


    @Autowired
    public UserMapper userMapper;

    @Autowired
    public MiaoshaUserMapper miaoshaUserMapper;

    @Autowired
    public RedisService redisService;


}
