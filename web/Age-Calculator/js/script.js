//const
const currentYear = 2019;
const months = ["January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"];

//variables
var option, i;

//getting elements from html page
var yearSelect = document.getElementById("year");
console.log(yearSelect);
var monthSelect = document.getElementById("month");
var daySelect = document.getElementById("day");

//generate year and push them in option (from 1900 to currentYear)
for(i = 1900; i <= currentYear; i++){
    option = document.createElement("option");
    option.text = String(i);
    yearSelect.add(option, yearSelect[0]);   
}

//generate month and push them in option
for(i = 12; i > 0; i--){
    option = document.createElement("option");
    option.text = months[i];
    monthSelect.add(option, monthSelect[0]);
}

//generate day