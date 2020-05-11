package demo.mapper;

import demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper<T> {

    public void insert(T t);

    public void delete(int id);

    public void update(T t);

    public T get(int id);

    public List<T> findAll();

    public int getCountById(int id);

    public List<T> getyName(String name);

    public User getOne(@Param("name") String name, @Param("pw") String pw);

    public User getUserByNameAndPw(Map<String,String> param);

    public User getList(Collection list);

    public User getUserByid(int[] ids);

    public User getUserByid2(@Param("a") int[] ids);

}
