package com.example.myblogcommon.dbblog.service.impl;

import com.example.myblogcommon.dbblog.entity.Tag;
import com.example.myblogcommon.dbblog.mapper.TagMapper;
import com.example.myblogcommon.dbblog.service.TagService;
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
 * 标签 服务实现类
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@Service
@Slf4j
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map
                                       <String, Object> params) {
        IPage<Tag> page = baseMapper.selectPage(new Query<Tag>(params).getPage(),
                new QueryWrapper<Tag>().lambda());
        return new PageUtils(page);
    }

}
