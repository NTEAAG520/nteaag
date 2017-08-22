package bean;


import annotation.Table;

/**
 * Created by Administrator on 2017/7/7.
 */
@Table(tableName = "t_user")
public class User {
    private int id;
    private String userName;
    private String name;
    private String password;
    private String gender;

    public User() {
    }

    public User(int id, String userName, String name, String password, String gender) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.password = password;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

