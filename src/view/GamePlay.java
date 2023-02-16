package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.*;
import model.*;
import nhandang.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import org.opencv.videoio.VideoCapture;

public class GamePlay extends JFrame implements ActionListener, KeyListener {
	private RoadRace road = new RoadRace(20, 0, 600, 750, 3);
	private Handling handling = new Handling(road, new Car(200, 670, 50, 80, 15));

	private String imageCar = "image/Capture.PNG";
	private String imageBreak = "image/tải xuống.jpg";

	private int score;
	private String text = "Play";

	DataInputStream dis;

	private Timer timer;
	private int i = 0;
	private SURFDetection frame;

	public GamePlay() {
		try {
			Socket socket = new Socket("localhost", 12345);
			dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.setTitle("Car Racing");
//		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 50, 1000, 900);
		this.getContentPane().setBackground(Color.black);
		this.addKeyListener(this);

		timer = new Timer(50, this);
		timer.start();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
//		this.getContentPane().setBackground(Color.black);

		g.setColor(Color.gray);
		g.fillRect(handling.getRoadRace().getxRoadRace(), handling.getRoadRace().getyRoadRace(),
				handling.getRoadRace().getWidthRoadRace(), handling.getRoadRace().getHeightRoadRace());

		for (int i = 0; i < handling.getArrobstacles().size(); i++) {

			ImageIcon iconBreak = new ImageIcon(imageBreak);
			Image imgBreak = iconBreak.getImage();
			g.drawImage(imgBreak, handling.getArrobstacles().get(i).getxObstacles(),
					handling.getArrobstacles().get(i).getyObstacles(),
					handling.getArrobstacles().get(i).getxObstacles()
							+ handling.getArrobstacles().get(i).getWidthObstacles() + 50,
					handling.getArrobstacles().get(i).getyObstacles()
							+ handling.getArrobstacles().get(i).getHeightObstacles() + 80,
					50, 50, 400, 400, null);
		}
		ImageIcon iconCar = new ImageIcon(imageCar);
		Image imgCar = iconCar.getImage();
		g.drawImage(imgCar, handling.getCar().getxCar(), handling.getCar().getyCar(),
				handling.getCar().getxCar() + handling.getCar().getWidthCar(),
				handling.getCar().getyCar() + handling.getCar().getHeightCar(), 10, 20, 180, 300, null);

		g.setColor(Color.red);
		g.setFont(new Font(Font.SERIF, Font.BOLD, 50));
		g.drawString(text, 700, 200);
		g.drawString(this.handling.getScore() + "", 700, 250);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		handling.moveob();
		if (handling.collision() == true) {
			timer.stop();
			text = "Game over";
		}
		try {
			if (dis.readInt() == 0)
				handling.moveCar(0);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (dis.readInt() == 1)
				handling.moveCar(1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			handling.moveCar(0);
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			handling.moveCar(1);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new GamePlay();
//		EventQueue.invokeLater(new Runnable() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//					SURFDetection frame = new SURFDetection();
//					frame.setVisible(true);
//					
//					System.out.println(frame.getGiaTri0());
//					
//				} catch (Exception e) {
//					// TODO: handle exception
//					e.printStackTrace();
//				}
//			}
//		});
	}
}
