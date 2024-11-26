class Worker{
  String name;
  int age;
  Worker(String name, int age){
    this.name = name;
    this.age = age;
  }
  void displayInfo(){
    System.out.println("Imie: "+name+", Wiek: "+age);
  }
  void work(){
    System.out.println(name+" pracuje.");
  }
}

class ConstructionWorker extends Worker{
  String specialty;
  int experience;
  ConstructionWorker(String name, int age, String specialty, int experience){
    super(name, age);
    this.specialty = specialty;
    this.experience = experience;
  }

  @Override
  void displayInfo(){
    super.displayInfo();
    System.out.println("Specjalizacja: "+specialty+", Doswiadczenie: "+experience+" lat.");
  }

  void build(){
    System.out.println(name+" buduje");
  }
}

class TraineeWorker extends Worker{
  String mentor;
  TraineeWorker(String name, int age, String mentor){
    super(name, age);
    this.mentor = mentor;
  }

  @Override
  void work(){
    System.out.println(name+" uczy sie pod okiem mentora: "+mentor);
  }
}
public class WorkerMain{
  public static void main(String[] args){
    ConstructionWorker budowniczy1 = new ConstructionWorker("Jan", 35, "Murarz", 10);
    TraineeWorker stazysta1 = new TraineeWorker("Anna", 22, "Kowalski");

    budowniczy1.displayInfo();
    budowniczy1.work();
    budowniczy1.build();

    stazysta1.displayInfo();
    stazysta1.work();
  }
}

//TODO add jaavdoc comments
