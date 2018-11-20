package model;

import dao.UserDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.servlet.http.HttpServletRequest;

@Data
@Accessors(chain = true)
public class User {
    private Long idUser;
    private String login;
    private AccessLevelEnum accessLevel;
    private static UserDAO DAO = new UserDAO();

    public static Boolean authenticate(HttpServletRequest request){
        User u = DAO.authenticate(request.getParameter("login"), request.getParameter("password"));
        if (u.idUser != null){
            request.getSession().setAttribute("access_level", u.accessLevel);
            return true;
        }
        return false;
    }

    public User setAccessLevel(String accessLevel) {
        this.accessLevel = AccessLevelEnum.valueOf(accessLevel.toUpperCase());
        return this;
    }


}
