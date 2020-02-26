package janakalyan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class InvoiceFrame extends JFrame {

	private JPanel contentPane;
	static InvoiceFrame frame;
	public JButton btnPrint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new InvoiceFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InvoiceFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 10, 850, 700);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		btnPrint = new JButton("PRINT");
		btnPrint.setBounds(212, 586, 89, 30);
		contentPane.add(btnPrint);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(548, 586, 89, 30);
		contentPane.add(btnCancel);
	}
}
