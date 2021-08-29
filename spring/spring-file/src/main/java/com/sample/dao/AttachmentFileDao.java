package com.sample.dao;

import java.util.List;

import com.sample.vo.AttachmentFile;

/**
 * 첨부파일 상세 정보 테이블에 대한 CRUD 작업을 지원한다.
 * @author lee_e
 *
 */
public interface AttachmentFileDao {

	/**
	 * 새 첨부파일 정보를 데이터베이스에 저장한다.
	 * @param attachmentFile 첨부파일 상세 정보
	 */
	void insertAttachmentFile(AttachmentFile attachmentFile);
	
	/**
	 * 모든 첨부파일 상세정보를 조회해서 반환한다.
	 * @return
	 */
	List<AttachmentFile> getAllAttachmentFiles();
	
	/**
	 * 지정된 첨부파일 상세정보 번호에 해당하는 첨부파일 상세정보를 반환한다.
	 * @param fileNo 첨부파일 상세정보 번호
	 * @return 첨부파일 상세 정보
	 */
	AttachmentFile getAttachmentFile(long fileNo);
	
	/**
	 * 수정된 첨부파일 상세정보를 전달받아서 데이터베이스에 반영한다.
	 * @param attachmentFile 수정된 첨부파일 상세정보
	 */
	void updateAttachmentFile(AttachmentFile attachmentFile);
	
	/**
	 * 지정된 첨부파일 상세정보 번호를 전달받아서 해당 첨부파일 상세정보를 삭제한다.
	 * @param fileNo 첨부파일 상세정보 번호
	 */
	void deleteAttachmentFile(long fileNo);
}
