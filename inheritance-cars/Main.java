abstract class Pojazd {
  protected int cena;
  protected String marka;
  protected String kolor;
  protected double dzienna_stawka;
  public Pojazd(String marka, int cena){
    this.marka = marka;
    this.cena = cena;
  }
  public abstract double obliczKosztWypozyczenia();
  public void wyswietlInformacje(){
    System.out.println("Marka: " + marka);
    System.out.println("Cena sprzedazy: "+cena+" zl");
  }
}
class Samochod extends Pojazd {
  private int miejsca_siedzace;
  public Samochod(String marka, int cena, int miejsca_siedzace){
    super(marka, cena);
    this.miejsca_siedzace = miejsca_siedzace;
  }
  @Override
  public double obliczKosztWypozyczenia() {
    return dzienna_stawka+(miejsca_siedzace*100);
  }
  @Override
  public void wyswietlInformacje() {
    super.wyswietlInformacje();
    System.out.println("Miejsca siedzace: "+miejsca_siedzace);
  }
}

class Motocykl extends Pojazd {
  private int kilowat_mocy;
  public Motocykl(String marka, int cena, int kilowat_mocy){
    super(marka, cena);
    this.kilowat_mocy = kilowat_mocy;
  }
  @Override
  public double obliczKosztWypozyczenia() {
    return dzienna_stawka+(kilowat_mocy*5);
  }
  @Override
  public void wyswietlInformacje() {
    super.wyswietlInformacje();
    System.out.println("Kilwatty mocy: "+kilowat_mocy);
  }
}

public class Main {
    public static void main(String[] args) {
        Samochod car = new Samochod("Toyota", 50000, 5);
        car.dzienna_stawka = 200;
        car.wyswietlInformacje();
        System.out.println("Koszt wypożyczenia: " + car.obliczKosztWypozyczenia() + " zl\n");

        Motocykl bike = new Motocykl("Yamaha", 15000, 100);
        bike.dzienna_stawka = 150;
        bike.wyswietlInformacje();
        System.out.println("Koszt wypożyczenia: " + bike.obliczKosztWypozyczenia() + " zł");
    }
}
