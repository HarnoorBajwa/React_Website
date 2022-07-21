package ca.dal.Group2.Task.Service;

import ca.dal.Group2.Task.Entity.DueDateEntity;

import java.util.List;

public interface DueDateService {

    boolean save(DueDateEntity entity);

    List<DueDateEntity> list();

    DueDateEntity findById(Long id);
}
