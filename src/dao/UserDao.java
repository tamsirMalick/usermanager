package dao;

import models.IUser;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao  implements IUser {
    private static final String Insert_User = "INSERT INTO user values (0, ?, ?, ?, ?, ?)";
    private static final String List_User = "SELECT * FROM user";
    private static final String Delete_User = "DELETE FROM user WHERE userId = ?";
    private static final String Update_User = "UPDATE user SET firstname = ?, lastname = ?, email = ?, phone = ?, password = ? WHERE userId = ?";
    private static final String GetOneUser = "SELECT * FROM user WHERE userId = ?";
    private static final Connection connexion = ConnectionManager.getConnection();

    @Override
    public void addUser(User user) {
        if(user != null) {
            Connection conn = ConnectionManager.getConnection();

            try {
                PreparedStatement ps = conn.prepareStatement(Insert_User);

                ps.setString(1, user.getFirstname());
                ps.setString(2, user.getLastname());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPhone());
                ps.setString(5, user.getPassword());
                ps.executeUpdate();
                ps.close();
            } catch (SQLException e) {
                System.out.println("Impossible d'ajouter l'utilisateur");
                e.printStackTrace();
            }
        } else {
            System.out.println("Impossible d'enregistrer un user avec la valeur null");
        }
    }

    @Override
    public void updateUser(User user) {
        if(user != null) {
            try {
                PreparedStatement ps = connexion.prepareStatement(Update_User);

                ps.setString(1, user.getFirstname());
                ps.setString(2, user.getLastname());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPhone());
                ps.setString(5, user.getPassword());
                ps.setInt(6, user.getUserId());

                ps.executeUpdate();
                ps.close();

            } catch (SQLException e) {
                System.out.println("Impossible de mettre a jour l'utilisateur");
                e.printStackTrace();
            }
        } else {
            System.out.println("Impossible de mettre un user avec la valeur null");
        }
    }

    @Override
    public void deleteUser(int userId) {
        if(userId <= 0) {
            System.out.println("Impossible de supprimer l'utilisateur avec une valeur negative");
        } else {
            try {
                PreparedStatement ps = connexion.prepareStatement(Delete_User);
                ps.setInt(1, userId);
                ps.executeUpdate();
                ps.close();
            } catch (SQLException e) {
                System.out.println("Impossible de supprimer l'utilisateur");
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        try {
            Statement st = connexion.createStatement();
            ResultSet rs = st.executeQuery(List_User);
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setPassword(rs.getString("password"));

                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Impossible de charger les utilisateurs");
            e.printStackTrace();
        }
        if(users == null) {
            System.out.println("Aucun utilisateur trouvé");
        }
        return users;
    }

    @Override
    public User getOneUser(int userId) {
        User user = null;
        try {
            PreparedStatement ps = connexion.prepareStatement(GetOneUser);
            ps.setInt(1,userId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(user == null) {
            System.out.println("Cet utilisateur n'exite pas");
        }
        return user;
    }
}
