
package ATM_System;

abstract class pageneeded extends javax.swing.JFrame{
    pageneeded(){}
    abstract void welcomepage();
    abstract void pinpage(int i);
    abstract void keytap(int i);
    abstract void dashboardpage();
    abstract void confirmpin();
    abstract void confirmamount();
    abstract void confirmdamount();
    abstract void confirmcamount();
    abstract void confirmacc();
    abstract void clearpin();
    abstract void clearamount();
    abstract void cleardamount();
    abstract void clearacc();
    abstract void clearcamount();
    abstract void depositpage();
    abstract void transferpage();
    abstract void transferpageb();
    abstract void withdrawpage();
    abstract void balancepage();
}
class cards{
    String name;
    int cardno;
    int pin;
    int balance;
    cards(String n,int c,int p,int b){
        name=n;
        cardno=c;
        pin=p;
        balance=b;
    }
    void setBal(int bal){
        balance=bal;
    }
}
public class ATM extends pageneeded {
    int pin=0;
    boolean loggedin=false;
    String currentpage="welcome";
    int currentuser=-1;
    int amount=0;
    int accno=0;
    cards[] cardlists=new cards[3];
    public ATM() {
        initComponents();
        cardlists[0]=new cards("Sagar",11111111,1111,350000);
        cardlists[1]=new cards("Omar",22222222,2222,550000);
        cardlists[2]=new cards("Sibghat",33333333,3333,150000);
    }
    
     @Override
    void welcomepage() {
        currentpage="welcome";
        pin=0;
        currentuser=-1;
                maintext.setText("Please Insert your card");
                pintext.setText("");
                rectext.setText("");
                cardlist.setVisible(true);
                reciptarea.setVisible(true);
        pintext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
                scrlab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
                scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
                scrlab3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
                scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
        
        pintext.setEditable(false);
        maintext.setEditable(false);
    }

    @Override
    void pinpage(int i) {
        
            carda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            cardb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            cardc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            
            if(i==0){
            carda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            }else if(i==1){
            cardb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            }else if(i==2){
            cardc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            }
            
        pin=0;
                scrlab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
                scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
                scrlab3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
                scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
        loggedin=false;
        currentuser=i;
        currentpage="pin";
        maintext.setText("Welcome "+cardlists[i].name+", Please insert your pin");
        pintext.setText("");
        
        pintext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
                scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/cancelbox.png"))); 
                scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/confirmbox.png"))); 
                
        
    }
   @Override
    void keytap(int i) {
           if(currentpage=="pin") {
               
           if(pin < 1000){
               if(i>-1 && i <10){
              if(pin==0){
                  pin=i;
              }else{
                  pin=(pin*10)+i;
              }
                pintext.setText(""+pin);
            }  
           }
             if(pin<1000 || pin >9999){
                scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
               }else{
                scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/confirmbox.png"))); 
             }
           }
           if((currentpage=="withdraw")||(currentpage=="deposit")||(currentpage=="transferb")) {
               if(i>-1 && i <10){
              if(amount==0){
                  amount=i;
              }else{
                  amount=(amount*10)+i;
              }
                pintext.setText(""+amount);
            }  
           }
           if(currentpage=="transfera") {
               if(i>-1 && i <10){
              if(accno==0){
                  accno=i;
              }else{
                  accno=(accno*10)+i;
              }
                pintext.setText(""+accno);
            }  
           }
    }
    
    @Override
    void confirmpin() {
              if(cardlists[currentuser].pin==pin){
                 loggedin=true;
                 dashboardpage();
              }else{
                  
                  maintext.setText("Wrong pin, try again");
                    pin=0;
                    pintext.setText("");
              }
    }
    @Override
    void confirmamount() {
                  if(amount>20000){
                  maintext.setText("Max 20000 withdrawal allowed");
               }else if(amount%500!=0){
                  maintext.setText("Amount must be divisable by 500");
               }else if(amount>cardlists[currentuser].balance){
                          maintext.setText("Not enough balance");
                   }else{
                       int newbal=cardlists[currentuser].balance-amount;
                       cardlists[currentuser].setBal(newbal);
                       
               currentpage="balance";
        maintext.setText("Hello "+cardlists[currentuser].name+", Your withdrawal was successful.");
        pintext.setText(""+cardlists[currentuser].balance);
    scrlab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
          scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
          scrlab3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
          scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
        pintext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
                scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/cancelbox.png"))); 
        rectext.setText("Hello "+cardlists[currentuser].name+",\n\nAfter this transaction Your new Account\n Balance is:\n"+cardlists[currentuser].balance);
       
        
                   }
               
    }
    
