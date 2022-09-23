package com.example.myblogcommon.dbblog.service.impl;

import com.example.myblogcommon.dbblog.entity.SysUser;
import com.example.myblogcommon.dbblog.mapper.SysUserMapper;
import com.example.myblogcommon.dbblog.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myblogcommon.common.util.Query;
import com.example.myblogcommon.common.util.PageUtils;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map
                                       <String, Object> params) {
        IPage<SysUser> page = baseMapper.selectPage(new Query<SysUser>(params).getPage(),
                new QueryWrapper<SysUser>().lambda());
        return new PageUtils(page);
    }

}
