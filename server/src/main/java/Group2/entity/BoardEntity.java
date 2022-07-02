package Group2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "board")
public class BoardEntity {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private int workSpaceId;
    private String boardName;
    private String boardDescription;
}
