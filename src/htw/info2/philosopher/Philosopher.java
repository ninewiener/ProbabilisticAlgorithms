package htw.info2.philosopher;

import java.util.Random;

public class Philosopher implements Runnable {
  boolean isBusy;
  private int id;
  private Random rand;

  public Philosopher() {
    System.out.println("test");
  }

  public Philosopher(int id) {
    this.id = id;
    rand = new Random();
  }

  @Override
  public void run() {
    while (true) {
      synchronized (this) {
        if (!isBusy) {
          System.out.println(id);
        } else {
          try {
            wait(3000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        isBusy = !isBusy;
      }
    }
  }
}
