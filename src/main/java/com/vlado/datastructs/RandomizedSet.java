package com.vlado.datastructs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.text.html.parser.Entity;

/**
 * Created by vdimitrov on 11/4/17.
 */
public class RandomizedSet {

  public static void main(String[] args) {
    RandomizedSet set = new RandomizedSet();
//    ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
//    [[],[1],[2],[2],[],[1],[2],[]]

//    ["RandomizedSet","insert","insert","insert","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom"]
//    [[],[0],[1],[2],[],[],[],[],[],[],[],[],[],[]]

    System.out.println(set.insert(0));
    System.out.println(set.insert(1));
    System.out.println(set.insert(2));
    System.out.println(set.getRandom());
    System.out.println(set.getRandom());
    System.out.println(set.getRandom());
    System.out.println(set.getRandom());
    System.out.println(set.getRandom());
    System.out.println(set.getRandom());
    System.out.println(set.getRandom());
    System.out.println(set.getRandom());
    System.out.println(set.getRandom());

  }

  private int count = 0;
  private LinkedList<Entry>[] values;

  /** Initialize your data structure here. */
  public RandomizedSet() {
    values = new LinkedList[15];
    for (int i = 0; i < values.length; i++) {
      values[i] = new LinkedList<>();
    }
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    LinkedList<Entry> entries = entriesForIndex(val);

    for (Entry e : entries) {
      if (e.getValue() == val) {
        return false;
      }
    }
    entries.add(new Entry(val));
    count ++;
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    LinkedList<Entry> entries = entriesForIndex(val);
    Iterator<Entry> iter = entries.iterator();
    while (iter.hasNext()) {
      Entry next = iter.next();
      if (next.getValue() == val) {
        iter.remove();
        count --;
        return true;
      }
    }
    return false;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    int randomNum = ThreadLocalRandom.current().nextInt(0, count);
    int current = 0;
    for (int i = 0; i < values.length; i++) {
      if (values[i].size() > 0) {
        for (Entry e : values[i]) {
          if (current == randomNum) {
            return e.getValue();
          } else {
            current++;
          }
        }
      }
    }
    return -1;
  }

  public LinkedList<Entry> entriesForIndex(int val) {
    int index =  val & values.length - 1;
    LinkedList<Entry> entries = values[index];
    return entries;
  }

  static class Entry {
    private int value;
    public Entry(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

}
