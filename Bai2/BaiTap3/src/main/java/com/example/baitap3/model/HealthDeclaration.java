package com.example.baitap3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

public class HealthDeclaration {
    @NotBlank(message = "Họ tên không được để trống")
    private String fullName;

    @NotBlank(message = "CMND/Hộ chiếu không được để trống")
    private String idNumber;

    @NotBlank(message = "Năm sinh không được để trống")
    @Pattern(regexp = "\\d{4}", message = "Năm sinh phải có 4 chữ số")
    private String yearOfBirth;

    @NotBlank(message = "Giới tính không được để trống")
    private String gender;

    @NotBlank(message = "Quốc tịch không được để trống")
    private String nationality;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;


    private String district;
    private String ward;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "\\d{10,11}", message = "Số điện thoại phải có 10-11 chữ số")
    private String phone;

    private String email;

    @NotEmpty(message = "Vui lòng chọn phương tiện đi lại")
    private List<String> transportations;

    @NotEmpty(message = "Vui lòng chọn triệu chứng (hoặc 'Không triệu chứng')")
    private List<String> symptoms;



    public HealthDeclaration(String fullName, String idNumber, String yearOfBirth, String gender, String nationality, String address, String district, String ward, String phone, String email, List<String> transportations, List<String> symptoms) {
        this.fullName = fullName;
        this.idNumber = idNumber;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.address = address;
        this.district = district;
        this.ward = ward;
        this.phone = phone;
        this.email = email;
        this.transportations = transportations;
        this.symptoms = symptoms;

    }
    public HealthDeclaration() {
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }




    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getTransportations() {
        return transportations;
    }

    public void setTransportations(List<String> transportations) {
        this.transportations = transportations;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }




    @Override
    public String toString() {
        return "HealthDeclaration{" +
                "fullName='" + fullName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", address='" + address + '\'' +
                ", district='" + district + '\'' +
                ", ward='" + ward + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", transportations=" + transportations +
                ", symptoms=" + symptoms +
                '}';
    }
}

