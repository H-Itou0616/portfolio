import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**********************************************************************/
/*�ǉ��{�^���c�f�[�^��ǉ����邽�߂̉�ʂ��J��                        */
/*�ҏW�{�^���c���ݕێ�����Ă���f�[�^��ҏW���邽�߂̉�ʂ��J��      */
/*�\���{�^���c���ݕێ�����Ă���f�[�^��\��                          */
/*�ۑ��{�^���c���ݕێ����Ă���f�[�^��Schedule.txt�Ƃ������O�ŕۑ�����*/
/*�J���{�^���cSchedule.txt�̓��e���J��                                */
/**********************************************************************/


public class Schedule extends JFrame implements ActionListener{

	JFrame tuika_frm,hensyu_frm,hyouji_frm;
	JLabel lb1;
	JButton tuika,hensyu,hyouji,hidari,migi,tuikabtn,kousinbtn,hozon,hiraku;
	int count=0;

	String data[][]=new String[20][7];
	String[] columnNames={"���t","�ꏊ","�J�n����","�I������","�o�^��","�V�[�N���b�g","���e"};

	JLabel tuikalb,hyoujilb,Placelb,StartTimelb,EndTimelb,Registerlb,Secretlb,naiyoulb,datalb,kensulb;
	JTextField Placetf,StartTimetf,EndTimetf,naiyoutf,tuikatf;
	JCheckBox SecretCh;

	String[] combodata={"A","B","C","D","E"};
	JComboBox Combo;

	boolean[] checkstatus=new boolean[20];

