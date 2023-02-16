package nhandang;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import nhandang.SURFDetection.MyThread;

public class SURFDetection extends JFrame {
	private JPanel contentPane;
	private VideoCapture cap;
	
	private static int PORT = 12345;
	private DataOutputStream dos;

	public SURFDetection() {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			
			Socket socket = serverSocket.accept();
			
			dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 645, 510);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//		System.load("E:\\opencv4.4.0\\opencv\\build\\java\\x64opencv_java440.dll");
		cap = new VideoCapture();
		cap.open(0);
		new MyThread().start();

	}

	private static BufferedImage matToBufferdImage(Mat matrix) {
		try {
			MatOfByte mob = new MatOfByte();
			Imgcodecs.imencode(".jpg", matrix, mob);
			byte[] ba = mob.toArray();
			BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(ba));
			return bufferedImage;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void paint(Graphics g) {
		g = contentPane.getGraphics();
		Mat matrix = new Mat();
		cap.read(matrix);
		Rect rect = new Rect(0, 0, 600, 400);
		matrix = new Mat(matrix, rect);
		g.drawImage(matToBufferdImage(matrix), 0, 0, this);
//		System.out.println(matToBufferdImage(matrix));
		int p = matToBufferdImage(matrix).getRGB(300, 350);
		if (p > -6000000) {
			try {
				dos.writeInt(0);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(0);
		} else if (p > -13000000) {
			try {
				dos.writeInt(1);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(1);
		}
		
//		System.out.println(p);

	}

	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					SURFDetection frame = new SURFDetection();
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}

	class MyThread extends Thread {
		@Override
		public void run() {
			for (;;) {
				try {
					repaint();
					Thread.sleep(50);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
}
