package com.petShop.app.entity;

import com.petShop.app.dto.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "getEmailRepo",query = "from PetShopEntity  where email =:email"),
        @NamedQuery(name = "getPhoneRepo",query = "from PetShopEntity  where phone =:phone"),
        @NamedQuery(name = "resetOtp", query="UPDATE PetShopEntity SET otp = NULL")
})
@Table(name = "petuser_info")
public  class PetShopEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_Name")
    private String  firstName;
    @Column(name  ="last_Name")
    private   String lastName;
    @Column(name = "email")
    private  String email;
    @Column(name="phone")
    private  Long phone;
    @Column(name = "dob")
    private  String dob;
    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "country")
    private  String country;
    @Column(name = "state")
    private  String state;
    @Column(name = "city")
    private  String city;
    @Column(name = "pincode")
    private  int pincode;
    @Column(name = "password")
    private  String password;
    @Column(name = "otp")
    private  String  otp;
@Column(name = "file_name")
    private  String  fileName;


}