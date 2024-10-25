package LoginPage.controller;

import LoginPage.view.LoginView;
import java.awt.*;
import java.awt.event.*;



public class LoginController implements ActionListener, MouseListener {

    private LoginView loginView;
    private MouseEvent e;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        loginView.getLoginButton().addMouseListener(this);
        loginView.getSignupButton().addMouseListener(this);
        loginView.getBtnForgot().addMouseListener(this);


        loginView.getLoginButton().addActionListener(this);
        loginView.getSignupButton().addActionListener(this);
        loginView.getBtnForgot().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("LOGIN".equals(command)) {
            System.out.println("Nút Login được nhấn!");
            loginView.getMainView().showCard("HomePage");



        } else if ("SIGNUP".equals(command)) {
            System.out.println("Nút Signup được nhấn!");
            loginView.getMainView().showCard("Signup");
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == loginView.getLoginButton()) {
            loginView.getLoginButton().setBackground(new Color(255, 50, 0));
            loginView.getLoginButton().setPreferredSize(new Dimension(120, 40));
            loginView.getLoginButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
            loginView.getLoginButton().revalidate(); // Cập nhật lại layout
            loginView.getLoginButton().repaint(); // Vẽ lại nút
        } else if (e.getSource() == loginView.getSignupButton()) {

            loginView.getSignupButton().setBackground(new Color(192, 192, 192));
            loginView.getSignupButton().setPreferredSize(new Dimension(120, 40));
            loginView.getSignupButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
            loginView.getSignupButton().revalidate();
            loginView.getSignupButton().repaint();
        } else if (e.getSource() == loginView.getBtnForgot()) {
            loginView.getBtnForgot().setFont(new Font("Tahoma", Font.BOLD, 15)); // Đổi kiểu chữ để thêm gạch chân
            loginView.getBtnForgot().setText("<html><u>Forgot Password</u></html>"); // Thêm gạch chân
            loginView.getBtnForgot().setBounds(loginView.getBtnForgot().getX(), loginView.getBtnForgot().getY() - 2, loginView.getBtnForgot().getWidth(), loginView.getBtnForgot().getHeight() + 2); // Tăng kích thước nút
            loginView.getBtnForgot().revalidate();
            loginView.getBtnForgot().repaint();

        }







    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == loginView.getLoginButton()) {
            loginView.getLoginButton().setBackground(new Color(255, 0, 0));
            loginView.getLoginButton().setPreferredSize(new Dimension(100, 30));
            loginView.getLoginButton().setFont(new Font("Tahoma", 1, 16));
            loginView.getLoginButton().revalidate();
            loginView.getLoginButton().repaint();
        } else if (e.getSource() == loginView.getSignupButton()) {
            loginView.getSignupButton().setBackground(new Color(211, 211, 211));
            loginView.getSignupButton().setPreferredSize(new Dimension(100, 30));
            loginView.getSignupButton().setFont(new Font("Tahoma", 1, 16));
            loginView.getSignupButton().revalidate();
            loginView.getSignupButton().repaint();
        } else if (e.getSource() == loginView.getBtnForgot()) {
            loginView.getBtnForgot().setFont(new Font("Tahoma", Font.PLAIN, 14));
            loginView.getBtnForgot().setForeground(Color.WHITE);
            loginView.getBtnForgot().setText("Forgot Password");
            loginView.getBtnForgot().setBounds(loginView.getBtnForgot().getX(), loginView.getBtnForgot().getY() + 2, loginView.getBtnForgot().getWidth(), loginView.getBtnForgot().getHeight() - 2);
            loginView.getBtnForgot().revalidate();
            loginView.getBtnForgot().repaint();


        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        this.e=e;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }



    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
