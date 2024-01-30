package kr.or.ddit.lprod;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.mybatisUtil;

public class LprodDaoImpl implements ILprodDao {
	private static LprodDaoImpl dao = null;
	private LprodDaoImpl() {}
	public static LprodDaoImpl getInstance() {
		if(dao == null) dao = new LprodDaoImpl();
		return dao;
	}
	@Override
	public List<LprodVo> getList() {
		List<LprodVo> vo = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			
			vo = session.selectList("lprod.getList");
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return vo;
	}
	
}
