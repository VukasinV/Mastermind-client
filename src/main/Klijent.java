
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
	static boolean nastavak = false;
	static boolean pom = false;

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
		Window w = new Window();
		ListaOnlineIgraca listaOIgraca = new ListaOnlineIgraca();
		try {
			while (true) {
				while ((paket = primiPaket()) != null) {
					//System.out.println("PRIMIO PAKET OD SERVERA!");
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
						listaOIgraca.setVisible(true);
					}

					if (paket.getType() == Paket.LIST) {
						// if (paket.getListaOnlineIgraca().isEmpty()) {
						// System.out.println("Server je poslao praznu listu
						// igraca ???");
						// }
						// if (paket.getPoruka() == this.ime) {
						ListaOnlineIgraca.listaOnlineIgraca = paket.getListaOnlineIgraca();
						//System.out.println("Azurirana lista igraca");
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

						//System.out.println("potraga za izabranim...");
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
						//System.out.println("Odbijen klijent");

						JOptionPane.showMessageDialog(this, "Igrac " + paket.getPoruka() + " je odbio/la zahtev...");

					}

					if (paket.getType() == Paket.ACCEPTED) {
						//System.out.println("accepted klasa klijent, poruka: " + paket.getPoruka());

						w = new Window();
						w.setVisible(true);
						listaOIgraca.setVisible(false);

						if (paket.getPoruka().equals("izazvac si"))
							w.setJaIgram(true);

					}

					if (paket.getType() == Paket.COMBINATION) {
						int a = Integer.parseInt(paket.getPoruka().split(",")[0]);
						int b = Integer.parseInt(paket.getPoruka().split(",")[1]);
						int c = Integer.parseInt(paket.getPoruka().split(",")[2]);
						int d = Integer.parseInt(paket.getPoruka().split(",")[3]);
						int red = paket.getRed();
						
						//System.out.println("KOMBINACIJA : "+a+b+c+d+" ,a red: "+red);
						
						popuniPolje(a, 1, red, w);
						popuniPolje(b, 2, red, w);
						popuniPolje(c, 3, red, w);
						popuniPolje(d, 4, red, w);						
					}

					if (paket.getType() == Paket.REZ) {
						int red = paket.getRed();
						int brPogodjenihNaMestu = Integer.parseInt(paket.getPoruka().split(",")[0]);
						int brPogodjenih = Integer.parseInt(paket.getPoruka().split(",")[1]);
						if (red == 1)
							w.rez1.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
						if (red == 2)
							w.rez2.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
						if (red == 3)
							w.rez3.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
						if (red == 4)
							w.rez4.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
						if (red == 5)
							w.rez5.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
						if (red == 6)
							w.rez6.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
						if(red == 7) {
							System.out.println("rez7");
							//Window.rez7.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
						}
							
						
						if(brPogodjenihNaMestu == 4){
							upaljenaIgrica = false;
							System.out.println("POBEDA..");
							JOptionPane.showMessageDialog(new JFrame(), "P O B E D A! Hvala na druzenju, dodji nam opet :)");							
							posaljiPaket(new Paket(Paket.END));
														
							
						} else {
							System.out.println("Nastavlja se.");
							nastavak = true;
						}
					}
					if(paket.getType()==Paket.TURN){
						Window.jaIgram = true;
						nastavak = true;
						pom = true;
						//System.out.println("uso u turn kod klijenta");
					}
					if(paket.getType()==Paket.WARRNING){
						Window.jaIgram = false;
						upaljenaIgrica = false;
						nastavak = true;
					//	System.out.println("uso u warning kod klijenta");
					}
					
					if(paket.getType()==Paket.WIN){
						System.out.println("Ispis resenja");
						int a = Integer.parseInt(paket.getPoruka().split(",")[0]);
						int b = Integer.parseInt(paket.getPoruka().split(",")[1]);
						int c = Integer.parseInt(paket.getPoruka().split(",")[2]);
						int d = Integer.parseInt(paket.getPoruka().split(",")[3]);
						upaljenaIgrica = false;						
						
						postaviResenje(a, 1, w);
						postaviResenje(b, 2, w);
						postaviResenje(c, 3, w);
						postaviResenje(d, 4, w);
						
						posaljiPaket(new Paket(Paket.END));
					}

					if(paket.getType()==Paket.END){
						upaljenaIgrica = false;
						listaOIgraca = new ListaOnlineIgraca();
						listaOIgraca.setVisible(true);						
						//w.dispose();
					}
					
				}
			}
		} catch (Exception e) {
			System.err.println("IOException " + e);
		}
	}


	private void postaviResenje(int x, int i, Window w) {
		if(i==1)w.polje = w.lblRez1;
		if(i==2)w.polje = w.lblRez2;
		if(i==3)w.polje = w.lblRez3;
		if(i==4)w.polje = w.lblRez4;
		
		switch (x) {
		case 1:
			w.polje.setIcon(Window.pikSlicica);
			break;
		case 2:
			w.polje.setIcon(Window.trefSlicica);
			break;
		case 3:
			w.polje.setIcon(Window.hercSlicica);
			break;
		case 4:
			w.polje.setIcon(Window.karoSlicica);
			break;
		case 5:
			w.polje.setIcon(Window.zvezdaSlicica);
			break;
		case 6:
			w.polje.setIcon(Window.jokerSlicica);
			break;
		default:
			System.out.println("LOSE UNET BROJ");
			break;
		}
		
	}

	private void popuniPolje(int x, int pom, int red, Window w) {
	//	for (int i = red*4-4; i < red*4; i++) {
			if(red==1){
				if(pom==1)w.polje = w.lbl1;
				if(pom==2)w.polje = w.lbl2;
				if(pom==3)w.polje = w.lbl3;
				if(pom==4)w.polje = w.lbl4;
			} else if(red==2){
				if(pom==1)w.polje = w.lbl5;
				if(pom==2)w.polje = w.lbl6;
				if(pom==3)w.polje = w.lbl7;
				if(pom==4)w.polje = w.lbl8;
			} else if(red==3){
				if(pom==1)w.polje = w.lbl9;
				if(pom==2)w.polje = w.lbl10;
				if(pom==3)w.polje = w.lbl11;
				if(pom==4)w.polje = w.lbl12;
			} else if(red==4){
				if(pom==1)w.polje = w.lbl13;
				if(pom==2)w.polje = w.lbl14;
				if(pom==3)w.polje = w.lbl15;
				if(pom==4)w.polje = w.lbl16;
			} else if(red==5){
				if(pom==1)w.polje = w.lbl17;
				if(pom==2)w.polje = w.lbl18;
				if(pom==3)w.polje = w.lbl19;
				if(pom==4)w.polje = w.lbl20;
			} else if(red==6){
				if(pom==1)w.polje = w.lbl21;
				if(pom==2)w.polje = w.lbl22;
				if(pom==3)w.polje = w.lbl23;
				if(pom==4)w.polje = w.lbl24;
			}else if(red==7){
				if(pom==1)w.polje = w.lblPokusaj1;
				if(pom==2)w.polje = w.lblPokusaj2;
				if(pom==3)w.polje = w.lblPokusaj3;
				if(pom==4)w.polje = w.lblPokusaj4;
			}
			
			switch (x) {
			case 1:
				w.polje.setIcon(Window.pikSlicica);
				break;
			case 2:
				w.polje.setIcon(Window.trefSlicica);
				break;
			case 3:
				w.polje.setIcon(Window.hercSlicica);
				break;
			case 4:
				w.polje.setIcon(Window.karoSlicica);
				break;
			case 5:
				w.polje.setIcon(Window.zvezdaSlicica);
				break;
			case 6:
				w.polje.setIcon(Window.jokerSlicica);
				break;
			default:
				System.out.println("LOSE UNET BROJ");
				break;
			}
		//}
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
