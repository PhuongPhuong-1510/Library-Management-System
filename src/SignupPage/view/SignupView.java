
package SignupPage.view;
import LoginPage.view.OvalButton;
import LoginPage.view.PlaceholderPasswordField;
import MainApp.view.MainView;
import SignupPage.model.SignupModel;

import javax.swing.*;
import java.awt.*;

public class SignupView extends JPanel {
    SignupModel signupModel;

    private JTextField txtUserName;
    private JTextField txtPassWord;
    private JTextField txtConfirmPass;
    private JTextField txtContactNumber;
    private JButton btnLogin;
    private JButton btnSignUp;
    private MainView mainView; // Biến để lưu trữ đối tượng MainView
    private JLabel lblEmailError;
    private JLabel lblPasswordError;
    private JLabel lblConfirmPasswordError;
    private JLabel lblContactError;




    public SignupView(MainView mainView) {
        this.mainView = mainView; // Lưu đối tượng MainView
        this.init();
        new SignupPage.controller.SignupController(this);
    }

    private void init() {


        //set layout cho JFrame
        this.setLayout(new BorderLayout());

        // Tạo JLabel chứa hình ảnh
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(getClass().getResource("/SignupPage/view/icon/imgLabel.png")));
        imageLabel.setLayout(null);  // Layout null để tự do đặt vị trí của văn bản

        // Tạo JLayeredPane để chồng các JLabel lên ảnh
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(750, 632)); // Kích thước của LayeredPane khớp với ảnh
        layeredPane.setLayout(null);  // Layout null để tự do set vị trí các thành phần bên trong

        // Đặt JLabel chứa hình ảnh vào lớp nền (layer 0)
        imageLabel.setBounds(0, 0, 750, 632);  // Set vị trí và kích thước cho JLabel chứa ảnh
        layeredPane.add(imageLabel, Integer.valueOf(0));  // Lớp nền

        // Thêm dòng chữ "WELCOME TO"
        JLabel welcomeLabel = new JLabel("WELCOME TO");
        welcomeLabel.setFont(new Font(" Tahonma", 0, 22));
        welcomeLabel.setForeground(Color.RED);
        welcomeLabel.setBounds(290, 10, 300, 34);  // Đặt vị trí tự do trên LayeredPane
        layeredPane.add(welcomeLabel, Integer.valueOf(1));  // Lớp trên cùng

        // Thêm dòng chữ "ADVANCE LIBRARY"
        JLabel libraryLabel = new JLabel("ADVANCE LIBRARY");
        libraryLabel.setFont(new Font("Tahoma", 0, 22));
        libraryLabel.setForeground(Color.BLUE);
        libraryLabel.setBounds(270, 45, 300, 50);  // Đặt vị trí tự do
        layeredPane.add(libraryLabel, Integer.valueOf(1));  // Lớp trên cùng

        // Thêm layeredPane vào JFrame với BorderLayout
        this.add(layeredPane, BorderLayout.WEST);  // Đặt ở phía West theo BorderLayout


        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(new Color(85, 117, 255));//mau nen xanh


        JLabel lblWelcome = new JLabel("Signup Page");
        lblWelcome.setFont(new Font("Tahoma", 0, 30));
        lblWelcome.setForeground(Color.WHITE);
        lblWelcome.setBounds(150, 30, 200, 50); // (x, y, width, height)
        loginPanel.add(lblWelcome);

        // Login to your account label
        JLabel lblLoginMsg = new JLabel("Creat New Account Here");
        lblLoginMsg.setFont(new Font("Tahoma", 0, 18));
        lblLoginMsg.setForeground(Color.WHITE);
        lblLoginMsg.setBounds(130, 80, 250, 30);
        loginPanel.add(lblLoginMsg);

        // Username label
        JLabel lblUsername = new JLabel("Email :");
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Tahoma", 0, 16));
        lblUsername.setBounds(50, 170, 150, 45); // Điều chỉnh lại vị trí
        lblUsername.setIcon(new ImageIcon(getClass().getResource("/SignupPage/view/icon/userName.png")));
        loginPanel.add(lblUsername);

