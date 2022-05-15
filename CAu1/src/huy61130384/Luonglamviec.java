package huy61130384;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Luonglamviec extends Thread{
	Socket socketClient;
	int id=-1;	
	public Luonglamviec(Socket socketClient, int id) {
		super();
		this.socketClient = socketClient;
		this.id = id;
	}
	public void run() {
		try {
			System.out.print(socketClient.getInetAddress().getHostAddress());
			System.out.print(id);
			
			OutputStream osToClient = socketClient.getOutputStream();
			OutputStreamWriter write2client = new OutputStreamWriter(osToClient);
			BufferedWriter buffW = new BufferedWriter(write2client);
			
			InputStream in = socketClient.getInputStream();
			InputStreamReader inReader = new InputStreamReader(in);
			BufferedReader buffRead = new BufferedReader(inReader);
			
			while(true){
				String chuoiNhan=buffRead.readLine();
				System.out.print(chuoiNhan);
				int m = Integer.parseInt(chuoiNhan);
				if(m%2==0)
		        {
					String chuoiGui= "Chan";
					buffW.write(chuoiGui+"\n");
					buffW.flush();
		            
		        }
		        if(m%2==1)
		        {
		        	String chuoiGui= "Le";
					buffW.write(chuoiGui+"\n");
					buffW.flush();
		        }
		        if(chuoiNhan.equals("0")) {
					break;
		        }
			}
				
			socketClient.close();
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
}