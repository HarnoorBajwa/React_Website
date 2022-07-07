package Group2.Controller;

import Group2.Service.BoardService;
import Group2.entity.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/add")
    public Boolean add(@RequestBody BoardEntity model){
        return boardService.save(model);
    }

    @PostMapping("/update")
    public Boolean update(@RequestBody BoardEntity model){
        return boardService.updateById(model);
    }


    @GetMapping("/getByWorkSpaceId/{workSpaceId}")
    public List<BoardEntity> getByWorkSpaceId(@PathVariable("workSpaceId")Long workSpaceId){

        return boardService.getByWorkSpaceId(workSpaceId);
    }

    @DeleteMapping("/deleteById/{id}")
    public Boolean deleteById(@PathVariable("id")Long id){

        return boardService.deleteById(id);
    }
}
