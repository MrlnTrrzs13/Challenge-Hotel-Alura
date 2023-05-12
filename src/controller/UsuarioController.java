
package controller;

import dao.UsuarioDao;
import java.sql.Connection;
import java.util.List;
import factory.Conexion;
import model.Usuario;

/**
 *
 * @author Marlon Torres
 */
public class UsuarioController {

    private final UsuarioDao userDao;

    public UsuarioController() {
        Connection connection = new Conexion().connection();
        this.userDao = new UsuarioDao(connection);
    }
    
    public void Save(Usuario users) {
        this.userDao.Save(users);
    }

    public List<Usuario> ToListUser() {
        return this.userDao.ToListUser();
    }

    public List<Usuario> SearchId(Integer id) {
        return this.userDao.SearchId(id);
    }
    
    public List<Usuario> SearchUserId(String userName, String password) {
        return this.userDao.SearchUserId(userName, password);
    }

    public void Uptade(String name, String email, String phone, String username,
            String levelType, String status, Integer id) {
        this.userDao.Update(name, email, phone, username, levelType, status, id);
    }
    public void UpdatePassword(String password, int id){
        this.userDao.UpdatePassword(password, id);
    }

    public void Delete(Integer id) {
        this.userDao.Delete(id);
    }
   
    public List<Usuario> SearchNameAdmin(String username) {
        return this.userDao.SearchNameAdmin(username);
    }
    
    public List<Usuario> ActiveUser(String username, Integer id) {
        return this.userDao.ActiveUser(username, id);
    }
    
    public List<Usuario> Validation(String username) {
        return this.userDao.Validation(username);
    }
}
