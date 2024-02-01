package kr.or.ddit.basic.upload.service;

import java.util.List;

import kr.or.ddit.basic.upload.vo.FileInfoVo;

public interface IFileInfoService {

	/**
	 * FileInfoVo객체에 저장된 자료를 DB에 insert 하는 메서드
	 * @param fileVo 저장할 데이터가 저장된 fileInfoVo객체
	 * @return 작업 성공 : 1 , 작업 실패 : 0
	 */
	public int insertFileinfo(FileInfoVo fileVo);
	
	
	/**
	 * DB에 저장된 전체 파일 목록을 가져와 List에 담아서 반환하는 메서드
	 * 
	 * @return 파일 정보 목록이 저장된 List객체
	 */
	public List<FileInfoVo> getAllFileinfo();
	
	
	/**
	 * fileNo를 매개변수로 받아서 해당 파일 정보를 검색하여 찾은 파일 정보를 반환하는 메서드
	 * 
	 * @param fileNo 검색할 파일 번호
	 * @return 검색된 데이터가 저장된 FileInfoVo 객체
	 */
	public FileInfoVo getFileinfo(int fileNo);
}
