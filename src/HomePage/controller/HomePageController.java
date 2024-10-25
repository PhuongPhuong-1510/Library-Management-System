package HomePage.controller;

import HomePage.view.HomePageView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePageController implements ActionListener {
    private HomePageView homePageView;

    public HomePageController(HomePageView homePageView) {
        this.homePageView = homePageView;
        homePageView.getHamburgerButton().addActionListener(this);

        // Thêm sự kiện thay đổi màu khi di chuột vào nút Hamburger
        homePageView.getHamburgerButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                homePageView.getHamburgerButton().setBackground(new Color(0, 51, 204)); // Đổi màu nền khi di chuột vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                homePageView.getHamburgerButton().setBackground(new Color(85, 117, 255)); // Trả về màu nền gốc
            }
        });

        // Thêm hiệu ứng hover cho JMenu trong menuBar
        addMenuHoverEffect(homePageView.getjMenuHomePage(), new Color(163,184,204));
        addMenuHoverEffect(homePageView.getjMenuDefault(), new Color(163,184,204));
        addMenuHoverEffect(homePageView.getjMenuLogout(), new Color(163,184,204));
        addMenuHoverEffect(homePageView.getjMenuIssueBook(),new Color(163,184,204));
        addMenuHoverEffect(homePageView.getjMenuMGMTSutudents(), new Color(163,184,204));
        addMenuHoverEffect(homePageView.getjMenuReturnBook(), new Color(163,184,204));
        addMenuHoverEffect(homePageView.getjMenuLMSDashBoard(), new Color(163,184,204));
        addMenuHoverEffect(homePageView.getjMenuMGMTBooks(), new Color(163,184,204));
        addMenuHoverEffect(homePageView.getjMenuViewBooks(), new Color(163,184,204));
        addMenuHoverEffect(homePageView.getjMenuViewRecords(), new Color(163,184,204));




        // Gọi các JMenu khác tương tự
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homePageView.getHamburgerButton()) {
            homePageView.toggleMenuBar();
            System.out.println("Hamburger button clicked!");
        }
    }

    // Phương thức thêm MouseListener cho mỗi JMenu
    private void addMenuHoverEffect(JMenu menu, Color hoverColor) {
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu.setOpaque(true);
                menu.setBackground(hoverColor);  // Đổi màu khi di chuột qua
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu.setOpaque(false);
                menu.setBackground(new Color(102,102,102));


            }
        });
    }
}
