package repository;

import db_Util.Database_Util;
import dto.Card;
import enums.CardStatus;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CardRepository {
    public void create(Card card) {
        try {
            Connection con = Database_Util.getConnection();
            String sql = "insert into cards(numbers,exp_date,balance,status,phone,created_date,profile_id) values(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, card.getNumber());
            preparedStatement.setString(2, card.getExp_date());
            preparedStatement.setDouble(3, card.getBalance());
            preparedStatement.setString(4, card.getStatus().name());
            preparedStatement.setString(5, card.getPhone());
            preparedStatement.setTimestamp(6, Timestamp.valueOf(card.getCreated_date()));
            preparedStatement.setInt(7, card.getProfile_id());

            int effectedRows = preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    public List<Card> getAllID(Integer userId) {
        List<Card> dtoList = new LinkedList<>();
        try {
            Connection con = Database_Util.getConnection();
            Statement statement = con.createStatement();
            String sql = "select * from cards where profile_id = "+userId;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Card dto = new Card();
                dto.setId(resultSet.getInt("id"));
                dto.setNumber(resultSet.getString("numbers"));
                dto.setExp_date(resultSet.getString("exp_date"));
                dto.setBalance(resultSet.getDouble("balance"));
                dto.setStatus(CardStatus.valueOf(resultSet.getString("status")));
                dto.setPhone(resultSet.getString("phone"));
                dto.setCreated_date(resultSet.getTimestamp("created_date").toLocalDateTime());
                dto.setProfile_id(resultSet.getInt("profile_id"));
                dtoList.add(dto);
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dtoList;
    }

    public List<Card> getAll() {
        List<Card> dtoList = new LinkedList<>();
        try {
            Connection con = Database_Util.getConnection();
            Statement statement = con.createStatement();
            String sql = "select * from cards";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Card dto = new Card();
                dto.setId(resultSet.getInt("id"));
                dto.setNumber(resultSet.getString("numbers"));
                dto.setExp_date(resultSet.getString("exp_date"));
                dto.setBalance(resultSet.getDouble("balance"));
                dto.setStatus(CardStatus.valueOf(resultSet.getString("status")));
                dto.setPhone(resultSet.getString("phone"));
                dto.setCreated_date(resultSet.getTimestamp("created_date").toLocalDateTime());
                dto.setProfile_id(resultSet.getInt("profile_id"));
                dtoList.add(dto);
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dtoList;
    }

    public boolean cardChangeStatus_ACTIVE(Integer id) {
        try {
            Connection con = Database_Util.getConnection();
            String sql = "update cards set status = ? where id = " + id;

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,CardStatus.ACTIVE.name());

            int effectedRows = preparedStatement.executeUpdate();
            con.close();
            return effectedRows == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean cardChangeStatus_BLOCE(Integer id) {
        try {
            Connection con = Database_Util.getConnection();
            String sql = "update cards set status = ? where id = " + id;

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,CardStatus.BLOCE.name());

            int effectedRows = preparedStatement.executeUpdate();
            con.close();
            return effectedRows == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Card> search(String numbers) {
        List<Card> dtoList = new LinkedList<>();
        try {
            Connection con = Database_Util.getConnection();
            String sql = "select * from cards where lower(numbers) = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,numbers);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Card card = new Card();
                card.setId(resultSet.getInt("id"));
                card.setNumber(resultSet.getString("numbers"));
                card.setExp_date(resultSet.getString("exp_date"));
                card.setBalance(resultSet.getDouble("balance"));
                card.setStatus(CardStatus.valueOf(resultSet.getString("status")));
                card.setPhone(resultSet.getString("phone"));
                card.setCreated_date(resultSet.getTimestamp("created_date").toLocalDateTime());
                dtoList.add(card);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return dtoList;
    }

    public void delete(String numbers) {
        try {
            Connection con = Database_Util.getConnection();
            String sql = "delete from cards where numbers = "+"'"+numbers+"'";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.executeQuery(sql);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
