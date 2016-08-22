// example.js

// Welcome to ProcessingLiveJS

/* PLJS is a live Processing interpreter that use Javascript.

Simply double click on the pljs.jar file and select a javascript file (like this one)

The file you selected will be read at each frame.
The sketch window is resizable by hand.

Only the draw function is supported at the moment.

The PApplet object is imported as p. That means that at the moment, every Processing method, field or constant should be 
prefixed by "p." :

	millis() 			=> p.millis()
	background() 		=> p.background()
	mouseX 				=> p.mouseX
	rectMode(CORNER) 	=> p.rectMode(p.CORNER) 

To print something in the console just use the`print` function : `print("Hello")`

Math function (sin, cos, asin, acos, tan, round, min, max, ...) is accessible with the Math object : 
	
	sin(i)	=> Math.sin(i)
	sin(i)	=> Math.sin(i)
	println(round(frameRate))) => print(Math.round(p.frameRate))

You can define variable outside the draw function using
	
	var myVariable;

But initializing variables with a value is a bit trickier at the moment :

	var hello = hello == undefined ? "world" : hello;

this initialize a variable `hello` with the value "world"

*/

var i = i == undefined ? 0 : i;

function draw(){

	if(p.frameCount % 100 == 0)
		print("FPS "+Math.round(p.frameRate))

	p.background(127+Math.cos(p.millis()/2000)*127, 0, 127+Math.sin(p.millis()/2000)*127)

	p.translate(p.width/2, p.height/2, 100)
	p.rotateX(p.millis()/500)
	p.rotateY(p.millis()/700)
	p.stroke(255)
	p.noFill()
	p.box(Math.abs(p.mouseX-p.width/2), Math.abs(p.mouseY-p.height/2), Math.sin(i/20)*300)

	i++;
}