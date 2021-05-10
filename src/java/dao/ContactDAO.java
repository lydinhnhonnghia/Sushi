/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import entity.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author kynhanht
 */
public class ContactDAO {

    DBConnection dBConnection;

    public ContactDAO() throws Exception {
        try {
            dBConnection = new DBConnection();
        } catch (Exception e) {
            throw e;
        }
    }

    public Contact getContact() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Contact contact = null;
        try {
            con = dBConnection.getConnection();
            String query = "Select* from Contact";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String introPicture = dBConnection.getImagePath() + rs.getString("introPicture");
                String mapPicture = dBConnection.getImagePath() + rs.getString("mapPicture");
                contact = new Contact(address, phone, email, introPicture, mapPicture);

            }
        } catch (Exception e) {
            throw e;
        } finally {
            dBConnection.close(con, ps, rs);
        }
        return contact;

    }

}
