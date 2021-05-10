/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import entity.Share;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kynhanht
 */
public class ShareDAO {

    DBConnection dBConnection;

    public ShareDAO() throws Exception {
        try {
            dBConnection = new DBConnection();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Share> getShares() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Share> shares = null;
        try {
            con = dBConnection.getConnection();
            String query = "Select* from Share";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            shares = new ArrayList();
            while (rs.next()) {
                String icon = dBConnection.getImagePath() + rs.getString("icon");
                String socialNetwork = rs.getString("socialNetwork");
                String url = rs.getString("url");
                Share share = new Share(icon, socialNetwork, url);
                shares.add(share);

            }
        } catch (Exception e) {
            throw e;
        } finally {
            dBConnection.close(con, ps, rs);
        }
        return shares;

    }

}
