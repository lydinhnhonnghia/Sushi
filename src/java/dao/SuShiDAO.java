/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import entity.Sushi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kynhanht
 */
public class SuShiDAO {

    DBConnection dBConnection;

    public SuShiDAO() throws Exception {
        try {
            dBConnection = new DBConnection();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Sushi> getAllCake() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Sushi> sushis = null;
        try {
            conn = dBConnection.getConnection();
            String query = "select* from Sushi";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            sushis = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String menuDescription = rs.getString("menuDescription");
                String shortDescription = rs.getString("shortDescription");
                String detailDescription = rs.getString("detailDescription");
                String picture = dBConnection.getImagePath() + rs.getString("picture");
                float price = rs.getFloat("price");
                Date dateCreated = new Date(rs.getDate("dateCreated").getTime());
                Sushi sushi = new Sushi(id, name, menuDescription, shortDescription, detailDescription, picture, price, dateCreated);
                sushis.add(sushi);

            }
        } catch (Exception e) {
            throw e;
        } finally {
            dBConnection.close(conn, ps, rs);
        }
        return sushis;
    }

    public Sushi getSushiById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Sushi sushi = null;
        try {
            conn = dBConnection.getConnection();
            String query = "select* from Sushi where id=?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String menuDescription = rs.getString("menuDescription");
                String shortDescription = rs.getString("shortDescription");
                String detailDescription = rs.getString("detailDescription");
                String picture = dBConnection.getImagePath() + rs.getString("picture");
                float price = rs.getFloat("price");
                Date dateCreated = new Date(rs.getDate("dateCreated").getTime());
                sushi = new Sushi(id, name, menuDescription, shortDescription, detailDescription, picture, price, dateCreated);

            }
        } catch (Exception e) {
            throw e;
        } finally {
            dBConnection.close(conn, ps, rs);
        }
        return sushi;
    }

    public int getTotalSushi() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            String query = "select count(*) from Sushi";
            conn = dBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                rows = rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            dBConnection.close(conn, ps, rs);
        }
        return rows;
    }

    public int getTotalPages() throws Exception {
        if (getTotalSushi() % 3 == 0) {
            return getTotalSushi() / 3;
        }
        return getTotalSushi() / 3 + 1;
    }

    public List<Sushi> getSushiByPage(int page) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Sushi> sushies = null;
        try {
            conn = dBConnection.getConnection();
            String query = "select s.* "
                    + "from (select *,ROW_NUMBER() Over(Order by id) RN  from Sushi ) s "
                    + "where RN between ? and ?";
            int from = (page - 1) * 3 + 1;
            int to = page * 3;
            ps = conn.prepareStatement(query);
            ps.setInt(1, from);
            ps.setInt(2, to);
            rs = ps.executeQuery();
            sushies = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String menuDescription = rs.getString("menuDescription");
                String shortDescription = rs.getString("shortDescription");
                String detailDescription = rs.getString("detailDescription");
                String picture = dBConnection.getImagePath() + rs.getString("picture");
                float price = rs.getFloat("price");
                Date dateCreated = new Date(rs.getDate("dateCreated").getTime());
                Sushi sushi = new Sushi(id, name, menuDescription, shortDescription, detailDescription, picture, price, dateCreated);
                sushies.add(sushi);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            dBConnection.close(conn, ps, rs);
        }
        return sushies;
    }

}
