package com.boxflux.tool.web.controller;

import com.boxflux.tool.web.config.accessLimit.AccessLimit;
import com.boxflux.tool.web.domain.test.entity.User;
import com.boxflux.tool.web.domain.test.service.UserService;
import com.boxflux.tool.web.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by wangguanglin on 2019/6/11.
 */
@RestController
public class FangshuaController {

    @Autowired
    private UserService userService;

    //@AccessLimit(resource = "fang",seconds=5, maxCount=5, needLogin=true)
    @RequestMapping("/fangshua")
    @ResponseBody
    public Result<String> fangshua(){

        User user = userService.getUser(1l);

        return new Result<String>().success(null==user?"SUCCESS":user.toString());

    }

}
