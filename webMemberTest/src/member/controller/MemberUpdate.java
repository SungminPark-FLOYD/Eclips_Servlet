package member.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVo;


@WebServlet("/memberUpdate.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30,
		maxRequestSize = 1024*1024*100
	)
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memId = request.getParameter("memid");
		String memPass = request.getParameter("pass"); 
		String memName = request.getParameter("name"); 
		String memTel = request.getParameter("tel"); 
		String memAddr = request.getParameter("addr"); 
		
		MemberVo vo = new MemberVo();
		
		vo.setMem_id(memId);
		vo.setMem_pass(memPass);
		vo.setMem_name(memName);
		vo.setMem_tel(memTel);
		vo.setMem_addr(memAddr);
		
		//업로드된 파일들이 저장될 폴더 설정 (서버 컴퓨터 기준)
		String uploadPath = "d:/d_other/uploadFiles";
		
		//저장될 폴더가 없으면 새로 생성한다.
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdir();
		}
		
		for(Part part : request.getParts()) {
			String fileName = extractFilename(part);	//upload한 파일이름 구하기
			
			if(fileName != null) {
				vo.setMem_photo(fileName);				
				try {
					//Upload된 파일을 지정한 '업로드 폴더'에 저장하기
					//저장하는 메서드 ==> Part객체.wrtie()메서드 이용
					part.write(uploadPath + File.separator + fileName);
				}catch(IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		int res = service.updateMember(vo);
		request.setAttribute("res",res);
		request.getRequestDispatcher("/member/updateRes.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public String extractFilename(Part part) {
		String fileName = null;	//반환값(파일명)이 저장될 변수
		String dispositionStr = part.getHeader("content-disposition");
		String[] itemArr = dispositionStr.split(";");
		
		for(String item : itemArr) {
			if(item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=") + 2, item.length()-1);
				break;
			}
		}
		return fileName;
	}

}
