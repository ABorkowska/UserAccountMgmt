package pl.entity;

import java.sql.SQLException;

public class MainDAO {


    public static void main(String[] args) throws SQLException {

        UserDAO userDao = new UserDAO();
        //User user = new User ("sara.halle@wp.com", "Saraina", "GoodByEAfrica10");
        //userDao.addUser(user);

        User userToUpdate = userDao.findUser(2);

        userToUpdate.setEmail("marigold96yahoo.de");

        userDao.updateUser(userToUpdate);


//        Scanner scanner = new Scanner (System.in);
//        String username;
//        String password = "";
//
//        System.out.println("Enter your User Name");
//        if (scanner.hasNextLine()){
//          username = scanner.nextLine();
//        }
//        System.out.println("Enter your Password");
//        if (scanner.hasNextLine()) {
//          password = scanner.nextLine();
//        }
//        System.out.println(userDao.checkPassword(password, userToFind.getPassword()));



//
//        user.setEmail("jaasmin@wp.pl");
       // user.setPassword("Terry70");
//        user.setUsername("VBill2005");

        //userDao.updateUser(user);
        //userDao.addUser(user);
        //User user = userDao.findUser(5);
        //System.out.println(user);
        //userDao.removeUser(4);
        //userDao.displayAll();

//        System.out.println(user.getEmail());
//        System.out.println(user.getId());
    }
}
