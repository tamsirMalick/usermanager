package metier;

import dao.UserDao;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserDao dao;

    public UserService() {
        dao = new UserDao();
    }

    /**
     * usage : service.addUser(user)
     * @param user
     */
    public void addUser(User user) {
        if(user == null) {
            System.out.println("Pas d'utilisateur null");
        } else {
            dao.addUser(user);
        }
    }

    /**
     * usage : service.update(user)
     * @param user
     */
    public void updateUser(User user) {
        if(user == null) {
            System.out.println("Modification impossible ! pas d'utilisateur null");
        } else {
            dao.updateUser(user);
        }
    }

    /**
     * usage : service.delete(userId)
     * @param userId
     */
    public void deleteUser(int userId) {
        if(userId <= 0) {
            System.out.println("Utilisateur invalide !");
        } else {
            dao.deleteUser(userId);
        }
    }

    /**
     * usage: service.listUsers()
     * @return
     */
    public List<User> listUsers() {
        List<User> users = new ArrayList<>();
        users = dao.getUsers();
        if (users == null) {
            System.out.println("Aucun utilisateur dans la base de données");
        }
        return users;
    }

    /**
     * usage : service.getUserById()
     * @param userId
     * @return
     */
    public User getUserById(int userId) {
        if(userId <= 0) {
            System.out.println("Utilisateur invalide");
        }
        return dao.getOneUser(userId);
    }
}
