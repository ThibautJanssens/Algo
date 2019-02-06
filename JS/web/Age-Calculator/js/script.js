//const
const months = ["January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"
];

//variables
var option, i;
var daysOld, monthsOld, yearsOld;

//getting current date (month/day/year)
let currentDate = new Date(Date.now());
let currentMonth = currentDate.getMonth()+1;
let currentDay = currentDate.getDate();
let currentYear = currentDate.getFullYear();

//getting elements from html page
var yearSelect = document.getElementById("year");
var monthSelect = document.getElementById("month");
var daySelect = document.getElementById("day");

//generate year and push them in option (from 1900 to currentYear)
for (i = 1900; i <= currentYear; i++) {
    option = document.createElement("option");
    option.text = String(i);
    yearSelect.add(option, yearSelect[0]);
}

//generate month and push them in option
for (i = 11; i >= 0; i--) {
    option = document.createElement("option");
    option.text = months[i];
    monthSelect.add(option, monthSelect[0]);
}

newMonth();

function newYear(){
    newMonth();
    calcAge();
}

//generate day when month is changed on the front page
function newMonth() {
    var nbrOfDays;

    var selector = document.getElementById("month");
    var value = selector[selector.selectedIndex].value;
    daySelect.options.length = 0;

    var nbrOfDays = getNbrOfDays(value);

    for (i = nbrOfDays; i > 0; i--) {
        option = document.createElement("option");
        option.text = String(i);
        daySelect.add(option, daySelect[0]);
    }
    calcAge();
}

function newDay(){
    calcAge();
}

function calcAge() {
    //get month in select and convert it to int
    var monthSelector = document.getElementById("month"); 
    var monthValue = monthSelector[monthSelector.selectedIndex].value;

    var monthInt = monthToInt(monthValue);

    //convert current month to int
    var currentMonthInt = monthToInt(currentMonth);
    
    //get the day in the select
    var daySelector = document.getElementById("day");
    var dayValue = daySelector[daySelector.selectedIndex].value;
    
    //get the year in the select
    var yearSelector = document.getElementById("year");
    var yearValue = yearSelector[yearSelector.selectedIndex].value;

    //todo verify days, then month then year
    currentTotal = parseInt(currentYear) * 10000 + parseInt(currentMonth) * 100 + parseInt(currentDay);
    total = yearValue * 10000 + monthInt * 100 + dayValue;
    console.log(currentTotal);
    console.log(total);
    yearsOld = Math.floor((currentTotal - total) / 10000);

    //display the age
    document.getElementById("age").innerHTML = "You currently are " + yearsOld + " years old.";
}

function monthToInt(monthString) {
    var nbr;
    switch (monthString) {
        case "January":
            nbr = 1;
            break;
        case "February":
            nbr = 2;
            break;
        case "March":
            nbr = 3;
            break;
        case "April":
            nbr = 4;
            break;
        case "May":
            nbr = 5;
            break;
        case "June":
            nbr = 6;
            break;
        case "July":
            nbr = 7;
            break;
        case "August":
            nbr = 8;
            break;
        case "September":
            nbr = 9;
            break;
        case "October":
            nbr = 10;
            break;
        case "November":
            nbr = 11;
            break;
        case "December":
            nbr = 12;
            break;
    }
    return nbr;
}

function getNbrOfDays(monthString){
    var nbrOfDays;
    switch (monthString) {
        case "January":
        case "March":
        case "May":
        case "July":
        case "August":
        case "October":
        case "December":
            nbrOfDays = 31;
            break;
        case "February":
            if(document.getElementById("year").value % 4 == 0)
                nbrOfDays = 29;
            else
                nbrOfDays = 28;
            break;
        case "April":
        case "June":
        case "September":
        case "November":
            nbrOfDays = 30;
            break;
    }
    return nbrOfDays;
}
