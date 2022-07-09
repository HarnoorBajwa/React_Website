package ca.dal.Group2.Workspace.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import ca.dal.Group2.Board.Entity.BoardEntity;
import ca.dal.Group2.Board.Repository.BoardRepo;
import ca.dal.Group2.Workspace.Entity.WorkSpaceEntity;
import ca.dal.Group2.Workspace.Repository.WorkspaceRepo;
import ca.dal.Group2.Workspace.Service.WorkSpaceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkSpaceServiceImpl implements WorkSpaceService {
    @Autowired
    WorkspaceRepo workspaceRepo;

    @Autowired
    BoardRepo boardRepo;
    // public boolean addUserToWorkspace(String userEmail, long workspaceId){
        
    //     return true;
    // }

    public WorkSpaceEntity add(WorkSpaceEntity workspace){
        return workspaceRepo.save(workspace);
    }



    public WorkSpaceEntity addBoard(int boardId, int workspaceId){
        WorkSpaceEntity ret = null;
        Optional<BoardEntity> board = boardRepo.findById((long)boardId);
        Optional<WorkSpaceEntity> workspace = workspaceRepo.findById((long)workspaceId);
        System.out.print("sdjikrgnbszdjkrhgb");

        if(board.isPresent() && workspace.isPresent()){
            List<BoardEntity> boards = workspace.get().getBoards();
            if(board.get() == null){
                boards = new ArrayList<BoardEntity>();
            }
            boards.add(board.get());
            workspace.get().setBoards(boards);
            ret = workspaceRepo.save(workspace.get());
        }
        return ret;

    }

    
}
