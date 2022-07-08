package Group2.entity;

import lombok.Data;

@Data
public class BoardEntity {

    private Long id;
    private Long workSpaceId;
    private String boardName;
    private String boardDescription;
}
