# K-Nearest Neighbor Search Algorithm

## Overview

KNN Search is my take on one of the many algorithms behind the Hierarchical Navigable Small World data structure (coded in Java), which is used for efficient approximate nearest neighbor (ANN) searches on vector datasets. This project demonstrates the use of a KNNS algorithm in HNSW data structures for quickly finding the nearest vectors in a high-dimensional space, and includes a sample implementation of K Nearest Neighbors search methods.

## Background

Some important concepts for this project were KNN/KANN and hierarchical Navigable Small World. KNN is a simple and widely used algorithm for all sorts of stuff in ML, graphs, distributed systems, etc. The basic idea of KNN is to find the k closest data points to a given query point in a dataset and use the properties of these neighbors to make predictions or decisions. KNN relies heavily on distance metrics to determine proximity, for example: Manhattan Distance, Euclidean Distance, Minokowski Distance. I use Minokowski in my implimentation. KANN is aproximate - in name and nature - meaning that the requirements for the "NN's" are much more lax.

HNSW is an advanced algorithm designed for fast and efficient approximate nearest neighbor searches. It constructs a multi-layer graph where each layer provides a different level of granularity for navigation. My HNSW algorthm is semantically stong and makes very few assumptions about the input for vectorized data to determine our "NN's". It can adapt to any number of inputs.

Demo class included.

## Run

$ #mkdir/cd/...  
$ git clone https://github.com/samjoredw/hierarchical_nsw.git  
$ cd hierarchical_nsw  
$ javac -d out src/com/hnsw/*.java  
$ java -cp out com.hnsw.Main  

