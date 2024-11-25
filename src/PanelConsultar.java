import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class PanelConsultar extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox comboFiltrar;
	private JComboBox comboBuscar;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel_2;
	private JTextField textField;

	
	public PanelConsultar() {
		initComponents();
	}
	private void initComponents() {
		setLayout(new MigLayout("", "[grow][][][grow][][grow][grow]", "[][][][][][][][][grow][grow]"));
		
		this.lblNewLabel = new JLabel("Consultar Ve\u00EDculos");
		add(this.lblNewLabel, "cell 1 1 3 1,alignx center");
		
		this.lblNewLabel_1 = new JLabel("Buscar por:");
		add(this.lblNewLabel_1, "cell 1 3,alignx trailing");
		
		this.comboFiltrar = new JComboBox();
		this.comboFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheCombo();
			}
		});
		this.comboFiltrar.setModel(new DefaultComboBoxModel(new String[] {"marca", "modelo", "ano"}));
		add(this.comboFiltrar, "cell 3 3,growx");
		
		this.comboBuscar = new JComboBox();
		this.comboBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(this.comboBuscar, "cell 5 3,growx");
		
		this.lblNewLabel_2 = new JLabel("Pesquisar:");
		add(this.lblNewLabel_2, "cell 1 5");
		
		this.textField = new JTextField();
		add(this.textField, "cell 3 5,growx");
		this.textField.setColumns(10);
		
		this.scrollPane = new JScrollPane();
		add(this.scrollPane, "cell 1 8 5 1,grow");
		
		this.table = new JTable();
		this.table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Marca", "Modelo", "Ano"
			}
		));
		this.scrollPane.setViewportView(this.table);
	}

	private void preencheCombo() {
		VeiculosDAO dao = new VeiculosDAO();
		LinkedList<String> nomes = dao.listarFuncionariosCombo(comboFiltrar.getSelectedItem().toString());
		for (String string : nomes) {
			comboBuscar.addItem(string);
		}
	}
}
