import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class object extends JPanel implements KeyListener {
	public static JFrame frame = new JFrame();
	public static JTextField field = new JTextField();
	public JLabel l1;
	
	public void createFrame() {
		frame.setSize(new Dimension(900,700));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		l1 = new JLabel();
		l1.setBounds(new Rectangle(50,500,200,100));
		l1.setText("<html><font size = '100'; color = 'red'>Zoom in : D</font></html>");
		
		this.setLayout(null);
		
		field.addKeyListener(this);
		this.add(field);
		
		
		frame.setBackground(Color.BLACK);
		frame.add(this);
		frame.setVisible(true);
		
	}
	

	
	private static int[][] pointX = {
									{100,150,350,300    },
									{300,300,350,350},
									{100,100,150,150},
									{100,100,300,300},
									{100,150,350,300}
			
									};
	private static int[][] pointY = {
			
			
									{300,250,250,300 },
									{500,300,250,450},
									{500,300,250,450},
									{500,300,300,500},
									{500,450,450,500}
									
									
									};
	
	int[] rect1;
	
	public void paintComponent(Graphics g) {
		if(position ==1) {
			super.paintComponent(g);
			Graphics2D gg = (Graphics2D) g;
			g.setColor(Color.black);
			g.fillRect(0, 0, 1000, 1000);
			g.setColor(new Color(147,132,132));
			Polygon bot = new Polygon(pointX[4],pointY[4],4);
			gg.fill(bot);
			g.setColor(Color.BLACK);
			gg.draw(bot);
			Polygon pol2 = new Polygon(pointX[1],pointY[1],4);
			g.setColor(new Color(147,132,132));
			gg.fill(pol2);
			g.setColor(Color.BLACK);
			gg.draw(pol2);
			g.setColor(new Color(147,132,132));
			Polygon pol3 = new Polygon(pointX[2],pointY[2],4);
			gg.fill(pol3);
			g.setColor(Color.BLACK);
			gg.draw(pol3);
			Polygon r = new Polygon(pointX[3],pointY[3],4);
			g.setColor(new Color(147,132,132));
			gg.fill(r);
			g.setColor(Color.black);
			gg.draw(r);
			g.setColor(new Color(147,132,132));
			Polygon pol1 = new Polygon(pointX[0],pointY[0], 4);
			gg.fill(pol1);
			g.setColor(Color.BLACK);
			gg.draw(pol1);
		}
		else if(position == 2) {
			super.paintComponent(g);
			Graphics2D gg = (Graphics2D) g;
			g.setColor(Color.black);
			g.fillRect(0, 0, 1000, 1000);
			g.setColor(new Color(147,132,132));
			Polygon pol1 = new Polygon(pointX[0],pointY[0], 4);
			gg.fill(pol1);
			g.setColor(Color.BLACK);
			gg.draw(pol1);
			Polygon pol2 = new Polygon(pointX[1],pointY[1],4);
			g.setColor(new Color(147,132,132));
			gg.fill(pol2);
			g.setColor(Color.BLACK);
			gg.draw(pol2);
			g.setColor(new Color(147,132,132));
			Polygon pol3 = new Polygon(pointX[2],pointY[2],4);
			gg.fill(pol3);
			g.setColor(Color.BLACK);
			gg.draw(pol3);
			Polygon r = new Polygon(pointX[3],pointY[3],4);
			g.setColor(new Color(147,132,132));
			Polygon bot = new Polygon(pointX[4],pointY[4],4);
			gg.fill(bot);
			g.setColor(Color.BLACK);
			gg.draw(bot);
			g.setColor(new Color(147,132,132));
			gg.fill(r);
			g.setColor(Color.black);
			gg.draw(r);
			
		}
	}
	
	
	public static boolean running = true;
	private static int position = 1;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == 37) {
			for(int i =0;i<pointX.length;i++) {
				
				for(int j = 0;j<pointX[i].length;j++) {
					pointX[i][j] += 10;
				}
			}
			pointX[0][1] -=2;
			pointX[0][2] -=2;
			pointX[1][2] -=2;
			pointX[1][3] -= 2;
			pointX[2][2] -= 2;
			pointX[2][3] -= 2;
			pointX[4][1] -= 2;
			pointX[4][2] -= 2;
		}
		
		if(code ==39) {
			for(int i =0;i<pointX.length;i++) {
				
				for(int j = 0;j<pointX[i].length;j++) {
					pointX[i][j] -= 10;
				}
			}
			pointX[0][1] +=2;
			pointX[0][2] +=2;
			pointX[1][2] +=2;
			pointX[1][3] += 2;
			pointX[2][2] += 2;
			pointX[2][3] += 2;
			pointX[4][1] += 2;
			pointX[4][2] += 2;
		}
		if(code == KeyEvent.VK_S) {
			for(int i =0;i<pointX.length;i++) {
				
				for(int j = 0;j<pointX[i].length;j++) {
					if((i == 0 )||(i == 3)||(i == 4)) {
						if((j == 0)||(j == 1)) {
							pointX[i][j] +=2;
						}
						else if((j == 2)||(j == 3)) {
							pointX[i][j] -=2;
						}
					}
					else if(i == 1) {
						if((j == 0)||(j == 1)) {
							pointX[i][j] -=2;
						}
						else if((j == 2)||(j == 3)) {
							pointX[i][j] -=2;
						}
					}else {
						if((j == 0)||(j == 1)) {
							pointX[i][j] +=2;
						}
						else if((j == 2)||(j == 3)) {
							pointX[i][j] +=2;
						}
					}
				}
			}
			for(int i= 0;i<pointY.length;i++) {
				for(int j = 0;j<pointY[i].length;j++) {
					if( i ==0) {
						if((j == 1)||(j == 2)) {
							pointY[i][j] +=2;
						}
						else if((j == 0)||(j == 3)) {
							pointY[i][j] +=2;
						}
					}
					else {
						if( i == 4) {
							if(position == 1) {
								if((j == 1)||(j == 2)) {
									pointY[i][j] -=2;
								}
								else if((j == 0)||(j == 3)) {
									pointY[i][j] -=2;
								}
							}
							else {
								if((j == 1)||(j == 2)) {
									pointY[i][j] -=2;
								}
								else if((j == 0)||(j == 3)) {
									pointY[i][j] -=2;
								}
							}
						}else {
							if((j == 1)||(j == 2)) {
								pointY[i][j] +=2;
							}
							else if((j == 0)||(j == 3)) {
								pointY[i][j] -=2;
							}
						}
					}
				}
				
				
				
			}
		}
		if(code == KeyEvent.VK_D) {
				for(int i =0;i<pointX.length;i++) {
				
				for(int j = 0;j<pointX[i].length;j++) {
					if((i == 0 )||(i == 3)||(i == 4)) {
						if((j == 0)||(j == 1)) {
							pointX[i][j] -=2;
						}
						else if((j == 2)||(j == 3)) {
							pointX[i][j] +=2;
						}
					}
					else if(i == 1) {
						if((j == 0)||(j == 1)) {
							pointX[i][j] +=2;
						}
						else if((j == 2)||(j == 3)) {
							pointX[i][j] +=2;
						}
					}else {
						if((j == 0)||(j == 1)) {
							pointX[i][j] -=2;
						}
						else if((j == 2)||(j == 3)) {
							pointX[i][j] -=2;
						}
					}
				}
			}
			for(int i= 0;i<pointY.length;i++) {
				for(int j = 0;j<pointY[i].length;j++) {
					if( i ==0) {
						if((j == 1)||(j == 2)) {
							pointY[i][j] -=2;
						}
						else if((j == 0)||(j == 3)) {
							pointY[i][j] -=2;
						}
					}
					else {
						if(i == 4) {
							if(position == 1) {
								if((j == 1)||(j == 2)) {
									pointY[i][j] +=2;
								}
								else if((j == 0)||(j == 3)) {
									pointY[i][j] -=2;
								}
							}
							else {
								if((j == 1)||(j == 2)) {
									pointY[i][j] +=2;
								}
								else if((j == 0)||(j == 3)) {
									pointY[i][j] +=2;
								}
							}
							
						}
						else {
							if((j == 1)||(j == 2)) {
								pointY[i][j] -=2;
							}
							else if((j == 0)||(j == 3)) {
								pointY[i][j] +=2;
							}
						}
					}
				}
				
				
				
			}
		}
		if(code  == 38) {
			for(int i =0;i<pointY.length;i++) {
				
				for(int j = 0;j<pointY[i].length;j++) {
					pointY[i][j] += 10;
				}
			}
			pointY[0][1] -=5;
			pointY[0][2] -=5;
			pointY[1][2] -=5;
			pointY[1][3] -= 5;
			pointY[2][2] -= 5;
			pointY[2][3] -= 5;
			pointY[4][1] -= 5;
			pointY[4][2] -= 5;
			if(pointY[4][1] == pointY[3][0]) {
				position = 1;
			}
			
			
		}
		if(code == 40) {
			for(int i =0;i<pointY.length;i++) {
				
				for(int j = 0;j<pointY[i].length;j++) {
					pointY[i][j] -= 10;
				}
			}
			pointY[0][1] +=5;
			pointY[0][2] +=5;
			pointY[1][2] +=5;
			pointY[1][3] += 5;
			pointY[2][2] += 5;
			pointY[2][3] += 5;
			pointY[4][1] += 5;
			pointY[4][2] += 5;
			if(pointY[0][1] == pointY[3][1]) {
				position = 2;
			}
		}
		
		 
	}


	@Override
	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
