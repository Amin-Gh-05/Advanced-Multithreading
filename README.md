# Pi Calculator

## Intro

PI as one of the most influential irrational numbers in vast world of mathematics.

In basic education - mostly in geometry - we've been taught to define PI as circle's number ration to its radius.

finding the most accurate PI number's been a classic math problem and issue for scientist since 15th century and earlier.

## Algorithms

### Nilkantha's series

The series was published in the 15th century by the Indian mathematician Nilakantha Somayaji. 
It's the first accessible algorithm when it comes to finding one.
We should consider it a classic algorithm with time complexity of O(N * logN * loglogN)
    
> Approach: 
When looking at the pattern of the denominator, we can see that, except for the first term, each term consists of the product of three sequential numbers.
To find the right term in the denominator, we can use a variable and increase it by two with each iteration.
Also, note that this is an alternating series, meaning the signs of consecutive terms are different.

### Ramanujan–Sato series

Examples for levels 1–4 were given by Ramanujan in his 1917 paper.
It's been basis of many other modern algorithms.

### Chudnovsky series

The Chudnovsky algorithm is a fast method for calculating the digits of π, based on Ramanujan's π formulae.
Published by the Chudnovsky brothers in 1988, it was used to calculate π to a billion decimal places.
The order of the algorithm is O(N * logN ^ 3).

![chudnovsky](resources/chudnovsky.svg)

### Bailey-Borwein-Plouffe series

Such algorithms are called spigot algorithms.
The formula was discovered experimentally in 1995 via the PSLQ algorithm, which itself was named one of the Top Ten Algorithms of the Century.

![bbp](resources/bbp.svg)

### Bellard's formula

Bellard's formula was discovered by Fabrice Bellard in 1997. It is about 43% faster than the Bailey–Borwein–Plouffe formula (discovered in 1995).
It has been used in PiHex, the now-completed distributed computing project.

> One important use of this method is to confirm calculations of all the numbers in pi that have been done using other methods.
Instead of having to calculate all the numbers in pi twice using two different algorithms to make sure the calculation is accurate, the final numbers in a very long calculation can be checked using Bellard's formula, which is much faster.

![bellard](resources/bellard.svg)

## Bugs and Challenges