    @Override
    void confirmdamount() {
          if(amount>0){
                       int newbal=cardlists[currentuser].balance+amount;
                       cardlists[currentuser].setBal(newbal);
                       
               currentpage="balance";
        maintext.setText("Hello "+cardlists[currentuser].name+", Your Deposit was successful.");
        pintext.setText(""+cardlists[currentuser].balance);
    scrlab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
          scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
          scrlab3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
          scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
        pintext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
                scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/cancelbox.png"))); 
        rectext.setText("Hello "+cardlists[currentuser].name+",\n\nAfter this transaction Your new Account\n Balance is:\n"+cardlists[currentuser].balance);
          }else{
          
          }
    }
    
    
      @Override
    void confirmcamount() {
          for(int i=0;i<3;i++){
          if(cardlists[i].cardno==accno){
          if(cardlists[i].cardno==cardlists[currentuser].cardno){
           maintext.setText("You Cant Transfer to your own account");
          }else{
   
       if(amount>cardlists[currentuser].balance){
                          maintext.setText("Not enough balance");
                   }else{
        int newbal=cardlists[currentuser].balance-amount;
        cardlists[currentuser].setBal(newbal);
        int newbalb=cardlists[i].balance+amount;
        cardlists[i].setBal(newbalb);
                       
               currentpage="balance";
        maintext.setText("Hello "+cardlists[currentuser].name+", Transfer was successful.");
        pintext.setText(""+cardlists[currentuser].balance);
    scrlab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
          scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
          scrlab3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
          scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
        pintext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
                scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/cancelbox.png"))); 
        rectext.setText("Hello "+cardlists[currentuser].name+",\n\nAfter this transaction Your new Account\n Balance is:\n"+cardlists[currentuser].balance);
       
        
                   }
              }
          }
      }
          
    }

    @Override
    void confirmacc() {
        boolean foundacc=false;
      for(int i=0;i<3;i++){
          if(cardlists[i].cardno==accno){
          foundacc=true;
          if(cardlists[i].cardno==cardlists[currentuser].cardno){
           maintext.setText("You Cant Transfer to your own account");
          }else{
          transferpageb();
          }
          }
      }
      if(!foundacc){
           maintext.setText("Invalid account no");
      }
    }

    
    @Override
    void clearpin() {
        maintext.setText("Welcome "+cardlists[currentuser].name+", Please insert your pin");
        pin=0;
        pintext.setText("");
    }

    void clearamount() {
        amount=0;
        pintext.setText("");
    }
    void cleardamount() {
        amount=0;
        pintext.setText("");
    }

    void clearcamount() {
        amount=0;
        pintext.setText("");
    }
    void clearacc() {
        accno=0;
        pintext.setText("");
    }

    
            
    @Override
    void dashboardpage() {
       if(loggedin){
             rectext.setText("");
           currentpage="dashboard";
                   maintext.setText("Hello "+cardlists[currentuser].name+", Choose options:");
                scrlab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/depositbox.png"))); 
                scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/withdrawhbox.png"))); 
                scrlab3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/transfer.png"))); 
                scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/balancebox.png"))); 
                 pintext.setText("");
                 pintext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
           
       }else{
           welcomepage();
       }
    }


    @Override
    void depositpage() {
        pintext.setText("");
        amount=0;
                scrlab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
                scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
                scrlab3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
                scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
            System.out.println("running");
           rectext.setText("");
           maintext.setText("Enter Deposit Amount");
           pintext.setText("");
           currentpage="deposit";
           pintext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
           scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/cancelbox.png"))); 
           scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/confirmbox.png"))); 
           
    }

    @Override
    void transferpage() {
            pintext.setText("");
            amount=0;
            accno=0;
                scrlab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
                scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
                scrlab3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
                scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
     
           rectext.setText("");
           maintext.setText("Enter Account Number");
           pintext.setText("");
           currentpage="transfera";
           pintext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
           scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/cancelbox.png"))); 
           scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/confirmbox.png"))); 
           
    }

