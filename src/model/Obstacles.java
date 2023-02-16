package model;

public class Obstacles {
	private int xObstacles;
	private int yObstacles;
	private int widthObstacles;
	private int heightObstacles;
	
	public Obstacles(int xObstacles, int yObstacles, int widthObstacles, int heightObstacles) {
		super();
		this.xObstacles = xObstacles;
		this.yObstacles = yObstacles;
		this.widthObstacles = widthObstacles;
		this.heightObstacles = heightObstacles;
	}

	public int getxObstacles() {
		return xObstacles;
	}

	public void setxObstacles(int xObstacles) {
		this.xObstacles = xObstacles;
	}

	public int getyObstacles() {
		return yObstacles;
	}

	public void setyObstacles(int yObstacles) {
		this.yObstacles = yObstacles;
	}

	public int getWidthObstacles() {
		return widthObstacles;
	}

	public void setWidthObstacles(int widthObstacles) {
		this.widthObstacles = widthObstacles;
	}

	public int getHeightObstacles() {
		return heightObstacles;
	}

	public void setHeightObstacles(int heightObstacles) {
		this.heightObstacles = heightObstacles;
	}
	
	

}
