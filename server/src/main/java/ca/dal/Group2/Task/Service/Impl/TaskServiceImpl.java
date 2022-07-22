package ca.dal.Group2.Task.Service.Impl;

import ca.dal.Group2.Task.Entity.TaskEntity;
import ca.dal.Group2.Task.Entity.dto.TaskDTO;
import ca.dal.Group2.Task.Repository.TaskRepo;
import ca.dal.Group2.Task.Service.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	TaskRepo taskRepo;

	@Override
	public TaskEntity createTask(TaskEntity task) {
		taskRepo.save(task);
		return task;
	}

    @Override
	public TaskEntity updateTask(TaskEntity task){
        taskRepo.save(task);
        return task;
    }

	@Override
	public Map<String, Object> changeStatus(Long id, String status) {
		HashMap<String, Object> map = new HashMap<>();
		if(!status.equals("to-do")&&!status.equals("doing")){
			map.put("msg", "status error");
			return map;
		}
		Optional<TaskEntity> byId = this.taskRepo.findById(id);
		if(byId.isPresent()) {
			TaskEntity model = byId.get();
			model.setStatus(status);
			this.taskRepo.save(model);
			map.put("msg", "success");
			map.put("status", status);
			return map;
		}else{
			map.put("msg", "Data does not exist");
			return map;
		}
	}

	@Override
	public List<TaskDTO> findAll() {
		List<TaskEntity> list = taskRepo.findAll();
		ArrayList<TaskDTO> dtos = new ArrayList<>();
		for(TaskEntity entity : list){
			TaskDTO dto = new TaskDTO();
			BeanUtils.copyProperties(entity, dto);
			dtos.add(dto);
		}
		return dtos;
	}
}
