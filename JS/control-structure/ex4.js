const readlineSync = require("readline-sync");

//Ex4 - Count from 1 to 100. For every even number display the result of their division by 2. 
//For every odd number display the result of their multiplication by 3.
for (let j = 0; j <= 100; j++){
    if(j%2 == 0)
        console.log(j/2);
    else
        console.log(j*3);
}