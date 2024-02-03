package member.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.vo.MemberVo;
import util.mybatisUtil;

public class MemberDaoImpl implements IMemberDao {
	private static MemberDaoImpl instance = null;
	private MemberDaoImpl() {}
	public static MemberDaoImpl getInstance() {
		if(instance == null) instance = new MemberDaoImpl();
		return instance;
	}
	
	@Override
	public List<MemberVo> getAllMember() {
		List<MemberVo> memList = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			
			memList = new ArrayList<MemberVo>();
			
			memList = session.selectList("member.getAllMember");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return memList;
	}

	@Override
	public String idChk(String id) {
		String memId = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			
			memId = session.selectOne("member.idChk", id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return memId;
	}

	@Override
	public int insertMember(MemberVo vo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			
			cnt = session.insert("member.insertMember", vo);
			
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public MemberVo selectMem(String id) {
		MemberVo vo = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			
			vo = session.selectOne("member.selectMem", id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return vo;
	}

	@Override
	public int updateMember(MemberVo vo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			
			cnt = session.update("member.updateMember", vo);
			
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String id) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			
			cnt = session.delete("member.deleteMember", id);
			
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

}
