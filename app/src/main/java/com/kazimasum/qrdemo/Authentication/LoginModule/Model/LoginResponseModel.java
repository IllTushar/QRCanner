package com.kazimasum.qrdemo.Authentication.LoginModule.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponseModel
{
    @SerializedName("status")
@Expose
private Integer status;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("data")
    @Expose
    private Data data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public class Data {
        @SerializedName("auth")
        @Expose
        private Auth auth;
        @SerializedName("employee")
        @Expose
        private Employee employee;

        public Auth getAuth() {
            return auth;
        }

        public void setAuth(Auth auth) {
            this.auth = auth;
        }

        public Employee getEmployee() {
            return employee;
        }

        public void setEmployee(Employee employee) {
            this.employee = employee;
        }

        public class Employee {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("user_id")
            @Expose
            private Integer userId;
            @SerializedName("employee_code")
            @Expose
            private String employeeCode;
            @SerializedName("alternate_mobile")
            @Expose
            private String alternateMobile;
            @SerializedName("date_of_birth")
            @Expose
            private String dateOfBirth;
            @SerializedName("father_name")
            @Expose
            private String fatherName;
            @SerializedName("father_profession")
            @Expose
            private String fatherProfession;
            @SerializedName("mother_name")
            @Expose
            private String motherName;
            @SerializedName("mother_profession")
            @Expose
            private String motherProfession;
            @SerializedName("permanent_addr")
            @Expose
            private String permanentAddr;
            @SerializedName("temporary_addr")
            @Expose
            private String temporaryAddr;
            @SerializedName("joining_date")
            @Expose
            private String joiningDate;
            @SerializedName("designation")
            @Expose
            private String designation;
            @SerializedName("exit_date")
            @Expose
            private Object exitDate;
            @SerializedName("exit_reason")
            @Expose
            private String exitReason;
            @SerializedName("full_n_final")
            @Expose
            private Integer fullNFinal;
            @SerializedName("pf_percent")
            @Expose
            private Integer pfPercent;
            @SerializedName("manager_user_id")
            @Expose
            private Integer managerUserId;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public String getEmployeeCode() {
                return employeeCode;
            }

            public void setEmployeeCode(String employeeCode) {
                this.employeeCode = employeeCode;
            }

            public String getAlternateMobile() {
                return alternateMobile;
            }

            public void setAlternateMobile(String alternateMobile) {
                this.alternateMobile = alternateMobile;
            }

            public String getDateOfBirth() {
                return dateOfBirth;
            }

            public void setDateOfBirth(String dateOfBirth) {
                this.dateOfBirth = dateOfBirth;
            }

            public String getFatherName() {
                return fatherName;
            }

            public void setFatherName(String fatherName) {
                this.fatherName = fatherName;
            }

            public String getFatherProfession() {
                return fatherProfession;
            }

            public void setFatherProfession(String fatherProfession) {
                this.fatherProfession = fatherProfession;
            }

            public String getMotherName() {
                return motherName;
            }

            public void setMotherName(String motherName) {
                this.motherName = motherName;
            }

            public String getMotherProfession() {
                return motherProfession;
            }

            public void setMotherProfession(String motherProfession) {
                this.motherProfession = motherProfession;
            }

            public String getPermanentAddr() {
                return permanentAddr;
            }

            public void setPermanentAddr(String permanentAddr) {
                this.permanentAddr = permanentAddr;
            }

            public String getTemporaryAddr() {
                return temporaryAddr;
            }

            public void setTemporaryAddr(String temporaryAddr) {
                this.temporaryAddr = temporaryAddr;
            }

            public String getJoiningDate() {
                return joiningDate;
            }

            public void setJoiningDate(String joiningDate) {
                this.joiningDate = joiningDate;
            }

            public String getDesignation() {
                return designation;
            }

            public void setDesignation(String designation) {
                this.designation = designation;
            }

            public Object getExitDate() {
                return exitDate;
            }

            public void setExitDate(Object exitDate) {
                this.exitDate = exitDate;
            }

            public String getExitReason() {
                return exitReason;
            }

            public void setExitReason(String exitReason) {
                this.exitReason = exitReason;
            }

            public Integer getFullNFinal() {
                return fullNFinal;
            }

            public void setFullNFinal(Integer fullNFinal) {
                this.fullNFinal = fullNFinal;
            }

            public Integer getPfPercent() {
                return pfPercent;
            }

            public void setPfPercent(Integer pfPercent) {
                this.pfPercent = pfPercent;
            }

            public Integer getManagerUserId() {
                return managerUserId;
            }

            public void setManagerUserId(Integer managerUserId) {
                this.managerUserId = managerUserId;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }
        }

        public class Auth {
            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("profile_img")
            @Expose
            private Object profileImg;
            @SerializedName("email")
            @Expose
            private String email;
            @SerializedName("facebook_id")
            @Expose
            private Object facebookId;
            @SerializedName("google_id")
            @Expose
            private Object googleId;
            @SerializedName("mobile")
            @Expose
            private String mobile;
            @SerializedName("email_verified_at")
            @Expose
            private String emailVerifiedAt;
            @SerializedName("status")
            @Expose
            private Integer status;
            @SerializedName("fcm_token")
            @Expose
            private String fcmToken;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getProfileImg() {
                return profileImg;
            }

            public void setProfileImg(Object profileImg) {
                this.profileImg = profileImg;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public Object getFacebookId() {
                return facebookId;
            }

            public void setFacebookId(Object facebookId) {
                this.facebookId = facebookId;
            }

            public Object getGoogleId() {
                return googleId;
            }

            public void setGoogleId(Object googleId) {
                this.googleId = googleId;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getEmailVerifiedAt() {
                return emailVerifiedAt;
            }

            public void setEmailVerifiedAt(String emailVerifiedAt) {
                this.emailVerifiedAt = emailVerifiedAt;
            }

            public Integer getStatus() {
                return status;
            }

            public void setStatus(Integer status) {
                this.status = status;
            }

            public String getFcmToken() {
                return fcmToken;
            }

            public void setFcmToken(String fcmToken) {
                this.fcmToken = fcmToken;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }
        }
    }
}
