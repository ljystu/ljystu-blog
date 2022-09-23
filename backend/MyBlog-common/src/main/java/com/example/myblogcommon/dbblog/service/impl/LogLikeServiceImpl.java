package com.example.myblogcommon.dbblog.service.impl;

import com.example.myblogcommon.dbblog.entity.LogLike;
import com.example.myblogcommon.dbblog.mapper.LogLikeMapper;
import com.example.myblogcommon.dbblog.service.LogLikeService;
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
 * 点赞日志 服务实现类
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@Service
@Slf4j
public class LogLikeServiceImpl extends ServiceImpl<LogLikeMapper, LogLike> implements LogLikeService {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map
                                       <String, Object> params) {
        IPage<LogLike> page = baseMapper.selectPage(new Query<LogLike>(params).getPage(),
                new QueryWrapper<LogLike>().lambda());
        return new PageUtils(page);
    }

}