    @Override
    void transferpageb() {
            pintext.setText("");
            amount=0;
            scrlab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
            scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
            scrlab3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
             scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
        
           rectext.setText("");
           maintext.setText("Enter Amount:");
           pintext.setText("");
           currentpage="transferb";
           pintext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
           scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/cancelbox.png"))); 
           scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/confirmbox.png"))); 
           
    }

    @Override
    void withdrawpage() {
         pintext.setText("");
        amount=0;
                scrlab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
                scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
                scrlab3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
                scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
           
           rectext.setText("");
           maintext.setText("Enter Withdrawal Amount");
           pintext.setText("");
           currentpage="withdraw";
           pintext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
           scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/cancelbox.png"))); 
           scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/confirmbox.png"))); 
           
    }

    @Override
    void balancepage() {
        
        currentpage="balance";
        maintext.setText("Hello "+cardlists[currentuser].name+", Your account balance:");
        pintext.setText(""+cardlists[currentuser].balance);
    scrlab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
          scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
          scrlab3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
          scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/whitebg.png"))); 
        pintext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
                scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/cancelbox.png"))); 
        rectext.setText("Hello "+cardlists[currentuser].name+",\n\nYour current Account\n Balance is:\n"+cardlists[currentuser].balance);
       
    }

        public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ATM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ATM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ATM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ATM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
         
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ATM frame =new ATM();
                frame.setVisible(true);
                frame.welcomepage();
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        pintext = new javax.swing.JTextField();
        maintext = new javax.swing.JTextField();
        scrlab1 = new javax.swing.JButton();
        scrlab2 = new javax.swing.JButton();
        scrlab3 = new javax.swing.JButton();
        scrlab4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnnum1 = new javax.swing.JButton();
        btnnum2 = new javax.swing.JButton();
        btnnum3 = new javax.swing.JButton();
        action1 = new javax.swing.JButton();
        btnnum4 = new javax.swing.JButton();
        btnnum5 = new javax.swing.JButton();
        btnnum6 = new javax.swing.JButton();
        action2 = new javax.swing.JButton();
        btnnum7 = new javax.swing.JButton();
        btnnum8 = new javax.swing.JButton();
        btnnum9 = new javax.swing.JButton();
        action3 = new javax.swing.JButton();
        btnnumminus = new javax.swing.JButton();
        btnnum0 = new javax.swing.JButton();
        btnnumplus = new javax.swing.JButton();
        action4 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cardlist = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        carda = new javax.swing.JButton();
        cardb = new javax.swing.JButton();
        cardc = new javax.swing.JButton();
        reciptarea = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rectext = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setMaximumSize(new java.awt.Dimension(1162, 555));
        setMinimumSize(new java.awt.Dimension(1162, 555));
        setPreferredSize(new java.awt.Dimension(1162, 555));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel4.setMaximumSize(new java.awt.Dimension(390, 193));
        jPanel4.setMinimumSize(new java.awt.Dimension(390, 193));

        pintext.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pintext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pintext.setBorder(null);

