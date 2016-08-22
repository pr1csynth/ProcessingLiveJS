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