package com.chankin.ssms.web.controller;

import com.chankin.ssms.core.utils.PasswordEncrypt;
import com.chankin.ssms.web.model.User;
import com.chankin.ssms.web.security.PermissionSign;
import com.chankin.ssms.web.security.RoleSign;
import com.chankin.ssms.web.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    //用户登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid User user, BindingResult result, Model model, HttpServletRequest httpServletRequest) {
        try {
            //获取当前登录的subject对象
            Subject currentSubject = SecurityUtils.getSubject();
            if (currentSubject.isAuthenticated()) {
                return "redirect:/";
            }
            if (result.hasErrors()) {   //验证参数
                model.addAttribute("erro", "参数错误！");
                return "login";
            }

            // 将前台传来的密码进行封装  登录验证
            currentSubject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));

        } catch (AuthenticationException e) {
            model.addAttribute("erro", "用户名密码错误");
            return "login";
        }
        return "redirect:/";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("userInfo");
        // 登出操作
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    /**
     * 基于角色 标识的权限控制案例
     */
    @RequestMapping(value = "/admin")
    @ResponseBody
    @RequiresRoles(value = RoleSign.ADMIN)
    public String admin() {
        return "拥有admin角色,能访问";
    }

    /**
     * 基于权限标识的权限控制案例
     */
    @RequestMapping(value = "/create")
    @ResponseBody
    @RequiresPermissions(value = PermissionSign.USER_CREATE)
    public String create() {
        return "拥有user:create权限,能访问";
    }
}
