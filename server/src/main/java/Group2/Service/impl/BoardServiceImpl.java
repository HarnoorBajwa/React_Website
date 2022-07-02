package Group2.Service.impl;

import Group2.Service.BoardService;
import Group2.dao.BoardDao;
import Group2.entity.BoardEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl extends ServiceImpl<BoardDao, BoardEntity> implements BoardService {

    @Override
    public List<BoardEntity> getByWorkSpaceId(Long workSpaceId) {

        QueryWrapper<BoardEntity> qw = new QueryWrapper<>();
        qw.lambda().eq(BoardEntity::getWorkSpaceId, workSpaceId);
        return baseMapper.selectList(qw);
    }

    @Override
    public boolean deleteById(Long id) {
        return baseMapper.deleteById(id) > 0;
    }
}
