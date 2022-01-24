package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
 Util util;
    public UserDaoJdbcImpl() {
    }

    public void createUsersTable() {
        try (
                Connection conn= Util.connections();
                Statement statement=conn.createStatement();
        ){
            String SQL="CREATE  TABLE users(" +
                    "id serial primary  key ," +
                    "name VARCHAR  NOT NULL ," +
                    "lastName VARCHAR NOT NULL," +
                    "age int not null )";
            statement.executeUpdate(SQL);
            System.out.println("Таблица тузулду ");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void dropUsersTable() {
        try {
            Connection conn1 = Util.connections();
            Statement statement1 = conn1.createStatement();
            String drop = "DROP TABLE  users";
            System.out.println(statement1.execute(drop));
            System.out.println("Таблица удалить болду");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "insert into users (name, lastName, age)values (?,?,?)";
        try {
            Connection coons = Util.connections();
            PreparedStatement statement = coons.prepareStatement(sql);
            {
                statement.setString(1, name);
                statement.setString(2, lastName);
                statement.setByte(3, age);
                statement.executeUpdate();
            }
            System.out.println("Маани кошулду");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void removeUserById(long id)  {
        try (
                PreparedStatement preparedStatement=Util.connections()
                        .prepareStatement("delete  from users where id=(?)")){
            preparedStatement.setLong(1, id);
            ResultSet rs=preparedStatement.executeQuery();
            if (rs.next()){
                int id1=rs.getInt("id");
                String name=rs.getString("name");
                String lastName=rs.getString("lastName");
              byte age =rs.getByte("age");
                System.out.println(id1);
                System.out.println(name);
                System.out.println(lastName);
                System.out.println(age);
            }
        }catch (SQLException e){
            System.out.println("Uer удалит этилди");
        }

    }

    public List<User> getAllUsers() {
        List<User>users=new ArrayList<>();
        try {
            Connection conn4=Util.connections();
            Statement statement4=conn4.createStatement();
            String SQL4="SELECT *FROM users";
            statement4.execute(SQL4);
            ResultSet rs4=statement4.executeQuery(SQL4);
            while (rs4.next()){
                User user=new User();
                user.setId(rs4.getLong("id"));
                user.setName(rs4.getString("name"));
                user.setLastName(rs4.getString("lastName"));
                user.setAge(rs4.getByte("age"));
                users.add(user);
            }
            System.out.println(users);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
      try {
          Connection conn5=Util.connections();
          Statement  statement5=conn5.createStatement();
          String SQL5="delete from users";
          System.out.println(statement5.executeUpdate(SQL5));
          System.out.println("Маанилерди очуруп салдыныз");
      } catch (SQLException e) {
          e.printStackTrace();
      }
    }
}