package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] sites;
    private int n;
    private int count = 0;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF noBackWash;
    private int top;
    private int bottom;

    public Percolation(int N) {
        if (N < 0) {
            throw new java.lang.IllegalArgumentException();
        }
        this.n = N;
        this.sites = new boolean[N][N];
        for (int q = 0; q < N; q++) {
            for (int r = 0; r < N; r++) {
                this.sites[q][r] = false;
            }
        }
        uf = new WeightedQuickUnionUF(n * n + 2);
        noBackWash = new WeightedQuickUnionUF(n * n + 1);
        //noBackWash is to record the node which is connected to the bottom but not the top
        //so it is only find the connect between the node and the top
        top = n * n;
        bottom = n * n + 1;
    }                // create N-by-N grid, with all sitess initially blocked


    public void open(int row, int col) {
        if (row >= n || col >= n || row < 0 || col < 0) {
            throw new java.lang.IndexOutOfBoundsException("Invalid numbers for row and col");
        }
        if (isOpen(row, col)) {
            return;
        }
        sites[row][col] = true;

        if (row == 0) {
            uf.union(xyTo1D(row, col), top);
            noBackWash.union(xyTo1D(row, col), top);
        }
        if (row == n - 1) {
            uf.union(xyTo1D(row, col), bottom);
        }

        if (col + 1 < n  &&  isOpen(row, col + 1)) {
            uf.union(xyTo1D(row, col), xyTo1D(row, col + 1));
            noBackWash.union(xyTo1D(row, col), xyTo1D(row, col + 1));
        }
        if (col - 1 >= 0 &&  isOpen(row, col - 1)) {
            uf.union(xyTo1D(row, col), xyTo1D(row, col - 1));
            noBackWash.union(xyTo1D(row, col), xyTo1D(row, col - 1));
        }
        if (row + 1 < n  &&  isOpen(row + 1, col)) {
            uf.union(xyTo1D(row, col), xyTo1D(row + 1, col));
            noBackWash.union(xyTo1D(row, col), xyTo1D(row + 1, col));
        }
        if (row - 1 >= 0  &&  isOpen(row - 1, col)) {
            uf.union(xyTo1D(row, col), xyTo1D(row - 1, col));
            noBackWash.union(xyTo1D(row, col), xyTo1D(row - 1, col));
        }


        count += 1;
    }       // open the sites (row, col) if it is not open already

    public boolean isOpen(int row, int col) {
        if (row >= n || col >= n || row < 0 || col < 0) {
            throw new java.lang.IndexOutOfBoundsException("Invalid numbers for row and col");
        }
        return sites[row][col];
    }  // is the sites (row, col) open?

    public boolean isFull(int row, int col) {
        if (row >= n || col >= n || row < 0 || col < 0) {
            throw new java.lang.IndexOutOfBoundsException("Invalid numbers for row and col");
        }
        return noBackWash.connected(xyTo1D(row, col), top);
    }  // is the sites (row, col) full?


    public int numberOfOpenSites() {
        return count;
    }           // number of open sites

    public boolean percolates() {
        return uf.connected(top, bottom);
    }              // does the system percolate?

    private int xyTo1D(int row, int col) {
        if (row >= n || col >= n || row < 0 || col < 0) {
            throw new java.lang.IndexOutOfBoundsException("Invalid numbers for row and col");
        }
        return row * n + col;
    }

    public static void main(String[] args) {
    }


}
