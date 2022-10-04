package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    /*Statement:Statik bir SQL ifadesi yürütmek ve
    ürettiği sonuçları döndürmek için kullanılan nesne.
     Varsayılan olarak, aynı anda Statement nesnesi başına yalnızca bir ResultSet
      nesnesi açılabilir. Bu nedenle, bir ResultSet nesnesinin okuması diğerinin
      okumasıyla aralanmışsa, her biri farklı Statement nesneleri
       tarafından oluşturulmuş olmalıdır. Açık bir varsa, Statement arabirimindeki tüm yürütme yöntemleri,
    ifadenin geçerli bir ResultSet nesnesini örtük olarak kapatır.



     */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {




            //1. Adım: Driver'a kaydol
            Class.forName("org.postgresql.Driver");

            //2. Adım: Database'e bağlan
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","yusufmehmet");

            //3. Adım: Statement oluştur.
            Statement st = con.createStatement();

            //4. Adım: Query çalıştır.

            //1.Örnek: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin.
            String sql1 = "CREATE TABLE workers(worker_id VARCHAR(50), worker_name VARCHAR(50), worker_salary INT)";
            boolean result = st.execute(sql1);
           // System.out.println(result);//False return yapar, çünkü data çağrılmadı.



        //2.Örnek: Table'a worker_address sütunu ekleyerek alter (degisim) yapın.

        String sql2="ALTER TABLE  workers ADD  worker_address  VARCHAR(80)";
        st.execute(sql2);


        /*  //3.Example: Drop workers table  // BUNUNLA TABLOYU SILDIK
        String sql3="DROP TABLE workers";
       st.execute(sql3);  // bu satiri yorum icine alirsak postSQL workers tablomuz olusur
*/

        // 5.Adim : Baglanti ve Statement'i kapat
       con.close();
      st.close();


   // HATA ALIYORSAM GIT SQL WORKERS TABLSOU EKLE OYLE CALISTIR




    }






}
