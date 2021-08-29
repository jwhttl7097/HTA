package com.sample.service;

import java.util.List;

import com.sample.vo.AttachmentFile;
import com.sample.vo.FileItem;

public interface FileService {

	void insertNewAttachmentFile(AttachmentFile attachmentFile);
	List<AttachmentFile> getAttachmentFileList();
	AttachmentFile getAttachmentDetail(long fileNo);
	FileItem getFileItem(long itemNo);
	void addFileItems(long fileNo, List<FileItem> fileItems);
	void updateAttachmentFile(AttachmentFile attachmentFile);
	void removeAttachmentFile(long fileNo);
	void removeFileItems(long fileNo, long[] itemNumbers);
}
