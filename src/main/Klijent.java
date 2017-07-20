
package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Klijent extends JFrame implements Runnable {
	static Socket soketZaKomunikaciju = null;
	static boolean upaljenaIgrica = true;
	static ObjectOutputStream oos = null;
	static ObjectInputStream ois = null;
	public static boolean uspesnoUlogovan = false;

	static boolean kraj = false;

	public static void main(String[] args) {
		try {
			int port = 4444;

			if (args.length > 0) {
				port = Integer.parseInt(args[0]);
			}

			soketZaKomunikaciju = new Socket("localhost", port);
			OutputStream os = soketZaKomunikaciju.getOutputStream();
			oos = new ObjectOutputStream(os);
			InputStream is = soketZaKomunikaciju.getInputStream();
			ois = new ObjectInputStream(is);

			new Thread(new Klijent()).start();

			login();
			while (!uspesnoUlogovan) {
				System.out.println("Ceka da se promeni uspesno ulogovan");
			}
			System.out.println();
			prikaziListu();

			while (!kraj) {

			}

			System.out.println("Stigao je dovde");
			soketZaKomunikaciju.close();
		} catch (UnknownHostException e) {
			System.err.println("DONT KNOW ABOUT HOST " + e);
		} catch (IOException e) {
			System.err.println("IOException :" + e);
			System.out.println("Server je offline");
		}
	}

	public void run() {
		Paket paket;
		try {
			while (true) {
				while ((paket = primiPaket()) != null) {
					if (paket.getType() == Paket.INVALID_USERNAME) {
						JOptionPane.showMessageDialog(this, "Ime vec postoji, izaberite neko drugo");
						login();
					}

					if ((paket.getPoruka() != null && paket.getPoruka().equals("kraj")) || kraj) {
						kraj = true;
						return;
					}

					if (paket.getType() == Paket.VALID_USERNAME) {
						uspesnoUlogovan = true;
					}

					if (paket.getType() == Paket.LIST) {
						if (paket.getPoruka() == null) {
							ListaOnlineIgraca.listaOnlineIgraca = paket.getListaOnlineIgraca();
							System.out.println("Promenio je static lista OI");
							for (int i = 0; i < ListaOnlineIgraca.listaOnlineIgraca.size();i++) {
								System.out.println(ListaOnlineIgraca.listaOnlineIgraca.get(i).toString());
							}
						} else {
							ListaOnlineIgraca.nemaIgraca = true;
							JOptionPane.showMessageDialog(this, "Trenutno nema online igraca sacekajte");
						}
					}
				}
			}
		} catch (Exception e) {
			System.err.println("IOException " + e);
		}
	}

	public static void prikaziListu() {
		ListaOnlineIgraca listaOIgraca = new ListaOnlineIgraca();
		listaOIgraca.setVisible(true);
	}

	public static void login() {
		String korisnik = JOptionPane.showInputDialog("USERNAME: ");
		if (korisnik != null) {
			posaljiPaket(new Paket(Paket.USERNAME, korisnik));
			uspesnoUlogovan = true;
		} else {
			kraj = true;
			System.out.println("Promenio je kraj");
		}
	}

	public static void posaljiPaket(Paket paket) {
		try {
			oos.writeObject(paket);
			System.out.println("Poslao paket");
		} catch (IOException ioe) {
			System.out.println("Nije mogao da posalje poruku jer je pukao server!");
			kraj = true;
			System.exit(1);
		}
	}

	public static Paket primiPaket() {
		Paket paket;
		try {
			while ((paket = (Paket) ois.readObject()) != null) {
				return paket;
			}
		} catch (Exception e) {
		}
		return null;
	}

	public static boolean hostAvailabilityCheck() {
		try (Socket s = new Socket("localhost", 4444)) {
			return true;
		} catch (IOException ex) {
		}
		return false;
	}
}
