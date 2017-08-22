package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class ListaOnlineIgraca extends JFrame {

	private JPanel contentPane;
	private JList list;
	private JButton btnZahtevaj;
	private JButton btnZapocniIgru;
	
	
	public static boolean nemaIgraca;
	DefaultListModel listmodel = new DefaultListModel();

	public static LinkedList<String> listaOnlineIgraca;
	private JPanel panelce;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaOnlineIgraca frame = new ListaOnlineIgraca();
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
	public ListaOnlineIgraca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanelce());
		contentPane.add(getBtnZahtevaj());
		contentPane.add(getBtnZapocniIgru());
		contentPane.add(getList());
	}

	private JList getList() {
		if (list == null) {
			list = new JList(listmodel);
			list.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					while (ListaOnlineIgraca.listaOnlineIgraca == null) {
						System.out.println("Cekam odgovor od servera!");
					}
					String izabraniIgrac = list.getSelectedValue().toString();
					JOptionPane.showMessageDialog(new JFrame(),
							  "Izabrali ste da Vam protivnik bude "+izabraniIgrac);
					
					System.out.println(izabraniIgrac);
					
					Klijent.posaljiPaket(new Paket(Paket.CHOOSEN_PLAYER,izabraniIgrac));				
				}
			});
			list.setBounds(197, 11, 198, 218);
			list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
			list.setVisibleRowCount(-1);

		}
		return list;
	}

	private JButton getBtnZahtevaj() {
		if (btnZahtevaj == null) {
			btnZahtevaj = new JButton("ZahtevajListu");
			btnZahtevaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					listmodel.removeAllElements();
					System.out.println("Zahtevam list *click* ");
					listaOnlineIgraca = null;
					nemaIgraca = false;
					Klijent.posaljiPaket(new Paket(Paket.LIST_REQUEST));
					System.out.println("Usao u while petlje kod *click");
					while (ListaOnlineIgraca.listaOnlineIgraca == null) {
						if (nemaIgraca) {
							break;
						}
						System.out.println("zaglavljen u while petlji kod klika");
					}
					System.out.println("Izasao iz while petlje kod *click* ");

					if (listaOnlineIgraca != null) {
						System.out.println("Lista koju sam dobio nije null");
						for (int i = 0; i < listaOnlineIgraca.size(); i++) {
							listmodel.addElement(listaOnlineIgraca.get(i).toString());
							System.out.println("DODAO JE U LISTU U PROZORCETU");
						}
					}
						/*
						 * JOptionPane.showMessageDialog(new JFrame(),
						 * listmodel);
						 */
				}
			});
			btnZahtevaj.setBounds(26, 11, 119, 102);
		}
		return btnZahtevaj;
	}

	private JButton getBtnZapocniIgru() {
		if (btnZapocniIgru == null) {
			btnZapocniIgru = new JButton("ZapocniIgru");
			btnZapocniIgru.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					for (int i = 0; i < listmodel.size(); i++) {
						String izabrani_igrac = list.getSelectedValue().toString();
						if(listmodel.getElementAt(i).equals(izabrani_igrac)){
							Klijent.posaljiPaket(new Paket(Paket.CHOOSEN_PLAYER, izabrani_igrac));
						}
					}
					
				}
			});
			btnZapocniIgru.setBounds(26, 123, 118, 106);
		}
		return btnZapocniIgru;
	}

	private JPanel getPanelce() {
		if (panelce == null) {
			panelce = new JPanel();
			panelce.setBounds(0, 0, 0, 0);
			panelce.setLayout(null);
		}
		return panelce;
	}
}
