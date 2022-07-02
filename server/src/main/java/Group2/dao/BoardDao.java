package Group2.dao;

import Group2.entity.BoardEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao extends BaseMapper<BoardEntity> {
}
