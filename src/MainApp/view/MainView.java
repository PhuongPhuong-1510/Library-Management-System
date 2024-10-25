package MainApp.view;

import HomePage.view.HomePageView;
import LoginPage.view.LoginView;
import MainApp.controller.MainController;
import SignupPage.view.SignupView;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JButton closeButton, minimizeButton;
    private JLayeredPane layeredPane;
    private MainController mainController;



    public MainView() {
        this.setSize(1200, 632);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon(getClass().getResource("/LoginPage/view/icon/imgLabel.png"));
        this.setIconImage(icon.getImage());

        setUndecorated(true);
        this.setLayout(null); // Tắt layout manager để định vị thủ công

        // Tạo JLayeredPane để quản lý các lớp
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1200, 632); // Set kích thước cho layeredPane

        // Tạo nút Close
        closeButton = createButton("X", 1150, 0);
        // Tạo nút Minimize
        minimizeButton = createButton("-", 1100, 0);
        // Tạo nút Maximize

        // Đặt các nút vào layeredPane
        layeredPane.add(minimizeButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(closeButton, JLayeredPane.PALETTE_LAYER);

        // CardLayout cho việc chuyển đổi giữa các view
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBounds(0, 0, 1200, 632); // Kích thước của các panel

        // Thêm các view vào cardPanel
        cardPanel.add(new LoginView(this), "Login");
        cardPanel.add(new SignupView(this), "Signup");
        cardPanel.add(new HomePageView(this),"HomePage");

        // Thêm cardPanel vào lớp thấp hơn trong layeredPane
        layeredPane.add(cardPanel, JLayeredPane.DEFAULT_LAYER);

        // Thêm layeredPane vào JFrame
        this.add(layeredPane);

        mainController = new MainController(this);
        cardLayout.show(cardPanel, "Login");

        ToolTipManager.sharedInstance().setInitialDelay(0); // Không có độ trễ ban đầu
        ToolTipManager.sharedInstance().setDismissDelay(3000); // Độ trễ tắt tooltip là 3 giây


        this.setVisible(true);

    }

    // Phương thức tạo nút với các thuộc tính mặc định
    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setFont(new Font("Tahoma", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(85, 117, 255));
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        if (text.equals("X")) {
            button.setToolTipText("Close Window"); // Tooltip cho nút Close
        } else if (text.equals("-")) {
            button.setToolTipText("Minimize Window"); // Tooltip cho nút Minimize
        } else {
            button.setToolTipText(text + " Window"); // Tooltip cho các nút khác
        }

        button.setBounds(x, y, 50, 50); // Kích thước và vị trí của nút
        return button;
    }

    public void showCard(String cardName) {
        CardLayout cl = (CardLayout) (cardPanel.getLayout());
        switch (cardName) {
            case "Login":
                // Tạo một đối tượng mới của LoginView
                LoginView loginView = new LoginView(this);
                cardPanel.add(loginView, "Login"); // Thêm LoginView vào cardPanel
                cl.show(cardPanel, "Login"); // Chuyển đến Login
                break;
            case "Signup":
                    SignupView signupView = new SignupView(this);
                    cardPanel.add(signupView, "Signup");
                cl.show(cardPanel, "Signup");
            case"HomePage":
                HomePageView homePageView=new HomePageView(this);
                cardPanel.add(homePageView,"HomePage");
                cl.show(cardPanel,"HomePage");
        }
    }



    public JButton getCloseButton() {
        return closeButton;
    }

    public JButton getMinimizeButton() {
        return minimizeButton;
    }


}
