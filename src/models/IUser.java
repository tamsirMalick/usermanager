package models;

import java.util.List;

public interface IUser {
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int userId);
    public List<User> getUsers();
    public User getOneUser(int userId);
}
