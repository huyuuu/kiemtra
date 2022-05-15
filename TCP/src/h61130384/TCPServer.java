package h61130384;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		try {
			//mở cổng và bắt đầu nghe
			ServerSocket socketserver = new ServerSocket(5555);
			System.out.print("I'm listening on port number 5555");
			//luôn luôn lắng nghe
			while(true) {
				Socket socketclient = socketserver.accept();
				
				InputStream in = socketclient.getInputStream();
				InputStreamReader inReader = new InputStreamReader(in);
				BufferedReader buffR = new BufferedReader(inReader);
				
				OutputStream osToClient = socketclient.getOutputStream();
				OutputStreamWriter write2client = new OutputStreamWriter(osToClient);
				BufferedWriter buffW = new BufferedWriter(write2client);
				while(true) {
					buffW.write("Mời nhập a:");
					buffW.flush();
					String soA=buffR.readLine();
					Double a=Double.parseDouble(soA);
					Double Guia = a;
					buffW.write(Guia+"\n");
					buffW.flush();
					
					buffW.write("Mời nhập b:");
					buffW.flush();
					String soB=buffR.readLine();
					Double b=Double.parseDouble(soB);
					Double Guib = b;
					buffW.write(Guib+"\n");
					buffW.flush();
					
					buffW.write("Mời nhập phép toán:");
					buffW.flush();
					
					String pheptoan=buffR.readLine();
					double kq = 0;
					String kqstr;
					switch (pheptoan) {
	                case "+":
	                	kq = a + b;
	                    break;
	                case "-":
	                	kq = a - b;
	                    break;
	                case "*":
	                	kq = a * b;
	                    break;
	                case "/":
	                    if (b == 0) {
	                        kqstr = "ERROR b=0";
	                        break;
	                    }
	                    kq = a * 1.0f / b;
	                    break;
					}
					kqstr = String.valueOf(kq);
					buffW.write(kqstr+"\n");
					buffW.flush();
					
					buffW.write("Làm tiếp không?");
					buffW.flush();
					String chuoiNhan=buffR.readLine();
					String chuoiGui=chuoiNhan;
					buffW.write(chuoiGui+"\n");
					buffW.flush();
					
					socketclient.close();
					if(chuoiGui.equals("Không")||chuoiGui.equals("không")) break;
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
