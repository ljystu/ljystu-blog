package ljystu.blog.mapper.operation;

import ljystu.blog.entity.operation.Tag;
import ljystu.blog.entity.operation.vo.TagDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * TagMapper
 *
 * @Author: ljystu
 * @Date: 02/10/2022-15:48
 */

@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    /**
     * 根据linkId获取Tag列表
     *
     * @param linkId
     * @param type
     * @return
     */
    List<Tag> listByLinkId(@Param("linkId") Integer linkId, @Param("type") Integer type);

    /**
     * 根据linkId删除多对多关联
     *
     * @param linkId
     * @param type
     */
    void deleteTagLink(@Param("linkId") Integer linkId, @Param("type") Integer type);

    /**
     * 获取tagVoList
     *
     * @return
     */
    List<TagDTO> listTagVo();
}
