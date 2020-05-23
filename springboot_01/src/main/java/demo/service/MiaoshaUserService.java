package demo.service;

import demo.model.MiaoshaUser;
import demo.service.base.BaseService;
import demo.vo.LoginVo;

import javax.servlet.http.HttpServletResponse;

public interface MiaoshaUserService extends BaseService<MiaoshaUser> {

    public boolean login(HttpServletResponse response, LoginVo loginVo);

    public MiaoshaUser getByToken(HttpServletResponse response, String token);

}
