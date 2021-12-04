/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kasapp.model.DatabaseConfig;
import kasapp.model.Anggota;

/**
 *
 * @author acer
 */
public class kasDAOProses implements KasDAO {

    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;

    @Override
    public List<Anggota> get() {
        List<Anggota> list = new ArrayList<Anggota>();
        try {
            //list=new ArrayList<Mahasiswa>();
            String sql = "Select * from kas_subur";
            connection = DatabaseConfig.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Anggota ang = new Anggota();
                ang.setId(resultSet.getInt("id"));
                ang.setNik(resultSet.getString("nik"));
               ang.setNama(resultSet.getString("nama"));
                ang.setAlamat(resultSet.getString("alamat"));
                ang.setPembayaran(resultSet.getString("pembayaran"));
                list.add(ang);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public boolean save(Anggota anggota) {
        boolean flag = false;
        try {
            String sql = "Insert Into kas_subur (nik,nama,alamat,pembayaran) values (?,?,?,?)";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, anggota.getNik());
            preparedStatement.setString(2, anggota.getNama());
            preparedStatement.setString(3, anggota.getAlamat());
            preparedStatement.setString(4, anggota.getPembayaran());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
        }
        return flag;
    }

    @Override
    public Anggota getSinggle(int id) {
        Anggota ang = null;
        try {
            String sql = "select * from kas_subur where id=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ang = new Anggota();
                ang.setId(resultSet.getInt("id"));
                ang.setNik(resultSet.getString("nik"));
                ang.setNama(resultSet.getString("nama"));
                ang.setPembayaran(resultSet.getString("pembayaran"));
                ang.setAlamat(resultSet.getString("alamat"));
            }
        } catch (SQLException ex) {
        }
        return ang;
    }

    @Override
    public boolean update(Anggota anggota) {
        boolean flag = false;
        try {
            String sql = "update kas_subur set nama=?,nik=?,alamat=?,pembayaran=? where id=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, anggota.getNama());
            preparedStatement.setString(2, anggota.getNik());
            preparedStatement.setString(3, anggota.getAlamat());
            preparedStatement.setString(4, anggota.getPembayaran());
            preparedStatement.setInt(5, anggota.getId());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
        }
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            String sql = "delete from kas_subur where id=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
        }
        return flag;
    }
}
