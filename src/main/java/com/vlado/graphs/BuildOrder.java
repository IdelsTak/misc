package com.vlado.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a list of projects and a list of dependencies. All of a project's dependencies
 * must be built before the project is. Find a build order.
 */
public class BuildOrder {

  public static void main(String[] args) {
    String[] projects = new String[]{"a", "b", "c", "d", "e", "f"};
    String[][] deps = new String[][]{{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};

    BuildOrder buildOrder = new BuildOrder();
    Project[] result = buildOrder.findBuildOrder(projects, deps);
    System.out.println(Arrays.toString(result));
  }

  private Graph createGraph(String[] projects, String[][] dependencies) {
    Graph graph = new Graph();
    for (String project : projects) {
      graph.getOrCreateNode(project);
    }

    for (String[] dep : dependencies) {
      String start = dep[0];
      String end = dep[1];
      graph.createDependency(start, end);
    }
    return graph;
  }

  public Project[] findBuildOrder(String[] projects, String[][] dependencies) {
    Graph graph = createGraph(projects, dependencies);
    return orderProjects(graph.allNodes);
  }

  private Project[] orderProjects(List<Project> projects) {
    Project[] result = new Project[projects.size()];

    int offset = addNonDependent(result, projects, 0);

    int toProcess = 0;
    while (toProcess < result.length) {
      Project current = result[toProcess];
      if (current == null) {
        return null;
      }

      List<Project> deps = current.deps;
      for (Project child : deps) {
        child.decrementDepCount();
      }

      offset = addNonDependent(result, deps, offset);
      toProcess++;
    }
    return result;
  }

  private int addNonDependent(Project[] result, List<Project> projects, int offset) {
    for (Project project : projects) {
      if (project.depCount == 0) {
        result[offset] = project;
        offset++;
      }
    }
    return offset;
  }

  private static class Project {
    public int depCount = 0;
    private List<Project> deps = new ArrayList<>();
    private Map<String, Project> map = new HashMap<>();
    public String name;
    public Project(String name) {
      this.name = name;
    }

    public void addDependency(Project dependency) {
      if (!map.containsKey(dependency.name)) {
        deps.add(dependency);
        map.put(dependency.name, dependency);
        dependency.incrementDepCount();
      }
    }

    public void decrementDepCount() {
      depCount--;
    }

    public void incrementDepCount() {
      depCount++;
    }

    public String toString() {
      return name;
    }
  }

  private static class Graph {
    private Map<String, Project> map = new HashMap<>();
    private List<Project> allNodes = new ArrayList<>();

    public void createDependency(String start, String end) {
      Project s = getOrCreateNode(start);
      Project e = getOrCreateNode(end);
      s.addDependency(e);
    }

    public Project getOrCreateNode(String name) {
      if (!map.containsKey(name)) {
        Project node = new Project(name);
        map.put(name, node);
        allNodes.add(node);
      }
      return map.get(name);
    }
  }
}
