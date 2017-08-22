package dao;


import bean.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Employee的数据操作对象，负责Employee的增删改查
 */
public class EmployeeDAO {
    /**
     * 查询所有员工信息
     * @return list
     * @throws SQLException
     */
    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<Employee>();
        Connection connection = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM emp");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("salary"),
                        resultSet.getInt("age"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection);
        }
        return employees;
    }

    /**
     * 删除员工信息
     * @param id 所删除用户的ID
     * @return 删除成功 返回true,否则false
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean delete(int id) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM emp WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }finally {
            DBUtil.close(connection);
        }
        return true;
    }

    /**
     * 新增员工信息
     * @param employee 要增加的员工
     * @return 增加成功 返回true,否则false
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean save(Employee employee) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO emp VALUES (?,?,?,?)");
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2,employee.getName());
            preparedStatement.setDouble(3, employee.getSalary());
            preparedStatement.setInt(4, employee.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }finally {
            DBUtil.close(connection);
        }
        return true;
    }

    /**
     * 根据id查询员工信息
     * @param id 用户的ID
     * @return 所在id的员工
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Employee findById(int id) throws ClassNotFoundException, SQLException {
        Employee employee=null;
        Connection connection = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM emp WHERE id=?");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("salary"),
                        resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }finally {
            DBUtil.close(connection);
        }
        return employee;
    }

    public boolean modify(Employee employee) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE emp SET name=?,salary=?,age=? WHERE id=?");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDouble(2, employee.getSalary());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setInt(4, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }finally {
            DBUtil.close(connection);
        }
        return true;
    }

}
