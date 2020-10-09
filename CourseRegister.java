import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.text.NumberFormat;
import java.applet.Applet;

public class CourseRegister extends JApplet implements ItemListener,ListSelectionListener,ActionListener
{
   NumberFormat dollars = NumberFormat.getCurrencyInstance();
   JCheckBox cAll,cCsis,cBusn,cAcct,cPhys;
   JTextArea t1;
   JTextField tf1,tf2,tf3;
   JList l1,l2;
   TitledBorder tb;
   JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12;
   JLabel lb3,lb5;
   JScrollPane jp;
   JButton b1,b2,b3,b4;
   JPasswordField tp1,tp2;
   Vector vt1,vt2,vt3;
   Image regClose, regOpen;
   ImageIcon image1,image2;
   //Demoframe window;
   double total;
   
   Container con;
   
   CourseList cl = new CourseList();
   final DefaultListModel<String> model = new DefaultListModel<String>();

   public void init()
   {
      con = getContentPane();
      cl.createList();
   /////////////////////////////////////////////////Course Type
      p1 = new JPanel();
      p1.setLayout(new GridLayout(3,2));
      cAll = new JCheckBox("All");
      cCsis = new JCheckBox("CSIS");
      cAcct = new JCheckBox("ACCT");
      cBusn = new JCheckBox("BUSN");
      cPhys = new JCheckBox("PHYS");
      
      p1.add(cAll);
      p1.add(cCsis);
      p1.add(cBusn);
      p1.add(cAcct);
      p1.add(cPhys);
           
      tb = new TitledBorder("Course type");
      p1.setBorder(tb);
      
      cAll.addItemListener(this);
      cCsis.addItemListener(this);
      cBusn.addItemListener(this);
      cAcct.addItemListener(this);
      cPhys.addItemListener(this);
   /////////////////////////////////////////////////Course Available
      p2 = new JPanel();
      p2.setLayout(new BorderLayout());
      vt1 = new Vector();
      l1 = new JList();
      l1.setFixedCellHeight(25);
      l1.setFixedCellWidth(50);
      l1.setVisibleRowCount(10);
      
      l1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      l1.addListSelectionListener(this);
      jp = new JScrollPane(l1);
      
      p2.add(jp,BorderLayout.CENTER);
      tb = new TitledBorder("Courses Available");
      p2.setBorder(tb);
   /////////////////////////////////////////////////Course Description
      p3 = new JPanel();
      p3.setLayout(new BorderLayout());
      t1 = new JTextArea(6,40);
      t1.setBackground(Color.yellow);
      t1.setEditable(false);
      jp = new JScrollPane(t1);
      p3.add(jp,BorderLayout.CENTER);
      tb = new TitledBorder("Course Description");
      p3.setBorder(tb);
      
      p4 = new JPanel();
      p4.setLayout(new GridLayout(1,2,5,5));
      Color color = UIManager.getColor ( "Panel.background" );
      tf1 = new JTextField();
      tf1.setEditable(false);
      tf1.setBackground(color);
      tf2 = new JTextField();
      tf2.setEditable(false);
      tf2.setBackground(color);
      
      tb = new TitledBorder("Course Price");
      tf1.setBorder(tb);
      
      tb = new TitledBorder("Seats Available");
      tf2.setBorder(tb);
      
      p4.add(tf1);
      p4.add(tf2);
       
      p5 = new JPanel();
      p5.setLayout(new GridLayout(2,1,0,0));
      p5.add(p3);
      p5.add(p4);
   ////////////////////////////////////////////////Picture Button
      p6 = new JPanel();
      p6.setLayout(new BorderLayout());
      
      regClose = getImage(getCodeBase(),"regClose.png");
      regOpen = getImage(getCodeBase(),"regOpen.png");
      
      image1 = new ImageIcon(regClose);
      image2 = new ImageIcon(regOpen);
      
      
      b1 = new JButton("Register",image1);
      b1.setRolloverIcon(image2);
      b1.setPressedIcon(image2);
      
      p6.add(b1,BorderLayout.CENTER);
      b1.addActionListener(this);
   ////////////////////////////////////////////////Course Selected
      p7 = new JPanel();
      p7.setLayout(new BorderLayout());
      vt2 = new Vector();
      l2 = new JList(vt2);
      l2.setFixedCellHeight(25);
      l2.setFixedCellWidth(50);
      l2.setVisibleRowCount(10);
      
      l2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      l2.addListSelectionListener(this);
      jp = new JScrollPane(l2);
      
      p7.add(jp,BorderLayout.CENTER);
      tb = new TitledBorder("Courses Selected");
      p7.setBorder(tb);
   ////////////////////////////////////////////////Clear Course Selected
      p8 = new JPanel();
      p8.setLayout(new GridLayout(2,1,0,0));
      b2 = new JButton("Clear");
      b2.addActionListener(this);
      b3 = new JButton("Clear All");
      b3.addActionListener(this);
      
      p8.add(b2);
      p8.add(b3);
      
      tb = new TitledBorder("Clear Course Selected");
      p8.setBorder(tb);
   ////////////////////////////////////////////////For Employee Use Only
      p9 = new JPanel();
      p9.setLayout(new GridLayout(3,1,5,5));
      
      lb3 = new JLabel("Please Enter password, then<enter>");
      tp1 = new JPasswordField(20);
      
      p9.add(lb3);
      p9.add(tp1);
      tb = new TitledBorder("For Employee Use Only");
      p9.setBorder(tb);
      p9.setBackground(Color.red);
      
   ////////////////////////////////////////////////Total & Credit Card
      p10 = new JPanel();
      p10.setLayout(new GridLayout(1,2,5,5));
      lb5 = new JLabel("Enter Credit Card#:",SwingConstants.RIGHT);
      tp2 = new JPasswordField(20);
      p10.add(lb5);
      p10.add(tp2);
      
      p11 = new JPanel();
      p11.setLayout(new GridLayout(3,1,5,5));
      Color lightBlue= new Color(0,255,255);
      tf3 = new JTextField("Total: ");
      tf3.setBackground(lightBlue);
      tf3.setEditable(false);
      tf3.addActionListener(this);
      b4 = new JButton("Submit");
      b4.addActionListener(this);
      p11.add(tf3);
      p11.add(p10);
      p11.add(b4);
   ////////////////////////////////////////////////Demo Frame
      
      
   ////////////////////////////////////////////////
      
      p12 = new JPanel();
      p12.setLayout(new GridLayout(3,3,5,5));
      p12.add(p1);
      p12.add(p2);
      p12.add(p5);
      p12.add(p6);
      p12.add(p7);
      p12.add(p8);
      p12.add(p9);
      p12.add(p11);
      con.add(p12);
   }
   
