package com.zr0726.news.realm;

import com.zr0726.news.po.Permission;
import com.zr0726.news.po.Role;
import com.zr0726.news.po.User;
import com.zr0726.news.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class NewsRealm extends AuthorizingRealm {
    public void setName(String name){setName("newsRealm");}

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取认证的用户数据
        User user = (User)principalCollection.getPrimaryPrincipal();
        //构造认证数据
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<Role> roles = user.getRoles();
        for (Role role:roles){
            //获得角色信息
            info.addRole(role.getName());
            for (Permission permission:role.getPermissions()){
                //添加权限信息
                info.addStringPermission(permission.getCode());
            }
        }
        return info;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken)authenticationToken;
        String username = upToken.getUsername();
        String password = new String(upToken.getPassword());
        User user = userService.checkUsers(username, password);
        if (user!=null){
            return  new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
        }
        return null;
    }






    }