	Schedule(){

		setSize(300,380);
		setTitle("���j���[�F�t�H�[��");

		lb1=new JLabel("�X�P�W���[���Ǘ�");
		lb1.setFont(new Font(Font.DIALOG,Font.BOLD,20));

		tuika=new JButton("�ǉ�");
		hensyu=new JButton("�ҏW");
		hyouji=new JButton("�\��");
		hozon=new JButton("�ۑ�");
		hiraku=new JButton("�J��");

		setLayout(null);

		lb1.setBounds(50,20,200,50);
		tuika.setBounds(90,90,100,30);
		hensyu.setBounds(90,140,100,30);
		hyouji.setBounds(90,190,100,30);
		hozon.setBounds(90,240,100,30);
		hiraku.setBounds(90,290,100,30);

		add(lb1);
		add(tuika);
		add(hensyu);
		add(hyouji);
		add(hozon);
		add(hiraku);

//================================���ʂŎg������======================================

		Placelb=new JLabel("�ꏊ");
		StartTimelb=new JLabel("�J�n����");
		EndTimelb=new JLabel("�I������");
		Registerlb=new JLabel("�o�^�Җ�");
		Secretlb=new JLabel("�V�[�N���b�g");
		naiyoulb=new JLabel("���e");
		kensulb=new JLabel((count+1)+"/20");

		Placetf=new JTextField(20);
		StartTimetf=new JTextField(5);
		EndTimetf=new JTextField(5);
		naiyoutf=new JTextField(100);

		hidari=new JButton("��");
		migi=new JButton("��");

		SecretCh=new JCheckBox();
		Combo=new JComboBox(combodata);
		Combo.setSelectedIndex(0);

//====================================================================================



//=================================�\���{�^���p=======================================

		hyoujilb=new JLabel("",JLabel.CENTER);
		hyoujilb.setOpaque(true);
		hyoujilb.setBackground(Color.WHITE);

//====================================================================================


//=================================�ҏW�{�^���p=======================================

		kousinbtn=new JButton("�X�V");

//====================================================================================



//=================================�ǉ��{�^���p=======================================

		tuikalb=new JLabel("�ǉ��X�P�W���[���̓���");
		tuikatf=new JTextField(100);
		tuikabtn=new JButton("�ǉ�");

//====================================================================================

		hyouji.addActionListener(this);
		hensyu.addActionListener(this);
		tuika.addActionListener(this);
		hidari.addActionListener(this);
		migi.addActionListener(this);
		hozon.addActionListener(this);
		hiraku.addActionListener(this);
		kousinbtn.addActionListener(this);

		tuikabtn.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e){
	//�ǉ��{�^�����������ꍇ�̏���
		if(e.getSource()==tuika){
			tuika_frm=new JFrame("�X�P�W���[��");
			tuika_frm.setSize(500,330);
			tuika_frm.setLayout(null);

			while(data[count][0]!=null){
				count++;
				kensulb.setText((count+1)+"/20");
				}

			tuikalb.setBounds(10,10,380,50);
			tuikatf.setBounds(160,20,260,30);

			Placelb.setBounds(10,70,30,20); Placetf.setBounds(80,70,180,20);
			StartTimelb.setBounds(290,70,60,20); StartTimetf.setBounds(360,70,60,20);
			Registerlb.setBounds(10,100,60,20); Combo.setBounds(80,100,180,20);
			EndTimelb.setBounds(290,100,60,20); EndTimetf.setBounds(360,100,60,20);
			Secretlb.setBounds(290,130,80,20); SecretCh.setBounds(402,130,20,20);
			naiyoulb.setBounds(10,160,60,20); naiyoutf.setBounds(80,160,330,70);
			tuikabtn.setBounds(320,240,90,40); kensulb.setBounds(30,240,90,40);

			tuika_frm.add(tuikalb);
			tuika_frm.add(tuikatf);
			tuika_frm.add(Placelb);
			tuika_frm.add(Placetf);
			tuika_frm.add(StartTimelb);
			tuika_frm.add(StartTimetf);
			tuika_frm.add(Registerlb);
			tuika_frm.add(Combo);
			tuika_frm.add(EndTimelb);
			tuika_frm.add(EndTimetf);
			tuika_frm.add(Secretlb);
			tuika_frm.add(SecretCh);
			tuika_frm.add(naiyoulb);
			tuika_frm.add(naiyoutf);
			tuika_frm.add(tuikabtn);
			tuika_frm.add(kensulb);


			tuikatf.setText(data[count][0]);
			Placetf.setText(data[count][1]);
			StartTimetf.setText(data[count][2]);
			EndTimetf.setText(data[count][3]);
			Combo.setSelectedIndex(0);
			naiyoutf.setText(data[count][6]);

			SecretCh.setSelected(false);


			tuika_frm.setVisible(true);
		}

			if(e.getSource()==tuikabtn){

				data[count][0]=tuikatf.getText();
				data[count][1]=Placetf.getText();
				data[count][2]=StartTimetf.getText();
				data[count][3]=EndTimetf.getText();

				checkstatus[count]=SecretCh.isSelected();
				data[count][4]=(String)Combo.getSelectedItem();

				data[count][5]=Boolean.toString(checkstatus[count]);

				data[count][6]=naiyoutf.getText();

				count++;

				tuikatf.setText(data[count][0]);
				Placetf.setText(data[count][1]);
				StartTimetf.setText(data[count][2]);
				EndTimetf.setText(data[count][3]);
				Combo.setSelectedIndex(0);
				naiyoutf.setText(data[count][6]);

				SecretCh.setSelected(false);

				kensulb.setText((count+1)+"/20");
			}

	//�ҏW�{�^�����������ꍇ�̏���
		if(e.getSource()==hensyu){
			count=0;
			hensyu_frm=new JFrame("�X�P�W���[��");
			hensyu_frm.setSize(500,330);
			hensyu_frm.setLayout(null);

			tuikalb.setBounds(10,10,380,50);
			tuikatf.setBounds(160,20,260,30);

			Placelb.setBounds(10,70,30,20); Placetf.setBounds(80,70,180,20);
			StartTimelb.setBounds(290,70,60,20); StartTimetf.setBounds(360,70,60,20);
			Registerlb.setBounds(10,100,60,20); Combo.setBounds(80,100,180,20);
			EndTimelb.setBounds(290,100,60,20); EndTimetf.setBounds(360,100,60,20);
			Secretlb.setBounds(290,130,80,20); SecretCh.setBounds(402,130,20,20);
			naiyoulb.setBounds(10,160,60,20); naiyoutf.setBounds(80,160,330,70);
			hidari.setBounds(135,250,90,20); migi.setBounds(230,250,90,20);
			kousinbtn.setBounds(330,240,90,40);

			count=0;

			tuikatf.setText(data[count][0]);
			Placetf.setText(data[count][1]);
			StartTimetf.setText(data[count][2]);
			EndTimetf.setText(data[count][3]);

			if(data[count][4]=="A"){
				Combo.setSelectedIndex(0);
			}else if(data[count][4]=="B"){
				Combo.setSelectedIndex(1);
			}else if(data[count][4]=="C"){
				Combo.setSelectedIndex(2);
			}else if(data[count][4]=="D"){
				Combo.setSelectedIndex(3);
			}else if(data[count][4]=="E"){
				Combo.setSelectedIndex(4);
			}
			
			naiyoutf.setText(data[count][6]);

			SecretCh.setSelected(checkstatus[count]);

			hensyu_frm.add(tuikalb);
			hensyu_frm.add(tuikatf);
			hensyu_frm.add(Placelb);
			hensyu_frm.add(Placetf);
			hensyu_frm.add(StartTimelb);
			hensyu_frm.add(StartTimetf);
			hensyu_frm.add(Registerlb);
			hensyu_frm.add(Combo);
			hensyu_frm.add(EndTimelb);
			hensyu_frm.add(EndTimetf);
			hensyu_frm.add(Secretlb);
			hensyu_frm.add(SecretCh);
			hensyu_frm.add(naiyoulb);
			hensyu_frm.add(naiyoutf);
			hensyu_frm.add(hidari);
			hensyu_frm.add(migi);
			hensyu_frm.add(kousinbtn);

			hensyu_frm.setVisible(true);
		}
	//�X�V�{�^�����������ꍇ�̏���
			if(e.getSource()==kousinbtn){
				data[count][0]=tuikatf.getText();
				data[count][1]=Placetf.getText();
				data[count][2]=StartTimetf.getText();
				data[count][3]=EndTimetf.getText();

				checkstatus[count]=SecretCh.isSelected();
				data[count][4]=(String)Combo.getSelectedItem();

				data[count][5]=Boolean.toString(checkstatus[count]);

				data[count][6]=naiyoutf.getText();


				count++;

				tuikatf.setText(data[count][0]);
				Placetf.setText(data[count][1]);
				StartTimetf.setText(data[count][2]);
				EndTimetf.setText(data[count][3]);
				Combo.setSelectedIndex(0);
				naiyoutf.setText(data[count][6]);

				SecretCh.setSelected(false);

			}

	//�\���{�^�����������ꍇ�̏���
		if(e.getSource()==hyouji){
			count=0;
			hyouji_frm=new JFrame("�X�P�W���[��");
			hyouji_frm.setSize(500,600);
			hyouji_frm.setLayout(null);

			hyoujilb.setBounds(40,10,380,50);
			hyoujilb.setFont(new Font(Font.DIALOG,Font.BOLD,26));

			Placelb.setBounds(10,70,30,20); Placetf.setBounds(80,70,180,20);
			StartTimelb.setBounds(290,70,60,20); StartTimetf.setBounds(360,70,60,20);
			Registerlb.setBounds(10,100,60,20); Combo.setBounds(80,100,180,20);
			EndTimelb.setBounds(290,100,60,20); EndTimetf.setBounds(360,100,60,20);
			Secretlb.setBounds(290,130,80,20); SecretCh.setBounds(402,130,20,20);
			naiyoulb.setBounds(10,160,60,20); naiyoutf.setBounds(80,160,330,70);
			hidari.setBounds(255,250,90,20); migi.setBounds(350,250,90,20);

			DefaultTableModel tableModel=new DefaultTableModel(columnNames,0);
			JTable table=new JTable(tableModel);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

			for(int i=0; i<20; i++){
				tableModel.addRow(data[i]);
			}

			JScrollPane sp=new JScrollPane(table);
			sp.setPreferredSize(new Dimension(460,240));
			JPanel p=new JPanel();
			p.add(sp);
			p.setBounds(10,300,460,250);

			count=0;

			hyoujilb.setText(data[count][0]);
			Placetf.setText(data[count][1]);
			StartTimetf.setText(data[count][2]);
			EndTimetf.setText(data[count][3]);

			if(data[count][4]=="A"){
				Combo.setSelectedIndex(0);
			}else if(data[count][4]=="B"){
				Combo.setSelectedIndex(1);
			}else if(data[count][4]=="C"){
				Combo.setSelectedIndex(2);
			}else if(data[count][4]=="D"){
				Combo.setSelectedIndex(3);
			}else if(data[count][4]=="E"){
				Combo.setSelectedIndex(4);
			}
			
			naiyoutf.setText(data[count][6]);

			SecretCh.setSelected(checkstatus[count]);

			hyouji_frm.add(hyoujilb);
			hyouji_frm.add(Placelb);
			hyouji_frm.add(Placetf);
			hyouji_frm.add(StartTimelb);
			hyouji_frm.add(StartTimetf);
			hyouji_frm.add(Registerlb);
			hyouji_frm.add(Combo);
			hyouji_frm.add(EndTimelb);
			hyouji_frm.add(EndTimetf);
			hyouji_frm.add(Secretlb);
			hyouji_frm.add(SecretCh);
			hyouji_frm.add(naiyoulb);
			hyouji_frm.add(naiyoutf);
			hyouji_frm.add(hidari);
			hyouji_frm.add(migi);
			hyouji_frm.add(p);

			hyouji_frm.setVisible(true);
		}
	//�������������ꍇ�̏���
		if(e.getSource()==hidari){
			count--;

			hyoujilb.setText(data[count][0]);
			tuikatf.setText(data[count][0]);
			Placetf.setText(data[count][1]);
			StartTimetf.setText(data[count][2]);
			EndTimetf.setText(data[count][3]);

			if(data[count][4]=="A"){
				Combo.setSelectedIndex(0);
			}else if(data[count][4]=="B"){
				Combo.setSelectedIndex(1);
			}else if(data[count][4]=="C"){
				Combo.setSelectedIndex(2);
			}else if(data[count][4]=="D"){
				Combo.setSelectedIndex(3);
			}else if(data[count][4]=="E"){
				Combo.setSelectedIndex(4);
			}

			naiyoutf.setText(data[count][6]);

			SecretCh.setSelected(checkstatus[count]);
		}

	//�E�����������ꍇ�̏���
		if(e.getSource()==migi){
			count++;

			hyoujilb.setText(data[count][0]);
			tuikatf.setText(data[count][0]);
			Placetf.setText(data[count][1]);
			StartTimetf.setText(data[count][2]);
			EndTimetf.setText(data[count][3]);

			if(data[count][4]=="A"){
				Combo.setSelectedIndex(0);
			}else if(data[count][4]=="B"){
				Combo.setSelectedIndex(1);
			}else if(data[count][4]=="C"){
				Combo.setSelectedIndex(2);
			}else if(data[count][4]=="D"){
				Combo.setSelectedIndex(3);
			}else if(data[count][4]=="E"){
				Combo.setSelectedIndex(4);
			}

			naiyoutf.setText(data[count][6]);

			SecretCh.setSelected(checkstatus[count]);
		}

	//�ۑ��{�^�����������ꍇ�̏���
		if(e.getSource()==hozon){
			try{
			File txt=new File("Schedule.txt");
			BufferedWriter bw=new BufferedWriter(new FileWriter(txt));
			for(count=0; count<20; count++){
				if(data[count][0]==null){
					bw.close();
				}
				bw.write(data[count][0]+","+data[count][1]+","+
						data[count][2]+","+data[count][3]+","+
						data[count][4]+","+data[count][5]+","+
						data[count][6]);
				bw.newLine();
				}
				bw.close();
			}catch(IOException er){}
		}

	//�J���{�^�����������ꍇ�̏���
		if(e.getSource()==hiraku){
			File file=new File("Schedule.txt");

			try{
			BufferedReader br=new BufferedReader(new FileReader(file));

			String line;
			count=0;

			while((line=br.readLine())!=null){
				data[count]=line.split(",");
				count++;
			}
			br.close();
			}catch(IOException er){}
		}
	}

	public static void main(String args[]){
		Schedule sch=new Schedule();
		sch.setVisible(true);
	}
}