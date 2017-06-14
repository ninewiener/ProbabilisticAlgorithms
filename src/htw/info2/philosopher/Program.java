package htw.info2.philosopher;

public class Program {

  public Program() {
    // TODO Auto-generated constructor stub
  }


  public static void main(String[] args) {
    Program p = new Program();
    p.run();
  }

  private void run() {
    Thread p1 = new Philosopher(1);
    p1.start();
    Thread p2 = new Philosopher(2);
    p2.start();
    Thread p3 = new Philosopher(3);
    p3.start();
  }
}
