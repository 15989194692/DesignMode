package com.lsz.chain.servlet;

import java.util.Arrays;
import java.util.HashMap;

public class ServletFilterChain implements FilterChain {
    private Filter[] filters;

    private static final int INIT_CAPACITY = 10;

    private static final int DEFAULT_INCREMENT = 5;

    private int pos = 0;

    private int n = 0;

    private Servlet servlet;

    public ServletFilterChain() {
        filters = new Filter[INIT_CAPACITY];
    }

    public void addFilter(Filter filter) {
        for (Filter f : filters) {
            if (f == filter) {
                return;
            }
        }

        if (n == filters.length) {
            Filter[] newFilters = new Filter[n + DEFAULT_INCREMENT];
            System.arraycopy(filters, 0, newFilters, 0, n);
            filters = newFilters;
        }

        filters[n++] = filter;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) {
        if (pos < n) {
            Filter filter = filters[pos++];
            filter.doFilter(servletRequest, servletResponse, this);
        } else {
            servlet.service(servletRequest, servletResponse);
            // 复位 pos 游标，否则该拦截器链只能使用一次
            pos = 0;
        }
    }

}
