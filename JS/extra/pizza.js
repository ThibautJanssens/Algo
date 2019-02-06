class Pizza{
    constructor(name, topings, price){
        this.name = name;
        this.topings = topings;
        this.price = price;
    }

    get getName(){
        return this.name;
    }

    get getTopings(){
        return this.topings;
    }

    get getPrice(){
        return this.price;
    }

    show(){
        let toRet = "Pizza " + this.getName + ":\n { ";
        for(var i = 0; i < this.topings.length; i++){
            toRet += this.topings[i] + ", ";
        }
        toRet += "}\n Price: " + this.getPrice + "€";
        return toRet;
    }
}

module.exports = Pizza;