package io.zbc.price.controller;

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

}
