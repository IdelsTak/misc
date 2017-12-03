package com.vlado.mocks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Find the Common Manager
 */
public class CommonManager {

  public static void main(String[] args) {

    CommonManager cm = new CommonManager(new String[]{"Gareth", "Alex", "June Alex", "June Qing",
    "Qing Paul", "Qing Gareth"});
    System.out.println(cm.getCommonManager("Gareth", "Alex")); //June

    cm = new CommonManager(new String[]{"Simon", "Claudiu", "Sarah Claudiu", "Sarah Paul",
        "Claudiu Simon"});
    System.out.println(cm.getCommonManager("Simon", "Claudiu")); //Claudiu

    cm = new CommonManager(new String[]{"Hilary", "James", "Sarah Fred", "Sarah Paul",
        "Fred Hilary", "Fred Jenny", "Jenny James"});
    System.out.println(cm.getCommonManager("Hilary", "James")); //Fred
  }

  Map<String, String> relations = new HashMap<>();

  public CommonManager(String[] list) {
    for (int i = 2; i < list.length; i++) {
      String[] s = list[i].split(" ");
      relations.put(s[1], s[0]); //enables finding the manager
    }
  }

  public String getCommonManager(String name1, String name2) {
    Set<String> chain = new HashSet<>();
    String empl = name1;
    while (empl != null) {
      empl = relations.get(empl);
      chain.add(empl);
    }
    empl = name2;
    while (empl != null && !chain.contains(empl)) {
      empl = relations.get(empl);
    }

    return empl;
  }

}
