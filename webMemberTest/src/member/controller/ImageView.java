package member.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVo;


@WebServlet("/imageView.do")
public class ImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memid = request.getParameter("memno");
		
		
		
		IMemberService service = MemberServiceImpl.getInstance();
		MemberVo vo = service.selectMem(memid);
		
		//업로드된 파일들이 저장된 폴더 설정
		String uploadPath = "d:/d_other/uploadFiles";
		
		//저장될 폴더가 없으면 새로 생성한다.
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdir();
		}
		
		String imgPath = uploadPath + File.separator + vo.getMem_photo();
		File file = new File(imgPath);
		
		if(file.exists()) {	//이미지 파일이 있을 때..
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			try {
				//출력용
				bout = new BufferedOutputStream(response.getOutputStream());
				//파일 입력용
				bin = new BufferedInputStream(new FileInputStream(file));
				
				byte[] temp = new byte[1024];
				int len = 0;
				while((len = bin.read(temp))> 0) {
					bout.write(temp, 0 , len);
				}
				bout.flush();
			}catch(Exception e) {
				System.out.println("파일 입출력 오류 :" + e.getMessage());
			}finally {
				if(bin != null) try {bin.close();} catch(IOException e) {}
				if(bout != null) try {bout.close();} catch(IOException e) {}
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
