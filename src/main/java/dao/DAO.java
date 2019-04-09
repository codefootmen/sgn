package dao;

import model.Activity;

import java.util.List;
import java.util.Optional;

public interface DAO<Entity, PrimaryKeyType> {
//    Boolean save(Entity entity);

    Optional<Entity> save(Entity entity);

    Entity findOne(PrimaryKeyType key);

    List<Entity> findAll();

    Optional<Entity> update(Entity entity);

    Boolean delete(PrimaryKeyType key);
}