// Tạo kiểu cho JTextField (username)
        txtUserName = new PlaceholderPasswordField("abc@gmail.com",0); // Placeholder text
        txtUserName.setBounds(200, 185, 200, 30);
        txtUserName.setOpaque(false); // Đặt nền trong suốt
        txtUserName.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE)); // Đường viền dưới màu trắng
        loginPanel.add(txtUserName);


// Password label
        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Tahoma", 0, 15));
        lblPassword.setBounds(50, 240, 150, 45); // Điều chỉnh lại vị trí cho khớp với Username
        lblPassword.setIcon(new ImageIcon(getClass().getResource("/SignupPage/view/icon/passWord.png")));
        loginPanel.add(lblPassword);

// Tạo kiểu cho JPasswordField (password)
        txtPassWord = new PlaceholderPasswordField("Enter your new password",1); // Placeholder text
        txtPassWord.setBounds(200, 235, 200, 30);
        txtPassWord.setOpaque(false); // Đặt nền trong suốt
        txtPassWord.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE)); // Đường viền dưới màu trắng
        loginPanel.add(txtPassWord);




// Tạo kiểu cho JPasswordField (password)
        txtConfirmPass = new PlaceholderPasswordField("Enter confirm password",1); // Placeholder text
        txtConfirmPass.setBounds(200, 280, 200, 30);
        txtConfirmPass.setOpaque(false); // Đặt nền trong suốt
        txtConfirmPass.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE)); // Đường viền dưới màu trắng
        loginPanel.add(txtConfirmPass);




        // Tạo JLabel cho số điện thoại (Contact Number)
        JLabel lblContactNumber = new JLabel("Contact Number :");
        lblContactNumber.setForeground(Color.WHITE);
        lblContactNumber.setFont(new Font("Tahoma", 0, 15));
        lblContactNumber.setBounds(55, 325, 150, 45); // Điều chỉnh lại vị trí cho khớp với các thành phần khác
        lblContactNumber.setIcon(new ImageIcon(getClass().getResource("/SignupPage/view/icon/contact.png"))); // Đảm bảo rằng bạn có icon cho số điện thoại
        loginPanel.add(lblContactNumber);

// Tạo JTextField cho nhập số điện thoại (Contact Number)
        txtContactNumber = new PlaceholderPasswordField("0***",0); // Placeholder text
        txtContactNumber.setBounds(205, 325, 200, 30);
        txtContactNumber.setOpaque(false); // Đặt nền trong suốt
        txtContactNumber.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE)); // Đường viền dưới màu trắng
        loginPanel.add(txtContactNumber);






// Login button
        this.btnSignUp = new OvalButton("SIGNUP");
        btnSignUp.setBackground(new Color(255, 94, 77)); // Màu đỏ cho nút
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.setBounds(120, 390, 100, 30); // Điều chỉnh vị trí phù hợp phía dưới Password
        btnSignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginPanel.add(btnSignUp);

