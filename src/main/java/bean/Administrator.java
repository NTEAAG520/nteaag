package bean;


import annotation.Column;
import annotation.Table;

@Table(tableName = "t_administrator")
public class Administrator {
    //属性
    @Column(type = "varchar(30)" ,field = "id" ,primaryKey = true ,defaultNull = false)
    private String id;    //主键，采用UUID
    @Column(type = "VARCHAR(20)", field = "username")
    private String username;  //用户名
    @Column(type = "VARCHAR(20)", field = "password")
    private String password;  //密码
    @Column(type = "VARCHAR(60)", field = "headerPic")
    private String headerPic; //头像
    @Column(type = "VARCHAR(60)", field = "email")
    private String email;     //电子邮箱
    @Column(type = "VARCHAR(2)", field = "sex")
    private Integer male;     //性别 0男 1女 3保密
    @Column(type = "datetime", field = "create_time")
    private String createTime;//创建时间
    @Column(type = "timestamp", field = "update_time")
    private String updateTime;//最后更新时间
    @Column(type = "int(1)", field = "is_delete")
    private Integer isDelete; // 删除状态  0未删除  1删除
    @Column(type = "VARCHAR(200)", field = "address")
    private String address;   //地址
    @Column(type = "VARCHAR(15)", field = "telephone")
    private String telephone; //电话

    public Administrator() {
    }

    public Administrator(String id, String username, String password, String headerPic, String email, Integer male, String createTime, String updateTime, Integer isDelete, String address, String telephone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.headerPic = headerPic;
        this.email = email;
        this.male = male;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.address = address;
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeaderPic() {
        return headerPic;
    }

    public void setHeaderPic(String headerPic) {
        this.headerPic = headerPic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMale() {
        return male;
    }

    public void setMale(Integer male) {
        this.male = male;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", headerPic='" + headerPic + '\'' +
                ", email='" + email + '\'' +
                ", male=" + male +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", isDelete=" + isDelete +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