        maintext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        maintext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        maintext.setBorder(null);
        maintext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maintextActionPerformed(evt);
            }
        });

        scrlab1.setBackground(new java.awt.Color(255, 255, 255));
        scrlab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/depositbox.png"))); // NOI18N
        scrlab1.setText("jButton1");
        scrlab1.setAlignmentY(0.0F);
        scrlab1.setBorder(null);
        scrlab1.setDisplayedMnemonicIndex(0);
        scrlab1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        scrlab1.setIconTextGap(0);
        scrlab1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        scrlab1.setMaximumSize(new java.awt.Dimension(100, 37));
        scrlab1.setMinimumSize(new java.awt.Dimension(100, 37));
        scrlab1.setPreferredSize(new java.awt.Dimension(100, 37));
        scrlab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scrlab1ActionPerformed(evt);
            }
        });

        scrlab2.setBackground(new java.awt.Color(255, 255, 255));
        scrlab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/withdrawhbox.png"))); // NOI18N
        scrlab2.setText("jButton1");
        scrlab2.setAlignmentY(0.0F);
        scrlab2.setBorder(null);
        scrlab2.setDisplayedMnemonicIndex(0);
        scrlab2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        scrlab2.setIconTextGap(0);
        scrlab2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        scrlab2.setMaximumSize(new java.awt.Dimension(100, 37));
        scrlab2.setMinimumSize(new java.awt.Dimension(100, 37));
        scrlab2.setPreferredSize(new java.awt.Dimension(100, 37));
        scrlab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scrlab2ActionPerformed(evt);
            }
        });

        scrlab3.setBackground(new java.awt.Color(255, 255, 255));
        scrlab3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/transfer.png"))); // NOI18N
        scrlab3.setText("jButton1");
        scrlab3.setAlignmentY(0.0F);
        scrlab3.setBorder(null);
        scrlab3.setDisplayedMnemonicIndex(0);
        scrlab3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        scrlab3.setIconTextGap(0);
        scrlab3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        scrlab3.setMaximumSize(new java.awt.Dimension(100, 37));
        scrlab3.setMinimumSize(new java.awt.Dimension(100, 37));
        scrlab3.setPreferredSize(new java.awt.Dimension(100, 37));
        scrlab3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scrlab3ActionPerformed(evt);
            }
        });

        scrlab4.setBackground(new java.awt.Color(255, 255, 255));
        scrlab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/balancebox.png"))); // NOI18N
        scrlab4.setText("jButton1");
        scrlab4.setAlignmentY(0.0F);
        scrlab4.setBorder(null);
        scrlab4.setDisplayedMnemonicIndex(0);
        scrlab4.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        scrlab4.setIconTextGap(0);
        scrlab4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        scrlab4.setMaximumSize(new java.awt.Dimension(100, 37));
        scrlab4.setMinimumSize(new java.awt.Dimension(100, 37));
        scrlab4.setPreferredSize(new java.awt.Dimension(100, 37));
        scrlab4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scrlab4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrlab1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrlab2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pintext, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrlab3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(scrlab4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(maintext))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(maintext, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(scrlab1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrlab2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrlab3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pintext))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrlab4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/small.jpg"))); // NOI18N
        btn3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/small.jpg"))); // NOI18N
        btn4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        btnnum1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/1.jpg"))); // NOI18N
        btnnum1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnnum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnum1ActionPerformed(evt);
            }
        });

        btnnum2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/2.jpg"))); // NOI18N
        btnnum2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnnum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnum2ActionPerformed(evt);
            }
        });

        btnnum3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/3.jpg"))); // NOI18N
        btnnum3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnnum3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnum3ActionPerformed(evt);
            }
        });

        action1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/enter.jpg"))); // NOI18N
        action1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        action1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                action1ActionPerformed(evt);
            }
        });

        btnnum4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/4.jpg"))); // NOI18N
        btnnum4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnnum4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnum4ActionPerformed(evt);
            }
        });

        btnnum5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/5.jpg"))); // NOI18N
        btnnum5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnnum5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnum5ActionPerformed(evt);
            }
        });

        btnnum6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/6.jpg"))); // NOI18N
        btnnum6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnnum6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnum6ActionPerformed(evt);
            }
        });

        action2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/clear.jpg"))); // NOI18N
        action2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        action2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                action2ActionPerformed(evt);
            }
        });

        btnnum7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/7.jpg"))); // NOI18N
        btnnum7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnnum7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnum7ActionPerformed(evt);
            }
        });

        btnnum8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/8.jpg"))); // NOI18N
        btnnum8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnnum8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnum8ActionPerformed(evt);
            }
        });

        btnnum9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/9.jpg"))); // NOI18N
        btnnum9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnnum9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnum9ActionPerformed(evt);
            }
        });

        action3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/cancel.jpg"))); // NOI18N
        action3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        action3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                action3ActionPerformed(evt);
            }
        });

        btnnumminus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/left.jpg"))); // NOI18N
        btnnumminus.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnnumminus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnumminusActionPerformed(evt);
            }
        });

        btnnum0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/0.jpg"))); // NOI18N
        btnnum0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnnum0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnum0ActionPerformed(evt);
            }
        });

        btnnumplus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/right.jpg"))); // NOI18N
        btnnumplus.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnnumplus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnumplusActionPerformed(evt);
            }
        });

        action4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/empty.jpg"))); // NOI18N
        action4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        action4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                action4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnnum1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnnum2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnnum3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(action1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnnumminus, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnnum0, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnnumplus, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(action4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnnum4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnnum5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnnum6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(action2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnnum7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnnum8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnnum9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(action3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnnum1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnum2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnum3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(action1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnum4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnum5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnum6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(action2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnum7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnum8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnum9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(action3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnumminus, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnum0, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnumplus, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(action4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        btn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/small.jpg"))); // NOI18N
        btn7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/small.jpg"))); // NOI18N
        btn8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ATM SYSTEM");
        jLabel2.setMaximumSize(new java.awt.Dimension(80, 41));
        jLabel2.setMinimumSize(new java.awt.Dimension(80, 41));
        jLabel2.setPreferredSize(new java.awt.Dimension(80, 41));

        cardlist.setBackground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cards");

        carda.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        carda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/sagar.png"))); // NOI18N
        carda.setText("Sagar's Card");
        carda.setAlignmentY(0.0F);
        carda.setIconTextGap(0);
        carda.setMargin(new java.awt.Insets(0, 0, 0, 0));
        carda.setMaximumSize(new java.awt.Dimension(200, 127));
        carda.setMinimumSize(new java.awt.Dimension(200, 127));
        carda.setPreferredSize(new java.awt.Dimension(200, 127));
        carda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardaActionPerformed(evt);
            }
        });

        cardb.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cardb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/omar.png"))); // NOI18N
        cardb.setText("Sagar's Card");
        cardb.setAlignmentY(0.0F);
        cardb.setIconTextGap(0);
        cardb.setMargin(new java.awt.Insets(0, 0, 0, 0));
        cardb.setMaximumSize(new java.awt.Dimension(200, 127));
        cardb.setMinimumSize(new java.awt.Dimension(200, 127));
        cardb.setPreferredSize(new java.awt.Dimension(200, 127));
        cardb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardbActionPerformed(evt);
            }
        });

        cardc.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cardc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ATM_System/icons/sibghat.png"))); // NOI18N
        cardc.setText("Sagar's Card");
        cardc.setAlignmentY(0.0F);
        cardc.setIconTextGap(0);
        cardc.setMargin(new java.awt.Insets(0, 0, 0, 0));
        cardc.setMaximumSize(new java.awt.Dimension(200, 127));
        cardc.setMinimumSize(new java.awt.Dimension(200, 127));
        cardc.setPreferredSize(new java.awt.Dimension(200, 127));
        cardc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cardlistLayout = new javax.swing.GroupLayout(cardlist);
        cardlist.setLayout(cardlistLayout);
        cardlistLayout.setHorizontalGroup(
            cardlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardlistLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(carda, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardb, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        cardlistLayout.setVerticalGroup(
            cardlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardlistLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(carda, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(cardb, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardc, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        reciptarea.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reciept");

        rectext.setColumns(20);
        rectext.setRows(5);
        jScrollPane1.setViewportView(rectext);

        javax.swing.GroupLayout reciptareaLayout = new javax.swing.GroupLayout(reciptarea);
        reciptarea.setLayout(reciptareaLayout);
        reciptareaLayout.setHorizontalGroup(
            reciptareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reciptareaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reciptareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        reciptareaLayout.setVerticalGroup(
            reciptareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reciptareaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cardlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reciptarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reciptarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(528, 528, 528))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnum2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnum2ActionPerformed
        keytap(2);
    }//GEN-LAST:event_btnnum2ActionPerformed

    private void btnnum7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnum7ActionPerformed
       keytap(7);
    }//GEN-LAST:event_btnnum7ActionPerformed

    private void btnnumminusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnumminusActionPerformed
         keytap(-1);
    }//GEN-LAST:event_btnnumminusActionPerformed

    private void btnnum0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnum0ActionPerformed
         keytap(0);
    }//GEN-LAST:event_btnnum0ActionPerformed

    private void btnnumplusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnumplusActionPerformed
         keytap(11);
    }//GEN-LAST:event_btnnumplusActionPerformed

    private void action4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_action4ActionPerformed
        System.out.println("changing");                                 
        System.out.println(rectext.getText());
        rectext.setText("bbb");
        // TODO add your handling code here:
    }//GEN-LAST:event_action4ActionPerformed

    private void btnnum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnum1ActionPerformed
         keytap(1);  
    }//GEN-LAST:event_btnnum1ActionPerformed

    private void action1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_action1ActionPerformed
       if(currentpage=="pin") {
           confirmpin();
       }else if(currentpage=="withdraw") {
           confirmamount();
       }else if(currentpage=="deposit") {
           confirmdamount();
       }else if(currentpage=="transfera") {
           confirmacc();
       }else if(currentpage=="transferb") {
           confirmcamount();
       }
    }//GEN-LAST:event_action1ActionPerformed

    private void maintextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maintextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maintextActionPerformed

    private void cardcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardcActionPerformed
        pinpage(2);          // TODO add your handling code here:
    }//GEN-LAST:event_cardcActionPerformed

    private void cardbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardbActionPerformed
        pinpage(1);          // TODO add your handling code here:
    }//GEN-LAST:event_cardbActionPerformed

    private void cardaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardaActionPerformed
        pinpage(0);        // TODO add your handling code here:
    }//GEN-LAST:event_cardaActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
            if(currentpage=="pin") {
            welcomepage();
            } else if(currentpage=="dashboard") {
           withdrawpage();
       }else if(currentpage=="balance") {
           dashboardpage();
       }  else if(currentpage=="withdraw") {
           dashboardpage();
       }   else if(currentpage=="deposit") {
           dashboardpage();
       }   else if(currentpage=="transfera") {
           dashboardpage();
       }    else if(currentpage=="transferb") {
           transferpage();
       }  
    }//GEN-LAST:event_btn4ActionPerformed

    private void scrlab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scrlab1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scrlab1ActionPerformed

    private void scrlab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scrlab2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scrlab2ActionPerformed

    private void scrlab3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scrlab3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scrlab3ActionPerformed

    private void scrlab4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scrlab4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scrlab4ActionPerformed

    private void btnnum3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnum3ActionPerformed
            keytap(3);  
    }//GEN-LAST:event_btnnum3ActionPerformed

    private void btnnum4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnum4ActionPerformed
            keytap(4);  
    }//GEN-LAST:event_btnnum4ActionPerformed

    private void btnnum5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnum5ActionPerformed
          keytap(5);  
    }//GEN-LAST:event_btnnum5ActionPerformed

    private void btnnum6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnum6ActionPerformed
            keytap(6);  
    }//GEN-LAST:event_btnnum6ActionPerformed

    private void btnnum8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnum8ActionPerformed
            keytap(8);  
    }//GEN-LAST:event_btnnum8ActionPerformed

    private void btnnum9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnum9ActionPerformed
             keytap(9);  
    }//GEN-LAST:event_btnnum9ActionPerformed

    private void action3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_action3ActionPerformed
        welcomepage();
    }//GEN-LAST:event_action3ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        if(currentpage=="pin") {
           confirmpin();
       }else if(currentpage=="dashboard") {
           balancepage();
       }else if(currentpage=="withdraw") {
           confirmamount();
       }else if(currentpage=="deposit") {
           confirmdamount();
       }else if(currentpage=="transfera") {
           confirmacc();
       }else if(currentpage=="transferb") {
           confirmcamount();
       }
    }//GEN-LAST:event_btn8ActionPerformed

    private void action2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_action2ActionPerformed
        if(currentpage=="pin") {
            clearpin();
    }else if(currentpage=="withdraw") {
            clearamount();
    }else if(currentpage=="deposit") {
            cleardamount();
    }else if(currentpage=="transfera") {
            clearacc();
    }else if(currentpage=="transferb") {
            clearcamount();
    }          
    }//GEN-LAST:event_action2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        if(currentpage=="dashboard") {
           depositpage();
       }
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
          if(currentpage=="dashboard") {
           transferpage();
       }
    }//GEN-LAST:event_btn7ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton action1;
    private javax.swing.JButton action2;
    private javax.swing.JButton action3;
    private javax.swing.JButton action4;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btnnum0;
    private javax.swing.JButton btnnum1;
    private javax.swing.JButton btnnum2;
    private javax.swing.JButton btnnum3;
    private javax.swing.JButton btnnum4;
    private javax.swing.JButton btnnum5;
    private javax.swing.JButton btnnum6;
    private javax.swing.JButton btnnum7;
    private javax.swing.JButton btnnum8;
    private javax.swing.JButton btnnum9;
    private javax.swing.JButton btnnumminus;
    private javax.swing.JButton btnnumplus;
    private javax.swing.JButton carda;
    private javax.swing.JButton cardb;
    private javax.swing.JButton cardc;
    private javax.swing.JPanel cardlist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField maintext;
    private javax.swing.JTextField pintext;
    private javax.swing.JPanel reciptarea;
    private javax.swing.JTextArea rectext;
    private javax.swing.JButton scrlab1;
    private javax.swing.JButton scrlab2;
    private javax.swing.JButton scrlab3;
    private javax.swing.JButton scrlab4;
    // End of variables declaration//GEN-END:variables


 

   
}
