package com.vlado.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CourseSchedule {

  public static void main(String[] args) {
    CourseSchedule s = new CourseSchedule();

    System.out.println(Arrays.toString(s.findOrder(2, new int[][]{{0, 1}, {1, 0}})));
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if (numCourses <= 1 || prerequisites.length == 0) {
      return new int[0];
    }

    Graph graph = buildGraph(numCourses, prerequisites);

    Course[] result = new Course[numCourses];

    List<Course> nonDependent = graph.getNonDependent();
    for (int i = 0; i < nonDependent.size(); i++) {
      result[i] = nonDependent.get(i);
    }

    int counter = nonDependent.size();
    for (int i = 0; i < result.length; i++) {
      Course course = result[i];
      if (course == null) {
        return null;
      }
      for(Course c : course.courses) {
        c.decrementPrerequisites();
        if (c.prerequisites == 0) {
          result[counter] = c;
          counter++;
        }
      }
    }

    int[] ints = new int[numCourses];
    for (int i = 0; i < result.length; i++) {
      ints[i] = result[i].number;
    }
    return ints;
  }



  public Graph buildGraph(int numCourses, int[][] prerequisites) {
    Graph graph = new Graph();

    for (int i = 0; i < numCourses; i++) {
      graph.addCourse(i);
    }

    for (int i = 0; i < prerequisites.length; i++) {
      int prereq = prerequisites[i][0];
      int target = prerequisites[i][1];
      graph.addDependency(target, prereq);
    }
    return graph;
  }

  static class Course {

    private final int number;
    private int prerequisites = 0;

    private Set<Course> courses = new HashSet<>();

    public void addPrerequisite(Course course) {
      courses.add(course);
      course.incrementPrerequisites();
    }

    public void incrementPrerequisites() {
      prerequisites++;
    }

    public void decrementPrerequisites() {
      prerequisites--;
    }

    Course (int number) {
      this.number = number;
    }
  }

  static class Graph {
    Map<Integer, Course> courses = new HashMap<>();

    public void addCourse(int number) {
      courses.putIfAbsent(number, new Course(number));
    }

    public void addDependency(int target, int prereq) {
      courses.putIfAbsent(target, new Course(target));
      courses.putIfAbsent(prereq, new Course(prereq));

      courses.get(target).addPrerequisite(courses.get(prereq));
    }

    public List<Course> getNonDependent() {
      return courses.values().stream().filter(course -> course.prerequisites == 0).collect(
          Collectors.toList());
    }
  }
}
