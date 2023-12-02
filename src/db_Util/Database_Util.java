package db_Util;

import dto.Profile;
import enums.ProfilStatus;
import repository.ProfileRepasitory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class Database_Util {
    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "jdbs_user", "123456"); // <2>
            return con;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTable() {
        try {
            Connection con = Database_Util.getConnection();
            Statement statement = con.createStatement();
            String sql = "   create table if not exists profile(" +
                    "        id serial  primary key," +
                    "        name varchar(25) not null," +
                    "        surname varchar(25) not null," +
                    "         phone varchar(20) UNIQUE," +
                    "        password varchar(25) not null," +
                    "        created_date timestamp," +
                    "        status varchar(25)," +
                    "        role varchar(25)" +
                    "      );";
            statement.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTableCards() {
        try {
            Connection con = Database_Util.getConnection();
            Statement statement = con.createStatement();
            String sql = "   create table if not exists cards(" +
                    "        id serial  primary key," +
                    "        numbers varchar(25) not null," +
                    "        exp_date varchar(25) not null," +
                    "        balance DOUBLE PRECISION," +
                    "        status varchar(25)," +
                    "        phone varchar(20) ," +
                    "        created_date timestamp," +
                    "        profile_id int," +
                    "        foreign key(profile_id)" +
                    " REFERENCES profile(id) " +
                    "      );";
            statement.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   /** public void createAdmin() {
        Profile profileAdmin = new Profile();
        profileAdmin.setName("Murod");
        profileAdmin.setSurname("Dadaboev");
        profileAdmin.setPhone("901584040");
        profileAdmin.setPassword("1111");
        profileAdmin.setCreated_date(LocalDateTime.now());
        profileAdmin.setStatus(ProfilStatus.ACTIVE);
        profileAdmin.setRole(ProfilStatus.ADMIN);

        ProfileRepasitory profileRepasitory = new ProfileRepasitory();
        profileRepasitory.create(profileAdmin);
    }*/


}
