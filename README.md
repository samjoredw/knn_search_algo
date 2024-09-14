# HierarchicalNSW

## Overview

HierarchicalNSW is a Java implementation of the Hierarchical Navigable Small World algorithm, which is used for efficient approximate nearest neighbor (ANN) searches. This project demonstrates the use of HNSW for quickly finding the nearest vectors in a high-dimensional space, and includes a sample implementation of K-Nearest Neighbors (K-NN) search methods.

## Background

Some important concepts for this project were K-Nearest Neighbors (K-NN) and hierarchical Navigable Small World. KNN is a simple and widely used algorithm for all sorts of stuff in ML, graphs, distributed systems, etc. The basic idea of K-NN is to find the k closest data points to a given query point in a dataset and use the properties of these neighbors to make predictions or decisions. KNN relies heavily on distance metrics to determine proximity, for example: Manhattan Distance, Euclidean Distance, Minokowski Distance. I use Minokowski in my implimentation.

Hierarchical Navigable Small World (HNSW) is an advanced algorithm designed for fast and efficient approximate nearest neighbor search. It constructs a multi-layer graph where each layer provides a different level of granularity for navigating through the space. HNSW achieves high performance by leveraging the following features: The graph is organized in layers, with higher layers containing fewer nodes and representing a more abstract view of the space. My HNSW algorthm is semantically stong and makes very few assumptions about the input for vectorized data to determine our "NN's". It can adapt to any number of inputs.

Demo class included.

## Run

$ #mkdir/cd/...  
$ git clone https://github.com/samjoredw/hierarchical_nsw.git  
$ cd hierarchical_nsw  
$ javac -d out src/com/hnsw/*.java  
$ java -cp out com.hnsw.Main  

