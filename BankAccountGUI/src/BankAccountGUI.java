import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Container;
import java.awt.Color;

/**stuff to do:
Withdraw (both) amount length not working??????????
Deposit (savings works Chequings doesn't????????????????
**/

public class BankAccountGUI extends JFrame {
	BankAccount chequing = new BankAccount("Chequing", 0.00, 0.00, 0.00);
	BankAccount savings = new BankAccount("Chequing", 0.00, 0.00, 0.00);
	
	//Panels----------------------------------------------------------------------
	private Panels currentPanel = Panels.ACCOUNTS;
	
	private JPanel panelmain;
	private JPanel panelAccounts;
	private JPanel panelAccountInfoS;
	private JPanel panelAccountInfoC;
	private JPanel panelActionsC; 
	private JPanel panelActionsS;
	private JPanel panelCheckBalanceC;
	private JPanel panelCheckBalanceS;
	private JPanel panelDepositC;
	private JPanel panelDepositS;
	private JPanel panelWithdrawC;
	private JPanel panelWithdrawS;

	//Labels----------------------------------------------------------------------
	private JLabel lblChoice;
	private JLabel lblActionsC;
	private JLabel lblActionsS;
	private JLabel lblCurrentBalanceC;
	private JLabel lblCurrentBalanceS;
	private JLabel lblNewBalanceC;
	private JLabel lblHowMuchC;
	private JLabel lblNewBalanceS;
	private JLabel lblHowMuchS;
	private JLabel lblwithdrawNewBalanceC;
	private JLabel lblWithdrawTitleC;
	private JLabel lblwithdrawNewBalanceS;
	private JLabel lblWithdrawtitleS;
	private JLabel lblInterestRateS;
	private JLabel lblStartBalanceS;
	private JLabel lblWithdrawalFeeS;
	private JLabel lblInterestRateC;
	private JLabel lblStartBalanceC;
	private JLabel lblWithdrawalFeeC;
	
	//Buttons----------------------------------------------------------------------
	private JButton btnChequing;
	private JButton btnSavings;
	private JButton btnDepositC;
	private JButton btnWithdrawC;
	private JButton btnCheckBalanceC;
	private JButton btnDepositS;
	private JButton btnWithdrawS;
	private JButton btnCheckBalanceS;
	private JButton btnBackC;
	private JButton btnFinalDepositC;
	private JButton btnFinalDepositS;
	private JButton btnContinueS;
	private JButton btnContinueC;
	private JButton btnBackInfoS;
	private JButton btnWithdrawbuttonC;
	private JButton btnBackInfoC;
	private JButton btnWithdrawbuttonS;
	private JButton btnBackS;
	private JButton btnBackCD;
	private JButton btnBackSD;
	private JButton btnBackCC;
	private JButton btnBackSC;
	private JButton btnBackCW;
	private JButton btnBackSW;
	
