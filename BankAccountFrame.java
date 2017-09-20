import javax.swing.*;

public class BankAccountFrame extends JFrame
{	
	/**
	 * Constructs a frame based on a BankAccount object
	 * @param b a BankAccount object
	 */
	public BankAccountFrame(BankAccount b)
	{
		setTitle("Bank Account");
		setSize(400,100);
		setResizable(false);
		setLocationRelativeTo(null);
		//JPanel panel = new BankAccountPanelV1(b);
		//JPanel panel = new BankAccountPanelV2(b);
		JPanel panel = new BankAccountPanelV3(b);
		//JPanel panel = new BankAccountPanelV4(b);
		this.add(panel);
	}
}
