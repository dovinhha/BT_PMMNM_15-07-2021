/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt_pmmnm;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author X509
 */
public class ConnectDatabase {
    private static Connection con = null;
    private final String user = "sa";
    private final String password = "123456";
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=PMMNM1";

    public ConnectDatabase() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connecting success");
        } catch (SQLException e) {
            System.out.println("Connect Error: " + e.getMessage());
        }
    }
    
    public void insertProductType(String typeNameProduct) {
        String query = "insert into LoaiSanPham values(?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,typeNameProduct);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("insertProductType Error: " + e.getMessage());
        }
    }
    
    public String getNameProduct(int id){
        String result = null;
        String query = "select * from LoaiSanPham where MaLoaiSP = " + id;
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                result = resultSet.getString("TenLoaiSP");
                break;
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("getNameProduct Error: " + e.getMessage());
        }
        return result;
    }
    
    public List<SanPham> products() {
        
        List<SanPham> products = new ArrayList<>();
        String query = "select * from SanPham";
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int MaSP = resultSet.getInt("MaSP");
                String TenSanPham = resultSet.getString("TenSP");
                String NhaSanXuat = resultSet.getString("NhaSanXuat");
                int MaLoaiSP = resultSet.getInt("MaLoaiSP");
                products.add(new SanPham(MaSP, TenSanPham, NhaSanXuat, getNameProduct(MaLoaiSP)));
            }
        } catch (SQLException e) {
            System.out.println("products Error: " + e.getMessage());
        }
        return products;
    }
    
    public List<LoaiSanPham> listProductType() {
        List<LoaiSanPham> listProductType = new ArrayList<>();
        String query = "select * from LoaiSanPham";
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int MaLoaiSP = resultSet.getInt("MaLoaiSP");
                String TenLoaiSP = resultSet.getString("TenLoaiSP");
                listProductType.add(new LoaiSanPham(MaLoaiSP, TenLoaiSP));
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("listProductType Error: " + e.getMessage());
        }
        return listProductType;
    }
    
}
