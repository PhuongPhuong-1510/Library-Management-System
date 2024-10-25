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
    HomePageModel homePageModel;
    private MainView mainView;
    private JButton hamburgerButton;
    private HomePageController homePageController;
    private boolean isMenuVisible = false;// Trạng thái của menubar (ẩn hay hiện)
    private JMenuBar menuBar; // Khai báo menubar để có thể thay đổi trạng thái
    private JMenu jMenuHomePage;
    private JMenu jMenuLogout;
    private JMenu jMenuLMSDashBoard;


    private JMenu jMenuMGMTBooks;
    private JMenu jMenuMGMTSutudents;
    private JMenu jMenuIssueBook;
    private JMenu jMenuReturnBook;
    private JMenu jMenuViewBooks;
    private JMenu jMenuViewRecords;
    private JMenu jMenuDefault;



    public HomePageView(MainView mainView) {
        this.mainView = mainView;
        this.homePageModel = new HomePageModel();
        this.init();
        this.homePageController = new HomePageController(this); // Khởi tạo controller và lưu trữ

    }

    private void init() {
        this.setSize(1200, 632);
        this.setLayout(new BorderLayout());

        JPanel homePagePanel = new JPanel();
        homePagePanel.setLayout(new BorderLayout());


        menuBar = new JMenuBar();
        menuBar.setLayout(null);
        menuBar.setBackground(new Color(102, 102, 102));
        menuBar.setPreferredSize(new Dimension(300, 632));
        menuBar.setBorder(null); // Xóa viền của JMenuBar
        menuBar.setVisible(false);


        jMenuHomePage = new JMenu("Home Page");
        jMenuHomePage.setFont(new Font("Tahoma", Font.PLAIN, 17)); // Đặt font cho JMenu với size 17
        jMenuHomePage.setBounds(0, 0, 300, 50);
        ImageIcon iconHomePage = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/HomePage/view/icon/icons8_Home_26px_2.png"))).getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
        jMenuHomePage.setIcon(iconHomePage);
        jMenuHomePage.setIconTextGap(10); // Đặt khoảng cách giữa icon và text
        jMenuHomePage.setHorizontalTextPosition(SwingConstants.RIGHT); // Text nằm bên phải icon
        jMenuHomePage.setVerticalTextPosition(SwingConstants.CENTER);  // Căn giữa text theo chiều dọc so với icon
        jMenuHomePage.setHorizontalAlignment(SwingConstants.LEFT);  // Đặt toàn bộ text và icon bắt đầu từ bên trái
        jMenuHomePage.setVerticalAlignment(SwingConstants.CENTER);  // Căn giữa toàn bộ nội dung theo chiều dọc
        jMenuHomePage.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Thêm padding trên và dưới
        menuBar.add(jMenuHomePage);


        jMenuLMSDashBoard=new JMenu("LMS Notification");
        jMenuLMSDashBoard.setFont(new Font("Tahoma", Font.PLAIN, 17)); // Đặt font cho JMenu với size 17
        jMenuLMSDashBoard.setBounds(0, 50, 300, 50);
        ImageIcon iconLMS = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/HomePage/view/icon/notification.png"))).getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
        jMenuLMSDashBoard.setIcon(iconLMS);
        jMenuLMSDashBoard.setIconTextGap(10); // Đặt khoảng cách giữa icon và text
        jMenuLMSDashBoard.setHorizontalTextPosition(SwingConstants.RIGHT); // Text nằm bên phải icon
        jMenuLMSDashBoard.setVerticalTextPosition(SwingConstants.CENTER);  // Căn giữa text theo chiều dọc so với icon
        jMenuLMSDashBoard.setHorizontalAlignment(SwingConstants.LEFT);  // Đặt toàn bộ text và icon bắt đầu từ bên trái
        jMenuLMSDashBoard.setVerticalAlignment(SwingConstants.CENTER);  // Căn giữa toàn bộ nội dung theo chiều dọc
        jMenuLMSDashBoard.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Thêm padding trên và dưới
        jMenuLMSDashBoard.setBackground(Color.cyan);
        menuBar.add(jMenuLMSDashBoard);


        JLabel lblMenu = new JLabel("Features");
        lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMenu.setBounds(10, 110, 300, 20);
        menuBar.add(lblMenu);



        jMenuMGMTBooks=new JMenu("Manage Books");
        jMenuMGMTBooks.setFont(new Font("Tahoma", Font.PLAIN, 17)); // Đặt font cho JMenu với size 17
        jMenuMGMTBooks.setBounds(0, 130, 300, 50);
        ImageIcon iconMGbooks = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/HomePage/view/icon/icons8_Books_26px.png"))).getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
        jMenuMGMTBooks.setIcon(iconMGbooks);
        jMenuMGMTBooks.setIconTextGap(10); // Đặt khoảng cách giữa icon và text
        jMenuMGMTBooks.setHorizontalTextPosition(SwingConstants.RIGHT); // Text nằm bên phải icon
        jMenuMGMTBooks.setVerticalTextPosition(SwingConstants.CENTER);  // Căn giữa text theo chiều dọc so với icon
        jMenuMGMTBooks.setHorizontalAlignment(SwingConstants.LEFT);  // Đặt toàn bộ text và icon bắt đầu từ bên trái
        jMenuMGMTBooks.setVerticalAlignment(SwingConstants.CENTER);  // Căn giữa toàn bộ nội dung theo chiều dọc
        jMenuMGMTBooks.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Thêm padding trên và dưới
        menuBar.add(jMenuMGMTBooks);


        jMenuMGMTSutudents=new JMenu("Manage Students");
        jMenuMGMTSutudents.setFont(new Font("Tahoma", Font.PLAIN, 17)); // Đặt font cho JMenu với size 17
        jMenuMGMTSutudents.setBounds(0, 180, 300, 50);
        ImageIcon imgMGMTSutudents = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/HomePage/view/icon/icons8_Read_Online_26px.png"))).getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
        jMenuMGMTSutudents.setIcon(imgMGMTSutudents);
        jMenuMGMTSutudents.setIconTextGap(10); // Đặt khoảng cách giữa icon và text
        jMenuMGMTSutudents.setHorizontalTextPosition(SwingConstants.RIGHT); // Text nằm bên phải icon
        jMenuMGMTSutudents.setVerticalTextPosition(SwingConstants.CENTER);  // Căn giữa text theo chiều dọc so với icon
        jMenuMGMTSutudents.setHorizontalAlignment(SwingConstants.LEFT);  // Đặt toàn bộ text và icon bắt đầu từ bên trái
        jMenuMGMTSutudents.setVerticalAlignment(SwingConstants.CENTER);  // Căn giữa toàn bộ nội dung theo chiều dọc
        jMenuMGMTSutudents.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Thêm padding trên và dưới
        menuBar.add(jMenuMGMTSutudents);

        jMenuIssueBook=new JMenu("Issue Book");
        jMenuIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 17)); // Đặt font cho JMenu với size 17
        jMenuIssueBook.setBounds(0, 230, 300, 50);
        ImageIcon imgIssueBook = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/HomePage/view/icon/icons8_Sell_26px.png"))).getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
        jMenuIssueBook.setIcon(imgIssueBook);
        jMenuIssueBook.setIconTextGap(10); // Đặt khoảng cách giữa icon và text
        jMenuIssueBook.setHorizontalTextPosition(SwingConstants.RIGHT); // Text nằm bên phải icon
        jMenuIssueBook.setVerticalTextPosition(SwingConstants.CENTER);  // Căn giữa text theo chiều dọc so với icon
        jMenuIssueBook.setHorizontalAlignment(SwingConstants.LEFT);  // Đặt toàn bộ text và icon bắt đầu từ bên trái
        jMenuIssueBook.setVerticalAlignment(SwingConstants.CENTER);  // Căn giữa toàn bộ nội dung theo chiều dọc
        jMenuIssueBook.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Thêm padding trên và dưới
        menuBar.add(jMenuIssueBook);





        jMenuReturnBook=new JMenu("Return Book");
        jMenuReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 17)); // Đặt font cho JMenu với size 17
        jMenuReturnBook.setBounds(0, 280, 300, 50);
        ImageIcon imgReturnBook = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/HomePage/view/icon/icons8_Return_Purchase_26px.png"))).getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
        jMenuReturnBook.setIcon(imgReturnBook);
        jMenuReturnBook.setHorizontalTextPosition(SwingConstants.RIGHT); // Text nằm bên phải icon
        jMenuReturnBook.setVerticalTextPosition(SwingConstants.CENTER);  // Căn giữa text theo chiều dọc so với icon
        jMenuReturnBook.setHorizontalAlignment(SwingConstants.LEFT);  // Đặt toàn bộ text và icon bắt đầu từ bên trái
        jMenuReturnBook.setVerticalAlignment(SwingConstants.CENTER);  // Căn giữa toàn bộ nội dung theo chiều dọc
        jMenuReturnBook.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Thêm padding trên và dưới
        menuBar.add(jMenuReturnBook);



        jMenuViewRecords=new JMenu("View Records");
        jMenuViewRecords.setFont(new Font("Tahoma", Font.PLAIN, 17)); // Đặt font cho JMenu với size 17
        jMenuViewRecords.setBounds(0, 330, 300, 50);
        ImageIcon imgViewRecords = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/HomePage/view/icon/icons8_View_Details_26px.png"))).getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
        jMenuViewRecords.setIcon(imgViewRecords);
        jMenuViewRecords.setHorizontalTextPosition(SwingConstants.RIGHT); // Text nằm bên phải icon
        jMenuViewRecords.setVerticalTextPosition(SwingConstants.CENTER);  // Căn giữa text theo chiều dọc so với icon
        jMenuViewRecords.setHorizontalAlignment(SwingConstants.LEFT);  // Đặt toàn bộ text và icon bắt đầu từ bên trái
        jMenuViewRecords.setVerticalAlignment(SwingConstants.CENTER);  // Căn giữa toàn bộ nội dung theo chiều dọc
        jMenuViewRecords.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Thêm padding trên và dưới
        menuBar.add(jMenuViewRecords);




        jMenuViewBooks=new JMenu("View Issued Books");
        jMenuViewBooks.setFont(new Font("Tahoma", Font.PLAIN, 17)); // Đặt font cho JMenu với size 17
        jMenuViewBooks.setBounds(0, 380, 300, 50);
        ImageIcon imgViewBook = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/HomePage/view/icon/icons8_Books_26px.png"))).getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
        jMenuViewBooks.setIcon(imgViewBook);
        jMenuViewBooks.setHorizontalTextPosition(SwingConstants.RIGHT); // Text nằm bên phải icon
        jMenuViewBooks.setVerticalTextPosition(SwingConstants.CENTER);  // Căn giữa text theo chiều dọc so với icon
        jMenuViewBooks.setHorizontalAlignment(SwingConstants.LEFT);  // Đặt toàn bộ text và icon bắt đầu từ bên trái
        jMenuViewBooks.setVerticalAlignment(SwingConstants.CENTER);  // Căn giữa toàn bộ nội dung theo chiều dọc
        jMenuViewBooks.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Thêm padding trên và dưới
        menuBar.add(jMenuViewBooks);




        jMenuDefault=new JMenu("Defaulter list");
        jMenuDefault.setFont(new Font("Tahoma", Font.PLAIN, 17)); // Đặt font cho JMenu với size 17
        jMenuDefault.setBounds(0, 430, 300, 50);
        ImageIcon imgDefault = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/HomePage/view/icon/icons8_Conference_26px.png"))).getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
        jMenuDefault.setIcon(imgDefault);
        jMenuDefault.setHorizontalTextPosition(SwingConstants.RIGHT); // Text nằm bên phải icon
        jMenuDefault.setVerticalTextPosition(SwingConstants.CENTER);  // Căn giữa text theo chiều dọc so với icon
        jMenuDefault.setHorizontalAlignment(SwingConstants.LEFT);  // Đặt toàn bộ text và icon bắt đầu từ bên trái
        jMenuDefault.setVerticalAlignment(SwingConstants.CENTER);  // Căn giữa toàn bộ nội dung theo chiều dọc
        jMenuDefault.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Thêm padding trên và dưới
        menuBar.add(jMenuDefault);




        jMenuLogout=new JMenu("Logout");
        jMenuLogout.setFont(new Font("Tahoma", Font.PLAIN, 17)); // Đặt font cho JMenu với size 17
        jMenuLogout.setBounds(0, 480, 300, 50);
        ImageIcon imgLogout = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/HomePage/view/icon/icons8_Exit_26px_2.png"))).getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
        jMenuLogout.setIcon(imgLogout);
        jMenuLogout.setHorizontalTextPosition(SwingConstants.RIGHT); // Text nằm bên phải icon
        jMenuLogout.setVerticalTextPosition(SwingConstants.CENTER);  // Căn giữa text theo chiều dọc so với icon
        jMenuLogout.setHorizontalAlignment(SwingConstants.LEFT);  // Đặt toàn bộ text và icon bắt đầu từ bên trái
        jMenuLogout.setVerticalAlignment(SwingConstants.CENTER);  // Căn giữa toàn bộ nội dung theo chiều dọc
        jMenuLogout.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Thêm padding trên và dưới
        menuBar.add(jMenuLogout);






        homePagePanel.add(menuBar, BorderLayout.WEST); // Thêm menubar vào phía trái của homePagePanel



        JPanel homeMenu = new JPanel();
        homeMenu.setLayout(null);
        homeMenu.setBackground(new Color(85, 117, 255));

        hamburgerButton = new JButton();
        ImageIcon icon_menu = new ImageIcon(Objects.requireNonNull(getClass().getResource("/HomePage/view/icon/icons8_menu_48px_1.png")));
        hamburgerButton.setBounds(10, 8, 40, 40);
        hamburgerButton.setIcon(icon_menu);
        hamburgerButton.setBorderPainted(false); // Ẩn viền
        hamburgerButton.setBackground(new Color(85, 117, 255));
        homeMenu.add(hamburgerButton);

        JLabel lblIcon = new JLabel("|");
        lblIcon.setFont(new Font("Tahoma", Font.PLAIN, 45));
        lblIcon.setForeground(Color.BLACK);
        lblIcon.setBounds(55, 0, 50, 45);
        homeMenu.add(lblIcon);

        JLabel imgAdmin = new JLabel();
        imgAdmin.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/HomePage/view/icon/male_user_50px.png"))));
        imgAdmin.setBounds(935,0,50,50);
        homeMenu.add(imgAdmin);
        JLabel lblAdmin = new JLabel("Welcome, Admin");
        lblAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15)); // Sửa dấu nháy đơn thành nháy kép
        lblAdmin.setBounds(985, 20, 120, 20); // Đặt kích thước và vị trí cho lblAdmin
        lblAdmin.setForeground(Color.WHITE);
        homeMenu.add(lblAdmin); // Thêm lblAdmin vào homeMenu
        homeMenu.setPreferredSize(new Dimension(1200, 50));


        JLabel timeLabel=new JLabel();
        homeMenu.add(timeLabel);
        timeLabel.setBounds(70,5,80,20);
        JLabel dateLabel=new JLabel();
        dateLabel.setBounds(70,30,80,20);
        homeMenu.add(dateLabel);

        Timer timer = new Timer(0, e -> {
            Date now = new Date();
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            timeLabel.setText(timeFormat.format(now));
            dateLabel.setText(dateFormat.format(now));

            timeLabel.repaint();
            timeLabel.revalidate();
            dateLabel.repaint();
            dateLabel.revalidate();
        });
        timer.start();
        homePagePanel.add(homeMenu, BorderLayout.NORTH); // Thêm homeMenu vào homePagePanel



        this.add(homePagePanel);
        this.setVisible(true);
    }

    public JButton getHamburgerButton() {
        return hamburgerButton;
    }

    public void setHamburgerButton(JButton hamburgerButton) {
        this.hamburgerButton = hamburgerButton;
    }

    // Phương thức để hiện/ẩn menubar
    public void toggleMenuBar() {
        isMenuVisible = !isMenuVisible; // Đổi trạng thái hiện/ẩn
        menuBar.setVisible(isMenuVisible); // Thiết lập trạng thái hiển thị cho menubar
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

}
