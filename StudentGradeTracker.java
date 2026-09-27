import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentGradeTracker extends JFrame {

    // =========================================================
    // COLORS
    // =========================================================

    private final Color DARK = new Color(20, 23, 38);
    private final Color DARK2 = new Color(29, 33, 52);

    private final Color PURPLE = new Color(108, 76, 255);
    private final Color PURPLE2 = new Color(139, 92, 246);

    private final Color BLUE = new Color(59, 130, 246);
    private final Color GREEN = new Color(34, 197, 94);
    private final Color ORANGE = new Color(249, 115, 22);
    private final Color RED = new Color(239, 68, 68);

    private final Color BG = new Color(246, 247, 252);
    private final Color CARD = Color.WHITE;

    private final Color TEXT = new Color(31, 35, 48);
    private final Color MUTED = new Color(107, 114, 128);

    // =========================================================
    // DATA
    // =========================================================

    static class Student {

        int id;
        String name;
        double marks;

        Student(int id, String name, double marks) {
            this.id = id;
            this.name = name;
            this.marks = marks;
        }

        String getGrade() {

            if (marks > 90)
                return "O";
            else if (marks >= 80)
                return "A+";
            else if (marks >= 70)
                return "A";
            else if (marks >= 60)
                return "B";
            else if (marks >= 50)
                return "C";
            else
                return "F";
        }
    }

    static ArrayList<Student> students =
            new ArrayList<>();

    // =========================================================
    // MAIN UI
    // =========================================================

    JPanel contentPanel;

    JLabel totalLabel;
    JLabel averageLabel;
    JLabel highestLabel;
    JLabel lowestLabel;

    DefaultTableModel tableModel;
    JTable table;

    JTextField searchField;

    public StudentGradeTracker() {

        setTitle("GradeFlow - Student Management");
        setSize(1400, 850);
        setMinimumSize(
                new Dimension(1100, 700)
        );

        setLocationRelativeTo(null);
        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        createUI();
    }

    // =========================================================
    // CREATE UI
    // =========================================================

    private void createUI() {

        JPanel root =
                new JPanel(new BorderLayout());

        root.setBackground(BG);

        root.add(
                createSidebar(),
                BorderLayout.WEST
        );

        contentPanel =
                new JPanel(new BorderLayout());

        contentPanel.setBackground(BG);

        contentPanel.add(
                createHeader(),
                BorderLayout.NORTH
        );

        contentPanel.add(
                createDashboard(),
                BorderLayout.CENTER
        );

        root.add(
                contentPanel,
                BorderLayout.CENTER
        );

        add(root);
    }

    // =========================================================
    // SIDEBAR
    // =========================================================

    private JPanel createSidebar() {

        JPanel sidebar =
                new JPanel(new BorderLayout());

        sidebar.setPreferredSize(
                new Dimension(245, 0)
        );

        sidebar.setBackground(DARK);

        // -------------------------------
        // Logo
        // -------------------------------

        JPanel logo =
                new JPanel(new BorderLayout());

        logo.setBackground(DARK);

        logo.setBorder(
                new EmptyBorder(
                        30, 25, 30, 20
                )
        );

        JLabel logoIcon =
                new JLabel("🎓");

        logoIcon.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        32
                )
        );

        JLabel logoText =
                new JLabel(
                        "<html>" +
                        "<b style='font-size:20px'>Grade</b>" +
                        "<b style='font-size:20px;color:#8b5cf6'>Flow</b>" +
                        "<br>" +
                        "<font color='#9ca3af' size='2'>" +
                        "Student Management" +
                        "</font>" +
                        "</html>"
                );

        logoText.setBorder(
                new EmptyBorder(
                        0, 12, 0, 0
                )
        );

        logo.add(
                logoIcon,
                BorderLayout.WEST
        );

        logo.add(
                logoText,
                BorderLayout.CENTER
        );

        sidebar.add(
                logo,
                BorderLayout.NORTH
        );

        // -------------------------------
        // Menu
        // -------------------------------

        JPanel menu =
                new JPanel();

        menu.setBackground(DARK);

        menu.setBorder(
                new EmptyBorder(
                        10, 15, 10, 15
                )
        );

        menu.setLayout(
                new BoxLayout(
                        menu,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel menuLabel =
                new JLabel("MENU");

        menuLabel.setForeground(
                new Color(130, 136, 155)
        );

        menuLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        11
                )
        );

        menuLabel.setBorder(
                new EmptyBorder(
                        5, 12, 15, 0
                )
        );

        menu.add(menuLabel);

        JButton dashboard =
                menuButton(
                        "⌂",
                        "Dashboard"
                );

        JButton studentsButton =
                menuButton(
                        "👨‍🎓",
                        "Students"
                );

        JButton addButton =
                menuButton(
                        "＋",
                        "Add Student"
                );

        JButton reportButton =
                menuButton(
                        "▣",
                        "Reports"
                );

        menu.add(dashboard);
        menu.add(studentsButton);
        menu.add(addButton);
        menu.add(reportButton);

        dashboard.addActionListener(
                e -> showDashboard()
        );

        studentsButton.addActionListener(
                e -> showStudents()
        );

        addButton.addActionListener(
                e -> showAddStudent()
        );

        reportButton.addActionListener(
                e -> showReports()
        );

        sidebar.add(
                menu,
                BorderLayout.CENTER
        );

        // -------------------------------
        // Bottom Profile
        // -------------------------------

        JPanel bottom =
                new JPanel(
                        new BorderLayout()
                );

        bottom.setBackground(DARK2);

        bottom.setBorder(
                new EmptyBorder(
                        18, 18, 18, 18
                )
        );

        JLabel avatar =
                new JLabel("RS");

        avatar.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        avatar.setForeground(Color.WHITE);

        avatar.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        avatar.setOpaque(true);
        avatar.setBackground(PURPLE);

        avatar.setPreferredSize(
                new Dimension(42, 42)
        );

        JLabel user =
                new JLabel(
                        "<html>" +
                        "<b style='color:white'>Admin</b>" +
                        "<br>" +
                        "<font color='#9ca3af'>Administrator</font>" +
                        "</html>"
                );

        user.setBorder(
                new EmptyBorder(
                        0, 10, 0, 0
                )
        );

        bottom.add(
                avatar,
                BorderLayout.WEST
        );

        bottom.add(
                user,
                BorderLayout.CENTER
        );

        sidebar.add(
                bottom,
                BorderLayout.SOUTH
        );

        return sidebar;
    }

    // =========================================================
    // SIDEBAR BUTTON
    // =========================================================

    private JButton menuButton(
            String icon,
            String text
    ) {

        JButton button =
                new JButton();

        button.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        50
                )
        );

        button.setPreferredSize(
                new Dimension(
                        210,
                        50
                )
        );

        button.setLayout(
                new BorderLayout()
        );

        button.setBackground(DARK);

        button.setBorder(
                new EmptyBorder(
                        0, 15, 0, 10
                )
        );

        button.setFocusPainted(false);
        button.setBorderPainted(false);

        JLabel iconLabel =
                new JLabel(icon);

        iconLabel.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        18
                )
        );

        JLabel textLabel =
                new JLabel(text);

        textLabel.setForeground(
                new Color(
                        215, 218, 230
                )
        );

        textLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        button.add(
                iconLabel,
                BorderLayout.WEST
        );

        button.add(
                textLabel,
                BorderLayout.CENTER
        );

        button.addMouseListener(
                new MouseAdapter() {

                    public void mouseEntered(
                            MouseEvent e
                    ) {

                        button.setBackground(
                                PURPLE
                        );

                        textLabel.setForeground(
                                Color.WHITE
                        );
                    }

                    public void mouseExited(
                            MouseEvent e
                    ) {

                        button.setBackground(
                                DARK
                        );

                        textLabel.setForeground(
                                new Color(
                                        215,
                                        218,
                                        230
                                )
                        );
                    }
                }
        );

        return button;
    }

    // =========================================================
    // HEADER
    // =========================================================

    private JPanel createHeader() {

        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setBackground(
                Color.WHITE
        );

        header.setBorder(
                new EmptyBorder(
                        20, 30, 20, 30
                )
        );

        JLabel title =
                new JLabel(
                        "Student Grade Tracker"
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        23
                )
        );

        title.setForeground(TEXT);

        JLabel status =
                new JLabel(
                        "●  System Active"
                );

        status.setForeground(
                GREEN
        );

        status.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        header.add(
                title,
                BorderLayout.WEST
        );

        header.add(
                status,
                BorderLayout.EAST
        );

        return header;
    }

    // =========================================================
    // DASHBOARD
    // =========================================================

    private JPanel createDashboard() {

        JPanel page =
                new JPanel(
                        new BorderLayout()
                );

        page.setBackground(BG);

        page.setBorder(
                new EmptyBorder(
                        25, 30, 30, 30
                )
        );

        // =====================================================
        // HERO
        // =====================================================

        JPanel hero =
                new GradientPanel();

        hero.setLayout(
                new BorderLayout()
        );

        hero.setBorder(
                new EmptyBorder(
                        30, 35, 30, 35
                )
        );

        JPanel heroText =
                new JPanel();

        heroText.setOpaque(false);

        heroText.setLayout(
                new BoxLayout(
                        heroText,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel welcome =
                new JLabel(
                        "Welcome back! 👋"
                );

        welcome.setForeground(
                Color.WHITE
        );

        welcome.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        26
                )
        );

        JLabel heroDescription =
                new JLabel(
                        "Manage students, track grades and monitor academic performance."
                );

        heroDescription.setForeground(
                new Color(
                        230, 230, 250
                )
        );

        heroDescription.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        heroText.add(welcome);

        heroText.add(
                Box.createVerticalStrut(7)
        );

        heroText.add(
                heroDescription
        );

        hero.add(
                heroText,
                BorderLayout.WEST
        );

        JButton add =
                new JButton(
                        "+  Add Student"
                );

        styleButton(
                add,
                Color.WHITE,
                PURPLE
        );

        add.addActionListener(
                e -> showAddStudent()
        );

        hero.add(
                add,
                BorderLayout.EAST
        );

        // =====================================================
        // STATISTICS
        // =====================================================

        JPanel stats =
                new JPanel(
                        new GridLayout(
                                1,
                                4,
                                18,
                                0
                        )
                );

        stats.setBackground(BG);

        stats.setBorder(
                new EmptyBorder(
                        20, 0, 20, 0
                )
        );

        totalLabel =
                new JLabel("0");

        averageLabel =
                new JLabel("0.00");

        highestLabel =
                new JLabel("0.00");

        lowestLabel =
                new JLabel("0.00");

        stats.add(
                statCard(
                        "TOTAL STUDENTS",
                        "👥",
                        totalLabel,
                        PURPLE
                )
        );

        stats.add(
                statCard(
                        "AVERAGE SCORE",
                        "📊",
                        averageLabel,
                        BLUE
                )
        );

        stats.add(
                statCard(
                        "HIGHEST SCORE",
                        "🏆",
                        highestLabel,
                        GREEN
                )
        );

        stats.add(
                statCard(
                        "LOWEST SCORE",
                        "📉",
                        lowestLabel,
                        ORANGE
                )
        );

        // =====================================================
        // TABLE CARD
        // =====================================================

        JPanel tableCard =
                new JPanel(
                        new BorderLayout()
                );

        tableCard.setBackground(
                Color.WHITE
        );

        tableCard.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        230,
                                        232,
                                        240
                                )
                        ),
                        new EmptyBorder(
                                20, 20, 20, 20
                        )
                )
        );

        JPanel tableHeader =
                new JPanel(
                        new BorderLayout()
                );

        tableHeader.setBackground(
                Color.WHITE
        );

        JLabel recent =
                new JLabel(
                        "Recent Students"
                );

        recent.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        recent.setForeground(TEXT);

        JLabel count =
                new JLabel(
                        "  " +
                        students.size() +
                        " records"
                );

        count.setForeground(MUTED);

        JPanel heading =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                0,
                                0
                        )
                );

        heading.setBackground(
                Color.WHITE
        );

        heading.add(recent);
        heading.add(count);

        // Search

        searchField =
                new JTextField();

        searchField.setPreferredSize(
                new Dimension(
                        220,
                        38
                )
        );

        searchField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        225,
                                        228,
                                        237
                                )
                        ),
                        new EmptyBorder(
                                5, 12, 5, 12
                        )
                )
        );

        searchField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        searchField.putClientProperty(
                "JTextField.placeholderText",
                "Search student..."
        );

        searchField.addKeyListener(
                new KeyAdapter() {

                    public void keyReleased(
                            KeyEvent e
                    ) {

                        filterTable(
                                searchField.getText()
                        );
                    }
                }
        );

        tableHeader.add(
                heading,
                BorderLayout.WEST
        );

        tableHeader.add(
                searchField,
                BorderLayout.EAST
        );

        tableCard.add(
                tableHeader,
                BorderLayout.NORTH
        );

        createTable();

        JScrollPane scroll =
                new JScrollPane(table);

        scroll.setBorder(null);

        scroll.getViewport()
                .setBackground(
                        Color.WHITE
                );

        tableCard.add(
                scroll,
                BorderLayout.CENTER
        );

        JPanel center =
                new JPanel(
                        new BorderLayout()
                );

        center.setBackground(BG);

        center.add(
                stats,
                BorderLayout.NORTH
        );

        center.add(
                tableCard,
                BorderLayout.CENTER
        );

        page.add(
                hero,
                BorderLayout.NORTH
        );

        page.add(
                center,
                BorderLayout.CENTER
        );

        updateStats();

        return page;
    }

    // =========================================================
    // GRADIENT HERO PANEL
    // =========================================================

    class GradientPanel extends JPanel {

        protected void paintComponent(
                Graphics g
        ) {

            super.paintComponent(g);

            Graphics2D g2 =
                    (Graphics2D) g;

            GradientPaint gradient =
                    new GradientPaint(
                            0,
                            0,
                            PURPLE,
                            getWidth(),
                            getHeight(),
                            new Color(
                                    67,
                                    56,
                                    202
                            )
                    );

            g2.setPaint(gradient);

            g2.fillRoundRect(
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    25,
                    25
            );
        }
    }

    // =========================================================
    // STAT CARD
    // =========================================================

    private JPanel statCard(
            String title,
            String icon,
            JLabel value,
            Color color
    ) {

        JPanel card =
                new JPanel(
                        new BorderLayout()
                );

        card.setBackground(
                CARD
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        230,
                                        232,
                                        240
                                )
                        ),
                        new EmptyBorder(
                                18, 20, 18, 20
                        )
                )
        );

        JPanel top =
                new JPanel(
                        new BorderLayout()
                );

        top.setBackground(CARD);

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setForeground(MUTED);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        10
                )
        );

        JLabel iconLabel =
                new JLabel(icon);

        iconLabel.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        20
                )
        );

        top.add(
                titleLabel,
                BorderLayout.WEST
        );

        top.add(
                iconLabel,
                BorderLayout.EAST
        );

        value.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        value.setForeground(TEXT);

        card.add(
                top,
                BorderLayout.NORTH
        );

        card.add(
                value,
                BorderLayout.CENTER
        );

        JPanel line =
                new JPanel();

        line.setBackground(color);

        line.setPreferredSize(
                new Dimension(
                        0,
                        4
                )
        );

        card.add(
                line,
                BorderLayout.SOUTH
        );

        return card;
    }

    // =========================================================
    // TABLE
    // =========================================================

    private void createTable() {

        String[] columns = {
                "ID",
                "STUDENT",
                "MARKS",
                "GRADE",
                "PERFORMANCE"
        };

        tableModel =
                new DefaultTableModel(
                        columns,
                        0
                ) {

                    public boolean isCellEditable(
                            int row,
                            int column
                    ) {

                        return false;
                    }
                };

        table =
                new JTable(tableModel);

        table.setRowHeight(52);

        table.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        table.setForeground(TEXT);

        table.setBackground(Color.WHITE);

        table.setGridColor(
                new Color(
                        240,
                        242,
                        247
                )
        );

        table.setShowVerticalLines(false);

        table.setSelectionBackground(
                new Color(
                        239,
                        235,
                        255
                )
        );

        table.setSelectionForeground(
                TEXT
        );

        table.getTableHeader()
                .setPreferredSize(
                        new Dimension(
                                0,
                                45
                        )
                );

        table.getTableHeader()
                .setBackground(
                        new Color(
                                249,
                                250,
                                252
                        )
                );

        table.getTableHeader()
                .setForeground(MUTED);

        table.getTableHeader()
                .setFont(
                        new Font(
                                "Segoe UI",
                                Font.BOLD,
                                11
                        )
                );

        refreshTable();
    }

    // =========================================================
    // REFRESH TABLE
    // =========================================================

    private void refreshTable() {

        if (tableModel == null)
            return;

        tableModel.setRowCount(0);

        for (Student s : students) {

            String performance;

            if (s.marks >= 90)
                performance = "Excellent";
            else if (s.marks >= 75)
                performance = "Very Good";
            else if (s.marks >= 60)
                performance = "Good";
            else if (s.marks >= 50)
                performance = "Average";
            else
                performance = "Needs Improvement";

            tableModel.addRow(
                    new Object[]{
                            s.id,
                            "👤  " + s.name,
                            String.format(
                                    "%.2f",
                                    s.marks
                            ),
                            s.getGrade(),
                            performance
                    }
            );
        }
    }

    // =========================================================
    // SEARCH
    // =========================================================

    private void filterTable(
            String text
    ) {

        if (tableModel == null)
            return;

        tableModel.setRowCount(0);

        String search =
                text.toLowerCase();

        for (Student s : students) {

            if (
                    s.name
                            .toLowerCase()
                            .contains(search)
                    ||
                    String.valueOf(
                            s.id
                    ).contains(search)
            ) {

                String performance;

                if (s.marks >= 90)
                    performance = "Excellent";
                else if (s.marks >= 75)
                    performance = "Very Good";
                else if (s.marks >= 60)
                    performance = "Good";
                else if (s.marks >= 50)
                    performance = "Average";
                else
                    performance = "Needs Improvement";

                tableModel.addRow(
                        new Object[]{
                                s.id,
                                "👤  " + s.name,
                                String.format(
                                        "%.2f",
                                        s.marks
                                ),
                                s.getGrade(),
                                performance
                        }
                );
            }
        }
    }

    // =========================================================
    // ADD STUDENT
    // =========================================================

    private void showAddStudent() {

        JPanel panel =
                new JPanel(
                        new BorderLayout()
                );

        panel.setBackground(BG);

        panel.setBorder(
                new EmptyBorder(
                        30, 40, 30, 40
                )
        );

        // Header

        JPanel heading =
                new JPanel();

        heading.setBackground(BG);

        heading.setLayout(
                new BoxLayout(
                        heading,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel title =
                new JLabel(
                        "Add New Student"
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        title.setForeground(TEXT);

        JLabel subtitle =
                new JLabel(
                        "Create a new student record and assign marks."
                );

        subtitle.setForeground(MUTED);

        heading.add(title);

        heading.add(
                Box.createVerticalStrut(5)
        );

        heading.add(subtitle);

        panel.add(
                heading,
                BorderLayout.NORTH
        );

        // Form Card

        JPanel card =
                new JPanel(
                        new GridBagLayout()
                );

        card.setBackground(Color.WHITE);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        230,
                                        232,
                                        240
                                )
                        ),
                        new EmptyBorder(
                                30, 35, 30, 35
                        )
                )
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(
                        10, 10, 10, 10
                );

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        gbc.weightx = 1;

        JTextField id =
                inputField();

        JTextField name =
                inputField();

        JTextField marks =
                inputField();

        gbc.gridx = 0;
        gbc.gridy = 0;

        card.add(
                label("Student ID"),
                gbc
        );

        gbc.gridy++;

        card.add(id, gbc);

        gbc.gridy++;

        card.add(
                label("Student Name"),
                gbc
        );

        gbc.gridy++;

        card.add(name, gbc);

        gbc.gridy++;

        card.add(
                label("Marks"),
                gbc
        );

        gbc.gridy++;

        card.add(marks, gbc);

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT
                        )
                );

        buttonPanel.setBackground(
                Color.WHITE
        );

        JButton clear =
                new JButton("Clear");

        JButton save =
                new JButton(
                        "✓  Save Student"
                );

        styleButton(
                clear,
                new Color(
                        240,
                        242,
                        247
                ),
                TEXT
        );

        styleButton(
                save,
                PURPLE,
                Color.WHITE
        );

        buttonPanel.add(clear);
        buttonPanel.add(save);

        gbc.gridy++;

        card.add(
                buttonPanel,
                gbc
        );

        clear.addActionListener(
                e -> {

                    id.setText("");
                    name.setText("");
                    marks.setText("");
                }
        );

        save.addActionListener(
                e -> {

                    try {

                        if (
                                id.getText()
                                        .trim()
                                        .isEmpty()
                                ||
                                name.getText()
                                        .trim()
                                        .isEmpty()
                                ||
                                marks.getText()
                                        .trim()
                                        .isEmpty()
                        ) {

                            error(
                                    "Please fill all fields."
                            );

                            return;
                        }

                        int studentId =
                                Integer.parseInt(
                                        id.getText()
                                                .trim()
                                );

                        double studentMarks =
                                Double.parseDouble(
                                        marks.getText()
                                                .trim()
                                );

                        if (
                                studentMarks < 0
                                        ||
                                studentMarks > 100
                        ) {

                            error(
                                    "Marks must be between 0 and 100."
                            );

                            return;
                        }

                        for (Student s : students) {

                            if (
                                    s.id
                                            == studentId
                            ) {

                                error(
                                        "Student ID already exists."
                                );

                                return;
                            }
                        }

                        Student student =
                                new Student(
                                        studentId,
                                        name.getText()
                                                .trim(),
                                        studentMarks
                                );

                        students.add(student);

                        JOptionPane.showMessageDialog(
                                this,
                                "Student added successfully!",
                                "Success",
                                JOptionPane.INFORMATION_MESSAGE
                        );

                        showDashboard();

                    } catch (
                            NumberFormatException ex
                    ) {

                        error(
                                "ID and Marks must be valid numbers."
                        );
                    }
                }
        );

        panel.add(
                card,
                BorderLayout.CENTER
        );

        replaceContent(panel);
    }

    // =========================================================
    // INPUT FIELD
    // =========================================================

    private JTextField inputField() {

        JTextField field =
                new JTextField();

        field.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        field.setPreferredSize(
                new Dimension(
                        500,
                        45
                )
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        220,
                                        223,
                                        232
                                )
                        ),
                        new EmptyBorder(
                                8, 12, 8, 12
                        )
                )
        );

        return field;
    }

    // =========================================================
    // LABEL
    // =========================================================

    private JLabel label(
            String text
    ) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        label.setForeground(TEXT);

        return label;
    }

    // =========================================================
    // STUDENTS PAGE
    // =========================================================

    private void showStudents() {

        JPanel panel =
                new JPanel(
                        new BorderLayout()
                );

        panel.setBackground(BG);

        panel.setBorder(
                new EmptyBorder(
                        30, 30, 30, 30
                )
        );

        JLabel title =
                new JLabel(
                        "All Students"
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        title.setForeground(TEXT);

        JPanel top =
                new JPanel(
                        new BorderLayout()
                );

        top.setBackground(BG);

        top.add(
                title,
                BorderLayout.WEST
        );

        JButton add =
                new JButton(
                        "+ Add Student"
                );

        styleButton(
                add,
                PURPLE,
                Color.WHITE
        );

        add.addActionListener(
                e -> showAddStudent()
        );

        top.add(
                add,
                BorderLayout.EAST
        );

        panel.add(
                top,
                BorderLayout.NORTH
        );

        createTable();

        JScrollPane scroll =
                new JScrollPane(table);

        scroll.setBorder(null);

        JPanel card =
                new JPanel(
                        new BorderLayout()
                );

        card.setBackground(
                Color.WHITE
        );

        card.setBorder(
                new EmptyBorder(
                        15, 15, 15, 15
                )
        );

        card.add(
                scroll,
                BorderLayout.CENTER
        );

        panel.add(
                card,
                BorderLayout.CENTER
        );

        replaceContent(panel);
    }

    // =========================================================
    // REPORT
    // =========================================================

    private void showReports() {

        JPanel panel =
                new JPanel(
                        new BorderLayout()
                );

        panel.setBackground(BG);

        panel.setBorder(
                new EmptyBorder(
                        30, 30, 30, 30
                )
        );

        JLabel title =
                new JLabel(
                        "Performance Report"
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        title.setForeground(TEXT);

        panel.add(
                title,
                BorderLayout.NORTH
        );

        JPanel report =
                new JPanel(
                        new GridLayout(
                                2,
                                2,
                                20,
                                20
                        )
                );

        report.setBackground(BG);

        if (students.isEmpty()) {

            JLabel empty =
                    new JLabel(
                            "No student records available.",
                            SwingConstants.CENTER
                    );

            empty.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            18
                    )
            );

            empty.setForeground(MUTED);

            report.add(empty);

        } else {

            Student highest =
                    students.get(0);

            Student lowest =
                    students.get(0);

            double total = 0;

            for (Student s : students) {

                total += s.marks;

                if (
                        s.marks
                                > highest.marks
                ) {

                    highest = s;
                }

                if (
                        s.marks
                                < lowest.marks
                ) {

                    lowest = s;
                }
            }

            double average =
                    total / students.size();

            report.add(
                    reportCard(
                            "Total Students",
                            String.valueOf(
                                    students.size()
                            ),
                            "Students registered",
                            PURPLE
                    )
            );

            report.add(
                    reportCard(
                            "Average Score",
                            String.format(
                                    "%.2f",
                                    average
                            ),
                            "Overall average",
                            BLUE
                    )
            );

            report.add(
                    reportCard(
                            "Top Performer",
                            highest.name,
                            String.format(
                                    "%.2f marks • Grade %s",
                                    highest.marks,
                                    highest.getGrade()
                            ),
                            GREEN
                    )
            );

            report.add(
                    reportCard(
                            "Lowest Score",
                            lowest.name,
                            String.format(
                                    "%.2f marks • Grade %s",
                                    lowest.marks,
                                    lowest.getGrade()
                            ),
                            ORANGE
                    )
            );
        }

        panel.add(
                report,
                BorderLayout.CENTER
        );

        replaceContent(panel);
    }

    // =========================================================
    // REPORT CARD
    // =========================================================

    private JPanel reportCard(
            String title,
            String value,
            String subtitle,
            Color color
    ) {

        JPanel card =
                new JPanel(
                        new BorderLayout()
                );

        card.setBackground(Color.WHITE);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        230,
                                        232,
                                        240
                                )
                        ),
                        new EmptyBorder(
                                25, 25, 25, 25
                        )
                )
        );

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setForeground(MUTED);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setForeground(color);

        valueLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30
                )
        );

        JLabel sub =
                new JLabel(subtitle);

        sub.setForeground(MUTED);

        sub.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        JPanel content =
                new JPanel();

        content.setBackground(
                Color.WHITE
        );

        content.setLayout(
                new BoxLayout(
                        content,
                        BoxLayout.Y_AXIS
                )
        );

        content.add(titleLabel);

        content.add(
                Box.createVerticalStrut(15)
        );

        content.add(valueLabel);

        content.add(
                Box.createVerticalStrut(8)
        );

        content.add(sub);

        card.add(
                content,
                BorderLayout.CENTER
        );

        return card;
    }

    // =========================================================
    // UPDATE STATISTICS
    // =========================================================

    private void updateStats() {

        if (totalLabel == null)
            return;

        totalLabel.setText(
                String.valueOf(
                        students.size()
                )
        );

        if (students.isEmpty()) {

            averageLabel.setText("0.00");
            highestLabel.setText("0.00");
            lowestLabel.setText("0.00");

            return;
        }

        double total = 0;

        double highest =
                students.get(0).marks;

        double lowest =
                students.get(0).marks;

        for (Student s : students) {

            total += s.marks;

            if (s.marks > highest)
                highest = s.marks;

            if (s.marks < lowest)
                lowest = s.marks;
        }

        averageLabel.setText(
                String.format(
                        "%.2f",
                        total / students.size()
                )
        );

        highestLabel.setText(
                String.format(
                        "%.2f",
                        highest
                )
        );

        lowestLabel.setText(
                String.format(
                        "%.2f",
                        lowest
                )
        );
    }

    // =========================================================
    // SHOW DASHBOARD
    // =========================================================

    private void showDashboard() {

        contentPanel.remove(1);

        contentPanel.add(
                createDashboard(),
                BorderLayout.CENTER
        );

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    // =========================================================
    // REPLACE CONTENT
    // =========================================================

    private void replaceContent(
            JPanel panel
    ) {

        contentPanel.remove(1);

        contentPanel.add(
                panel,
                BorderLayout.CENTER
        );

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    // =========================================================
    // BUTTON STYLE
    // =========================================================

    private void styleButton(
            JButton button,
            Color background,
            Color foreground
    ) {

        button.setBackground(background);

        button.setForeground(foreground);

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        button.setBorder(
                new EmptyBorder(
                        12, 20, 12, 20
                )
        );

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );
    }

    // =========================================================
    // ERROR
    // =========================================================

    private void error(
            String message
    ) {

        JOptionPane.showMessageDialog(
                this,
                message,
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE
        );
    }

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(
            String[] args
    ) {

        try {

            UIManager.setLookAndFeel(
                    UIManager
                            .getSystemLookAndFeelClassName()
            );

        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(
                () -> {

                    StudentGradeTracker app =
                            new StudentGradeTracker();

                    app.setVisible(true);
                }
        );
    }
}
