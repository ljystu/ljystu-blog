package ljystu.blog.mapper.operation;

import ljystu.blog.entity.operation.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * @Author: ljystu
 * @Date: 02/10/2022-15:50
 */

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 查询所有类别
     *
     * @param params
     * @return
     */
    List<Category> queryAll(Map<String, Object> params);
}
