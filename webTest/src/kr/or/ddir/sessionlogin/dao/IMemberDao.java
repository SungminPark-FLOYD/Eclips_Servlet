package kr.or.ddir.sessionlogin.dao;

import kr.or.ddir.sessionlogin.vo.MemberVo;

public interface IMemberDao {

	/**
	 * 회원 ID와 패스워드가 저장된 MemberVo 객체를 인수값으로 받아서 해당 회원을 검색하여 반환하는 메서드
	 * @param memVo 검색할 회원 ID와 패스워드가 저장된 MemberVo객체
	 * @return 검색된 회원정보가 저장된 MemberVo 객체(검색된 자료가 없으면 null)
	 */
	public MemberVo getLoginMember(MemberVo memVo);
}
