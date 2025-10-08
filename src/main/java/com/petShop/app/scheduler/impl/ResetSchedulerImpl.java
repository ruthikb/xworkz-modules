package com.petShop.app.scheduler.impl;

import com.petShop.app.repo.PetShopRepo;
import com.petShop.app.scheduler.ResetScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ResetSchedulerImpl implements ResetScheduler {

    @Autowired
    PetShopRepo petShopRepo;

    @Override
    @Scheduled(fixedRate = 50000)
    public void resetOpt() {
        petShopRepo.resetOtpRepo();
    }
}
