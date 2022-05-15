package a61130384;

import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class BMI_Server {

	public static void main(String[] args) {
		try {
			ServerSocket socketServer = new ServerSocket(8989);
			System.out.print("I'm listening on 8989 port ...");
			while(true) {
				Socket socketClient = socketServer.accept(); // chấp nhận kết nối 
				
				System.out.print(socketClient.getInetAddress().getHostAddress()); // nhập giống thầy
				
				OutputStream osToClient = socketClient.getOutputStream();	
				OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
				BufferedWriter buffW = new BufferedWriter(write2Client);
			
				InputStream in = socketClient.getInputStream();
				InputStreamReader inReader = new InputStreamReader(in);
				BufferedReader buffR = new BufferedReader(inReader);
				
				//Gửi hello
				String chuoiHello_Gui = "Hello";
				buffW.write(chuoiHello_Gui+ "\n" );
				buffW.flush();
				//Nhận về xin chào
				String chuoiXinchao_Nhan = buffR.readLine();
				//Hỏi tên người bên Client
				String chuoiHoiTen = "Bạn Tên là gì? ";
				buffW.write(chuoiHoiTen+ "\n" );
				buffW.flush();
				//Nhận trả lời tên và hỏi chiều cao
				String chuoiTen_Nhan = buffR.readLine();
				String chuoiHoiChieucao = "Bạn cao bao nhiêu cm? \n";
				buffW.write(chuoiHoiChieucao+ "\n" );
				buffW.flush();
				//Nhận trả lời chiêu cao và hỏi cân nặng
				String chuoiChieuCao_Nhan = buffR.readLine();
				Double ChieuCao=Double.parseDouble(chuoiChieuCao_Nhan);
				String chuoiHoiCanNang = "Bạn nặng bao nhiêu kg? \n";
				buffW.write(chuoiHoiCanNang+ "\n" );
				buffW.flush();
				// Nhận cân nặng
				String chuoiCanNang = buffR.readLine();
				Double CanNang = Double.parseDouble(chuoiCanNang);
				String chuoiNoiToiDangTinh = " Tôi đang tính toán ....";
				buffW.write(chuoiNoiToiDangTinh +"\n");
				buffW.flush();
				//Tính toán BMI
				double kq=0;
				kq=CanNang/(ChieuCao*ChieuCao);
				if(kq<18.5) {
					String Chuoigui_BMI = String.valueOf(kq);
					String Chuoigui_KQ = "Cân nặng thấp(gầy)";
					buffW.write(Chuoigui_BMI+ "\n"+Chuoigui_KQ+ "\n");
				    buffW.flush();	
				}else if(kq>=18.5 && kq<=24.9) {
					String Chuoigui_BMI = String.valueOf(kq);
					String Chuoigui_KQ = "Bình thường";
					buffW.write(Chuoigui_BMI+ "\n"+Chuoigui_KQ+ "\n");
				    buffW.flush();
				}else if(kq==25) {
					String Chuoigui_BMI = String.valueOf(kq);
					String Chuoigui_KQ = "Thừa cân";
					buffW.write(Chuoigui_BMI+ "\n"+Chuoigui_KQ+ "\n");
				    buffW.flush();
				}else if(kq>25 && kq<=29.9) {
					String Chuoigui_BMI = String.valueOf(kq);
					String Chuoigui_KQ = "Tiền béo phì";
					buffW.write(Chuoigui_BMI+ "\n"+Chuoigui_KQ+ "\n");
				    buffW.flush();
				}else if(kq>=30 && kq<=34.9) {
					String Chuoigui_BMI = String.valueOf(kq);
					String Chuoigui_KQ = "Béo phì độ I";
					buffW.write(Chuoigui_BMI+ "\n"+Chuoigui_KQ+ "\n");
				    buffW.flush();
				}else if(kq>=35 && kq<=39.9) {
					String Chuoigui_BMI = String.valueOf(kq);
					String Chuoigui_KQ = "Béo phì độ II";
					buffW.write(Chuoigui_BMI+ "\n"+Chuoigui_KQ+ "\n");
				    buffW.flush();
				}else {
					String Chuoigui_BMI = String.valueOf(kq);
					String Chuoigui_KQ = "Béo phì độ III";
					buffW.write(Chuoigui_BMI+ "\n"+Chuoigui_KQ+ "\n");
				    buffW.flush();
				}
				socketClient.close();
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
