package clienteChat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cliente 
{
	
	
	
	public static void main(String[] args)
	{
		JFrame ventana = new JFrame();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(700, 700);
		
		
		JTextArea areaMensajes = new JTextArea();
		JScrollPane scroll = new JScrollPane(areaMensajes);
		
		areaMensajes.setEditable(false);
		areaMensajes.setText("Bienvenido al chat!!!\n");
		
		
		JPanel panelEnvio = new JPanel();
		
		JTextField fieldMensajes = new JTextField();
		fieldMensajes.setColumns(50);
		panelEnvio.add(fieldMensajes);
		
		JButton bEnvio = new JButton("Enviar");
		
		panelEnvio.add(bEnvio);
		
		ventana.add(scroll);
		ventana.add(panelEnvio, BorderLayout.SOUTH);
		
		
		
		
		Socket cliente = conectarAServidor(args[0], Integer.parseInt(args[1]));
		try {
			PrintWriter out = new PrintWriter(cliente.getOutputStream());
			out.println(args[2]); // mandar nick
			out.flush();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			
			bEnvio.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) 
				{
					String mensaje = fieldMensajes.getText().trim();
					fieldMensajes.setText("");
					if(mensaje.equals(""))
						return;
					
					System.out.println(mensaje);
					out.println(mensaje);
					out.flush();
				}
			});
			
			
			RefrescadorMensajes rm = new RefrescadorMensajes(in, areaMensajes);
			new Thread(rm).start();
			
			ventana.setVisible(true);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Socket conectarAServidor(String IpSer, int puertoSer)
	{
		Socket cliente = null;
		try {
			 cliente = new Socket(IpSer, puertoSer);
			 
			 
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cliente;
		
	}
	
}
