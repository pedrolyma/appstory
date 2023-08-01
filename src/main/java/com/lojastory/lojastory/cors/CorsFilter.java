package com.lojastory.lojastory.cors;

import java.io.IOException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {
	
	private String originPermitida = "http://localhost:4200";

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        
    	response.setHeader("Access-Control-Allow-Origin", originPermitida);
    	response.setHeader("Access-Control-Allow-Credentials", "false"); // true com security
    	
        if ("OPTIONS".equals(request.getMethod()) && originPermitida.equals(request.getHeader("Origin"))) {
        	response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
        	response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
        	response.setHeader("Access-Control-Max-Age", "3600");
        	response.setStatus(HttpServletResponse.SC_OK);
        } else {
        	chain.doFilter(req, resp);
        }
	}

    public void destroy() {
    	
    }
    
    public void init(FilterConfig org0) throws ServletException {
    	
    }
}

