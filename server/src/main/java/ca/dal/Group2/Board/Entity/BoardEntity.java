package ca.dal.Group2.Board.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName(value = "board")
public class BoardEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long workSpaceId;
    private String boardName;
    private String boardDescription;
}