   public void SearchChar(char c)
   {
      for(int i=0; i < cl.courseList.length; i++)
      {  
         if(cl.courseList[i].getCrsChar() == c)
         {
            vt1.add(cl.courseList[i].getCrsTitle());
         }
      }
      
      l1.setListData(vt1);
   }
   
   public void ButtonPress(int ind)
   {      
      if(cl.courseList[ind].getCrsSeats() == 0)
      {      
         JOptionPane.showMessageDialog(this, "No seats left, please select another","Error Title",JOptionPane.ERROR_MESSAGE);
      }
      else if(vt2.contains(cl.courseList[ind].getCrsTitle() + "===" + cl.courseList[ind].getCrsPrice()) == true)
      {
         JOptionPane.showMessageDialog(this, "This Course is Already selected - Please select Another","Error Title",JOptionPane.ERROR_MESSAGE);
      }
      else
      {
         vt2.addElement(cl.courseList[ind].getCrsTitle() + "===" + cl.courseList[ind].getCrsPrice());
         l2.setListData(vt2);
         cl.courseList[ind].setCrsSeats(cl.courseList[ind].getCrsSeats() - 1);
         tf2.setText(String.valueOf(cl.courseList[ind].getCrsSeats()));
         total += cl.courseList[ind].getCrsPrice();
         tf3.setText("Total: " + String.valueOf(dollars.format(total)));
      }
   }
   
