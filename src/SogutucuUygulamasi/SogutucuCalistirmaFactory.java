package SogutucuUygulamasi;

public class SogutucuCalistirmaFactory {


    private IEkran ekran;
    private IEyleyici eyleyici;

    public SogutucuCalistirmaFactory(IEkran ekran, IEyleyici eyleyici){
        this.eyleyici = eyleyici;
        this.ekran = ekran;
    }

    public IIslem sogutucuDurumDegistir(int secim){

        IIslem sogutucuDurum = null;

        if (secim == 2){
            return new SogutucuAc(ekran, eyleyici);

        }
        if (secim == 3){
            return new SogutucuKapat(ekran, eyleyici);
        } else return null;

    }


}
