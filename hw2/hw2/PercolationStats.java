package hw2;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

import java.util.Random;

public class PercolationStats {
    private double[] threshold;
    private int T;
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        this.threshold = new double[T];
        this.T = T;

        for (int i = 0; i < T; i++) {
            Percolation p = pf.make(N);
            int randomRow = StdRandom.uniform(N);
            int randomCol = StdRandom.uniform(N);
            while (!p.percolates()) {
                p.open(randomRow,randomCol);
            }
            threshold[i] = (double) p.numberOfOpenSites() / N * N;
        }
    }   // perform T independent experiments on an N-by-N grid
    public double mean() {
        return StdStats.mean(threshold);
    }                                           // sample mean of percolation threshold
    public double stddev() {
        return StdStats.stddev(threshold);
    }                                        // sample standard deviation of percolation threshold
    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(T);

    }                                  // low endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(T);
    }                                 // high endpoint of 95% confidence interval

}
