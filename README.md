# ProcessingLiveJS

PLJS is a live Processing interpreter that use Javascript.

![screenshot from 2016-08-22 03-38-14](https://cloud.githubusercontent.com/assets/321345/17841546/efd0281c-6819-11e6-9e9b-d16ae0b278c7.png)

## USAGE

Simply download and run the [pljs.jar file](https://github.com/procsynth/ProcessingLiveJS/raw/master/dist/pljs.jar) and select a javascript file ([like the one in the example folder](https://raw.githubusercontent.com/procsynth/ProcessingLiveJS/master/examples/example.js), or at the bottom of this file).

__THIS REQUIRE JAVA 8.__

You don't need to have processing on your computer, all the magic is in the jar.

## WHAT TO EXPECT

The file you selected will be read each time you save it. (Auto-save plugin may exists for your text editor.)
You will be able to do live coding on Processing.
The sketch window is resizable by hand.

Only the `draw` function is supported at the moment. Your code should be inside the `draw` function.

Keep in mind this is an experiment made in less than 2 hours, you can quickly break it !

## THINGS TO KNOW

The PApplet object is imported as `p` That means that at the moment, every Processing method, field or constant should be 
prefixed by `p.` :
```javascript
	millis() 			=> p.millis()
	background() 		=> p.background()
	mouseX 				=> p.mouseX
	rectMode(CORNER) 	=> p.rectMode(p.CORNER) 
```
To print something in the console just use the`print` function : `print("Hello")`

Math function (sin, cos, asin, acos, tan, round, min, max, ...) is accessible with the `Math` object : 
```javascript
	sin(i)	=> Math.sin(i)
	sin(i)	=> Math.sin(i)
	println(round(frameRate))) => print(Math.round(p.frameRate))
```
You can define variable outside the draw function using
```javascript
	var myVariable;
```
But initializing variables with a value is a bit trickier at the moment :
```javascript
	var hello = hello == undefined ? "world" : hello;
```
this initialize a variable `hello` with the value "world"

### EXAMPLE

```javascript
	// example.js

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
```
