package com.example.duan_n7_cp17303.DAO;

import android.util.Log;

import com.example.duan_n7_cp17303.DTO.Sanpham;
import com.example.duan_n7_cp17303.DTO.Thongbao;
import com.example.duan_n7_cp17303.Sqlserver.DbSqlServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Daosanpham {

    Connection connection;
    public Daosanpham(){
        DbSqlServer db = new DbSqlServer();
        connection = db.openConnect();
    }

    public List<Sanpham> getAll(){
        List<Sanpham> sanphamList = new ArrayList<>();

        try{
            if (this.connection != null){
                String sqlSanPham = "select * from sanpham";
                Statement statement = this.connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlSanPham);
                while (resultSet.next()){
                    Sanpham sp = new Sanpham();
                    sp.setId_sp(resultSet.getInt("id_sp"));
                    sp.setId_loai(resultSet.getInt("id_loai"));
                    sp.setTensp(resultSet.getString("tensp"));
                    sp.setGiatien(resultSet.getString("giatien"));
                    sp.setSoluong(resultSet.getInt("soluong"));
                    sp.setAnh(resultSet.getString("anh"));
                    sanphamList.add(sp);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.e("zzzzz","getAllQuan co loi");
        }
        return sanphamList;
    }

    public List<Sanpham> getAllQuan(){
        List<Sanpham> sanphamList = new ArrayList<>();

        try{
            if (this.connection != null){
                String sqlSanPham = "select * from sanpham where id_loai = '1'";
                Statement statement = this.connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlSanPham);
                while (resultSet.next()){
                    Sanpham sp = new Sanpham();
                    sp.setId_sp(resultSet.getInt("id_sp"));
                    sp.setId_loai(resultSet.getInt("id_loai"));
                    sp.setTensp(resultSet.getString("tensp"));
                    sp.setGiatien(resultSet.getString("giatien"));
                    sp.setSoluong(resultSet.getInt("soluong"));
                    sp.setAnh(resultSet.getString("anh"));
                    sanphamList.add(sp);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.e("zzzzz","getAllQuan co loi");
        }
        return sanphamList;
    }
    public List<Sanpham> getAllAo(){
        List<Sanpham> sanphamList = new ArrayList<>();

        try{
            if (this.connection != null){
                String sqlSanPham = "select * from sanpham where id_loai = '2'";
                Statement statement = this.connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlSanPham);
                while (resultSet.next()){
                    Sanpham sp = new Sanpham();
                    sp.setId_sp(resultSet.getInt("id_sp"));
                    sp.setId_loai(resultSet.getInt("id_loai"));
                    sp.setTensp(resultSet.getString("tensp"));
                    sp.setGiatien(resultSet.getString("giatien"));
                    sp.setSoluong(resultSet.getInt("soluong"));
                    sp.setAnh(resultSet.getString("anh"));
                    sanphamList.add(sp);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.e("zzzzz","getAllAo co loi");
        }
        return sanphamList;
    }
    public List<Sanpham> getAllKhac(){
        List<Sanpham> sanphamList = new ArrayList<>();

        try{
            if (this.connection != null){
                String sqlSanPham = "select * from sanpham where id_loai = '3'";
                Statement statement = this.connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sqlSanPham);
                while (resultSet.next()){
                    Sanpham sp = new Sanpham();
                    sp.setId_sp(resultSet.getInt("id_sp"));
                    sp.setId_loai(resultSet.getInt("id_loai"));
                    sp.setTensp(resultSet.getString("tensp"));
                    sp.setGiatien(resultSet.getString("giatien"));
                    sp.setSoluong(resultSet.getInt("soluong"));
                    sp.setAnh(resultSet.getString("anh"));
                    sanphamList.add(sp);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.e("zzzzz","getAllKhac co loi");
        }
        return sanphamList;
    }
    public void insertSP(Sanpham sp){
        try{
            if (this.connection != null){
                String insertSP = "insert into sanpham(tensp,id_loai,giatien,soluong,anh) values (N'" + sp.getTensp() +"'," +sp.getId_loai() + ",'"+ sp.getGiatien() + "','"+sp.getSoluong() + "','"+ sp.getAnh() +"')";

                String generatedColumns[] = {"id_sp"};

                PreparedStatement statement = this.connection.prepareStatement(insertSP,generatedColumns);
                statement.execute();
                Log.e("zzzzz","insert : finish insert");

                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()){
                    long id = rs.getLong(1);
                    Log.e("zzzz","insert : id = "+ id);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.e("zzzz","insert : co loi them du lieu");
        }
    }
    public void updateSP(Sanpham sp){
        try {
            if (this.connection != null){
                String sqlUpdate = "UPDATE sanpham SET tensp = N'" + sp.getTensp() + "',id_loai = "+sp.getId_loai()+",giatien = '"
                        +sp.getGiatien() + "',soluong = " +sp.getSoluong() + ",anh = '" + sp.getAnh() + "' WHERE id_sp = " + sp.getId_sp();

                PreparedStatement statement = this.connection.prepareStatement(sqlUpdate);
                statement.execute();
                Log.e("zzzzz","insertSP : thanh cong");
            }
        }catch (Exception e){
            Log.e("zzzz","updateSP : co loi sua du lieu");
            e.printStackTrace();

        }
    }
    public Sanpham get_SP_theo_ID(int id) throws SQLException {

        List<Sanpham> list_sp = new ArrayList<>();

        try {
            if (this.connection != null){
                String sql = "SELECT * FROM sanpham WHERE id_sp = " + id;

                Statement statement = this.connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()){

                    Sanpham sp = new Sanpham();
                    sp.setId_sp(resultSet.getInt("id_sp"));
                    sp.setId_loai(resultSet.getInt("id_loai"));
                    sp.setTensp(resultSet.getString("tensp"));
                    sp.setGiatien(resultSet.getString("giatien"));
                    sp.setSoluong(resultSet.getInt("soluong"));
                    sp.setAnh(resultSet.getString("anh"));

                    list_sp.add(sp);
                }

            }
        } catch (SQLException throwables) {
            Log.d("TAG", "getThongBao: lỗi truy vấn");
            throwables.printStackTrace();

        }

        return list_sp.get(0);
    }

}
