package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.Font;
import java.io.*;
import java.util.Scanner;

public class LoginScreen {
    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.setTitle("BitWallet");
        screen.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 18));
    }
}

class Screen extends JFrame {
    JLabel userLabel = new JLabel("Username");
    JLabel passLabel = new JLabel("Password");
    JLabel image = new JLabel();

    JTextField user = new JTextField(20);
    JPasswordField pass = new JPasswordField(20);
    JButton loginbtn = new JButton("Login");

    public Screen(){

        userLabel.setBounds(150,50,200,15);
        user.setBounds(150,70,200,30);
        passLabel.setBounds(150,120,200,15);
        pass.setBounds(150,140,200,30);
        loginbtn.setBounds(150,200,200,30);

        //image.setBounds(150, 250, 200,200);
        //image.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("C:\\Users\\Kyle\\OneDrive\\Desktop\\OOPM\\Project\\BitWallet\\Logo.png"))));
        userLabel.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 18));
        passLabel.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 18));
        loginbtn.setForeground(Color.WHITE);
        loginbtn.setBackground(Color.BLACK);
        loginbtn.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 18));

        add(userLabel);
        add(user);
        add(passLabel);
        add(pass);
        add(loginbtn);
        loginbtn.addActionListener(e->{
            Writer writer = null;
            //File check = new File("passwords.txt");
            try {
                int counter = 0;
                String filePath = "./passwords.txt";
                File file = new File(filePath);
                Scanner scan = new Scanner(file);
                String line = null;
                FileWriter filewrite = new FileWriter(file, true);

                String usertxt = " ";
                String passtxt = " ";
                String puname = user.getText();
                String ppaswd = pass.getText();

                String nextLineIterator = "";
                String splitter = ",";
                String WalletBTCouter = "0.0"; //new variable as it was clashing with the one in buying screen (temporary fix)

                while (scan.hasNext()) {
                    usertxt = scan.nextLine();
                    passtxt = scan.nextLine();
                    if(puname.equals(usertxt) && ppaswd.equals(passtxt)) {
                        dispose();

                        BufferedReader br = new BufferedReader(new FileReader("./data.txt"));
                        while ((nextLineIterator = br.readLine()) != null)   //returns a Boolean value
                        {
                            String[] Users = nextLineIterator.split(splitter);    // use comma as separator
                            if(Users[0].equals(puname))
                            {
                                WalletBTCouter=Users[2];
                            }
                        }

                        JFrame wallet = new JFrame();
                        wallet.setTitle("Account Number: "+puname);
                        wallet.getContentPane().setBackground(Color.BLACK);
                        JLabel showAcc = new JLabel("");
                        JLabel rate = new JLabel("");
                        JLabel btc = new JLabel("");
                        JLabel usd = new JLabel("");
                        JButton buy = new JButton("Buy");
                        JButton sell = new JButton("Sell");
                        JButton logout = new JButton("Logout");
                        JLabel welcome = new JLabel("");

                        float currentRate = (float) Math.random() * 10;
                        rate.setText("Current Rate : " + currentRate + " USD");
                        String currentBal = WalletBTCouter;
                        btc.setText(currentBal + " BTC");
                        float currentBalInFloat=Float.parseFloat(currentBal);
                        usd.setText((currentBalInFloat * currentRate) + " USD");
                        showAcc.setText("Account Number: "+puname);

                        welcome.setText("Welcome to BitWallet");
                        wallet.setBounds(0, 0, 400, 400);
                        rate.setBounds(70, 65, 300, 40);
                        welcome.setBounds(79, -75, 400, 200);
                        showAcc.setBounds(95, -50, 400, 200);
                        btc.setBounds(75, 150, 150, 30);
                        usd.setBounds(210, 150, 150, 30);
                        buy.setBounds(95, 200, 100, 30);
                        sell.setBounds(205, 200, 100, 30);
                        logout.setBounds(145,250,110,30);

                        wallet.setFont(new Font("Montserrat", Font.PLAIN, 14));
                        welcome.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
                        welcome.setForeground(Color.GREEN);
                        showAcc.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 17));
                        showAcc.setForeground(Color.GREEN);
                        rate.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 18));
                        btc.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
                        usd.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
                        buy.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 18));
                        sell.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 18));
                        logout.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 18));
                        rate.setForeground(Color.GREEN);
                        btc.setForeground(Color.GREEN);
                        usd.setForeground(Color.GREEN);
                        buy.setForeground(Color.GREEN);
                        buy.setBackground(Color.BLACK);
                        buy.setBorder(new LineBorder(Color.GREEN));
                        sell.setBorder(new LineBorder(Color.GREEN));
                        logout.setBorder(new LineBorder(Color.GREEN));
                        sell.setForeground(Color.GREEN);
                        sell.setBackground(Color.BLACK);
                        logout.setForeground(Color.GREEN);
                        logout.setBackground(Color.BLACK);

                        logout.addActionListener(e1 -> {
                            wallet.dispose();
                            Screen screen = new Screen();
                        });
                        buy.addActionListener(b -> {
                            wallet.dispose();
                            JFrame buying = new JFrame();
                            setDefaultCloseOperation(EXIT_ON_CLOSE);
                            JLabel showAccb = new JLabel("");
                            JLabel rateb = new JLabel("");
                            JLabel btcb = new JLabel("");
                            JLabel usdb = new JLabel("");
                            JLabel Enter = new JLabel("");
                            JTextField ToBuy = new JTextField();
                            JButton submit = new JButton();

                            showAccb.setText("Account Number: "+puname);
                            buying.setTitle("Buy BTC");
                            rateb.setText("Current Rate: "+String.valueOf(currentRate));
                            Enter.setText("Enter amount of BTC to purchase: ");
                            submit.setText("Buy");

                            buying.getContentPane().setBackground(Color.BLACK);

                            buying.setBounds(0, 0, 500, 500);
                            showAccb.setBounds(95, -50, 400, 200);
                            rateb.setBounds(20,0,400,200);
                            Enter.setBounds(20,60,300,200);
                            submit.setBounds(40,300,80,30);

                            showAccb.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 17));
                            showAccb.setForeground(Color.GREEN);
                            rateb.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 17));
                            rateb.setForeground(Color.GREEN);
                            btcb.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 17));
                            btcb.setForeground(Color.GREEN);
                            usdb.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 17));
                            usdb.setForeground(Color.GREEN);
                            Enter.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 17));
                            Enter.setForeground(Color.GREEN);
                            ToBuy.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 17));
                            ToBuy.setForeground(Color.GREEN);
                            ToBuy.setBorder(new LineBorder(Color.GREEN));
                            submit.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 17));
                            submit.setForeground(Color.GREEN);
                            submit.setBackground(Color.BLACK);
                            submit.setBorder(new LineBorder(Color.GREEN));

                              String nextline = "";
                              String splitBy = ",";
                              String WalletBTC;
                              String Bal;

                            try
                            {
                                //BufferedReader br = new BufferedReader(new FileReader("./data.txt"));
                                while ((nextline = br.readLine()) != null)   //returns a Boolean value
                                {
                                    String[] Users = nextline.split(splitBy);    // use comma as separator
                                    //System.out.println("Acc No." + Users[0] + ", USD" + Users[1] + ", BTC" + Users[2]);
                                    if(Users[0].equals(puname))
                                    {
                                        WalletBTC=Users[2];
                                        btcb.setBounds(20,20,400,200);
                                        btcb.setText("Your current BTC wallet holds: "+String.valueOf(WalletBTC)+" BTC");
                                        buying.add(btcb);

                                        Bal = Users[1];
                                        usdb.setBounds(20,40,400,200);
                                        usdb.setText("Your current Balance is: $ "+String.valueOf(Bal));
                                        buying.add(usdb);

                                        ToBuy.setBounds(20,180,150,40);
                                        buying.add(ToBuy);


                                        submit.addActionListener(e1 -> {
                                            String Amt = ToBuy.getText();
                                            String Transact;
                                            Transact = String.valueOf(Float.parseFloat(Amt) * Float.parseFloat(String.valueOf(currentRate)));
                                            JOptionPane.showMessageDialog(null,"Are you sure you want to buy "+Amt+" BTC for $"+Transact);
                                        });
                                    }
                                }
                            }

                            catch (IOException e11)
                            {
                                e11.printStackTrace();
                            }

                            buying.setLayout(null);
                            buying.setVisible(true);
                            buying.add(showAccb);
                            buying.add(Enter);
                            buying.add(rateb);
                            buying.add(submit);

                        });

                        counter = 1;
                        wallet.add(rate);
                        wallet.add(welcome);
                        wallet.add(showAcc);
                        wallet.add(btc);
                        wallet.add(usd);
                        wallet.add(buy);
                        wallet.add(sell);
                        wallet.add(logout);

                        wallet.setLayout(null);
                        wallet.setVisible(true);
                    }
                }
                if(puname.equals("") && ppaswd.equals("")){
                    JOptionPane.showMessageDialog(null,"Please insert Username and Password");
                }
                else if(counter == 0){

                    JOptionPane.showMessageDialog(null,"Wrong Username / Password");
                    user.setText("");
                    pass.setText("");
                    user.requestFocus();
                }
            } catch (IOException d) {
                d.printStackTrace();
            }
        });
        setLayout(null);
        setSize(500,350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

