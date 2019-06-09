package model;

import dao.DAO;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Data
@Accessors(chain = true)
@Entity
public class Building {
    @Id
    @GeneratedValue
    private Long idBuilding;

    private String name;
    private Integer quantityOfBathrooms;
    private Boolean elevator;
    private Boolean accessibility;

    @ManyToOne
    private Campus campus;

    @ManyToOne
    private Institute institute;

    private static dao.DAO DAO = new DAO();

    public static void delete(Long id) {
        DAO.delete(new Building().setIdBuilding(id));
    }

    public static Building findOne(Long id) {
        return (Building) DAO.findOne(id, Building.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(Building.class);
    }

    public static Optional<Building> save(Building building){return DAO.save(building); }

    public static Optional<Building> update(Building building) {
        return DAO.update(building);
    }
}
