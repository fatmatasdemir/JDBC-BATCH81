package jdbcPractise;

import static jdbcPractise.DatabaseUtilty.*;

public class Ouery06 {
    public static void main(String[] args) {

        createConnection();

        String query="select * from ogrenciler";


        System.out.println( "Sutün isimleri : "+ getColumnNames(query));


        System.out.println("Okul NO : " +   getColumnData (query,"okul_no"));
        System.out.println("Ögrenci Ismi : " +   getColumnData (query,"ogrenci_ismi"));
        System.out.println("Sinif : " +   getColumnData (query,"sinif"));
        System.out.println("Cinsiyet : " +   getColumnData (query,"cinsiyet"));
    }
}
