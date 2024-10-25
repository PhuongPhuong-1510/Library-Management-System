package HomePage.controller;

import HomePage.view.HomePageView;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;

public class HomePageController implements ActionListener, MouseListener {
    private final HomePageView homePageView;

    public HomePageController(HomePageView homePageView) {
        this.homePageView = homePageView;
        initializeListeners();
    }

    private void initializeListeners() {
        homePageView.getHamburgerButton().addActionListener(this);
        homePageView.getHamburgerButton().addMouseListener(createButtonHoverListener(
                new Color(0, 51, 204), new Color(85, 117, 255)));

        addMenuHoverEffect(homePageView.getjMenuHomePage());
        addMenuHoverEffect(homePageView.getjMenuDefault());
        addMenuHoverEffect(homePageView.getjMenuLogout());
        addMenuHoverEffect(homePageView.getjMenuIssueBook());
        addMenuHoverEffect(homePageView.getjMenuMGMTSutudents());
        addMenuHoverEffect(homePageView.getjMenuReturnBook());
        addMenuHoverEffect(homePageView.getjMenuLMSDashBoard());
        addMenuHoverEffect(homePageView.getjMenuMGMTBooks());
        addMenuHoverEffect(homePageView.getjMenuViewBooks());
        addMenuHoverEffect(homePageView.getjMenuViewRecords());

        addLogoutMenuListener(homePageView.getjMenuLogout());
    }

    private MouseAdapter createButtonHoverListener(Color hoverColor, Color defaultColor) {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                homePageView.getHamburgerButton().setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                homePageView.getHamburgerButton().setBackground(defaultColor);
            }
        };
    }

    private void addMenuHoverEffect(JMenu menu) {
        menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                menu.setOpaque(true);
                menu.setBackground(new Color(163, 184, 204));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                menu.setOpaque(false);
                menu.setBackground(new Color(102, 102, 102));
            }
        });
    }

    private void addLogoutMenuListener(JMenu menu) {
        menu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                if (menu == homePageView.getjMenuLogout()) {
                    System.out.println("Logout clicked!");
                    homePageView.getMainView().showCard("Login");
                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {}

            @Override
            public void menuCanceled(MenuEvent e) {}
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homePageView.getHamburgerButton()) {
            homePageView.toggleMenuBar();
            System.out.println("Hamburger button clicked!");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
