// import some polyfill to ensure everything works OK
import "babel-polyfill"

// import bootstrap's javascript part
import 'bootstrap';

// import the style
import "./style.scss";

/*
  Put the JavaScript code you want below.
*/
import "./images"
/*import "./images/alpaga1.jpg";
import "./images/alpaga2.jpg";
import "./images/alpaga3.jpg";
import "./images/alpaga4.jpg";
import "./images/alpaga5.jpg";
import "./images/alpaga6.jpg";
import "./images/alpaga7.jpg";*/
let images = new Array();

images[0] = new Image();
images[0].src = 'images/alpaga1.jpg';
images[1] = new Image();
images[1].src = 'images/alpaga2.jpg';
images[2] = new Image();
images[2].src = 'images/alpaga3.jpg';
images[3] = new Image();
images[3].src = 'images/alpaga4.jpg';
images[4] = new Image();
images[4].src = 'images/alpaga5.jpg';
images[5] = new Image();
images[5].src = 'images/alpaga6.jpg';
images[6] = new Image();
images[6].src = 'images/alpaga7.jpg';