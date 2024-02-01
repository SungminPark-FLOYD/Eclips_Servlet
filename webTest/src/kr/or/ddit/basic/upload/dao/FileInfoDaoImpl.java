package kr.or.ddit.basic.upload.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.basic.upload.vo.FileInfoVo;
import kr.or.ddit.util.mybatisUtil;

public class FileInfoDaoImpl implements IFileInfoDao {

	private static FileInfoDaoImpl dao;
	private FileInfoDaoImpl() {}
	public static FileInfoDaoImpl getInstance() {
		if(dao == null) dao = new FileInfoDaoImpl();
		return dao;
	}
	@Override
	public int insertFileinfo(FileInfoVo fileVo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			cnt = session.insert("fileinfo.insertFileinfo", fileVo);
			
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public List<FileInfoVo> getAllFileinfo() {
		List<FileInfoVo> fileList = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			fileList = session.selectList("fileinfo.getAllFileinfo");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		
		return fileList;
	}

	@Override
	public FileInfoVo getFileinfo(int fileNo) {
		FileInfoVo fileVo = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			fileVo = session.selectOne("fileinfo.getFileinfo", fileNo);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		
		return fileVo;
	}

}
