
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
	public static String ime;
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
			// while (!uspesnoUlogovan) {
			// System.out.println("Ceka da se promeni uspesno ulogovan");
			// }

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
					System.out.println("PRIMIO PAKET OD SERVERA!");
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
						// if (paket.getListaOnlineIgraca().isEmpty()) {
						// System.out.println("Server je poslao praznu listu
						// igraca ???");
						// }
						// if (paket.getPoruka() == this.ime) {
						ListaOnlineIgraca.listaOnlineIgraca = paket.getListaOnlineIgraca();
						System.out.println("Azurirana lista igraca");
						for (int i = 0; i < ListaOnlineIgraca.listaOnlineIgraca.size(); i++) {
							System.out.print(ListaOnlineIgraca.listaOnlineIgraca.get(i).toString() + "--");
						}
						ListaOnlineIgraca.nemaIgraca = true;
						// } else {
						// System.out.println("Primio je paket koji pripada
						// pogresnom klijentu");
						// }
					}
					if (paket.getType() == Paket.NO_PLAYERS_ONLINE) {
						ListaOnlineIgraca.nemaIgraca = true;
						JOptionPane.showMessageDialog(this, "Trenutno nema online igraca sacekajte");
					}

					if (paket.getType() == Paket.CHOOSEN_PLAYER) {

						System.out.println("potraga za izabranim...");
						int opcion = JOptionPane.showConfirmDialog(null, "Izazvao vase je igrac: " + paket.getPoruka(),
								"Obavestenje!", JOptionPane.YES_NO_OPTION);

						if (opcion == 0) { // The ISSUE is here
							System.out.print("si");
							posaljiPaket(new Paket(Paket.ACCEPTED, paket.getPoruka()));
						} else {
							System.out.println("Izabrali ste NE");
							posaljiPaket(new Paket(Paket.DECLINED, paket.getPoruka()));
						}
					}

					if (paket.getType() == Paket.DECLINED) {
						System.out.println("Odbijen klijent");

						JOptionPane.showMessageDialog(this, "Igrac " + paket.getPoruka() + " je odbio/la zahtev...");

					}

					if (paket.getType() == Paket.ACCEPTED) {
						System.out.println("accepted klasa klijent, poruka: " + paket.getPoruka());

						Window w = new Window();
						w.setVisible(true);

						if (paket.getPoruka().equals("izazvac si"))
							w.setJaIgram(true);

					}

					if (paket.getType() == Paket.COMBINATION) {
						int a = Integer.parseInt(paket.getPoruka().split(",")[0]);
						int b = Integer.parseInt(paket.getPoruka().split(",")[1]);
						int c = Integer.parseInt(paket.getPoruka().split(",")[2]);
						int d = Integer.parseInt(paket.getPoruka().split(",")[3]);
						int red = paket.getRed();
						
						System.out.println("KOMBINACIJA : "+a+b+c+d+" ,a red: "+red);
						
						popuniPolje(a, 1, red);
						popuniPolje(b, 2, red);
						popuniPolje(c, 3, red);
						popuniPolje(d, 4, red);						
					}

					if (paket.getType() == Paket.REZ) {
						int red = paket.getRed();
						int brPogodjenihNaMestu = Integer.parseInt(paket.getPoruka().split(",")[0]);
						int brPogodjenih = Integer.parseInt(paket.getPoruka().split(",")[1]);
						if (red == 1)
							Window.rez1.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
						if (red == 2)
							Window.rez2.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
						if (red == 3)
							Window.rez3.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
						if (red == 4)
							Window.rez4.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
						if (red == 5)
							Window.rez5.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
						if (red == 6)
							Window.rez6.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);

					}

				}
			}
		} catch (Exception e) {
			System.err.println("IOException " + e);
		}
	}

	private void popuniPolje(int x, int pom, int red) {
	//	for (int i = red*4-4; i < red*4; i++) {
			if(red==1){
			if(pom==1)Window.polje = Window.lbl1;
			if(pom==2)Window.polje = Window.lbl2;
			if(pom==3)Window.polje = Window.lbl3;
			if(pom==4)Window.polje = Window.lbl4;
			} else if(red==2){
				if(pom==1)Window.polje = Window.lbl5;
				if(pom==2)Window.polje = Window.lbl6;
				if(pom==3)Window.polje = Window.lbl7;
				if(pom==4)Window.polje = Window.lbl8;
			} else if(red==3){
				if(pom==1)Window.polje = Window.lbl9;
				if(pom==2)Window.polje = Window.lbl10;
				if(pom==3)Window.polje = Window.lbl11;
				if(pom==4)Window.polje = Window.lbl12;
			} else if(red==4){
				if(pom==1)Window.polje = Window.lbl13;
				if(pom==2)Window.polje = Window.lbl14;
				if(pom==3)Window.polje = Window.lbl15;
				if(pom==4)Window.polje = Window.lbl16;
			} else if(red==5){
				if(pom==1)Window.polje = Window.lbl17;
				if(pom==2)Window.polje = Window.lbl18;
				if(pom==3)Window.polje = Window.lbl19;
				if(pom==4)Window.polje = Window.lbl20;
			} else if(red==6){
				if(pom==1)Window.polje = Window.lbl21;
				if(pom==2)Window.polje = Window.lbl22;
				if(pom==3)Window.polje = Window.lbl23;
				if(pom==4)Window.polje = Window.lbl24;
			}
			
			switch (x) {
			case 1:
				Window.polje.setIcon(Window.pikSlicica);
				break;
			case 2:
				Window.polje.setIcon(Window.trefSlicica);
				break;
			case 3:
				Window.polje.setIcon(Window.hercSlicica);
				break;
			case 4:
				Window.polje.setIcon(Window.karoSlicica);
				break;
			case 5:
				Window.polje.setIcon(Window.zvezdaSlicica);
				break;
			case 6:
				Window.polje.setIcon(Window.jokerSlicica);
				break;
			default:
				System.out.println("LOSE UNET BROJ");
				break;
			}
		//}
	}

	public static void prikaziListu() {
		ListaOnlineIgraca listaOIgraca = new ListaOnlineIgraca();
		listaOIgraca.setVisible(true);

	}

	public static void login() {
		String korisnik = JOptionPane.showInputDialog("USERNAME: ");
		if (korisnik != null) {
			posaljiPaket(new Paket(Paket.USERNAME, korisnik));
			ime = korisnik;
			uspesnoUlogovan = true;
		} else {
			System.exit(0);
		}
	}

	public static void posaljiPaket(Paket paket) {
		try {
			oos.writeObject(paket);
			System.out.println("Poslao paket");
		} catch (IOException ioe) {
			System.out.println("Nije mogao da posalje poruku jer je pukao server!");
			kraj = true;
			System.exit(0);
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
