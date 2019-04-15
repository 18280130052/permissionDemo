package com.synjones.cloudcard.permission.shiro;

import com.alibaba.dubbo.config.annotation.Reference;
import com.synjones.cloudcard.permission.provider.facade.PermissionProvider;
import com.synjones.cloudcard.permission.utils.JWTUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA
 * @Description 自定义 Realm
 * @Date 2018-04-09
 * @Time 16:58
 */
@Component
public class CustomRealm extends AuthorizingRealm {

    @Reference
    private PermissionProvider permissionProvider;

    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //System.out.println("————身份认证方法————");
        String token = (String) authenticationToken.getCredentials();
        if (StringUtils.isBlank(token) || JWTUtil.isTokenExpired(token)){
            throw new AuthenticationException("token失效！");
        }
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        //System.out.println("username-"+username);
        if (username == null || !JWTUtil.verify(token, username)) {
            throw new AuthenticationException("token认证失败！");
        }
        //缓存中获取 登录对象的json字符串
//        String loginName = RedisUtils.INSTANCE.getString(username+"login");
//        User user = null;
        return new SimpleAuthenticationInfo(token, token, "MyRealm");
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //System.out.println("————权限认证————");
        String token = principals.toString();
        String username = JWTUtil.getUsername(token);
        /*Set<String> cacheRole = RedisUtils.INSTANCE.getSet(token+"-role");
        //System.out.println("cacheRole-"+cacheRole);
        if (cacheRole == null || cacheRole.isEmpty()) {
            User user = userService.selectUserByName(username);
            //获得该用户角色
            Set<Role> roles = roleService.selectRoles(user.getId());
            cacheRole = new HashSet<>();
            for (Role role : roles) {
                cacheRole.add(role.getRoleSn());
            }
            RedisUtils.INSTANCE.setSet(token+"-role", 1800, ArrayUtils.toStringArray(cacheRole.toArray()));
        }
        //System.out.println("cacheRole后-"+cacheRole);
        Set<String> cacheAuth = RedisUtils.INSTANCE.getSet(token+"-auth");
        if (cacheAuth == null || cacheAuth.isEmpty()) {
            User user = userService.selectUserByName(username);
            //每个角色拥有默认的权限
            Set<Authority> authorities = authorityService.permissionsByUser(user.getId());
            cacheAuth = new HashSet<>();
            for (Authority authority : authorities) {
                cacheAuth.add(authority.getAuthoritySn());
            }
            RedisUtils.INSTANCE.setSet(token+"-auth",1800,ArrayUtils.toStringArray(cacheAuth.toArray()));
        }
        //设置该用户拥有的角色和权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(cacheRole);
        info.setStringPermissions(cacheAuth);
        return info;*/
        return null;
    }
}
