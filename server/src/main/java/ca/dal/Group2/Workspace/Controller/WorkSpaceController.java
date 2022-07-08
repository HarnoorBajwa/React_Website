package ca.dal.Group2.Workspace.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.dal.Group2.Workspace.Entity.WorkSpaceEntity;
import ca.dal.Group2.Workspace.Service.WorkSpaceService;

@RestController
@RequestMapping("/workSpace")
public class WorkSpaceController {

    @Autowired
    private WorkSpaceService workSpaceService;

    //创建工作区
    @PostMapping("/add")
    public Boolean add(@RequestBody WorkSpaceEntity model){

        return workSpaceService.save(model);
    }

    @PostMapping("/update")
    public Boolean update(@RequestBody WorkSpaceEntity model){
        return workSpaceService.updateById(model);
    }

    @PostMapping("addUserToWorkspace/{workSpaceId}/{userEmail}")
    public Boolean addUserToWorkspace(){

        return true;
    }

}
