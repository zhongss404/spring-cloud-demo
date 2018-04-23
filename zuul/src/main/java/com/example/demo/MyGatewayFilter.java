package com.example.demo;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by dashuai on 2018/4/23.
 */
@Component
public class MyGatewayFilter extends ZuulFilter {
    @Override
    public String filterType(){  //过滤器启动的时机
        return "pre";
    }

    @Override
    public int filterOrder(){   //过滤的顺序
        return 0;
    }

    @Override
    public boolean shouldFilter(){  //这里写逻辑判断，是否要过滤，本文为true,表示永远过滤
        return true;
    }

    @Override
    public Object run(){
        RequestContext rc = RequestContext.getCurrentContext();
        String token = rc.getRequest().getParameter("token");
        if(token == null || !"12345".equals(token)){
            rc.setSendZuulResponse(false);
            rc.setResponseStatusCode(401);
            try {
                rc.getResponse().getWriter().write("token is empty/error and access refused");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
