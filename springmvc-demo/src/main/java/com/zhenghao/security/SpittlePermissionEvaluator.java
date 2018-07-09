package com.zhenghao.security;


import com.zhenghao.domain.Spittle;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;

//自定义许可计算器
public class SpittlePermissionEvaluator implements PermissionEvaluator {

    private static final GrantedAuthority ADMIN_AUTHORITY =
            new SimpleGrantedAuthority("ROLE_ADMIN");

    //使用方法  @PreFilter("hasPermissin(targetObject, 'delete')")
    @Override
    public boolean hasPermission(Authentication authentication, Object target, Object permission) {
        if (target instanceof Spittle) {
            Spittle spittle = (Spittle) target;
            String username = spittle.getSpitter().getUserName();
            if ("delete".equals(permission)) {
                return isAdmin(authentication) || username.equals(authentication.getName());
            }
        }
        throw new UnsupportedOperationException();
    }

    private boolean isAdmin(Authentication authentication) {
        return authentication.getAuthorities().contains(ADMIN_AUTHORITY);
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        throw new UnsupportedOperationException();
    }
}
