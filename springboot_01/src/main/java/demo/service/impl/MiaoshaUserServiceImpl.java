package demo.service.impl;

import demo.exception.GlobalException;
import demo.model.MiaoshaUser;
import demo.redis.MiaoshaUserKey;
import demo.result.CodeMsg;
import demo.service.MiaoshaUserService;
import demo.service.base.BaseServiceImpl;
import demo.utils.MD5Util;
import demo.utils.ServerResponse;
import demo.utils.UUIDUtil;
import demo.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
@Transactional
public class MiaoshaUserServiceImpl extends BaseServiceImpl<MiaoshaUser> implements MiaoshaUserService {

    public static final String COOKI_NAME_TOKEN = "token";

    @Override
    public ServerResponse insert(MiaoshaUser miaoshaUser) {
        return null;
    }

    @Override
    public ServerResponse delete(int id) {
        return null;
    }

    @Override
    public ServerResponse update(MiaoshaUser miaoshaUser) {
        return null;
    }

    @Override
    public ServerResponse get(int id) {
        return null;
    }

    @Override
    public ServerResponse findAll() {
        return null;
    }

    @Override
    public int getCountById(int id) {
        return 0;
    }

    @Override
    public ServerResponse getyName(String name) {
        return null;
    }

    public MiaoshaUser getById(long id) {
        return miaoshaUserMapper.getById(id);
    }

    /**
     * 所有的异常都有GlobalException抛出,最终被异常处理器GlobalExceptionHandler处理
     * @param response
     * @param loginVo
     * @return
     */
    public boolean login(HttpServletResponse response, LoginVo loginVo) {
        if(loginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        //判断手机号是否存在
//        System.out.println("miaoshamapper: "+miaoshaUserMapper);
        MiaoshaUser user = getById(Long.parseLong(mobile));
//        System.out.println("user: "+user);
        if(user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(formPass, saltDB);
//        System.out.println("md5密码："+calcPass);
//        System.out.println("数据库密码："+dbPass);
        if(!calcPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //生成cookie,来标识用户 ,将用户写道cookie中，传递给客户端，客户端再给服务端
        String token	 = UUIDUtil.uuid();
        addCookie(response, token, user);   //把个人信息放到redis缓存上去
        return true;
    }

    private void addCookie(HttpServletResponse response, String token, MiaoshaUser user) {
        redisService.set(MiaoshaUserKey.token, token, user);   // tk
        Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
        cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());  // 和MiaoshaUserKey.token有效期一直
        cookie.setPath("/");
        response.addCookie(cookie);   // 写道response里返回到客户端
    }

    public MiaoshaUser getByToken(HttpServletResponse response, String token) {
        if(StringUtils.isEmpty(token)) {
            return null;
        }
        MiaoshaUser user = redisService.get(MiaoshaUserKey.token, token, MiaoshaUser.class);  // 获取该cookie所对应的user对象
        //延长有效期
        if(user != null) {
            addCookie(response, token, user);
        }
        return user;
    }
}
