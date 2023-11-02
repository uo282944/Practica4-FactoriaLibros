package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import Interfaz.BlackThemeFactory;
import Interfaz.LightThemeFactory;
import Libro.Book;
import Libro.EBookFactory;
import Libro.PhysicalBookFactory;
import parse.AdultParser;
import parse.InfantilParser;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class MainWindow extends JFrame {

	private JPanel panelPrincipal;
	private JPanel panelSeleccionTema;
	private JButton btnTemaClaro;
	private JButton btnTemaOscuro;
	private JLabel lblTema;
	private JPanel panelSeleccionFormato;
	private JLabel lblSeleccionFormato;
	private JRadioButton rdbtnEbook;
	private JRadioButton rdbtnFisico;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblFormato;
	private JButton btnSiguiente;
	private JPanel panelLibroFisico;
	private JLabel lblTituloFisico;
	private JPanel panelEBook;
	private JLabel lblTituloEbook;
	
	private Cliente cliente;
	private JButton btnAtras;
	private JLabel lblEBook;
	private JLabel lblBook;
	private JPanel panelSeleccionEdad;
	private JLabel lblEdad;
	private JRadioButton rdbtnAdulto;
	private JRadioButton rdbtnNiño;
	private JLabel lblSeleccionLibro;
	private JComboBox<Book> cbAdulto;
	private JComboBox<Book> cbNiño;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JLabel lblAdulto;
	private JLabel lblNiño;
	private JButton btnSiguienteSelLibro;
	private JButton btnAtrasSelLibro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		cliente = new Cliente();
		
		setTitle("Visualizador de libros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 521);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(new CardLayout(0, 0));
		panelPrincipal.add(getPanelSeleccionTema(), "TEMA");
		panelPrincipal.add(getPanelSeleccionFormato(), "SELLIBRO");
		panelPrincipal.add(getPanelLibroFisico(), "LIBROFISICO");
		panelPrincipal.add(getPanelEBook(), "EBOOK");
		panelPrincipal.add(getPanelSeleccionEdad(), "SELEDAD");
	}

	private JPanel getPanelSeleccionTema() {
		if (panelSeleccionTema == null) {
			panelSeleccionTema = new JPanel();
			panelSeleccionTema.setBackground(Color.WHITE);
			panelSeleccionTema.setLayout(null);
			panelSeleccionTema.add(getBtnTemaClaro());
			panelSeleccionTema.add(getBtnTemaOscuro());
			panelSeleccionTema.add(getLblTema());
		}
		return panelSeleccionTema;
	}
	private JButton getBtnTemaClaro() {
		if (btnTemaClaro == null) {
			btnTemaClaro = new JButton("Tema Claro");
			btnTemaClaro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cliente.setAif(new LightThemeFactory());
					cambiarPantallaSeleccion();
					cambiarFondoYBotones(getPanelSeleccionFormato());
				}
			});
			btnTemaClaro.setFont(new Font("Tahoma", Font.BOLD, 25));
			btnTemaClaro.setBackground(Color.BLUE);
			btnTemaClaro.setForeground(Color.BLACK);
			btnTemaClaro.setBounds(44, 168, 330, 85);
		}
		return btnTemaClaro;
	}
	
	private void cambiarFondoYBotones(JPanel panel) {
		panel.setBackground(cliente.getAif().colorFondo().getColorFondo());
		for (int i = 0;i< panel.getComponents().length;i++) {
			if (panel.getComponent(i) instanceof JButton) {
				((JButton)panel.getComponent(i)).setBackground(cliente.getAif().colorBoton().getColorFondoBoton());
				((JButton)panel.getComponent(i)).setForeground(cliente.getAif().colorBoton().getColorLetras());
			}else if(panel.getComponent(i) instanceof JLabel){
				((JLabel)panel.getComponent(i)).setForeground(cliente.getAif().colorEtiqueta().getColorLetras());
			}
		}
	}
	
	private void cambiarPantallaSeleccion() {
		CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
        cl.show(panelPrincipal, "SELLIBRO");
	}
	
	private JButton getBtnTemaOscuro() {
		if (btnTemaOscuro == null) {
			btnTemaOscuro = new JButton("Tema Oscuro");
			btnTemaOscuro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cliente.setAif(new BlackThemeFactory());
					cambiarPantallaSeleccion();
					cambiarFondoYBotones(getPanelSeleccionFormato());
				}
			});
			btnTemaOscuro.setFont(new Font("Tahoma", Font.BOLD, 25));
			btnTemaOscuro.setBackground(Color.ORANGE);
			btnTemaOscuro.setBounds(44, 299, 330, 85);
		}
		return btnTemaOscuro;
	}
	private JLabel getLblTema() {
		if (lblTema == null) {
			lblTema = new JLabel("Elige tema para la interfaz");
			lblTema.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblTema.setBounds(48, 44, 360, 34);
		}
		return lblTema;
	}
	private JPanel getPanelSeleccionFormato() {
		if (panelSeleccionFormato == null) {
			panelSeleccionFormato = new JPanel();
			panelSeleccionFormato.setBackground(Color.WHITE);
			panelSeleccionFormato.setLayout(null);
			panelSeleccionFormato.add(getLblSeleccionFormato());
			panelSeleccionFormato.add(getRdbtnEbook());
			panelSeleccionFormato.add(getRdbtnFisico());
			panelSeleccionFormato.add(getLblFormato());
			panelSeleccionFormato.add(getBtnSiguiente());
			panelSeleccionFormato.add(getBtnAtras());
			panelSeleccionFormato.add(getLblEBook());
			panelSeleccionFormato.add(getLblBook());
		}
		return panelSeleccionFormato;
	}
	private JLabel getLblSeleccionFormato() {
		if (lblSeleccionFormato == null) {
			lblSeleccionFormato = new JLabel("Seleccion de Formato");
			lblSeleccionFormato.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblSeleccionFormato.setEnabled(true);
			lblSeleccionFormato.setBounds(65, 10, 323, 53);
		}
		return lblSeleccionFormato;
	}
	private JRadioButton getRdbtnEbook() {
		if (rdbtnEbook == null) {
			rdbtnEbook = new JRadioButton("EBook");
			rdbtnEbook.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/gui/img/ebook.png")));
			rdbtnEbook.setIcon(new ImageIcon(MainWindow.class.getResource("/gui/img/ebookNoSele.png")));
			rdbtnEbook.setSelected(true);
			buttonGroup.add(rdbtnEbook);
			rdbtnEbook.setBounds(54, 117, 120, 164);
		}
		return rdbtnEbook;
	}
	private JRadioButton getRdbtnFisico() {
		if (rdbtnFisico == null) {
			rdbtnFisico = new JRadioButton("Físico");
			rdbtnFisico.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/gui/img/book.png")));
			rdbtnFisico.setIcon(new ImageIcon(MainWindow.class.getResource("/gui/img/bookNoSele.png")));
			buttonGroup.add(rdbtnFisico);
			rdbtnFisico.setBounds(226, 117, 120, 164);
		}
		return rdbtnFisico;
	}
	private JLabel getLblFormato() {
		if (lblFormato == null) {
			lblFormato = new JLabel("Elegir formato");
			lblFormato.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblFormato.setBounds(140, 73, 208, 32);
		}
		return lblFormato;
	}
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					asignarFactoriaLibroCliente();
					crearLibros();
					cambiarFondoYBotones(getPanelSeleccionEdad());
					CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
			        cl.show(panelPrincipal, "SELEDAD");
				}
			});
			btnSiguiente.setBounds(140, 362, 128, 32);
		}
		return btnSiguiente;
	}
	
	private void asignarFactoriaLibroCliente() {
		if (rdbtnEbook.isSelected()) {
			cliente.setPf(new EBookFactory());
		}else {
			cliente.setPf(new PhysicalBookFactory());
		}
	}
	
	private void mostrarPantallaLibro() {
		CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
		if (rdbtnFisico.isSelected()) {
            cl.show(panelPrincipal, "LIBROFISICO");
		}else {
            cl.show(panelPrincipal, "EBOOK");
		}
	}
	
	private JPanel getPanelLibroFisico() {
		if (panelLibroFisico == null) {
			panelLibroFisico = new JPanel();
			panelLibroFisico.setBackground(Color.WHITE);
			panelLibroFisico.setLayout(null);
			panelLibroFisico.add(getLblTituloFisico());
		}
		return panelLibroFisico;
	}
	private JLabel getLblTituloFisico() {
		if (lblTituloFisico == null) {
			lblTituloFisico = new JLabel("Titulo Físico");
			lblTituloFisico.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblTituloFisico.setBounds(10, 10, 336, 40);
		}
		return lblTituloFisico;
	}
	private JPanel getPanelEBook() {
		if (panelEBook == null) {
			panelEBook = new JPanel();
			panelEBook.setBackground(Color.WHITE);
			panelEBook.setLayout(null);
			panelEBook.add(getLblTituloEbook());
		}
		return panelEBook;
	}
	private JLabel getLblTituloEbook() {
		if (lblTituloEbook == null) {
			lblTituloEbook = new JLabel("Titulo EBook");
			lblTituloEbook.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblTituloEbook.setBounds(10, 10, 336, 40);
		}
		return lblTituloEbook;
	}
	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atras");
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout cl = (CardLayout)(panelPrincipal.getLayout());
			        cl.show(panelPrincipal, "TEMA");
				}
			});
			btnAtras.setBounds(140, 406, 128, 32);
		}
		return btnAtras;
	}
	private JLabel getLblEBook() {
		if (lblEBook == null) {
			lblEBook = new JLabel("EBook");
			lblEBook.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblEBook.setBounds(94, 287, 75, 22);
		}
		return lblEBook;
	}
	private JLabel getLblBook() {
		if (lblBook == null) {
			lblBook = new JLabel("Book");
			lblBook.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblBook.setBounds(271, 287, 75, 22);
		}
		return lblBook;
	}
	private JPanel getPanelSeleccionEdad() {
		if (panelSeleccionEdad == null) {
			panelSeleccionEdad = new JPanel();
			panelSeleccionEdad.setBackground(Color.WHITE);
			panelSeleccionEdad.setLayout(null);
			panelSeleccionEdad.add(getLblEdad_1());
			panelSeleccionEdad.add(getRdbtnAdulto());
			panelSeleccionEdad.add(getRdbtnNiño());
			panelSeleccionEdad.add(getLblSeleccionLibro());
			panelSeleccionEdad.add(getCbAdulto());
			panelSeleccionEdad.add(getCbNiño());
			panelSeleccionEdad.add(getLblAdulto());
			panelSeleccionEdad.add(getLblNiño());
			panelSeleccionEdad.add(getBtnSiguienteSelLibro());
			panelSeleccionEdad.add(getBtnAtrasSelLibro());
		}
		return panelSeleccionEdad;
	}
	private JLabel getLblEdad_1() {
		if (lblEdad == null) {
			lblEdad = new JLabel("Elegir edad");
			lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblEdad.setBounds(151, 73, 122, 25);
		}
		return lblEdad;
	}
	private JRadioButton getRdbtnAdulto() {
		if (rdbtnAdulto == null) {
			rdbtnAdulto = new JRadioButton("Adulto");
			rdbtnAdulto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getCbAdulto().setVisible(true);getCbAdulto().setEnabled(true);
					getCbNiño().setVisible(false);getCbNiño().setEnabled(false);
				}
			});
			buttonGroup_1.add(rdbtnAdulto);
			rdbtnAdulto.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/gui/img/adulto.png")));
			rdbtnAdulto.setIcon(new ImageIcon(MainWindow.class.getResource("/gui/img/adultoNoSele.png")));
			rdbtnAdulto.setSelected(true);
			rdbtnAdulto.setBounds(68, 125, 122, 162);
		}
		return rdbtnAdulto;
	}
	private JRadioButton getRdbtnNiño() {
		if (rdbtnNiño == null) {
			rdbtnNiño = new JRadioButton("Niño");
			rdbtnNiño.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getCbAdulto().setVisible(false);getCbAdulto().setEnabled(false);
					getCbNiño().setVisible(true);getCbNiño().setEnabled(true);
				}
			});
			buttonGroup_1.add(rdbtnNiño);
			rdbtnNiño.setIcon(new ImageIcon(MainWindow.class.getResource("/gui/img/niñoNoSele.png")));
			rdbtnNiño.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/gui/img/niño.png")));
			rdbtnNiño.setBounds(226, 125, 122, 162);
		}
		return rdbtnNiño;
	}
	private JLabel getLblSeleccionLibro() {
		if (lblSeleccionLibro == null) {
			lblSeleccionLibro = new JLabel("Seleccion de Libro");
			lblSeleccionLibro.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblSeleccionLibro.setEnabled(true);
			lblSeleccionLibro.setBounds(92, 10, 283, 53);
		}
		return lblSeleccionLibro;
	}
	private JComboBox<Book> getCbAdulto() {
		if (cbAdulto == null) {
			cbAdulto = new JComboBox();
			cbAdulto.setBounds(68, 327, 280, 21);
		}
		return cbAdulto;
	}
	private JComboBox<Book> getCbNiño() {
		if (cbNiño == null) {
			cbNiño = new JComboBox();
			cbNiño.setEnabled(false);
			cbNiño.setVisible(false);
			cbNiño.setBounds(68, 327, 280, 21);
		}
		return cbNiño;
	}

	private void crearLibros(){
		getCbNiño().removeAllItems();
		getCbAdulto().removeAllItems();
		new InfantilParser(cliente.getPf()).getBooks().stream()
				.forEach(ibook -> {
					getCbAdulto().addItem(ibook);
				});

		new AdultParser(cliente.getPf()).getBooks().stream()
				.forEach(abook -> {
					getCbAdulto().addItem(abook);
				});
	}
	
	private JLabel getLblAdulto() {
		if (lblAdulto == null) {
			lblAdulto = new JLabel("Adulto");
			lblAdulto.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblAdulto.setBounds(105, 293, 60, 22);
		}
		return lblAdulto;
	}
	private JLabel getLblNiño() {
		if (lblNiño == null) {
			lblNiño = new JLabel("Niño");
			lblNiño.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNiño.setBounds(269, 295, 60, 22);
		}
		return lblNiño;
	}
	private JButton getBtnSiguienteSelLibro() {
		if (btnSiguienteSelLibro == null) {
			btnSiguienteSelLibro = new JButton("Siguiente");
			btnSiguienteSelLibro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarFondoYBotones(getPanelEBook());cambiarFondoYBotones(getPanelLibroFisico());
					mostrarPantallaLibro();
				}
			});
			btnSiguienteSelLibro.setBounds(145, 368, 128, 32);
		}
		return btnSiguienteSelLibro;
	}
	private JButton getBtnAtrasSelLibro() {
		if (btnAtrasSelLibro == null) {
			btnAtrasSelLibro = new JButton("Atras");
			btnAtrasSelLibro.setBounds(145, 412, 128, 32);
		}
		return btnAtrasSelLibro;
	}
}
