package controller;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;



import model.Car;
import model.Obstacles;
import model.RoadRace;

public class Handling {

	private RoadRace roadRace;
	private ArrayList<Obstacles> arrobstacles = new ArrayList<Obstacles>();
	private Car car;
	private int score;
	
	public Handling(RoadRace roadRace,Car car) {
		this.roadRace = roadRace;
		this.car = car;

	}

	public void moveob() {
		Random rd = new Random();
		int x = rd.nextInt(roadRace.getNumRaceLane());
		for (int i = 0; i < roadRace.getNumRaceLane(); i++) {
			if (i == x) {
				if (arrobstacles.size() == 0)
					arrobstacles.add(new Obstacles(
							roadRace.getxRoadRace() + (roadRace.getWidthRoadRace()) / roadRace.getNumRaceLane() * i, 10,
							100	, 50));
				else if (arrobstacles.get(arrobstacles.size() - 1).getyObstacles() > 200)
					arrobstacles.add(new Obstacles(
							roadRace.getxRoadRace() + (roadRace.getWidthRoadRace()) / roadRace.getNumRaceLane() * i, 10,
							100, 50));
			}
		}
		for (int i = 0; i < arrobstacles.size(); i++) {
			if (arrobstacles.get(i).getyObstacles() > 700) {
				arrobstacles.remove(i);
				score++;
			}
			arrobstacles.get(i).setyObstacles(arrobstacles.get(i).getyObstacles() + 5);

		}
	}

	public void moveCar(int x) {
		int speed = 0;
		if (x == 0) {
			speed = this.car.getSpeed();
			this.car.setxCar(this.car.getxCar() - speed);
		} else if (x == 1) {
			speed = this.car.getSpeed();
			this.car.setxCar(this.car.getxCar() + speed);
		}
		if(car.getxCar()<roadRace.getxRoadRace()) car.setxCar(roadRace.getxRoadRace());
		if((car.getxCar()+car.getWidthCar())>(roadRace.getxRoadRace()+roadRace.getWidthRoadRace())) car.setxCar(roadRace.getxRoadRace()+roadRace.getWidthRoadRace()-car.getWidthCar());

	}
	public boolean collision() {
		Rectangle rect = new Rectangle(car.getxCar(),car.getyCar(),car.getWidthCar(),car.getHeightCar());
		for(int i = 0;i<arrobstacles.size();i++) {
			Rectangle recti = new Rectangle(arrobstacles.get(i).getxObstacles(),arrobstacles.get(i).getyObstacles(),arrobstacles.get(i).getWidthObstacles(),arrobstacles.get(i).getHeightObstacles());

			if(rect.intersects(recti)) return true;
		}
		return false;
	}
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public RoadRace getRoadRace() {
		return roadRace;
	}

	public void setRoadRace(RoadRace roadRace) {
		this.roadRace = roadRace;
	}

	public ArrayList<Obstacles> getArrobstacles() {
		return arrobstacles;
	}

	public void setArrobstacles(ArrayList<Obstacles> arrobstacles) {
		this.arrobstacles = arrobstacles;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


	public static void main(String[] args) {

//		ObstaclesMove o1 = new ObstaclesMove(new RoadRace(12, 15, 300, 200, 3));
//		o1.move();
//		for(int i = 0;i<o1.getArrobstacles().size();i++) {
//			System.out.println(o1.getArrobstacles().get(i).getxObstacles());
//		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		System.out.println(arr.get(0));

	}

}
