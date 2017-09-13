package com.xmg.springmvc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Upload {
	@RequestMapping("/uploaddemo")
	public ModelAndView Uploaddemo(MultipartFile file) throws IOException {
		String contentTypeString = file.getContentType();
		String name = file.getOriginalFilename();
		System.out.println(contentTypeString);
		System.out.println(name);

		InputStream in = file.getInputStream();
		String flieNameString = UUID.randomUUID().toString()
				+ name.split("\\.")[1];

		FileOutputStream out = new FileOutputStream(new File("F:/",
				flieNameString));
		IOUtils.copy(in, out);

		// 最后要将输出流关闭
		out.close();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("upload.jsp");
		return mv;
	}

	@RequestMapping("/down")
	@ResponseBody//告诉springmvc所有的相应有response操作
	public ModelAndView downloadimg(HttpServletResponse resp) throws IOException {
		File file = new File("F:/1.MP4");
		ServletOutputStream out = null;
		try {
			resp.setHeader("Content-Disposition", "attachment;filename=666.MP4");
			InputStream in = new FileInputStream(file);
			out = resp.getOutputStream();
			IOUtils.copy(in, out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
