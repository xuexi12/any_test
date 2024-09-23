package com.test.auth.satoken.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {

    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin?name=zhang&pwd=123456
    @RequestMapping("doLogin")
    public SaResult doLogin(String name, String pwd) {
        // 第一步：比对前端提交的账号名称、密码
        if ("zhang".equals(name) && "123456".equals(pwd)) {
            // 第二步：根据账号id，进行登录
            StpUtil.login(10001);
            return SaResult.ok("登录成功");
        }
        return SaResult.error("登录失败");
    }


    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok("当前会话是否登录：" + StpUtil.isLogin());
    }

    @RequestMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

    @RequestMapping("checkLogin")
    public SaResult checkLogin() {
        StpUtil.checkLogin();
        return SaResult.ok();
    }

    @RequestMapping("activeToken")
    public SaResult activeToken() {
        // 先检查是否已被冻结
        StpUtil.checkActiveTimeout();
        // 检查通过后继续续签
        StpUtil.updateLastActiveToNow();
        return SaResult.ok();
    }

    @RequestMapping("getLoginId")
    public SaResult getLoginId() {
        Object loginId = StpUtil.getLoginId();
        return SaResult.ok(String.valueOf(loginId));
    }

    @RequestMapping("getTokenValue")
    public SaResult getTokenValue() {
        String tokenValue = StpUtil.getTokenValue();
        System.out.println(StpUtil.getTokenInfo());
        return SaResult.ok(String.valueOf(tokenValue));
    }

}
