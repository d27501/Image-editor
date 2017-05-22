/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Client.Picture;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dominiq
 */
public class Database {
    
    private String url, user, password;
    
    public Database(String url, String user, String password) throws ClassNotFoundException{
         Class.forName("org.postgresql.Driver");
         this.url = url;
         this.user = user;
         this.password = password;
    }

    void createDB() {
 
        try (Connection conn = DriverManager.getConnection(this.url, this.user, this.password)) {            
            if (conn != null) {
                System.out.println("Stworzono baze danych.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    void createTables(){
        
        String sql = "CREATE TABLE IF NOT EXISTS original_images (\n"
                + "	id serial PRIMARY KEY,\n"
                + "     time timestamp(8) not null,\n"
                + "	image bytea NOT NULL\n"             
                + ");";
        
        String sql2 = "CREATE TABLE IF NOT EXISTS modified_images (\n"
                + "	id integer not null,\n"
                + "	mod_type integer not null,\n"               
                + "     time timestamp(8) not null,\n"
                + "	mod_image bytea not null\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(this.url, this.user, this.password);
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            stmt.execute(sql2);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    int insertOriginalPicture(Client.Picture tmp) {
        
        String sql = "INSERT INTO original_images(image, time) VALUES(?, ?);";
        int id = -1;
        //select now()::TIMESTAMP
        
        try (Connection conn = DriverManager.getConnection(this.url, this.user, this.password); 
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            pstmt.setBytes(1, tmp.tab);
            pstmt.setTimestamp(2, new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
            pstmt.executeUpdate();
            
            sql = "SELECT max(id) from original_images;";
            
            //pstmt = conn.prepareStatement(sql);
        
            try(Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(sql)){
                             
                 while (rs.next()) {
                    id = rs.getInt(1);
                }
            }
      
        } catch(SQLException e){
                System.out.println("Blad bazy");
        }
        
        return id;
            
    }
    
    
    void insertModifiedPicture(Client.Picture tmp) {
        
        String sql = "INSERT INTO modified_images(id, mod_type, time, mod_image) VALUES(?, ?, ?, ?);";
        //select now()::TIMESTAMP
        
        try (Connection conn = DriverManager.getConnection(this.url, this.user, this.password); 
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            pstmt.setInt(1, tmp.id);
            pstmt.setInt(2, tmp.mod_type);
            Timestamp ts = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
            pstmt.setTimestamp(3, ts);
            pstmt.setBytes(4, tmp.tab);
            pstmt.executeUpdate();
                      
            DateFormat df = new SimpleDateFormat("yyyy/dd/MM HH:mm:ss");
            tmp.date = df.format(ts);

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Picture getPicture(Picture p){
        
        Picture result = null;
        String sql = "SELECT mod_image, time from modified_images WHERE id =" + Integer.toString(p.id)
                + " and mod_type = " + Integer.toString(p.mod_type);
        //select now()::TIMESTAMP
        
        
        try (Connection conn = DriverManager.getConnection(this.url, this.user, this.password); 
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
 
            
            while (rs.next()) {
                    byte[] tmp = rs.getBytes(1);
                    DateFormat df = new SimpleDateFormat("yyyy/dd/MM HH:mm:ss");
                    String d = df.format(rs.getTimestamp(2));
                    result = new Picture(tmp, p.id, p.mod_type, d);
                    
                    return result;                  
            } 
    
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    /*
    public static void main(String []args){
        
        try {
            Database d = new Database("jdbc:postgresql://localhost/postgres", "postgres", "admin");
            d.createDB();
            d.createTables();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

}       