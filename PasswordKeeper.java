import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.*;
import java.util.*;

public class PasswordKeeper implements ActionListener {
	JFrame frame1 = new JFrame("Password Keeper");
	JLabel welcome = new JLabel("Password Keeper");
	JLabel username = new JLabel("Username: ");
	JLabel password = new JLabel("Password: ");
	JTextField usernameInput = new JTextField(30);
	JPasswordField passwordInput = new JPasswordField(30);
	JButton login = new JButton("Login");
	JLabel hint = new JLabel("Don't have an account yet? Click Sign up!!");
	JButton signup = new JButton("Sign up");
	JPanel panel1 = new JPanel();
	JPanel panel = new JPanel();

	JFrame frame2 = new JFrame("Register");
	JLabel register = new JLabel("Register");
	JLabel username_r = new JLabel("Username: ");
	JLabel password_r = new JLabel("Password: ");
	JLabel check = new JLabel("Enter the password again: ");
	JTextField usernameInput_r = new JTextField(10);
	JPasswordField passwordInput_r = new JPasswordField(30);
	JPasswordField check_r = new JPasswordField(30);
	JButton confirm = new JButton("Confirm");
	JPanel panel2 = new JPanel();

	JFrame create = new JFrame();
	JButton plus = new JButton("+");
	JButton logout = new JButton("Logout");
	JPanel panel3 = new JPanel();
	JButton history = new JButton("History");

	JFrame data = new JFrame("Information");
	JPanel panel4 = new JPanel();
	JLabel q1 = new JLabel("Title: ");
	JLabel q2 = new JLabel("Username: ");
	JLabel q3 = new JLabel("Password: ");
	JTextField q1Input = new JTextField(30);
	JTextField q2Input = new JTextField(30);
	JTextField q3Input = new JTextField(30);
	JButton save = new JButton("save");
	
