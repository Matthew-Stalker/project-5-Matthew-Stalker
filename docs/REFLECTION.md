[Shaker sort]: Shaker sort was pretty simple to understand with the background knowledge of bubble sort.
The main difference is the bidirectional sweeping, which allows it to handle the turtles at the end of the array much better than bubble sort.
The bug in this psuedo code is mentioned in the AI Assisted Development Analysis section.

[Gnome Sort]: The simple Gnome sort is pretty easy to understand, 
it's a fun little algorithm that just keeps swapping and checking until he's happy that his garden is sorted.

[Shell Sort]: It was rough to understand at first but found that it just takes smaller sets of data and semi 
sorts them until it can reduce the gap to one and then continue to make less and less changes 
to the array until fully sorted. 
It also uses the Ciura sequence, which I found is a set of numbers that efficiently cuts data into manageable chunks.
The shell sort then uses those chunks to sort the data in a way that is more efficient than just doing an insertion sort.

[Test suite]: The AI generated the entire test suite requested in the rubric, correctly using both Integer and String arrays to test the generic implementations.
However, the true value of the AI was in the extra boundary checks it suggested.
Beyond the standard requirements, the AI noted that we needed to test for:
Null Arrays: To ensure the algorithms safely exited rather than crashing.
Negative Numbers & Zero: To ensure the .compareTo() logic held up across the entire number line.
Nearly Sorted Arrays: This was a brilliant suggestion specifically to test Cocktail Shaker Sort's bidirectional sweeping and validate that its early-exit break condition actually functioned as intended.
Min/Max Integer Values: To test for unexpected integer overflow issues during comparisons.

[AI Assisted Development Analysis]
Did the AI correctly implement the pseudocode on first attempt?\
    -Yes, the core logic was translated correctly on the first attempt, but the AI identified and fixed a bug in the provided Cocktail Shaker Sort pseudocode. 
    The pseudocode used inclusive bounds (0 to length(a) - 1), which in Java would result in comparing a[4] > a[5] on a 5-element array, throwing an ArrayIndexOutOfBoundsException. 
    The AI automatically corrected this by adjusting the loop boundaries to exclusive bounds (< a.length - 1 and starting the reverse sweep at a.length - 2). 
    The AI suggested and implemented a null-input safety check (if (a == null) return;) to prevent a NullPointerException if the utility was called improperly.
Did AI preserve the exact variable names from pseudocode?\
    - By explicitly instructing the AI in the prompt, it perfectly preserved pos for Gnome Sort, swapped and i for Cocktail Shaker Sort, and gaps, n, temp, and j for Shell Sort.
How did using AI help (or hinder) learning these new algorithms?\
    - The code was exceptionally well-structured and readable. The AI included line-by-line comments explaining exactly how the Java code mapped back to the pseudocode steps. 
    It also flawlessly handled the generic type constraints (<T extends Comparable<T>>), ensuring that .compareTo() was used properly throughout the implementations without making the code overly dense or difficult to read.
Was the AI-generated code readable and well-structured? Did it include appropriate comments?\
    - The code was exceptionally well-structured and readable. The AI included line-by-line comments explaining exactly how the Java code mapped back to the pseudocode steps. 
    It also handled the generic type constraints (<T extends Comparable<T>>), ensuring that .compareTo() was used properly throughout the implementations without making the code overly dense or difficult to read.
What would you do differently next time?\
    - If I were to do this again, I would try and flesh out what I needed the AI to do beforehand,
    so I would have to make less edits and additions to code I had already implemented into the package.


