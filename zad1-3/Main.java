class Item {
  protected String title;
  protected String author;
  protected int year;
  public Item(String title, String author, int year) {
    this.title = title;
    this.author = author;
    this.year = year;
  }
  public void displayInfo() {
  System.out.println("Tytuł: " + title);
  System.out.println("Autor: " + author);
  System.out.println("Rok wydania: " + year);
  }
}

class Book extends Item {
  private int pages;
  public Book(String title, String author, int year, int pages) {
  super(title, author, year);
  this.pages = pages;
  }
  @Override
  public void displayInfo() {
  super.displayInfo();
  System.out.println("Liczba stron: " + pages);
  }
}
class Magazine extends Item {
  private int issue;
  public Magazine(String title, String author, int year, int issue) {
  super(title, author, year);
  this.issue = issue;
  }
  @Override
  public void displayInfo() {
  super.displayInfo();
  System.out.println("Numer wydania: " + issue);
  }
}

class DVD extends Item {
  private int duration;
  public DVD(String title, String author, int year, int duration) {
  super(title, author, year);
  this.duration = duration;
  }
  @Override
  public void displayInfo() {
  super.displayInfo();
  System.out.println("Czas trwania: " + duration + " minut.");
  }
}

public class Main{
  public static void displayLibrary(Item[] items){
    System.out.println("Biblioteka zawiera nastepujace pozycje:");
    for (Item item : items){
      item.displayInfo();
      System.out.println();
    }
  }
  public static void main(String[] args){
    Book book1 = new Book("Agresywne szachy", "Jacob Aagaard", 2011, 224);
    //book1.displayInfo();

    //System.out.println();

    Magazine mag1 = new Magazine("Zycie Podkarpackie", "Artur Wilgucki", 2024, 64);
    //mag1.displayInfo();

    //System.out.println();

    DVD dvd1 = new DVD("Kiler", "Juliusz Machulski", 1997, 124);
    //dvd1.displayInfo();

    Item[] library = {book1, mag1, dvd1};
    displayLibrary(library);
  }
}
