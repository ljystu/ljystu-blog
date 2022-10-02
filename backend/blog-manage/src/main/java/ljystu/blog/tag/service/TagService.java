package ljystu.blog.tag.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ljystu.blog.common.util.PageUtils;
import ljystu.blog.entity.article.Article;
import ljystu.blog.entity.operation.Tag;

import java.util.HashMap;
import java.util.List;

public interface TagService extends IService<Tag> {


    List<Tag> listBylinkId(Integer id, int type);
}
