
package tictactoe_2;

import java.sql.*;

public class saveDB{
    private Connection con;
   
    private String query = "select * from scores";
public saveDB(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoedb","root","");
    }
    catch(Exception ex){
        System.out.println("error3" + ex);
    }
}
    
    public void getData(){
        try{
            Statement st;
            ResultSet rs;
            st =con.createStatement();
            rs=st.executeQuery(query);
            while(rs.next()){
                String name =rs.getString(1);
                System.out.println("query received");
                String score =rs.getString("Score");
                System.out.println(name+score);
            }
            
        }
        catch(Exception ex){
            System.out.println("Error   "+ex);
        
    }
}
    public void saveData(String name,int score){
        try{
            
            Statement wst;
            ResultSet wrs;
            wst = con.createStatement();
            PreparedStatement ps =con.prepareStatement("insert into scores values(?,?,DEFAULT)");
            ps.setString(1, name);
            ps.setInt(2, score);
            ps.executeUpdate();
        }
        catch(Exception ex2){
            System.out.println("Error2"+ex2);
        }
    }
}
