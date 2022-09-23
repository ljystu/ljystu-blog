package com.example.myblogcommon.dbblog.service.impl;

import com.example.myblogcommon.dbblog.entity.SysMenu;
import com.example.myblogcommon.dbblog.mapper.SysMenuMapper;
import com.example.myblogcommon.dbblog.service.SysMenuService;
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
 * 菜单管理 服务实现类
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@Service
@Slf4j
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map
                                       <String, Object> params) {
        IPage<SysMenu> page = baseMapper.selectPage(new Query<SysMenu>(params).getPage(),
                new QueryWrapper<SysMenu>().lambda());
        return new PageUtils(page);
    }

}
