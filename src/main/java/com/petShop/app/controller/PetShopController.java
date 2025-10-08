package com.petShop.app.controller;

import com.petShop.app.dto.PetShopDto;
import com.petShop.app.service.PetShopService;
import com.petShop.app.util.OtpGenerator;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class PetShopController {
    @Autowired
    PetShopService service;

    @Autowired
    OtpGenerator otpGenerator;

    @GetMapping("userRegister")
    public String user() {
        return "register";
    }

    @GetMapping("index")
    public String home() {
        return "index";
    }

    @PostMapping("registerUser")
    public String saveUser(@Valid PetShopDto petShopDto) {
        service.saveUser(petShopDto);
        return "index";
    }

    @GetMapping("getEmail")
    public ResponseEntity<String> findByEmail(@RequestParam("email") String email) {

        if (email != null) {
            PetShopDto dto = new PetShopDto();
            dto = service.findEmailService(email);
            if (dto != null) {
                return ResponseEntity.ok("Email is used");
            }
        }
        return ResponseEntity.ok("Email is not used");
    }

    @GetMapping("getPhone")
    public ResponseEntity<String> getPhone(@RequestParam("phone") long phone) {
        if (phone != 0) {
            System.out.println(phone);
            PetShopDto dto = new PetShopDto();
            dto = service.getPhoneService(phone);
            System.out.println(dto);
            if (dto != null) {
                return ResponseEntity.ok("phone is used");
            }
        }
        return ResponseEntity.ok("phone is not used");
    }

    @GetMapping("/loginUser")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("getUser")
    public  String  getUser(){
        return "updateProfile";
    }

    @PostMapping("/loginUser")
    public String loginUser(@RequestParam("email") String emailNPhone, @RequestParam("password" ) String password,
                            Model model, HttpSession httpSession) {
        String mailAndPAssword = service.checkMailAndPAssword(emailNPhone, password);
        if (mailAndPAssword.equals("nullError")) {
            model.addAttribute("email", emailNPhone);
            model.addAttribute("nullError", "Please enter data");
            return "login";
        }
        if (mailAndPAssword.equals("dataError")) {
            model.addAttribute("email", emailNPhone);
            model.addAttribute("nullError", "Please enter data");
            return "login";
        }
        if (mailAndPAssword.equals("passwordError")) {
            model.addAttribute("email", emailNPhone);
            model.addAttribute("nullError", "Please enter data");
            return "login";
        }
        if (mailAndPAssword.equals("dbError")) {
            model.addAttribute("email", emailNPhone);
            model.addAttribute("nullError", "Please enter data");
            return "login";
        }
        if (mailAndPAssword.equals("invalidDataError")) {
            model.addAttribute("email", emailNPhone);
            model.addAttribute("nullError", "Please enter data");
            return "login";
        }
        httpSession.setAttribute("emailNPhone",emailNPhone);

        return "user";
    }
    @GetMapping("forgetPassword")
    public  String forgetUser(){
        return  "forget";
    }

    @PostMapping("getOtp")
    public  String  getOtp(@RequestParam String email, Model model ){
        System.out.println(email);
        service.getOtp(email);
        model.addAttribute("inputEmail",email);
        return  "forget";
    }
    @PostMapping("verifyOtp")
    public  String verifyOtp(@RequestParam String  email, String otp, Model model){
        System.out.println( otp);
        System.out.println(email);
        String verifyOtp = service.verifyOtp(email, otp);
        if (verifyOtp.equals("nullErrror")) {
//            model.addAttribute("inputEmail", email);
            return "forget";
        } else if (verifyOtp.equals("error")) {
            model.addAttribute("otpError","Invalid Otp");
            model.addAttribute("inputEmail",email);
            return "forget";

        }
        model.addAttribute("inputEmail",email);
        return  "resetPassword";
    }
    @PostMapping("resetPassword")
    public  String  resetPassword(@RequestParam("email") String  email,@RequestParam("newPassword")String password,@RequestParam("confirmPassword") String confirmPassword,Model model){
        String s= service.updatePassword(email,password);
        if (!password.equals(confirmPassword)){
            return "resetPassword";
        }

        if (s.equals("noEmailError")){
            model.addAttribute("noEmailError","noEmail");
            return "resetPassword";
        }
        if (s.equals("passwordError")){
            model.addAttribute("misMatchError","password doesnot match");
            return "resetPassword";
        }
        return "login";





    }
}
