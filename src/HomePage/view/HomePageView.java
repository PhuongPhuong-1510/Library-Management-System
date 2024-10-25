package HomePage.view;

import HomePage.controller.HomePageController;
import HomePage.model.HomePageModel;
import MainApp.view.MainView;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class HomePageView extends JPanel {
    private HomePageModel homePageModel;
    private MainView mainView;
    private JButton hamburgerButton;
    private HomePageController homePageController;
    private boolean isMenuVisible = false;
    private JMenuBar menuBar;

    private JMenu jMenuHomePage, jMenuLogout, jMenuLMSDashBoard, jMenuMGMTBooks, jMenuMGMTSutudents,
            jMenuIssueBook, jMenuReturnBook, jMenuViewBooks, jMenuViewRecords, jMenuDefault;

    public HomePageView(MainView mainView) {
        this.mainView = mainView;
        this.homePageModel = new HomePageModel();
        init();
        this.homePageController = new HomePageController(this);
    }

    private void init() {
        setSize(1200, 632);
        setLayout(new BorderLayout());

        JPanel homePagePanel = new JPanel(new BorderLayout());
        homePagePanel.add(createMenuBar(), BorderLayout.WEST);
        homePagePanel.add(createHomeMenu(), BorderLayout.NORTH);

        add(homePagePanel);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        menuBar = new JMenuBar();
        menuBar.setLayout(null);
        menuBar.setBackground(new Color(102, 102, 102));
        menuBar.setPreferredSize(new Dimension(300, 632));
        menuBar.setBorder(null);
        menuBar.setVisible(false);

        jMenuHomePage = createMenu("Home Page", "/HomePage/view/icon/icons8_Home_26px_2.png", 0);
        jMenuLMSDashBoard = createMenu("LMS Notification", "/HomePage/view/icon/notification.png", 50);
        jMenuMGMTBooks = createMenu("Manage Books", "/HomePage/view/icon/icons8_Books_26px.png", 130);
        jMenuMGMTSutudents = createMenu("Manage Students", "/HomePage/view/icon/icons8_Read_Online_26px.png", 180);
        jMenuIssueBook = createMenu("Issue Book", "/HomePage/view/icon/icons8_Sell_26px.png", 230);
        jMenuReturnBook = createMenu("Return Book", "/HomePage/view/icon/icons8_Return_Purchase_26px.png", 280);
        jMenuViewRecords = createMenu("View Records", "/HomePage/view/icon/icons8_View_Details_26px.png", 330);
        jMenuViewBooks = createMenu("View Issued Books", "/HomePage/view/icon/icons8_Books_26px.png", 380);
        jMenuDefault = createMenu("Defaulter list", "/HomePage/view/icon/icons8_Conference_26px.png", 430);
        jMenuLogout = createMenu("Logout", "/HomePage/view/icon/icons8_Exit_26px_2.png", 480);

        JLabel lblMenu = new JLabel("Features");
        lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMenu.setBounds(10, 110, 300, 20);
        menuBar.add(lblMenu);

        return menuBar;
    }

    private JMenu createMenu(String title, String iconPath, int yPosition) {
        JMenu menu = new JMenu(title);
        menu.setFont(new Font("Tahoma", Font.PLAIN, 17));
        menu.setBounds(0, yPosition, 300, 50);
        menu.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource(iconPath)))
                .getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH)));
        menu.setIconTextGap(10);
        menu.setHorizontalTextPosition(SwingConstants.RIGHT);
        menu.setVerticalTextPosition(SwingConstants.CENTER);
        menu.setHorizontalAlignment(SwingConstants.LEFT);
        menu.setVerticalAlignment(SwingConstants.CENTER);
        menu.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        menuBar.add(menu);
        return menu;
    }

    private JPanel createHomeMenu() {
        JPanel homeMenu = new JPanel(null);
        homeMenu.setBackground(new Color(85, 117, 255));
        homeMenu.setPreferredSize(new Dimension(1200, 50));

        hamburgerButton = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("/HomePage/view/icon/icons8_menu_48px_1.png"))));
        hamburgerButton.setBounds(10, 8, 40, 40);
        hamburgerButton.setBorderPainted(false);
        hamburgerButton.setBackground(new Color(85, 117, 255));
        homeMenu.add(hamburgerButton);

        JLabel lblIcon = new JLabel("|");
        lblIcon.setFont(new Font("Tahoma", Font.PLAIN, 45));
        lblIcon.setForeground(Color.BLACK);
        lblIcon.setBounds(55, 0, 50, 45);
        homeMenu.add(lblIcon);

        JLabel imgAdmin = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/HomePage/view/icon/male_user_50px.png"))));
        imgAdmin.setBounds(935, 0, 50, 50);
        homeMenu.add(imgAdmin);

        JLabel lblAdmin = new JLabel("Welcome, Admin");
        lblAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblAdmin.setBounds(985, 20, 120, 20);
        lblAdmin.setForeground(Color.WHITE);
        homeMenu.add(lblAdmin);

        createDateTimeLabels(homeMenu);

        return homeMenu;
    }

    private void createDateTimeLabels(JPanel panel) {
        JLabel timeLabel = new JLabel();
        JLabel dateLabel = new JLabel();

        timeLabel.setBounds(70, 5, 80, 20);
        dateLabel.setBounds(70, 30, 80, 20);

        Timer timer = new Timer(0, e -> {
            Date now = new Date();
            timeLabel.setText(new SimpleDateFormat("hh:mm:ss a").format(now));
            dateLabel.setText(new SimpleDateFormat("dd/MM/yyyy").format(now));
            timeLabel.repaint();
            dateLabel.repaint();
        });
        timer.start();

        panel.add(timeLabel);
        panel.add(dateLabel);
    }

    public JButton getHamburgerButton() {
        return hamburgerButton;
    }

    public void toggleMenuBar() {
        isMenuVisible = !isMenuVisible;
        menuBar.setVisible(isMenuVisible);
    }



    public void setHamburgerButton(JButton hamburgerButton) {
        this.hamburgerButton = hamburgerButton;
    }


    public JMenu getjMenuHomePage() {
        return jMenuHomePage;
    }

    public void setjMenuHomePage(JMenu jMenuHomePage) {
        this.jMenuHomePage = jMenuHomePage;
    }

    public JMenu getjMenuLogout() {
        return jMenuLogout;
    }

    public void setjMenuLogout(JMenu jMenuLogout) {
        this.jMenuLogout = jMenuLogout;
    }

    public JMenu getjMenuLMSDashBoard() {
        return jMenuLMSDashBoard;
    }

    public void setjMenuLMSDashBoard(JMenu jMenuLMSDashBoard) {
        this.jMenuLMSDashBoard = jMenuLMSDashBoard;
    }

    public JMenu getjMenuMGMTBooks() {
        return jMenuMGMTBooks;
    }

    public void setjMenuMGMTBooks(JMenu jMenuMGMTBooks) {
        this.jMenuMGMTBooks = jMenuMGMTBooks;
    }

    public JMenu getjMenuMGMTSutudents() {
        return jMenuMGMTSutudents;
    }

    public void setjMenuMGMTSutudents(JMenu jMenuMGMTSutudents) {
        this.jMenuMGMTSutudents = jMenuMGMTSutudents;
    }

    public JMenu getjMenuIssueBook() {
        return jMenuIssueBook;
    }

    public void setjMenuIssueBook(JMenu jMenuIssueBook) {
        this.jMenuIssueBook = jMenuIssueBook;
    }

    public JMenu getjMenuReturnBook() {
        return jMenuReturnBook;
    }

    public void setjMenuReturnBook(JMenu jMenuReturnBook) {
        this.jMenuReturnBook = jMenuReturnBook;
    }

    public JMenu getjMenuViewBooks() {
        return jMenuViewBooks;
    }

    public void setjMenuViewBooks(JMenu jMenuViewBooks) {
        this.jMenuViewBooks = jMenuViewBooks;
    }

    public JMenu getjMenuViewRecords() {
        return jMenuViewRecords;
    }

    public void setjMenuViewRecords(JMenu jMenuViewRecords) {
        this.jMenuViewRecords = jMenuViewRecords;
    }

    public JMenu getjMenuDefault() {
        return jMenuDefault;
    }

    public void setjMenuDefault(JMenu jMenuDefault) {
        this.jMenuDefault = jMenuDefault;
    }

    public MainView getMainView()
    {
        return mainView;
    }
}
