package com.example.oliomart.modals;

public class UserModalClass {

    String _id, msg, jtoken, username, email, phone, password, confirmpassword, gender, address, city, state, userpincode, role;
    Integer otp;
    Boolean isVerifiedOtp;

    //constructor for OTP
//    public UserModalClass(Integer otp, Boolean isVerifiedOtp) {
//        this.otp = otp;
//        this.isVerifiedOtp = isVerifiedOtp;
//    }

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public Boolean getVerifiedOtp() {
        return isVerifiedOtp;
    }

    public void setVerifiedOtp(Boolean verifiedOtp) {
        isVerifiedOtp = verifiedOtp;
    }

    //Constructor for logging in user
    public UserModalClass(String email, String password) {
        this.email = email;
        this.password = password;
    }

    //Constructor for New User Registration
    public UserModalClass(String username, String email, String phone, String password, String confirmpassword, String gender) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.gender = gender;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getJtoken() {
        return jtoken;
    }

    public void setJtoken(String jtoken) {
        this.jtoken = jtoken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUserpincode() {
        return userpincode;
    }

    public void setUserpincode(String userpincode) {
        this.userpincode = userpincode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
