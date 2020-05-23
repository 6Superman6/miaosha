package demo.validator;
import  javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import demo.utils.ValidatorUtil;

public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

	private boolean required = false;
	
	public void initialize(IsMobile constraintAnnotation) {
		required = constraintAnnotation.required();
	}

	/**
	 * 判断合法不合法
	 * @param value
	 * @param context
	 * @return
	 */
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(required) {   // 如果是必须的
			return ValidatorUtil.isMobile(value);
		}else {          // 不是必须的要判断是不是为空
			if(StringUtils.isEmpty(value)) {
				return true;  // 允许
			}else {
				return ValidatorUtil.isMobile(value);  // 检查的格式
			}
		}
	}

}
