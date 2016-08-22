/**
 *  Main program for PLJS
 *
 *	@author procsynth - Antoine Pintout
 *	@since  22-08-2016`
 */

package procsynth.pljs;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptContext;
import javax.script.ScriptException;
import javax.script.Invocable;

import java.lang.NoSuchMethodException;
import java.lang.reflect.*;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import processing.core.PApplet;

public class ProcessingLiveJS extends PApplet{

	public static String VERSION = "0.1";

	private static final String[] MAIN_WINDOW = new String[] { "procsynth.pljs.ProcessingLiveJS" };

	private static String scriptPath = null;
	private static boolean opening = false;

	private static ScriptEngineManager engineManager;
	private static ScriptEngine nashorn;

	public static void main(String[] args) {
		PApplet.main(MAIN_WINDOW);
	}

	public void settings() {
		size(800, 600, PApplet.P3D);
	}

	public void setup() {
		println("PLJS "+ VERSION + " / procsynth");
		frameRate(50);
		surface.setResizable(true);

		engineManager = new ScriptEngineManager();
		nashorn = engineManager.getEngineByName("nashorn");

		try{
			Object global = nashorn.eval("this");
			Object jsObject = nashorn.eval("Object");
			// calling Object.bindProperties(global, this);
			// which will "bind" properties of the PApplet object
			((Invocable)nashorn).invokeMethod(jsObject, "bindProperties", global, (PApplet)this);
			nashorn.eval("function define(varname, val){if(typeof this[varname] == 'undefined')this[varname] = val;}");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void draw() {
		if(scriptPath == null && !opening){
			opening = true;
			selectInput("Select script to live from", "openFile");
		}else if(scriptPath != null){
			try{
				nashorn.eval(readFile(scriptPath));
				nashorn.eval("loop()");
			}catch (ScriptException e) {
				println("error in the loop function");
				background(0);	
				text(e.getMessage(), 20, 30);
				e.printStackTrace();		
			}catch (Exception e) {
				println("no `loop` function found!");
			}
		}else{
			// waiting for file;
			background(0);
			text("PLJS", 20, 30);
			text("PROCSYNTH 2016", 20, 50);
			text("WAITING FOR FILE...", 20, 70);
		}
	}

	public void openFile(File file){
		if(file != null){
			String filepath = file.getAbsolutePath();
			try{
				if(file.isFile()){
					String source = readFile(filepath);
					scriptPath = filepath;
				}
			}catch(Exception i){
				i.printStackTrace();
				opening = false;
				scriptPath = null;
				return;
			}
		}else{
			opening = false;
			scriptPath = null;
		}
	}

	public static String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, StandardCharsets.UTF_8);
	}

}