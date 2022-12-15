// I build program java TCP(client-sever) by language java. get a string from clien.

// Program Clien
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;
// import java.net.UnknownHostException;

public class TCPclient {
	public static void main (String [] args) {
		try {
			//tao socket va ket noi voi sever va lay 2 luong de gui nhan du lieu
			Socket s = new Socket("127.0.0.1",1234);
			

			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();

			int ch;

			while (true) {
				System.out.print("nhap 1 chchuoi:  ");
				Scanner kb = new Scanner(System.in);
				String chuoi = kb.nextLine();

				if (chuoi.equals("thoat")) break;

				PrintWriter pw = new PrintWriter(os);
				pw.println(chuoi);  //gửi chuỗi chuoi ve cho server
				pw.flush(); 

			}
			s.close();
						
		}
		catch (Exception ioe){
			System.out.println("co loi gi do da xay ra " + ioe.getMessage());
		}
	}
}

-------
// Program Server
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
//import java.net.*;
//import java.io.*;

	public class TCPsocket {
		public static void main (String []args) {
			try{
				//tao sever cho sockett
				ServerSocket  ss = new ServerSocket(1234);
				System.out.println ("sv: da tao socket thanh cong");


				//cho va chap nhan ket noi tu socket
				System.out.println ("sv: cho ket noi tu client");
				Socket s = ss.accept();
				System.out.println ("sv: da chap nhan noi ket thanh cong tren cong:  " + s.getPort() );

				//lay 2 luong du lieu de lien ket voi client
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();

				while(true) {
				System.out.println("SV: dang cho nhan chuoi tu client:.." );

				Scanner sis = new Scanner(is);
				String request = sis.nextLine();

				//if(request.equals("thoat")) break;
			

				System.out.println("SV: chuoi nhan duoc tu client:.." + request);


			
				}
			}
			catch (Exception ioe) {
					System.out.println("loi roi " + ioe.getMessage());
				}
		}
	}
