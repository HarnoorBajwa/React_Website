package Group2.Service.impl;

import Group2.Service.WorkSpaceService;
import Group2.dao.WorkSpaceDao;
import Group2.entity.WorkSpaceEntity;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class WorkSpaceServiceImpl extends ServiceImpl<WorkSpaceDao, WorkSpaceEntity> implements WorkSpaceService {
}
