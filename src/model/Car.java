package model;

public class Car {
	private int xCar;
	private int yCar;
	private int widthCar;
	private int heightCar;
	private int speed;

	public int getxCar() {
		return xCar;
	}

	public void setxCar(int xCar) {
		this.xCar = xCar;
	}

	public int getyCar() {
		return yCar;
	}

	public void setyCar(int yCar) {
		this.yCar = yCar;
	}

	public int getWidthCar() {
		return widthCar;
	}

	public void setWidthCar(int widthCar) {
		this.widthCar = widthCar;
	}

	public int getHeightCar() {
		return heightCar;
	}

	public void setHeightCar(int heightCar) {
		this.heightCar = heightCar;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Car(int xCar, int yCar, int widthCar, int heightCar, int speed) {
		super();
		this.xCar = xCar;
		this.yCar = yCar;
		this.widthCar = widthCar;
		this.heightCar = heightCar;
		this.speed = speed;
	}

	

}
