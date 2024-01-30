package kr.or.ddir.sessionlogin.service;

import kr.or.ddir.sessionlogin.dao.IMemberDao;
import kr.or.ddir.sessionlogin.dao.MemberDaoImpl;
import kr.or.ddir.sessionlogin.vo.MemberVo;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;
	private static MemberServiceImpl instance;
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	public static MemberServiceImpl getInstance() {
		if(instance == null) instance = new MemberServiceImpl();
		return instance;
	}
	@Override
	public MemberVo getLoginMember(MemberVo memVo) {
		
		return dao.getLoginMember(memVo);
	}

}
