package com.vlado.strings;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by vdimitrov on 11/25/17.
 */
public class SimplifyPath {

  public static void main(String[] args) {
    System.out.println(new SimplifyPath().simplifyPath("/a/./b/../../c/"));
    System.out.println(new SimplifyPath().simplifyPath("/home/"));
    System.out.println(new SimplifyPath().simplifyPath("/../"));
    System.out.println(new SimplifyPath().simplifyPath("/home//foo/"));
  }

  public String simplifyPath(String path) {
    int ind = 0;
    int lastSlashIndex = 0;
    if (path.charAt(ind) == '/') {
      ind++;
    }
    LinkedList<String> folders = new LinkedList<>();
    for (int i = ind; i < path.length(); i++) {
      if (path.charAt(i) == '/') {
        String folder = path.substring(lastSlashIndex + 1, i);
        if (folder.equals("..")) {
          if (folders.isEmpty()) {
            return "/";
          }
          folders.pop();
        } else if (folder.length() > 0 && !folder.equals(".")) {
          folders.push(folder);
        }
        lastSlashIndex = i;
      }
    }
    if (folders.isEmpty()) {
      return "/";
    }
    StringBuilder sb = new StringBuilder();
    while (!folders.isEmpty()) {
      sb.append("/");
      sb.append(folders.pollLast());
    }
    return sb.toString();
  }
}
