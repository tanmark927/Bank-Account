import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import javax.swing.*;

public class BankAccountPanelV3 extends JPanel
{
	private JButton withdraw, deposit;
	private JTextField textField;
	private JLabel amountLabel, newBalanceLabel;
	private BankAccount bAcc;
	
	/**
	 * Constructs a panel with a given BankAccount object
	 * @param b a BankAccount object
	 */
	public BankAccountPanelV3(BankAccount b)
	{
		bAcc = b;
		JPanel display = new JPanel();
		display.setLayout(new FlowLayout(FlowLayout.LEFT));
		amountLabel = new JLabel("Amount:");
		display.add(amountLabel);
		textField = new JTextField(6);
		display.add(textField);
		
		JPanel option = new JPanel();
		ActionListener listener = new BankAccountActionListener();
		option.setLayout(new FlowLayout(FlowLayout.RIGHT));
		withdraw = new JButton("Withdraw");
		withdraw.addActionListener(listener);
		option.add(withdraw);
		
		deposit = new JButton("Deposit");
		deposit.addActionListener(listener);
		option.add(deposit);
			
		JPanel result = new JPanel();
		result.setLayout(new FlowLayout(FlowLayout.CENTER));
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		newBalanceLabel = new JLabel("Balance: " + currency.format(bAcc.getBalance()));
		result.add(newBalanceLabel);
		
		this.setLayout(new BorderLayout());
		this.add(display, BorderLayout.WEST);
		this.add(option, BorderLayout.EAST);
		this.add(result, BorderLayout.SOUTH);
	}
	
	class BankAccountActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object source = e.getSource();
			double amt = Double.parseDouble(textField.getText());

			if(source == withdraw)
				bAcc.withdraw(amt);
			else if(source == deposit)
				bAcc.deposit(amt);
			
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			newBalanceLabel.setText("Balance: " + currency.format(bAcc.getBalance()));
		}
	}
}
