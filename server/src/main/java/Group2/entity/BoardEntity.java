package Group2.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName(value = "board")
public class BoardEntity {

    private Long id;
    private Long workSpaceId;
    private String boardName;
    private String boardDescription;
}
