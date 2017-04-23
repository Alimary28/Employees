package servlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Vaio on 30.03.2017.
 */
public class AccessInfo {

    //List Info = new ArrayList<String>();

    public  List getInfoList(String name) {

        System.out.println("Name: " + name );
        List infoList = new ArrayList<EmployeeBean>();

        try {
            Class.forName("org.postgresql.Driver");


            // 2. define connection params to db
            final String URL = "jdbc:postgresql://54.93.65.5:5432/5alina";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";

            // 3. obtain a connection
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 4. create a query statement


            String query = "SELECT * FROM employees WHERE name = ?";

            // 5. execute a query
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1 ,name );
            ResultSet rs = st.executeQuery();


            // 6. iterate the result set and print the values
            while (rs.next()) {
                int id = rs.getInt("emp_id");
                String n = rs.getString("name");
                String str = rs.getString("city");
                String pos = rs.getString("job");

                EmployeeBean row = new EmployeeBean(id , n , str , pos);
                infoList.add(row);


                // 7. close the objects

            }
            rs.close();
            st.close();
            conn.close();


        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return infoList;
    }



}





