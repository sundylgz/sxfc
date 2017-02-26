package com.xkxx.aspect;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 *	��¼�쳣��־
 */
@Component
@Aspect
public class ExceptionLogger {
	
	@Resource
	private HttpServletRequest request;

	@Around("within(com.xkxx.controller..*)")
	public Object log(ProceedingJoinPoint point) throws Exception {
		Object obj = null;
		try {
			obj = point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			// ��¼������־
			Logger logger = Logger.getLogger(this.getClass());
			
//			Admin admin = (Admin) request.getSession().getAttribute("admin");
			/*if(admin != null) {
				String className = point.getTarget().getClass().getName();
				String method = point.getSignature().getName();
				String date = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss").format(new Date());
				
				StringBuffer sb = new StringBuffer();
				sb.append("�û�[").append(admin.getName()).append("], ");
				sb.append("IP[").append(request.getRemoteHost()).append("], ");
				sb.append("��[").append(date).append("], ִ��[");
				sb.append(className).append(".").append(method);
				sb.append("]ʱ�����������쳣��");
				logger.error(sb.toString());
			}*/
			
			StackTraceElement[] elems = e.getStackTrace();
			for(StackTraceElement elem : elems) {
				logger.error("\t" + elem.toString());
			}
			
			// �׳��쳣
			throw new Exception(e);
		}
		return obj;
	}

}