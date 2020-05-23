package demo.exception;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import demo.result.CodeMsg;
import demo.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 异常处理器，处理所有的异常
 */
@ControllerAdvice     //使用 @ControllerAdvice 实现全局异常处理
@ResponseBody
public class GlobalExceptionHandler {

	/**
	 * 拦截所有的异常
	 * @param request
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value=Exception.class)
	public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
		e.printStackTrace();
		if(e instanceof GlobalException) {
			GlobalException ex = (GlobalException)e;
			return Result.error(ex.getCm());
		}else if(e instanceof BindException) {   // 绑定异常
			BindException ex = (BindException)e;
			List<ObjectError> errors = ex.getAllErrors();// 检验有很多错误
			ObjectError error = errors.get(0);         // 只需要看第一个错就错了
			String msg = error.getDefaultMessage();
			return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
		}else {
			return Result.error(CodeMsg.SERVER_ERROR);   // 服务端异常
		}
	}
}
