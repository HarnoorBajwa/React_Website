package Group2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class WorkSpaceEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String workSpaceName;
    private String workSpaceDescription;
    private String workSpaceType;
}
