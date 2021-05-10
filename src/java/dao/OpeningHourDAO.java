/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import entity.OpeningHour;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kynhanht
 */
public class OpeningHourDAO {

    DBConnection dBConnection;

    public OpeningHourDAO() {
        try {
            dBConnection = new DBConnection();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<OpeningHour> getOpeningHour() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<OpeningHour> openingHours = null;
        try {
            con = dBConnection.getConnection();
            String query = "Select* from OpeningHour";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            openingHours = new ArrayList<>();
            while (rs.next()) {
                String day = rs.getString("day");
                String time = rs.getString("time");
                OpeningHour openingHour = new OpeningHour(day, time);
                openingHours.add(openingHour);

            }
        } catch (Exception e) {
            throw e;
        } finally {
            dBConnection.close(con, ps, rs);
        }
        return openingHours;

    }

}
