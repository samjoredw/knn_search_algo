package com.hnsw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

  public static void main(String[] args) {
    List<Vector> candidates = generateLargeDataset(1000, 3); // 1000 vectors, 3 dimensions
    Vector base = new Vector(new double[]{50.0, 50.0, 50.0}, "BaseVector");
    SelectNeighbors sn = new SelectNeighbors();

    Vector[] closestNeighbors = sn.SelectNeighbors(base, candidates, 5, 2);

    System.out.println("Closest Neighbors:");
    for (Vector vec : closestNeighbors) {
      System.out.print("Vector Value: " + vec.value + ", Coordinates: [");
      for (double axis : vec.axes) {
        System.out.print(axis + " ");
      }
      System.out.println("]");
    }
  }

  /**
   * Generates a large dataset of vectors with correlated values.
   * @param numVectors Number of vectors to generate
   * @param dimensions Number of dimensions for each vector
   * @return List of generated vectors
   */
  private static List<Vector> generateLargeDataset(int numVectors, int dimensions) {
    List<Vector> vectors = new ArrayList<>();
    Random rand = new Random();

    for (int i = 0; i < numVectors; i++) {
      double[] axes = new double[dimensions];
      for (int j = 0; j < dimensions; j++) {
        axes[j] = rand.nextDouble() * 100;
      }
      String value = generateDistribution(axes);

      vectors.add(new Vector(axes, value));
    }

    return vectors;
  }

  /**
   * Generates a meaningful value based on the vector's coordinates.
   * @param axes Array of coordinates
   * @return A string value based on the coordinates
   */
  private static String generateDistribution(double[] axes) {
    StringBuilder valueBuilder = new StringBuilder("Vector");
    for (double axis : axes) {
      valueBuilder.append((int) axis).append("_");
    }
    if (!valueBuilder.isEmpty()) {
      valueBuilder.setLength(valueBuilder.length() - 1);
    }
    return valueBuilder.toString();
  }
}
