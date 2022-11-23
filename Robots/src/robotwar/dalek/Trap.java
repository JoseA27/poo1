package robotwar.dalek;

import java.awt.Image;

import robotwar.common.robotbase.Weapon;

public class Trap {
	protected String ruta = "C:\\Users\\josea\\Desktop\\Imagenes poo\\";
	protected Image imagen;
	protected int posX;
	protected int posY;
	protected int height;
	protected int width;
	protected int level;

	public Trap() {
		
	}
	public Trap(int x, int y, int pHeight, int pWidth, int pLevel) {
		setPosX(x);
		setPosY(y);
		setHeight(pHeight);
		setWidth(pWidth);
		setLevel(pLevel);
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public Image getImagen() {
		return imagen;
	}
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
	
}
