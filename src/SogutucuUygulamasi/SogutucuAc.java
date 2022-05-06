package SogutucuUygulamasi;

public class SogutucuAc implements IIslem{

    private IEkran ekran;
    private IEyleyici eyleyici;

    public SogutucuAc(IEkran ekran, IEyleyici eyleyici) {
        this.eyleyici = eyleyici;
        this.ekran = ekran;
    }

    @Override
    public void islemYap(){

        eyleyici.sogutucuAc();
        ekran.mesajGoruntule("Açılış testi yapılıyor...");
        Araclar.bekle(750);
        ekran.mesajGoruntule("Soğutucu açıldı");
    }
}



