# ProcessingLiveJS

PLJS is a live Processing interpreter that use Javascript.

![screenshot from 2016-08-22 13-30-57](https://cloud.githubusercontent.com/assets/321345/17853432/b05113ba-686c-11e6-92d0-bea08a830032.png)


## USAGE

Simply download and run the [pljs.jar file](https://github.com/procsynth/ProcessingLiveJS/raw/master/dist/pljs.jar) and select a javascript file ([like the one in the example folder](https://raw.githubusercontent.com/procsynth/ProcessingLiveJS/master/examples/example.js), or at the bottom of this file).

__THIS REQUIRE JAVA 8.__

You don't need to have processing on your computer, all the magic is in the jar.

## WHAT TO EXPECT

The file you selected will be read each time you save it. (Auto-save plugin may exists for your text editor.)
You will be able to do live coding on Processing.
The sketch window is resizable by hand.

Keep in mind this is an experiment made in less than 2 hours, you can quickly break it ! (Avoid redefining things! )

## THINGS TO KNOW

The code you write in the JS file is like you're executing it in the draw.

You can define global variable the traditional way, it will be reset at each draw. Instead use `define` :

```javascript
	define("variableName", initValue); 
```



### EXAMPLE

```javascript
	// example.js

	define("i", 0)

	i++;

	background(127+Math.cos(millis()/2000)*127, 0, 127+Math.sin(millis()/2000)*127)

	translate(width/2, height/2, -100)
	rotateX(millis()/3090)
	rotateY(millis()/1000)
	stroke(255)
	noFill()
	box(Math.abs(mouseX-width/2), Math.abs(mouseY-height/2), Math.sin(i/20)*300)
```
