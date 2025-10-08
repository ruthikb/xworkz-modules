package com.petShop.app.repo;

import com.petShop.app.dto.PetShopDto;
import com.petShop.app.entity.LoginEntity;
import com.petShop.app.entity.PetShopEntity;

public interface PetShopRepo {
    boolean saveUser(PetShopEntity petShop);

    PetShopEntity findEmailRepo(String email);

    PetShopEntity getPhoneRepo(long phone);

    boolean emailNPhone(LoginEntity petShop);

    boolean getOtp(PetShopEntity petShop);

    boolean updatePassword(PetShopEntity petShopDto);

    void resetOtpRepo();


    boolean updateProfile(PetShopEntity entity);
}
