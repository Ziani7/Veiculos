import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Frame() {
		InitComponents();
		
		this.menuBar = new JMenuBar();
		setJMenuBar(this.menuBar);
		
		this.mnNewMenu = new JMenu("Menu");
		this.menuBar.add(this.mnNewMenu);
		
		this.mntmNewMenuItem = new JMenuItem("Cadastrar");
		this.mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudaTelaCad();
			}
		});
		this.mnNewMenu.add(this.mntmNewMenuItem);
		
		this.mntmNewMenuItem_1 = new JMenuItem("Consultar");
		this.mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudaTelaCon();
			}
		});
		this.mnNewMenu.add(this.mntmNewMenuItem_1);
		
		this.mntmNewMenuItem_2 = new JMenuItem("Editar/Excluir");
		this.mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudaTelaAlt();
			}
		});
		this.mnNewMenu.add(this.mntmNewMenuItem_2);
		this.setContentPane(new PanelCadastrar());
		this.setVisible(true);
	}
	
	
	private void InitComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
	}
	
	public void mudaTelaCad() {
		this.setContentPane(new PanelCadastrar());
		this.setVisible(true);
	}
	
	public void mudaTelaCon() {
		this.setContentPane(new PanelConsultar());
		this.setVisible(true);
	}
	
	public void mudaTelaAlt() {
		this.setContentPane(new PanelAlterarExcluir());
		this.setVisible(true);
	}
}
