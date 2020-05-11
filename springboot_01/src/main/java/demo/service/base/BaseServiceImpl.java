package demo.service.base;

import demo.mapper.DxyareaMapper;
import demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public DxyareaMapper dxyareaMapper;

}
