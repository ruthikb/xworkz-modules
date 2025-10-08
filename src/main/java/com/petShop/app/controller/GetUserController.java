package com.petShop.app.controller;

import com.petShop.app.dto.PetShopDto;
import com.petShop.app.service.PetShopService;
import com.petShop.app.util.OtpGenerator;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.Servlet;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
public class GetUserController {

    private  static  final  String UPLOAD_FILE="C:/Users/kruth/IdeaProjects/Model-pet-shop/src/main/resources/pathfile/";
    @Autowired
    PetShopService service;

    @Autowired
    OtpGenerator otpGenerator;

    @GetMapping("getUserProfile")
    public  String getUser(HttpSession httpSession , Model model){
        System.err.println("dfsjffkndf");
        String  email =httpSession.getAttribute("emailNPhone").toString();
        System.out.println("");
        PetShopDto dto=service.getUser(email);
        System.out.println(dto);
        model.addAttribute("dto",dto);
        return  "updateProfile";
    }

    @PostMapping("updateUserProfile")
    public  String  updateProfile(PetShopDto petShopDto, Model model){
        String  string=service.updateProfile(petShopDto);
        System.err.println(string);
        System.err.println(petShopDto.getFileUpload().getOriginalFilename());
        PetShopDto dto = service.getUser(petShopDto.getEmail());
        model.addAttribute("dto",dto);
        return "updateProfile";
    }
    @GetMapping("getProfile/{fileName}")
    public  void getImage(HttpServletResponse httpServletResponse, @PathVariable String fileName){
        File file=new File(UPLOAD_FILE+fileName);
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStream inputStream=new BufferedInputStream(fileInputStream);
            ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
            IOUtils.copy(inputStream,servletOutputStream);
        }
        catch (Exception e) {

        }
    }
}
