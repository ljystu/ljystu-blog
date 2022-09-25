package ljystu.blog.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;


/**
 * BaseEntity
 *
 * @Author: ljystu
 * @Date: 24/09/2022-18:07
 */

@Data
public class BaseEntity {

    /**
     * PK
     */
    @ApiModelProperty(value = "PK")
    @TableId(value = "id", type = IdType.AUTO)
    @Id
    private Integer id;

    /**
     * time created
     */
    @ApiModelProperty(value = "time created")
    @Field(type = FieldType.Date, format = DateFormat.none)
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * time updated
     */
    @ApiModelProperty(value = "time updated")
    @Field(type = FieldType.Date, format = DateFormat.none)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
