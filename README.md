# ProcessingLiveJS

PLJS is an interface between Processing and a always refreshed Javascript file. PLJS uses the Nashorn script engine to manipulate Java's objects.

![screenshot from 2016-08-22 13-30-57](https://cloud.githubusercontent.com/assets/321345/17853432/b05113ba-686c-11e6-92d0-bea08a830032.png)


## USAGE

Simply download and run the [pljs.jar](https://github.com/procsynth/ProcessingLiveJS/raw/master/dist/pljs.jar) file and select a javascript file ([like the one in the example folder](https://raw.githubusercontent.com/procsynth/ProcessingLiveJS/master/examples/example.js), or at the bottom of this file).

__THIS REQUIRE JAVA 8.__

You don't need to have processing on your computer, all the magic is in the jar.

## WHAT TO EXPECT

The file you selected will be read each time you save it. (Auto-save plugin may exists for your text editor : [Auto-save for Sublime Text](https://packagecontrol.io/packages/auto-save).)
You will be able to do live coding on Processing.
The sketch window is resizable by hand.

Keep in mind this is an experiment made in less than 2 hours, you can quickly break it ! (Avoid redefining things!) Also some thing like `frameRate` won't work because the field has the same name as the method `frameRate()`.

## THINGS TO KNOW

The code you write in the JS file is executed as if it was in the `draw` block of a classic sketch.

The renderer is set to `P3D`.

You can define global variable the traditional way, but it will be reset at each draw. Instead use `define` :

```javascript
	define("variableName", initValue); 
```

### How the hell that's working ?

This is not a rewrite/reimplementation of Processing, all the functionalities as you know them are in. It uses the Nashorn Script Engine to import the Processing context in a Javascript Context. See Nashorh documentation here : [Oracle Nashorn: A Next-Generation JavaScript Engine for the JVM](http://www.oracle.com/technetwork/articles/java/jf14-nashorn-2126515.html)


## EXAMPLE

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
