package h61130384;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		try {
			//Tạo 1 kết nối Socket đến Server time.nist.gov
			Socket soc = new Socket("localhost", 5555);
			System.out.print("Connect!");
			//Lấy luông nhập
			InputStream in = soc.getInputStream();
			InputStreamReader inReader = new InputStreamReader(in);
			BufferedReader buffR = new BufferedReader(inReader);
			
			OutputStream osToClient = soc.getOutputStream();
			OutputStreamWriter write2client = new OutputStreamWriter(osToClient);
			BufferedWriter buffW = new BufferedWriter(write2client);
			//Đọc trả lời và in ra
			Scanner bp = new Scanner(System.in);
			while(true) {
				System.out.println(buffR.readLine());
				Double a = Double.parseDouble(buffR.readLine());
				String soA = String.valueOf(a);
				buffW.write(soA+"\n");
				buffW.flush();
				
				System.out.println(buffR.readLine());
				Double b = Double.parseDouble(buffR.readLine());
				String soB = String.valueOf(a);
				buffW.write(soB+"\n");
				buffW.flush();
				
				System.out.println(buffR.readLine());
				String pheptoan = bp.nextLine();
				buffW.write(pheptoan+"\n");
				buffW.flush();
				
				System.out.println("Kết quả: "+buffR.readLine());
				
				System.out.println(buffR.readLine());
				String chuoiGui = bp.nextLine();
				buffW.write(chuoiGui+"\n");
				buffW.flush();
				
				soc.close();
				if(chuoiGui.equals("Không")||chuoiGui.equals("không")) break;
			}
			
		} catch (IOException e) {

			System.out.print("NoConnect....");
			e.printStackTrace();
		}


	}

}
