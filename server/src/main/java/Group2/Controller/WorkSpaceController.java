package Group2.Controller;

import Group2.Service.WorkSpaceService;
import Group2.entity.WorkSpaceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workSpace")
public class WorkSpaceController {

    @Autowired
    private WorkSpaceService workSpaceService;

    //创建工作区
    @PostMapping("/add")
    public Boolean add(@RequestBody WorkSpaceEntity model){

        workSpaceService.save(model);

        return true;
    }

    @PostMapping("/update")
    public Boolean update(@RequestBody WorkSpaceEntity model){
        return workSpaceService.updateById(model);
    }

}
