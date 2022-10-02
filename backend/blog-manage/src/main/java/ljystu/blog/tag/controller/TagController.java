package ljystu.blog.tag.controller;

import ljystu.blog.tag.service.TagService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/tag")
public class TagController {

    @Resource
    private TagService tagService;

//
//    @GetMapping("/list")
//    public Result listArticle(@RequestParam HashMap<String,Object> params){
//        PageUtils page = articleService.queryPage(params);
//        return Result.ok().put("page",page);
//
//    }


}
