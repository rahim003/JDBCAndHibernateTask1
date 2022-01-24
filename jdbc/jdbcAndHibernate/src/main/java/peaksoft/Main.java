package peaksoft;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static final Scanner sc=new Scanner(System.in);
    public static final Scanner sc1=new Scanner(System.in);
    public static final Scanner sc2=new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        System.out.println("Choose a language Kyr and RUS");
        UserService userService = new UserServiceImpl();
        String word = sc.nextLine();
        while (true) {
            if (word.equals("Kyr")) {
                User.printInformation();
            } else if (word.equals("Rus")) {
                User.printInformation2();
            } else {
                System.out.println();
            }

            int number = sc.nextInt();
            if (number == 1) {
                userService.createUsersTable();
            } else if (number == 2) {
                userService.dropUsersTable();
            } else if (number == 3) {

                System.out.println("name");
                String name = sc1.nextLine();
                System.out.println("lastName");
                String lastName = sc1.nextLine();
                System.out.println("age");
                byte age = sc2.nextByte();
                userService.saveUser(name, lastName, age);
            } else if (number == 4) {
                userService.removeUserById(sc.nextLong());
            } else if (number == 5) {
                userService.getAllUsers();
            } else if (number == 6) {
                userService.cleanUsersTable();
            } else {
                System.out.println("Kechriniz baska san jok");
            }
        }


        }

    }

