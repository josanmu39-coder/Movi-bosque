package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import co.edu.unbosque.controller.Controller;
import co.edu.unbosque.view.PanelFondo;
import co.edu.unbosque.model.*;

public class Ventana extends JFrame {

	private final Controller controller;
	private CardLayout cambioVentanas;
	private JPanel ventanaGrande;
	private Image imagen;
	private String horarioSeleccionado = "";
	private String rolSeleccionado = "";
	private String paradaSeleccionada = "";

	public Ventana(Controller controller) {
		this.controller = controller;
		setTitle("Movibosque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		setLocationRelativeTo(null);
		cambioVentanas = new CardLayout();
		ventanaGrande = new JPanel(cambioVentanas);
		ventanaGrande.add(pantallaDeInicio(), "menu");
		ventanaGrande.add(pantallaDelProfesor(), "profesor");
		ventanaGrande.add(pantallaDelAdministrador(), "administrador");
		ventanaGrande.add(pantallaDelEstudiante(), "estudiante");
		ventanaGrande.add(pantallaDeReservas(), "reservas");
		ventanaGrande.add(pantallaDeReservasTren(), "reservasTren");
		ventanaGrande.add(pantallaDeReservasBus(), "reservasBus");
		ventanaGrande.add(pantallaMirarReservas(), "MirarReserva");
		ventanaGrande.add(pantallaDeReservasAdmin(), "ReservasAdmin");
		add(ventanaGrande);
	}

	public JPanel pantallaDeInicio() {

		PanelFondo fondo = new PanelFondo();
		fondo.setLayout(new GridBagLayout());
		JPanel panelBotones = new JPanel();
		panelBotones.setOpaque(false);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
		JButton profesor = new JButton("Profesor");
		JButton estudiante = new JButton("Estudiante");
		JButton admin = new JButton("Administrador");

		profesor.addActionListener(e -> {
			rolSeleccionado = "profesor";
			ventanaGrande.add(pantallaRegistro(), "registro");
			cambioVentanas.show(ventanaGrande, "registro");
		});
		panelBotones.add(profesor);
		panelBotones.add(Box.createVerticalStrut(10));

		estudiante.addActionListener(e -> {
			rolSeleccionado = "estudiante";
			ventanaGrande.add(pantallaRegistro(), "registro");
			cambioVentanas.show(ventanaGrande, "registro");
		});
		panelBotones.add(estudiante);
		panelBotones.add(Box.createVerticalStrut(10));
		admin.addActionListener(e -> {
			rolSeleccionado = "administrador";
			ventanaGrande.add(pantallaRegistro(), "registro");
			cambioVentanas.show(ventanaGrande, "registro");
		});
		panelBotones.add(admin);
		panelBotones.add(Box.createVerticalStrut(10));
		fondo.add(panelBotones);
		return fondo;

	}

	private JPanel pantallaRegistro() {

		PanelFondo fondo = new PanelFondo();
		fondo.setLayout(new GridBagLayout());
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel titulo = new JLabel("Registro de Usuario");
		JTextField nombre = new JTextField(15);
		JTextField tipoDocumento = new JTextField(15);
		JTextField documento = new JTextField(15);
		JTextField facultad = new JTextField(15);
		JTextField edad = new JTextField(15);
		JTextField telefono = new JTextField(15);
		JTextField correo = new JTextField(15);
		
		JTextField semestre = new JTextField(15);
		JTextField anioExperiencia = new JTextField(15);
		JButton registrar = new JButton("Registrar");
		JButton volver = new JButton("Volver");

		panel.add(titulo);
		panel.add(new JLabel("Nombre"));
		panel.add(nombre);
		panel.add(new JLabel("Tipo de documento"));
		panel.add(tipoDocumento);
		panel.add(new JLabel("Documento"));
		panel.add(documento);
		panel.add(new JLabel("Facultad"));
		panel.add(facultad);
		panel.add(new JLabel("Edad"));
		panel.add(edad);
		panel.add(new JLabel("Telefono"));
		panel.add(telefono);
		panel.add(new JLabel("Correo"));
		panel.add(correo);
		
		if (rolSeleccionado.equals("estudiante")) {
	        panel.add(new JLabel("Semestre"));
	        panel.add(semestre);
	    } else if (rolSeleccionado.equals("administrador")) {
	        panel.add(new JLabel("Años de servicio"));
	        panel.add(anioExperiencia);
	    }
		panel.add(registrar);
		panel.add(volver);
		volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, "Administrador"));
		registrar.addActionListener(e -> {
			if (rolSeleccionado.equals("estudiante")) {
				Estudiante est = controller.agregarEstudiante(nombre.getText(), tipoDocumento.getText(),
						documento.getText(), facultad.getText(), Short.parseShort(edad.getText()),
						Long.parseLong(telefono.getText()), correo.getText(),semestre.getText());
				controller.iniciarSesion(est);
				JOptionPane.showMessageDialog(null, "Estudiante registrado");
			} else if (rolSeleccionado.equals("profesor")) {
				Docente prof = new Docente(nombre.getText(), tipoDocumento.getText(), documento.getText(),
						facultad.getText(), Short.parseShort(edad.getText()), Long.parseLong(telefono.getText()),
						correo.getText());
				controller.iniciarSesion(prof);
				JOptionPane.showMessageDialog(null, "Profesor registrado");
			} else if (rolSeleccionado.equals("administrador")) {
				Administrativo admin = new Administrativo(nombre.getText(), tipoDocumento.getText(),
						documento.getText(), facultad.getText(), Short.parseShort(edad.getText()),
						Long.parseLong(telefono.getText()), correo.getText(), Integer.parseInt(anioExperiencia.getText()));
				controller.iniciarSesion(admin);
				JOptionPane.showMessageDialog(null, "Administrador registrado");
			}
			cambioVentanas.show(ventanaGrande, "Administrador");
		});
		fondo.add(panel);
		return fondo;
	}

	public JPanel pantallaMirarReservas() {
		JPanel panel = new JPanel();
		JButton mirarReserva = new JButton("Mirar reservas");
		mirarReserva.addActionListener(e -> {
			String reservas = controller.getUsuarioActual().mostrarReservas();
			JOptionPane.showMessageDialog(null, reservas);
		});
		panel.add(mirarReserva);
		return panel;
	}

	public JPanel pantallaDelProfesor() {

		PanelFondo fondo = new PanelFondo();
		fondo.setLayout(new GridBagLayout());
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BorderLayout());
		JLabel titulo = new JLabel("Panel Profesor", JLabel.CENTER);
		JButton volver = new JButton("Volver");
		JButton mirarReserva = new JButton("Mirar sus reservas");
		JButton hacerReserva = new JButton("hacer reserva");
		mirarReserva.addActionListener(e -> {
			String reservas = controller.getUsuarioActual().mostrarReservas();
			JOptionPane.showMessageDialog(null, reservas);
		});
		volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, "menu"));
		JPanel reservaBotones = new JPanel();
		panel.add(titulo, BorderLayout.CENTER);
		panel.add(volver, BorderLayout.SOUTH);
		reservaBotones.add(mirarReserva);
		reservaBotones.add(hacerReserva);
		panel.add(reservaBotones, BorderLayout.NORTH);
		fondo.add(panel);
		return fondo;
	}

	private JPanel pantallaDelAdministrador() {
		PanelFondo fondo = new PanelFondo();
		fondo.setLayout(new GridBagLayout());
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BorderLayout());

		JLabel titulo = new JLabel("Panel Administrador", JLabel.CENTER);
		JButton volver = new JButton("Volver");

		JPanel botonesCRUD = new JPanel();
		botonesCRUD.setOpaque(false);
		botonesCRUD.setLayout(new GridLayout(4, 3, 10, 10));

		JButton agregarEstudiante = new JButton("Agregar Estudiante");
		agregarEstudiante.addActionListener(e -> agregarEstudiante());
		JButton verEstudiante = new JButton("Ver Estudiante");
		verEstudiante.addActionListener(e -> {
			String estudiantes = controller.mostrarEstudiantes();
			JOptionPane.showMessageDialog(null, estudiantes);
		});
		botonesCRUD.add(agregarEstudiante);
		botonesCRUD.add(verEstudiante);
		botonesCRUD.add(new JButton("Actualizar Estudiante") {{
		    addActionListener(e -> actualizarEstudiante());
		}});
		botonesCRUD.add(new JButton("Eliminar Estudiante") {{
		    addActionListener(e -> eliminarEstudiante());
		}});

		JButton agregarDocente = new JButton("Agregar Docente");
		agregarDocente.addActionListener(e -> agregarDocente());
		JButton verDocente = new JButton("Ver Docente");
		verDocente.addActionListener(e -> {
			String docentes = controller.mostrarDocentes();
			JOptionPane.showMessageDialog(null, docentes);
		});
		botonesCRUD.add(agregarDocente);
		botonesCRUD.add(verDocente);
		botonesCRUD.add(new JButton("Actualizar Docente") {{
		    addActionListener(e -> actualizarDocente());
		}});
		botonesCRUD.add(new JButton("Eliminar Docente") {{
		    addActionListener(e -> eliminarDocente());
		}});

		JButton agregarAdministrativo = new JButton("Agregar Administrativo");
		agregarAdministrativo.addActionListener(e -> agregarAdministrativo());
		JButton verAdministrativo = new JButton("Ver Administrativo");
		verAdministrativo.addActionListener(e -> {
			String administrativos = controller.mostrarAdministrativos();
			JOptionPane.showMessageDialog(null, administrativos);
		});
		botonesCRUD.add(agregarAdministrativo);
		botonesCRUD.add(verAdministrativo);
		botonesCRUD.add(new JButton("Actualizar Administrativo") {{
		    addActionListener(e -> actualizarAdministrativo());
		}});
		botonesCRUD.add(new JButton("Eliminar Administrativo") {{
		    addActionListener(e -> eliminarAdministrativo());
		}});

		volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, "menu"));

		panel.add(titulo, BorderLayout.NORTH);
		panel.add(botonesCRUD, BorderLayout.CENTER);
		panel.add(volver, BorderLayout.SOUTH);

		fondo.add(panel);
		return fondo;
	}

	private JPanel pantallaDelEstudiante() {

		PanelFondo fondo = new PanelFondo();
		fondo.setLayout(new GridBagLayout());
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BorderLayout());
		JLabel titulo = new JLabel("Panel Estudiante", JLabel.CENTER);
		JButton volver = new JButton("volver al menu");
		JButton mirarReserva = new JButton("Mirar sus reservas");
		JButton hacerReserva = new JButton("hacer reserva");
		JPanel botonesDeReserva = new JPanel();
		mirarReserva.addActionListener(e -> {
			String reservas = controller.getUsuarioActual().mostrarReservas();
			JOptionPane.showMessageDialog(null, reservas);
		});
		botonesDeReserva.setOpaque(false);
		hacerReserva.addActionListener(e -> cambioVentanas.show(ventanaGrande, "reservas"));
		volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, "menu"));
		botonesDeReserva.add(mirarReserva);
		botonesDeReserva.add(hacerReserva);
		panel.add(titulo, BorderLayout.CENTER);
		panel.add(volver, BorderLayout.SOUTH);
		panel.add(botonesDeReserva, BorderLayout.NORTH);

		fondo.add(panel);
		return fondo;
	}

	private JPanel pantallaDeReservas() {

		PanelFondo fondo = new PanelFondo();
		fondo.setLayout(new GridBagLayout());
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel titulo = new JLabel("Reservas UnBosque", JLabel.CENTER);

		ImageIcon tren = new ImageIcon(getClass().getResource("entradaTren.jpeg"));
		Image imagenTren = tren.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		tren = new ImageIcon(imagenTren);
		JLabel imagenTrenL = new JLabel(tren);
		JButton reservarTren = new JButton("Reservar Tren");

		ImageIcon bus = new ImageIcon(getClass().getResource("bus.jpeg"));
		Image imagenBus = bus.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		bus = new ImageIcon(imagenBus);
		JLabel imagenBusL = new JLabel(bus);

		JButton reservarBus = new JButton("Reservar Bus");
		JButton volver = new JButton("Volver al menú");

		reservarTren.addActionListener(e -> cambioVentanas.show(ventanaGrande, "reservasTren"));
		reservarBus.addActionListener(e -> cambioVentanas.show(ventanaGrande, "reservasBus"));
		volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, "reservas"));
		panel.add(titulo);
		panel.add(Box.createVerticalStrut(20));
		panel.add(imagenTrenL);
		panel.add(reservarTren);
		panel.add(Box.createVerticalStrut(20));
		panel.add(imagenBusL);
		panel.add(reservarBus);
		panel.add(Box.createVerticalStrut(20));
		panel.add(volver);
		fondo.add(panel);
		return fondo;
	}

	private JPanel pantallaDeReservasTren() {

		JPanel paradas = new JPanel();
		paradas.setLayout(new GridLayout(2, 3, 10, 10));
		PanelFondo fondo = new PanelFondo();
		JPanel panel = new JPanel();
		JButton reservar = new JButton("Reservar");
		JLabel titulo = new JLabel("Reservas de Tren", JLabel.CENTER);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton volver = new JButton("Volver a las reservas");
		JLabel textoParadas = new JLabel("Seleccione parada", JLabel.CENTER);
		textoParadas.setAlignmentX(Component.CENTER_ALIGNMENT);
		JPanel horarios = new JPanel();
		JPanel panelPagos = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelPagos.setOpaque(false);
		JButton pagos = new JButton("Pagos");
		JLabel total = new JLabel("Su total a pagar es:");
		horarios.setAlignmentX(Component.CENTER_ALIGNMENT);
		paradas.setAlignmentX(Component.CENTER_ALIGNMENT);
		reservar.setAlignmentX(Component.CENTER_ALIGNMENT);
		volver.setAlignmentX(Component.CENTER_ALIGNMENT);
		horarios.setOpaque(false);
		paradas.setOpaque(false);
		panel.setOpaque(false);
		fondo.setLayout(new GridBagLayout());
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(textoParadas);
		panelPagos.add(pagos);
		panelPagos.add(total);
		panel.add(paradas);
		panel.add(Box.createVerticalStrut(20));
		JButton p1 = new JButton("Campus chia");
		JButton p2 = new JButton("Calle 170");
		JButton p3 = new JButton("Calle 146");
		JButton p4 = new JButton("Universidad");
		JButton p5 = new JButton("Cra 30");
		JButton p6 = new JButton("Gran estacion");
		p1.addActionListener(e -> paradaSeleccionada = "Portal Norte");
		p2.addActionListener(e -> paradaSeleccionada = "Calle 170");
		p3.addActionListener(e -> paradaSeleccionada = "Calle 127");
		p4.addActionListener(e -> paradaSeleccionada = "Calle 100");
		p5.addActionListener(e -> paradaSeleccionada = "Calle 72");
		p6.addActionListener(e -> paradaSeleccionada = "Universidad");

		JButton h1 = new JButton("08:00");
		JButton h2 = new JButton("10:00");
		JButton h3 = new JButton("12:00");
		JButton h4 = new JButton("15:00");
		h1.addActionListener(e -> horarioSeleccionado = "08:00");
		h2.addActionListener(e -> horarioSeleccionado = "10:00");
		h3.addActionListener(e -> horarioSeleccionado = "12:00");
		h4.addActionListener(e -> horarioSeleccionado = "15:00");

		reservar.addActionListener(e -> {
			if (horarioSeleccionado.equals("") || paradaSeleccionada.equals("")) {
				JOptionPane.showMessageDialog(null, "Seleccione horario y parada");
			} else {
				controller.reservarTren(horarioSeleccionado);
				JOptionPane.showMessageDialog(null,
						"Reserva hecha\nHora: " + horarioSeleccionado +
						"\nParada: " + paradaSeleccionada);
			}
		});

		volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, "reservas"));
		paradas.add(p1);
		paradas.add(p2);
		paradas.add(p3);
		paradas.add(p4);
		paradas.add(p5);
		paradas.add(p6);
		horarios.add(h1);
		horarios.add(h2);
		horarios.add(h3);
		horarios.add(h4);
		panel.add(titulo);
		panel.add(Box.createVerticalStrut(20));
		panel.add(horarios);
		panel.add(Box.createVerticalStrut(20));
		panel.add(reservar);
		panel.add(Box.createVerticalStrut(20));
		panel.add(panelPagos);
		panel.add(volver);
		fondo.add(panel);
		return fondo;
	}

	private JPanel pantallaDeReservasBus() {

		PanelFondo fondo = new PanelFondo();
		fondo.setLayout(new GridBagLayout());
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel titulo = new JLabel("Reservas del bus");
		JButton reservar = new JButton("Reservar");
		JButton volver = new JButton("Volver al menú");
		JPanel horarios = new JPanel();
		horarios.setOpaque(false);

		JButton h1 = new JButton("08:00");
		JButton h2 = new JButton("10:00");
		JButton h3 = new JButton("12:00");
		JButton h4 = new JButton("16:00");

		h1.addActionListener(e -> horarioSeleccionado = "08:00");
		h2.addActionListener(e -> horarioSeleccionado = "10:00");
		h3.addActionListener(e -> horarioSeleccionado = "12:00");
		h4.addActionListener(e -> horarioSeleccionado = "16:00");

		reservar.addActionListener(e -> {
			if (horarioSeleccionado.equals("")) {
				JOptionPane.showMessageDialog(null, "Seleccione un horario primero");
			} else {
				JOptionPane.showMessageDialog(null, "Reserva hecha para las " + horarioSeleccionado);
			}
		});

		volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, "reservas"));
		horarios.add(h1);
		horarios.add(h2);
		horarios.add(h3);
		horarios.add(h4);
		panel.add(titulo);
		panel.add(Box.createVerticalStrut(20));
		panel.add(horarios);
		panel.add(Box.createVerticalStrut(20));
		panel.add(reservar);
		panel.add(volver);
		fondo.add(panel);
		return fondo;
	}

	private JPanel pantallaDeReservasAdmin() {
		PanelFondo fondo = new PanelFondo();
		fondo.setLayout(new GridBagLayout());
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel titulo = new JLabel("Reservas UnBosque", JLabel.CENTER);

		ImageIcon tren = new ImageIcon(getClass().getResource("entradaTren.jpeg"));
		Image imagenTren = tren.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		tren = new ImageIcon(imagenTren);
		JLabel imagenTrenL = new JLabel(tren);
		JButton reservarTren = new JButton("Reservar Tren");
		JButton volver = new JButton("Volver al menú");

		reservarTren.addActionListener(e -> cambioVentanas.show(ventanaGrande, "reservasTren"));
		volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, rolSeleccionado));
		panel.add(titulo);
		panel.add(Box.createVerticalStrut(20));
		panel.add(imagenTrenL);
		panel.add(reservarTren);
		panel.add(volver);
		fondo.add(panel);
		return fondo;
	}

	public void agregarEstudiante() {
		PanelFondo fondo = new PanelFondo();
		fondo.setLayout(new GridBagLayout());
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel titulo = new JLabel("Agregar Estudiante");
		JTextField nombre = new JTextField(15);
		JTextField tipoDocumento = new JTextField(15);
		JTextField documento = new JTextField(15);
		JTextField facultad = new JTextField(15);
		JTextField edad = new JTextField(15);
		JTextField telefono = new JTextField(15);
		JTextField correo = new JTextField(15);
		JTextField semestre = new JTextField(15);
		JButton registrar = new JButton("Registrar");
		JButton volver = new JButton("Volver");

		panel.add(titulo);
		panel.add(new JLabel("Nombre"));
		panel.add(nombre);
		panel.add(new JLabel("Tipo de documento"));
		panel.add(tipoDocumento);
		panel.add(new JLabel("Documento"));
		panel.add(documento);
		panel.add(new JLabel("Facultad"));
		panel.add(facultad);
		panel.add(new JLabel("Edad"));
		panel.add(edad);
		panel.add(new JLabel("Teléfono"));
		panel.add(telefono);
		panel.add(new JLabel("Correo"));
		panel.add(correo);
		panel.add(new JLabel("Semestre"));
		panel.add(semestre);
		panel.add(registrar);
		panel.add(volver);

		volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, "Administrador"));
		registrar.addActionListener(e -> {
			controller.agregarEstudiante(nombre.getText(), tipoDocumento.getText(), documento.getText(), facultad.getText(),
					Short.parseShort(edad.getText()), Long.parseLong(telefono.getText()), correo.getText(), semestre.getText());
			JOptionPane.showMessageDialog(null, "Estudiante registrado correctamente");
			cambioVentanas.show(ventanaGrande, "Administrador");
		});

		fondo.add(panel);
		ventanaGrande.add(fondo, "agregarEstudiante");
		cambioVentanas.show(ventanaGrande, "agregarEstudiante");
	}

	public void agregarDocente() {
		PanelFondo fondo = new PanelFondo();
		fondo.setLayout(new GridBagLayout());
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel titulo = new JLabel("Agregar Docente");
		JTextField nombre = new JTextField(15);
		JTextField tipoDocumento = new JTextField(15);
		JTextField documento = new JTextField(15);
		JTextField facultad = new JTextField(15);
		JTextField edad = new JTextField(15);
		JTextField telefono = new JTextField(15);
		JTextField correo = new JTextField(15);
		JButton registrar = new JButton("Registrar");
		JButton volver = new JButton("Volver");

		panel.add(titulo);
		panel.add(new JLabel("Nombre"));
		panel.add(nombre);
		panel.add(new JLabel("Tipo de documento"));
		panel.add(tipoDocumento);
		panel.add(new JLabel("Documento"));
		panel.add(documento);
		panel.add(new JLabel("Facultad"));
		panel.add(facultad);
		panel.add(new JLabel("Edad"));
		panel.add(edad);
		panel.add(new JLabel("Teléfono"));
		panel.add(telefono);
		panel.add(new JLabel("Correo"));
		panel.add(correo);
		panel.add(registrar);
		panel.add(volver);

		volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, "Administrador"));
		registrar.addActionListener(e -> {
			controller.agregarDocente(nombre.getText(), tipoDocumento.getText(), documento.getText(), facultad.getText(),
					Short.parseShort(edad.getText()), Long.parseLong(telefono.getText()), correo.getText());
			JOptionPane.showMessageDialog(null, "Docente registrado correctamente");
			cambioVentanas.show(ventanaGrande, "Administrador");
		});

		fondo.add(panel);
		ventanaGrande.add(fondo, "agregarDocente");
		cambioVentanas.show(ventanaGrande, "agregarDocente");
	}

	public void agregarAdministrativo() {
		PanelFondo fondo = new PanelFondo();
		fondo.setLayout(new GridBagLayout());
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel titulo = new JLabel("Agregar Administrativo");
		JTextField nombre = new JTextField(15);
		JTextField tipoDocumento = new JTextField(15);
		JTextField documento = new JTextField(15);
		JTextField facultad = new JTextField(15);
		JTextField edad = new JTextField(15);
		JTextField telefono = new JTextField(15);
		JTextField correo = new JTextField(15);
		JTextField aniosServicio = new JTextField(15);
		JButton registrar = new JButton("Registrar");
		JButton volver = new JButton("Volver");

		panel.add(titulo);
		panel.add(new JLabel("Nombre"));
		panel.add(nombre);
		panel.add(new JLabel("Tipo de documento"));
		panel.add(tipoDocumento);
		panel.add(new JLabel("Documento"));
		panel.add(documento);
		panel.add(new JLabel("Facultad"));
		panel.add(facultad);
		panel.add(new JLabel("Edad"));
		panel.add(edad);
		panel.add(new JLabel("Teléfono"));
		panel.add(telefono);
		panel.add(new JLabel("Correo"));
		panel.add(correo);
		panel.add(new JLabel("Años de servicio"));
		panel.add(aniosServicio);
		panel.add(registrar);
		panel.add(volver);

		volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, "Administrador"));
		registrar.addActionListener(e -> {
			controller.agregarAdministrativo(nombre.getText(), tipoDocumento.getText(), documento.getText(), facultad.getText(),
					Short.parseShort(edad.getText()), Long.parseLong(telefono.getText()), correo.getText(),
					Integer.parseInt(aniosServicio.getText()));
			JOptionPane.showMessageDialog(null, "Administrativo registrado correctamente");
			cambioVentanas.show(ventanaGrande, "Administrador");
		});

		fondo.add(panel);
		ventanaGrande.add(fondo, "agregarAdministrativo");
		cambioVentanas.show(ventanaGrande, "agregarAdministrativo");
	}

	public void actualizarEstudiante() {
	    PanelFondo fondo = new PanelFondo();
	    fondo.setLayout(new GridBagLayout());
	    JPanel panel = new JPanel();
	    panel.setOpaque(false);
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    JLabel titulo = new JLabel("Actualizar Estudiante");
	    JTextField index = new JTextField(15);
	    JTextField nombre = new JTextField(15);
	    JTextField tipoDocumento = new JTextField(15);
	    JTextField documento = new JTextField(15);
	    JTextField facultad = new JTextField(15);
	    JTextField edad = new JTextField(15);
	    JTextField telefono = new JTextField(15);
	    JTextField correo = new JTextField(15);
	    JTextField semestre = new JTextField(15);
	    JButton actualizar = new JButton("Actualizar");
	    JButton volver = new JButton("Volver");

	    panel.add(titulo);
	    panel.add(new JLabel("Índice"));
	    panel.add(index);
	    panel.add(new JLabel("Nombre"));
	    panel.add(nombre);
	    panel.add(new JLabel("Tipo de documento"));
	    panel.add(tipoDocumento);
	    panel.add(new JLabel("Documento"));
	    panel.add(documento);
	    panel.add(new JLabel("Facultad"));
	    panel.add(facultad);
	    panel.add(new JLabel("Edad"));
	    panel.add(edad);
	    panel.add(new JLabel("Teléfono"));
	    panel.add(telefono);
	    panel.add(new JLabel("Correo"));
	    panel.add(correo);
	    panel.add(new JLabel("Semestre"));
	    panel.add(semestre);
	    panel.add(actualizar);
	    panel.add(volver);

	    volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, "Administrador"));
	    actualizar.addActionListener(e -> {
	        int idx = Integer.parseInt(index.getText());
	        Estudiante estudiante = new Estudiante(nombre.getText(), tipoDocumento.getText(), documento.getText(),
	                facultad.getText(), Short.parseShort(edad.getText()), Long.parseLong(telefono.getText()),
	                correo.getText(), semestre.getText());
	        boolean resultado = controller.getEDAO().actualizar(idx, estudiante);
	        if (resultado) {
	            JOptionPane.showMessageDialog(null, "Estudiante actualizado correctamente");
	        } else {
	            JOptionPane.showMessageDialog(null, "Error al actualizar el estudiante");
	        }
	        cambioVentanas.show(ventanaGrande, "Administrador");
	    });

	    fondo.add(panel);
	    ventanaGrande.add(fondo, "actualizarEstudiante");
	    cambioVentanas.show(ventanaGrande, "actualizarEstudiante");
	}

	public void actualizarDocente() {
	    PanelFondo fondo = new PanelFondo();
	    fondo.setLayout(new GridBagLayout());
	    JPanel panel = new JPanel();
	    panel.setOpaque(false);
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    JLabel titulo = new JLabel("Actualizar Docente");
	    JTextField index = new JTextField(15);
	    JTextField nombre = new JTextField(15);
	    JTextField tipoDocumento = new JTextField(15);
	    JTextField documento = new JTextField(15);
	    JTextField facultad = new JTextField(15);
	    JTextField edad = new JTextField(15);
	    JTextField telefono = new JTextField(15);
	    JTextField correo = new JTextField(15);
	    JButton actualizar = new JButton("Actualizar");
	    JButton volver = new JButton("Volver");

	    panel.add(titulo);
	    panel.add(new JLabel("Índice"));
	    panel.add(index);
	    panel.add(new JLabel("Nombre"));
	    panel.add(nombre);
	    panel.add(new JLabel("Tipo de documento"));
	    panel.add(tipoDocumento);
	    panel.add(new JLabel("Documento"));
	    panel.add(documento);
	    panel.add(new JLabel("Facultad"));
	    panel.add(facultad);
	    panel.add(new JLabel("Edad"));
	    panel.add(edad);
	    panel.add(new JLabel("Teléfono"));
	    panel.add(telefono);
	    panel.add(new JLabel("Correo"));
	    panel.add(correo);
	    panel.add(actualizar);
	    panel.add(volver);

	    volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, "Administrador"));
	    actualizar.addActionListener(e -> {
	        int idx = Integer.parseInt(index.getText());
	        Docente docente = new Docente(nombre.getText(), tipoDocumento.getText(), documento.getText(), facultad.getText(),
	                Short.parseShort(edad.getText()), Long.parseLong(telefono.getText()), correo.getText());
	        boolean resultado = controller.getDDAO().actualizar(idx, docente);
	        if (resultado) {
	            JOptionPane.showMessageDialog(null, "Docente actualizado correctamente");
	        } else {
	            JOptionPane.showMessageDialog(null, "Error al actualizar el docente");
	        }
	        cambioVentanas.show(ventanaGrande, "Administrador");
	    });

	    fondo.add(panel);
	    ventanaGrande.add(fondo, "actualizarDocente");
	    cambioVentanas.show(ventanaGrande, "actualizarDocente");
	}

	public void actualizarAdministrativo() {
	    PanelFondo fondo = new PanelFondo();
	    fondo.setLayout(new GridBagLayout());
	    JPanel panel = new JPanel();
	    panel.setOpaque(false);
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    JLabel titulo = new JLabel("Actualizar Administrativo");
	    JTextField index = new JTextField(15);
	    JTextField nombre = new JTextField(15);
	    JTextField tipoDocumento = new JTextField(15);
	    JTextField documento = new JTextField(15);
	    JTextField facultad = new JTextField(15);
	    JTextField edad = new JTextField(15);
	    JTextField telefono = new JTextField(15);
	    JTextField correo = new JTextField(15);
	    JTextField aniosServicio = new JTextField(15);
	    JButton actualizar = new JButton("Actualizar");
	    JButton volver = new JButton("Volver");

	    panel.add(titulo);
	    panel.add(new JLabel("Índice"));
	    panel.add(index);
	    panel.add(new JLabel("Nombre"));
	    panel.add(nombre);
	    panel.add(new JLabel("Tipo de documento"));
	    panel.add(tipoDocumento);
	    panel.add(new JLabel("Documento"));
	    panel.add(documento);
	    panel.add(new JLabel("Facultad"));
	    panel.add(facultad);
	    panel.add(new JLabel("Edad"));
	    panel.add(edad);
	    panel.add(new JLabel("Teléfono"));
	    panel.add(telefono);
	    panel.add(new JLabel("Correo"));
	    panel.add(correo);
	    panel.add(new JLabel("Años de servicio"));
	    panel.add(aniosServicio);
	    panel.add(actualizar);
	    panel.add(volver);

	    volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, "Administrador"));
	    actualizar.addActionListener(e -> {
	        int idx = Integer.parseInt(index.getText());
	        Administrativo administrativo = new Administrativo(nombre.getText(), tipoDocumento.getText(), documento.getText(),
	                facultad.getText(), Short.parseShort(edad.getText()), Long.parseLong(telefono.getText()), correo.getText(),
	                Integer.parseInt(aniosServicio.getText()));
	        boolean resultado = controller.getADAO().actualizar(idx, administrativo);
	        if (resultado) {
	            JOptionPane.showMessageDialog(null, "Administrativo actualizado correctamente");
	        } else {
	            JOptionPane.showMessageDialog(null, "Error al actualizar el administrativo");
	        }
	        cambioVentanas.show(ventanaGrande, "Administrador");
	    });

	    fondo.add(panel);
	    ventanaGrande.add(fondo, "actualizarAdministrativo");
	    cambioVentanas.show(ventanaGrande, "actualizarAdministrativo");
	}

	public void eliminarEstudiante() {
	    String index = JOptionPane.showInputDialog("Ingrese el índice del estudiante a eliminar:");
	    try {
	        int idx = Integer.parseInt(index);
	        boolean resultado = controller.getEDAO().eliminar(idx);
	        if (resultado) {
	            JOptionPane.showMessageDialog(null, "Estudiante eliminado correctamente");
	        } else {
	            JOptionPane.showMessageDialog(null, "Error: Índice fuera de rango");
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Error: Índice inválido");
	    }
	}

	public void eliminarDocente() {
	    String index = JOptionPane.showInputDialog("Ingrese el índice del docente a eliminar:");
	    try {
	        int idx = Integer.parseInt(index);
	        boolean resultado = controller.getDDAO().eliminar(idx);
	        if (resultado) {
	            JOptionPane.showMessageDialog(null, "Docente eliminado correctamente");
	        } else {
	            JOptionPane.showMessageDialog(null, "Error: Índice fuera de rango");
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Error: Índice inválido");
	    }
	}

	public void eliminarAdministrativo() {
	    String index = JOptionPane.showInputDialog("Ingrese el índice del administrativo a eliminar:");
	    try {
	        int idx = Integer.parseInt(index);
	        boolean resultado = controller.getADAO().eliminar(idx);
	        if (resultado) {
	            JOptionPane.showMessageDialog(null, "Administrativo eliminado correctamente");
	        } else {
	            JOptionPane.showMessageDialog(null, "Error: Índice fuera de rango");
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Error: Índice inválido");
	    }
	}
}
