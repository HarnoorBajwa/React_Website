package Group2;

import Group2.Service.BoardService;
import Group2.Service.WorkSpaceService;
import Group2.entity.BoardEntity;
import Group2.entity.WorkSpaceEntity;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ServerApplicationTests {

	@Autowired
	private WorkSpaceService workSpaceService;

    @Autowired
    private BoardService boardService;

    @Test
    public void testWorkSpaceAdd(){

	    log.info("work_space_test start");
        WorkSpaceEntity model = new WorkSpaceEntity();
        model.setWorkSpaceName("work_space_test");
        model.setWorkSpaceDescription("work_space_test");
        model.setWorkSpaceType("work_space_test");
        boolean save = workSpaceService.save(model);
        log.info("work_space_test result:" + save);
    }

    @Test
    public void testBoardAdd(){

        log.info("board_test start");
        BoardEntity model = new BoardEntity();
        model.setWorkSpaceId(1L);
        model.setBoardName("board_test");
        model.setBoardDescription("board_test");
        boolean save = boardService.save(model);
        log.info("board_test result:" + save);
    }

}
