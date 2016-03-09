package br.edu.ifpi.associapp.modelo;

public class Coordenadas {
	private int latitude;
	private	int longitude;
	
	public Coordenadas(int latitude, int longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return this.latitude + "|" + this.longitude;
	}
}
