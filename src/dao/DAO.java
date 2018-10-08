package dao;

import java.util.List;

public interface DAO<Entity, PrimaryKeyType> {
    Boolean save(Entity entity);

    Entity findOne(PrimaryKeyType key);

    List<Entity> findAll();

    Boolean update(Entity entity);

    Boolean delete(PrimaryKeyType key);
}
