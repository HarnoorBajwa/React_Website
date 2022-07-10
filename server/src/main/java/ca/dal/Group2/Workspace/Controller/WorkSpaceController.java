package ca.dal.Group2.Workspace.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.dal.Group2.Board.Entity.BoardEntity;
import ca.dal.Group2.Workspace.Entity.WorkSpaceEntity;
import ca.dal.Group2.Workspace.Service.WorkSpaceService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/workspace")
public class WorkSpaceController {

    @Autowired
    private WorkSpaceService workSpaceService;


    //创建工作区
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("add")
    public WorkSpaceEntity add(@RequestBody WorkSpaceEntity model){

        return workSpaceService.add(model);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("addUserToWorkspace/{workSpaceId}/{userEmail}")
    public Boolean addUserToWorkspace(){

        return true;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("addBoardToWorkspace/{workspaceId}")
    public WorkSpaceEntity addBoardToWorkspace(@PathVariable Integer workspaceId, @RequestParam Integer boardId){
        return workSpaceService.addBoard(boardId, workspaceId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("getBoards/{workspaceId}")
    public List<BoardEntity> getBoards(@PathVariable int workspaceId) {
        
        return workSpaceService.getBoards(workspaceId);
    }
    

}
