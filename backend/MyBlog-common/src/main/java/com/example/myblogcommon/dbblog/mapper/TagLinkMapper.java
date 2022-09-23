package com.example.myblogcommon.dbblog.mapper;

import com.example.myblogcommon.dbblog.entity.TagLink;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 标签多对多维护表 Mapper 接口
 * </p>
 *
 * @author ljystu
 * @since 2022-09-23
 */
@Mapper
public interface TagLinkMapper extends BaseMapper<TagLink> {

}
