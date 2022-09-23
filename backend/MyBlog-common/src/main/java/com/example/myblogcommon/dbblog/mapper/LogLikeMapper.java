package com.example.myblogcommon.dbblog.mapper;

import com.example.myblogcommon.dbblog.entity.LogLike;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 点赞日志 Mapper 接口
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@Mapper
public interface LogLikeMapper extends BaseMapper<LogLike> {

}
