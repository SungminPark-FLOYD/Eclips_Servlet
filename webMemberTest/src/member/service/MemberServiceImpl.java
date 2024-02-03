package member.service;

import java.util.List;

import member.dao.IMemberDao;
import member.dao.MemberDaoImpl;
import member.vo.MemberVo;

public class MemberServiceImpl implements IMemberService{
	private IMemberDao dao;
	private static MemberServiceImpl instance = null;
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	public static MemberServiceImpl getInstance() {
		if(instance == null) instance = new MemberServiceImpl();
		return instance;
	}
	@Override
	public List<MemberVo> getAllMember() {
		
		return dao.getAllMember();
	}

	@Override
	public String idChk(String id) {
		
		return dao.idChk(id);
	}

	@Override
	public int insertMember(MemberVo vo) {
		
		return dao.insertMember(vo);
	}

	@Override
	public MemberVo selectMem(String id) {
		// TODO Auto-generated method stub
		return dao.selectMem(id);
	}

	@Override
	public int updateMember(MemberVo vo) {
		// TODO Auto-generated method stub
		return dao.updateMember(vo);
	}

	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return dao.deleteMember(id);
	}

}
