import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

/******************概要*********************/
/*Meiro.csvを読み込んで迷路を表示する      */
/*0が通路、1が壁、2がプレイヤー、3がゴール */
/*キーボード操作により2を動かせるようにする*/
/*1は壁なのでそれ以上進めないようにする    */
/*******************************************/

/*****************やることメモ*******************/
/*csvのデータを配列に入れて、キャンバスに表示   */
/*データの数字によって背景色を変化させる        */
/*キーリスナを追加してキーボード操作を可能にする*/
/************************************************/

public class Meiro extends JFrame implements KeyListener{

	JLabel Titlelb;

	String hairetu[][];//csvのデータを入れる配列
	int hairetuint[][];//csvデータをintに変換して格納する

	int key;
	int px,py;

	boolean flag=false;
	boolean hairetuflag[][]; //移動可能、不可の判定

	MyCanvas mc;
	Meiro(){
		setSize(500,500);
		setTitle("迷路ゲーム");
		setLayout(null);

		Titlelb=new JLabel("迷路ゲーム");
		Titlelb.setBounds(170,10,120,40);
		Titlelb.setHorizontalAlignment(JLabel.CENTER);
		Titlelb.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));

		hairetu=new String[17][13];
		hairetuint=new int[17][13];
		hairetuflag=new boolean[17][13];



		try{
			File f=new File("meiro.csv");
			BufferedReader br=new BufferedReader(new FileReader(f));

			String line=br.readLine();
			for(int i=0; line!=null; i++){
				hairetu[i]=line.split(",",0);
				line=br.readLine();
			}
			br.close();
		}catch(IOException er){
			System.out.println(er);
		}

		mc=new MyCanvas();
		mc.setBounds(42,50,400,350);
		add(Titlelb);
		add(mc);
		addKeyListener(this);

			/*for(int i=0; i<hairetu.length; i++){
				for(int j=0; j<hairetu[i].length; j++){
						py=i;
						px=j;
					hairetuint[i][j]=Integer.parseInt(hairetu[i][j]);
					hairetuint[py][px]=Integer.parseInt(hairetu[py][px]);
					//System.out.print(hairetuint[py][px]+" ");
				}
				//System.out.println("改行"+(py+1)+"回目");
			}*/
		}


	public void keyPressed(KeyEvent e){
		/*上38　左37　下40　右39*/
		key=e.getKeyCode();
		//System.out.println(key);


			for(py=0; py<hairetu.length; py++){
				for(px=0; px<hairetu[py].length; px++){
					if(key==38){
						if(hairetuint[py][px]==2 && hairetuint[py-1][px]==0){
							hairetuint[py][px]=0;
							hairetuint[py-1][px]=2;
							hairetu[py][px]=String.valueOf(hairetuint[py][px]);
							hairetu[py-1][px]=String.valueOf(hairetuint[py-1][px]);
							key=0;
							mc.repaint();
						}
					}
				}
			}


			for(py=0; py<hairetu.length; py++){
				for(px=0; px<hairetu[py].length; px++){
					if(key==40){
						if(hairetuint[py][px]==2 && hairetuint[py+1][px]==0){
							hairetuint[py][px]=0;
							hairetuint[py+1][px]=2;
							hairetu[py][px]=String.valueOf(hairetuint[py][px]);
							hairetu[py+1][px]=String.valueOf(hairetuint[py+1][px]);
							key=0;
							mc.repaint();
						}
						if(hairetuint[py][px]==2 && hairetuint[py+1][px]==3){
							hairetuint[py][px]=0;
							hairetuint[py+1][px]=2;
							hairetu[py][px]=String.valueOf(hairetuint[py][px]);
							hairetu[py+1][px]=String.valueOf(hairetuint[py+1][px]);
							key=0;
							mc.repaint();
							flag=true;
						}
					}
				}
			}


			for(py=0; py<hairetu.length; py++){
				for(px=0; px<hairetu[py].length; px++){
					if(key==37){
						if(hairetuint[py][px]==2 && hairetuint[py][px-1]==0){
							hairetuint[py][px]=0;
							hairetuint[py][px-1]=2;
							hairetu[py][px]=String.valueOf(hairetuint[py][px]);
							hairetu[py][px-1]=String.valueOf(hairetuint[py][px-1]);
							key=0;
							mc.repaint();
						}
					}
				}
			}

			for(py=0; py<hairetu.length; py++){
				for(px=0; px<hairetu[py].length; px++){
					if(key==39){
						if(hairetuint[py][px]==2 && hairetuint[py][px+1]==0){
							hairetuint[py][px]=0;
							hairetuint[py][px+1]=2;
							hairetu[py][px]=String.valueOf(hairetuint[py][px]);
							hairetu[py][px+1]=String.valueOf(hairetuint[py][px+1]);
							key=0;
							mc.repaint();
						}
					}
				}
			}

		}

	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}

	public class MyCanvas extends Canvas{
		public void paint(Graphics g){
			//setBackground(Color.white);
/****************************************ブロック・数字描画開始****************************************/
			int bx=0;
			int by=0;
			int y=14;

			//1.今の配列の[x][y]の位置から、可能な方向を求める

			//2.そのキーで移動可能であれば、移動させる。

			//0であれば移動可能、1であれば移動不可の判定

			for(int i=0; i<hairetu.length; i++){
				bx=0;
				int x=11;
				for(int j=0; j<hairetu[i].length; j++){
					hairetuint[i][j]=Integer.parseInt(hairetu[i][j]);
					//System.out.print(hairetuint[i][j]+" ");

					if(hairetuint[i][j]==0){
						g.setColor(Color.white);
						g.fillRect(bx,by,29,19);
					}else if(hairetuint[i][j]==1){
						g.setColor(Color.orange);
						g.fillRect(bx,by,29,19);
					}else if(hairetuint[i][j]==2){
						g.setColor(Color.red);
						g.fillRect(bx,by,29,19);
					}else if(hairetuint[i][j]==3){
						g.setColor(Color.green);
						g.fillRect(bx,by,29,19);
					}
					py=i;
					px=j;
					bx+=30;
					g.setColor(Color.black);
					g.drawString(hairetu[i][j],x,y);
					x+=30;
				}
				//System.out.println("改行"+(i+1)+"回目");
				y+=20;
				by+=20;
			}

			if(flag==true){
				Font font1 = new Font("ＭＳ Ｐゴシック",Font.BOLD,30);
				g.setFont(font1);
				g.drawString("Game Clear!!",110,170);
			}
/****************************************ブロック・数字描画終了****************************************/
		}	//void paint終わり
	}	//Canvas終わり


	public static void main(String args[]){
		Meiro m=new Meiro();
		m.setVisible(true);
	}
}