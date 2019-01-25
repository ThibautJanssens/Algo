/*
Make a program that asks for an integer n and generates the n first Fibonacci numbers.

Yes, you'll have to search what the hell are Fibonacci numbers.
*/

function fibonacci(n){
    if(n == 0)
        return 0;
    if(n == 1)
        return 1;
    return fibonacci(n-1) + n;
}

console.log(fibonacci(10));