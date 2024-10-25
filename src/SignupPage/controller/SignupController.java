package SignupPage.controller;

import SignupPage.view.SignupView;
import java.awt.*;
import java.awt.event.*;
import SignupPage.model.SignupModel;
import SignupPage.view.SignupView;

import javax.swing.*;


public class SignupController implements ActionListener, MouseListener {

    private SignupView signupView;
    private SignupModel signupModel;
    private MouseEvent e;

    public SignupController(SignupView signupView) {
        this.signupView = signupView;
        this.signupModel = new SignupModel(); // Đảm bảo dòng này không bị bỏ qua

        signupView.getLoginButton().addMouseListener(this);
        signupView.getSignupButton().addMouseListener(this);

        signupView.getLoginButton().addActionListener(this);
        signupView.getSignupButton().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("LOGIN".equals(command)) {
            int response = JOptionPane.showConfirmDialog(signupView, "Do you want to continue?", "Confirmation",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                signupView.getMainView().showCard("Login");
            }
        } else if ("SIGNUP".equals(command)) {
            signupModel.setEmail(signupView.getUserName());
            signupModel.setPassword(signupView.getPassword());
            signupModel.setContact(signupView.getContactNumber());
            signupModel.setConfirmPassword(signupView.getConfirmPassword());

            // Kiểm tra tính hợp lệ
            String[] errors = signupModel.validateInput();

            // Cập nhật thông báo lỗi trong view
            signupView.updateErrorMessages(errors[0], errors[1], errors[2], errors[3]);

            // Tạo thông điệp lỗi tổng hợp
            StringBuilder errorMessage = new StringBuilder("Please correct the following errors:\n");
            boolean hasErrors = false;

            // Kiểm tra các lỗi và thêm vào thông điệp
            if (errors[0] != null) {
                errorMessage.append("- ").append(errors[0]).append("\n");
                hasErrors = true;
            }
            if (errors[1] != null) {
                errorMessage.append("- ").append(errors[1]).append("\n");
                hasErrors = true;
            }
            if (errors[2] != null) {
                errorMessage.append("- ").append(errors[2]).append("\n");
                hasErrors = true;
            }
            if (errors[3] != null) {
                errorMessage.append("- ").append(errors[3]).append("\n");
                hasErrors = true;
            }

            // Nếu có lỗi, hiển thị hộp thoại nhắc nhở
            if (hasErrors) {
                JOptionPane.showMessageDialog(signupView, errorMessage.toString(), "Error Notification", JOptionPane.ERROR_MESSAGE);
            }

            // Nếu không có lỗi, hiển thị thông báo thành công
            if (!hasErrors) {
                JOptionPane.showMessageDialog(signupView, "Registration Successful!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                signupView.getMainView().showCard("Login");
            }
        }

    }


    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == signupView.getSignupButton()) {
            // Đổi màu khi di chuột vào nút LOGIN
            signupView.getSignupButton().setBackground(new Color(255, 50, 0)); // Màu đỏ đậm hơn
            signupView.getSignupButton().setPreferredSize(new Dimension(120, 40)); // Kích thước lớn hơn
            signupView.getSignupButton().setFont(new Font("Tahoma", Font.PLAIN, 14)); // Giảm kích thước phông chữ
            signupView.getSignupButton().revalidate(); // Cập nhật lại layout
            signupView.getSignupButton().repaint(); // Vẽ lại nút
        } else if (e.getSource() == signupView.getLoginButton()) {
            // Đổi màu khi di chuột vào nút SIGNUP
            signupView.getLoginButton().setBackground(new Color(192, 192, 192)); // Màu xám đậm hơn
            signupView.getLoginButton().setPreferredSize(new Dimension(120, 40)); // Kích thước lớn hơn
            signupView.getLoginButton().setFont(new Font("Tahoma", Font.PLAIN, 14)); // Giảm kích thước phông chữ
            signupView.getLoginButton().revalidate(); // Cập nhật lại layout
            signupView.getLoginButton().repaint(); // Vẽ lại nút
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == signupView.getSignupButton()) {
            // Khôi phục màu và kích thước ban đầu khi chuột rời khỏi nút LOGIN
            signupView.getSignupButton().setBackground(new Color(255, 0, 0)); // Màu đỏ
            signupView.getSignupButton().setPreferredSize(new Dimension(100, 30)); // Kích thước ban đầu
            signupView.getSignupButton().setFont(new Font("Tahoma", 1, 16)); // Kích thước phông chữ ban đầu
            signupView.getSignupButton().revalidate(); // Cập nhật lại layout
            signupView.getSignupButton().repaint(); // Vẽ lại nút
        } else if (e.getSource() == signupView.getLoginButton()) {
            // Khôi phục màu và kích thước ban đầu khi chuột rời khỏi nút SIGNUP
            signupView.getLoginButton().setBackground(new Color(211, 211, 211)); // Màu xám nhạt
            signupView.getLoginButton().setPreferredSize(new Dimension(100, 30)); // Kích thước ban đầu
            signupView.getLoginButton().setFont(new Font("Tahoma", 1, 16)); // Kích thước phông chữ ban đầu
            signupView.getLoginButton().revalidate(); // Cập nhật lại layout
            signupView.getLoginButton().repaint(); // Vẽ lại nút
        }


    }
    @Override
    public void mousePressed(MouseEvent e) {
        this.e=e;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // Optional: Có thể xử lý logic khi nút được nhấp vào
    }



    @Override
    public void mouseReleased(MouseEvent e) {
        // Optional: Xử lý khi nhả nút
    }


}
