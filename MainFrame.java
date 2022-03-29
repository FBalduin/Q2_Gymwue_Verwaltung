import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class MainFrame extends JFrame {

    private JPanel contentPane;
    private JTextField vornameField;
    private JTextField nachnameField;
    private JTextField gebDatField;
    private String[] newUsers = parseListToArray(Verwaltung.gymWueUser);
    private JList<String> guiUserList = new JList<String>(newUsers);
    private User selectedUser = null;


    public MainFrame() {
		//User[] t = (User[]) Verwaltung.gymWueUser.toArray();
        setTitle("Meine erste GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(230, 150, 800, 600); // 400 + 260
        
         
         contentPane = new JPanel();
         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         setContentPane(contentPane);
         contentPane.setBackground(Color.decode("#247BA0"));
         contentPane.setLayout(null);
        
         JLabel vornameLabel = new JLabel("Vorname: ");
         vornameLabel.setBounds(25, 15, 350, 20);
         vornameLabel.setForeground(Color.decode("#FAFAFF"));
         contentPane.add(vornameLabel);
         
        
         vornameField = new JTextField();
         vornameField.setBounds(25, 35, 350, 25);
         contentPane.add(vornameField);
         
         JLabel nachnameLabel = new JLabel("Nachname: ");
         nachnameLabel.setBounds(25, 70, 350, 20);
         nachnameLabel.setForeground(Color.decode("#FAFAFF"));
         contentPane.add(nachnameLabel);
         
        
         nachnameField = new JTextField();
         nachnameField.setBounds(25, 95, 350, 25);
         contentPane.add(nachnameField);
    
         JLabel gebDatLabel = new JLabel("Geburtsdatum: ");
         gebDatLabel.setBounds(25, 125, 350, 20);
         gebDatLabel.setForeground(Color.decode("#FAFAFF"));
         contentPane.add(gebDatLabel);
         
        
         gebDatField = new JTextField();
         gebDatField.setBounds(25, 150, 350, 25);
         contentPane.add(gebDatField);
         
         
         guiUserList = new JList<>(newUsers);
         guiUserList.addListSelectionListener(new ListSelectionListener() {
             @Override
             public void valueChanged(ListSelectionEvent e) {
                 if(!e.getValueIsAdjusting()) {
                     guiUserList.setSelectionBackground(Color.decode("#E4D9FF"));
                     User temp = getUserByUsername(Verwaltung.gymWueUser, guiUserList.getSelectedValue());
                     if(temp!=null) selectedUser = temp;

                     if(selectedUser!=null) {
                         vornameField.setText(selectedUser.getVorname());
                         nachnameField.setText(selectedUser.getNachname());
                         //String gebDat = selectedUser.getGeb().getDateAsString();
                         String gebDat = selectedUser.getGeb().getDateAsString();
                         gebDatField.setText(gebDat);
                     }
                 }

             }
         });
         
         //guiUserList.setCellRenderer(new SelectedListCellRenderer()); 
         JScrollPane guiScroll = new JScrollPane();
         guiScroll.setBounds(400,15, 355, 545);
         guiScroll.setViewportView(guiUserList);
         contentPane.add(guiScroll);
         //guiUserList.setBounds(400,15, 355, 200);
         
         
         //contentPane.add(guiUserList);
         

         JButton submitButton = new JButton("add");
         submitButton.setBackground(Color.decode("#3C4644"));
         submitButton.setForeground(Color.decode("#FFFFFF"));
         submitButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent arg0) {
               Verwaltung.gymWueUser.append(new User(vornameField.getText(), nachnameField.getText(), gebDatField.getText()));
               Verwaltung.gymWueUser.toLast();
               Verwaltung.gymWueUser.getContent().printData();
               
            }
        });
        submitButton.setBounds(260, 190, 115, 25);
        contentPane.add(submitButton);

        JButton editButton = new JButton("edit");
        editButton.setBackground(Color.decode("#3C4644"));
        editButton.setForeground(Color.decode("#FFFFFF"));
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(selectedUser!=null) {
                    Verwaltung.gymWueUser.toFirst();
                    while(Verwaltung.gymWueUser.hasAccess()) {
                        if(Verwaltung.gymWueUser.getContent().getUsername()==selectedUser.getUsername()) {
                            Verwaltung.gymWueUser.remove();
                            Verwaltung.gymWueUser.append(new User(vornameField.getText(), nachnameField.getText(), gebDatField.getText()));
                        }
                        Verwaltung.gymWueUser.next();

                    }

                    guiUserList.setListData(parseListToArray(Verwaltung.gymWueUser));
                    guiUserList.updateUI();
                }
            }
        });
        editButton.setBounds(140, 190, 120, 25);
        contentPane.add(editButton);

        JButton deleteButton = new JButton("delete");
        deleteButton.setBackground(Color.decode("#3C4644"));
        deleteButton.setForeground(Color.decode("#FFFFFF"));
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(selectedUser!=null) {
                    Verwaltung.gymWueUser.toFirst();
                    while(Verwaltung.gymWueUser.hasAccess()) {
                        if(Verwaltung.gymWueUser.getContent().getUsername()==selectedUser.getUsername()) {
                            Verwaltung.gymWueUser.remove();
                        }
                        Verwaltung.gymWueUser.next();

                    }
                    guiUserList.setListData(parseListToArray(Verwaltung.gymWueUser));
                    guiUserList.updateUI();
                }

            }
        });
        deleteButton.setBounds(25, 190, 115, 25);
        contentPane.add(deleteButton);
        
        
        
        JButton firstButton = new JButton("<<");
        firstButton.setBackground(Color.decode("#3C4644"));
        firstButton.setForeground(Color.decode("#FFFFFF"));
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                    Verwaltung.gymWueUser.toFirst();
                    User first = Verwaltung.gymWueUser.getContent();
                    if(first!=null) selectedUser = first;
                    vornameField.setText(selectedUser.getVorname());
                    nachnameField.setText(selectedUser.getNachname());
                    String gebDat = selectedUser.getGeb().getTag() + "." + selectedUser.getGeb().getMonat() + "." + selectedUser.getGeb().getJahr();
                    gebDatField.setText(gebDat);
        }
        });
        firstButton.setBounds(25, 230, 70, 25);
        contentPane.add(firstButton);
        
        
        JButton lastButton = new JButton(">>");
        lastButton.setBackground(Color.decode("#3C4644"));
        lastButton.setForeground(Color.decode("#FFFFFF"));
        lastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                    Verwaltung.gymWueUser.toLast();
                    User last = Verwaltung.gymWueUser.getContent();
                    if(last!=null) selectedUser = last;
                    vornameField.setText(selectedUser.getVorname());
                    nachnameField.setText(selectedUser.getNachname());
                    String gebDat = selectedUser.getGeb().getTag() + "." + selectedUser.getGeb().getMonat() + "." + selectedUser.getGeb().getJahr();
                    gebDatField.setText(gebDat);
        }
        });
        lastButton.setBounds(250, 230, 70, 25);
        contentPane.add(lastButton);
        
        
        JButton nextButton = new JButton(">");
        nextButton.setBackground(Color.decode("#3C4644"));
        nextButton.setForeground(Color.decode("#FFFFFF"));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                   // Verwaltung.gymWueUser.getPrevious();
                    User last = Verwaltung.gymWueUser.getContent();
                    if(last!=null) selectedUser = last;
                    vornameField.setText(selectedUser.getVorname());
                    nachnameField.setText(selectedUser.getNachname());
                    String gebDat = selectedUser.getGeb().getTag() + "." + selectedUser.getGeb().getMonat() + "." + selectedUser.getGeb().getJahr();
                    gebDatField.setText(gebDat);
        }
        });
        
        nextButton.setBounds(175, 230, 70, 25);
        contentPane.add(nextButton);
        
        
        
        JButton previousButton = new JButton("<");
        previousButton.setBackground(Color.decode("#3C4644"));
        previousButton.setForeground(Color.decode("#FFFFFF"));
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                    Verwaltung.gymWueUser.next();
                    User last = Verwaltung.gymWueUser.getContent();
                    if(last!=null) selectedUser = last;
                    vornameField.setText(selectedUser.getVorname());
                    nachnameField.setText(selectedUser.getNachname());
                    String gebDat = selectedUser.getGeb().getTag() + "." + selectedUser.getGeb().getMonat() + "." + selectedUser.getGeb().getJahr();
                    gebDatField.setText(gebDat);
        }
        });
       previousButton.setBounds(100, 230, 70, 25);
       contentPane.add(previousButton);



    }
    
    
    private String[] arrayToStringArray(User[] list) {
        String[] arr = new String[list.length];
        for (int i = 0; i < list.length; i++) {
            arr[i] = list[i].username;
        }

        return arr;
    }

    private String[] parseListToArray(List<User> list) {
        String[] stringList = new String[list.size()];
        System.out.println(list.size());
        list.toFirst();
        for(int i=0; list.hasAccess(); i++) {
            stringList[i] = list.getContent().getUsername();
            list.next();
        }
        return stringList;
    }

    private User getUserByUsername(List<User> list, String username) {
        list.toFirst();
        while (list.hasAccess()) {
            if (list.getContent().getUsername() == username) {
                return list.getContent();
            }
            list.next();
        }

        return null;
    }
}
