package model;

import dao.DAO;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Data
@Accessors(chain = true)
public class User {
    private Long idUser;
    private String login;
    private AccessLevelEnum accessLevel;

    private static dao.DAO DAO = new DAO();

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

    public static Optional<User> save(User user) { return DAO.save(user); }

    public static Optional<User> update(User user) { return DAO.update(user); }

    public static void delete(Long id) { DAO.delete(new User().setIdUser(id)); }

    public static User findOne(Long id) { return (User) DAO.findOne(id, User.class); }

    public static List<Object> findAll() { return DAO.findAll(User.class); }


}
