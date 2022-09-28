import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.io.*;

class Client_Productlist extends JFrame{

	Object[][] data;
	String[] columns={"商品名","単価","数量"};

	JLabel titlelb;
	JTable tb;
	JScrollPane sc;
	DefaultTableModel model;

	FileInputStream fi=null;
	InputStreamReader is=null;
	BufferedReader br=null;


	Client_Productlist(){
		setSize(500,400);
		setTitle("データ一覧");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		//-----------データ読み込み-----------
		try{
		fi=new FileInputStream("product.txt");
		is=new InputStreamReader(fi);
		br=new BufferedReader(is);

		String line;

		int count=0;

		data=new Object[50][columns.length];

		while((line=br.readLine()) != null){
			String[] Sdata=line.split(",");
			for (int i=0; i<columns.length; i++){
				//System.out.println(Sdata[i]);
				data[count][i]=Sdata[i];
			}
			count++;
		}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				br.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//-------------ここまで---------------




		titlelb=new JLabel("データ一覧");
		titlelb.setBounds(150,40,150,50);
		titlelb.setHorizontalAlignment(JLabel.CENTER);
		titlelb.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));


		model=new DefaultTableModel(data,columns);
		tb=new JTable(model);
		//tb.setBounds(40,100,200,200);
		sc=new JScrollPane(tb);
		sc.setBounds(40,100,400,200);

		add(titlelb);
		add(sc);



	}

	public static void main(String args[]){
		Client_Productlist cpl=new Client_Productlist();
		cpl.setVisible(true);


	}
}