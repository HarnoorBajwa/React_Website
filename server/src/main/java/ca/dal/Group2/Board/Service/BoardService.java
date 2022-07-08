package ca.dal.Group2.Board.Service;

import com.baomidou.mybatisplus.extension.service.IService;

import ca.dal.Group2.Board.Entity.BoardEntity;

import java.util.List;

public interface BoardService extends IService<BoardEntity> {
    List<BoardEntity> getByWorkSpaceId(Long workSpaceId);

    boolean deleteById(Long id);
}
