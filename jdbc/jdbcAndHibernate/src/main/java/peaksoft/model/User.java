package peaksoft.model;

import javax.persistence.*;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
     @Column(name = "last_name")
    private String lastName;

    private Byte age;

    public User() {
    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "id      ->" + id +'\n'+
                "name    ->" + name +'\n'+
                "lastName->" + lastName+'\n'+
                " age    ->"+  age;
    }
    public static void printInformation(){
        System.out.println("Таблицца тузуу учун 1 санын танданыз");
        System.out.println("Таблиццаны очуруу учун 2 санын танданыз");
        System.out.println("Таблицага маани киргизууну кааласаныз 3 санын басыныз");
        System.out.println("Таблицадагы маанини айди мн очуруу учун 4 санын басыныз");
        System.out.println("Таблицадагы ьаардык маалыматтарды корууну кааласаныз 5 санын басыныз");
        System.out.println("Таблиццадагы баардык маалыматты очуруу учун 6 санын басыныз");
    }
    public static void printInformation2(){
        System.out.println(" Выберите 1, чтобы создать таблицу ");
        System.out.println("Выберите 2, чтобы удалить таблицу");
        System.out.println("Если вы хотите добавить значение в таблицу, нажмите 3");
        System.out.println("Нажмите 4, чтобы удалить значение в таблице");
        System.out.println("Если вы хотите увидеть все данные в таблице, нажмите 5");
        System.out.println("Нажмите 6, чтобы удалить всю информацию в таблице");
    }
}