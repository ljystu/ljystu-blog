package com.example.myblogcommon.dbblog.service.impl;

import com.example.myblogcommon.dbblog.entity.Link;
import com.example.myblogcommon.dbblog.mapper.LinkMapper;
import com.example.myblogcommon.dbblog.service.LinkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.example.myblogcommon.common.util.PageUtils;
import com.example.myblogcommon.common.util.Query;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * <p>
 * 友链 服务实现类
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@Service
@Slf4j
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map
                                       <String, Object> params) {
        IPage<Link> page = baseMapper.selectPage(new Query<Link>(params).getPage(),
                new QueryWrapper<Link>().lambda());
        return new PageUtils(page);
    }

}
