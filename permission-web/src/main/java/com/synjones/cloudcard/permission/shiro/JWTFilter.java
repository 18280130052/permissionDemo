package com.synjones.cloudcard.permission.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description preHandle->isAccessAllowed->isLoginAttempt->executeLogin
 * @Date 2018-04-08
 * @Time 12:36
 */
public class JWTFilter extends BasicHttpAuthenticationFilter {

    /**
     * 如果带有 token，则对 token 进行检查，否则直接通过
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws UnauthorizedException {
        boolean allowed = false;
        try {
            //带有token就执行登录，没有就返回false调用onAccessDenied跳转到登录页面
            if (isLoginAttempt(request, response)){
                allowed =  executeLogin(request, response);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return allowed;
        //return true;//测试时使用，用完删除 恢复上面的
    }

    /**
     * 如果这个Filter在之前isAccessAllowed（）方法中返回false,则会进入这个方法
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse)  {
        try {
            HttpServletResponse httpResponse = WebUtils.toHttp(servletResponse);
            httpResponse.sendRedirect("/demo/index");
            fillCorsHeader(WebUtils.toHttp(servletRequest), httpResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) {
        String jwtToken = getAuthzHeader(servletRequest);
        if(StringUtils.isNotBlank(jwtToken))
            return new JWTToken(jwtToken);

        return null;
    }

    /**
     * 从请求头获取token
     * @param request
     * @return
     */
    protected String getAuthzHeader(ServletRequest request) {
        HttpServletRequest req = WebUtils.toHttp(request);
        //String token = req.getHeader("Token");
        String token = getToken(req, null);
        return token;
    }

    private String getToken(HttpServletRequest req, String token) {
        //if (StringUtils.isBlank(token)) {
            String params = req.getQueryString();
            if (null != params && !params.isEmpty()) {
                String[] strings = params.split("&");
                for (String string : strings) {
                    if (string.startsWith("token=")) {
                        token = StringUtils.removeStart(string, "token=");
                    }
                }
            }
        //}
        return token;
    }

    /**
     * 判断用户是否想要登入。
     * 检测 header 里面是否包含 Token 字段
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {

        HttpServletRequest req = (HttpServletRequest) request;
        //String token = req.getHeader("Token");
        String token = getToken(req, null);
        return token != null;
    }

    /**
     * 执行登陆操作
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        //String token = req.getHeader("Token");
        String token = getToken(req, null);

        JWTToken jwtToken = new JWTToken(token);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request, response).login(jwtToken);
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        //设置允许跨域访问的域名
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求 （包含复杂的方法和头时也会先发送options请求）
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

    protected void fillCorsHeader(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        //设置Access-Control-Allow-Origin：xxx ->允许指定的域名访问
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,HEAD");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
    }
}
