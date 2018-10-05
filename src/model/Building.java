package model;

import dao.CampusDAO;
import dao.InstitutionDAO;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Building {
    private Long idBuilding;
    private String name;
    private Integer quantityOfBathrooms;
    private Boolean elevator;
    private Boolean accessibility;
    private Campus campus;
    private Long idCampus;
    private Institution institution;
    private Long idInstitution;

    public Campus getCampus() {
        if(campus == null){
            CampusDAO dao = new CampusDAO();
            campus = dao.find(idCampus);
        }
        return campus;
    }

    public Building setCampus(Campus campus) {
        this.idCampus = campus.getIdCampus();
        this.campus = campus;
        return this;
    }

    public Institution getInstitution() {
        if(institution == null){
            InstitutionDAO dao = new InstitutionDAO();
            institution = dao.find(idInstitution);
        }
        return institution;
    }

    public Building setInstitution(Institution institution) {
        this.idInstitution = institution.getIdInstitution();
        this.institution = institution;
        return this;
    }
}