   public void CancelPress(int ind)
   {
      if(l2.getSelectedIndex() != -1)
      {
         vt2.removeElementAt(l2.getSelectedIndex());
         l2.setListData(vt2);
         cl.courseList[ind].setCrsSeats(cl.courseList[ind].getCrsSeats() + 1);
         tf2.setText(String.valueOf(cl.courseList[ind].getCrsSeats()));
         
         total -= cl.courseList[ind].getCrsPrice();
         tf3.setText("Total: " + String.valueOf(dollars.format(total)));
      }
   }
   
   public void ClearAllPress(int ind)
   {
      cl.courseList[ind].setCrsSeats(cl.courseList[ind].getCrsSeats()+1);
   }
//////////////////////////////////////////////////////////////////////////////Separator
   
   public void actionPerformed(ActionEvent e)
   {
      if(e.getSource() instanceof JButton)
      {
         
         if(e.getSource() == b1)
         {
            int index;
      
            if(String.valueOf(l1.getSelectedValue()) == "acct110")
            {
               index = 0;
               
               ButtonPress(index);
            }
            
            if(String.valueOf(l1.getSelectedValue()) == "busn110")
            {
               index = 1;
               
               ButtonPress(index);
            }
      
            if(String.valueOf(l1.getSelectedValue()) == "busn240")
            {
               index = 2;
               ButtonPress(index);            
            }
            
            if(String.valueOf(l1.getSelectedValue()) == "csis110")
            {
               index = 3;
               ButtonPress(index);            
            }
            
            if(String.valueOf(l1.getSelectedValue()) == "csis220")
            {
               index = 4;
               ButtonPress(index);            
            }
            
            if(String.valueOf(l1.getSelectedValue()) == "csis290")
            {
               index = 5;
               ButtonPress(index);
            }
            
            if(String.valueOf(l1.getSelectedValue()) == "csis340")
            {
               index = 6;
               ButtonPress(index);            
            }
            
            if(String.valueOf(l1.getSelectedValue()) == "csis420")
            {
               index = 7;
               ButtonPress(index);            
            }
            
            if(String.valueOf(l1.getSelectedValue()) == "csis491")
            {
               index = 8;
               ButtonPress(index);            
            }
            
            if(String.valueOf(l1.getSelectedValue()) == "phys120")
            {
               index = 9;
              ButtonPress(index);            
            }
            
            if(String.valueOf(l1.getSelectedValue()) == "phys240")
            {
               index = 10;
               ButtonPress(index);
            }
         }
         
         if(e.getSource() == b2)
         {
            int index;
            
            if(l2.getSelectedIndex() != -1)
            {
               if(vt2.contains("acct110===375.49") == true)
               {
                  index = 0;
                  
                  CancelPress(index);
               }
               
               if(vt2.contains("busn110===375.49") == true)
               {
                  index = 1;
                  
                  CancelPress(index);
               }
         
               if(vt2.contains("busn240===375.49") == true)
               {
                  index = 2;
                  CancelPress(index);          
               }
               
               if(vt2.contains("csis110===375.49") == true)
               {
                  index = 3;
                  CancelPress(index);            
               }
               
               if(vt2.contains("csis220===375.49") == true)
               {
                  index = 4;
                  CancelPress(index);            
               }
               
               if(vt2.contains("csis290===375.49") == true)
               {
                  index = 5;
                  CancelPress(index);
               }
               
               if(vt2.contains("csis340===375.49") == true)
               {
                  index = 6;
                  CancelPress(index);            
               }
               
               if(vt2.contains("csis420===375.49") == true)
               {
                  index = 7;
                  CancelPress(index);            
               }
               
               if(vt2.contains("csis491===375.49") == true)
               {
                  index = 8;
                  CancelPress(index);            
               }
               
               if(vt2.contains("phys120===499.19") == true)
               {
                  index = 9;
                  CancelPress(index);            
               }
               
               if(vt2.contains("phys240===399.99") == true)
               {
                  index = 10;
                  CancelPress(index);
               }
            }
            else
            {
               JOptionPane.showMessageDialog(this, "Please Select a course to Clear","Error Title",JOptionPane.ERROR_MESSAGE);
            }
         }
         
         if(e.getSource() == b3)
         {
               int index;
               int res = 0;
               
               res = JOptionPane.showConfirmDialog(this, "Are You SURE?","WARNING",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
               
               if(vt2.contains("acct110===375.49") == true)
               {
                  index = 0;
                  
                  ClearAllPress(index);
               }
               
               if(vt2.contains("busn110===375.49") == true)
               {
                  index = 1;
                  
                  ClearAllPress(index);
               }
         
               if(vt2.contains("busn240===375.49") == true)
               {
                  index = 2;
                  ClearAllPress(index);         
               }
               
               if(vt2.contains("csis110===375.49") == true)
               {
                  index = 3;
                  ClearAllPress(index);            
               }
               
               if(vt2.contains("csis220===375.49") == true)
               {
                  index = 4;
                  ClearAllPress(index);            
               }
               
               if(vt2.contains("csis290===375.49") == true)
               {
                  index = 5;
                  ClearAllPress(index);
               }
               
               if(vt2.contains("csis340===375.49") == true)
               {
                  index = 6;
                  ClearAllPress(index);            
               }
               
               if(vt2.contains("csis420===375.49") == true)
               {
                  index = 7;
                  ClearAllPress(index);            
               }
               
               if(vt2.contains("csis491===375.49") == true)
               {
                  index = 8;
                  ClearAllPress(index);           
               }
               
               if(vt2.contains("phys120===499.19") == true)
               {
                  index = 9;
                  ClearAllPress(index);           
               }
               
               if(vt2.contains("phys240===399.99") == true)
               {
                  index = 10;
                  ClearAllPress(index);
               }
               
               if(res == JOptionPane.YES_OPTION)
               {
                  vt2.clear();
                  l2.setListData(vt2);
                  tf3.setText("Total: " + dollars.format(0));
                  total = 0;
               }
               else
               {
               }
         }
         
         if(e.getSource() == b4)
         {
            int res1 = 0;
            int res2 = 0;
            
            if(tp2.getText().equals(""))
            {
               JOptionPane.showMessageDialog(this, "Please Enter a VALID Credit Card","Not Allowed",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
               res1 = JOptionPane.showConfirmDialog(this, "Are You SURE?","WARNING",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
               
               if(res1 == JOptionPane.YES_OPTION)
               {
                  JOptionPane.showMessageDialog(this, tf3.getText() + " has been charged to your card, Thank you","Confirmation",JOptionPane.INFORMATION_MESSAGE);
                  
                  vt2.clear();
                  l2.setListData(vt2);
                  tf3.setText("Total:");
                  total = 0.0;
               }
               else
               {
               }
            }
         }
      }
   }
   
   
   public void itemStateChanged(ItemEvent e)
   {
      if(e.getSource() instanceof JCheckBox)
      {      
         if(e.getSource() == cAll)
         {  
            if(cAll.isSelected())
            {
               cCsis.setSelected(false);
               cBusn.setSelected(false);
               cAcct.setSelected(false);
               cPhys.setSelected(false);
               vt1.clear();
            
               for(int i=0; i < cl.courseList.length; i++)
               {
                  vt1.addElement(cl.courseList[i].getCrsTitle());
               }
               
               l1.setListData(vt1);
            }
            else
            {
               vt1.removeAllElements();
               l1.setListData(vt1);
            }
         }
         else
         {  
            vt1.removeAllElements();
            
            if(cAcct.isSelected())
            {
               cAll.setSelected(false);
               SearchChar('a');
            }

            if(cBusn.isSelected())
            {
               cAll.setSelected(false);
               SearchChar('b');
            }
            
            if(cCsis.isSelected())
            {             
               cAll.setSelected(false);
               SearchChar('c');
            }

            if(cPhys.isSelected())
            {
               cAll.setSelected(false);
               SearchChar('p');
            }
         }
      }
   }
   
   public void valueChanged(ListSelectionEvent e)
   {
      int index;
      
      if(String.valueOf(l1.getSelectedValue()) == "acct110")
      {
         index = 0;
         t1.setText(cl.courseList[index].getCrsDesc());
         tf1.setText(String.valueOf(cl.courseList[index].getCrsPrice()));
         tf2.setText(String.valueOf(cl.courseList[index].getCrsSeats()));
         
         if(cl.courseList[index].getCrsSeats() == 0)
         {
            l1.setSelectionBackground(Color.red);
            l1.setSelectionForeground(Color.yellow);
         }
         else
         {
            Color colors = UIManager.getColor ( "List.selectionBackground" );
            l1.setSelectionBackground(colors);
            l1.setSelectionForeground(Color.black);
         }      
      }
      
      if(String.valueOf(l1.getSelectedValue()) == "busn110")
      {
         index = 1;
         t1.setText(cl.courseList[index].getCrsDesc());
         tf1.setText(String.valueOf(cl.courseList[index].getCrsPrice()));
         tf2.setText(String.valueOf(cl.courseList[index].getCrsSeats()));
         
         if(cl.courseList[index].getCrsSeats() == 0)
         {
            l1.setSelectionBackground(Color.red);
            l1.setSelectionForeground(Color.yellow);
         }
         else
         {
            Color colors = UIManager.getColor ( "List.selectionBackground" );
            l1.setSelectionBackground(colors);
            l1.setSelectionForeground(Color.black);
         }      
      }

      if(String.valueOf(l1.getSelectedValue()) == "busn240")
      {
         index = 2;
         t1.setText(cl.courseList[index].getCrsDesc());
         tf1.setText(String.valueOf(cl.courseList[index].getCrsPrice()));
         tf2.setText(String.valueOf(cl.courseList[index].getCrsSeats()));
         
         if(cl.courseList[index].getCrsSeats() == 0)
         {
            l1.setSelectionBackground(Color.red);
            l1.setSelectionForeground(Color.yellow);
         }
         else
         {
            Color colors = UIManager.getColor ( "List.selectionBackground" );
            l1.setSelectionBackground(colors);
            l1.setSelectionForeground(Color.black);
         }
      }

      
      if(String.valueOf(l1.getSelectedValue()) == "csis110")
      {
         index = 3;
         t1.setText(cl.courseList[index].getCrsDesc());
         tf1.setText(String.valueOf(cl.courseList[index].getCrsPrice()));
         tf2.setText(String.valueOf(cl.courseList[index].getCrsSeats()));
         
         if(cl.courseList[index].getCrsSeats() == 0)
         {
            l1.setSelectionBackground(Color.red);
            l1.setSelectionForeground(Color.yellow);
         }
         else
         {
            Color colors = UIManager.getColor ( "List.selectionBackground" );
            l1.setSelectionBackground(colors);
            l1.setSelectionForeground(Color.black);
         }
      }
      
      if(String.valueOf(l1.getSelectedValue()) == "csis220")
      {
         index = 4;
         t1.setText(cl.courseList[index].getCrsDesc());
         tf1.setText(String.valueOf(cl.courseList[index].getCrsPrice()));
         tf2.setText(String.valueOf(cl.courseList[index].getCrsSeats()));
         
         if(cl.courseList[index].getCrsSeats() == 0)
         {
            l1.setSelectionBackground(Color.red);
            l1.setSelectionForeground(Color.yellow);
         }
         else
         {
            Color colors = UIManager.getColor ( "List.selectionBackground" );
            l1.setSelectionBackground(colors);
            l1.setSelectionForeground(Color.black);
         }
      }
      
      if(String.valueOf(l1.getSelectedValue()) == "csis290")
      {
         index = 5;
         t1.setText(cl.courseList[index].getCrsDesc());
         tf1.setText(String.valueOf(cl.courseList[index].getCrsPrice()));
         tf2.setText(String.valueOf(cl.courseList[index].getCrsSeats()));
         
         if(cl.courseList[index].getCrsSeats() == 0)
         {
            l1.setSelectionBackground(Color.red);
            l1.setSelectionForeground(Color.yellow);
         }
         else
         {
            Color colors = UIManager.getColor ( "List.selectionBackground" );
            l1.setSelectionBackground(colors);
            l1.setSelectionForeground(Color.black);
         }
      }
      
      if(String.valueOf(l1.getSelectedValue()) == "csis340")
      {
         index = 6;
         t1.setText(cl.courseList[index].getCrsDesc());
         tf1.setText(String.valueOf(cl.courseList[index].getCrsPrice()));
         tf2.setText(String.valueOf(cl.courseList[index].getCrsSeats()));
         
         if(cl.courseList[index].getCrsSeats() == 0)
         {
            l1.setSelectionBackground(Color.red);
            l1.setSelectionForeground(Color.yellow);
         }
         else
         {
            Color colors = UIManager.getColor ( "List.selectionBackground" );
            l1.setSelectionBackground(colors);
            l1.setSelectionForeground(Color.black);
         }
      }
      
      if(String.valueOf(l1.getSelectedValue()) == "csis420")
      {
         index = 7;
         t1.setText(cl.courseList[index].getCrsDesc());
         tf1.setText(String.valueOf(cl.courseList[index].getCrsPrice()));
         tf2.setText(String.valueOf(cl.courseList[index].getCrsSeats()));
         
         if(cl.courseList[index].getCrsSeats() == 0)
         {
            l1.setSelectionBackground(Color.red);
            l1.setSelectionForeground(Color.yellow);
         }
         else
         {
            Color colors = UIManager.getColor ( "List.selectionBackground" );
            l1.setSelectionBackground(colors);
            l1.setSelectionForeground(Color.black);
         }
      }
      
      if(String.valueOf(l1.getSelectedValue()) == "csis491")
      {
         index = 8;
         t1.setText(cl.courseList[index].getCrsDesc());
         tf1.setText(String.valueOf(cl.courseList[index].getCrsPrice()));
         tf2.setText(String.valueOf(cl.courseList[index].getCrsSeats()));
         
         if(cl.courseList[index].getCrsSeats() == 0)
         {
            l1.setSelectionBackground(Color.red);
            l1.setSelectionForeground(Color.yellow);
         }
         else
         {
            Color colors = UIManager.getColor ( "List.selectionBackground" );
            l1.setSelectionBackground(colors);
            l1.setSelectionForeground(Color.black);
         }
      }
      
      if(String.valueOf(l1.getSelectedValue()) == "phys120")
      {
         index = 9;
         t1.setText(cl.courseList[index].getCrsDesc());
         tf1.setText(String.valueOf(cl.courseList[index].getCrsPrice()));
         tf2.setText(String.valueOf(cl.courseList[index].getCrsSeats()));
         
         if(cl.courseList[index].getCrsSeats() == 0)
         {
            l1.setSelectionBackground(Color.red);
            l1.setSelectionForeground(Color.yellow);
         }
         else
         {
            Color colors = UIManager.getColor ( "List.selectionBackground" );
            l1.setSelectionBackground(colors);
            l1.setSelectionForeground(Color.black);
         }
      }
      
      if(String.valueOf(l1.getSelectedValue()) == "phys240")
      {
         index = 10;
         t1.setText(cl.courseList[index].getCrsDesc());
         tf1.setText(String.valueOf(cl.courseList[index].getCrsPrice()));
         tf2.setText(String.valueOf(cl.courseList[index].getCrsSeats()));
         
         if(cl.courseList[index].getCrsSeats() == 0)
         {
            l1.setSelectionBackground(Color.red);
            l1.setSelectionForeground(Color.yellow);
         }
         else
         {
            Color colors = UIManager.getColor ( "List.selectionBackground" );
            l1.setSelectionBackground(colors);
            l1.setSelectionForeground(Color.black);
         }
      }
   }
}