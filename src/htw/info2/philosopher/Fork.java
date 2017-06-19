package htw.info2.philosopher;

/**
 * Created by salomon on 19.06.17.
 */
public class Fork {
  private int id;
  private boolean active = false;

  Fork(int id) {
    this.id = id;
  }

  boolean take() {
    if (!active) {
      active = true;
      return true;
    }
    return false;
  }

  boolean drop() {
    if (active) {
      active = false;
      return true;
    }
    return false;
  }

  int getId() {
    return this.id;
  }

  boolean isActive() {
    return active;
  }

}
