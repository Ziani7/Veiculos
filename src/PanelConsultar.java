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

	
	public PanelConsultar() {
		initComponents();
		preencheTabInicio();
	}
	private void initComponents() {
		setLayout(new MigLayout("", "[grow][][][grow][][grow][grow]", "[][][][][][][][grow][grow]"));
		
		this.lblNewLabel = new JLabel("Consultar Ve\u00EDculos");
		add(this.lblNewLabel, "cell 1 1 5 1,alignx center");
		
		this.lblNewLabel_1 = new JLabel("Buscar por:");
		add(this.lblNewLabel_1, "cell 1 3,alignx trailing");
		
		this.comboFiltrar = new JComboBox();
		this.comboFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBuscar.removeAllItems();
				preencheCombo();
			}
		});
		this.comboFiltrar.setModel(new DefaultComboBoxModel(new String[] {"marca", "modelo", "ano"}));
		add(this.comboFiltrar, "cell 3 3,growx");
		
		this.comboBuscar = new JComboBox();
		this.comboBuscar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (comboBuscar.getSelectedItem() != null) {
		            preencheTabela();
		        }
		    }
		});
		add(this.comboBuscar, "cell 5 3,growx");
		
		this.scrollPane = new JScrollPane();
		add(this.scrollPane, "cell 1 7 5 1,grow");
		
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
	    comboBuscar.removeAllItems();
	    VeiculosDAO dao = new VeiculosDAO();
	    LinkedList<String> nomes = dao.listarVeiculosCombo(comboFiltrar.getSelectedItem().toString());
	    if (nomes != null && !nomes.isEmpty()) {
	        for (String string : nomes) {
	            comboBuscar.addItem(string);
	        }
	    } else {
	        comboBuscar.addItem("Nenhum resultado");
	    }
	}
	
	private void preencheTabela() {
	    if (comboBuscar.getSelectedItem() == null || 
	        "Nenhum resultado".equals(comboBuscar.getSelectedItem())) {
	    }
	    VeiculosDAO vdao = new VeiculosDAO();
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0);
	    LinkedList<Veiculos> lista = vdao.listarVeiculos(comboFiltrar.getSelectedItem().toString(), comboBuscar.getSelectedItem().toString());
	    for (Veiculos veiculos : lista) {
	        model.addRow(veiculos.toLinha());
	    }
	}
	
	private void preencheTabInicio() {
		VeiculosDAO vdao = new VeiculosDAO();
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0);
	    LinkedList<Veiculos> lista = vdao.listarTodos();
	    for (Veiculos veiculos : lista) {
	        model.addRow(veiculos.toLinha());
	    }
	}
}
