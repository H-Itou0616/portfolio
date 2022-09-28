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

/******************�T�v*********************/
/*Meiro.csv��ǂݍ���Ŗ��H��\������      */
/*0���ʘH�A1���ǁA2���v���C���[�A3���S�[�� */
/*�L�[�{�[�h����ɂ��2�𓮂�����悤�ɂ���*/
/*1�͕ǂȂ̂ł���ȏ�i�߂Ȃ��悤�ɂ���    */
/*******************************************/

/*****************��邱�ƃ���*******************/
/*csv�̃f�[�^��z��ɓ���āA�L�����o�X�ɕ\��   */
/*�f�[�^�̐����ɂ���Ĕw�i�F��ω�������        */
/*�L�[���X�i��ǉ����ăL�[�{�[�h������\�ɂ���*/
/************************************************/

public class Meiro extends JFrame implements KeyListener{

	JLabel Titlelb;

	String hairetu[][];//csv�̃f�[�^������z��
	int hairetuint[][];//csv�f�[�^��int�ɕϊ����Ċi�[����

	int key;
	int px,py;

	boolean flag=false;
	boolean hairetuflag[][]; //�ړ��\�A�s�̔���

	MyCanvas mc;
	Meiro(){
		setSize(500,500);
		setTitle("���H�Q�[��");
		setLayout(null);

		Titlelb=new JLabel("���H�Q�[��");
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
				//System.out.println("���s"+(py+1)+"���");
			}*/
		}


	public void keyPressed(KeyEvent e){
		/*��38�@��37�@��40�@�E39*/
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
/****************************************�u���b�N�E�����`��J�n****************************************/
			int bx=0;
			int by=0;
			int y=14;

			//1.���̔z���[x][y]�̈ʒu����A�\�ȕ��������߂�

			//2.���̃L�[�ňړ��\�ł���΁A�ړ�������B

			//0�ł���Έړ��\�A1�ł���Έړ��s�̔���

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
				//System.out.println("���s"+(i+1)+"���");
				y+=20;
				by+=20;
			}

			if(flag==true){
				Font font1 = new Font("�l�r �o�S�V�b�N",Font.BOLD,30);
				g.setFont(font1);
				g.drawString("Game Clear!!",110,170);
			}
/****************************************�u���b�N�E�����`��I��****************************************/
		}	//void paint�I���
	}	//Canvas�I���


	public static void main(String args[]){
		Meiro m=new Meiro();
		m.setVisible(true);
	}
}