// Signup button
        this.btnLogin = new OvalButton("LOGIN");
        btnLogin.setBackground(new Color(192, 192, 192)); // Màu xám cho nút
        btnLogin.setBounds(240, 390, 100, 30); // Điều chỉnh vị trí phù hợp cạnh Login
        btnLogin.setToolTipText("Do you already have an account?"); // Thêm tooltip
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginPanel.add(btnLogin);




        lblEmailError = new JLabel("!");
        lblEmailError.setForeground(Color.RED);
        lblEmailError.setFont(new Font("Arial", Font.BOLD, 20)); // Thiết lập font và kích thước
        lblEmailError.setVisible(false); // Ẩn dấu chấm than ban đầu

        lblPasswordError = new JLabel("!");
        lblPasswordError.setForeground(Color.RED);
        lblPasswordError.setFont(new Font("Arial", Font.BOLD, 20)); // Thiết lập font và kích thước
        lblPasswordError.setVisible(false); // Ẩn dấu chấm than ban đầu

        lblConfirmPasswordError = new JLabel("!");
        lblConfirmPasswordError.setForeground(Color.RED);
        lblConfirmPasswordError.setFont(new Font("Arial", Font.BOLD, 20)); // Thiết lập font và kích thước
        lblConfirmPasswordError.setVisible(false); // Ẩn dấu chấm than ban đầu

        lblContactError = new JLabel("!");
        lblContactError.setForeground(Color.RED);
        lblContactError.setFont(new Font("Arial", Font.BOLD, 20)); // Thiết lập font và kích thước
        lblContactError.setVisible(false); // Ẩn dấu chấm than ban đầu

        // Add error labels to the panel at appropriate positions
        loginPanel.add(lblEmailError);
        loginPanel.add(lblPasswordError);
        loginPanel.add(lblConfirmPasswordError);
        loginPanel.add(lblContactError);

        // Set bounds for error labels (with larger width and height for circular effect)
        lblEmailError.setBounds(410, 185, 30, 30); // Điều chỉnh kích thước cho hiệu ứng tròn
        lblPasswordError.setBounds(410, 240, 30, 30);
        lblConfirmPasswordError.setBounds(410, 280, 30, 30);
        lblContactError.setBounds(410, 325, 30, 30);



        loginPanel.setFocusable(true);
        loginPanel.requestFocus(); // Đặt focus cho loginPanel, không cho txtUserName có focus
        // Thêm loginPanel vào frame
        this.add(loginPanel);
        this.setVisible(true);


    }

    // Trong LoginView.java
    public JButton getLoginButton() {
        return btnLogin;
    }

    public JButton getSignupButton() {
        return btnSignUp;
    }


    public MainView getMainView() {
        return mainView;
    }
    public String getUserName() {
        return txtUserName.getText().trim(); // Trả về email
    }

    public String getPassword() {
        return txtPassWord.getText(); // Trả về mật khẩu
    }

    public String getConfirmPassword() {
        return txtConfirmPass.getText(); // Trả về mật khẩu xác nhận
    }

    public String getContactNumber() {
        return txtContactNumber.getText(); // Trả về số điện thoại
    }

    // Phương thức để hiển thị thông báo lỗi
    public void showErrorMessages(String messages) {
        JOptionPane.showMessageDialog(this, messages, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void updateErrorMessages(String emailError, String passwordError, String confirmPasswordError, String contactError) {
        // Cập nhật dấu chấm than cho Email
        lblEmailError.setVisible(emailError != null);

        // Nếu có lỗi, hiển thị thông điệp trong console (hoặc trong UI nếu cần)
        if (emailError != null) {
            lblEmailError.setToolTipText(emailError); // Hiển thị tooltip khi di chuột
        }

        // Cập nhật dấu chấm than cho Password
        lblPasswordError.setVisible(passwordError != null);
        if (passwordError != null) {
            lblPasswordError.setToolTipText(passwordError);
        }

        // Cập nhật dấu chấm than cho Confirm Password
        lblConfirmPasswordError.setVisible(confirmPasswordError != null);
        if (confirmPasswordError != null) {
            lblConfirmPasswordError.setToolTipText(confirmPasswordError);
        }

        // Cập nhật dấu chấm than cho Contact Number
        lblContactError.setVisible(contactError != null);
        if (contactError != null) {
            lblContactError.setToolTipText(contactError);
        }
    }


    public void resetFields() {
        txtUserName.setText(""); // Đặt lại email
        txtPassWord.setText(""); // Đặt lại mật khẩu
        txtConfirmPass.setText(""); // Đặt lại mật khẩu xác nhận
        txtContactNumber.setText(""); // Đặt lại số điện thoại

        // Đặt lại thông báo lỗi
        updateErrorMessages(null, null, null, null);
    }



}

