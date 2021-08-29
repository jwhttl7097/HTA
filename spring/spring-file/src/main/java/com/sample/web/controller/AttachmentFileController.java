package com.sample.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sample.service.FileService;
import com.sample.vo.AttachmentFile;
import com.sample.vo.FileItem;
import com.sample.web.form.AttachmentFileForm;
import com.sample.web.view.DownloadView;

@Controller
public class AttachmentFileController {

	@Autowired
	FileService fileService;
	
	@Autowired
	DownloadView downloadView;
	
	@GetMapping({"/", "/home", "/list"})
	public String home(Model model) {
		List<AttachmentFile> files = fileService.getAttachmentFileList();
		model.addAttribute("files", files);
		
		return "list";
	}
	
	@GetMapping("/register")
	public String form() {
		return "registerform";
	}
	
	@PostMapping("/register")
	public String form(AttachmentFileForm form) throws IOException {
		List<FileItem> fileItems = new ArrayList<>();

		List<MultipartFile> uploadFiles = form.getUpfiles();
		for (MultipartFile uploadFile : uploadFiles) {
			if (!uploadFile.isEmpty()) {
				String filename = System.currentTimeMillis() + uploadFile.getOriginalFilename();
				String filetype = uploadFile.getContentType();
				long filesize = uploadFile.getSize();
				
				FileItem fileItem = new FileItem();
				fileItem.setFilename(filename);
				fileItem.setFiletype(filetype);
				fileItem.setFilesize(filesize);
				
				fileItems.add(fileItem);
				
				FileCopyUtils.copy(uploadFile.getInputStream(), new FileOutputStream(new File("c:/upload", filename)));
			}
		}

		AttachmentFile attachmentFile = new AttachmentFile();
		attachmentFile.setTitle(form.getTitle());
		attachmentFile.setWriter(form.getWriter());
		attachmentFile.setDescription(form.getDescription());
		attachmentFile.setAmount(fileItems.size());
		attachmentFile.setFileItems(fileItems);
		
		fileService.insertNewAttachmentFile(attachmentFile);
		
		return "redirect:list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("no") long fileNo, Model model) {
		model.addAttribute("file", fileService.getAttachmentDetail(fileNo));
		return "detail";
	}
	
	@PostMapping("/addfileitem")
	public String addFileItems(@RequestParam("no") long fileNo, @RequestParam("upfiles") List<MultipartFile> uploadFiles) throws IOException {
		List<FileItem> fileItems = new ArrayList<>();
		for (MultipartFile uploadFile : uploadFiles) {
			if (!uploadFile.isEmpty()) {
				String filename = System.currentTimeMillis() + uploadFile.getOriginalFilename();
				String filetype = uploadFile.getContentType();
				long filesize = uploadFile.getSize();
				
				FileItem fileItem = new FileItem();
				fileItem.setFilename(filename);
				fileItem.setFiletype(filetype);
				fileItem.setFilesize(filesize);
				fileItem.setFileNo(fileNo);
				
				fileItems.add(fileItem);
				
				FileCopyUtils.copy(uploadFile.getInputStream(), new FileOutputStream(new File("c:/upload", filename)));
			}
		}
		fileService.addFileItems(fileNo, fileItems);
		
		return "redirect:detail?no=" + fileNo;
	}
	
	@GetMapping("/delete")
	public String removeAttachmentFile(@RequestParam("no") long fileNo) {
		fileService.removeAttachmentFile(fileNo);
		return "redirect:list";
	}
	
	@GetMapping("/deletefile")
	public String removeFileItem(@RequestParam("fileno") long fileNo, @RequestParam("itemno") long[] itemNo) {
		fileService.removeFileItems(fileNo, itemNo);
		return "redirect:detail?no=" + fileNo;
	}
	
	@GetMapping("/download")
	public ModelAndView download(@RequestParam("no") long itemNo) {
		ModelAndView mav = new ModelAndView();
		FileItem fileItem = fileService.getFileItem(itemNo);
		
		mav.addObject("directory", "c:/upload");
		mav.addObject("filename", fileItem.getFilename());
		mav.setView(downloadView);		
		
		return mav;
	}
}
