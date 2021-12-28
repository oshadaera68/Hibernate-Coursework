package lk.ijse.hibernate.dao.custom.Impl;

import lk.ijse.hibernate.entity.SuperEntity;

import java.util.List;

public interface SuperDAO<Entity extends SuperEntity, ID> {
    boolean save(Entity entity);

    boolean update(Entity entity);

    boolean delete(ID id);

    List<Entity> findAll();

    Entity get(ID id);

}
