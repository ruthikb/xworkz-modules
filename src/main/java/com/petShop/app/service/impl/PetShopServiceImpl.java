package com.petShop.app.service.impl;
import com.petShop.app.dto.LoginDto;
import com.petShop.app.dto.PetShopDto;
import com.petShop.app.entity.LoginEntity;
import com.petShop.app.entity.PetShopEntity;
import com.petShop.app.repo.PetShopRepo;
import com.petShop.app.service.PetShopService;
import com.petShop.app.util.OtpGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
@Service
public class PetShopServiceImpl implements PetShopService {

    private  static  final  String UPLOAD_FILE="C:/Users/kruth/IdeaProjects/Model-pet-shop/src/main/resources/pathfile/";
    @Autowired
    PetShopRepo petShopRepo;

    @Autowired
    OtpGenerator otpGenerator;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public boolean saveUser(PetShopDto petShopDto) {
        findEmailService(petShopDto.getEmail());
        if (!petShopDto.getPassword().equals(petShopDto.getConfirmPassword())){
            System.out.println("password invalid ");
            return  false;
        }
        else {
            petShopDto.setPassword(bCryptPasswordEncoder.encode(petShopDto.getPassword()));
            System.out.println("password valid");
            PetShopEntity petShop = new PetShopEntity();
            BeanUtils.copyProperties(petShopDto, petShop);
            return petShopRepo.saveUser(petShop);
        }
    }

    @Override
    public PetShopDto findEmailService(String email) {
        PetShopEntity entity = new PetShopEntity();
        entity=petShopRepo.findEmailRepo(email);
        if (entity!=null)
        {
            PetShopDto dto = new PetShopDto();
            BeanUtils.copyProperties(entity,dto);
            return dto;
        }
        return null;
    }

    @Override
    public PetShopDto getPhoneService(long phone) {
        System.out.println(phone);
        PetShopEntity entity=new PetShopEntity();
        entity=petShopRepo.getPhoneRepo(phone);
        System.out.println(entity);
        if (entity!=null)
        {
            PetShopDto dto=new PetShopDto();
            BeanUtils.copyProperties(entity,dto);
            System.out.println(dto);
            return dto;
        }
        return null;
    }

    @Override
    public String checkMailAndPAssword(String emailNPhone, String password){
        if (emailNPhone == null && password == null){
            return "nullError";
        }
        if (emailNPhone.contains("@")){
            PetShopDto dto=findEmailService(emailNPhone);
            String  email = isSaved(emailNPhone, password, dto);
            return  email;
        }
        else if (emailNPhone != null){
            PetShopDto petShopDto=getPhoneService(Long.parseLong(emailNPhone));
            String phone = isSaved(password, emailNPhone, petShopDto);
            return  phone;
        }
        return "invalidDataError";
    }

    @Override
    public String  getOtp(String email) {
        if (email==null){
            return  "nullError";
        }
        if (email.contains("@gmail.com")){
            PetShopDto dto =findEmailService(email);
            if (dto!=null) {
                if (dto.getEmail().equals(email)) {
                    String otp = otpGenerator.sendSimpleMessage(email);
                    dto.setOtp(otp);
                    PetShopEntity petShop =new PetShopEntity();
                    BeanUtils.copyProperties(dto,petShop);
                   boolean isRegister= petShopRepo.getOtp(petShop);
                    System.out.println(isRegister);
                }
            }
        }
        return "allGood";
    }

    @Override
    public String verifyOtp(String email, String otp) {
        PetShopDto dto=findEmailService(email);
        System.out.println( otp);
        System.out.println("null error");
        if (dto==null) {
            return "nullErrror";
        }
        if (otp.equals(dto.getOtp())){
            System.out.println(otp);
            System.out.println("all good");
            return  "allGood";
        }
        return "error";
    }

    @Override
    public String  updatePassword(String email, String password) {
      PetShopEntity  petShopDto= petShopRepo.findEmailRepo(email);
        if (petShopDto==null){
            System.out.println("password null");
            return  "noEmailError";
        }
        if (password.equals(petShopDto.getPassword())){
            System.out.println("password doesnot match");
            return "passwordError";
        }

       petShopDto.setPassword(bCryptPasswordEncoder.encode(password));
        System.out.println("all good"+ password);
//        System.out.println(encode);
        petShopRepo.updatePassword(petShopDto);
        return "noError";
    }

    @Override
    public PetShopDto getUser(String email) {
        PetShopEntity entity=petShopRepo.findEmailRepo(email);
        PetShopDto petShopDto=new PetShopDto();
        BeanUtils.copyProperties(entity,petShopDto);
        return petShopDto;
    }

    @Override
    public String updateProfile(PetShopDto petShopDto) {
        if (!saveFile(petShopDto)){
            return "file notSaved";
        }
        else {
            PetShopEntity entity=new PetShopEntity();
            BeanUtils.copyProperties(petShopDto,entity);
            entity.setFileName(petShopDto.getFileUpload().getOriginalFilename());
            System.err.println(entity);
            petShopRepo.updateProfile(entity);
        }
        return "";
    }

    private boolean saveFile(PetShopDto petShopDto) {
        MultipartFile multipartFile=petShopDto.getFileUpload();
        System.err.println(multipartFile.getOriginalFilename());
        try{
            byte[] bytes=multipartFile.getBytes();
            Path path=Paths.get(UPLOAD_FILE+multipartFile.getOriginalFilename());
            Files.write(path,bytes);
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    private String isSaved(String emailNPhone, String password, PetShopDto dto) {
        if (dto == null){
            return "dataError";
        }
        boolean matches = bCryptPasswordEncoder.matches(password, dto.getPassword());
        System.out.println(matches);
        if (!bCryptPasswordEncoder.matches(password,dto.getPassword())){
            return "passwordError";
        }
        LoginDto loginDto = emailNPhone(dto, password, emailNPhone);
        LoginEntity loginEntity = new LoginEntity();
        BeanUtils.copyProperties(loginDto,loginEntity);
        boolean email = petShopRepo.emailNPhone(loginEntity);
       if (!email){
           return "dbError";
       }
       return "All right";
    }

    private  LoginDto emailNPhone(PetShopDto petShopDto,String password,String  emailNPhone){
        if (petShopDto==null){
            System.out.println(emailNPhone);
            return null;
        }
        boolean matches = bCryptPasswordEncoder.matches(password, petShopDto.getPassword());
        if (!matches) {
            System.out.println("Invalid Password for user: " + emailNPhone);
            return null;
        }
            LoginDto loginDto=new LoginDto();
            loginDto.setEmail(emailNPhone);
            loginDto.setPassword(petShopDto.getPassword());
            loginDto.setLoginDate(LocalDate.now());
           loginDto.setLoginTime(LocalTime.now());

        LoginEntity loginEntity=new LoginEntity();
        BeanUtils.copyProperties(loginDto,loginEntity);
        return loginDto;

    }


}