	//Text fields----------------------------------------------------------------------
	private JTextField txtWithdrawNewBalanceS;
	private JTextField txtCurrentBalanceC;
	private JTextField txtCurrentBalanceS;
	private JTextField txtAmountC;
	private JTextField txtNewBalanceC;
	private JTextField txtAmountS;
	private JTextField txtNewBalanceS;
	private JTextField txtAmountWithdrawC;
	private JTextField txtWithdrawFeeS;
	private JTextField txtWithdrawNewBalanceC;
	private JTextField txtAmountWithdrawS;
	private JTextField txtBalanceS;
	private JTextField txtInterestRateS;
	private JTextField txtWithdrawFeeC;
	private JTextField txtBalanceC;
	private JTextField txtInterestRateC;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankAccountGUI frame = new BankAccountGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BankAccountGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		panelmain = new JPanel();
		panelmain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelmain);
		panelmain.setLayout(null);
		panelmain.setVisible(true);
		panelmain.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblChoice, btnChequing, panelActionsC, lblActionsC, btnDepositC, btnWithdrawC, btnCheckBalanceC, btnSavings, panelActionsS, lblActionsS, btnDepositS, btnWithdrawS, btnCheckBalanceS}));
		
		panelCheckBalanceC = new JPanel();
		panelCheckBalanceC.setBounds(0, 0, 284, 162);
		panelmain.add(panelCheckBalanceC);
		panelCheckBalanceC.setLayout(null);
		panelCheckBalanceC.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		lblCurrentBalanceC = new JLabel("your current balance is:");
		lblCurrentBalanceC.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentBalanceC.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCurrentBalanceC.setBounds(10, 11, 264, 39);
		panelCheckBalanceC.add(lblCurrentBalanceC);
		
		txtCurrentBalanceC = new JTextField();
		txtCurrentBalanceC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCurrentBalanceC.setEditable(false);
		txtCurrentBalanceC.setColumns(10);
		txtCurrentBalanceC.setBounds(22, 61, 252, 48);
		panelCheckBalanceC.add(txtCurrentBalanceC);
		txtCurrentBalanceC.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				setActive();				
			}
			public void insertUpdate(DocumentEvent e) {
				setActive();
			}
			public void removeUpdate(DocumentEvent e) {
				setActive();				
			}
		});
		
		btnBackCC = new JButton("back");
		btnBackCC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBackCC_mouseClicked(e);
			}
		});
		btnBackCC.setBounds(0, 139, 89, 23);
		panelCheckBalanceC.add(btnBackCC);
		panelCheckBalanceC.setVisible(false);
		
		panelCheckBalanceS = new JPanel();
		panelCheckBalanceS.setBounds(0, 0, 284, 162);
		panelmain.add(panelCheckBalanceS);
		panelCheckBalanceS.setLayout(null);
		panelCheckBalanceS.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		lblCurrentBalanceS = new JLabel("your current balance is:");
		lblCurrentBalanceS.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentBalanceS.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCurrentBalanceS.setBounds(10, 11, 264, 39);
		panelCheckBalanceS.add(lblCurrentBalanceS);
		
		txtCurrentBalanceS = new JTextField();
		txtCurrentBalanceS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCurrentBalanceS.setEditable(false);
		txtCurrentBalanceS.setColumns(10);
		txtCurrentBalanceS.setBounds(22, 61, 252, 48);
		panelCheckBalanceS.add(txtCurrentBalanceS);
		txtCurrentBalanceS.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				setActive();				
			}
			public void insertUpdate(DocumentEvent e) {
				setActive();
			}
			public void removeUpdate(DocumentEvent e) {
				setActive();				
			}
		});
		
		btnBackSC = new JButton("back");
		btnBackSC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBackSC_mouseClicked(e);
			}
		});
		btnBackSC.setBounds(0, 139, 89, 23);
		panelCheckBalanceS.add(btnBackSC);
		panelCheckBalanceS.setVisible(false);
		
		panelWithdrawC = new JPanel();
		panelWithdrawC.setBounds(0, 0, 284, 162);
		panelmain.add(panelWithdrawC);
		panelWithdrawC.setLayout(null);
		panelWithdrawC.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		lblWithdrawTitleC = new JLabel("How much would you like to withdraw?");
		lblWithdrawTitleC.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdrawTitleC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWithdrawTitleC.setBounds(10, 11, 264, 41);
		panelWithdrawC.add(lblWithdrawTitleC);
		
		txtAmountWithdrawC = new JTextField();
		txtAmountWithdrawC.setText(" ");
		txtAmountWithdrawC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAmountWithdrawC.setColumns(10);
		txtAmountWithdrawC.setBounds(10, 63, 86, 31);
		panelWithdrawC.add(txtAmountWithdrawC);
		txtAmountWithdrawC.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				setActive();				
			}
			public void insertUpdate(DocumentEvent e) {
				setActive();
			}
			public void removeUpdate(DocumentEvent e) {
				setActive();				
			}
		});
		
		btnWithdrawbuttonC = new JButton("Withdraw");
		btnWithdrawbuttonC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnWithdrawbuttonC_mouseClicked(e);
			}
		});
		btnWithdrawbuttonC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnWithdrawbuttonC.setBounds(106, 63, 168, 33);
		panelWithdrawC.add(btnWithdrawbuttonC);
		btnWithdrawbuttonC.setVisible(false);
		
		lblwithdrawNewBalanceC = new JLabel("Your new balance is:");
		lblwithdrawNewBalanceC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblwithdrawNewBalanceC.setBounds(10, 105, 156, 33);
		panelWithdrawC.add(lblwithdrawNewBalanceC);
		
		txtWithdrawNewBalanceC = new JTextField();
		txtWithdrawNewBalanceC.setEditable(false);
		txtWithdrawNewBalanceC.setText(" ");
		txtWithdrawNewBalanceC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtWithdrawNewBalanceC.setColumns(10);
		txtWithdrawNewBalanceC.setBounds(164, 107, 110, 31);
		panelWithdrawC.add(txtWithdrawNewBalanceC);
		txtWithdrawNewBalanceC.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				setActive();				
			}
			public void insertUpdate(DocumentEvent e) {
				setActive();
			}
			public void removeUpdate(DocumentEvent e) {
				setActive();				
			}
		});
		
		btnBackCW = new JButton("back");
		btnBackCW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBackCW_mouseClicked(e);
			}
		});
		btnBackCW.setBounds(0, 139, 89, 23);
		panelWithdrawC.add(btnBackCW);
		panelWithdrawC.setVisible(false);
		btnWithdrawbuttonC.setVisible(false);
		
		panelDepositS = new JPanel();
		panelDepositS.setBounds(0, 0, 284, 162);
		panelmain.add(panelDepositS);
		panelDepositS.setLayout(null);
		panelDepositS.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		lblHowMuchS = new JLabel("How much would you like to deposit?");
		lblHowMuchS.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowMuchS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHowMuchS.setBounds(10, 11, 264, 31);
		panelDepositS.add(lblHowMuchS);
		
		txtAmountS = new JTextField();
		txtAmountS.setText(" ");
		txtAmountS.setColumns(10);
		txtAmountS.setBounds(10, 53, 107, 38);
		panelDepositS.add(txtAmountS);
		txtAmountS.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				setActive();				
			}
			public void insertUpdate(DocumentEvent e) {
				setActive();
			}
			public void removeUpdate(DocumentEvent e) {
				setActive();				
			}
		});
		
		btnFinalDepositS = new JButton("Deposit");
		btnFinalDepositS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnFinalDepositS_actionPerformed(arg0);
			}
		});
		btnFinalDepositS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFinalDepositS.setBounds(127, 53, 147, 37);
		panelDepositS.add(btnFinalDepositS);
		
		lblNewBalanceS = new JLabel("Your new balance is:");
		lblNewBalanceS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewBalanceS.setBounds(10, 102, 154, 23);
		panelDepositS.add(lblNewBalanceS);
		
		txtNewBalanceS = new JTextField();
		txtNewBalanceS.setEditable(false);
		txtNewBalanceS.setText(" ");
		txtNewBalanceS.setColumns(10);
		txtNewBalanceS.setBounds(161, 101, 113, 26);
		panelDepositS.add(txtNewBalanceS);
		txtNewBalanceS.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				setActive();				
			}
			public void insertUpdate(DocumentEvent e) {
				setActive();
			}
			public void removeUpdate(DocumentEvent e) {
				setActive();				
			}
		});
		
		btnBackSD = new JButton("back");
		btnBackSD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBackSD_mouseClicked(e);
			}
		});
		btnBackSD.setBounds(0, 139, 89, 23);
		panelDepositS.add(btnBackSD);
		panelDepositS.setVisible(false);
		btnFinalDepositS.setVisible(false);
		
		panelDepositC = new JPanel();
		panelDepositC.setBounds(0, 0, 284, 162);
		panelmain.add(panelDepositC);
		panelDepositC.setLayout(null);
		panelDepositC.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		lblHowMuchC = new JLabel("How much would you like to deposit?");
		lblHowMuchC.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowMuchC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHowMuchC.setBounds(10, 11, 264, 31);
		panelDepositC.add(lblHowMuchC);
		
		txtAmountC = new JTextField();
		txtAmountC.setText(" ");
		txtAmountC.setColumns(10);
		txtAmountC.setBounds(10, 53, 107, 38);
		panelDepositC.add(txtAmountC);
		txtAmountC.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				setActive();				
			}
			public void insertUpdate(DocumentEvent e) {
				setActive();
			}
			public void removeUpdate(DocumentEvent e) {
				setActive();				
			}
		});
		
		btnFinalDepositC = new JButton("Deposit");
		btnFinalDepositC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnFinalDepositC_mouseClicked(arg0);
			}
		});
		btnFinalDepositC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFinalDepositC.setBounds(127, 53, 147, 37);
		panelDepositC.add(btnFinalDepositC);
		btnFinalDepositC.setVisible(false);
		
		lblNewBalanceC = new JLabel("Your new balance is:");
		lblNewBalanceC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewBalanceC.setBounds(10, 102, 154, 23);
		panelDepositC.add(lblNewBalanceC);
		
		txtNewBalanceC = new JTextField();
		txtNewBalanceC.setEditable(false);
		txtNewBalanceC.setText(" ");
		txtNewBalanceC.setColumns(10);
		txtNewBalanceC.setBounds(161, 101, 113, 26);
		panelDepositC.add(txtNewBalanceC);
		txtNewBalanceC.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				setActive();				
			}
			public void insertUpdate(DocumentEvent e) {
				setActive();
			}
			public void removeUpdate(DocumentEvent e) {
				setActive();				
			}
		});
		
		btnBackCD = new JButton("back");
		btnBackCD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBackCD_mouseClicked(e);
			}
		});
		btnBackCD.setBounds(0, 139, 89, 23);
		panelDepositC.add(btnBackCD);
		panelDepositC.setVisible(false);
		btnFinalDepositC.setVisible(false);
		
		panelWithdrawS = new JPanel();
		panelWithdrawS.setBounds(0, 0, 284, 162);
		panelmain.add(panelWithdrawS);
		panelWithdrawS.setLayout(null);
		panelWithdrawS.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		lblWithdrawtitleS = new JLabel("How much would you like to withdraw?");
		lblWithdrawtitleS.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdrawtitleS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWithdrawtitleS.setBounds(10, 11, 264, 41);
		panelWithdrawS.add(lblWithdrawtitleS);
		
		txtAmountWithdrawS = new JTextField();
		txtAmountWithdrawS.setText(" ");
		txtAmountWithdrawS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAmountWithdrawS.setColumns(10);
		txtAmountWithdrawS.setBounds(10, 63, 86, 31);
		panelWithdrawS.add(txtAmountWithdrawS);
		txtAmountWithdrawS.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				setActive();				
			}
			public void insertUpdate(DocumentEvent e) {
				setActive();
			}
			public void removeUpdate(DocumentEvent e) {
				setActive();				
			}
		});
		
		btnWithdrawbuttonS = new JButton("Withdraw");
		btnWithdrawbuttonS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnWithdrawbuttonS_mouseClicked(arg0);
			}
		});
		btnWithdrawbuttonS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnWithdrawbuttonS.setBounds(106, 63, 168, 33);
		panelWithdrawS.add(btnWithdrawbuttonS);
		btnWithdrawbuttonS.setVisible(false);
		
		
		lblwithdrawNewBalanceS = new JLabel("Your new balance is:");
		lblwithdrawNewBalanceS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblwithdrawNewBalanceS.setBounds(10, 105, 156, 33);
		panelWithdrawS.add(lblwithdrawNewBalanceS);
		
		txtWithdrawNewBalanceS = new JTextField();
		txtWithdrawNewBalanceS.setEditable(false);
		txtWithdrawNewBalanceS.setText(" ");
		txtWithdrawNewBalanceS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtWithdrawNewBalanceS.setColumns(10);
		txtWithdrawNewBalanceS.setBounds(164, 107, 110, 31);
		panelWithdrawS.add(txtWithdrawNewBalanceS);
		txtWithdrawNewBalanceS.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				setActive();				
			}
			public void insertUpdate(DocumentEvent e) {
				setActive();
			}
			public void removeUpdate(DocumentEvent e) {
				setActive();				
			}
		});
		
		btnBackSW = new JButton("back");
		btnBackSW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBackSW_mouseClicked(e);
			}
		});
		btnBackSW.setBounds(0, 139, 89, 23);
		panelWithdrawS.add(btnBackSW);
		panelWithdrawS.setVisible(false);
		btnWithdrawbuttonS.setVisible(false);
		
		panelAccountInfoC = new JPanel();
		panelAccountInfoC.setLayout(null);
		panelAccountInfoC.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelAccountInfoC.setBounds(0, 0, 284, 162);
		panelmain.add(panelAccountInfoC);
		
		lblWithdrawalFeeC = new JLabel("what is your withdrawal fee? (in %)");
		lblWithdrawalFeeC.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWithdrawalFeeC.setBounds(10, 11, 171, 23);
		panelAccountInfoC.add(lblWithdrawalFeeC);
		
		btnContinueC = new JButton("continue");
		btnContinueC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnContinueC_mouseClicked(e);
			}
		});
		btnContinueC.setBounds(195, 139, 89, 23);
		panelAccountInfoC.add(btnContinueC);
		
		txtWithdrawFeeC = new JTextField();
		txtWithdrawFeeC.setAlignmentX(TOP_ALIGNMENT);
		txtWithdrawFeeC.setAlignmentY(LEFT_ALIGNMENT);
		txtWithdrawFeeC.setColumns(10);
		txtWithdrawFeeC.setBounds(188, 12, 86, 20);
		panelAccountInfoC.add(txtWithdrawFeeC);
		
		txtWithdrawFeeC.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				//System.out.println(txtWithdrawFeeC.getText());
				setActive();
			}
			public void insertUpdate(DocumentEvent e) {
				//System.out.println(txtWithdrawFeeC.getText());
				setActive();
			}
			public void removeUpdate(DocumentEvent e) {
				//System.out.println(txtWithdrawFeeC.getText());
				setActive();				
			}
		});
		
		lblStartBalanceC = new JLabel("what is your current balance?(in $ CAN)");
		lblStartBalanceC.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblStartBalanceC.setBounds(10, 66, 191, 14);
		panelAccountInfoC.add(lblStartBalanceC);
		
		txtBalanceC = new JTextField();
		txtBalanceC.setColumns(10);
		txtBalanceC.setBounds(204, 63, 70, 20);
		panelAccountInfoC.add(txtBalanceC);
		txtBalanceC.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				setActive();				
			}
			public void insertUpdate(DocumentEvent e) {
				setActive();
			}
			public void removeUpdate(DocumentEvent e) {
				setActive();				
			}
		});
		
		lblInterestRateC = new JLabel("what is your annual interest rate?(in %)");
		lblInterestRateC.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInterestRateC.setBounds(10, 111, 193, 14);
		panelAccountInfoC.add(lblInterestRateC);
		
		txtInterestRateC = new JTextField();
		txtInterestRateC.setColumns(10);
		txtInterestRateC.setBounds(204, 108, 70, 20);
		panelAccountInfoC.add(txtInterestRateC);
		txtInterestRateC.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				setActive();				
			}
			public void insertUpdate(DocumentEvent e) {
				setActive();
			}
			public void removeUpdate(DocumentEvent e) {
				setActive();				
			}
		});
		
		btnBackInfoC = new JButton("back");
		btnBackInfoC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBackInfoC_mouseClicked(e);
			}
		});
		btnBackInfoC.setBounds(0, 139, 89, 23);
		panelAccountInfoC.add(btnBackInfoC);
		panelAccountInfoC.setVisible(false);
		btnContinueC.setVisible(false);
		
		panelAccountInfoS = new JPanel();
		panelAccountInfoS.setLayout(null);
		panelAccountInfoS.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelAccountInfoS.setBounds(0, 0, 284, 162);
		panelmain.add(panelAccountInfoS);
		
		lblWithdrawalFeeS = new JLabel("what is your withdrawal fee? (in %)");
		lblWithdrawalFeeS.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdrawalFeeS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWithdrawalFeeS.setBounds(10, 11, 171, 23);
		panelAccountInfoS.add(lblWithdrawalFeeS);
		
		btnContinueS = new JButton("continue");
		btnContinueS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnContinueS_mouseClicked(arg0);
			}
		});
		btnContinueS.setBounds(195, 139, 89, 23);
		panelAccountInfoS.add(btnContinueS);
		btnContinueS.setVisible(false);
		
		txtWithdrawFeeS = new JTextField();
		txtWithdrawFeeS.setText(" ");
		txtWithdrawFeeS.setBounds(188, 12, 86, 20);
		panelAccountInfoS.add(txtWithdrawFeeS);
		txtWithdrawFeeS.setColumns(10);
		txtWithdrawFeeS.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				setActive();				
			}
			public void insertUpdate(DocumentEvent e) {
				setActive();
			}
			public void removeUpdate(DocumentEvent e) {
				setActive();				
			}
		});
		
		lblStartBalanceS = new JLabel("what is your current balance?(in $ CAN)");
		lblStartBalanceS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblStartBalanceS.setBounds(10, 66, 191, 14);
		panelAccountInfoS.add(lblStartBalanceS);
		
		txtBalanceS = new JTextField();
		txtBalanceS.setBounds(204, 63, 70, 20);
		panelAccountInfoS.add(txtBalanceS);
		txtBalanceS.setColumns(10);
		txtBalanceS.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				setActive();				
			}
			public void insertUpdate(DocumentEvent e) {
				setActive();
			}
			public void removeUpdate(DocumentEvent e) {
				setActive();				
			}
		});
		
		lblInterestRateS = new JLabel("what is your annual interest rate?(in %)");
		lblInterestRateS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInterestRateS.setBounds(10, 111, 193, 14);
		panelAccountInfoS.add(lblInterestRateS);
		
		txtInterestRateS = new JTextField();
		txtInterestRateS.setBounds(204, 108, 70, 20);
		panelAccountInfoS.add(txtInterestRateS);
		txtInterestRateS.setColumns(10);
		txtInterestRateS.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				setActive();				
			}
			public void insertUpdate(DocumentEvent e) {
				setActive();
			}
			public void removeUpdate(DocumentEvent e) {
				setActive();				
			}
		});
		
		btnBackInfoS = new JButton("back");
		btnBackInfoS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBackInfoS_mouseClicked(e);
			}
		});
		btnBackInfoS.setBounds(0, 139, 89, 23);
		panelAccountInfoS.add(btnBackInfoS);
		panelAccountInfoS.setVisible(false);
		
		panelActionsC = new JPanel();
		panelActionsC.setBounds(0, 0, 284, 162);
		panelmain.add(panelActionsC);
		panelActionsC.setLayout(null);
		panelActionsC.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		lblActionsC = new JLabel("What would you like to do?");
		lblActionsC.setHorizontalAlignment(SwingConstants.CENTER);
		lblActionsC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblActionsC.setBounds(10, 11, 264, 23);
		panelActionsC.add(lblActionsC);
		
		btnDepositC = new JButton("Deposit");
		btnDepositC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDepositC_mouseClicked(e);
			}
		});
		btnDepositC.setBounds(46, 36, 192, 30);
		panelActionsC.add(btnDepositC);
		
		btnWithdrawC = new JButton("Withdraw");
		btnWithdrawC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnWithdrawC_mouseClicked(e);
			}
		});
		btnWithdrawC.setBounds(46, 70, 192, 30);
		panelActionsC.add(btnWithdrawC);
		
		btnCheckBalanceC = new JButton("Check Balance");
		btnCheckBalanceC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCheckBalanceC_mouseClicked(e);
			}
		});
		btnCheckBalanceC.setBounds(46, 104, 192, 30);
		panelActionsC.add(btnCheckBalanceC);
		
		btnBackC = new JButton("back");
		btnBackC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBackC_mouseClicked(e);
			}
		});
		btnBackC.setBounds(0, 139, 89, 23);
		panelActionsC.add(btnBackC);
		panelActionsC.setVisible(false); 
		
		panelActionsS = new JPanel();
		panelActionsS.setBounds(0, 0, 284, 162);
		panelmain.add(panelActionsS);
		panelActionsS.setLayout(null);
		panelActionsS.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		lblActionsS = new JLabel("What would you like to do?");
		lblActionsS.setHorizontalAlignment(SwingConstants.CENTER);
		lblActionsS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblActionsS.setBounds(10, 11, 264, 23);
		panelActionsS.add(lblActionsS);
		
		btnDepositS = new JButton("Deposit");
		btnDepositS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDepositS_mouseClicked(e);
			}
		});
		btnDepositS.setBounds(46, 36, 192, 30);
		panelActionsS.add(btnDepositS);
		
		btnWithdrawS = new JButton("Withdraw");
		btnWithdrawS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnWithdrawS_mouseClicked(e);
			}
		});
		btnWithdrawS.setBounds(46, 70, 192, 30);
		panelActionsS.add(btnWithdrawS);
		
		btnCheckBalanceS = new JButton("Check Balance");
		btnCheckBalanceS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCheckBalanceS_mouseClicked(e);
			}
		});
		btnCheckBalanceS.setBounds(46, 104, 192, 30);
		panelActionsS.add(btnCheckBalanceS);
		
		btnBackS = new JButton("back");
		btnBackS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBackS_mouseClicked(e);
			}
		});
		btnBackS.setBounds(0, 140, 89, 23);
		panelActionsS.add(btnBackS);
		panelActionsS.setVisible(false);
		
		
		panelAccounts = new JPanel();
		panelAccounts.setBounds(0, 0, 284, 162);
		panelmain.add(panelAccounts);
		panelAccounts.setLayout(null);
		panelAccounts.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		lblChoice = new JLabel("Which account would you like to access");
		lblChoice.setBounds(0, 0, 284, 23);
		panelAccounts.add(lblChoice);
		lblChoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnChequing = new JButton("Chequing");
		btnChequing.setBounds(53, 34, 177, 37);
		panelAccounts.add(btnChequing);
		btnChequing.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnSavings = new JButton("Savings");
		btnSavings.setBounds(53, 82, 177, 37);
		panelAccounts.add(btnSavings);
		btnSavings.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSavings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSavings_mouseClicked(e);
			}
		});
		btnChequing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnChequing_mouseClicked(arg0);
			}
		});
		panelmain.setVisible(true);


	}
	
	protected void btnChequing_mouseClicked(MouseEvent arg0) {
		panelAccountInfoC.setVisible(true);
		panelAccounts.setVisible(false);
		currentPanel = Panels.ACCOUNT_INFOC;
	}
	
	protected void btnSavings_mouseClicked(MouseEvent e) {
		panelAccountInfoS.setVisible(true);
		panelAccounts.setVisible(false);
		currentPanel = Panels.ACCOUNT_INFOS;
	}
	
	protected void btnDepositC_mouseClicked(MouseEvent e) {
		panelActionsC.setVisible(false);
		panelDepositC.setVisible(true);
		currentPanel = Panels.DEPOSITC;
	}
	
	protected void btnWithdrawC_mouseClicked(MouseEvent e) {
		panelActionsC.setVisible(false);
		panelWithdrawC.setVisible(true);
		currentPanel = Panels.WITHDRAWC;
	}
	
	protected void btnCheckBalanceC_mouseClicked(MouseEvent e) {

		panelActionsC.setVisible(false);
		panelCheckBalanceC.setVisible(true);
		currentPanel = Panels.CHECK_BALANCEC;
		this.txtCurrentBalanceC.setText(chequing.getFormatedBalance());
	}
	
	protected void btnFinalDepositC_mouseClicked(MouseEvent arg0) {
		chequing.deposit(Double.valueOf(this.txtAmountC.getText()));
		String output = String.format("%.2f\n", (chequing.getBalance()));
		this.txtNewBalanceC.setText(output);
		this.txtAmountC.setText("");
		this.btnFinalDepositC.setVisible(false);
	}
	
	protected void btnWithdrawbuttonC_mouseClicked(MouseEvent e) {
		chequing.withdraw(Double.valueOf(this.txtAmountWithdrawC.getText()));
		if (0 > chequing.getBalance()) {
			JOptionPane.showMessageDialog(this, "You Can't withdraw more than you have in your balance",
					"INVALID", JOptionPane.WARNING_MESSAGE);
		}
		else { 
			this.txtWithdrawNewBalanceC.setText(chequing.getFormatedBalance());
		}
	}
	
	protected void btnFinalDepositS_actionPerformed(ActionEvent arg0) {
		savings.deposit(Double.valueOf(this.txtAmountS.getText()));
		String output = String.format("%.2f\n", (savings.getBalance()));
		this.txtNewBalanceS.setText(output);
		this.txtAmountS.setText("");
		this.btnFinalDepositS.setVisible(false);
	}
	
	protected void btnWithdrawbuttonS_mouseClicked(MouseEvent e) {
		savings.withdraw(Double.valueOf(this.txtAmountWithdrawS.getText()));
		if (0 > savings.getBalance()) {
			JOptionPane.showMessageDialog(this, "You Can't withdraw more than you have in your balance",
					"INVALID", JOptionPane.WARNING_MESSAGE);
		}
		else { 
			this.txtWithdrawNewBalanceS.setText(savings.getFormatedBalance());
		}
	}
	
	protected void btnBackS_mouseClicked(MouseEvent e) {
		panelActionsS.setVisible(false);
		panelAccountInfoS.setVisible(true);
		currentPanel = Panels.ACCOUNT_INFOS;
	}
	
	protected void btnBackCD_mouseClicked(MouseEvent e) {
		panelDepositC.setVisible(false);
		panelActionsC.setVisible(true);
		currentPanel = Panels.ACTIONSC;
		this.txtNewBalanceC.setText("");
		this.txtAmountC.setText("");
		this.btnFinalDepositC.setVisible(false);
	}
	
	protected void btnBackSD_mouseClicked(MouseEvent e) {
		panelDepositS.setVisible(false);
		panelActionsS.setVisible(true);
		currentPanel = Panels.ACTIONSS;
		this.txtNewBalanceS.setText("");
		this.txtAmountS.setText("");
		this.btnFinalDepositS.setVisible(false);
	}
	
	protected void btnBackCC_mouseClicked(MouseEvent e) {
		panelCheckBalanceC.setVisible(false);
		panelActionsC.setVisible(true);
		currentPanel = Panels.ACTIONSC;
	}
	
	protected void btnBackSC_mouseClicked(MouseEvent e) {
		panelCheckBalanceS.setVisible(false);
		panelActionsS.setVisible(true);
		currentPanel = Panels.ACTIONSS;
	}
	
	protected void btnBackSW_mouseClicked(MouseEvent e) {
		panelWithdrawS.setVisible(false);
		panelActionsS.setVisible(true);
		currentPanel = Panels.ACTIONSS;
		this.txtAmountWithdrawS.setText("");
		this.txtWithdrawNewBalanceS.setText("");
		this.btnWithdrawbuttonS.setVisible(false);
	}
	
	protected void btnBackCW_mouseClicked(MouseEvent e) {
		panelWithdrawC.setVisible(false);
		panelActionsC.setVisible(true);
		currentPanel = Panels.ACTIONSC;
		this.txtAmountWithdrawC.setText("");
		this.txtWithdrawNewBalanceC.setText("");
		this.btnWithdrawbuttonC.setVisible(false);
	}
	
	protected void btnDepositS_mouseClicked(MouseEvent e) {
		panelActionsS.setVisible(false);
		panelDepositS.setVisible(true);
		currentPanel = Panels.DEPOSITS;
	}
	
	protected void btnWithdrawS_mouseClicked(MouseEvent e) {
		panelActionsS.setVisible(false);
		panelWithdrawS.setVisible(true);
		currentPanel = Panels.WITHDRAWS;
	}
	
	protected void btnCheckBalanceS_mouseClicked(MouseEvent e) {
		panelActionsS.setVisible(false);
		panelCheckBalanceS.setVisible(true);
		currentPanel = Panels.CHECK_BALANCES;
		this.txtCurrentBalanceS.setText(savings.getFormatedBalance());
	}
	
	protected void btnContinueS_mouseClicked(MouseEvent arg0) {
		panelActionsS.setVisible(true);
		panelAccountInfoS.setVisible(false);
		currentPanel = Panels.ACTIONSS;
		try {
			savings.setAnnualInterestRate(Double.valueOf(this.txtInterestRateS.getText()));
		} catch (NumberFormatException e1) {
		}
		try {
			savings.setWithdrawalFee(Double.valueOf(this.txtWithdrawFeeS.getText()));
		} catch (NumberFormatException e1) {
		}
		try {
			savings.setBalance(Double.valueOf(this.txtBalanceS.getText()));
		} catch (NumberFormatException e1) {
		}
	}
	
	protected void btnContinueC_mouseClicked(MouseEvent e) {
		panelActionsC.setVisible(true);
		panelAccountInfoC.setVisible(false);
		currentPanel = Panels.ACTIONSC;
		try {
			chequing.setAnnualInterestRate(Double.valueOf(this.txtInterestRateC.getText()));
		} catch (NumberFormatException e1) {
		}
		try {
			chequing.setWithdrawalFee(Double.valueOf(this.txtWithdrawFeeC.getText()));
		} catch (NumberFormatException e1) {
		}
		try {
			chequing.setBalance(Double.valueOf(this.txtBalanceC.getText()));
		} catch (NumberFormatException e1) {
		}
	}
	
	protected void btnBackC_mouseClicked(MouseEvent e) {
		panelActionsC.setVisible(false);
		panelAccountInfoC.setVisible(true);
		currentPanel = Panels.ACCOUNT_INFOC;
	}
	
	protected void btnBackInfoS_mouseClicked(MouseEvent e) {
		panelAccountInfoS.setVisible(false);
		panelAccounts.setVisible(true);
		currentPanel = Panels.ACCOUNTS;
	}
	
	protected void btnBackInfoC_mouseClicked(MouseEvent e) {
		panelAccountInfoC.setVisible(false);
		panelAccounts.setVisible(true);
		currentPanel = Panels.ACCOUNTS;
	}
	
	private void setActive() {
		System.out.println("Controls");
		
		panelAccountInfoS.setVisible(currentPanel == Panels.ACCOUNT_INFOS);
		panelAccountInfoC.setVisible(currentPanel == Panels.ACCOUNT_INFOC);
		panelActionsC.setVisible(currentPanel == Panels.ACTIONSC); 
		panelActionsS.setVisible(currentPanel == Panels.ACTIONSS);
		panelCheckBalanceC.setVisible(currentPanel == Panels.CHECK_BALANCEC);
		panelCheckBalanceS.setVisible(currentPanel == Panels.CHECK_BALANCES);
		panelDepositC.setVisible(currentPanel == Panels.DEPOSITC);
		panelDepositS.setVisible(currentPanel == Panels.DEPOSITS);
		panelWithdrawC.setVisible(currentPanel == Panels.WITHDRAWC);
		panelWithdrawS.setVisible(currentPanel == Panels.WITHDRAWS);
		panelAccounts.setVisible(currentPanel == Panels.ACCOUNTS);
				
		//panelAccountInfoC:-----------------------------------------------WORKING
		if (currentPanel == Panels.ACCOUNT_INFOC) {
			String WithdrawFeeC = this.txtWithdrawFeeC.getText();
			String BalanceCurrentC = this.txtBalanceC.getText();
			String YearlyInterestRateC = this.txtInterestRateC.getText();
			
			boolean withdrawFeeCOk =  (WithdrawFeeC.length() <= 12);
			boolean BalanceCurrentCOk =  (BalanceCurrentC.length() <= 12);
			boolean YearlyInterestRateCOK =  (YearlyInterestRateC.length() <= 12);
			
			if ((withdrawFeeCOk == false) || (BalanceCurrentCOk == false) || (YearlyInterestRateCOK == false)) {
				JOptionPane.showMessageDialog(this, "your amount may not exceed 12 characters in length.",
						"INVALID", JOptionPane.WARNING_MESSAGE);
				this.btnContinueC.setVisible(false);
			}
			
			double WithdrawC = 0;
			try {
				WithdrawC = Double.valueOf(this.txtWithdrawFeeC.getText());
			} catch (NumberFormatException e2) {
			}
			double BalanceC = 0;
			try {
				BalanceC = Double.valueOf(this.txtBalanceC.getText());
			} catch (NumberFormatException e2) {
			}
			double InterestRateC = 0;
			try {
				InterestRateC = Double.valueOf(this.txtInterestRateC.getText());
			} catch (NumberFormatException e2) {
			}
			if ((WithdrawC  >= 0) && (BalanceC >= 0) && (InterestRateC >= 0)) {
				boolean WithdrawFeeCIsNumerical = false;
				boolean InterestRateCIsNumerical = false;
				boolean BalanceCIsNumerical = false;
					
				try {
					WithdrawFeeCIsNumerical = Double.valueOf(this.txtWithdrawFeeC.getText()) != 0;
				} catch (NumberFormatException e1) {
				}
				try {
					InterestRateCIsNumerical = Double.valueOf(this.txtInterestRateC.getText()) != 0;
				} catch (NumberFormatException e) {
				}
				try {
					BalanceCIsNumerical = Double.valueOf(this.txtBalanceC.getText()) != 0;
				} catch (NumberFormatException e) {
				}
					
				boolean BalanceCNotGiven = this.txtBalanceC.getText().equals("");
				boolean InterestRateCNotGiven = this.txtInterestRateC.getText().equals("");
				boolean WithdrawFeeCNotGiven = this.txtWithdrawFeeC.getText().equals("");
				
				this.btnContinueC.setVisible(withdrawFeeCOk && BalanceCurrentCOk && YearlyInterestRateCOK && (WithdrawFeeCNotGiven == false && WithdrawFeeCIsNumerical) && (InterestRateCNotGiven == false && InterestRateCIsNumerical) && (BalanceCNotGiven == false && BalanceCIsNumerical));
				
			}
			else {
				JOptionPane.showMessageDialog(this, "Make sure all of you're Information is positive and not negative",
						"INVALID", JOptionPane.WARNING_MESSAGE);
				this.btnContinueC.setVisible(false);
			}
		}
		
		//panelAccountInfoS---------------------------------------------------------WORKING
		if(currentPanel == Panels.ACCOUNT_INFOS) {
			String WithdrawFeeS = this.txtWithdrawFeeC.getText();
			String BalanceCurrentS = this.txtBalanceC.getText();
			String YearlyInterestRateS = this.txtInterestRateC.getText();
			
			boolean withdrawFeeSOk =  (WithdrawFeeS.length() <= 12);
			boolean BalanceCurrentSOk =  (BalanceCurrentS.length() <= 12);
			boolean YearlyInterestRateSOK =  (YearlyInterestRateS.length() <= 12);
			
			if ((withdrawFeeSOk == false) || (BalanceCurrentSOk == false) || (YearlyInterestRateSOK == false)) {
				JOptionPane.showMessageDialog(this, "your amount may not exceed 12 characters in length.",
						"INVALID", JOptionPane.WARNING_MESSAGE);
				this.btnContinueS.setVisible(false);
			}
			double WithdrawS = 0;
			try {
				WithdrawS = Double.valueOf(this.txtWithdrawFeeC.getText());
			} catch (NumberFormatException e2) {
			}
			double BalanceS = 0;
			try {
				BalanceS = Double.valueOf(this.txtBalanceC.getText());
			} catch (NumberFormatException e2) {
			}
			double InterestRateS = 0;
			try {
				InterestRateS = Double.valueOf(this.txtInterestRateC.getText());
			} catch (NumberFormatException e2) {
			}
			if ((WithdrawS  >= 0) && (BalanceS >= 0) && (InterestRateS >= 0)) {
				boolean WithdrawFeeSIsNumerical = false;
				boolean InterestRateSIsNumerical = false;
				boolean BalanceSIsNumerical = false;
					
				try {
					WithdrawFeeSIsNumerical = Double.valueOf(this.txtWithdrawFeeS.getText()) != 0;
				} catch (NumberFormatException e) {
				}
				try {
					InterestRateSIsNumerical = Double.valueOf(this.txtInterestRateS.getText()) != 0;
				} catch (NumberFormatException e) {
				}
				try {
					BalanceSIsNumerical = Double.valueOf(this.txtBalanceS.getText()) != 0;
				} catch (NumberFormatException e) {
				}
					
				boolean WithdrawFeeSNotGiven = this.txtWithdrawFeeS.getText().equals("");
				boolean InterestRateSNotGiven = this.txtInterestRateS.getText().equals("");
				boolean BalanceSNotGiven = this.txtBalanceS.getText().equals("");
					
				this.btnContinueS.setVisible(withdrawFeeSOk && BalanceCurrentSOk && YearlyInterestRateSOK &&(WithdrawFeeSNotGiven == false && WithdrawFeeSIsNumerical) && (InterestRateSNotGiven == false && InterestRateSIsNumerical) && (BalanceSNotGiven == false && BalanceSIsNumerical));
			}
			else {
				JOptionPane.showMessageDialog(this, "Make sure all of you're Information is positive and not negative",
						"INVALID", JOptionPane.WARNING_MESSAGE);
				this.btnContinueS.setVisible(false);
			}
		}
		//panelDepositS-----------------------------------------------------------WORKING
		if(currentPanel == Panels.DEPOSITS) {
			String DepositS = this.txtAmountS.getText(); 
			
			boolean DepositSNotOK = (DepositS.length() >= 13);
			
			if (DepositSNotOK == true) {
				JOptionPane.showMessageDialog(this, "your amount may not exceed 12 characters in length.",
						"INVALID", JOptionPane.WARNING_MESSAGE);
				this.btnFinalDepositS.setVisible(false);
			}
			
			double AmountS = 0;
			try {
				AmountS = Double.valueOf(this.txtAmountS.getText());
			} catch (NumberFormatException e1) {
			}
			if (AmountS >= 0) {	
				boolean AmountSIsNumerical = false;
					
				try {
					AmountSIsNumerical = Double.valueOf(this.txtAmountS.getText()) != 0;
				} catch (NumberFormatException e) {
				}
					
				boolean AmountSNotGiven = this.txtAmountS.getText().equals("");
					
				this.btnFinalDepositS.setVisible((DepositSNotOK == false) && (AmountSNotGiven == false && AmountSIsNumerical));
			}	
			else {
				JOptionPane.showMessageDialog(this, "You can't deposit a negative amount of money",
						"INVALID", JOptionPane.WARNING_MESSAGE);
				this.btnFinalDepositS.setVisible(false);
			}
		}
		//panelDepositC------------------------------------------------------------------WORKING
		if(currentPanel == Panels.DEPOSITC) {
			String DepositC = this.txtAmountC.getText(); 
			
			boolean DepositCNotOk = (DepositC.length() >= 14);
			
			if (DepositCNotOk == true) {
				JOptionPane.showMessageDialog(this, "your amount may not exceed 12 characters in length.",
						"INVALID", JOptionPane.WARNING_MESSAGE);
				this.btnFinalDepositC.setVisible(false);
				System.out.println("over limit");
			}

			double AmountC = 0;
			try {
				AmountC = Double.valueOf(this.txtAmountS.getText());
			} catch (NumberFormatException e1) {
			}
			if (AmountC >= 0) {	
				boolean amountCIsNumerical = false;
					
				try {
					amountCIsNumerical = Double.valueOf(this.txtAmountC.getText()) != 0;
				} catch (NumberFormatException e) {
				}
					
				boolean amountCNotGiven = this.txtAmountC.getText().equals("");
					
				this.btnFinalDepositC.setVisible((DepositCNotOk == false) && (amountCNotGiven == false && amountCIsNumerical));
				System.out.println("under limit");
			}	
			else{
				JOptionPane.showMessageDialog(this, "You can't deposit a negative amount of money",
						"INVALID", JOptionPane.WARNING_MESSAGE);
				this.btnFinalDepositC.setVisible(false);
			}
		}
		//panelWithdrawC-------------------------------------------------------------------WORKING
		if(currentPanel == Panels.WITHDRAWC) {
			String WithdrawC = this.txtAmountWithdrawC.getText(); 
			
			boolean WithdrawCOk = (WithdrawC.length() >= 14);
			
			if (WithdrawCOk == true) {
				JOptionPane.showMessageDialog(this, "your amount may not exceed 12 characters in length.",
						"INVALID", JOptionPane.WARNING_MESSAGE);
				this.btnWithdrawbuttonC.setVisible(false);
			}
			
			double AmountWithdrawC = 0;
			try {
				AmountWithdrawC = Double.valueOf(this.txtAmountWithdrawC.getText());
			} catch (NumberFormatException e1) {
			}
			if (AmountWithdrawC >= 0) {	
				boolean AmountWithdrawCIsNumerical = false;
					
				try {
					AmountWithdrawCIsNumerical = Double.valueOf(this.txtAmountWithdrawC.getText()) != 0;
				} catch (NumberFormatException e) {
				}
					
				boolean AmountWithdrawCNotGiven = this.txtAmountWithdrawC.getText().equals("");
					
				this.btnWithdrawbuttonC.setVisible((WithdrawCOk == false) && (AmountWithdrawCNotGiven == false && AmountWithdrawCIsNumerical));
			}
			else {
				JOptionPane.showMessageDialog(this, "You can't withdraw a negative amount of money",
						"INVALID", JOptionPane.WARNING_MESSAGE);
				this.btnWithdrawbuttonC.setVisible(false);
			}
		}
		//panelWithdrawS--------------------------------------------------------------------NOT WORKING	
		if(currentPanel == Panels.WITHDRAWS) {
			String WithdrawS = this.txtAmountWithdrawS.getText();
			
			boolean WithdrawSOk = (WithdrawS.length() >= 14);
			
			if (WithdrawSOk == true) {
				JOptionPane.showMessageDialog(this, "your amount may not exceed 12 characters in length.",
						"INVALID", JOptionPane.WARNING_MESSAGE);
				this.btnWithdrawbuttonS.setVisible(false);
			}
			double AmountWithdrawS = 0;
			try {
				AmountWithdrawS = Double.valueOf(this.txtAmountWithdrawS.getText());
			} catch (NumberFormatException e1) {
			}
			if (AmountWithdrawS >= 0) {
				boolean AmountWithdrawSIsNumerical = false;
					
				try {
					AmountWithdrawSIsNumerical = Double.valueOf(this.txtAmountWithdrawS.getText()) != 0;
				} catch (NumberFormatException e) {
				}
					
				boolean AmountWithdrawSNotGiven = this.txtAmountWithdrawS.getText().equals("");
					
				this.btnWithdrawbuttonS.setVisible((WithdrawSOk == false) && (AmountWithdrawSNotGiven == false && AmountWithdrawSIsNumerical));
			}
			else{
				JOptionPane.showMessageDialog(this, "You can't withdraw a negative amount of money",
						"INVALID", JOptionPane.WARNING_MESSAGE);
				this.btnWithdrawbuttonS.setVisible(false);
			}
		}
	}
	
}
