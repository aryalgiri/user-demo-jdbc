package com.vastika.dao;

import com.vastika.model.User;
import com.vastika.util.DBUtil;
import com.vastika.util.QueryUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public int saveUserInfo(User user) {
        int saved=0;
        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_SQL)
        ) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setLong(3, user.getMobileNo());
            ps.setString(4, user.getAddress());

            saved=ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return saved;
    }

    @Override
    public int updateUserInfo(User user) {
        int updated=0;
        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(QueryUtil.UPDATE_SQL)
        ) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setLong(3, user.getMobileNo());
            ps.setString(4, user.getAddress());
            ps.setInt(5,user.getId());

            updated=ps.executeUpdate();


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    @Override
    public void deleteUserInfo(int id) {
        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(QueryUtil.DELETE_SQL)
        ) {
           ps.setInt(1,id);
           ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id) {
        User user=new User();
        try(
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(QueryUtil.GET_BY_ID_SQL)
        ) {

            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword((rs.getString("password")));
                user.setMobileNo(rs.getLong("mobile_no"));
                user.setAddress(rs.getString("address"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

    @Override
    public List<User> getAllUserInfo() {
        List<User> userList=new ArrayList<>();
        try(
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(QueryUtil.LIST_SQL)
        ) {
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword((rs.getString("password")));
                user.setMobileNo(rs.getLong("mobile_no"));
                user.setAddress(rs.getString("address"));
                userList.add(user);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
