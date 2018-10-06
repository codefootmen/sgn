package model;

import dao.InstitutionDAO;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Campus {
    private Long idCampus;
    private String name;
    private String street;
    private Long number;
    private String city;
    private String state;
    private String telephone;
    private String zip;
    private Institution institution;
    private Long idInstitution;

    public Institution getInstitution() {
        if (institution == null) {
            InstitutionDAO dao = new InstitutionDAO();
            institution = dao.find(idInstitution);
        }
        return institution;
    }

    public Campus setInstitution(Institution institution) {
        this.idInstitution = institution.getIdInstitution();
        this.institution = institution;
        return this;
    }
}
