package Group2.Service;

import Group2.entity.BoardEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface BoardService extends IService<BoardEntity> {
    List<BoardEntity> getByWorkSpaceId(Long workSpaceId);

    boolean deleteById(Long id);
}
