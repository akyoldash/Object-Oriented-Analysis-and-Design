package SogutucuUygulamasi;

public class SicaklikGoruntule implements IIslem{
    @Override
    public void islemYap() {
        System.out.println("Sıcaklık ölçülüyor");
        Araclar.bekle(750 );
        System.out.print("Sıcaklık:");
    }
}
