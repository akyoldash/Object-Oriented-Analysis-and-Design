package SogutucuUygulamasi;

import java.util.Scanner;

public class AgArayuzu
{

    private final IEkran ekran;
    private final IEyleyici eyleyici;
    private final ISicaklikAlgilayici sicaklikAlgilayici;


    private static final int SICAKLIK_OKU = 1;
    private static final int SOGUTUCU_AC = 2;
    private static final int SOGUTUCU_KAPA= 3;
    private static final int CIKIS = 4;


    public AgArayuzu()
    {
        ekran = new Ekran();
        eyleyici = new Eyleyici();
        sicaklikAlgilayici = new SicaklikAlgilayici();
    }

    public void start()
    {
        Scanner input=new Scanner(System.in);
        ekran.mesajGoruntule("GIRIS EKRANI");

        boolean authorization;

        do {
            ekran.mesajGoruntule("\nKullanici adi: ");
            IKullaniciVeritabaniPostgreSQL database = new KullaniciVeritabaniPostgreSQL(ekran);
            authorization = database.kullaniciDogrula(input.nextLine());
        }while (!authorization);

        islemSecimi();

    }

    private void islemSecimi(){
        int secim;
        do{
            Araclar.bekle(750);
            secim=anaMenuyuGoster();

            SogutucuCalistirmaFactory sogutucuFactory = new SogutucuCalistirmaFactory(ekran, eyleyici);
            IIslem sogutucuAktivite = null;
            sogutucuAktivite = sogutucuFactory.sogutucuDurumDegistir(secim);

            ekran.ekranTemizle();
            switch (secim) {
                case SICAKLIK_OKU:
                    ISicaklikAlgilayici sicaklik = new SicaklikAlgilayici(ekran, new Publisher());
                    sicaklik.aboneEkle(new Subscriber());
                    sicaklik.sicaklikOku();
                    break;
                case SOGUTUCU_AC:
                    sogutucuAktivite.islemYap();
                    break;

                case SOGUTUCU_KAPA:
                    sogutucuAktivite.islemYap();
                    break;

                case CIKIS:
                    ekran.mesajGoruntule("Çıkılıyor");
                    break;
                default:
                    ekran.mesajGoruntule("1-4 arasında bir sayı girmelisiniz");
            }
        }while(secim!=4);
    }

    private int anaMenuyuGoster()
    {
        ekran.mesajGoruntule("**********************************************");
        ekran.mesajGoruntule("Ana Menu");
        ekran.mesajGoruntule("1-Sıcaklık Oku");
        ekran.mesajGoruntule("2-Soğutucu Aç");
        ekran.mesajGoruntule("3-Soğutucu Kapat");
        ekran.mesajGoruntule("4-Cikis");
        ekran.mesajGoruntule("Seciminiz:");
        ekran.mesajGoruntule("**********************************************");

        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

}
