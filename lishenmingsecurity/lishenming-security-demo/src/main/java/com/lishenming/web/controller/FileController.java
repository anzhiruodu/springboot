package com.lishenming.web.controller;

import com.lishenming.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

@RestController
@RequestMapping("/file")
public class FileController {
    String folder = "E:\\myCode\\springboot\\lishenmingsecurity\\lishenming-security-demo\\src\\main\\resources";


    @PostMapping()
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        File localfile = new File(folder, new Date().getTime() + ".txt");
        file.transferTo(localfile);//将传过来的文件写到本地的文件；
        return new FileInfo(localfile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
        OutputStream outputStream = response.getOutputStream();
        try {
            response.setContentType("allication/x-download");
            response.addHeader("Content-Disposition","attachment;filename=test.txt");
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        }catch (Exception e){

        }finally {
            inputStream.close();
            outputStream.close();
        }
    }
}
