package com.study.springboot;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

/**
 * 콘솔에서 생성주기 보기
 * Servlet Filter implementation class TestFilter
 */
@WebFilter(filterName="testFilter", urlPatterns = "/aaa/*")
public class TestFilter extends HttpFilter implements Filter {
    
    /**
     * @see HttpFilter#HttpFilter()
     */
    public TestFilter() {
        super();
        System.out.println("---TestFilter 필터 생성자---");
    }
 
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
        System.out.println("---TestFilter destroy---"); /*수정하고 저장하면 얘가 뜸.*/
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("---TestFilter doFilter---"); /*url에 요청명넣을때마다 얘가 뜸.*/

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("---TestFilter 초기화---");
	}

}
