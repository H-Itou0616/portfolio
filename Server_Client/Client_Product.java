import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;

public class Client_Product extends JFrame implements ActionListener{

	JLabel Titlelb,syouhinmeilb,tankalb,suuryoulb;
	JButton tourokubtn;
	JTextField syouhinmeitf,tankatf,suuryoutf;
	JPanel p;
	String syouhinmei,tanka,suuryou;

	Client_Product(){
		setSize(500,400);
		setTitle("商品登録フォーム");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		Titlelb=new JLabel("商品登録フォーム");
		Titlelb.setBounds(135,30,200,40);
		Titlelb.setHorizontalAlignment(JLabel.CENTER);
		Titlelb.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));

		syouhinmeilb=new JLabel("商品名");
		syouhinmeilb.setBounds(0,100,200,40);
		syouhinmeilb.setHorizontalAlignment(JLabel.CENTER);
		syouhinmeilb.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));

		tankalb=new JLabel("単価");
		tankalb.setBounds(0,160,200,40);
		tankalb.setHorizontalAlignment(JLabel.CENTER);
		tankalb.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));

		suuryoulb=new JLabel("数量");
		suuryoulb.setBounds(0,220,200,40);
		suuryoulb.setHorizontalAlignment(JLabel.CENTER);
		suuryoulb.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));

		tourokubtn=new JButton("登録する");
		tourokubtn.setBounds(50,300,100,30);
		tourokubtn.setHorizontalAlignment(JButton.CENTER);
		tourokubtn.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));

		/*endbtn=new JButton("終　了");
		endbtn.setBounds(250,300,100,30);
		endbtn.setHorizontalAlignment(JButton.CENTER);
		endbtn.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));*/

		syouhinmeitf=new JTextField(10);
		syouhinmeitf.setBounds(180,105,200,30);

		tankatf=new JTextField(10);
		tankatf.setBounds(180,165,200,30);

		suuryoutf=new JTextField(10);
		suuryoutf.setBounds(180,225,200,30);

		add(Titlelb);
		add(syouhinmeilb);
		add(tankalb);
		add(suuryoulb);
		add(tourokubtn);
		//add(endbtn);
		add(syouhinmeitf);
		add(tankatf);
		add(suuryoutf);

		tourokubtn.addActionListener(this);


		//p=new JPanel();
		//p.setBounds(0,0,500,500);
		//p.add(Titlelb);
		//getContentPane().add(p,BorderLayout.CENTER);




	}


	public void actionPerformed(ActionEvent ev){

		if(ev.getSource()==tourokubtn){
			syouhinmei=syouhinmeitf.getText();
			tanka=tankatf.getText();
			suuryou=suuryoutf.getText();

			try{
				Socket tushin;
				tushin=new Socket("192.168.0.28",1234);

				//受け取り
				BufferedReader b_in;
				b_in=new BufferedReader(new InputStreamReader(tushin.getInputStream()));
				//String line;
				//line=b_in.readLine();
				//System.out.println(line);

				//送り
				PrintStream p_out=new PrintStream(tushin.getOutputStream());
				//p_out.println("クライアントからデータを受信しました");
				p_out.println(syouhinmei+","+tanka+","+suuryou);
				System.out.println(syouhinmei+" "+tanka+" "+suuryou);



				b_in.close();
				p_out.close();
				tushin.close();

				JOptionPane.showMessageDialog(null,"商品を登録しました","完了",JOptionPane.INFORMATION_MESSAGE);

			}catch(IOException e){
			}
		}
	}
	public static void main(String args[]){
		Client_Product cp=new Client_Product();
		cp.setVisible(true); 
	}
}