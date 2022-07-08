package Group2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName(value = "work_space")
public class WorkSpaceEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String workSpaceName;
    private String workSpaceDescription;
    private String workSpaceType;
}
