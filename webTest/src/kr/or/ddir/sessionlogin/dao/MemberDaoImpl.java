package kr.or.ddir.sessionlogin.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddir.sessionlogin.vo.MemberVo;
import kr.or.ddit.util.mybatisUtil;

public class MemberDaoImpl implements IMemberDao {

	private static MemberDaoImpl instance = null;
	private MemberDaoImpl() {}
	public static MemberDaoImpl getInstance() {
		if(instance == null) instance = new MemberDaoImpl();
		return instance;			
	}
	@Override
	public MemberVo getLoginMember(MemberVo memVo) {
		MemberVo loginMemVo = null;	//반환값이 저장될 변수
		SqlSession session = null;
		try {
			session = mybatisUtil.getSqlSession();
			
			loginMemVo = session.selectOne("mymember.getLoginMember", memVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session != null) session.close();
		}
		
		return loginMemVo;
	}

}
