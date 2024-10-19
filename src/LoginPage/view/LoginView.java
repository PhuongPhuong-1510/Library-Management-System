package LoginPage.view;


import LoginPage.controller.LoginController;
import LoginPage.model.LoginModel;
import MainApp.view.MainView;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class LoginView extends JPanel {
    LoginModel loginModel;
    private JTextField txtUserName;
    private JTextField txtPassWord;
    private JButton btnLogin;
    private JButton btnSignUp;
    private JButton btnForgot;
    private final MainView mainView;
    private JRadioButton rbUser;
    private JRadioButton rbAdmin;
    ButtonGroup roleGroup = new ButtonGroup();




    public LoginView(MainView mainView) {
        this.mainView = mainView;
        this.loginModel = new LoginModel();
        this.init();
        new LoginController(this);
    }

    private void init() {
        this.setSize(1200, 632);


        //set layout cho JFrame
        this.setLayout(new BorderLayout());

        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/LoginPage/view/icon/imgLabel.png"))));
        imageLabel.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(750, 632));
        layeredPane.setLayout(null);

        imageLabel.setBounds(0, 0, 750, 632);
        layeredPane.add(imageLabel, Integer.valueOf(0));

        JLabel welcomeLabel = new JLabel("WELCOME TO");
        welcomeLabel.setFont(new Font(" Tahonma", Font.PLAIN, 22));
        welcomeLabel.setForeground(Color.RED);
        welcomeLabel.setBounds(280, 15, 300, 34);
        layeredPane.add(welcomeLabel, Integer.valueOf(1));

        // Thêm dòng chữ "ADVANCE LIBRARY"
        JLabel libraryLabel = new JLabel("ADVANCE LIBRARY");
        libraryLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        libraryLabel.setForeground(Color.BLUE);
        libraryLabel.setBounds(260, 50, 300, 50);
        layeredPane.add(libraryLabel, Integer.valueOf(1));

        this.add(layeredPane, BorderLayout.WEST);


        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(new Color(85, 117, 255));


        JLabel lblWelcome = new JLabel("Welcome!");
        lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblWelcome.setForeground(Color.WHITE);
        lblWelcome.setBounds(150, 30, 200, 50);
        loginPanel.add(lblWelcome);

        JLabel lblLoginMsg = new JLabel("Login To Your Account");
        lblLoginMsg.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblLoginMsg.setForeground(Color.WHITE);
        lblLoginMsg.setBounds(130, 80, 250, 30);
        loginPanel.add(lblLoginMsg);

        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblUsername.setBounds(50, 170, 150, 45);
        lblUsername.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/LoginPage/view/icon/userName.png"))));
        loginPanel.add(lblUsername);

        txtUserName = new PlaceholderPasswordField("Enter your email",0);
        txtUserName.setBounds(200, 185, 200, 30);
        txtUserName.setOpaque(false);
        txtUserName.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        loginPanel.add(txtUserName);


        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPassword.setBounds(50, 240, 150, 45);
        lblPassword.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/LoginPage/view/icon/passWord.png"))));
        loginPanel.add(lblPassword);

        txtPassWord = new PlaceholderPasswordField("Enter your password",1);
        txtPassWord.setBounds(200, 235, 200, 30);
        txtPassWord.setOpaque(false);
        txtPassWord.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        loginPanel.add(txtPassWord);










        this.btnLogin = new OvalButton("LOGIN");
        btnLogin.setBackground(new Color(255, 94, 77));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBounds(120, 320, 100, 30);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginPanel.add(btnLogin);

        this.btnSignUp = new OvalButton("SIGNUP");
        btnSignUp.setBackground(new Color(192, 192, 192));
        btnSignUp.setBounds(240, 320, 100, 30);
        btnSignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginPanel.add(btnSignUp);

        btnForgot = new JButton("Forgot Password");
        btnForgot.setForeground(Color.WHITE);
        btnForgot.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnForgot.setBorderPainted(false);
        btnForgot.setContentAreaFilled(false);
        btnForgot.setFocusPainted(false);
        btnForgot.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnForgot.setBounds(120, 370, 250, 60);

        btnForgot.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/LoginPage/view/icon/forgotPassword.png")))); // Thêm icon cho nút
        assert btnForgot != null;
        btnForgot.setHorizontalTextPosition(SwingConstants.RIGHT);
        loginPanel.add(btnForgot);







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

    public JButton getBtnForgot() {
        return btnForgot;
    }

    public void setBtnForgot(JButton btnForgot) {
        this.btnForgot = btnForgot;
    }


    public MainView getMainView() {
        return mainView;
    }
    public void resetFields() {
        txtUserName.setText(""); // Đặt lại tên đăng nhập
        txtPassWord.setText(""); // Đặt lại mật khẩu

        // Đặt lại thông báo lỗi
        updateErrorMessages(null, null);
    }

    public void updateErrorMessages(String emailError, String passwordError) {
        // Cập nhật thông báo lỗi cho các trường tương ứng
        txtUserName.setVisible(emailError != null);
        if (emailError != null) {
            txtUserName.setToolTipText(emailError); // Hiển thị tooltip khi di chuột
        }

        txtPassWord.setVisible(passwordError != null);
        if (passwordError != null) {
            txtPassWord.setToolTipText(passwordError);
        }
    }


}
