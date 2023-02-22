package ManageKaraoke;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class InAppFrame extends conmysql implements ActionListener {
    String username, Email, password;
    String USN, EM;
    JFrame InAppFrame;
    JMenuBar MenubarEdit;
    JMenu Choose;
    JMenuItem Add, Update, Delete;
    JButton ListButton, EditButton, HistoryButton, SettingButton, FilterButton, SearchButton, ApplyButton, DeleteButton,
            AddInfo, UpdateInfo, DeleteInfo, changepass, changeusername, deleteacc,
            signout, HistorySignin;
    JLabel WelcomeLabel_List, FilterLabel_List;
    JRadioButton SongName, SingerName;
    ButtonGroup FilterChoose;
    JTextField Search, AddSongName, AddSinger, UpdateSongName, IDtf_Update, IDtf_Delete, UpdateSinger, DeleteSongName,
            DeleteSinger, inputCode_changeUSN, changeNewUsername, PassCodeVeri,
            InputCode_DellAccTF;
    JTable EditTable, HistoryTable, ListTable, HistorySI_setting;
    JTextArea SearchText, AddSong, ID_Update, ID_Delete, UpdateSong, DeleteSong, AddSongNameTx, AddSingerTx,
            UpdateSongNameTx, UpdateSingerTx, DeleteSingerTx, DeleteSongTx, SearchUpdate1,
            DeleteSearch1, text_setting;
    JPanel MenuPanel, SearchPanel_List, TablePanel_List, EditPanel_Edit, EditTablePanel_Edit, HistoryTabelPanel_History,
            SettingPanel_Setting, history_setting, changeusername_setting, changepass_setting, deleteacc_setting;
    JTextArea ChangeUsernameTA, changeUsernameTApass, changeUsernameCode, newUserName, ChangePASSTA, ChangePASSold,
            ChangePASS_Code, ChangePASSnew, ChangePassnew1, DelAccTA, InputCode_DelAccTA, DelAcc;
    JPasswordField changeUsernameTFpass, oldPASSTF, newPassTF, newPassTF1, InputPass_DelAcc;
    JButton NextBut_ChangeUsN, NextbutCode_changeUSN, SendCodeAgainBut, nextNewUS, SendCodeAgain_Changepass,
            NextChangepass, NextCode_changepass, NextChangePassSuc, Next_DelAcc, Next_DelAcc1, RedsendCode;
    ImageIcon icon = new ImageIcon("icon.jpg");
    ImageIcon Filter = new ImageIcon("filter.png");
    ImageIcon SearchIcon = new ImageIcon("search.png");
    ImageIcon question = new ImageIcon("question.png");
    Border BlackBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
    JPanel ListGroup, EditGroup, HistoryGroup, SettingGroup, DefaultPanel;
    JScrollPane ScrollListTable, ScrollHistoryTable, ScrollEditTable, HistoryScrollSI_setting;
    DefaultTableModel EditTableModel, HistoryTableModel, ListTableModel, Historydftb_setting;
    JCheckBox show, show1, show2, show3;
    SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    Date date = new Date();
    String SN, SGN;
    ArrayList<Integer> idDel, idUp;
    ArrayList<String> Songname, Singername, Songname1, Singername1;
    int ID = 0;
    String Song, Singer;
    int max = 0;
    int code = 0;

    public InAppFrame(String username, String Email) {
        this.USN = username;
        this.EM = Email;

        this.DeleteSongName = new JTextField();
        this.DeleteSongName.setFont(new Font("Serif", Font.BOLD, 20));
        this.DeleteSongName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.DeleteSongName.setBounds(255, 149, 350, 30);
        this.DeleteSongName.setVisible(false);

        this.DeleteSinger = new JTextField();
        this.DeleteSinger.setFont(new Font("Serif", Font.BOLD, 20));
        this.DeleteSinger.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.DeleteSinger.setBounds(770, 149, 350, 30);
        this.DeleteSinger.setVisible(false);

        this.DeleteSongTx = new JTextArea("Song Name");
        this.DeleteSongTx.setEditable(false);
        this.DeleteSongTx.setFocusable(false);
        this.DeleteSongTx.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        this.DeleteSongTx.setFont(new Font("Serif", Font.BOLD, 20));
        this.DeleteSongTx.setBounds(150, 150, 97, 30);
        this.DeleteSongTx.setBackground(Color.LIGHT_GRAY);
        this.DeleteSongTx.setVisible(false);

        this.DeleteSingerTx = new JTextArea("Singer Name");
        this.DeleteSingerTx.setEditable(false);
        this.DeleteSingerTx.setFocusable(false);
        this.DeleteSingerTx.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        this.DeleteSingerTx.setFont(new Font("Serif", Font.BOLD, 20));
        this.DeleteSingerTx.setBounds(650, 150, 120, 30);
        this.DeleteSingerTx.setBackground(Color.LIGHT_GRAY);
        this.DeleteSingerTx.setVisible(false);

        this.DeleteSearch1 = new JTextArea("Type or select on table view");
        this.DeleteSearch1.setEditable(false);
        this.DeleteSearch1.setFocusable(false);
        this.DeleteSearch1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        this.DeleteSearch1.setFont(new Font("Serif", Font.BOLD, 20));
        this.DeleteSearch1.setBounds(535, 90, 300, 30);
        this.DeleteSearch1.setBackground(Color.LIGHT_GRAY);
        this.DeleteSearch1.setVisible(false);

        this.DeleteInfo = new JButton("DELETE");
        this.DeleteInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.DeleteInfo.setOpaque(true);
        this.DeleteInfo.setFont(new Font("Serif", Font.BOLD, 20));
        this.DeleteInfo.setBounds(585, 200, 100, 30);
        this.DeleteInfo.setFocusable(false);
        this.DeleteInfo.setVisible(false);
        this.DeleteInfo.addActionListener(this);

        this.SearchUpdate1 = new JTextArea("Type or select on table view");
        this.SearchUpdate1.setEditable(false);
        this.SearchUpdate1.setFocusable(false);
        this.SearchUpdate1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        this.SearchUpdate1.setFont(new Font("Serif", Font.BOLD, 20));
        this.SearchUpdate1.setBounds(535, 90, 300, 30);
        this.SearchUpdate1.setBackground(Color.LIGHT_GRAY);
        this.SearchUpdate1.setVisible(false);

        this.UpdateInfo = new JButton("UPDATE");
        this.UpdateInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.UpdateInfo.setOpaque(true);
        this.UpdateInfo.setFont(new Font("Serif", Font.BOLD, 20));
        this.UpdateInfo.setBounds(585, 200, 100, 30);
        this.UpdateInfo.setFocusable(false);
        this.UpdateInfo.setVisible(false);
        this.UpdateInfo.addActionListener(this);

        this.UpdateSongName = new JTextField();
        this.UpdateSongName.setFont(new Font("Serif", Font.BOLD, 20));
        this.UpdateSongName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.UpdateSongName.setBounds(255, 149, 350, 30);
        this.UpdateSongName.setVisible(false);

        this.UpdateSinger = new JTextField();
        this.UpdateSinger.setFont(new Font("Serif", Font.BOLD, 20));
        this.UpdateSinger.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.UpdateSinger.setBounds(770, 149, 350, 30);
        this.UpdateSinger.setVisible(false);

        this.UpdateSongNameTx = new JTextArea("Song Name");
        this.UpdateSongNameTx.setEditable(false);
        this.UpdateSongNameTx.setFocusable(false);
        this.UpdateSongNameTx.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        this.UpdateSongNameTx.setFont(new Font("Serif", Font.BOLD, 20));
        this.UpdateSongNameTx.setBounds(150, 150, 97, 30);
        this.UpdateSongNameTx.setBackground(Color.LIGHT_GRAY);
        this.UpdateSongNameTx.setVisible(false);

        this.UpdateSingerTx = new JTextArea("Singer Name");
        this.UpdateSingerTx.setEditable(false);
        this.UpdateSingerTx.setFocusable(false);
        this.UpdateSingerTx.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        this.UpdateSingerTx.setFont(new Font("Serif", Font.BOLD, 20));
        this.UpdateSingerTx.setBounds(650, 150, 120, 30);
        this.UpdateSingerTx.setBackground(Color.LIGHT_GRAY);
        this.UpdateSingerTx.setVisible(false);

        this.AddInfo = new JButton("ADD");
        this.AddInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.AddInfo.setOpaque(true);
        this.AddInfo.setFont(new Font("Serif", Font.BOLD, 20));
        this.AddInfo.setBounds(585, 180, 100, 30);
        this.AddInfo.setFocusable(false);
        this.AddInfo.setVisible(true);
        this.AddInfo.addActionListener(this);

        this.AddSongNameTx = new JTextArea("Song Name");
        this.AddSongNameTx.setEditable(false);
        this.AddSongNameTx.setFocusable(false);
        this.AddSongNameTx.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        this.AddSongNameTx.setFont(new Font("Serif", Font.BOLD, 20));
        this.AddSongNameTx.setBounds(150, 100, 97, 30);
        this.AddSongNameTx.setBackground(Color.LIGHT_GRAY);
        this.AddSongNameTx.setVisible(true);

        this.AddSingerTx = new JTextArea("Singer Name");
        this.AddSingerTx.setEditable(false);
        this.AddSingerTx.setFocusable(false);
        this.AddSingerTx.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        this.AddSingerTx.setFont(new Font("Serif", Font.BOLD, 20));
        this.AddSingerTx.setBounds(650, 100, 120, 30);
        this.AddSingerTx.setBackground(Color.LIGHT_GRAY);
        this.AddSingerTx.setVisible(true);

        this.AddSongName = new JTextField();
        this.AddSongName.setFont(new Font("Serif", Font.BOLD, 20));
        this.AddSongName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.AddSongName.setBounds(255, 99, 350, 30);
        this.AddSongName.setVisible(true);

        this.AddSinger = new JTextField();
        this.AddSinger.setFont(new Font("Serif", Font.BOLD, 20));
        this.AddSinger.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.AddSinger.setBounds(770, 99, 350, 30);
        this.AddSinger.setVisible(true);

        this.AddSong = new JTextArea("Add Song");
        this.AddSong.setEditable(false);
        this.AddSong.setFocusable(false);
        this.AddSong.setBackground(Color.LIGHT_GRAY);
        this.AddSong.setBounds(530, 10, 215, 63);
        this.AddSong.setFont(new Font("Serif", Font.BOLD, 50));
        this.AddSong.setVisible(true);

        this.UpdateSong = new JTextArea("Update Song");
        this.UpdateSong.setEditable(false);
        this.UpdateSong.setFocusable(false);
        this.UpdateSong.setBackground(Color.LIGHT_GRAY);
        this.UpdateSong.setBounds(515, 10, 300, 63);
        this.UpdateSong.setFont(new Font("Serif", Font.BOLD, 50));
        this.UpdateSong.setVisible(false);

        this.IDtf_Update = new JTextField();
        this.IDtf_Update.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.IDtf_Update.setOpaque(true);
        this.IDtf_Update.setFont(new Font("Serif", Font.BOLD, 20));
        this.IDtf_Update.setBounds(400, 200, 150, 30);
        this.IDtf_Update.setVisible(false);

        this.ID_Update = new JTextArea("ID");
        this.ID_Update.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        this.ID_Update.setOpaque(true);
        this.ID_Update.setBackground(Color.LIGHT_GRAY);
        this.ID_Update.setFont(new Font("Serif", Font.BOLD, 20));
        this.ID_Update.setBounds(360, 200, 30, 30);
        this.ID_Update.setFocusable(false);
        this.ID_Update.setVisible(false);

        this.IDtf_Delete = new JTextField();
        this.IDtf_Delete.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.IDtf_Delete.setOpaque(true);
        this.IDtf_Delete.setFont(new Font("Serif", Font.BOLD, 20));
        this.IDtf_Delete.setBounds(400, 200, 150, 30);
        this.IDtf_Delete.setVisible(false);

        this.ID_Delete = new JTextArea("Or just ID");
        this.ID_Delete.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        this.ID_Delete.setOpaque(true);
        this.ID_Delete.setBackground(Color.LIGHT_GRAY);
        this.ID_Delete.setFont(new Font("Serif", Font.BOLD, 20));
        this.ID_Delete.setBounds(280, 200, 100, 30);
        this.ID_Delete.setFocusable(false);
        this.ID_Delete.setVisible(false);

        this.DeleteSong = new JTextArea("Delete Song");
        this.DeleteSong.setEditable(false);
        this.DeleteSong.setFocusable(false);
        this.DeleteSong.setBackground(Color.LIGHT_GRAY);
        this.DeleteSong.setBounds(530, 10, 250, 63);
        this.DeleteSong.setFont(new Font("Serif", Font.BOLD, 50));
        this.DeleteSong.setVisible(false);

        this.MenubarEdit = new JMenuBar();
        this.MenubarEdit.setBounds(0, 0, 60, 20);
        this.MenubarEdit.setFont(new Font("Serif", Font.BOLD, 12));
        this.MenubarEdit.setBackground(Color.lightGray);
        this.MenubarEdit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.Choose = new JMenu("Choose");
        this.Add = new JMenuItem("Add");
        this.Update = new JMenuItem("Update");
        this.Delete = new JMenuItem("Delete");
        this.Choose.add(this.Add);
        this.Choose.add(this.Update);
        this.Choose.add(this.Delete);
        this.MenubarEdit.add(this.Choose);
        this.Add.addActionListener(this);
        this.Update.addActionListener(this);
        this.Delete.addActionListener(this);

        this.ListTable = new JTable();
        this.ScrollListTable = new JScrollPane(this.ListTable);
        this.ScrollListTable.setBorder(BorderFactory.createLineBorder(Color.white));
        this.ListTable.getTableHeader().setBackground(Color.PINK);
        this.ListTable.setFont(new Font("Serif", Font.BOLD, 16));
        this.ListTable.setShowHorizontalLines(true);
        this.ListTable.setGridColor(Color.orange);
        this.ListTable.setFocusable(false);
        this.ListTable.setDefaultEditor(Object.class, null);
        this.ScrollListTable.setBounds(0, 0, 780, 635);
        this.ListTableModel = (DefaultTableModel) this.ListTable.getModel();

        this.HistoryTable = new JTable();
        this.ScrollHistoryTable = new JScrollPane(this.HistoryTable);
        this.HistoryTable.getTableHeader().setBackground(Color.red);
        this.HistoryTable.getTableHeader().setForeground(Color.WHITE);
        this.HistoryTable.setFont(new Font("Serif", Font.BOLD, 16));
        this.HistoryTable.setShowHorizontalLines(true);
        this.HistoryTable.setGridColor(Color.ORANGE);
        this.HistoryTable.setFocusable(false);
        this.HistoryTable.setDefaultEditor(Object.class, null);
        this.ScrollHistoryTable.setBounds(0, 0, 755, 700);
        this.HistoryTableModel = (DefaultTableModel) this.HistoryTable.getModel();

        this.EditTable = new JTable();
        this.ScrollEditTable = new JScrollPane(this.EditTable);
        this.EditTable.getTableHeader().setBackground(Color.YELLOW);
        this.EditTable.setFont(new Font("Serif", Font.BOLD, 16));
        this.EditTable.setShowHorizontalLines(true);
        this.EditTable.setGridColor(Color.YELLOW);
        this.EditTable.setFocusable(false);
        this.EditTable.setDefaultEditor(Object.class, null);
        this.ScrollEditTable.setBounds(0, 0, 770, 600);
        this.EditTableModel = (DefaultTableModel) this.EditTable.getModel();

        this.ListButton = new JButton("SONG LIST");
        this.ListButton.setSize(500, 100);
        this.ListButton.setFont(new Font("Serif", Font.BOLD, 25));
        this.ListButton.setBackground(Color.LIGHT_GRAY);
        this.ListButton.setOpaque(true);
        this.ListButton.setFocusable(false);
        this.ListButton.addActionListener(this);
        this.ListButton.setIcon(new ImageIcon("List.png"));
        this.ListButton.setBorder(this.BlackBorder);

        this.EditButton = new JButton("EDIT");
        this.EditButton.setSize(500, 100);
        this.EditButton.setFont(new Font("Serif", Font.BOLD, 25));
        this.EditButton.setBackground(Color.LIGHT_GRAY);
        this.EditButton.setOpaque(true);
        this.EditButton.setFocusable(false);
        this.EditButton.setIcon(new ImageIcon("Edit.png"));
        this.EditButton.setBorder(this.BlackBorder);
        this.EditButton.addActionListener(this);

        this.HistoryButton = new JButton("HISTORY");
        this.HistoryButton.setSize(500, 100);
        this.HistoryButton.setFont(new Font("Serif", Font.BOLD, 25));
        this.HistoryButton.setBackground(Color.LIGHT_GRAY);
        this.HistoryButton.setOpaque(true);
        this.HistoryButton.setFocusable(false);
        this.HistoryButton.setIcon(new ImageIcon("History.png"));
        this.HistoryButton.setBorder(this.BlackBorder);
        this.HistoryButton.addActionListener(this);

        this.SettingButton = new JButton("SETTING");
        this.SettingButton.setSize(500, 100);
        this.SettingButton.setFont(new Font("Serif", Font.BOLD, 25));
        this.SettingButton.setBackground(Color.LIGHT_GRAY);
        this.SettingButton.setOpaque(true);
        this.SettingButton.setFocusable(false);
        this.SettingButton.setIcon(new ImageIcon("Setting.png"));
        this.SettingButton.setBorder(this.BlackBorder);
        this.SettingButton.addActionListener(this);

        this.MenuPanel = new JPanel();
        this.MenuPanel.setPreferredSize(new Dimension(100, 60));
        this.MenuPanel.add(this.ListButton);
        this.MenuPanel.add(this.EditButton);
        this.MenuPanel.add(this.HistoryButton);
        this.MenuPanel.add(this.SettingButton);
        this.MenuPanel.setLayout(new GridLayout());

        this.SearchText = new JTextArea("Search, find song");
        this.SearchText.setBackground(Color.LIGHT_GRAY);
        this.SearchText.setFont(new Font("Serif", Font.BOLD, 40));
        this.SearchText.setOpaque(true);
        this.SearchText.setBounds(110, 100, 300, 55);
        this.SearchText.setEditable(false);
        this.SearchText.setFocusable(false);

        this.SongName = new JRadioButton("Song name");
        this.SongName.setBounds(30, 30, 150, 30);
        this.SongName.setFont(new Font("Serif", Font.BOLD, 20));
        this.SongName.setBackground(Color.WHITE);
        this.SongName.setOpaque(true);
        this.SongName.setFocusable(false);
        this.SongName.addActionListener(this);

        this.SingerName = new JRadioButton("Singer name");
        this.SingerName.setBounds(30, 60, 150, 30);
        this.SingerName.setFont(new Font("Serif", Font.BOLD, 20));
        this.SingerName.setBackground(Color.WHITE);
        this.SingerName.setOpaque(true);
        this.SingerName.setFocusable(false);
        this.SingerName.addActionListener(this);

        this.FilterChoose = new ButtonGroup();
        this.FilterChoose.add(this.SingerName);
        this.FilterChoose.add(this.SongName);

        this.FilterButton = new JButton();
        this.FilterButton.setIcon(this.Filter);
        this.FilterButton.setBounds(70, 160, 30, 30);
        this.FilterButton.setFocusable(false);
        this.FilterButton.setBackground(Color.WHITE);
        this.FilterButton.setOpaque(true);
        this.FilterButton.addActionListener(this);

        this.ApplyButton = new JButton("Apply");
        this.ApplyButton.setBounds(250, 270, 75, 25);
        this.ApplyButton.setFocusable(false);
        this.ApplyButton.setFont(new Font("Serif", Font.BOLD, 16));
        this.ApplyButton.addActionListener(this);
        this.ApplyButton.setVisible(false);

        this.DeleteButton = new JButton("Delete");
        this.DeleteButton.setBounds(133, 270, 80, 25);
        this.DeleteButton.setFocusable(false);
        this.DeleteButton.setFont(new Font("Serif", Font.BOLD, 16));
        this.DeleteButton.addActionListener(this);
        this.DeleteButton.setVisible(false);
        this.DeleteButton.setEnabled(false);

        this.Search = new JTextField();
        this.Search.setBounds(100, 160, 300, 30);
        this.Search.setBorder(this.BlackBorder);
        this.Search.setFont(new Font("Serif", Font.BOLD, 20));

        this.SearchButton = new JButton();
        this.SearchButton.setIcon(this.SearchIcon);
        this.SearchButton.setBackground(Color.WHITE);
        this.SearchButton.setOpaque(true);
        this.SearchButton.setFocusable(false);
        this.SearchButton.setBounds(400, 160, 30, 30);
        this.SearchButton.addActionListener(this);

        this.FilterLabel_List = new JLabel("FILTER");
        this.FilterLabel_List.setFont(new Font("Serif", Font.BOLD, 25));
        this.FilterLabel_List.setHorizontalAlignment(JLabel.CENTER);
        this.FilterLabel_List.setVerticalAlignment(JLabel.TOP);
        this.FilterLabel_List.setBounds(130, 160, 200, 100);
        this.FilterLabel_List.setBackground(Color.WHITE);
        this.FilterLabel_List.setOpaque(true);
        this.FilterLabel_List.setBorder(this.BlackBorder);
        this.FilterLabel_List.add(this.SongName);
        this.FilterLabel_List.add(this.SingerName);
        this.FilterLabel_List.setVisible(false);

        this.SearchPanel_List = new JPanel();
        this.SearchPanel_List.setPreferredSize(new Dimension(500, 100));
        this.SearchPanel_List.setBackground(Color.lightGray);
        this.SearchPanel_List.setOpaque(true);
        this.SearchPanel_List.setLayout(null);
        this.SearchPanel_List.add(this.SearchText);
        this.SearchPanel_List.add(this.FilterLabel_List);
        this.SearchPanel_List.add(this.FilterButton);
        this.SearchPanel_List.add(this.ApplyButton);
        this.SearchPanel_List.add(this.DeleteButton);
        this.SearchPanel_List.add(this.Search);
        this.SearchPanel_List.add(this.SearchButton);

        this.TablePanel_List = new JPanel();
        this.TablePanel_List.setLayout(null);
        this.TablePanel_List.setPreferredSize(new Dimension(780, 100));
        this.TablePanel_List.setOpaque(true);
        this.TablePanel_List.add(this.ScrollListTable);

        this.WelcomeLabel_List = new JLabel();
        this.WelcomeLabel_List.setText("Welcome " + username);
        this.WelcomeLabel_List.setFont(new Font("Serif", Font.BOLD, 40));
        this.WelcomeLabel_List.setHorizontalAlignment(JLabel.CENTER);
        this.WelcomeLabel_List.setIcon(new ImageIcon("notemusic.gif"));
        this.WelcomeLabel_List.setBackground(Color.WHITE);
        this.WelcomeLabel_List.setOpaque(true);

        this.ListGroup = new JPanel();
        this.ListGroup.setLayout(new BorderLayout());
        this.ListGroup.add(this.SearchPanel_List, BorderLayout.WEST);
        this.ListGroup.add(this.TablePanel_List, BorderLayout.EAST);
        this.ListGroup.setVisible(false);

        this.EditPanel_Edit = new JPanel();
        this.EditPanel_Edit.setLayout(null);
        this.EditPanel_Edit.setPreferredSize(new Dimension(350, 250));
        this.EditPanel_Edit.setBackground(Color.LIGHT_GRAY);
        this.EditPanel_Edit.setOpaque(true);
        this.EditPanel_Edit.add(this.AddInfo);
        this.EditPanel_Edit.add(this.UpdateInfo);
        this.EditPanel_Edit.add(this.MenubarEdit);
        this.EditPanel_Edit.add(this.AddSong);
        this.EditPanel_Edit.add(this.UpdateSong);
        this.EditPanel_Edit.add(this.DeleteSong);
        this.EditPanel_Edit.add(this.AddSongNameTx);
        this.EditPanel_Edit.add(this.AddSongName);
        this.EditPanel_Edit.add(this.AddSingerTx);
        this.EditPanel_Edit.add(this.AddSinger);
        this.EditPanel_Edit.add(this.UpdateInfo);
        this.EditPanel_Edit.add(this.UpdateSinger);
        this.EditPanel_Edit.add(this.UpdateSongName);
        this.EditPanel_Edit.add(this.UpdateSongNameTx);
        this.EditPanel_Edit.add(this.UpdateSingerTx);
        this.EditPanel_Edit.add(this.SearchUpdate1);
        this.EditPanel_Edit.add(this.DeleteSongName);
        this.EditPanel_Edit.add(this.DeleteSinger);
        this.EditPanel_Edit.add(this.DeleteSongTx);
        this.EditPanel_Edit.add(this.DeleteSingerTx);
        this.EditPanel_Edit.add(this.DeleteSinger);
        this.EditPanel_Edit.add(this.DeleteSongName);
        this.EditPanel_Edit.add(this.DeleteSearch1);
        this.EditPanel_Edit.add(this.DeleteInfo);
        this.EditPanel_Edit.add(this.IDtf_Update);
        this.EditPanel_Edit.add(this.ID_Update);
        this.EditPanel_Edit.add(this.ID_Delete);
        this.EditPanel_Edit.add(this.IDtf_Delete);

        this.EditTablePanel_Edit = new JPanel();
        this.EditTablePanel_Edit.setLayout(new BorderLayout());
        this.EditTablePanel_Edit.setPreferredSize(new Dimension(200, 100));
        this.EditTablePanel_Edit.setBackground(Color.RED);
        this.EditTablePanel_Edit.setOpaque(true);
        this.EditTablePanel_Edit.add(this.ScrollEditTable, BorderLayout.CENTER);

        this.EditGroup = new JPanel();
        this.EditGroup.setLayout(new BorderLayout());
        this.EditGroup.add(this.EditPanel_Edit, BorderLayout.NORTH);
        this.EditGroup.add(this.EditTablePanel_Edit, BorderLayout.CENTER);
        this.EditGroup.setVisible(false);

        this.HistoryTabelPanel_History = new JPanel();
        this.HistoryTabelPanel_History.setLayout(new BorderLayout());
        this.HistoryTabelPanel_History.setBackground(Color.LIGHT_GRAY);
        this.HistoryTabelPanel_History.add(this.ScrollHistoryTable);

        this.HistoryGroup = new JPanel();
        this.HistoryGroup.setLayout(new BorderLayout());
        this.HistoryGroup.add(this.HistoryTabelPanel_History);
        this.HistoryGroup.setVisible(false);

        this.HistorySI_setting = new JTable();
        this.HistoryScrollSI_setting = new JScrollPane(this.HistorySI_setting);
        this.HistorySI_setting.getTableHeader().setBackground(Color.red);
        this.HistorySI_setting.getTableHeader().setForeground(Color.WHITE);
        this.HistorySI_setting.setFont(new Font("Serif", Font.BOLD, 16));
        this.HistorySI_setting.setShowHorizontalLines(true);
        this.HistorySI_setting.setGridColor(Color.ORANGE);
        this.HistorySI_setting.setFocusable(false);
        this.HistorySI_setting.setDefaultEditor(Object.class, null);
        this.HistorySI_setting.setBounds(0, 0, 755, 700);
        this.Historydftb_setting = (DefaultTableModel) this.HistorySI_setting.getModel();

        this.HistorySignin = new JButton("Sign in history");
        this.HistorySignin.setBounds(0, 190, 500, 40);
        this.HistorySignin.setBackground(Color.LIGHT_GRAY);
        this.HistorySignin.setFocusable(false);
        this.HistorySignin.setFont(new Font("Serif", Font.BOLD, 25));
        this.HistorySignin.addActionListener(this);

        this.history_setting = new JPanel();
        this.history_setting.setLayout(new BorderLayout());
        this.history_setting.setPreferredSize(new Dimension(780, 100));
        this.history_setting.setBackground(Color.BLUE);
        this.history_setting.add(this.HistoryScrollSI_setting, BorderLayout.CENTER);
        this.history_setting.setVisible(false);

        this.changeusername = new JButton("Change username");
        this.changeusername.setBounds(0, 230, 500, 40);
        this.changeusername.setBackground(Color.LIGHT_GRAY);
        this.changeusername.setFocusable(false);
        this.changeusername.setFont(new Font("Serif", Font.BOLD, 25));
        this.changeusername.addActionListener(this);

        this.ChangeUsernameTA = new JTextArea("Change user name");
        this.ChangeUsernameTA.setEditable(false);
        this.ChangeUsernameTA.setFocusable(false);
        this.ChangeUsernameTA.setBounds(220, 150, 365, 55);
        this.ChangeUsernameTA.setFont(new Font("Serif", Font.BOLD, 45));

        this.show = new JCheckBox("Show Password");
        this.show.setBounds(280, 290, 200, 25);
        this.show.setBackground(Color.white);
        this.show.addActionListener(this);
        this.show.setFocusable(false);

        this.changeUsernameTApass = new JTextArea("Password");
        this.changeUsernameTApass.setFont(new Font("Serif", Font.BOLD, 25));
        this.changeUsernameTApass.setEditable(false);
        this.changeUsernameTApass.setFocusable(false);
        this.changeUsernameTApass.setBounds(145, 250, 110, 30);

        this.changeUsernameTFpass = new JPasswordField();
        this.changeUsernameTFpass.setBounds(265, 251, 400, 30);
        this.changeUsernameTFpass.setFont(new Font("Serif", Font.BOLD, 18));
        this.changeUsernameTFpass.setBorder(this.BlackBorder);

        this.NextBut_ChangeUsN = new JButton("Next");
        this.NextBut_ChangeUsN.setFocusable(false);
        this.NextBut_ChangeUsN.setFont(new Font("Serif", Font.BOLD, 25));
        this.NextBut_ChangeUsN.setBounds(325, 330, 90, 30);
        this.NextBut_ChangeUsN.addActionListener(this);

        this.NextbutCode_changeUSN = new JButton("Next");
        this.NextbutCode_changeUSN.setFocusable(false);
        this.NextbutCode_changeUSN.setFont(new Font("Serif", Font.BOLD, 25));
        this.NextbutCode_changeUSN.setBounds(430, 330, 90, 30);
        this.NextbutCode_changeUSN.setVisible(false);
        this.NextbutCode_changeUSN.addActionListener(this);

        this.SendCodeAgainBut = new JButton("Resend code");
        this.SendCodeAgainBut.setFocusable(false);
        this.SendCodeAgainBut.setFont(new Font("Serif", Font.BOLD, 25));
        this.SendCodeAgainBut.setBounds(235, 330, 175, 30);
        this.SendCodeAgainBut.setVisible(false);
        this.SendCodeAgainBut.addActionListener(this);

        this.inputCode_changeUSN = new JTextField();
        this.inputCode_changeUSN.setBounds(360, 251, 350, 30);
        this.inputCode_changeUSN.setFont(new Font("Serif", Font.BOLD, 25));
        this.inputCode_changeUSN.setBorder(this.BlackBorder);
        this.inputCode_changeUSN.setVisible(false);

        this.changeUsernameCode = new JTextArea("Verificate code in your Email");
        this.changeUsernameCode.setFont(new Font("Serif", Font.BOLD, 25));
        this.changeUsernameCode.setEditable(false);
        this.changeUsernameCode.setFocusable(false);
        this.changeUsernameCode.setBounds(30, 250, 330, 30);
        this.changeUsernameCode.setVisible(false);

        this.newUserName = new JTextArea("New User name");
        this.newUserName.setFont(new Font("Serif", Font.BOLD, 25));
        this.newUserName.setEditable(false);
        this.newUserName.setFocusable(false);
        this.newUserName.setBounds(85, 250, 170, 30);
        this.newUserName.setVisible(false);

        this.changeNewUsername = new JTextField();
        this.changeNewUsername.setBounds(265, 251, 400, 30);
        this.changeNewUsername.setFont(new Font("Serif", Font.BOLD, 18));
        this.changeNewUsername.setBorder(this.BlackBorder);
        this.changeNewUsername.setVisible(false);

        this.nextNewUS = new JButton("Next");
        this.nextNewUS.setFocusable(false);
        this.nextNewUS.setFont(new Font("Serif", Font.BOLD, 25));
        this.nextNewUS.setBounds(325, 330, 90, 30);
        this.nextNewUS.setVisible(false);
        this.nextNewUS.addActionListener(this);

        this.changeusername_setting = new JPanel();
        this.changeusername_setting.setLayout(null);
        this.changeusername_setting.setPreferredSize(new Dimension(780, 100));
        this.changeusername_setting.setBackground(Color.WHITE);
        this.changeusername_setting.add(this.changeUsernameTApass);
        this.changeusername_setting.add(this.ChangeUsernameTA);
        this.changeusername_setting.add(this.changeUsernameTFpass);
        this.changeusername_setting.add(this.NextBut_ChangeUsN);
        this.changeusername_setting.add(this.changeUsernameCode);
        this.changeusername_setting.add(this.inputCode_changeUSN);
        this.changeusername_setting.add(this.show);
        this.changeusername_setting.add(this.NextbutCode_changeUSN);
        this.changeusername_setting.add(this.SendCodeAgainBut);
        this.changeusername_setting.add(this.newUserName);
        this.changeusername_setting.add(this.nextNewUS);
        this.changeusername_setting.add(this.changeNewUsername);
        this.changeusername_setting.setVisible(false);

        this.changepass = new JButton("Change password");
        this.changepass.setBounds(0, 270, 500, 40);
        this.changepass.setBackground(Color.LIGHT_GRAY);
        this.changepass.setFocusable(false);
        this.changepass.setFont(new Font("Serif", Font.BOLD, 25));
        this.changepass.addActionListener(this);

        this.ChangePASSTA = new JTextArea("Change Password");
        this.ChangePASSTA.setEditable(false);
        this.ChangePASSTA.setFocusable(false);
        this.ChangePASSTA.setBounds(220, 150, 360, 55);
        this.ChangePASSTA.setFont(new Font("Serif", Font.BOLD, 45));

        this.ChangePASSold = new JTextArea("Password");
        this.ChangePASSold.setFont(new Font("Serif", Font.BOLD, 25));
        this.ChangePASSold.setEditable(false);
        this.ChangePASSold.setFocusable(false);
        this.ChangePASSold.setBounds(145, 250, 110, 30);

        this.oldPASSTF = new JPasswordField();
        this.oldPASSTF.setBounds(265, 251, 400, 30);
        this.oldPASSTF.setFont(new Font("Serif", Font.BOLD, 18));
        this.oldPASSTF.setBorder(this.BlackBorder);

        this.NextChangepass = new JButton("Next");
        this.NextChangepass.setFocusable(false);
        this.NextChangepass.setFont(new Font("Serif", Font.BOLD, 25));
        this.NextChangepass.setBounds(325, 330, 90, 30);
        this.NextChangepass.addActionListener(this);

        this.show1 = new JCheckBox("Show password");
        this.show1.setBounds(280, 290, 200, 25);
        this.show1.setBackground(Color.white);
        this.show1.addActionListener(this);
        this.show1.setFocusable(false);

        this.SendCodeAgain_Changepass = new JButton("Resend code");
        this.SendCodeAgain_Changepass.setFocusable(false);
        this.SendCodeAgain_Changepass.setFont(new Font("Serif", Font.BOLD, 25));
        this.SendCodeAgain_Changepass.setBounds(235, 330, 175, 30);
        this.SendCodeAgain_Changepass.setVisible(false);
        this.SendCodeAgain_Changepass.addActionListener(this);

        this.PassCodeVeri = new JTextField();
        this.PassCodeVeri.setBounds(360, 251, 350, 30);
        this.PassCodeVeri.setFont(new Font("Serif", Font.BOLD, 25));
        this.PassCodeVeri.setBorder(this.BlackBorder);
        this.PassCodeVeri.setVisible(false);

        this.ChangePASS_Code = new JTextArea("Verificate code in your Email");
        this.ChangePASS_Code.setFont(new Font("Serif", Font.BOLD, 25));
        this.ChangePASS_Code.setEditable(false);
        this.ChangePASS_Code.setFocusable(false);
        this.ChangePASS_Code.setBounds(30, 250, 330, 30);
        this.ChangePASS_Code.setVisible(false);

        this.NextCode_changepass = new JButton("Next");
        this.NextCode_changepass.setFocusable(false);
        this.NextCode_changepass.setFont(new Font("Serif", Font.BOLD, 25));
        this.NextCode_changepass.setBounds(430, 330, 90, 30);
        this.NextCode_changepass.setVisible(false);
        this.NextCode_changepass.addActionListener(this);

        this.ChangePASSnew = new JTextArea("New Password");
        this.ChangePASSnew.setFont(new Font("Serif", Font.BOLD, 25));
        this.ChangePASSnew.setEditable(false);
        this.ChangePASSnew.setFocusable(false);
        this.ChangePASSnew.setBounds(85, 250, 170, 30);
        this.ChangePASSnew.setVisible(false);

        this.ChangePassnew1 = new JTextArea("Confirm again");
        this.ChangePassnew1.setFont(new Font("Serif", Font.BOLD, 25));
        this.ChangePassnew1.setEditable(false);
        this.ChangePassnew1.setFocusable(false);
        this.ChangePassnew1.setBounds(85, 325, 170, 35);
        this.ChangePassnew1.setVisible(false);

        this.show2 = new JCheckBox("Show password");
        this.show2.setBounds(280, 385, 200, 25);
        this.show2.setBackground(Color.white);
        this.show2.addActionListener(this);
        this.show2.setFocusable(false);
        this.show2.setVisible(false);

        this.newPassTF = new JPasswordField();
        this.newPassTF.setBounds(265, 251, 400, 30);
        this.newPassTF.setFont(new Font("Serif", Font.BOLD, 18));
        this.newPassTF.setBorder(this.BlackBorder);
        this.newPassTF.setVisible(false);

        this.newPassTF1 = new JPasswordField();
        this.newPassTF1.setBounds(265, 326, 400, 30);
        this.newPassTF1.setFont(new Font("Serif", Font.BOLD, 18));
        this.newPassTF1.setBorder(this.BlackBorder);
        this.newPassTF1.setVisible(false);

        this.NextChangePassSuc = new JButton("Next");
        this.NextChangePassSuc.setFocusable(false);
        this.NextChangePassSuc.setFont(new Font("Serif", Font.BOLD, 25));
        this.NextChangePassSuc.setBounds(325, 450, 90, 30);
        this.NextChangePassSuc.setVisible(false);
        this.NextChangePassSuc.addActionListener(this);

        this.changepass_setting = new JPanel();
        this.changepass_setting.setLayout(null);
        this.changepass_setting.setPreferredSize(new Dimension(780, 100));
        this.changepass_setting.setBackground(Color.WHITE);
        this.changepass_setting.add(this.ChangePASSTA);
        this.changepass_setting.add(this.ChangePASSold);
        this.changepass_setting.add(this.oldPASSTF);
        this.changepass_setting.add(this.NextChangepass);
        this.changepass_setting.add(this.SendCodeAgain_Changepass);
        this.changepass_setting.add(this.PassCodeVeri);
        this.changepass_setting.add(this.ChangePASS_Code);
        this.changepass_setting.add(this.NextCode_changepass);
        this.changepass_setting.add(this.show1);
        this.changepass_setting.add(this.ChangePASSnew);
        this.changepass_setting.add(this.ChangePassnew1);
        this.changepass_setting.add(this.show2);
        this.changepass_setting.add(this.newPassTF);
        this.changepass_setting.add(this.newPassTF1);
        this.changepass_setting.add(this.NextChangePassSuc);
        this.changepass_setting.setVisible(false);

        this.deleteacc = new JButton("Delete account ?");
        this.deleteacc.setBounds(0, 310, 500, 40);
        this.deleteacc.setBackground(Color.LIGHT_GRAY);
        this.deleteacc.setFocusable(false);
        this.deleteacc.setFont(new Font("Serif", Font.BOLD, 25));
        this.deleteacc.addActionListener(this);

        this.DelAcc = new JTextArea("Delete account");
        this.DelAcc.setEditable(false);
        this.DelAcc.setFocusable(false);
        this.DelAcc.setBounds(220, 150, 360, 55);
        this.DelAcc.setFont(new Font("Serif", Font.BOLD, 45));

        this.DelAccTA = new JTextArea("Password");
        this.DelAccTA.setFont(new Font("Serif", Font.BOLD, 25));
        this.DelAccTA.setEditable(false);
        this.DelAccTA.setFocusable(false);
        this.DelAccTA.setBounds(145, 250, 110, 30);

        this.InputPass_DelAcc = new JPasswordField();
        this.InputPass_DelAcc.setBounds(265, 251, 400, 30);
        this.InputPass_DelAcc.setFont(new Font("Serif", Font.BOLD, 18));
        this.InputPass_DelAcc.setBorder(this.BlackBorder);

        this.show3 = new JCheckBox("Show password");
        this.show3.setBounds(280, 290, 200, 25);
        this.show3.setBackground(Color.white);
        this.show3.addActionListener(this);
        this.show3.setFocusable(false);

        this.Next_DelAcc = new JButton("Next");
        this.Next_DelAcc.setFocusable(false);
        this.Next_DelAcc.setFont(new Font("Serif", Font.BOLD, 25));
        this.Next_DelAcc.setBounds(325, 330, 90, 30);
        this.Next_DelAcc.addActionListener(this);

        this.InputCode_DelAccTA = new JTextArea("Verificate code in your Email");
        this.InputCode_DelAccTA.setFont(new Font("Serif", Font.BOLD, 25));
        this.InputCode_DelAccTA.setEditable(false);
        this.InputCode_DelAccTA.setFocusable(false);
        this.InputCode_DelAccTA.setBounds(30, 250, 330, 30);
        this.InputCode_DelAccTA.setVisible(false);

        this.InputCode_DellAccTF = new JTextField();
        this.InputCode_DellAccTF.setBounds(360, 251, 350, 30);
        this.InputCode_DellAccTF.setFont(new Font("Serif", Font.BOLD, 25));
        this.InputCode_DellAccTF.setBorder(this.BlackBorder);
        this.InputCode_DellAccTF.setVisible(false);

        this.Next_DelAcc1 = new JButton("Next");
        this.Next_DelAcc1.setFocusable(false);
        this.Next_DelAcc1.setFont(new Font("Serif", Font.BOLD, 25));
        this.Next_DelAcc1.setBounds(430, 330, 90, 30);
        this.Next_DelAcc1.setVisible(false);
        this.Next_DelAcc1.addActionListener(this);

        this.RedsendCode = new JButton("Resend code");
        this.RedsendCode.setFocusable(false);
        this.RedsendCode.setFont(new Font("Serif", Font.BOLD, 25));
        this.RedsendCode.setBounds(235, 330, 175, 30);
        this.RedsendCode.setVisible(false);
        this.RedsendCode.addActionListener(this);

        this.deleteacc_setting = new JPanel();
        this.deleteacc_setting.setLayout(null);
        this.deleteacc_setting.setPreferredSize(new Dimension(780, 100));
        this.deleteacc_setting.setBackground(Color.WHITE);
        this.deleteacc_setting.add(this.DelAcc);
        this.deleteacc_setting.add(this.DelAccTA);
        this.deleteacc_setting.add(this.InputCode_DelAccTA);
        this.deleteacc_setting.add(this.InputPass_DelAcc);
        this.deleteacc_setting.add(this.InputCode_DellAccTF);
        this.deleteacc_setting.add(this.Next_DelAcc);
        this.deleteacc_setting.add(this.Next_DelAcc1);
        this.deleteacc_setting.add(this.RedsendCode);
        this.deleteacc_setting.add(this.show3);
        this.deleteacc_setting.setVisible(false);

        this.signout = new JButton("Sign out");
        this.signout.setBounds(0, 500, 500, 40);
        this.signout.setBackground(Color.LIGHT_GRAY);
        this.signout.setFocusable(false);
        this.signout.setForeground(Color.RED);
        this.signout.setFont(new Font("Serif", Font.BOLD, 25));
        this.signout.addActionListener(this);

        this.text_setting = new JTextArea("Setting");
        this.text_setting.setBounds(180, 50, 200, 65);
        this.text_setting.setFocusable(false);
        this.text_setting.setEditable(false);
        this.text_setting.setFont(new Font("Serif", Font.BOLD, 50));
        this.text_setting.setBackground(Color.LIGHT_GRAY);

        this.SettingPanel_Setting = new JPanel();
        this.SettingPanel_Setting.setLayout(null);
        this.SettingPanel_Setting.setPreferredSize(new Dimension(500, 500));
        this.SettingPanel_Setting.setBackground(Color.LIGHT_GRAY);
        this.SettingPanel_Setting.add(this.HistorySignin);
        this.SettingPanel_Setting.add(this.changeusername);
        this.SettingPanel_Setting.add(this.changepass);
        this.SettingPanel_Setting.add(this.deleteacc);
        this.SettingPanel_Setting.add(this.signout);
        this.SettingPanel_Setting.add(this.text_setting);

        this.SettingGroup = new JPanel();
        this.SettingGroup.setLayout(new BorderLayout());
        this.SettingGroup.setVisible(false);
        this.SettingGroup.add(this.SettingPanel_Setting, BorderLayout.WEST);
        this.SettingGroup.setBackground(Color.WHITE);

        this.DefaultPanel = new JPanel();
        this.DefaultPanel.setLayout(new BorderLayout());
        this.DefaultPanel.add(this.MenuPanel, BorderLayout.SOUTH);
        this.DefaultPanel.add(this.WelcomeLabel_List, BorderLayout.CENTER);

        this.InAppFrame = new JFrame("Karaoke");
        this.InAppFrame.setSize(900, 750);
        this.InAppFrame.setLocationRelativeTo(null);
        this.InAppFrame.setVisible(true);
        this.InAppFrame.setIconImage(this.icon.getImage());
        this.InAppFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.InAppFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.InAppFrame.setContentPane(this.DefaultPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.show.isSelected()) {
            this.changeUsernameTFpass.setEchoChar((char) 0);
        } else {
            this.changeUsernameTFpass.setEchoChar('*');
        }

        if (e.getSource() == this.ListButton) {
            this.WelcomeLabel_List.setVisible(false);
            this.DefaultPanel.remove(this.WelcomeLabel_List);

            this.EditGroup.setVisible(false);
            this.DefaultPanel.remove(this.EditGroup);

            this.DefaultPanel.add(this.ListGroup, BorderLayout.CENTER);
            this.ListGroup.setVisible(true);

            this.HistoryGroup.setVisible(false);
            this.DefaultPanel.remove(this.HistoryGroup);

            this.SettingGroup.setVisible(false);
            this.DefaultPanel.remove(this.SettingGroup);
            try {
                Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                Statement stmt = connection.createStatement();
                ResultSet rs1 = stmt
                        .executeQuery("Select SongId, SongName, SingerName from Karaoke.Songlist Order by SongName");
                ResultSetMetaData rsmd = rs1.getMetaData();
                this.ListTableModel.getDataVector().removeAllElements();
                int cols = rsmd.getColumnCount();
                String[] colName = new String[cols];
                for (int i = 0; i < cols; i++)
                    colName[i] = rsmd.getColumnName(i + 1);
                this.ListTableModel.setColumnIdentifiers(colName);
                String id, name, singer;
                while (rs1.next()) {
                    id = rs1.getString(1);
                    name = rs1.getString(2);
                    singer = rs1.getString(3);
                    String[] row = { id, name, singer };
                    this.ListTableModel.addRow(row);
                }
                stmt.close();
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            this.ListButton.setBackground(Color.PINK);
            this.EditButton.setBackground(Color.lightGray);
            this.HistoryButton.setBackground(Color.lightGray);
            this.SettingButton.setBackground(Color.lightGray);
        } else {

        }

        if (e.getSource() == this.EditButton) {
            this.WelcomeLabel_List.setVisible(false);
            this.DefaultPanel.remove(this.WelcomeLabel_List);

            this.ListGroup.setVisible(false);
            this.DefaultPanel.remove(this.ListGroup);

            this.HistoryGroup.setVisible(false);
            this.DefaultPanel.remove(this.HistoryGroup);

            this.SettingGroup.setVisible(false);
            this.DefaultPanel.remove(this.SettingGroup);

            this.DefaultPanel.add(this.EditGroup, BorderLayout.CENTER);
            this.EditGroup.setVisible(true);
            try {
                Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                Statement stmt = connection.createStatement();
                ResultSet rs1 = stmt.executeQuery("Select * from Karaoke.SongList Order by SongName");
                ResultSetMetaData rsmd = rs1.getMetaData();
                this.EditTableModel.getDataVector().removeAllElements();
                int cols = rsmd.getColumnCount();
                String[] colName = new String[cols];
                for (int i = 0; i < cols; i++)
                    colName[i] = rsmd.getColumnName(i + 1);
                this.EditTableModel.setColumnIdentifiers(colName);
                String id, name, singer;
                while (rs1.next()) {
                    id = rs1.getString(1);
                    name = rs1.getString(2);
                    singer = rs1.getString(3);
                    String[] row1 = { id, name, singer };
                    this.EditTableModel.addRow(row1);
                }
                stmt.close();
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            this.ListButton.setBackground(Color.LIGHT_GRAY);
            this.EditButton.setBackground(Color.ORANGE);
            this.HistoryButton.setBackground(Color.LIGHT_GRAY);
            this.SettingButton.setBackground(Color.LIGHT_GRAY);

        } else {

        }

        if (e.getSource() == this.HistoryButton) {
            this.WelcomeLabel_List.setVisible(false);
            this.DefaultPanel.remove(this.WelcomeLabel_List);

            this.EditGroup.setVisible(false);
            this.DefaultPanel.remove(this.EditGroup);

            this.ListGroup.setVisible(false);
            this.DefaultPanel.remove(this.ListGroup);

            this.SettingGroup.setVisible(false);
            this.DefaultPanel.remove(this.SettingGroup);

            this.DefaultPanel.add(this.HistoryGroup, BorderLayout.CENTER);
            this.HistoryGroup.setVisible(true);

            try {
                Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                Statement stmt = connection.createStatement();
                ResultSet rs1 = stmt.executeQuery("Select * from Karaoke.HistoryEdit");
                ResultSetMetaData rsmd = rs1.getMetaData();
                this.HistoryTableModel.getDataVector().removeAllElements();
                int cols = rsmd.getColumnCount();
                String[] colName = new String[cols];
                for (int i = 0; i < cols; i++)
                    colName[i] = rsmd.getColumnName(i + 1);
                this.HistoryTableModel.setColumnIdentifiers(colName);
                String id, name, time, act;
                while (rs1.next()) {
                    id = rs1.getString(1);
                    name = rs1.getString(2);
                    time = rs1.getString(3);
                    act = rs1.getString(4);
                    String[] row1 = { id, name, time, act };
                    this.HistoryTableModel.addRow(row1);
                }
                stmt.close();
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            this.ListButton.setBackground(Color.LIGHT_GRAY);
            this.EditButton.setBackground(Color.LIGHT_GRAY);
            this.HistoryButton.setBackground(Color.RED);
            this.SettingButton.setBackground(Color.LIGHT_GRAY);
        } else {

        }

        if (e.getSource() == this.SettingButton) {
            this.WelcomeLabel_List.setVisible(false);
            this.DefaultPanel.remove(this.WelcomeLabel_List);

            this.EditGroup.setVisible(false);
            this.DefaultPanel.remove(this.EditGroup);

            this.ListGroup.setVisible(false);
            this.DefaultPanel.remove(this.ListGroup);

            this.HistoryGroup.setVisible(false);
            this.DefaultPanel.remove(this.HistoryGroup);

            this.DefaultPanel.add(this.SettingGroup, BorderLayout.CENTER);
            this.SettingGroup.setVisible(true);

            this.ListButton.setBackground(Color.LIGHT_GRAY);
            this.EditButton.setBackground(Color.LIGHT_GRAY);
            this.HistoryButton.setBackground(Color.LIGHT_GRAY);
            this.SettingButton.setBackground(Color.CYAN);
        } else {

        }

        if (e.getSource() == this.FilterButton) {
            this.FilterButton.setEnabled(false);
            this.FilterLabel_List.setVisible(true);
            this.ApplyButton.setVisible(true);
            this.DeleteButton.setVisible(true);
            this.Search.setBounds(90, 300, 300, 30);
            this.SearchButton.setBounds(390, 300, 30, 30);
        } else {

        }

        if (e.getSource() == this.ApplyButton) {
            this.FilterButton.setEnabled(true);
            this.FilterLabel_List.setVisible(false);
            this.ApplyButton.setVisible(false);
            this.DeleteButton.setVisible(false);
            this.Search.setBounds(100, 160, 300, 30);
            this.SearchButton.setBounds(400, 160, 30, 30);
        } else {

        }

        if (this.SongName.isSelected() == true) {
            this.DeleteButton.setEnabled(true);
        } else {

        }

        if (this.SingerName.isSelected() == true) {
            this.DeleteButton.setEnabled(true);
        } else {

        }

        if (e.getSource() == this.SearchButton) {
            if (this.SongName.isSelected() == true) {
                if (this.Search.getText().length() == 0) {
                    try {
                        Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                        Statement stmt = connection.createStatement();
                        ResultSet rs1 = stmt.executeQuery(
                                "Select SongId, SongName, SingerName from Karaoke.Songlist Order by SongName");
                        ResultSetMetaData rsmd = rs1.getMetaData();
                        this.ListTableModel.getDataVector().removeAllElements();
                        int cols = rsmd.getColumnCount();
                        String[] colName = new String[cols];
                        for (int i = 0; i < cols; i++)
                            colName[i] = rsmd.getColumnName(i + 1);
                        this.ListTableModel.setColumnIdentifiers(colName);
                        String id, name, singer;
                        while (rs1.next()) {
                            id = rs1.getString(1);
                            name = rs1.getString(2);
                            singer = rs1.getString(3);
                            String[] row = { id, name, singer };
                            this.ListTableModel.addRow(row);
                        }
                        stmt.close();
                        connection.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                        Statement stmt = connection.createStatement();
                        ResultSet rs1 = stmt.executeQuery(
                                "select SongID, SongName, SingerName from Karaoke.Songlist where SongName Like '%"
                                        + this.Search.getText() + "%' Order by SongName;");
                        ResultSetMetaData rsmd = rs1.getMetaData();
                        DefaultTableModel ListTableModel = (DefaultTableModel) this.ListTable.getModel();
                        ListTableModel.getDataVector().removeAllElements();
                        int cols = rsmd.getColumnCount();
                        String[] colName = new String[cols];
                        for (int i = 0; i < cols; i++)
                            colName[i] = rsmd.getColumnName(i + 1);
                        ListTableModel.setColumnIdentifiers(colName);
                        String id, name, singer;
                        while (rs1.next()) {
                            id = rs1.getString(1);
                            name = rs1.getString(2);
                            singer = rs1.getString(3);
                            String[] row = { id, name, singer };
                            ListTableModel.addRow(row);
                        }
                        stmt.close();
                        connection.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (this.SingerName.isSelected() == true) {
                if (this.Search.getText().length() == 0) {
                    try {
                        Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                        Statement stmt = connection.createStatement();
                        ResultSet rs1 = stmt.executeQuery(
                                "Select SongId, SongName, SingerName from Karaoke.Songlist Order by SongName");
                        ResultSetMetaData rsmd = rs1.getMetaData();
                        DefaultTableModel ListTableModel = (DefaultTableModel) this.ListTable.getModel();
                        ListTableModel.getDataVector().removeAllElements();
                        int cols = rsmd.getColumnCount();
                        String[] colName = new String[cols];
                        for (int i = 0; i < cols; i++)
                            colName[i] = rsmd.getColumnName(i + 1);
                        ListTableModel.setColumnIdentifiers(colName);
                        String id, name, singer;
                        while (rs1.next()) {
                            id = rs1.getString(1);
                            name = rs1.getString(2);
                            singer = rs1.getString(3);
                            String[] row = { id, name, singer };
                            ListTableModel.addRow(row);
                        }
                        stmt.close();
                        connection.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                        Statement stmt = connection.createStatement();
                        ResultSet rs1 = stmt.executeQuery(
                                "Select SongID, SongName, SingerName from Karaoke.Songlist where SingerName LIKE '%"
                                        + this.Search.getText() + "%' Order by SongName ;");
                        ResultSetMetaData rsmd = rs1.getMetaData();
                        DefaultTableModel ListTableModel = (DefaultTableModel) this.ListTable.getModel();
                        ListTableModel.getDataVector().removeAllElements();
                        int cols = rsmd.getColumnCount();
                        String[] colName = new String[cols];
                        for (int i = 0; i < cols; i++)
                            colName[i] = rsmd.getColumnName(i + 1);
                        ListTableModel.setColumnIdentifiers(colName);
                        String id, name, singer;
                        while (rs1.next()) {
                            id = rs1.getString(1);
                            name = rs1.getString(2);
                            singer = rs1.getString(3);
                            String[] row = { id, name, singer };
                            ListTableModel.addRow(row);
                        }
                        stmt.close();
                        connection.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
                if (this.Search.getText().length() == 0) {
                    try {
                        Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                        Statement stmt = connection.createStatement();
                        ResultSet rs1 = stmt.executeQuery(
                                "Select SongID, SongName, SingerName from Karaoke.Songlist Order by SongName");
                        ResultSetMetaData rsmd = rs1.getMetaData();
                        DefaultTableModel ListTableModel = (DefaultTableModel) this.ListTable.getModel();
                        ListTableModel.getDataVector().removeAllElements();
                        int cols = rsmd.getColumnCount();
                        String[] colName = new String[cols];
                        for (int i = 0; i < cols; i++)
                            colName[i] = rsmd.getColumnName(i + 1);
                        ListTableModel.setColumnIdentifiers(colName);
                        String id, name, singer;
                        while (rs1.next()) {
                            id = rs1.getString(1);
                            name = rs1.getString(2);
                            singer = rs1.getString(3);
                            String[] row = { id, name, singer };
                            ListTableModel.addRow(row);
                        }
                        stmt.close();
                        connection.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                        Statement stmt = connection.createStatement();
                        ResultSet rs1 = stmt.executeQuery(
                                "Select SongID, SongName, SingerName from Karaoke.Songlist where SongName LIKE '%"
                                        + this.Search.getText() + "%' or SingerName LIKE '%" + this.Search.getText()
                                        + "%' Order by SongName;");
                        ResultSetMetaData rsmd = rs1.getMetaData();
                        DefaultTableModel ListTableModel = (DefaultTableModel) this.ListTable.getModel();
                        ListTableModel.getDataVector().removeAllElements();
                        int cols = rsmd.getColumnCount();
                        String[] colName = new String[cols];
                        for (int i = 0; i < cols; i++)
                            colName[i] = rsmd.getColumnName(i + 1);
                        ListTableModel.setColumnIdentifiers(colName);
                        String id, name, singer;
                        while (rs1.next()) {
                            id = rs1.getString(1);
                            name = rs1.getString(2);
                            singer = rs1.getString(3);
                            String[] row = { id, name, singer };
                            ListTableModel.addRow(row);
                        }
                        stmt.close();
                        connection.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        if (e.getSource() == this.DeleteButton) {
            this.FilterChoose.clearSelection();
            this.DeleteButton.setEnabled(false);
        } else {

        }

        if (e.getSource() == this.Add) {
            this.AddSong.setVisible(true);
            this.AddSongNameTx.setVisible(true);
            this.AddSingerTx.setVisible(true);
            this.AddSongName.setVisible(true);
            this.AddSinger.setVisible(true);
            this.AddInfo.setVisible(true);

            this.UpdateSong.setVisible(false);
            this.UpdateInfo.setVisible(false);
            this.UpdateSinger.setVisible(false);
            this.UpdateSongName.setVisible(false);
            this.UpdateSingerTx.setVisible(false);
            this.UpdateSongNameTx.setVisible(false);
            this.SearchUpdate1.setVisible(false);
            this.ID_Update.setVisible(false);
            this.IDtf_Update.setVisible(false);

            this.DeleteSong.setVisible(false);
            this.DeleteInfo.setVisible(false);
            this.DeleteSinger.setVisible(false);
            this.DeleteSongName.setVisible(false);
            this.DeleteSongTx.setVisible(false);
            this.DeleteSingerTx.setVisible(false);
            this.DeleteSearch1.setVisible(false);
            this.ID_Delete.setVisible(false);
            this.IDtf_Delete.setVisible(false);
        } else if (e.getSource() == this.Update) {

            this.UpdateSong.setVisible(true);
            this.UpdateInfo.setVisible(true);
            this.UpdateSinger.setVisible(true);
            this.UpdateSongName.setVisible(true);
            this.UpdateSingerTx.setVisible(true);
            this.UpdateSongNameTx.setVisible(true);
            this.SearchUpdate1.setVisible(true);
            this.ID_Update.setVisible(true);
            this.IDtf_Update.setVisible(true);

            this.EditTable.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent arg0) {
                    int i = InAppFrame.this.EditTable.getSelectedRow();
                    InAppFrame.this.IDtf_Update.setText(InAppFrame.this.EditTable.getValueAt(i, 0).toString());
                    InAppFrame.this.UpdateSongName.setText(InAppFrame.this.EditTableModel.getValueAt(i, 1).toString());
                    InAppFrame.this.UpdateSinger.setText(InAppFrame.this.EditTableModel.getValueAt(i, 2).toString());
                }
            });

            this.AddSong.setVisible(false);
            this.AddSongNameTx.setVisible(false);
            this.AddSingerTx.setVisible(false);
            this.AddSongName.setVisible(false);
            this.AddSinger.setVisible(false);
            this.AddInfo.setVisible(false);

            this.DeleteSong.setVisible(false);
            this.DeleteInfo.setVisible(false);
            this.DeleteSinger.setVisible(false);
            this.DeleteSongName.setVisible(false);
            this.DeleteSongTx.setVisible(false);
            this.DeleteSingerTx.setVisible(false);
            this.DeleteSearch1.setVisible(false);
            this.ID_Delete.setVisible(false);
            this.IDtf_Delete.setVisible(false);
        } else if (e.getSource() == this.Delete) {

            this.AddSong.setVisible(false);
            this.AddSongNameTx.setVisible(false);
            this.AddSingerTx.setVisible(false);
            this.AddSongName.setVisible(false);
            this.AddSinger.setVisible(false);
            this.AddInfo.setVisible(false);

            this.UpdateSong.setVisible(false);
            this.UpdateInfo.setVisible(false);
            this.UpdateSinger.setVisible(false);
            this.UpdateSongName.setVisible(false);
            this.UpdateSingerTx.setVisible(false);
            this.UpdateSongNameTx.setVisible(false);
            this.SearchUpdate1.setVisible(false);
            this.ID_Update.setVisible(false);
            this.IDtf_Update.setVisible(false);

            this.DeleteSong.setVisible(true);
            this.DeleteInfo.setVisible(true);
            this.DeleteSinger.setVisible(true);
            this.DeleteSongName.setVisible(true);
            this.DeleteSongTx.setVisible(true);
            this.DeleteSingerTx.setVisible(true);
            this.DeleteSearch1.setVisible(true);
            this.ID_Delete.setVisible(true);
            this.IDtf_Delete.setVisible(true);

            this.EditTable.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent arg0) {
                    int i = InAppFrame.this.EditTable.getSelectedRow();
                    InAppFrame.this.IDtf_Delete.setText(InAppFrame.this.EditTable.getValueAt(i, 0).toString());
                    InAppFrame.this.DeleteSongName.setText(InAppFrame.this.EditTableModel.getValueAt(i, 1).toString());
                    InAppFrame.this.DeleteSinger.setText(InAppFrame.this.EditTableModel.getValueAt(i, 2).toString());
                }
            });
        }

        if (e.getSource() == this.AddInfo) {
            if (this.AddSongName.getText().length() != 0) {
                if (this.AddSinger.getText().length() != 0) {
                    try {
                        Connection connection6 = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                        Statement stmt6 = connection6.createStatement();
                        ResultSet rs6 = stmt6.executeQuery("Select SongName , SingerName from Karaoke.Songlist");
                        this.Songname = new ArrayList<String>();
                        this.Singername = new ArrayList<String>();
                        while (rs6.next()) {
                            this.Songname.add(rs6.getString(1));
                            this.Singername.add(rs6.getString(2));
                        }
                        connection6.close();
                        if (this.Songname.contains(this.AddSongName.getText()) != true) {
                            if (this.Singername.contains(this.AddSinger.getText()) != true) {
                                try {
                                    Connection connection1 = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                                    Statement stmt1 = connection1.createStatement();
                                    ResultSet rs1 = stmt1
                                            .executeQuery("Select Max(Songid) from Karaoke.Songlist Order by SongName");
                                    while (rs1.next()) {
                                        this.max = rs1.getInt(1);
                                    }
                                    this.max++;
                                    stmt1.executeUpdate("insert into Karaoke.SongList values(" + this.max + ",'"
                                            + this.AddSongName.getText() + "','" + this.AddSinger.getText() + "');");
                                    stmt1.executeUpdate("insert into Karaoke.HistoryEdit values(" + this.max + ",'"
                                            + this.AddSongName.getText() + "','" + this.formatter.format(this.date)
                                            + "','ADD');");
                                    Statement stmt3 = connection1.createStatement();
                                    ResultSet rs3 = stmt3
                                            .executeQuery("Select * from Karaoke.SongList Order by SongName");
                                    ResultSetMetaData rsmd = rs3.getMetaData();
                                    this.EditTableModel.getDataVector().removeAllElements();
                                    int cols = rsmd.getColumnCount();
                                    String[] colName = new String[cols];
                                    for (int i = 0; i < cols; i++)
                                        colName[i] = rsmd.getColumnName(i + 1);
                                    this.EditTableModel.setColumnIdentifiers(colName);
                                    String id, name, singer;
                                    while (rs3.next()) {
                                        id = rs3.getString(1);
                                        name = rs3.getString(2);
                                        singer = rs3.getString(3);
                                        String[] row1 = { id, name, singer };
                                        this.EditTableModel.addRow(row1);
                                    }
                                    stmt1.close();
                                    connection1.close();
                                    JOptionPane.showMessageDialog(null, "This song has been add successful!",
                                            "Congratulation!!!", JOptionPane.INFORMATION_MESSAGE);
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "This song cannot be add!", "Congratulation!!!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                }
                            } else {
                                try {
                                    Connection connection1 = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                                    Statement stmt1 = connection1.createStatement();
                                    ResultSet rs1 = stmt1
                                            .executeQuery("Select Max(Songid) from Karaoke.Songlist Order by SongName");
                                    while (rs1.next()) {
                                        this.max = rs1.getInt(1);
                                    }
                                    this.max++;
                                    stmt1.executeUpdate("insert into Karaoke.SongList values(" + this.max + ",'"
                                            + this.AddSongName.getText() + "','" + this.AddSinger.getText() + "');");
                                    stmt1.executeUpdate("insert into Karaoke.HistoryEdit values(" + this.max + ",'"
                                            + this.AddSongName.getText() + "','" + this.formatter.format(this.date)
                                            + "','ADD');");
                                    Statement stmt3 = connection1.createStatement();
                                    ResultSet rs3 = stmt3
                                            .executeQuery("Select * from Karaoke.SongList Order by SongName");
                                    ResultSetMetaData rsmd = rs3.getMetaData();
                                    this.EditTableModel.getDataVector().removeAllElements();
                                    int cols = rsmd.getColumnCount();
                                    String[] colName = new String[cols];
                                    for (int i = 0; i < cols; i++)
                                        colName[i] = rsmd.getColumnName(i + 1);
                                    this.EditTableModel.setColumnIdentifiers(colName);
                                    String id, name, singer;
                                    while (rs3.next()) {
                                        id = rs3.getString(1);
                                        name = rs3.getString(2);
                                        singer = rs3.getString(3);
                                        String[] row1 = { id, name, singer };
                                        this.EditTableModel.addRow(row1);
                                    }
                                    stmt1.close();
                                    connection1.close();
                                    JOptionPane.showMessageDialog(null, "This song has been add successful!",
                                            "Congratulation!!!", JOptionPane.INFORMATION_MESSAGE);
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "This song cannot be add!", "Congratulation!!!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        } else {
                            if (this.Singername.contains(this.AddSinger.getText()) != true) {
                                try {
                                    Connection connection1 = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                                    Statement stmt1 = connection1.createStatement();
                                    ResultSet rs1 = stmt1
                                            .executeQuery("Select Max(Songid) from Karaoke.Songlist Order by SongName");
                                    while (rs1.next()) {
                                        this.max = rs1.getInt(1);
                                    }
                                    this.max++;
                                    stmt1.executeUpdate("insert into Karaoke.SongList values(" + this.max + ",'"
                                            + this.AddSongName.getText() + "','" + this.AddSinger.getText() + "');");
                                    stmt1.executeUpdate("insert into Karaoke.HistoryEdit values(" + this.max + ",'"
                                            + this.AddSongName.getText() + "','" + this.formatter.format(this.date)
                                            + "','ADD');");
                                    Statement stmt3 = connection1.createStatement();
                                    ResultSet rs3 = stmt3
                                            .executeQuery("Select * from Karaoke.SongList Order by SongName");
                                    ResultSetMetaData rsmd = rs3.getMetaData();
                                    this.EditTableModel.getDataVector().removeAllElements();
                                    int cols = rsmd.getColumnCount();
                                    String[] colName = new String[cols];
                                    for (int i = 0; i < cols; i++)
                                        colName[i] = rsmd.getColumnName(i + 1);
                                    this.EditTableModel.setColumnIdentifiers(colName);
                                    String id, name, singer;
                                    while (rs3.next()) {
                                        id = rs3.getString(1);
                                        name = rs3.getString(2);
                                        singer = rs3.getString(3);
                                        String[] row1 = { id, name, singer };
                                        this.EditTableModel.addRow(row1);
                                    }
                                    stmt1.close();
                                    connection1.close();
                                    JOptionPane.showMessageDialog(null, "This song has been add successful!",
                                            "Congratulation!!!", JOptionPane.INFORMATION_MESSAGE);
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "This song cannot be add!", "Congratulation!!!",
                                            JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "This song already exist", "Warning",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill all Text Field", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all Text Field", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == this.DeleteInfo) {
            if (this.IDtf_Delete.getText().length() != 0) {
                if (this.DeleteSongName.getText().length() != 0) {
                    if (this.DeleteSinger.getText().length() != 0) {
                        try {
                            Connection connection7 = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                            Statement stmt7 = connection7.createStatement();
                            ResultSet rs7 = stmt7.executeQuery("Select * from Karaoke.Songlist ");
                            this.idDel = new ArrayList<Integer>();
                            this.Songname1 = new ArrayList<String>();
                            this.Singername1 = new ArrayList<String>();
                            while (rs7.next()) {
                                this.idDel.add(rs7.getInt(1));
                                this.Songname1.add(rs7.getString(2));
                                this.Singername1.add(rs7.getString(3));
                            }
                            if (this.idDel.contains(Integer.parseInt(this.IDtf_Delete.getText()))) {
                                if (this.Songname1.contains(this.DeleteSongName.getText())) {
                                    if (this.Singername1.contains(this.DeleteSinger.getText())) {
                                        try {
                                            Connection connection8 = DriverManager.getConnection(DB_URL, USER_NAME,
                                                    PASSWORD);
                                            Statement stmt8 = connection8.createStatement();
                                            ResultSet rs8 = stmt8
                                                    .executeQuery("Select * from Karaoke.Songlist where songname = '"
                                                            + this.DeleteSongName.getText() + "'and Singername = '"
                                                            + this.DeleteSinger.getText() + "';");
                                            while (rs8.next()) {
                                                this.ID = rs8.getInt(1);
                                                this.Song = rs8.getString(2);
                                                this.Singer = rs8.getString(3);
                                            }
                                            stmt8.executeUpdate("insert into Karaoke.Historyedit values('" + this.ID
                                                    + "','" + this.Song + "','" + this.formatter.format(this.date)
                                                    + "','DELETE');");
                                            stmt8.executeUpdate(
                                                    "Delete from Karaoke.Songlist where SongID = " + this.ID + ";");
                                            Statement stmt9 = connection8.createStatement();
                                            ResultSet rs9 = stmt9
                                                    .executeQuery("Select * from Karaoke.SongList Order by SongName");
                                            ResultSetMetaData rsmd = rs9.getMetaData();
                                            this.EditTableModel.getDataVector().removeAllElements();
                                            int cols = rsmd.getColumnCount();
                                            String[] colName = new String[cols];
                                            for (int i = 0; i < cols; i++)
                                                colName[i] = rsmd.getColumnName(i + 1);
                                            this.EditTableModel.setColumnIdentifiers(colName);
                                            String id, name, singer;
                                            while (rs9.next()) {
                                                id = rs9.getString(1);
                                                name = rs9.getString(2);
                                                singer = rs9.getString(3);
                                                String[] row1 = { id, name, singer };
                                                this.EditTableModel.addRow(row1);
                                            }
                                            stmt9.close();
                                            connection8.close();
                                            JOptionPane.showMessageDialog(null, "This song has been delete successful!",
                                                    "Congratulation!!!", JOptionPane.INFORMATION_MESSAGE);
                                        } catch (Exception ex) {
                                            JOptionPane.showMessageDialog(null, "Cannot delete this song!", "Warning",
                                                    JOptionPane.WARNING_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "This singer not exist!", "Warning",
                                                JOptionPane.WARNING_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "This song not exist!", "Warning",
                                            JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "This song ID not exist!", "Warning",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                            connection7.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please fill all Text Field", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    if (this.DeleteSinger.getText().length() == 0) {
                        try {
                            Connection connection10 = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                            Statement stmt10 = connection10.createStatement();
                            ResultSet rs10 = stmt10.executeQuery("Select * from Karaoke.Songlist where SongID = '"
                                    + this.IDtf_Delete.getText() + "';");
                            while (rs10.next()) {
                                this.ID = rs10.getInt(1);
                                this.Song = rs10.getString(2);
                                this.Singer = rs10.getString(3);
                            }
                            stmt10.executeUpdate("insert into Karaoke.Historyedit values('" + this.ID + "','"
                                    + this.Song + "','" + this.formatter.format(this.date) + "','DELETE');");
                            stmt10.executeUpdate("Delete from Karaoke.Songlist where SongID = " + this.ID + ";");
                            Statement stmt11 = connection10.createStatement();
                            ResultSet rs11 = stmt11.executeQuery("Select * from Karaoke.SongList Order by SongName");
                            ResultSetMetaData rsmd11 = rs11.getMetaData();
                            this.EditTableModel.getDataVector().removeAllElements();
                            int cols = rsmd11.getColumnCount();
                            String[] colName = new String[cols];
                            for (int i = 0; i < cols; i++)
                                colName[i] = rsmd11.getColumnName(i + 1);
                            this.EditTableModel.setColumnIdentifiers(colName);
                            String id, name, singer;
                            while (rs11.next()) {
                                id = rs11.getString(1);
                                name = rs11.getString(2);
                                singer = rs11.getString(3);
                                String[] row1 = { id, name, singer };
                                this.EditTableModel.addRow(row1);
                            }
                            stmt11.close();
                            connection10.close();
                            JOptionPane.showMessageDialog(null, "This song has been delete successful!",
                                    "Congratulation!!!", JOptionPane.INFORMATION_MESSAGE);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Cannot delete this song!", "Warning",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please fill all Text Field", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            } else if (this.IDtf_Delete.getText().length() == 0) {
                if (this.DeleteSongName.getText().length() != 0) {
                    if (this.DeleteSinger.getText().length() != 0) {
                        try {
                            Connection connection7 = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                            Statement stmt7 = connection7.createStatement();
                            ResultSet rs7 = stmt7.executeQuery("Select SongName , SingerName from Karaoke.Songlist");
                            this.Songname1 = new ArrayList<String>();
                            this.Singername1 = new ArrayList<String>();
                            while (rs7.next()) {
                                this.Songname1.add(rs7.getString(1));
                                this.Singername1.add(rs7.getString(2));
                            }
                            if (this.Songname1.contains(this.DeleteSongName.getText())) {
                                if (this.Singername1.contains(this.DeleteSinger.getText())) {
                                    try {
                                        Connection connection8 = DriverManager.getConnection(DB_URL, USER_NAME,
                                                PASSWORD);
                                        Statement stmt8 = connection8.createStatement();
                                        ResultSet rs8 = stmt8
                                                .executeQuery("Select * from Karaoke.Songlist where songname = '"
                                                        + this.DeleteSongName.getText() + "'and Singername = '"
                                                        + this.DeleteSinger.getText() + "';");
                                        while (rs8.next()) {
                                            this.ID = rs8.getInt(1);
                                            this.Song = rs8.getString(2);
                                            this.Singer = rs8.getString(3);
                                        }
                                        stmt8.executeUpdate(
                                                "insert into Karaoke.Historyedit values('" + this.ID + "','" + this.Song
                                                        + "','" + this.formatter.format(this.date) + "','DELETE');");
                                        stmt8.executeUpdate(
                                                "Delete from Karaoke.Songlist where SongID = " + this.ID + ";");
                                        Statement stmt9 = connection8.createStatement();
                                        ResultSet rs9 = stmt9
                                                .executeQuery("Select * from Karaoke.SongList Order by SongName");
                                        ResultSetMetaData rsmd = rs9.getMetaData();
                                        this.EditTableModel.getDataVector().removeAllElements();
                                        int cols = rsmd.getColumnCount();
                                        String[] colName = new String[cols];
                                        for (int i = 0; i < cols; i++)
                                            colName[i] = rsmd.getColumnName(i + 1);
                                        this.EditTableModel.setColumnIdentifiers(colName);
                                        String id, name, singer;
                                        while (rs9.next()) {
                                            id = rs9.getString(1);
                                            name = rs9.getString(2);
                                            singer = rs9.getString(3);
                                            String[] row1 = { id, name, singer };
                                            this.EditTableModel.addRow(row1);
                                        }
                                        stmt9.close();
                                        connection8.close();
                                        JOptionPane.showMessageDialog(null, "This song has been delete successful!",
                                                "Congratulation!!!", JOptionPane.INFORMATION_MESSAGE);
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, "Cannot delete this song!", "Warning",
                                                JOptionPane.WARNING_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "This singer not exist!", "Warning",
                                            JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "This song not exist!", "Warning",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                            connection7.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please fill all Text Field", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill all Text Field", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {

        }

        if (e.getSource() == this.UpdateInfo) {
            if (this.IDtf_Update.getText().length() != 0) {
                if (this.UpdateSongName.getText().length() != 0) {
                    if (this.UpdateSinger.getText().length() != 0) {
                        try {
                            Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                            Statement stmt = connection.createStatement();
                            ResultSet rs = stmt.executeQuery("Select SongID from Karaoke.Songlist");
                            this.idUp = new ArrayList<Integer>();
                            while (rs.next()) {
                                this.idUp.add(rs.getInt(1));
                            }
                            if (this.idUp.contains(Integer.parseInt(this.IDtf_Update.getText()))) {
                                try {
                                    Connection connection12 = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                                    Statement stmt12 = connection12.createStatement();
                                    ResultSet rs12 = stmt12.executeQuery(
                                            "Select Songname , Singername from Karaoke.Songlist where SongID = '"
                                                    + this.IDtf_Update.getText() + "'");
                                    while (rs12.next()) {
                                        this.SN = rs12.getString(1);
                                        this.SGN = rs12.getString(2);
                                    }
                                    if (this.SN.equals(this.UpdateSongName.getText()) != true) {
                                        if (this.SGN.equals(this.UpdateSinger.getText()) != true) {
                                            stmt12.executeUpdate("insert into Karaoke.Historyedit values('"
                                                    + this.IDtf_Update.getText() + "','" + this.UpdateSongName.getText()
                                                    + "','" + this.formatter.format(this.date) + "','UPDATE');");
                                            stmt12.executeUpdate("Update Karaoke.Songlist set SongName = '"
                                                    + this.UpdateSongName.getText() + "', SingerName = '"
                                                    + this.UpdateSinger.getText() + "' where SongID = "
                                                    + this.IDtf_Update.getText() + ";");
                                            Statement stmt13 = connection12.createStatement();
                                            ResultSet rs13 = stmt13
                                                    .executeQuery("Select * from Karaoke.SongList Order by SongName");
                                            ResultSetMetaData rsmd12 = rs13.getMetaData();
                                            this.EditTableModel.getDataVector().removeAllElements();
                                            int cols = rsmd12.getColumnCount();
                                            String[] colName = new String[cols];
                                            for (int i = 0; i < cols; i++)
                                                colName[i] = rsmd12.getColumnName(i + 1);
                                            this.EditTableModel.setColumnIdentifiers(colName);
                                            String id, name, singer;
                                            while (rs13.next()) {
                                                id = rs13.getString(1);
                                                name = rs13.getString(2);
                                                singer = rs13.getString(3);
                                                String[] row1 = { id, name, singer };
                                                this.EditTableModel.addRow(row1);
                                            }
                                            JOptionPane.showMessageDialog(null, "This song has been update successful!",
                                                    "Congratulation!!!", JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            stmt12.executeUpdate("insert into Karaoke.Historyedit values('"
                                                    + this.IDtf_Update.getText() + "','" + this.UpdateSongName.getText()
                                                    + "','" + this.formatter.format(this.date) + "','UPDATE');");
                                            stmt12.executeUpdate("Update Karaoke.Songlist set SongName = '"
                                                    + this.UpdateSongName.getText() + "' where SongID = '"
                                                    + this.IDtf_Update.getText() + "';");
                                            Statement stmt13 = connection12.createStatement();
                                            ResultSet rs13 = stmt13
                                                    .executeQuery("Select * from Karaoke.SongList Order by SongName");
                                            ResultSetMetaData rsmd12 = rs13.getMetaData();
                                            this.EditTableModel.getDataVector().removeAllElements();
                                            int cols = rsmd12.getColumnCount();
                                            String[] colName = new String[cols];
                                            for (int i = 0; i < cols; i++)
                                                colName[i] = rsmd12.getColumnName(i + 1);
                                            this.EditTableModel.setColumnIdentifiers(colName);
                                            String id, name, singer;
                                            while (rs13.next()) {
                                                id = rs13.getString(1);
                                                name = rs13.getString(2);
                                                singer = rs13.getString(3);
                                                String[] row1 = { id, name, singer };
                                                this.EditTableModel.addRow(row1);

                                            }
                                            JOptionPane.showMessageDialog(null, "This song has been update successful!",
                                                    "Congratulation!!!", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } else {
                                        if (this.SGN.equals(this.UpdateSinger.getText()) != true) {
                                            stmt12.executeUpdate("insert into Karaoke.Historyedit values('"
                                                    + this.IDtf_Update.getText() + "','" + this.UpdateSongName.getText()
                                                    + "','" + this.formatter.format(this.date) + "','UPDATE');");
                                            stmt12.executeUpdate("Update Karaoke.Songlist set SingerName = '"
                                                    + this.UpdateSinger.getText() + "' where SongID = '"
                                                    + this.IDtf_Update.getText() + "';");
                                            rs12.close();
                                            Statement stmt13 = connection12.createStatement();
                                            ResultSet rs13 = stmt13
                                                    .executeQuery("Select * from Karaoke.SongList Order by SongName");
                                            ResultSetMetaData rsmd12 = rs13.getMetaData();
                                            this.EditTableModel.getDataVector().removeAllElements();
                                            int cols = rsmd12.getColumnCount();
                                            String[] colName = new String[cols];
                                            for (int i = 0; i < cols; i++)
                                                colName[i] = rsmd12.getColumnName(i + 1);
                                            this.EditTableModel.setColumnIdentifiers(colName);
                                            String id, name, singer;
                                            while (rs13.next()) {
                                                id = rs13.getString(1);
                                                name = rs13.getString(2);
                                                singer = rs13.getString(3);
                                                String[] row1 = { id, name, singer };
                                                this.EditTableModel.addRow(row1);
                                            }
                                            JOptionPane.showMessageDialog(null, "This song has been update successful!",
                                                    "Congratulation!!!", JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(null, "information not change !", "Warning",
                                                    JOptionPane.WARNING_MESSAGE);
                                        }
                                    }
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "Cannot update !", "Warning",
                                            JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "ID song not exist !", "Warning",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                            connection.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please fill all Text Field !", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill all Text Field !", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all Text Field !", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {

        }

        if (e.getSource() == this.signout) {
            String choose[] = { "Ok", "Cancel" };
            int get = JOptionPane.showOptionDialog(null, "Do you wanna sign out ?", "Warning",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, this.question, choose, 0);
            if (get == 0) {
                this.InAppFrame.dispose();
                new mainFrame();
            } else {

            }
        }

        if (e.getSource() == this.HistorySignin) {
            this.changeusername_setting.setVisible(false);
            this.SettingGroup.remove(this.changeusername_setting);

            this.deleteacc_setting.setVisible(false);
            this.SettingGroup.remove(this.deleteacc_setting);

            this.changepass_setting.setVisible(false);
            this.SettingGroup.remove(this.changepass_setting);

            this.SettingGroup.add(this.history_setting, BorderLayout.EAST);
            this.history_setting.setVisible(true);
            try {
                Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                Statement stmt = connection.createStatement();
                ResultSet rs1 = stmt
                        .executeQuery("Select TimeSI from Karaoke.SigninHis where Email = '" + this.EM + "'");
                ResultSetMetaData rsmd = rs1.getMetaData();
                this.Historydftb_setting.getDataVector().removeAllElements();
                int cols = rsmd.getColumnCount();
                String[] colName = new String[cols];
                for (int i = 0; i < cols; i++)
                    colName[i] = rsmd.getColumnName(i + 1);
                this.Historydftb_setting.setColumnIdentifiers(colName);
                String Time;
                while (rs1.next()) {
                    Time = rs1.getString(1);
                    String[] row1 = { Time };
                    this.Historydftb_setting.addRow(row1);
                }
                stmt.close();
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {

        }

        if (e.getSource() == this.changeusername) {
            this.history_setting.setVisible(false);
            this.SettingGroup.remove(this.history_setting);

            this.deleteacc_setting.setVisible(false);
            this.SettingGroup.remove(this.deleteacc_setting);
            this.InputPass_DelAcc.setText(null);
            this.InputPass_DelAcc.setEchoChar('*');
            this.InputCode_DellAccTF.setText(null);

            this.changepass_setting.setVisible(false);
            this.SettingGroup.remove(this.changepass_setting);

            this.inputCode_changeUSN.setVisible(false);
            this.inputCode_changeUSN.setText(null);
            this.changeUsernameCode.setVisible(false);
            this.NextbutCode_changeUSN.setVisible(false);
            this.SendCodeAgainBut.setVisible(false);

            this.newUserName.setVisible(false);
            this.changeNewUsername.setVisible(false);
            this.changeNewUsername.setText(null);
            this.nextNewUS.setVisible(false);

            this.SettingGroup.add(this.changeusername_setting, BorderLayout.EAST);
            this.changeusername_setting.setVisible(true);
            this.changeUsernameTFpass.setVisible(true);
            this.show.setSelected(false);
            this.show.setVisible(true);
            this.NextBut_ChangeUsN.setVisible(true);
            this.changeUsernameTApass.setVisible(true);
            this.changeUsernameTFpass.setText(null);
            this.changeUsernameTFpass.setEchoChar('*');
        } else {

        }

        if (e.getSource() == this.NextBut_ChangeUsN) {
            if (this.changeUsernameTFpass.getText().length() != 0) {
                try {
                    Connection connection20 = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                    Statement stmt20 = connection20.createStatement();
                    ResultSet rs20 = stmt20.executeQuery(
                            "Select UserName, Email, cast(aes_decrypt(pass,'key123') as char) as showpass from Karaoke.UserList where Email = '"
                                    + this.EM + "' and UserName = '" + this.USN + "' ");
                    while (rs20.next()) {
                        this.username = rs20.getString(1);
                        this.Email = rs20.getString(2);
                        this.password = rs20.getString(3);
                    }
                    if (this.username.equals(this.USN) == true && this.Email.equalsIgnoreCase(this.EM) == true
                            && this.password.equals(this.changeUsernameTFpass.getText()) == true) {
                        sendmail send = new sendmail(this.EM);
                        this.code = send.n;
                        if (send.get == true) {
                            JOptionPane.showMessageDialog(null, "Code has been sent to your email!", "Congrtulation!!!",
                                    JOptionPane.INFORMATION_MESSAGE);
                            this.changeUsernameTFpass.setVisible(false);
                            this.show.setVisible(false);
                            this.NextBut_ChangeUsN.setVisible(false);
                            this.changeUsernameTApass.setVisible(false);

                            this.inputCode_changeUSN.setVisible(true);
                            this.changeUsernameCode.setVisible(true);
                            this.NextbutCode_changeUSN.setVisible(true);
                            this.SendCodeAgainBut.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Code cannot be sent !", "Warning",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong password !", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password field cannot be null !", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {

        }

        if (e.getSource() == this.NextbutCode_changeUSN) {
            if (this.inputCode_changeUSN.getText().length() != 0) {
                if (this.code == Integer.parseInt(this.inputCode_changeUSN.getText())) {
                    this.inputCode_changeUSN.setVisible(false);
                    this.inputCode_changeUSN.setText(null);
                    this.changeUsernameCode.setVisible(false);
                    this.NextbutCode_changeUSN.setVisible(false);
                    this.SendCodeAgainBut.setVisible(false);

                    this.newUserName.setVisible(true);
                    this.changeNewUsername.setVisible(true);
                    this.nextNewUS.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong verificate code !", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please input varificate code!", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {

        }

        if (e.getSource() == this.nextNewUS) {
            if (this.changeNewUsername.getText().length() != 0) {
                if (this.changeNewUsername.getText().length() >= 7) {
                    if (this.changeNewUsername.getText().length() <= 22) {
                        try {
                            Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                            Statement stmt = connection.createStatement();
                            ResultSet rs = stmt.executeQuery("Select UserName from Karaoke.UserList");
                            ArrayList<String> usn = new ArrayList<String>();
                            while (rs.next()) {
                                usn.add(rs.getString(1));
                            }
                            if (usn.contains(this.changeNewUsername.getText()) != true) {
                                try {
                                    Connection connection30 = DriverManager.getConnection(DB_URL, USER_NAME,
                                            PASSWORD);
                                    Statement stmt30 = connection30.createStatement();
                                    stmt30.executeUpdate("Update Karaoke.UserList set UserName = '"
                                            + this.changeNewUsername.getText() + "' where Email = '" + this.EM + "' ");
                                    this.USN = this.changeNewUsername.getText();
                                    JOptionPane.showMessageDialog(null,
                                            "Yayy!!! your user name has been change successful!", "Congrtulation!!!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                    this.newUserName.setVisible(false);
                                    this.changeNewUsername.setVisible(false);
                                    this.changeNewUsername.setText(null);
                                    this.nextNewUS.setVisible(false);

                                    this.changeUsernameTFpass.setVisible(true);
                                    this.changeUsernameTFpass.setText(null);
                                    this.changeUsernameTFpass.setEchoChar('*');
                                    this.show.setVisible(true);
                                    this.show.setSelected(false);
                                    this.NextBut_ChangeUsN.setVisible(true);
                                    this.changeUsernameTApass.setVisible(true);
                                    connection30.close();
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "Cannot change your username!", "Warning!",
                                            JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "This user name already exist!", "Warning!",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                            connection.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "User name is too long !", "Warning!",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "User name must over than 7 charater!", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "User name field cannot be null!", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {

        }

        if (e.getSource() == this.SendCodeAgainBut) {
            sendmail sm = new sendmail(this.EM);
            this.code = sm.n;
            if (sm.get == true) {
                JOptionPane.showMessageDialog(null, "Code has been sent to your email!", "Congrtulation!!!",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Code cannot be sent !", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {

        }

        if (this.show1.isSelected()) {
            this.oldPASSTF.setEchoChar((char) 0);
        } else {
            this.oldPASSTF.setEchoChar('*');
        }

        if (e.getSource() == this.changepass) {
            this.changeusername_setting.setVisible(false);
            this.SettingGroup.remove(this.changeusername_setting);

            this.history_setting.setVisible(false);
            this.SettingGroup.remove(this.history_setting);

            this.deleteacc_setting.setVisible(false);
            this.SettingGroup.remove(this.deleteacc_setting);
            this.InputPass_DelAcc.setText(null);
            this.InputPass_DelAcc.setEchoChar('*');
            this.InputCode_DellAccTF.setText(null);
            this.SettingGroup.remove(this.history_setting);

            this.oldPASSTF.setText(null);
            this.oldPASSTF.setEchoChar('*');
            this.show1.setSelected(false);
            this.SettingGroup.add(this.changepass_setting, BorderLayout.EAST);
            this.changepass_setting.setVisible(true);

            this.oldPASSTF.setVisible(true);
            this.show1.setVisible(true);
            this.NextChangepass.setVisible(true);
            this.ChangePASSold.setVisible(true);

            this.NextCode_changepass.setVisible(false);
            this.PassCodeVeri.setVisible(false);
            this.PassCodeVeri.setText(null);
            this.ChangePASS_Code.setVisible(false);
            this.SendCodeAgain_Changepass.setVisible(false);

            this.ChangePASSnew.setVisible(false);
            this.ChangePassnew1.setVisible(false);
            this.newPassTF.setVisible(false);
            this.newPassTF.setText(null);
            this.newPassTF.setEchoChar('*');
            this.newPassTF1.setVisible(false);
            this.newPassTF1.setText(null);
            this.newPassTF1.setEchoChar('*');
            this.show2.setSelected(false);
            this.NextChangePassSuc.setVisible(false);
            this.show2.setVisible(false);
        } else {

        }

        if (e.getSource() == this.NextChangepass) {
            if (this.oldPASSTF.getText().length() != 0) {
                try {
                    Connection connection20 = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                    Statement stmt20 = connection20.createStatement();
                    ResultSet rs20 = stmt20.executeQuery(
                            "Select UserName, Email, cast(aes_decrypt(pass,'key123') as char) as showpass from Karaoke.UserList where Email = '"
                                    + this.EM + "' and UserName = '" + this.USN + "' ");
                    while (rs20.next()) {
                        this.username = rs20.getString(1);
                        this.Email = rs20.getString(2);
                        this.password = rs20.getString(3);
                    }
                    if (this.username.equals(this.USN) == true && this.Email.equalsIgnoreCase(this.EM) == true
                            && this.password.equals(this.oldPASSTF.getText()) == true) {
                        sendmail send = new sendmail(this.EM);
                        this.code = send.n;
                        if (send.get == true) {
                            JOptionPane.showMessageDialog(null, "Code has been sent to your email!", "Congrtulation!!!",
                                    JOptionPane.INFORMATION_MESSAGE);
                            this.oldPASSTF.setVisible(false);
                            this.show1.setVisible(false);
                            this.NextChangepass.setVisible(false);
                            this.ChangePASSold.setVisible(false);

                            this.NextCode_changepass.setVisible(true);
                            this.PassCodeVeri.setVisible(true);
                            this.ChangePASS_Code.setVisible(true);
                            this.SendCodeAgain_Changepass.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Code cannot be sent !", "Warning",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong password !", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please input password!", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } else {

        }

        if (e.getSource() == this.NextCode_changepass) {
            if (this.PassCodeVeri.getText().length() != 0) {
                if (this.code == Integer.parseInt(this.PassCodeVeri.getText())) {
                    this.NextCode_changepass.setVisible(false);
                    this.PassCodeVeri.setVisible(false);
                    this.PassCodeVeri.setText(null);
                    this.ChangePASS_Code.setVisible(false);
                    this.SendCodeAgain_Changepass.setVisible(false);

                    this.ChangePASSnew.setVisible(true);
                    this.ChangePassnew1.setVisible(true);
                    this.newPassTF.setVisible(true);
                    this.newPassTF1.setVisible(true);
                    this.NextChangePassSuc.setVisible(true);
                    this.show2.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong varificate code !", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please input varificate code !", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {

        }
        if (e.getSource() == this.NextChangePassSuc) {
            if (this.newPassTF.getText().length() != 0) {
                if (this.newPassTF1.getText().length() != 0) {
                    if (this.newPassTF.getText().length() >= 7) {
                        if (this.newPassTF.getText().equals(this.newPassTF1.getText())) {
                            try {
                                Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                                Statement stmt = connection.createStatement();
                                ResultSet rs = stmt.executeQuery(
                                        "Select cast(aes_decrypt(pass,'key123') as char) as showpass from Karaoke.UserList");
                                ArrayList<String> Pass = new ArrayList<String>();
                                while (rs.next()) {
                                    Pass.add(rs.getString(1));
                                }
                                if (Pass.contains(this.newPassTF.getText()) != true) {
                                    try {
                                        Connection connection30 = DriverManager.getConnection(DB_URL, USER_NAME,
                                                PASSWORD);
                                        Statement stmt30 = connection30.createStatement();
                                        stmt30.executeUpdate("Update Karaoke.UserList set pass = aes_encrypt('"
                                                + this.newPassTF.getText() + "','key123') where Email = '" + this.EM
                                                + "' ");
                                        JOptionPane.showMessageDialog(null,
                                                "Yayy!!! your user name has been change successful!",
                                                "Congrtulation!!!", JOptionPane.INFORMATION_MESSAGE);
                                        this.ChangePASSnew.setVisible(false);
                                        this.newPassTF1.setText(null);
                                        this.ChangePassnew1.setVisible(false);
                                        this.newPassTF.setText(null);
                                        this.newPassTF.setVisible(false);
                                        this.newPassTF1.setVisible(false);
                                        this.NextChangePassSuc.setVisible(false);
                                        this.show2.setVisible(false);
                                        this.show2.setSelected(false);

                                        this.oldPASSTF.setVisible(true);
                                        this.oldPASSTF.setText(null);
                                        this.oldPASSTF.setEchoChar('*');
                                        this.show1.setVisible(true);
                                        this.show1.setSelected(false);
                                        this.NextChangepass.setVisible(true);
                                        this.ChangePASSold.setVisible(true);
                                        connection30.close();
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, "Cannot change your password!", "Warning!",
                                                JOptionPane.WARNING_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Easy to guest password !", "Warning",
                                            JOptionPane.WARNING_MESSAGE);
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Password confirm not correct !", "Warning",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Password must be over than 7 character !", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please confirm password again !", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password field cannot be null !", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {

        }

        if (e.getSource() == this.SendCodeAgain_Changepass) {
            sendmail sm = new sendmail(this.EM);
            this.code = sm.n;
            if (sm.get == true) {
                JOptionPane.showMessageDialog(null, "Code has been sent to your email!", "Congrtulation!!!",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Code cannot be sent !", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {

        }

        if (this.show3.isSelected() == true) {
            this.InputPass_DelAcc.setEchoChar((char) 0);
        } else {
            this.InputPass_DelAcc.setEchoChar('*');
        }

        if (this.show2.isSelected() == true) {
            this.newPassTF.setEchoChar((char) 0);
            this.newPassTF1.setEchoChar((char) 0);
        } else {
            this.newPassTF.setEchoChar('*');
            this.newPassTF1.setEchoChar('*');
        }

        if (e.getSource() == this.deleteacc) {
            this.history_setting.setVisible(false);
            this.SettingGroup.remove(this.history_setting);

            this.changepass_setting.setVisible(false);
            this.SettingGroup.remove(this.changepass_setting);

            this.changeusername_setting.setVisible(false);
            this.SettingGroup.remove(this.changeusername_setting);

            this.SettingGroup.add(this.deleteacc_setting, BorderLayout.EAST);
            this.deleteacc_setting.setVisible(true);
            this.show3.setSelected(false);
            this.InputPass_DelAcc.setText(null);
            this.InputPass_DelAcc.setEchoChar('*');
            this.InputCode_DellAccTF.setText(null);
        } else {

        }

        if (e.getSource() == this.Next_DelAcc) {
            if (this.InputPass_DelAcc.getText().length() != 0) {
                try {
                    Connection connection20 = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                    Statement stmt20 = connection20.createStatement();
                    ResultSet rs20 = stmt20.executeQuery(
                            "Select UserName, Email, cast(aes_decrypt(pass,'key123') as char) as showpass from Karaoke.UserList where Email = '"
                                    + this.EM + "' and UserName = '" + this.USN + "' ");
                    while (rs20.next()) {
                        this.username = rs20.getString(1);
                        this.Email = rs20.getString(2);
                        this.password = rs20.getString(3);
                    }
                    if (this.username.equals(this.USN) == true && this.Email.equalsIgnoreCase(this.EM) == true
                            && this.password.equals(this.InputPass_DelAcc.getText()) == true) {
                        sendmail send2 = new sendmail(this.EM);
                        this.code = send2.n;
                        if (send2.get == true) {
                            JOptionPane.showMessageDialog(null, "Code has been sent to your email!", "Congrtulation!!!",
                                    JOptionPane.INFORMATION_MESSAGE);
                            this.InputPass_DelAcc.setText(null);
                            this.InputPass_DelAcc.setEchoChar('*');
                            this.InputPass_DelAcc.setVisible(false);
                            this.Next_DelAcc.setVisible(false);
                            this.DelAccTA.setVisible(false);
                            this.show3.setSelected(false);
                            this.show3.setVisible(false);

                            this.Next_DelAcc1.setVisible(true);
                            this.InputCode_DellAccTF.setVisible(true);
                            this.InputCode_DellAccTF.setText(null);
                            this.InputCode_DelAccTA.setVisible(true);
                            this.RedsendCode.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Code cannot be sent !", "Warning",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong password !", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password field cannot be null !", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {

        }

        if (e.getSource() == this.Next_DelAcc1) {
            if (this.InputCode_DellAccTF.getText().length() != 0) {
                if (this.code == Integer.parseInt(this.InputCode_DellAccTF.getText())) {
                    String choose[] = { "Ok", "Cancel" };
                    int get = JOptionPane.showOptionDialog(null, "Are you sure ?", "Warning",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, this.question, choose, 0);
                    if (get == 0) {
                        try {
                            Connection connection30 = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                            Statement stmt30 = connection30.createStatement();
                            stmt30.executeUpdate("Delete from Karaoke.UserList where username = '" + this.USN
                                    + "' and email = '" + this.EM + "' ");
                            JOptionPane.showMessageDialog(null, "Your account has been delete successful !", "Done!!!",
                                    JOptionPane.INFORMATION_MESSAGE);
                            this.Next_DelAcc1.setVisible(false);
                            this.InputCode_DellAccTF.setVisible(false);
                            this.InputCode_DellAccTF.setText(null);
                            this.InputCode_DelAccTA.setVisible(false);
                            this.RedsendCode.setVisible(false);
                            this.InAppFrame.dispose();
                            new mainFrame();
                            connection30.close();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Cannot delete your account !", "Warning!",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Varificate code not correct !", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please input varificate code !", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {

        }

        if (e.getSource() == this.RedsendCode) {
            sendmail sm = new sendmail(this.EM);
            this.code = sm.n;
            if (sm.get == true) {
                JOptionPane.showMessageDialog(null, "Code has been sent to your email!", "Congrtulation!!!",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Code cannot be sent !", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {

        }

    }
}