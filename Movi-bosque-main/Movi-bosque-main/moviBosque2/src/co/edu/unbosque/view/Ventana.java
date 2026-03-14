package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import co.edu.unbosque.controller.Controller;
import co.edu.unbosque.model.*;

public class Ventana extends JFrame {

	private final Controller controller;
	private CardLayout cambioVentanas;
	private JPanel ventanaGrande;
	private Image imagen;
	private String horarioSeleccionado = "";
	private String rolSeleccionado = "";

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
		
		//Campos adicionales
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
		volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, "menu"));
		registrar.addActionListener(e -> {
			if (rolSeleccionado.equals("estudiante")) {
				Estudiante est = controller.agregarEstudiante(nombre.getText(), tipoDocumento.getText(),
						documento.getText(), facultad.getText(), Short.parseShort(edad.getText()),
						Long.parseLong(telefono.getText()), correo.getText(),semestre.getText());
				controller.iniciarSesion(est);
				JOptionPane.showMessageDialog(null, "Estudiante registrado");
				cambioVentanas.show(ventanaGrande, "estudiante");
			} else if (rolSeleccionado.equals("profesor")) {
				Docente prof = new Docente(nombre.getText(), tipoDocumento.getText(), documento.getText(),
						facultad.getText(), Short.parseShort(edad.getText()), Long.parseLong(telefono.getText()),
						correo.getText());
				controller.iniciarSesion(prof);
				JOptionPane.showMessageDialog(null, "Profesor registrado");
				cambioVentanas.show(ventanaGrande, "profesor");
			} else if (rolSeleccionado.equals("administrador")) {
				Administrativo admin = new Administrativo(nombre.getText(), tipoDocumento.getText(),
						documento.getText(), facultad.getText(), Short.parseShort(edad.getText()),
						Long.parseLong(telefono.getText()), correo.getText(), Integer.parseInt(anioExperiencia.getText()));
				controller.iniciarSesion(admin);
				JOptionPane.showMessageDialog(null, "Administrador registrado");
				cambioVentanas.show(ventanaGrande, "administrador");
			}
		});
		fondo.add(panel);
		return fondo;
	}

	public JPanel pantallaMirarReservas() {
		JPanel panel = new JPanel();
		JButton mirarReserva = new JButton("Mirar reservas");
		mirarReserva.addActionListener(e -> {
			String reservas = controller.getUsuarioActual().mostrarReservas();
			if (reservas == null || reservas.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "No tienes reservas registradas");
		    } else {
		        JOptionPane.showMessageDialog(null, reservas);
		    }
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
		
		JButton verReservasEstudiantes = new JButton(" Ver reservas de estudiantes");
		verReservasEstudiantes.addActionListener(e -> {
	        String reservas = controller.mostrarReservasEstudiantes();
	        JOptionPane.showMessageDialog(null, reservas);
	    });
		
		mirarReserva.addActionListener(e -> {
			String reservas = controller.getUsuarioActual().mostrarReservas();
			JOptionPane.showMessageDialog(null, reservas);
		});
		hacerReserva.addActionListener(e -> cambioVentanas.show(ventanaGrande, "reservas"));

		volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, "menu"));
		
		JPanel reservaBotones = new JPanel();
		reservaBotones.add(mirarReserva);
		reservaBotones.add(hacerReserva);
		reservaBotones.add(verReservasEstudiantes);
		
		panel.add(titulo, BorderLayout.CENTER);
		panel.add(volver, BorderLayout.SOUTH);
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
		JButton mirarReserva = new JButton("Mirar sus reservas");
		JButton hacerReserva = new JButton("Hacer reserva");
		mirarReserva.addActionListener(e -> {
			String reservas = controller.getUsuarioActual().mostrarReservas();
			JOptionPane.showMessageDialog(null, reservas);
		});
		hacerReserva.addActionListener(e -> cambioVentanas.show(ventanaGrande, "ReservasAdmin"));
		volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, "menu"));
		JPanel reservaBotones = new JPanel();
		reservaBotones.setOpaque(false);
		panel.add(titulo, BorderLayout.CENTER);
		panel.add(volver, BorderLayout.SOUTH);
		reservaBotones.add(mirarReserva);
		reservaBotones.add(hacerReserva);
		panel.add(reservaBotones, BorderLayout.NORTH);
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

	private JPanel pantallaDeReservasTren() {

		PanelFondo fondo = new PanelFondo();
		fondo.setLayout(new GridBagLayout());
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel titulo = new JLabel("Reservas de Tren");
		JButton reservar = new JButton("Reservar");
		JButton volver = new JButton("Volver a las reservas");
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
				controller.reservarTren(horarioSeleccionado);
				JOptionPane.showMessageDialog(null, "Reserva hecha para las " + horarioSeleccionado);
			}
		});

		volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, rolSeleccionado));
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

		volver.addActionListener(e -> cambioVentanas.show(ventanaGrande, rolSeleccionado));
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
}
