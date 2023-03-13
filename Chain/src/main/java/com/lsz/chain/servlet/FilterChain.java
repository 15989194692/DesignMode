package com.lsz.chain.servlet;

public interface FilterChain {

    void doFilter(ServletRequest servletRequest, ServletResponse servletResponse);
}
