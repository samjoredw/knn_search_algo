package com.hnsw;
public class Vector {
  public Vector(double[] axes, String value) {
    this.axes = axes;
    this.value = value;
    this.length = axes.length;
  }
  public double[] axes;
  public String value;
  public int length;
}
