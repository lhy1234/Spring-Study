package com.nb.nbbase2.controller;


import cn.hutool.extra.spring.SpringUtil;
import com.nb.nbbase2.beans.Result;
import com.nb.nbbase2.service.SysUserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 
 * @since 2020-09-02
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ApplicationContext applicationContext;


    @GetMapping("read")
    public Result read() throws Exception{
        String[] webNames = webApplicationContext.getBeanDefinitionNames();
        System.err.println("----------web-----------");
        for(String webName:webNames){
            System.err.println(webName);
        }
        System.err.println("----------spring-----------");
        String[] names = applicationContext.getBeanDefinitionNames();
        for(String name:names){
            System.err.println(name);
        }
        return Result.ok();
    }

    @GetMapping("/testThread")
    public Result testThread(String username){
        sysUserService.add2(username);
        return Result.ok();
    }

}

