package com.example.myblogcommon.dbblog.service.impl;

import com.example.myblogcommon.dbblog.entity.BookSense;
import com.example.myblogcommon.dbblog.mapper.BookSenseMapper;
import com.example.myblogcommon.dbblog.service.BookSenseService;
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
 * 读后感 服务实现类
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@Service
@Slf4j
public class BookSenseServiceImpl extends ServiceImpl<BookSenseMapper, BookSense> implements BookSenseService {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map
                                       <String, Object> params) {
        IPage<BookSense> page = baseMapper.selectPage(new Query<BookSense>(params).getPage(),
                new QueryWrapper<BookSense>().lambda());
        return new PageUtils(page);
    }

}
