package pl.entity;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDAO {

    private static final String ADD_USER_QUERY = "insert into users (email, username, password) values (?,?,?)";
    private static final String REMOVE_USER_QUERY = "delete from users where id = ?";
    private static final String FIND_USER_QUERY = "select * from users where id = ?";
    private static final String UPDATE_USER_QUERY = "update users set email = ?, username = ?, password =? where id = ?";
    private static final String FIND_ALL_QUERY = "select id,username,email from users";
    private static final String UPDATE_PASSWORD = "update users set password = ? where id = ?";

    //create
    public User addUser(User user) throws SQLException {
        Connection con = DBUtil.getConnection();

        try (PreparedStatement ps = con.prepareStatement(ADD_USER_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUsername());
            ps.setString(3, hashPassword(user.getPassword()));  //hashujemy haslo
            ps.executeUpdate();

            //wyswietlamy nowo dodany klucz (id)
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void removeUser(int userId) throws SQLException {
        Connection con = DBUtil.getConnection();
        if (findUser(userId) != null) {
            try (PreparedStatement ps = con.prepareStatement(REMOVE_USER_QUERY)) {
                ps.setInt(1, userId);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public User findUser(int userId) throws SQLException {
        User person = new User(userId);
        Connection con = DBUtil.getConnection();

        try (PreparedStatement ps = con.prepareStatement(FIND_USER_QUERY)) {
            ps.setInt(1, userId);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                person.setId(result.getInt("id"));
                person.setEmail(result.getString("email"));
                person.setUsername(result.getString("username"));
                person.setPassword(result.getString("password"));

                return person;

            } else {
                System.out.println("Wrong ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public List<User> displayAll() throws SQLException {
        //User[] users = new User[0];
        List<User> users = new ArrayList<>();
        Connection con = DBUtil.getConnection();

        try (Statement st = con.createStatement()) {
            ResultSet result = st.executeQuery(FIND_ALL_QUERY);

            while (result.next()){
                users.add(new User(result.getInt("id"),result.getString("username"),result.getString("email")));

//            while (result.next()) {
//                String mail = result.getString("email");
//                String name = result.getString("username");
//                String password = result.getString("password");
//                int id = result.getInt("id");
//                //System.out.println("ID: " + id + " E-mail: " + mail + ", " + "User Name: " + name + ", Password:  " + password);
//
//                User user = new User(mail, name, password, id);
//                users = Arrays.copyOf(users, users.length + 1);
//                users[users.length - 1] = user;
//                //System.out.println(Arrays.toString(users));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void updateUser(User user) throws SQLException {
        Connection con = DBUtil.getConnection();
        //if (findUser(user.getId()) != null) {
            try (PreparedStatement ps = con.prepareStatement(UPDATE_USER_QUERY)) {
                ps.setInt(4, user.getId());
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getUsername());
                ps.setString(3, hashPassword(user.getPassword()));

                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    //}

    public void updatePassword(User user) throws SQLException {
        Connection con = DBUtil.getConnection();
        if (findUser(user.getId()) != null) {
            try (PreparedStatement ps = con.prepareStatement(UPDATE_PASSWORD)) {
                ps.setInt(2, user.getId());
                ps.setString(1, hashPassword(user.getPassword()));

                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean checkPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);

    }
}


