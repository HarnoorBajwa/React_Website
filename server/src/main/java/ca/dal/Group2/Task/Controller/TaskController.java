package ca.dal.Group2.Task.Controller;

import ca.dal.Group2.Board.Service.BoardService;
import ca.dal.Group2.Task.Entity.TaskEntity;
import ca.dal.Group2.Task.Entity.dto.TaskDTO;
import ca.dal.Group2.Task.Service.DueDateService;
import ca.dal.Group2.Task.Service.TaskService;
import ca.dal.Group2.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    @Autowired
    private DueDateService dueDateService;
    @Autowired
    private BoardService boardService;

    @PostMapping("/create/{dueDateId}/{boardId}")
    public TaskEntity create(@RequestBody TaskEntity model,
                             @PathVariable("dueDateId")Long dueDateId,
                             @PathVariable("boardId")Long boardId){
        if(dueDateId == null){
            throw new RuntimeException("dueDateId is null");
        }
        if(boardId == null){
            throw new RuntimeException("boardId is null");
        }
        model.setDueDate(dueDateService.findById(dueDateId));
        model.setBoard(boardService.findById(boardId));
        model.setCreateTime(new Date());
        TaskEntity task = taskService.createTask(model);
        return task;
    }


    @GetMapping("/assignTo/{userId}/{taskId}")
    public Boolean assignTo(@PathVariable("userId")Long userId, @PathVariable("taskId")Long taskId){
        return userService.addUserToTask(userId, taskId);
    }

    @GetMapping("/changeStatus/{taskId}/{status}")
    public Map<String, Object> changeStatus(@PathVariable("taskId")Long taskId, @PathVariable("status")String status){
        return taskService.changeStatus(taskId, status);
    }


    @GetMapping("/findAll")
    public List<TaskDTO> findAll(){
        return taskService.findAll();
    }
}
