package hw2;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;


public class PercolationStats {
    private double[] threshold;
    private int T;
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        this.T = T;
        this.threshold = new double[T];


        for (int i = 0; i < T; i++) {
            Percolation p = pf.make(N);
            while (!p.percolates()) {
                int randomRow = StdRandom.uniform(N);
                int randomCol = StdRandom.uniform(N);
                p.open(randomRow, randomCol);
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
