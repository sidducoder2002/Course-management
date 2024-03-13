package com.taashee.SpringWebApplicatoinAssignment.error;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController implements ErrorController {
	private final Logger logger=LoggerFactory.getLogger(getClass());
	
	@GetMapping("/error")
	public String handleError(HttpServletRequest request,ModelMap modelMap) {
		Object status=request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(Objects.nonNull(status)){
			Integer statusCode=Integer.valueOf(status.toString());
			if(statusCode.equals(HttpStatus.NOT_FOUND.value())) {
				logger.info("Page not found: {} ,Status code: {}" ,
						request.getServletPath(),statusCode);
				modelMap.put("timestamp",LocalDateTime.now());
				modelMap.put("status",statusCode);
				modelMap.put("error","Page not fond. Please check your url");
				return "error";
			}
			else if(statusCode.equals(HttpStatus.INTERNAL_SERVER_ERROR.value())) {
				logger.info("Server Error: {} ,Status code: {}" ,
						request.getServletPath(),statusCode);
				modelMap.put("timestamp",LocalDateTime.now());
				modelMap.put("status",statusCode);
				modelMap.put("error",modelMap.get("error"));
				return "error";
			}
			else if (statusCode.equals(HttpStatus.FORBIDDEN.value())) {
			    logger.info("Forbidden Error: {}, status_code: {}", request.getServletPath(), statusCode);
			    modelMap.put("timestamp", LocalDateTime.now());
			    modelMap.put("status", statusCode);
			    modelMap.put("error","Forbidden");
			    return "error";
			}
		}
		return "error";
		
	}
}
