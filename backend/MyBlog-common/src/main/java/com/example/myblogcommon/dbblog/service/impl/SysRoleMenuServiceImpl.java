package com.example.myblogcommon.dbblog.service.impl;

import com.example.myblogcommon.dbblog.entity.SysRoleMenu;
import com.example.myblogcommon.dbblog.mapper.SysRoleMenuMapper;
import com.example.myblogcommon.dbblog.service.SysRoleMenuService;
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
 * 角色与菜单对应关系 服务实现类
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@Service
@Slf4j
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map
                                       <String, Object> params) {
        IPage<SysRoleMenu> page = baseMapper.selectPage(new Query<SysRoleMenu>(params).getPage(),
                new QueryWrapper<SysRoleMenu>().lambda());
        return new PageUtils(page);
    }

}
