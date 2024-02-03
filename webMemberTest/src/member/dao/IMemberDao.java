package member.dao;

import java.util.List;

import member.vo.MemberVo;

public interface IMemberDao {
	//전체 회원 리스트 id, pass, name, tel, addr
	public List<MemberVo> getAllMember();
	//id 중복 체크
	public String idChk(String id);
	//회원정보 추가 id, pass, name, tel, addr, photo
	public int insertMember(MemberVo vo);
	//회원정보 상세보기  id, pass, name, tel, addr, photo
	public MemberVo selectMem(String id);
	//회원정보 수정 pass, name, tel, addr, photo
	public int updateMember(MemberVo vo);
	//회원 정보 삭제
	public int deleteMember(String id);
}
