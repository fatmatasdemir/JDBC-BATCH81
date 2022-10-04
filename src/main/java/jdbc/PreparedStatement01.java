package jdbc;

import java.sql.*;

public class PreparedStatement01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

    Class.forName("org.postgresql.Driver");
    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "yusufmehmet");
    Statement st = con.createStatement();


        //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.

        //1. Adım:  Prepared statement query'sini oluştur.
        String sql1 = "UPDATE companies SET number_of_employees = ? WHERE company = ?";

        //2. Adım: PreparedStatement objesini oluştur.
        PreparedStatement pst1 = con.prepareStatement(sql1);

        //3. Adım: set...() methodları ile soru işaretleri için değer gir.
        pst1.setInt(1,9999);
        pst1.setString(2,"IBM");

        //4. Adım: Execute query
        int updateRowSayisi = pst1.executeUpdate();
        System.out.println(updateRowSayisi+" satır güncellendi.");

        String sql2 = "SELECT * FROM companies";
        ResultSet result2 =  st.executeQuery(sql2);

        while (result2.next()){

            System.out.println(result2.getInt(1)+"--"+result2.getString(2)+"--"+result2.getInt(3));
        }


        //Google için değişiklik
        pst1.setInt(1,15000);
        pst1.setString(2,"GOOGLE");

        int updateRowSayisi2 = pst1.executeUpdate();
        System.out.println(updateRowSayisi2+" satır güncellendi.");

        String sql3 = "SELECT * FROM companies";
        ResultSet result3 =  st.executeQuery(sql3);

        while (result3.next()){

            System.out.println(result3.getInt(1)+"--"+result3.getString(2)+"--"+result3.getInt(3));
        }

        System.out.println("=========================");

        read_data(con," companies");// asagiya bagli en son bunu yazdik run yaptik

    }

      //2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.
     // Bir tablonun istenilen datasini prepared statement ile cagirmak  icin kullanilan method
       public static void  read_data(Connection con,String tableName){

        try {

            String query = String.format("SELECT * FROM %s", tableName);//Format() methodu dinamik String olusturmak icin kullanilir

            Statement statement=con.createStatement();
            //SQL query'i calistir.
            ResultSet rs=statement.executeQuery(query); //Datayi cagirip ResulSet konteynirina koyuyoruz

            while (rs.next()){ // Tüm datayi cagiralim

                System.out.println(rs.getString(1)+"-"+rs.getString(2)+"-"+rs.getInt(3));


            }



        }catch (Exception e){

            System.out.println(e);

            /*
 103-APPLE-21000
102-MICROSOFT-16000
100-IBM-9999
101-GOOGLE-15000


             */
        }
       }


}




















/*
1 sat?r g�ncellendi.
103--APPLE--21000
102--MICROSOFT--16000
101--GOOGLE--15000
100--IBM--9999
1 sat?r g�ncellendi.
103--APPLE--21000
102--MICROSOFT--16000
100--IBM--9999
101--GOOGLE--15000






 */













