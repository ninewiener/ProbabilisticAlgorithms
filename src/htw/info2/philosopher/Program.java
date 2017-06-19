package htw.info2.philosopher;

public class Program {
  private Philosopher[] philosophers;
  private Fork[] forks;

  public Program() {
    philosophers = new Philosopher[5];
    /* for (int i = 0; i < philosophers.length; i++) {
      philosophers[i] = new Philosopher(i);
      System.out.println(philosophers[i]);
    } */

    forks = new Fork[5];
    for (int i = 0; i < forks.length; i++) {
      forks[i] = new Fork(i);
    }

    for (Fork fork : forks) {
      System.out.println("Fork " + fork.getId());
    }
  }

  public static void main(String[] args) {
    Program p = new Program();
    p.run();
  }

  private void run() {
    Thread[] threads = new Thread[philosophers.length];
    for (int i = 0; i < philosophers.length; i++) {
      Fork leftFork = forks[i];
      Fork rightFork = forks[(i + 1) % 5]; // 5 becomes 0
      philosophers[i] = new Philosopher(i, leftFork, rightFork);
      threads[i] = new Thread(philosophers[i]);
      threads[i].start();
    }
  }

  Philosopher getPhilosopher(int id) {
    try {
      return philosophers[id];
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
    return null;
  }
}
