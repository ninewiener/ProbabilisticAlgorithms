package htw.info2.philosopher;

public class Program {

  private Philosopher ph1, ph2, ph3, ph4, ph5;

  public Program() {
    ph1 = new Philosopher(1);
    ph2 = new Philosopher(2);
    ph3 = new Philosopher(3);
    ph4 = new Philosopher(4);
    ph5 = new Philosopher(5);
  }

  public static void main(String[] args) {
    Program p = new Program();
    p.run();
  }

  private void run() {
    Thread threadPh1 = new Thread(ph1);
    threadPh1.start();
    Thread threadPh2 = new Thread(ph2);
    threadPh2.start();
    Thread threadPh3 = new Thread(ph3);
    threadPh3.start();
    Thread threadPh4 = new Thread(ph4);
    threadPh4.start();
    Thread threadPh5 = new Thread(ph5);
    threadPh5.start();
  }
}
