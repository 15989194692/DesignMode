package com.lsz.chain.servlet;

public interface Filter {

    void init(ServletConfig servletConfig);

    void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain);

    void destroy();
}
