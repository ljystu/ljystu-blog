package com.example.myblogcommon.dbblog.service;

import com.example.myblogcommon.dbblog.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myblogcommon.common.util.PageUtils;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map
                                <String, Object> params);
}
