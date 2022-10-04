package jdbc;

import java.sql.Connection;

public class MainPgadmin4baglanmakicin {
    public static void main(String[] args) {


        //DBWork objesini oluştur.
        DBWorkPOSTgreSQLicin db = new DBWorkPOSTgreSQLicin();
        Connection con = db.connect_to_db("techproed","postgres","yusufmehmet");


        //Yeni table oluşturma methodunu çağır.
        db.createTable(con,"employees");



    }
}
