import java.io.*;
import java.net.*;

public class Server_Product{
	public static void main(String args[])throws IOException{
		ServerSocket server=null;
		Socket client=null;

		server=new ServerSocket(1234);
		client=server.accept();

		System.out.println("接続を受け付けました");

		//送る側
		PrintStream sp_out=new PrintStream(client.getOutputStream());
		//sp_out.println("サーバーからデータを送信しました");

		BufferedReader sb_in;
		sb_in=new BufferedReader(new InputStreamReader(client.getInputStream()));

		//String line;
		//while(true){
			//line=sb_in.readLine();
			//System.out.println(line);
			//if(line.equals("bye")){break;}
			//sp_out.println("ok");
		//}


		//while(true){
			String text;
			text=sb_in.readLine();
			//System.out.println(sb_in.readLine());


			File f=new File("product.txt");
			BufferedWriter bw=new BufferedWriter(new FileWriter(f,true));

			bw.write(text+"\n");

			//if(text.equals("bye")){break;}
			//sp_out.println("ok");

			System.out.println(text);

			bw.close();

		//}
		sb_in.close();
		server.close();
		client.close();
	}
}