package com.petShop.app.service;

import com.petShop.app.dto.PetShopDto;

public interface PetShopService {

    boolean saveUser(PetShopDto petShopDto);

    PetShopDto findEmailService(String email);

    PetShopDto getPhoneService(long phone);

    String checkMailAndPAssword(String emailNPhone, String password);

    String getOtp(String email);

    String  verifyOtp(String email, String otp);

    String updatePassword(String email, String password);

    PetShopDto getUser(String email);

    String updateProfile(PetShopDto petShopDto);
}
