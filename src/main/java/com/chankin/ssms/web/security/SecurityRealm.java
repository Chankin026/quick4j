package com.chankin.ssms.web.security;

import com.chankin.ssms.core.utils.PasswordEncrypt;
import com.chankin.ssms.web.model.Permission;
import com.chankin.ssms.web.model.Role;
import com.chankin.ssms.web.model.User;
import com.chankin.ssms.web.service.PermissionService;
import com.chankin.ssms.web.service.RoleService;
import com.chankin.ssms.web.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户身份验证,授权 Realm 组件
 **/
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;

    @Resource
    private PermissionService permissionService;

    @Resource
    private RoleService roleService;

    //权限检查
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        String username = String.valueOf(principalCollection.getPrimaryPrincipal());
        final User user = userService.selectByUsername(username);
        final List<Role> roleInfos = roleService.selectRolesByUserId(user.getId());
        for (Role role : roleInfos) {
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleSign());
            final List<Permission> permissions = permissionService.selectPermissionsByRoleId(role.getId());
            for (Permission permission : permissions) {
                //添加权限
                simpleAuthorizationInfo.addStringPermission(permission.getPermissionSign());
            }
        }

        return simpleAuthorizationInfo;
    }

    /*
     *  密码验证时 已经把token进行md5加密
     *
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String password = new String((char[]) token.getCredentials());

        //1、authenticationtoken强转为usernamepasswordtoken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //2、获取username
        String username = usernamePasswordToken.getUsername();
        //密码MD5加密
        String credentials = PasswordEncrypt.createHash(username, password);

        //通过数据库进行验证
        final User authentication = userService.authentication(new User(username, credentials));

        if (authentication == null) {
            throw new AuthenticationException("用户名或密码错误。");
        }
        Object principal = username;

        //进行密码和token进行对比
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, authentication.getPassword(), ByteSource.Util.bytes(username), getName());

        return simpleAuthenticationInfo;
    }

    @Test
    public void ss() { //测试1024迭代后密码值
        String hashAlgorithmName = "MD5";
        Object credentials = "123456";
        Object salt = ByteSource.Util.bytes("chenjian026");
        int hashIterations = 1024;
        Object object = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(object);
    }
}
