package com.example.myblogcommon.dbblog.service.impl;

import com.example.myblogcommon.dbblog.entity.SysParam;
import com.example.myblogcommon.dbblog.mapper.SysParamMapper;
import com.example.myblogcommon.dbblog.service.SysParamService;
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
 * 系统参数 服务实现类
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@Service
@Slf4j
public class SysParamServiceImpl extends ServiceImpl<SysParamMapper, SysParam> implements SysParamService {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map
                                       <String, Object> params) {
        IPage<SysParam> page = baseMapper.selectPage(new Query<SysParam>(params).getPage(),
                new QueryWrapper<SysParam>().lambda());
        return new PageUtils(page);
    }

}
