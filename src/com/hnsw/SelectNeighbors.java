package com.hnsw;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class SelectNeighbors {

  /**
   * Selects the closest neighbors to a given vector.
   * @param base
   * @param candidates
   * @param numNeighbors
   * @param order to determine distance-order method (Manhattan = 1, Euclidean = 2, etc.)
   *
   * @return Vector[] because after the PriorityQueue has fulfilled its purpose of
   * sorting or selecting elements, it is often discarded or cleared (based on my research).
   * Assuming M (numNeighbors) is an arbitrary large number and that Vector.length is also large:
   * M x V_l would have significant implications on time complexity.
   * A PriorityQueueVector allocation is of O(logN) and a Vector[] allocation is of O(n)
   * Thus, I have decided to return a Vector[] as this would be significant on a large
   * distributed system. Again, this is assuming that after SelectNeighbors() has fulfilled
   * its purpose, the return type and value are not dynamically used again. LMK if I am wrong!
   */
  public Vector[] SelectNeighbors(Vector base, List<Vector> candidates, int numNeighbors, int order) {

    if (candidates.isEmpty()) {
      return null;
    }

    PriorityQueue<Distance> distances =
        new PriorityQueue<>(Comparator.comparingDouble(SelectNeighbors::applyAsDouble));

    double dif;
    for (Vector vector : candidates) {
      dif = minkowskiDistance(vector, base, order);
      distances.add(new Distance(dif, vector));
    }

    Vector[] closest = new Vector[numNeighbors];
    for (int i = 0; i < numNeighbors; i++) {
      closest[i] = Objects.requireNonNull(distances.poll()).vector;
    }

    return closest;
  }

  /**
   * Sums the vector variable differences using minkowski
   * @param newVector
   * @param base
   * @param p I.E. 1 for Manhattan, 2 for Euclidean, 3 for third-order, and so on
   * @return difference
   */
  private double minkowskiDistance(Vector newVector, Vector base, double p) {
    double total = 0;
    for (int i = 0; i < Math.min(newVector.length, base.length); i++) {
      total += Math.pow(Math.abs(newVector.axes[i] - base.axes[i]), p);
    }
    return Math.pow(total, 1.0 / p);
  }

  private static double applyAsDouble(Distance dist) {
    return dist.distance;
  }
}
