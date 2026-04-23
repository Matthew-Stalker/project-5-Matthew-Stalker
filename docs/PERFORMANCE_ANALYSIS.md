
[10,000 size array] Performance Analysis
StopWatch '': 0.5636262 seconds
----------------------------------------
Seconds       %       Task name
----------------------------------------
0.2157125     38%     Gnome Sort
0.3416147     61%     Cocktail Shaker Sort
0.006299      01%     Shell Sort

For the medium data set of 10,000 elements, the performance analysis shows that the Cocktail Shaker Sort is significantly faster than the Gnome Sort, 
taking approximately 61% of the total time compared to 38% for Gnome Sort. 
The Shell Sort is much faster than both, taking only about 1% of the total time.



[100,000 size array] Performance Analysis
StopWatch '': 71.8511724 seconds
----------------------------------------
Seconds       %       Task name
----------------------------------------
25.4184242    35%     Gnome Sort
46.3563153    65%     Cocktail Shaker Sort
00.0764329    00%     Shell Sort

For the large data set of 100,000 elements, the performance analysis shows that the Cocktail Shaker Sort continues to outperform the Gnome Sort, 
taking approximately 65% of the total time compared to 35% for Gnome Sort. 
Shell sort continues to be the fastest, taking 0% relative to the total time.

[100 size array] Performance Analysis
StopWatch '': 0.0015292 seconds
----------------------------------------
Seconds       %       Task name
----------------------------------------
0.0011191     73%     Gnome Sort
0.0002834     19%     Cocktail Shaker Sort
0.0001267     08%     Shell Sort

For the small data set of 100 elements, the performance analysis shows that the Gnome Sort takes the majority of the time, 
effectively swapping with cocktail shaker sort implying the larger the data set the less efficient shaker sort is. 
Shell sort takes the cake for efficiency among all data sizes.

=========================================
TESTING RANDOM ARRAY             
=========================================
StopWatch '': 0.5652659 seconds
----------------------------------------
Seconds       %       Task name
----------------------------------------
0.2142768     38%     Gnome Sort
0.3444832     61%     Cocktail Shaker Sort
0.0065059     01%     Shell Sort


=========================================
TESTING SORTED ARRAY             
=========================================
StopWatch '': 0.0039354 seconds
----------------------------------------
Seconds       %       Task name
----------------------------------------
0.0000815     02%     Gnome Sort
0.0001392     04%     Cocktail Shaker Sort
0.0037147     94%     Shell Sort


=========================================
TESTING REVERSE SORTED ARRAY       
=========================================
StopWatch '': 0.7049062 seconds
----------------------------------------
Seconds       %       Task name
----------------------------------------
0.3444953     49%     Gnome Sort
0.358723      51%     Cocktail Shaker Sort
0.0016879     00%     Shell Sort

These results show that Shell sort is still more efficient unless the data is already sorted.
This is due to its logic having to work through all the gaps in the array before terminating.

[Complexity Analysis]
[Comparing Empirical Results]\
The empirical timing results seem to match the expected efficiency equations. Shell Sort, which operates with a sub-quadratic complexity (roughly O(n^{1.25}) with the Ciura gap sequence), completely dominated the tests, finishing in just a few milliseconds.
Gnome Sort and Cocktail Shaker Sort, both holding an O(n^2) average/worst-case complexity, took significantly longer (hundreds of milliseconds) on scrambled data, 
confirming their quadratic nature.\
[Gnome Sort vs. Cocktail Shaker Sort]\
Although both have the same theoretical worst-case complexity, their constant factors and overhead vary wildly depending on the data. On purely random data,
Gnome Sort actually performed faster than Cocktail Shaker Sort. This is because Gnome Sort relies on a single, highly optimized while loop. 
Cocktail Shaker Sort carries heavy overhead—managing two separate for loops, toggling a boolean flag, and recalculating boundaries on every single pass.\
[Why Cocktail Shaker is often faster than Bubble Sort]\
Standard Bubble Sort only sweeps from left to right. This means large numbers move to the end very quickly (rabbits), 
but small numbers at the end of the array (turtles) only move forward one position per complete pass. 
Cocktail Shaker Sort fixes this by adding a backward sweep. This backward pass grabs those "turtles" and immediately drags them all the way to the front, 
drastically reducing the total number of passes required.\
[Best Algorithms in Different ScenariosCompletely Random / Reverse Sorted] \
Shell Sort is the undisputed winner. The gap sequence allows it to make massive leaps, 
whereas Gnome and Cocktail Shaker are forced to drag elements one by one.\
[Already Sorted / Nearly Sorted] \
Cocktail Shaker Sort (and Gnome Sort) perform beautifully here, dropping to O(n) time.
Cocktail Shaker's early-exit boolean flag triggers almost immediately, preventing unnecessary work.\
[Does Gnome Sort show consistent O(n^2) behavior?]\
Yes. On random and reverse-sorted data, its runtime scales poorly. 
Because every out-of-order element forces the algorithm to "walk backward" step-by-step to place the element, 
an array with many displaced elements results in a massive number of redundant comparisons and swaps. \
[How does Cocktail Shaker Sort perform on nearly-sorted data vs. reverse-sorted?]\
It acts like two completely different algorithms. On nearly-sorted data, it is incredibly fast because it makes one or two passes, sees that swapped == false, 
and triggers the break condition to exit early. 
On reverse-sorted data, it drops to its absolute worst O(n^2) performance because every single pass requires maximum swaps, 
and it must traverse the array constantly.\
[Does bidirectional sweeping in Cocktail Shaker provide observable benefits?]\
It provides massive benefits specifically when the array contains small values at the end of the data. The backward sweep clears these out instantly. 
However, on purely random data, the bidirectional sweeping provides no observable benefit and 
actually slows the algorithm down compared to a simpler loop due to overhead.\
[How do these algorithms compare to standard bubble sort?]\
Both are improvements over standard Bubble Sort. Gnome Sort achieves similar results but with simpler logic. 
Cocktail Shaker Sort is a direct, optimized upgrade to Bubble Sort that eliminates the "turtle" problem of slowly moving small number to the front of the data.
Shell Sort is in a completely different class of efficiency, far outperforming Bubble Sort in every scenario due to its divide and conquer methodology. 
[Are there any unexpected performance patterns?]\
The most unexpected pattern was that the "smarter" Cocktail Shaker Sort ran notably slower than the "dumber" Gnome Sort on a completely random 10,000-element array. 
One might expect bidirectional sweeping to always be faster, but this empirically proves that algorithmic complexity (managing multiple loops and direction changes) 
can cause an algorithm to perform worse than an equivalent O(n^2) algorithm with simpler, tighter code.
[Final thoughts (No AI)]\
Though AI wrote the majority of this analysis the driver results speak for themselves. 
AI did a great job of describing the exact methodology behind each sorting algorithm.
This led me to the realization that, even without the technical "know how" of the way these algorithms sort data in code, the logic behind them 
is simple enough to understand the limits of efficiency with increasing data sizes in each sorting system.