package model;

public class RoadRace {
	private int xRoadRace;
	private int yRoadRace;
	private int widthRoadRace;
	private int heightRoadRace;
	private int numRaceLane;
	
	public RoadRace(int xRoadRace, int yRoadRace, int widthRoadRace, int heightRoadRace,int numRaceLane) {
		super();
		this.xRoadRace = xRoadRace;
		this.yRoadRace = yRoadRace;
		this.widthRoadRace = widthRoadRace;
		this.heightRoadRace = heightRoadRace;
		this.numRaceLane = numRaceLane;
	}
	public int getNumRaceLane() {
		return numRaceLane;
	}
	public void setNumRaceLane(int numRaceLane) {
		this.numRaceLane = numRaceLane;
	}
	public int getxRoadRace() {
		return xRoadRace;
	}
	public void setxRoadRace(int xRoadRace) {
		this.xRoadRace = xRoadRace;
	}
	public int getyRoadRace() {
		return yRoadRace;
	}
	public void setyRoadRace(int yRoadRace) {
		this.yRoadRace = yRoadRace;
	}
	public int getWidthRoadRace() {
		return widthRoadRace;
	}
	public void setWidthRoadRace(int widthRoadRace) {
		this.widthRoadRace = widthRoadRace;
	}
	public int getHeightRoadRace() {
		return heightRoadRace;
	}
	public void setHeightRoadRace(int heightRoadRace) {
		this.heightRoadRace = heightRoadRace;
	}
	
	

}
