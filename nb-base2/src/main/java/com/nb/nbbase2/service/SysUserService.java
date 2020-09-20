package com.nb.nbbase2.service;

import com.nb.nbbase2.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 
 * @since 2020-09-02
 */
public interface SysUserService extends IService<SysUser> {

    void add2(String username);
}
