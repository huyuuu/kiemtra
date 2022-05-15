package b61130384;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class BMI_Client {

	public static void main(String[] args) {
		try {
			Socket soc = new Socket("localhost",8989);
			System.out.print("Conected!\n");
			
			InputStream in = soc.getInputStream();
			InputStreamReader inReader = new InputStreamReader(in);
			BufferedReader buffR = new BufferedReader(inReader);

			OutputStream osToClient = soc.getOutputStream();	
			OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
			BufferedWriter buffW = new BufferedWriter(write2Client);
			
			Scanner banPhim = new Scanner(System.in);
			//=====THIẾT KẾ GIAO THỨC ======
			String chuoiHello_Nhan = buffR.readLine();
			System.out.println("BMI server: " + chuoiHello_Nhan);
			
			String chuoiXinChao_Gui = "Xin Chào";
			buffW.write(chuoiXinChao_Gui +"\n");
			buffW.flush();
			
			String chuoiHoiTen_Nhan = buffR.readLine();
			System.out.println("BMI server: " + chuoiHoiTen_Nhan);
			//Trả lời tên bằng bàn phím
			System.out.print("BMI client: (Nhập tên bạn): ");
			String chuoiTraLoiTen_Gui = banPhim.nextLine();
			buffW.write(chuoiTraLoiTen_Gui );
			buffW.flush();
			// Nhận trả lời tên, và hỏi chiều cao
			String chuoiHoiChieuCao_Nhan = buffR.readLine();
			System.out.println("BMI server: " + chuoiHoiChieuCao_Nhan);
			//Trả lời tên bằng bàn phím
			System.out.print("BMI client: (Nhập chiều cao của bạn [cm]): ");
			String chuoiTraLoiChieuCao_Gui = banPhim.nextLine();
			buffW.write(chuoiTraLoiChieuCao_Gui );
			buffW.flush();
			// nhận trả lời chiều cao và gửi cân nặng
			String chuoiHoiCanNang_Nhan = buffR.readLine();
			System.out.println("BMI server: " + chuoiHoiCanNang_Nhan);
			//Trả lời tên bằng bàn phím
			System.out.print("BMI client: (Nhập cân nặng của bạn [kg]): ");
			String chuoiTraLoiCanNang_Gui = banPhim.nextLine();
			buffW.write(chuoiTraLoiCanNang_Gui );
			buffW.flush();
			//Nhận 1: Thông tin đang tính
			String chuoiDangTinh_Nhan = buffR.readLine();
			System.out.println("BMI server: "+chuoiDangTinh_Nhan);
			//Nhận 2: Kết quả béo phì
			String chuoiKQ_Nhan = buffR.readLine();
			System.out.println("BMI server: "+chuoiKQ_Nhan);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}

