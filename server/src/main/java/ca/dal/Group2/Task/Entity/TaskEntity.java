package ca.dal.Group2.Task.Entity;

import ca.dal.Group2.Board.Entity.BoardEntity;
import ca.dal.Group2.User.Entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @OneToOne(targetEntity = BoardEntity.class)
    @JoinColumn(name = "board_id")
    private BoardEntity board;

    @OneToOne(targetEntity = DueDateEntity.class)
    @JoinColumn(name = "due_date_id")
    private DueDateEntity dueDate;

    @OneToMany(targetEntity = UserEntity.class)
    @JoinColumn(name = "task_id")
    private List<UserEntity> users;


}
