package Group2.Controller;

import Group2.Service.WorkSpaceService;
import Group2.entity.WorkSpaceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/workSpace")
public class WorkSpaceController {

    @Autowired
    private WorkSpaceService workSpaceService;

    @GetMapping("")
    public List<WorkSpaceEntity> getAll() {
        return workSpaceService.list();
    }

    @PostMapping("/add")
    public Boolean add(@RequestBody WorkSpaceEntity model){
        return workSpaceService.save(model);
    }

    @PostMapping("/update")
    public Boolean update(@RequestBody WorkSpaceEntity model){
        return workSpaceService.updateById(model);
    }


}
