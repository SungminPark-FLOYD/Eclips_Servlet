package kr.or.ddit.lprod;

import java.util.List;

public class LprodServiceImpl implements ILprodService {
	private ILprodDao dao;
	private static LprodServiceImpl service = null;
	
	private LprodServiceImpl() {
		dao = LprodDaoImpl.getInstance();
	}
	public static LprodServiceImpl getInstance() {
		if(service == null) service = new LprodServiceImpl();
		return service;
	}

	@Override
	public List<LprodVo> getList() {		
		return dao.getList();
	}
}
