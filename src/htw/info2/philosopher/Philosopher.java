package htw.info2.philosopher;

import java.util.Random;

public class Philosopher implements Runnable {
  private boolean isBusy;
  private int id;
  private Random rand;
  private volatile boolean running = true;
  private Fork leftFork;
  private Fork rightFork;
  private int counter = 0;

  public Philosopher(int id, Fork leftFork, Fork rightFork) {
    this.id = id;
    this.leftFork = leftFork;
    this.rightFork = rightFork;
    rand = new Random();
  }

  @Override
  public void run() {
    while (running) {
      think();
      synchronized (this) {
        takeLeftFork();
        synchronized (this) {
          takeRightFork();
          eat();
        }
      }
      dropLeftFork();
      dropRightFork();
      if (counter > 20) {
        running = false;
      } else {
        System.out.println("Philosopher " + id + " total meals: " + counter);
      }
    }
    // running = false;
  }

  void think() {
    System.out.println("Philosopher " + id + " is thinking");
    delay();
    System.out.println("Philosopher " + id + " is done thinking");
  }

  void takeLeftFork() {
    if (leftFork.take()) {
      System.out.println("Philosopher " + id + " takes left fork " + leftFork.getId());
    }
    delay();
  }

  void takeRightFork() {
    if (rightFork.take()) {
      System.out.println("Philosopher " + id + " takes right fork " + rightFork.getId());
    }
    delay();
  }

  void dropLeftFork() {
    if (leftFork.drop()) {
      System.out.println("Philosopher " + id + " drops left fork " + leftFork.getId());
    }
    delay();
  }

  void eat() {
    if (leftFork.isActive() && rightFork.isActive()) {
      counter++;
      System.out.println("Philosopher " + id + " eats (Fork " + leftFork.getId() + " & " + rightFork.getId() + ")");
      delay();
      System.out.println("Philosopher " + id + " is done eating");
    }
  }

  void dropRightFork() {
    if (rightFork.drop()) {
      System.out.println("Philosopher " + id + " drops right fork " + rightFork.getId());
    }
    delay();
  }

  void delay() {
    try {
      Thread.sleep(rand.nextInt(1000) + 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
