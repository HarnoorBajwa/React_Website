package ca.dal.Group2.Board.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import ca.dal.Group2.Board.Entity.BoardEntity;
import ca.dal.Group2.Board.Service.BoardService;
import ca.dal.Group2.Board.dao.BoardDao;

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
