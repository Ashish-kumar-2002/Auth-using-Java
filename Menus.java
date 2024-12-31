import  java.awt.*;
import java .awt.event.*;
import javax.swing.*;

public class Menus extends JFrame
{
public  Menus()
{
super("Menus");
setSize(200,200);

JMenuBar menubar=new JMenuBar();

/*  File menu*/

JMenu file=new JMenu("file");
file.setMnemonic(KeyEvent.VK_F);
file.setIcon(new ImageIcon("Header_Linked.png"));

// new menuitem
JMenuItem new_item=new JMenuItem("New",KeyEvent.VK_N);
new_item.setIcon(new ImageIcon("new.png"));

new_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));

new_item.addActionListener(new ActionListener()

				{
				public  void actionPerformed(ActionEvent e)
				{
				System.out.println("Hello");
				}
					}
					);

/*end of new menuitem*/

JMenuItem open =new JMenuItem("open");
open.setIcon(new ImageIcon("about.png"));

JMenuItem save=new JMenuItem("save");
save.setIcon(new ImageIcon("backup.png"));

file.add(new_item);
file.add(open);
file.addSeparator();
file.add(save);

/*end of file menu*/

/*start of file menu*/

JMenu edit=new JMenu("Edit");
edit.setIcon(new ImageIcon("view.png"));

JCheckBoxMenuItem computer=new JCheckBoxMenuItem("computer");
JCheckBoxMenuItem laptop=new JCheckBoxMenuItem("laptop");
JCheckBoxMenuItem fridge=new JCheckBoxMenuItem("fridge");

JRadioButtonMenuItem india=new JRadioButtonMenuItem("india");
JRadioButtonMenuItem america=new JRadioButtonMenuItem("america");
JRadioButtonMenuItem japan=new JRadioButtonMenuItem("japan");

ButtonGroup bg=new ButtonGroup();
bg.add(india);
bg.add(america);
bg.add(japan);

edit.add(computer);
edit.add(laptop);
edit.add(fridge);

edit.addSeparator();

edit.add(india);
edit.add(america);
edit.add(japan);

/*end of edit menu*/

/*start of view menu*/
JMenu view=new JMenu("view");

JMenu xyz=new JMenu("Numbers");
JMenuItem one=new JMenuItem("1");
JMenuItem two=new JMenuItem("2");
JMenuItem three=new JMenuItem("3");
JMenuItem four=new JMenuItem("4");
xyz.add(one);
xyz.add(two);
xyz.add(three);
xyz.add(four);

file.add(xyz);

menubar.add(file);
menubar.add(edit);
menubar.add(view);

setJMenuBar(menubar);

//end of menus

addWindowListener(new WindowAdapter()
				{
				public void windowClosing(WindowEvent e)
				{
				try{
int a=JOptionPane.showConfirmDialog(Menus.this,"Are You Sure to exit?","Exit.program",JOptionPane.YES_NO_OPTION);
if( a== JOptionPane.YES_OPTION)
{
System.exit(0);
}					
					}
					catch(Exception exc){}
				}
				}	
					);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);
}
public static void main(String...a1)
{
new Menus();
}
}


