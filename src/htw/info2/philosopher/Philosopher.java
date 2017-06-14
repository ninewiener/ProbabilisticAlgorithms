package htw.info2.philosopher;

import java.util.Random;

public class Philosopher extends Thread {
  boolean isBusy;
  private int id;
  private Random rand;

  public Philosopher(int id) {
    // TODO Auto-generated constructor stub
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
            wait(10);
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
        isBusy = !isBusy;
      }
    }
  }
}