	JFrame frame5 = new JFrame("History");
	JPanel panel5 = new JPanel();
	JButton ok = new JButton("OK");
	JTextArea historyText = new JTextArea();
	JScrollPane sp = new JScrollPane(historyText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	
	
	public static String[][] account = new String[100][3];
	public static String[][] numofUsers = new String[100][3];
	int row = 1;
	String user = "";
	String pass = "";
	String passTemp = "";
	String title = "";
	String saveUser = "";
	String savePass = "";
	int counter = 2;
	String tempCount = "";
	String counterText = "";
	String numOfFile = "";
	String path = "accountInfo.txt";
	String tempPath = "";
	Scanner scanIn = null;
	String inputLine = "";
	boolean loginSuccess = false;
	boolean createSuccess = false;

	public PasswordKeeper() {

		frame1.setSize(500, 300);
		frame1.setLocationRelativeTo(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcome.setFont(new Font("Lato", Font.PLAIN, 50));
		panel1.add(welcome);
		username.setFont(new Font("Lato", Font.PLAIN, 20));
		panel1.add(username);
		panel1.add(usernameInput);
		password.setFont(new Font("Lato", Font.PLAIN, 20));
		panel1.add(password);
		panel1.add(passwordInput);
		login.setPreferredSize(new Dimension(150, 30));
		panel1.add(login);
		login.addActionListener(this);
		hint.setFont(new Font("Lato", Font.PLAIN, 20));
		panel1.add(hint);
		signup.setBorderPainted(false);
		signup.setContentAreaFilled(false);
		signup.setBackground(Color.white);
		signup.setFont(new Font("Lato", Font.PLAIN, 15));
		panel1.add(signup);
		signup.addActionListener(this);
		frame1.add(panel1);
		frame1.setVisible(true);

		frame2.setSize(500, 300);
		frame2.setLocationRelativeTo(null);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
		panel2.add(Box.createRigidArea(new Dimension(0, 5)));
		register.setFont(new Font("Lato", Font.PLAIN, 40));
		panel2.add(register);
		username_r.setFont(new Font("Lato", Font.PLAIN, 20));
		panel2.add(username_r);
		panel2.add(usernameInput_r);
		password_r.setFont(new Font("Lato", Font.PLAIN, 20));
		panel2.add(password_r);
		panel2.add(passwordInput_r);
		check.setFont(new Font("Lato", Font.PLAIN, 20));
		panel2.add(check);
		panel2.add(check_r);
		confirm.setPreferredSize(new Dimension(150, 30));
		panel2.add(confirm);
		confirm.addActionListener(this);
		hint.setFont(new Font("Lato", Font.PLAIN, 20));
		frame2.add(panel2);
		frame2.setVisible(false);

		create.setSize(400, 500);
		create.setLocationRelativeTo(null);
		create.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		plus.setFont(new Font("Lato", Font.PLAIN, 20));
		plus.setPreferredSize(new Dimension(50, 50));
		panel3.add(logout);
		logout.addActionListener(this);
		panel3.add(plus);
		plus.addActionListener(this);
		panel3.add(history);
		history.addActionListener(this);
		create.add(panel3);
		create.setVisible(false);
		
		data.setSize(400, 500);
		data.setLocationRelativeTo(null);
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.PAGE_AXIS));
		panel4.add(Box.createRigidArea(new Dimension(0, 5)));
		q1.setFont(new Font("Lato", Font.PLAIN, 20));
		panel4.add(q1);
		q1Input.setMaximumSize( q1Input.getPreferredSize() );
		panel4.add(q1Input);
		q2.setFont(new Font("Lato", Font.PLAIN, 20));
		panel4.add(q2);
		q2Input.setMaximumSize( q2Input.getPreferredSize() );
		panel4.add(q2Input);
		q3.setFont(new Font("Lato", Font.PLAIN, 20));
		panel4.add(q3);
		q3Input.setMaximumSize( q3Input.getPreferredSize() );
		panel4.add(q3Input);
		save.setPreferredSize(new Dimension(150, 30));
		panel4.add(save);
		save.addActionListener(this);
		data.add(panel4);
		data.setVisible(false);
		
		frame5.setSize(400,500);
		frame5.setLocationRelativeTo(null);
		sp.setPreferredSize(new Dimension(370,420)); 
		historyText.setWrapStyleWord(true);
		historyText.setLineWrap(true);
		panel5.add(sp);
		panel5.add(ok);
		ok.addActionListener(this);
		historyText.setEditable(false);
		frame5.add(panel5);
		frame5.setVisible(false);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == login) {
			loginSuccess = false; 
			readNumOfUser("accountInfortmation.txt");
			/*for (String[] x : numofUsers)
			{
			   for (String y : x)
			   {
			        System.out.print(y + " ");
			   }
			   System.out.println();
			}*/
			for (int i = 0; i < 10; i++) {
				if (numofUsers[i][0] != null) {
					char[] p = passwordInput.getPassword();
					String passText = new String(p);
					if (numofUsers[i][0].equals(usernameInput.getText()) && numofUsers[i][1].equals(passText)) {
						JOptionPane.showMessageDialog(null, "Login successful. Welcome!!!");
						create.setVisible(true);
						loginSuccess = true;
						tempCount = numofUsers[i][2];
						frame1.dispose();
						break;
					}
				}
			}
			if (!loginSuccess) {
				JOptionPane.showMessageDialog(null, "Incorrect username or password or create a new account.");
			}
		}
		if (event.getSource() == signup) {
			frame2.setVisible(true);
			frame1.dispose();
		}
		if (event.getSource() == confirm) {
			user = usernameInput_r.getText();
			char[] temp = passwordInput_r.getPassword();
			String pa1 = new String(temp);
			pass = pa1;
			temp = check_r.getPassword();
			String pa2 = new String(temp);
			passTemp = pa2;
			if (!user.equals("") && !pass.equals("") && !passTemp.equals("") && pass.equals(passTemp)) {
				counterText = String.valueOf(counter);
				writeVerify(user, pass, counterText);
				createFile(counterText);
				counter++;
				JOptionPane.showMessageDialog(null, "Account created. Welcome!!!");
				usernameInput_r.setText("");
				passwordInput_r.setText("");
				check_r.setText("");
				usernameInput.setText("");
				passwordInput.setText("");
				frame2.dispose();
				frame1.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Please check you password again.");
			}
		}
		if (event.getSource() == logout) {
			frame1.setVisible(true);
			create.dispose();
			usernameInput.setText("");
			passwordInput.setText("");
		}
		if (event.getSource() == plus) {
			data.setVisible(true);
		}
		if(event.getSource() == save) {
			title = q1Input.getText();
			saveUser = q2Input.getText();
			savePass = q3Input.getText();
			if (!title.equals("") || !saveUser.equals("") || !savePass.equals("")) {
				write(title, saveUser, savePass, tempCount);
				JOptionPane.showMessageDialog(null, "Your data has been saved.");
				q1Input.setText("");
				q2Input.setText("");
				q3Input.setText("");
				data.dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "Please check you input again.");
			}
		}
		if (event.getSource() == history) {
			int i = 1;
			frame5.setVisible(true);
			tempPath = "account" + tempCount + ".txt";
			read(tempPath);
			for (String[] x : account)
			{
			   for (String y : x)
			   {
			        System.out.print(y + " ");
			   }
			   System.out.println();
			}
			/*for (String[] x : account)
			{
			   for (String y : x)
			   {
				   if (i == 1) {
					   historyText.append("Name: ");
					   i++;
				   }
				   if (i == 2) {
					   historyText.append("Username: ");
					   i++;
				   }
				   if (i == 3) {
					   historyText.append("Password: ");
					   i = 1;
				   }
			       historyText.append(y);
			   }
			   historyText.append("\n");
			}*/
		}
		if (event.getSource() == ok) {
			frame5.setVisible(false);
			historyText.setText("");
		}
	}

	public void createFile(String p) {
		final Formatter x;
		try {
			tempPath = "account" + p + ".txt";
			x = new Formatter(tempPath);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Account not created.");
		}
	}

	public void convert() {
		numOfFile = String.valueOf(counter);
		path = "accountInfo" + numOfFile + ".txt";
		counter++;
	}

	public void read(String filePath) {
		try {
			scanIn = new Scanner(new BufferedReader(new FileReader(filePath)));
			while (scanIn.hasNextLine()) {
				inputLine = scanIn.nextLine();
				String[] InArray = inputLine.split(",");
				for (int i = 0; i < InArray.length; i++) {
					account[row][i] = InArray[i];
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		}
	}

	public void readNumOfUser(String filePath) {
		try {
			scanIn = new Scanner(new BufferedReader(new FileReader(filePath)));
			while (scanIn.hasNextLine()) {
				inputLine = scanIn.nextLine();
				String[] InArray = inputLine.split(",");
				for (int i = 0; i < InArray.length; i++) {
					numofUsers[row][i] = InArray[i];
				}
			}
			row++;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		}
	}

	public void write(String a, String b, String c, String d) {
		try {
			tempPath = "account" + d + ".txt";
			FileWriter fw = new FileWriter(tempPath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			pw.println(a + "," + b + "," + c);
			pw.flush();
			pw.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void writeVerify(String a, String b, String c) {
		try {
			FileWriter fw = new FileWriter("accountInfortmation.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			pw.println(a + "," + b + "," + c);
			pw.flush();
			pw.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
