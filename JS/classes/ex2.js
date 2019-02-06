/*
Create a class name Rectangle with attributes topLeftXPos, topLeftYPos, width and lenght. 
Add a method named collides(otherRectangle) that returns true only if 
the current rectangle collides with otherRectangle.

Test the collides(otherRectangle) method by using multiple test cases.
*/

class Rectangle{
    constructor(topLeftXPos, topLeftYPos, width, length){
        this.topLeftXPos = parseInt(topLeftXPos);
        this.topLeftYPos = parseInt(topLeftYPos);
        this.width = parseInt(width);
        this.length = parseInt(length);
    }

    collides(otherRectangle){
        if(this.topLeftXPos < otherRectangle.topLeftXPos + otherRectangle.width &&
            this.topLeftXPos + this.width > otherRectangle.topLeftXPos &&
            this.topLeftYPos < otherRectangle.topLeftYPos + otherRectangle.length &&
            this.length + this.topLeftYPos > otherRectangle.topLeftYPos)
            return true;
        else
            return false;
    }
}

module.exports = Rectangle;

//tests
let rect1 = new Rectangle(6,6,3,2);
let rect2 = new Rectangle(100,100, 5, 5);
let rect3 = new Rectangle(5,6,3,2);

console.log("Rect1 vs Rect2: (false)" + rect1.collides(rect2));
console.log("Rect1 vs Rect3: (true) " + rect1.collides(rect3));
console.log("Rect2 vs Rect3: (false) " + rect2.collides(rect3));