package io.zbc.price.controller;

import io.zbc.price.config.SystemConfig;
import io.zbc.price.controller.oauth.AuthService;
import io.zbc.price.entity.Result;
import io.zbc.price.entity.User;
import io.zbc.price.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/user/*")
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private SystemConfig systemConfig;

    @Autowired
    private AuthService authService;

    private static final String USER_ID = "userId";

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody User user, HttpServletRequest request) {
        User userLogin = userService.getUserByNameAndPassword(user);
        if (userLogin == null) {
            return Result.failResult();
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", userLogin);
        session.setMaxInactiveInterval(60 * 60);
        return Result.successResult(userLogin);
    }

    @RequestMapping(value = "/signOut", method = RequestMethod.POST)
    @ResponseBody
    public Result signOut(HttpServletRequest request) {
        request.getSession().setAttribute("user", null);
        if (systemConfig.getAuthorizationEnabled()) {
            authService.signOut();
        }
        return Result.successResult();
    }

    @RequestMapping(value = "/oauth2Login", method = RequestMethod.GET)
    @ResponseBody
    public Result oauth2Login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return user != null ? Result.successResult(user) : Result.failResult();
    }

    @RequestMapping(value = "/getUserFromSession", method = RequestMethod.GET)
    @ResponseBody
    public Result getUserFromSession(HttpSession session) {
        User userLogin = (User) session.getAttribute("user");
        if (userLogin == null) {
            return Result.failResult();
        }
        return Result.successResult(userLogin);
    }

}
