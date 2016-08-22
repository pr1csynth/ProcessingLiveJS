// exame.js

// Welcome to ocessingLiveJS

/* JS is a live ocessing intereter that use Javascri.

Simy double click on the js.jar file and select a javascri file (like this one)

The file you selected will be read at each frame.
The sketch window is resizable by hand.

*/

define("i", 0)

i++;

background(127+Math.cos(millis()/2000)*127, 0, 127+Math.sin(millis()/2000)*127)

translate(width/2, height/2, -100)
rotateX(millis()/3090)
rotateY(millis()/1000)
stroke(255)
noFill()
box(Math.abs(mouseX-width/2), Math.abs(mouseY-height/2), Math.sin(i/20)*300)