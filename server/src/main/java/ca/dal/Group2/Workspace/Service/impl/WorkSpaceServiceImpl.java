package ca.dal.Group2.Workspace.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import ca.dal.Group2.Workspace.Entity.WorkSpaceEntity;
import ca.dal.Group2.Workspace.Service.WorkSpaceService;
import ca.dal.Group2.Workspace.dao.WorkSpaceDao;

import org.springframework.stereotype.Service;

@Service
public class WorkSpaceServiceImpl extends ServiceImpl<WorkSpaceDao, WorkSpaceEntity> implements WorkSpaceService {
}
