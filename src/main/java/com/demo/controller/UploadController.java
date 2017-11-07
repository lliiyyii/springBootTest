package com.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONObject;
import com.demo.entity.BaseApi;
import com.demo.service.StorageService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;


@RestController
public class UploadController {
    private static final Logger log = LoggerFactory.getLogger(UploadController.class);
@RequestMapping(value = "/upload",method = RequestMethod.POST)
    public BaseApi upload (HttpServletRequest request,
                           @RequestParam(value = "file",required = true) MultipartFile file,
                           @RequestParam(value = "tag") int tag) throws Exception{
   log.info("进入了upload,tag是 "+tag);
    try{
        String filename = file.getOriginalFilename();
        String path = request.getServletContext().getRealPath("/images/");
        log.info("文件名字是 "+filename+" 文件路径是 "+path);
        File filepath = new File(path,filename);
        //判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        //将上传文件保存到一个目标文件当中
        file.transferTo(new File(path + File.separator + filename));
        //返回文件的路径
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("path",path+File.separator+filename);
        return new BaseApi("ok",0,jsonObject);
    }catch (Exception e){
        e.printStackTrace();
        return new BaseApi("error",1,null);
    }

}
}