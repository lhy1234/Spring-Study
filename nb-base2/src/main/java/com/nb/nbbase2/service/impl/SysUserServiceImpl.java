package com.nb.nbbase2.service.impl;

import com.nb.nbbase2.entity.SmsProject;
import com.nb.nbbase2.entity.SysUser;
import com.nb.nbbase2.mapper.SysUserMapper;
import com.nb.nbbase2.service.SmsProjectService;
import com.nb.nbbase2.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-09-02
 */
@Service
@Transactional
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SmsProjectService smsProjectService;

    @Override
    public void add2(String username) {
        SysUser user = new SysUser();
        user.setUsername(username);
        user.setCreateTime(new Date());
        save(user);


        new Thread(()->{
            try{
                SmsProject project = new SmsProject();
                project.setDrugName(user.getUsername()+"-药物");
                project.setProjectCode(user.getId()+"--11111");
                smsProjectService.save(project);
                String ss = null;
                System.out.println(ss.length());
            }catch (Exception e){
                System.out.println("报错啦");
            }

        }).start();

    }




}
