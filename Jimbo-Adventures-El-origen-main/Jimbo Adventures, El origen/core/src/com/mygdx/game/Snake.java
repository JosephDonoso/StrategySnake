package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

public class Snake {
	private final int up = 1;
	private final int down = -1;
	
	private final int left = 2;
	private final int right = -2;
	private final int stop = 0;
	
	private int vidas = 3;
	private int dir;
	private float vel = 10; //Del 1 al 100
	private BodySnake body;
	
	public Snake(float x, float y, Texture tx, World world) {
		body = new BodySnake(x, y, tx, world);
		dir = stop;
	}
	
	public void draw(SpriteBatch batch) {
		if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) moverLeft();
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) moverRight();
    	if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) moverDown();     
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) moverUp();
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) agregarCola();
        
        if(dir != stop) 
        	dir = body.mover(vel, dir, batch); //Se actualiza automáticamente si está en el borde
	}
	
	public void agregarCola() {
		body.agregarCola(dir);
	}
	
	public void eliminarCola() {
		body.eliminarCola();
	}
	
	public void moverLeft(){
		if(dir != right) {
			dir = left;
		}
	}
	
	public void moverRight(){
		if(dir != left) {
			dir = right;
		}
	}
	
	public void moverDown(){
		if(dir != up) {
			dir = down;
		}
	}
	
	public void moverUp(){
		if(dir != down) {
			dir = up;
		}
	}
	
	//Retorna true si ya no quedan vidas
	public boolean quitarVida() {
		vidas -=1;
		return !tieneVidas();
	}
	
	public void darVida() {
		vidas += 1;
	}
	
	public boolean tieneVidas() {
		if(vidas == 0)
			return false;
		return true;
	}
	
	public int getVidas() {
		return vidas;
	}
    
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	public int getDir(){
		return dir;
	}
	
	public void setDir(int dir){
		this.dir = dir;
	}
	
	public float getVel(){
		return vel;
	}
	
	public void setVel(float vel){
		this.vel = vel;
	}
}
