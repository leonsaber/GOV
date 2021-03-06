package com.processchecker.presenter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.processchecker.model.entity.AuthenticationBean;
import com.processchecker.model.entity.LoginRequestBean;
import com.processchecker.model.service.LoginHandler;
import com.processchecker.model.utils.MySQLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ss on 2017/10/21.
 */

@EnableAutoConfiguration
@RestController
@RequestMapping("/api")
public class LoginPresenter {

    private Gson gson = new GsonBuilder().create();

    @RequestMapping("/allDepartments")
    public String getDepartments() {

        return gson.toJson(MySQLUtils.getDepartments());
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String getCheckUserInfo(@RequestBody String body) {

        LoginHandler loginHandler = new LoginHandler();

        LoginRequestBean requestBean = gson.fromJson(body, LoginRequestBean.class);

        return gson.toJson(loginHandler.authenticate(requestBean));
    }
}
