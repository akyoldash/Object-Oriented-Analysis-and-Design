package SogutucuUygulamasi;

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici{

    private int sicaklik;
    private Random random=new Random();
    private IIslem islem;
    private IEkran ekran;
    private ISubject publisher;

    public SicaklikAlgilayici() {

    }
    public SicaklikAlgilayici(IEkran ekran, ISubject publisher){
        this.ekran = ekran;
        this.publisher = publisher;
        islem = new SicaklikGoruntule();
    }

    @Override
    public void aboneEkle(IObserver abone){
        publisher.attach(abone);
    }

    @Override
    public void sicaklikOku() {
        sicaklik=Math.abs(random.nextInt()%100);


        islem.islemYap();
        ekran.mesajGoruntule("" + sicaklik);

        Araclar.bekle(500);
        if (sicaklik > 40){
            publisher.notify("Uyarı! Sicaklik 40 derecenin üzerine çıktı. Sogutucuyu açmanız tavsiye edilir");
        }
        if (sicaklik < 5){
            publisher.notify("Uyarı! Sicaklik 5 derecenin altına indi. Eger sogutucu açıksa, kapatmanız tavsiye edilir");
        }

    }
}
