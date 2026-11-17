1. End-to-end benchmark

What is measured: time needed to read input file, sort, write sorted output to a new file

Results:

Quicksort:  approximately 200ms for 100k integers

Bitmapsort: approximately 100ms for 100k integers

2x speedup

2. In-memory benchmark

What is measured: only sorting operations - for Quicksort this means integer comparisons, swaps, etc. For Bitmapsort it means iterate through the bitmap and construct the output (i.e., it includes 1 I/O operation)

Results:

Quicksort:  approximately 85ms for 100k integers

Bitmapsort: approximately 18ms for 100k integers

~5x speedup

In both experiments, both algorithms executed on the same machine, on the exactly the same data.

Final result:

For a dataset of 100,000 unique, non-negative, randomly shuffled integers within a known bounded domain [0, 99999], this Java BitSet-based Bitmap Sort implementation achieved approximately 4.72x faster in-memory execution and 2x faster end-to-end execution compared with a conventional recursive (Lomuto partition scheme) Quicksort implementation.