package SogutucuUygulamasi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class KullaniciVeritabaniPostgreSQL implements IKullaniciVeritabaniPostgreSQL{

    private IEkran ekran;

    public KullaniciVeritabaniPostgreSQL(IEkran ekran){
        this.ekran = ekran;
    }

    private Connection connect(){

        Connection conn=null;
        try {


            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/KullaniciVeritabani",
                    "postgres", "km810AAcs12!435");

            if (conn != null)
                ekran.mesajGoruntule("Veritabanına bağlandı.");


        } catch (Exception e) {
            ekran.mesajGoruntule("Bağlantı girişimi başarısız!");
            e.printStackTrace();
        }
        return conn;
    }

    public boolean kullaniciDogrula(String username){

        ekran.mesajGoruntule("Veritabanina baglaniyor...");
        Araclar.bekle(750);
        Connection conn=this.connect();

        try
        {
            //

            String sql= "SELECT \"kullaniciAdi\", \"sifre\" FROM \"Kullanici\" WHERE \"kullaniciAdi\"= '" + username + "'" ;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //***** Bağlantı sonlandırma *****
            conn.close();
            int id;
            String kullaniciAdi;
            String sifre;

            while(rs.next())
            {
                kullaniciAdi = rs.getString("kullaniciAdi");
                sifre = rs.getString("sifre");

                if (kullaniciAdi.equals(username)){
                    Scanner input=new Scanner(System.in);
                    ekran.mesajGoruntule("Kullanici adi doğrulandı.\nŞifre:");
                    if (sifre.equals(input.nextLine())){

                        ekran.mesajGoruntule("Şifre doğrulandı. Uygulamaya giriş yapabilirsiniz.");
                        return true;
                    }
                    else
                    {
                        ekran.mesajGoruntule("Şifre hatalı. Lütfen tekrar deneyiniz");
                        return false;
                    }


                }
            }

            rs.close();
            stmt.close();

            ekran.mesajGoruntule("Kullanıcı adı doğrulanamadı lütfen tekrar deneyiniz");
            return false;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
