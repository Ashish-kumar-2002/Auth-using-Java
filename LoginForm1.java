import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
class LoginForm1 extends Frame
{
TextField txt_username,txt_password;
Button btn_login,btn_reset;
Label lbl_username,lbl_password;
PreparedStatement ps;
Connection con;
ResultSet result1;

LoginForm1(String s)
{
setTitle(s);
setSize(350,150);
Toolkit t=Toolkit.getDefaultToolkit();
Dimension d=t.getScreenSize();
double x=d.getWidth();
double y=d.getHeight();
setLocation((int)(x/3),(int)(y/3));
Color c=new Color(224,190,109);
setBackground(c);
//setResizable(false);


txt_username=new TextField();
txt_password=new TextField();

lbl_username=new Label("username:");
lbl_password=new Label("password");

btn_login=new Button("Login");
btn_reset=new Button("Reset");

add(txt_username);
add(txt_password);
add(lbl_username);
add(lbl_password);
add(btn_login);
add(btn_reset);
setLayout(null);

lbl_username.setBounds(20,40,100,20);
lbl_password.setBounds(20,80,100,20);

txt_username.setBounds(140,40,100,20);
txt_password.setBounds(140,80,100,20);

btn_login.setBounds(70,120,70,20);
btn_reset.setBounds(150,120,70,20);


//DataBases

//btn_reset.addActionListener(new other(this));
btn_login.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
				{
					try{
					ps=con.prepareStatement("select * from login where  username=? and password=?");
					ps.setString(1,txt_username.getText());
					ps.setString(2,txt_password.getText());
					result1=ps.executeQuery();

					if(result1.next()){dispose();	new Menus();}
					else{
						try{						JOptionPane.showConfirmDialog(LoginForm1.this," Invalid username or password","Exit.program",JOptionPane.YES_NO_OPTION);  
						    }catch(Exception exc){}
					       }
					}catch(Exception e1){System.out.println(e1);}
				}
			       });



//addwindowListener(new mywindowAdapter());
setVisible(true);

try{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection
("jdbc:mysql://localhost:3306/first","root" ,"Navbharat2005");
}
catch(Exception e)
		{
	e.printStackTrace();
	}
}
}
class Rastogijewellers1
{
public static void main(String...a1)
{
LoginForm1 l1=new LoginForm1("Rastogijwellers");
}
}
