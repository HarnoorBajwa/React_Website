package ca.dal.Group2.Task.Service;

import ca.dal.Group2.Task.Entity.TaskEntity;
import ca.dal.Group2.Task.Entity.dto.TaskDTO;

import java.util.List;
import java.util.Map;

public interface TaskService {

    public TaskEntity createTask(TaskEntity Task);

    public TaskEntity updateTask(TaskEntity Task);

    Map<String, Object> changeStatus(Long id, String status);

    List<TaskEntity> findAll(Long boardId);

    public TaskEntity getTask(Long taskId);

}
