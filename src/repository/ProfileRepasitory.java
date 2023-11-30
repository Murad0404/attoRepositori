package repository;

import db_Util.Database_Util;
import dto.Profile;
import enums.ProfilStatus;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProfileRepasitory {
    public void create(Profile profile) {
        try {
            Connection con = Database_Util.getConnection();
            String sql = "insert into profile(name,surname,phone,password,created_date,status,role) values(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, profile.getName());
            preparedStatement.setString(2, profile.getSurname());
            preparedStatement.setString(3, profile.getPhone());
            preparedStatement.setString(4, profile.getPassword());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(profile.getCreated_date()));
            preparedStatement.setString(6, profile.getStatus().name());
            preparedStatement.setString(7, profile.getRole().name());

            int effectedRows = preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }
    public List<Profile> search(String phone) {
        List<Profile> dtoList = new LinkedList<>();
        try {
            Connection con = Database_Util.getConnection();
            String sql = "select * from profile where lower(phone) like ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,"%"+phone+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Profile dto = new Profile();
                dto.setId(resultSet.getInt("id"));
                dto.setName(resultSet.getString("name"));
                dto.setSurname(resultSet.getString("surname"));
                dto.setPhone(resultSet.getString("phone"));
                dto.setPassword(resultSet.getString("password"));
                dto.setCreated_date(resultSet.getTimestamp("created_date").toLocalDateTime());
                dto.setStatus(ProfilStatus.valueOf(resultSet.getString("status")));
                dto.setRole(ProfilStatus.valueOf(resultSet.getString("role")));

                dtoList.add(dto);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return dtoList;
    }

    public boolean loginUpdateStatusACTIVE(Integer id) {
        try {
            Connection con = Database_Util.getConnection();
            String sql = "update profile set status = ? where id = " + id;

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, ProfilStatus.ACTIVE.name());

            int effectedRows = preparedStatement.executeUpdate();
            con.close();
            return effectedRows == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean loginUpdateStatusNOT_AKTIVE(Integer id) {
        try {
            Connection con = Database_Util.getConnection();
            String sql = "update profile set status = ? where id = " + id;

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, ProfilStatus.NOT_ACTIVE.name());

            int effectedRows = preparedStatement.executeUpdate();
            con.close();
            return effectedRows == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
