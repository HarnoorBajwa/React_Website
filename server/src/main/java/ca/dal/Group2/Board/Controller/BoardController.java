package ca.dal.Group2.Board.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ca.dal.Group2.Board.Entity.BoardEntity;
import ca.dal.Group2.Board.Service.BoardService;

import java.io.Console;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    //创建看板
    @PostMapping("/add")
    public BoardEntity add(@RequestBody BoardEntity model){

        return boardService.createBoard(model);
        
    }

    // //获取看板
    // @GetMapping("/getByWorkSpaceId/{workSpaceId}")
    // public List<BoardEntity> getByWorkSpaceId(@PathVariable("workSpaceId")Long workSpaceId){

    //     return boardService.getByWorkSpaceId(workSpaceId);
    // }

    //删除看板
    @DeleteMapping("/deleteById/{id}")
    public Boolean deleteById(@PathVariable("id")Long id){
        return boardService.deleteBoard(id);
    }

}