package SignupPage.model;

import java.util.ArrayList;
import java.util.List;

public class SignupModel {
    private String email;
    private String contact;
    private String password;
    private String confirmPassword;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String[] validateInput() {
        String emailError = null;
        String passwordError = null;
        String confirmPasswordError = null;
        String contactError = null;

        // Kiểm tra email
        if (email == null || !email.contains("@")) {
            emailError = "Email must be in the correct format!";
        }

        // Kiểm tra mật khẩu
        if (password.length() < 8 ||
                !password.matches(".*[a-z].*") ||
                !password.matches(".*[A-Z].*") ||
                !password.matches(".*[0-9].*") ||
                !password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            passwordError = "Password must be at least 8 characters long and include uppercase letters, lowercase letters, numbers, and special characters!";
        }

        // Kiểm tra xác nhận mật khẩu
        if (!password.equals(confirmPassword)) {
            confirmPasswordError = "Confirm password does not match!";
        }

        // Kiểm tra số điện thoại
        if (contact.length() != 10 || !contact.startsWith("0")) {
            contactError = "Phone number must start with 0 and have 10 digits!";
        }


        return new String[]{emailError, passwordError, confirmPasswordError, contactError}; // Trả về các lỗi
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


}
