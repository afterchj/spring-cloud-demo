package com.example.demo;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * Created by hongjian.chen on 2018/12/5.
 */

@Component
@Slf4j
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        OutputStream out;
        try {
            out = ctx.getResponse().getOutputStream();
            HttpServletRequest request = ctx.getRequest();
            Object token = request.getParameter("token");
            if (null == token) {
                log.warn(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()) + " token is empty.");
                out.write("Token is empty! ".getBytes());
            } else {
                out.write(("Token is " + token + ". ").getBytes());
            }
        } catch (IOException e) {
            return null;
        }
        return null;
    }
}
