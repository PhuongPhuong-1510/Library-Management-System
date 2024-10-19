package MainApp.controller;

import MainApp.view.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainController implements ActionListener {
    private MainView mainView;
    private boolean isMaximized = false; // Trạng thái hiện tại của cửa sổ

    public MainController(MainView mainView) {
        this.mainView = mainView;

        // Thêm ActionListener cho các nút
        mainView.getCloseButton().addActionListener(this);
        mainView.getMinimizeButton().addActionListener(this);

        // Thêm sự kiện thay đổi màu khi di chuột vào nút Close
        mainView.getCloseButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mainView.getCloseButton().setBackground(Color.RED); // Đổi màu nền sang đỏ khi di chuột vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainView.getCloseButton().setBackground(new Color(85, 117, 255)); // Trả về màu nền gốc
            }
        });

        // Thêm sự kiện thay đổi màu khi di chuột vào nút Minimize
        mainView.getMinimizeButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mainView.getMinimizeButton().setBackground(Color.RED); // Đổi màu nền khi di chuột vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainView.getMinimizeButton().setBackground(new Color(85, 117, 255)); // Trả về màu nền gốc
            }
        });

        // Thêm sự kiện thay đổi màu khi di chuột vào nút Maximize

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainView.getCloseButton()) {
            // Xử lý sự kiện khi nút Close được nhấn
            System.exit(0); // Đóng ứng dụng
        } else if (e.getSource() == mainView.getMinimizeButton()) {
            // Xử lý sự kiện khi nút Minimize được nhấn
            mainView.setState(JFrame.ICONIFIED); // Thu nhỏ cửa sổ
        }
    }

    }
