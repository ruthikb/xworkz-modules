package com.petShop.app.repo.impl;

import com.petShop.app.dto.PetShopDto;
import com.petShop.app.entity.LoginEntity;
import com.petShop.app.entity.PetShopEntity;
import com.petShop.app.repo.PetShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Repository
public class PetShopRepoImpl implements PetShopRepo {
    @Autowired
    EntityManagerFactory factory;

    @Override
    public boolean saveUser(PetShopEntity petShop) {
        System.err.println(petShop);
        System.out.println("repo got invoked");
        EntityManager entityManager=factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(petShop);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public PetShopEntity findEmailRepo(String email) {
        EntityManager entityManager= factory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("getEmailRepo");
            query.setParameter("email",email);
            transaction.commit();
            return (PetShopEntity) query.getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PetShopEntity getPhoneRepo(long phone) {
        EntityManager entityManager=factory.createEntityManager();
        try {
            Query query=entityManager.createNamedQuery("getPhoneRepo");
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            query.setParameter("phone",phone);
            transaction.commit();
            return (PetShopEntity) query.getSingleResult();
        }catch (Exception e){
            return  null;
        }

    }
    @Override
    public boolean emailNPhone(LoginEntity loginEntity) {
        System.err.println(loginEntity);
        EntityManager entityManager=factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(loginEntity);
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public boolean getOtp(PetShopEntity petShop) {
        System.out.println(petShop);
        EntityManager entityManager=factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(petShop);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return  false;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public boolean updatePassword(PetShopEntity petShop) {
        EntityManager entityManager = factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(petShop);
            entityManager.getTransaction().commit();
            return  true;
        }
        catch (Exception e){
            return  false;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public void resetOtpRepo() {
        EntityManager entityManager = factory.createEntityManager();
        try {
            Query query=entityManager.createNamedQuery("resetOtp");
            entityManager.getTransaction().begin();
            query.executeUpdate();
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public boolean updateProfile(PetShopEntity entity) {
        EntityManager entityManager=factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            return  true;
        }
        catch (Exception e){
            e.printStackTrace();
            return  false;
        }
        finally {
            entityManager.close();
        }

    }


}
