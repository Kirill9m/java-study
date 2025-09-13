package rs.clone.locations;


import rs.clone.Items.Item;
import rs.clone.character.Enemy;

public abstract class Location {
  public abstract String name();
  public abstract String description();
  public abstract Enemy enemy();
  public abstract Item item();
}
