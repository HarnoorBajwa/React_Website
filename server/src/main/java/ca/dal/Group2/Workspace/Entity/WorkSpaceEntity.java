package ca.dal.Group2.Workspace.Entity;

import ca.dal.Group2.Board.Entity.BoardEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class WorkSpaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String workSpaceName;
    private String workSpaceDescription;
    private String workSpaceType;

    @OneToMany(targetEntity = BoardEntity.class)
    @JoinColumn(name = "board_map")
    private List<BoardEntity> boards;





}
