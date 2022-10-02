package ljystu.blog.tag.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ljystu.blog.entity.operation.Tag;
import ljystu.blog.tag.service.TagService;
import ljystu.blog.mapper.operation.TagMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {


    /**
     * @param id
     * @param type
     * @return
     */
    @Override
    public List<Tag> listBylinkId(Integer id, int type) {
        baseMapper.listByLinkId(id, type);
        return null;
    }
}
