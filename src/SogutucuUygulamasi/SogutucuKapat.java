package SogutucuUygulamasi;

public class SogutucuKapat implements IIslem{

    private IEkran ekran;
    private IEyleyici eyleyici;

    public SogutucuKapat(IEkran ekran, IEyleyici eyleyici) {
        this.eyleyici = eyleyici;
        this.ekran = ekran;
    }
    @Override
    public void islemYap(){
        eyleyici.sogutucuKapat();
        ekran.mesajGoruntule("Sogutucu kapatılıyor...");
        Araclar.bekle(750);
        ekran.mesajGoruntule("Soğutucu kapatıldı");
    }
}







