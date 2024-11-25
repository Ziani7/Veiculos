import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCadastrar extends JPanel {
	private JLabel lblNewLabel;
	private JTextField inMarca;
	private JLabel lblNewLabel_1;
	private JTextField inModelo;
	private JLabel lblNewLabel_2;
	private JTextField inAno;
	private JLabel lblNewLabel_3;
	private JButton btCadastrar;

	
	public PanelCadastrar() {
		initComponents();
	}
	private void initComponents() {
		setLayout(new MigLayout("", "[grow][][grow][][grow]", "[grow][][][][][][][][][][grow]"));
		
		this.lblNewLabel = new JLabel("Cadastrar Autom\u00F3veis");
		add(this.lblNewLabel, "cell 2 1,alignx center");
		
		this.lblNewLabel_1 = new JLabel("Marca:");
		add(this.lblNewLabel_1, "cell 1 3,alignx right");
		
		this.inMarca = new JTextField();
		add(this.inMarca, "cell 2 3,growx");
		this.inMarca.setColumns(10);
		
		this.lblNewLabel_2 = new JLabel("Modelo:");
		add(this.lblNewLabel_2, "cell 1 5,alignx right");
		
		this.inModelo = new JTextField();
		add(this.inModelo, "cell 2 5,growx");
		this.inModelo.setColumns(10);
		
		this.lblNewLabel_3 = new JLabel("Ano:");
		add(this.lblNewLabel_3, "cell 1 7,alignx trailing");
		
		this.inAno = new JTextField();
		add(this.inAno, "cell 2 7,growx");
		this.inAno.setColumns(10);
		
		this.btCadastrar = new JButton("Cadastrar Autom\u00F3vel");
		this.btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VeiculosDAO vdao = new VeiculosDAO();
				Veiculos v = new Veiculos(inMarca.getText(), inModelo.getText(), Integer.parseInt(inAno.getText()));
				vdao.InserirVeiculo(v);
			}
		});
		add(this.btCadastrar, "cell 2 9,alignx center");
	}

}
