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

    toString(){
        let toRet = "Pizza " + this.getName + ":\n { ";
        topings.forEach(toping => {
            toRet += toping + ", ";
        });
        toRet += "}\n Price: " + this.getPrice + "€";
        return toRet;
    }
}

module.exports.Pizza