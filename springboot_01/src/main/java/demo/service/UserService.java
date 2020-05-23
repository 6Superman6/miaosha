package demo.service;

import demo.model.User;
import demo.service.base.BaseService;

public interface UserService extends BaseService<User> {

    public User getById(int id);




}
