import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener, KeyListener
{
  private JLabel promptN = new JLabel("Indtast navn: ");
  private JTextField navn = new JTextField(6);
  private JLabel promptA = new JLabel("Indtast alder: ");
  private JTextField alder = new JTextField(2);
  private JButton tilfoej = new JButton("Tilføj");
  
  private List list = new List(10,true);
  PersonListe pL = new PersonListe();
  
  public GUI()
  {
      setTitle("Counterintuitive GUI");
      getContentPane().setLayout(new FlowLayout());
      getContentPane().add(promptN);
      getContentPane().add(navn);
      getContentPane().add(promptA);
      getContentPane().add(alder);
      getContentPane().add(tilfoej);
      
      getContentPane().add(list);
      
      
      list.setFont(new Font("Courier", Font.PLAIN, 11));
      list.setBackground(Color.yellow);
      ArrayList<Person> aL = pL.hentPersoner();
      for (Person p : aL)
            list.add(p.getName()+" "+p.getAge());
      tilfoej.addActionListener(this);
      alder.addKeyListener(this);
      
  }

  
  
  public void actionPerformed(ActionEvent e)
  {
      
            list.add(navn.getText() + " " + alder.getText());
            
            Person p = new Person(navn.getText(),Integer.parseInt(alder.getText()));
            pL.tilfoejPerson(p);
            
            navn.setText("");
            alder.setText("");
            navn.requestFocus();
           
        
  } 
  
  public void keyTyped(KeyEvent event){}

  public void keyPressed(KeyEvent event){}

  public void keyReleased(KeyEvent event)
  {  
      if (event.getKeyCode() == 10) // Enter
      {
          this.actionPerformed(new ActionEvent(tilfoej,0,"Tilføj"));
      }
      if (event.getKeyCode() == 34)
          this.setTitle("Page down");  
      if (event.getKeyCode() == 35)
          this.setTitle("End");  
  }
  public static void main(String args[])
  {
      GUI f = new GUI();
      f.setSize(400,300);
      f.setVisible(true);
      f.addWindowListener(new WindowAdapter(){
          public void windowClosing(WindowEvent e){
            System.exit(0);
          }
      });
  }
}