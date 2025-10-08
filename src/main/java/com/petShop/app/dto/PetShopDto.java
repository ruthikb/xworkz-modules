package com.petShop.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.ImmutableEntityEntry;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetShopDto {

    private int id;
    @NotBlank(message = "first name cannot be blank")
    private String  firstName;
    @NotBlank(message = "last name cannot be blank")
    private   String lastName;
    @NotBlank(message = "email cannot be blank")
    private  String email;
    @NotNull(message = "phone cannot be blank")
    private  Long phone;
    @NotBlank(message = "dob cannot be blank")
    private  String dob;
    @NotNull(message = "gender cannot be blank")
    private  Gender gender;
    @NotBlank(message = "country cannot be blank")
    private  String country;
    @NotBlank(message = "state cannot be blank")
    private  String state;
    @NotBlank(message = "city cannot be blank")
    private  String city;
    @NotNull(message = "pincode cannot be blank")
    private  int pincode;
    @NotBlank(message = "password cannot be blank")
    private  String password;
    @NotBlank(message = "confirm pasword cannot be blank")
    private  String confirmPassword;
    private  String  otp;

    private MultipartFile fileUpload;

    private  String fileName;

}
