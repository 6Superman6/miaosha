package demo.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import demo.validator.IsMobile;

public class LoginVo {
	
	@NotNull        // 不能为空
	@IsMobile		// 检查是否是手机号格式
	private String mobile;
	
	@NotNull        // 不能为空
	@Length(min=32)  // 限定密码长度
	private String password;
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginVo [mobile=" + mobile + ", password=" + password + "]";
	}
}
