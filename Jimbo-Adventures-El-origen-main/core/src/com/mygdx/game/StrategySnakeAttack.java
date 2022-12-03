package com.mygdx.game;

import java.util.ArrayList;

public interface StrategySnakeAttack {
	
	public float validarLadoSerpenteo(boolean stateSerpenteo);
	
	public float actualizarVelAcum(float velAcum);
	
	public boolean validarVelAcum(float vel, float velAcum);
	
	public int validarAleatoriaDir(int dir);
	
}
