package main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl9;
	private JLabel lbl10;
	private JLabel lbl11;
	private JLabel lbl12;
	private JLabel lbl13;
	private JLabel lbl14;
	private JLabel lbl15;
	private JLabel lbl16;
	private JLabel lbl17;
	private JLabel lbl18;
	private JLabel lbl19;
	private JLabel lbl20;
	private JLabel lbl21;
	private JLabel lbl22;
	private JLabel lbl23;
	private JLabel lbl24;
	private JLabel rez1;
	private JLabel rez2;
	private JLabel rez3;
	private JLabel rez4;
	private JLabel rez5;
	private JLabel rez6;
	private JButton btnPik;
	private JButton btnKaro;
	private JButton btnTref;
	private JButton btnHerc;
	private JButton btnJoker;
	private JButton btnZvezda;
	private JLabel lblRez1;
	private JLabel lblRez2;
	private JLabel lblRez3;
	private JLabel lblRez4;
	Icon karoSlicica = new ImageIcon(".\\src\\resources\\rsz_karo.png");
	Icon zvezdaSlicica = new ImageIcon(".\\src\\resources\\rsz_zvezda.png");
	Icon pikSlicica = new ImageIcon(".\\src\\resources\\rsz_pik.png");
	Icon hercSlicica = new ImageIcon(".\\src\\resources\\rsz_srce.jpg");
	Icon trefSlicica = new ImageIcon(".\\src\\resources\\rsz_tref.png");
	Icon jokerSlicica = new ImageIcon(".\\src\\resources\\rsz_joker.png");
	private JLabel lblResenje;
	private JPanel panel_4;
	private JButton btnProveriPrviRed;
	private JButton btnProveriDrugiRed;
	private JButton btnProveriTreciRed;
	private JButton btnProveriCetvrtiRed;
	private JButton btnProveriPetiRed;
	private JButton btnProveriSestiRed;
	public JLabel tempLbl;
	private JPanel panel_5;
	private JButton btnRestartPrviRed;
	private JButton btnRestartDrugiRed;
	private JButton btnRestartTreciRed;
	private JButton btnRestartCetvrtiRed;
	private JButton btnRestartPetiRed;
	private JButton btnRestartSestiRed;
	int trenutniRed = 1;
	private JButton btnPokusajPonovo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Window frame = new Window();
//					frame.setVisible(true);
//					System.out.println("Resenje je: " + ispisiZnak(game.q) + " " + ispisiZnak(game.w) + " "
//							+ ispisiZnak(game.e) + " " + ispisiZnak(game.r));

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setOpaque(true);
		contentPane.setBackground(Color.blue);
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.setLayout(null);
		contentPane.add(getPanel_1());
		contentPane.add(getPanel_2());
		contentPane.add(getPanel_3_1());
		contentPane.add(getLblResenje());
		contentPane.add(getPanel_4());
		contentPane.add(getPanel_5());
		contentPane.add(getBtnPokusajPonovo());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
		}
		panel.setPreferredSize(new Dimension(50, 50));
		return panel;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBounds(115, 6, 442, 65);
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_1.setOpaque(true);
			panel_1.setBackground(Color.blue);
			panel_1.add(getBtnPik());
			panel_1.add(getBtnTref());
			panel_1.add(getBtnHerc());
			panel_1.add(getBtnKaro());
			panel_1.add(getBtnZvezda());
			panel_1.add(getBtnJoker());
		}
		return panel_1;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBounds(141, 82, 388, 395);
			panel_2.setLayout(new GridLayout(6, 6, 20, 7));
			panel_2.setOpaque(true);
			panel_2.setBackground(Color.blue);
			panel_2.add(getLblSrce());
			panel_2.add(getLblPik());
			panel_2.add(getLblTref());
			panel_2.add(getLblKaro());
			panel_2.add(getRez1());
			panel_2.add(getLbl5());
			panel_2.add(getLbl6());
			panel_2.add(getLbl7());
			panel_2.add(getLbl8());
			panel_2.add(getRez2());
			panel_2.add(getLbl9());
			panel_2.add(getLbl10());
			panel_2.add(getLbl11());
			panel_2.add(getLbl12());
			panel_2.add(getRez3());
			panel_2.add(getLbl13());
			panel_2.add(getLbl14());
			panel_2.add(getLbl15());
			panel_2.add(getLbl16());
			panel_2.add(getRez4());
			panel_2.add(getLbl17());
			panel_2.add(getLbl18());
			panel_2.add(getLbl19());
			panel_2.add(getLbl20());
			panel_2.add(getRez5());
			panel_2.add(getLbl21());
			panel_2.add(getLbl22());
			panel_2.add(getLbl23());
			panel_2.add(getLbl24());
			panel_2.add(getRez6());
		}
		return panel_2;
	}

	private JLabel getLblSrce() {
		if (lbl1 == null) {
			lbl1 = new JLabel("");
			lbl1.setOpaque(true);
			lbl1.setBackground(Color.WHITE);
			lbl1.setPreferredSize(new Dimension(60, 60));
			lbl1.setPreferredSize(new Dimension(60, 60));
			lbl1.setPreferredSize(new Dimension(60, 60));
		}
		return lbl1;
	}

	private JLabel getLblPik() {
		if (lbl2 == null) {
			lbl2 = new JLabel("");
			lbl2.setOpaque(true);
			lbl2.setBackground(Color.white);
			lbl2.setPreferredSize(new Dimension(60, 60));
			lbl2.setMaximumSize(new Dimension(60, 60));
			lbl2.setMinimumSize(new Dimension(60, 60));
		}
		return lbl2;
	}

	private JLabel getLblTref() {
		if (lbl3 == null) {
			lbl3 = new JLabel("");
			lbl3.setOpaque(true);
			lbl3.setBackground(Color.white);
		}
		return lbl3;
	}

	private JLabel getLblKaro() {
		if (lbl4 == null) {
			lbl4 = new JLabel("");
			lbl4.setOpaque(true);
			lbl4.setBackground(Color.white);
		}
		return lbl4;
	}

	private JLabel getRez1() {
		if (rez1 == null) {
			rez1 = new JLabel("");
			rez1.setOpaque(true);
			rez1.setBackground(Color.white);
			rez1.setFont(new Font("Serif", Font.BOLD, 45));
		}
		return rez1;
	}

	private JLabel getLbl5() {
		if (lbl5 == null) {
			lbl5 = new JLabel("");
			lbl5.setOpaque(true);
			lbl5.setBackground(Color.white);
		}
		return lbl5;
	}

	private JLabel getLbl6() {
		if (lbl6 == null) {
			lbl6 = new JLabel("");
			lbl6.setOpaque(true);
			lbl6.setBackground(Color.white);
		}
		return lbl6;
	}

	private JLabel getLbl7() {
		if (lbl7 == null) {
			lbl7 = new JLabel("");
			lbl7.setOpaque(true);
			lbl7.setBackground(Color.white);
		}
		return lbl7;
	}

	private JLabel getLbl8() {
		if (lbl8 == null) {
			lbl8 = new JLabel("");
			lbl8.setOpaque(true);
			lbl8.setBackground(Color.white);
		}
		return lbl8;
	}

	private JLabel getRez2() {
		if (rez2 == null) {
			rez2 = new JLabel("");
			rez2.setOpaque(true);
			rez2.setBackground(Color.white);
			rez2.setFont(new Font("Serif", Font.BOLD, 45));
		}
		return rez2;
	}

	private JLabel getLbl9() {
		if (lbl9 == null) {
			lbl9 = new JLabel("");
			lbl9.setOpaque(true);
			lbl9.setBackground(Color.white);
		}
		return lbl9;
	}

	private JLabel getLbl10() {
		if (lbl10 == null) {
			lbl10 = new JLabel("");
			lbl10.setOpaque(true);
			lbl10.setBackground(Color.white);
		}
		return lbl10;
	}

	private JLabel getLbl11() {
		if (lbl11 == null) {
			lbl11 = new JLabel("");
			lbl11.setOpaque(true);
			lbl11.setBackground(Color.white);
		}
		return lbl11;
	}

	private JLabel getLbl12() {
		if (lbl12 == null) {
			lbl12 = new JLabel("");
			lbl12.setOpaque(true);
			lbl12.setBackground(Color.white);
		}
		return lbl12;
	}

	private JLabel getRez3() {
		if (rez3 == null) {
			rez3 = new JLabel("");
			rez3.setOpaque(true);
			rez3.setBackground(Color.white);
			rez3.setFont(new Font("Serif", Font.BOLD, 45));
		}
		return rez3;
	}

	private JLabel getLbl13() {
		if (lbl13 == null) {
			lbl13 = new JLabel("");
			lbl13.setOpaque(true);
			lbl13.setBackground(Color.white);
		}
		return lbl13;
	}

	private JLabel getLbl14() {
		if (lbl14 == null) {
			lbl14 = new JLabel("");
			lbl14.setOpaque(true);
			lbl14.setBackground(Color.white);
		}
		return lbl14;
	}

	private JLabel getLbl15() {
		if (lbl15 == null) {
			lbl15 = new JLabel("");
			lbl15.setOpaque(true);
			lbl15.setBackground(Color.white);
		}
		return lbl15;
	}

	private JLabel getLbl16() {
		if (lbl16 == null) {
			lbl16 = new JLabel("");
			lbl16.setOpaque(true);
			lbl16.setBackground(Color.white);
		}
		return lbl16;
	}

	private JLabel getRez4() {
		if (rez4 == null) {
			rez4 = new JLabel("");
			rez4.setOpaque(true);
			rez4.setBackground(Color.white);
			rez4.setFont(new Font("Serif", Font.BOLD, 45));
		}
		return rez4;
	}

	private JLabel getLbl17() {
		if (lbl17 == null) {
			lbl17 = new JLabel("");
			lbl17.setOpaque(true);
			lbl17.setBackground(Color.white);
		}
		return lbl17;
	}

	private JLabel getLbl18() {
		if (lbl18 == null) {
			lbl18 = new JLabel("");
			lbl18.setOpaque(true);
			lbl18.setBackground(Color.white);
		}
		return lbl18;
	}

	private JLabel getLbl19() {
		if (lbl19 == null) {
			lbl19 = new JLabel("");
			lbl19.setOpaque(true);
			lbl10.setBackground(Color.white);
		}
		return lbl19;
	}

	private JLabel getLbl20() {
		if (lbl20 == null) {
			lbl20 = new JLabel("");
			lbl20.setOpaque(true);
			lbl20.setBackground(Color.white);
		}
		return lbl20;
	}

	private JLabel getRez5() {
		if (rez5 == null) {
			rez5 = new JLabel("");
			rez5.setOpaque(true);
			rez5.setBackground(Color.white);
			rez5.setFont(new Font("Serif", Font.BOLD, 45));
		}
		return rez5;
	}

	private JLabel getLbl21() {
		if (lbl21 == null) {
			lbl21 = new JLabel("");
			lbl21.setOpaque(true);
			lbl21.setBackground(Color.white);
		}
		return lbl21;
	}

	private JLabel getLbl22() {
		if (lbl22 == null) {
			lbl22 = new JLabel("");
			lbl22.setOpaque(true);
			lbl22.setBackground(Color.white);
		}
		return lbl22;
	}

	private JLabel getLbl23() {
		if (lbl23 == null) {
			lbl23 = new JLabel("");
			lbl23.setOpaque(true);
			lbl23.setBackground(Color.white);
		}
		return lbl23;
	}

	private JLabel getLbl24() {
		if (lbl24 == null) {
			lbl24 = new JLabel("");
			lbl24.setOpaque(true);
			lbl24.setBackground(Color.white);
		}
		return lbl24;
	}

	private JLabel getRez6() {
		if (rez6 == null) {
			rez6 = new JLabel("");
			rez6.setOpaque(true);
			rez6.setBackground(Color.white);
			rez6.setFont(new Font("Serif", Font.BOLD, 45));
		}
		return rez6;
	}

	private JButton getBtnPik() {
		if (btnPik == null) {
			btnPik = new JButton("");
			btnPik.setPreferredSize(new Dimension(60, 60));
			btnPik.setIcon(pikSlicica);
			btnPik.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					unesiSlicicu(pikSlicica, trenutniRed);
				}
			});
		}
		return btnPik;
	}

	private JButton getBtnKaro() {
		if (btnKaro == null) {
			btnKaro = new JButton("");
			btnKaro.setPreferredSize(new Dimension(60, 60));
			btnKaro.setIcon(karoSlicica);
			btnKaro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					unesiSlicicu(karoSlicica, trenutniRed);
				}
			});
		}
		return btnKaro;
	}

	private JPanel getPanel_3_1() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBounds(202, 529, 300, 60);
			panel_3.setOpaque(true);
			panel_3.setBackground(Color.blue);
			panel_3.setLayout(new GridLayout(0, 4, 20, 0));
			panel_3.add(getLblRez1());
			panel_3.add(getLblRez2());
			panel_3.add(getLblRez3());
			panel_3.add(getLblRez4());
		}
		return panel_3;
	}

	private JButton getBtnTref() {
		if (btnTref == null) {
			btnTref = new JButton("");
			btnTref.setPreferredSize(new Dimension(60, 60));
			btnTref.setIcon(trefSlicica);
			btnTref.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					unesiSlicicu(trefSlicica, trenutniRed);
				}
			});
		}
		return btnTref;
	}

	private JButton getBtnHerc() {
		if (btnHerc == null) {
			btnHerc = new JButton("");
			btnHerc.setPreferredSize(new Dimension(60, 60));
			btnHerc.setIcon(hercSlicica);
			btnHerc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					unesiSlicicu(hercSlicica, trenutniRed);
				}
			});
		}
		return btnHerc;
	}

	private JButton getBtnJoker() {
		if (btnJoker == null) {
			btnJoker = new JButton("");
			btnJoker.setPreferredSize(new Dimension(60, 60));
			btnJoker.setIcon(jokerSlicica);
			btnJoker.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					unesiSlicicu(jokerSlicica, trenutniRed);
				}
			});
		}
		return btnJoker;
	}

	private JButton getBtnZvezda() {
		if (btnZvezda == null) {
			btnZvezda = new JButton("");
			btnZvezda.setPreferredSize(new Dimension(60, 60));
			btnZvezda.setIcon(zvezdaSlicica);
			btnZvezda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					unesiSlicicu(zvezdaSlicica, trenutniRed);
				}
			});
		}
		return btnZvezda;
	}

	private JLabel getLblRez1() {
		if (lblRez1 == null) {
			lblRez1 = new JLabel("");
			lblRez1.setOpaque(true);
			lblRez1.setBackground(Color.white);
		}
		return lblRez1;
	}

	private JLabel getLblRez2() {
		if (lblRez2 == null) {
			lblRez2 = new JLabel("");
			lblRez2.setOpaque(true);
			lblRez2.setBackground(Color.white);
		}
		return lblRez2;
	}

	private JLabel getLblRez3() {
		if (lblRez3 == null) {
			lblRez3 = new JLabel("");
			lblRez3.setOpaque(true);
			lblRez3.setBackground(Color.white);
		}
		return lblRez3;
	}

	private JLabel getLblRez4() {
		if (lblRez4 == null) {
			lblRez4 = new JLabel("");
			lblRez4.setOpaque(true);
			lblRez4.setBackground(Color.white);
		}
		return lblRez4;
	}

	private JLabel getLblResenje() {
		if (lblResenje == null) {
			lblResenje = new JLabel("            R    E    S    E    NJ    E:       ");
			lblResenje.setBounds(260, 488, 183, 30);
			lblResenje.setOpaque(true);
			lblResenje.setBackground(Color.yellow);
			lblResenje.setForeground(Color.black);
		}
		return lblResenje;
	}

	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBounds(559, 82, 86, 395);
			panel_4.setLayout(new GridLayout(6, 1, 0, 20));
			panel_4.add(getBtnProveriPrviRed());
			panel_4.add(getBtnProveriDrugiRed());
			panel_4.add(getBtnProveriTreciRed());
			panel_4.add(getBtnProveriCetvrtiRed());
			panel_4.add(getBtnProveriPetiRed());
			panel_4.add(getBtnProveriSestiRed());
		}
		return panel_4;
	}

	private JButton getBtnProveriPrviRed() {
		if (btnProveriPrviRed == null) {
			btnProveriPrviRed = new JButton("PROVERI");
			btnProveriPrviRed.setOpaque(true);
			btnProveriPrviRed.setForeground(Color.red);
			btnProveriPrviRed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (lbl1.getIcon() != null && lbl2.getIcon() != null && lbl3.getIcon() != null
							&& lbl4.getIcon() != null) {
						int a, b, c, d;
						a = dodeliKontrolniBr(lbl1);
						b = dodeliKontrolniBr(lbl2);
						c = dodeliKontrolniBr(lbl3);
						d = dodeliKontrolniBr(lbl4);
//						int brPogodjenihNaMestu = game.vratiBrojPogodjenih(a, b, c, d, true);
//						int brPogodjenih = game.vratiBrojPogodjenih(a, b, c, d, false);
//						daLiSiPobedio(brPogodjenihNaMestu);
//						rez1.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
						trenutniRed = 2;
					}
				}
			});
		}
		return btnProveriPrviRed;
	}

	private JButton getBtnProveriDrugiRed() {
		if (btnProveriDrugiRed == null) {
			btnProveriDrugiRed = new JButton("PROVERI");
			btnProveriDrugiRed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (lbl5.getIcon() != null && lbl6.getIcon() != null && lbl7.getIcon() != null
							&& lbl8.getIcon() != null) {
						int a, b, c, d;
						a = dodeliKontrolniBr(lbl5);
						b = dodeliKontrolniBr(lbl6);
						c = dodeliKontrolniBr(lbl7);
						d = dodeliKontrolniBr(lbl8);
//						int brPogodjenihNaMestu = game.vratiBrojPogodjenih(a, b, c, d, true);
//						int brPogodjenih = game.vratiBrojPogodjenih(a, b, c, d, false);
//						daLiSiPobedio(brPogodjenihNaMestu);
//						rez2.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
						trenutniRed = 3;
					}
				}
			});
			btnProveriDrugiRed.setOpaque(true);
			btnProveriDrugiRed.setForeground(Color.red);
		}
		return btnProveriDrugiRed;
	}

	private JButton getBtnProveriTreciRed() {
		if (btnProveriTreciRed == null) {
			btnProveriTreciRed = new JButton("PROVERI");
			btnProveriTreciRed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (lbl9.getIcon() != null && lbl10.getIcon() != null && lbl11.getIcon() != null
							&& lbl12.getIcon() != null) {
						int a, b, c, d;
						a = dodeliKontrolniBr(lbl9);
						b = dodeliKontrolniBr(lbl10);
						c = dodeliKontrolniBr(lbl11);
						d = dodeliKontrolniBr(lbl12);
//						int brPogodjenihNaMestu = game.vratiBrojPogodjenih(a, b, c, d, true);
//						int brPogodjenih = game.vratiBrojPogodjenih(a, b, c, d, false);
//						daLiSiPobedio(brPogodjenihNaMestu);
//						rez3.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
						trenutniRed = 4;
					}
				}
			});
			btnProveriTreciRed.setOpaque(true);
			btnProveriTreciRed.setForeground(Color.red);
		}
		return btnProveriTreciRed;
	}

	private JButton getBtnProveriCetvrtiRed() {
		if (btnProveriCetvrtiRed == null) {
			btnProveriCetvrtiRed = new JButton("PROVERI");
			btnProveriCetvrtiRed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (lbl13.getIcon() != null && lbl14.getIcon() != null && lbl15.getIcon() != null
							&& lbl16.getIcon() != null) {
						int a, b, c, d;
						a = dodeliKontrolniBr(lbl13);
						b = dodeliKontrolniBr(lbl14);
						c = dodeliKontrolniBr(lbl15);
						d = dodeliKontrolniBr(lbl16);
//						int brPogodjenihNaMestu = game.vratiBrojPogodjenih(a, b, c, d, true);
//						int brPogodjenih = game.vratiBrojPogodjenih(a, b, c, d, false);
//						daLiSiPobedio(brPogodjenihNaMestu);
//						rez4.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
						trenutniRed = 5;
					}
				}
			});
			btnProveriCetvrtiRed.setOpaque(true);
			btnProveriCetvrtiRed.setForeground(Color.red);
		}
		return btnProveriCetvrtiRed;
	}

	private JButton getBtnProveriPetiRed() {
		if (btnProveriPetiRed == null) {
			btnProveriPetiRed = new JButton("PROVERI");
			btnProveriPetiRed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (lbl17.getIcon() != null && lbl18.getIcon() != null && lbl19.getIcon() != null
							&& lbl20.getIcon() != null) {
						int a, b, c, d;
						a = dodeliKontrolniBr(lbl17);
						b = dodeliKontrolniBr(lbl18);
						c = dodeliKontrolniBr(lbl19);
						d = dodeliKontrolniBr(lbl20);
//						int brPogodjenihNaMestu = game.vratiBrojPogodjenih(a, b, c, d, true);
//						int brPogodjenih = game.vratiBrojPogodjenih(a, b, c, d, false);
//						daLiSiPobedio(brPogodjenihNaMestu);
//						rez5.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
						trenutniRed = 6;
					}
				}
			});
			btnProveriPetiRed.setOpaque(true);
			btnProveriPetiRed.setForeground(Color.red);
		}
		return btnProveriPetiRed;
	}

	private JButton getBtnProveriSestiRed() {
		if (btnProveriSestiRed == null) {
			btnProveriSestiRed = new JButton("PROVERI");
			btnProveriSestiRed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (lbl21.getIcon() != null && lbl22.getIcon() != null && lbl23.getIcon() != null
							&& lbl24.getIcon() != null) {
						int a, b, c, d;
						a = dodeliKontrolniBr(lbl21);
						b = dodeliKontrolniBr(lbl22);
						c = dodeliKontrolniBr(lbl23);
						d = dodeliKontrolniBr(lbl24);
//						int brPogodjenihNaMestu = game.vratiBrojPogodjenih(a, b, c, d, true);
//						int brPogodjenih = game.vratiBrojPogodjenih(a, b, c, d, false);
//						daLiSiPobedio(brPogodjenihNaMestu);
//						if (lblRez1.getIcon() == null) {
//							lblRez1.setIcon(dodeliSlicicu(game.q));
//							lblRez2.setIcon(dodeliSlicicu(game.w));
//							lblRez3.setIcon(dodeliSlicicu(game.e));
//							lblRez4.setIcon(dodeliSlicicu(game.r));
							JOptionPane.showMessageDialog(new JFrame(),
									"NAZALOST NISI USPEO, ALI MOZES DA POKUSAS PONOVO!");
//						}
//							rez6.setText("" + brPogodjenihNaMestu + " " + brPogodjenih);
					}
				}
			});
			btnProveriSestiRed.setOpaque(true);
			btnProveriSestiRed.setForeground(Color.red);
		}
		return btnProveriSestiRed;
	}

	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setBounds(20, 82, 88, 395);
			panel_5.setLayout(new GridLayout(6, 1, 0, 20));
			panel_5.add(getBtnRestartPrviRed());
			panel_5.add(getBtnRestartDrugiRed());
			panel_5.add(getBtnRestartTreciRed());
			panel_5.add(getBtnRestartCetvrtiRed());
			panel_5.add(getBtnRestartPetiRed());
			panel_5.add(getBtnRestartSestiRed());
		}
		return panel_5;
	}

	private JButton getBtnRestartPrviRed() {
		if (btnRestartPrviRed == null) {
			btnRestartPrviRed = new JButton("RESTART");
			btnRestartPrviRed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!rez1.getText().equals("")) {
						return;
					}
					lbl1.setIcon(null);
					lbl2.setIcon(null);
					lbl3.setIcon(null);
					lbl4.setIcon(null);
				}
			});
		}
		return btnRestartPrviRed;
	}

	private JButton getBtnRestartDrugiRed() {
		if (btnRestartDrugiRed == null) {
			btnRestartDrugiRed = new JButton("RESTART");
			btnRestartDrugiRed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!rez2.getText().equals("")) {
						return;
					}
					lbl5.setIcon(null);
					lbl6.setIcon(null);
					lbl7.setIcon(null);
					lbl8.setIcon(null);
				}
			});
		}
		return btnRestartDrugiRed;
	}

	private JButton getBtnRestartTreciRed() {
		if (btnRestartTreciRed == null) {
			btnRestartTreciRed = new JButton("RESTART");
			btnRestartTreciRed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!rez3.getText().equals("")) {
						return;
					}
					lbl9.setIcon(null);
					lbl10.setIcon(null);
					lbl11.setIcon(null);
					lbl12.setIcon(null);
				}
			});
		}
		return btnRestartTreciRed;
	}

	private JButton getBtnRestartCetvrtiRed() {
		if (btnRestartCetvrtiRed == null) {
			btnRestartCetvrtiRed = new JButton("RESTART");
			btnRestartCetvrtiRed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!rez4.getText().equals("")) {
						return;
					}
					lbl13.setIcon(null);
					lbl14.setIcon(null);
					lbl15.setIcon(null);
					lbl16.setIcon(null);
				}
			});
		}
		return btnRestartCetvrtiRed;
	}

	private JButton getBtnRestartPetiRed() {
		if (btnRestartPetiRed == null) {
			btnRestartPetiRed = new JButton("RESTART");
			btnRestartPetiRed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!rez5.getText().equals("")) {
						return;
					}
					lbl17.setIcon(null);
					lbl18.setIcon(null);
					lbl19.setIcon(null);
					lbl20.setIcon(null);
				}
			});
		}
		return btnRestartPetiRed;
	}

	private JButton getBtnRestartSestiRed() {
		if (btnRestartSestiRed == null) {
			btnRestartSestiRed = new JButton("RESTART");
			btnRestartSestiRed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!rez6.getText().equals("")) {
						return;
					}
					lbl21.setIcon(null);
					lbl22.setIcon(null);
					lbl23.setIcon(null);
					lbl24.setIcon(null);
				}
			});
		}
		return btnRestartSestiRed;
	}

	// Sad ide 6 metoda od kojih svaka proverava u odgovarajucem redu, 
	// gde treba da se stavi slicica klikom na dugme
	// Siguran sam da ovo moze da se odradi na jednostavniji nacin,
	// ali dok ja ili neko drugi ne smisli, ostaje ovako
	public JLabel proveriDokleSiStigaoPrviRed() {
		if (lbl1.getIcon() == null) {
			return lbl1;
		} else if (lbl2.getIcon() == null) {
			return lbl2;
		} else if (lbl3.getIcon() == null) {
			return lbl3;
		} else if (lbl4.getIcon() == null) {
			return lbl4;
		} else {
			return null;
		}
	}

	public JLabel proveriDokleSiStigaoDrugiRed() {
		if (lbl5.getIcon() == null) {
			return lbl5;
		} else if (lbl6.getIcon() == null) {
			return lbl6;
		} else if (lbl7.getIcon() == null) {
			return lbl7;
		} else if (lbl8.getIcon() == null) {
			return lbl8;
		} else {
			return null;
		}
	}

	public JLabel proveriDokleSiStigaoTreciRed() {
		if (lbl9.getIcon() == null) {
			return lbl9;
		} else if (lbl10.getIcon() == null) {
			return lbl10;
		} else if (lbl11.getIcon() == null) {
			return lbl11;
		} else if (lbl12.getIcon() == null) {
			return lbl12;
		} else {
			return null;
		}
	}

	public JLabel proveriDokleSiStigaoCetvrtiRed() {
		if (lbl13.getIcon() == null) {
			return lbl13;
		} else if (lbl14.getIcon() == null) {
			return lbl14;
		} else if (lbl15.getIcon() == null) {
			return lbl15;
		} else if (lbl16.getIcon() == null) {
			return lbl16;
		} else {
			return null;
		}
	}

	public JLabel proveriDokleSiStigaoPetiRed() {
		if (lbl17.getIcon() == null) {
			return lbl17;
		} else if (lbl18.getIcon() == null) {
			return lbl18;
		} else if (lbl19.getIcon() == null) {
			return lbl19;
		} else if (lbl20.getIcon() == null) {
			return lbl20;
		} else {
			return null;
		}
	}

	public JLabel proveriDokleSiStigaoSestiRed() {
		if (lbl21.getIcon() == null) {
			return lbl21;
		} else if (lbl22.getIcon() == null) {
			return lbl22;
		} else if (lbl23.getIcon() == null) {
			return lbl23;
		} else if (lbl24.getIcon() == null) {
			return lbl24;
		} else {
			return null;
		}
	}

	//Metoda kojom se unosi slicica u odredjeni red na odredjeno mesto
	public void unesiSlicicu(Icon icon, int trenutniRed) {
		switch (trenutniRed) {
		case 1:
			if (proveriDokleSiStigaoPrviRed() == null) {
				System.out.println("SVI SU POPUNJENI!");
			} else {
				proveriDokleSiStigaoPrviRed().setIcon(icon);
			}
			break;
		case 2:
			if (proveriDokleSiStigaoDrugiRed() == null) {
				System.out.println("SVI SU POPUNJENI!");
			} else {
				proveriDokleSiStigaoDrugiRed().setIcon(icon);
			}
			break;
		case 3:
			if (proveriDokleSiStigaoTreciRed() == null) {
				System.out.println("SVI SU POPUNJENI!");
			} else {
				proveriDokleSiStigaoTreciRed().setIcon(icon);
			}
			break;
		case 4:
			if (proveriDokleSiStigaoCetvrtiRed() == null) {
				System.out.println("SVI SU POPUNJENI!");
			} else {
				proveriDokleSiStigaoCetvrtiRed().setIcon(icon);
			}
			break;
		case 5:
			if (proveriDokleSiStigaoPetiRed() == null) {
				System.out.println("SVI SU POPUNJENI!");
			} else {
				proveriDokleSiStigaoPetiRed().setIcon(icon);
			}
			break;
		case 6:
			if (proveriDokleSiStigaoSestiRed() == null) {
				System.out.println("SVI SU POPUNJENI!");
			} else {
				proveriDokleSiStigaoSestiRed().setIcon(icon);
			}
			break;
		default:
			break;
		}

	}
	
	//Metoda koja na osnovu slicice vraca odgovarajuci broj
	public int dodeliKontrolniBr(JLabel lbl) {
		if (lbl.getIcon() == pikSlicica) {
			return 1;
		} else if (lbl.getIcon() == trefSlicica) {
			return 2;
		} else if (lbl.getIcon() == hercSlicica) {
			return 3;
		} else if (lbl.getIcon() == karoSlicica) {
			return 4;
		} else if (lbl.getIcon() == zvezdaSlicica) {
			return 5;
		} else {
			return 6;
		}
	}

	//Metoda koja na osnovu broja vraca odgovarajucu slicicu
	public Icon dodeliSlicicu(int a) {
		switch (a) {
		case 1:
			return pikSlicica;
		case 2:
			return trefSlicica;
		case 3:
			return hercSlicica;
		case 4:
			return karoSlicica;
		case 5:
			return zvezdaSlicica;
		case 6:
			return jokerSlicica;
		default:
			System.out.println("LOSE UNET BROJ");
			break;
		}
		return null;
	}
	
	//Metoda koje ukoliko se pogodilo resenje, izbacuje poruku o tome u vidu upozoravajuceg prozorcica
	public void daLiSiPobedio(int brPogodjenihNaMestu) {
		if (brPogodjenihNaMestu == 4) {
//			lblRez1.setIcon(dodeliSlicicu(game.q));
//			lblRez2.setIcon(dodeliSlicicu(game.w));
//			lblRez3.setIcon(dodeliSlicicu(game.e));
//			lblRez4.setIcon(dodeliSlicicu(game.r));
			JOptionPane.showMessageDialog(new JFrame(), "P O B E D I L I    S T E !!!");
		}
	}
	
	//Metoda koja brise sve lebele tako da igra moze krenuti od pocetka opet od prvog reda
	private JButton getBtnPokusajPonovo() {
		if (btnPokusajPonovo == null) {
			btnPokusajPonovo = new JButton("POKUSAJ PONOVO");
			btnPokusajPonovo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					trenutniRed = 1;
					lbl1.setIcon(null);
					lbl2.setIcon(null);
					lbl3.setIcon(null);
					lbl4.setIcon(null);
					lbl5.setIcon(null);
					lbl6.setIcon(null);
					lbl7.setIcon(null);
					lbl8.setIcon(null);
					lbl9.setIcon(null);
					lbl10.setIcon(null);
					lbl11.setIcon(null);
					lbl12.setIcon(null);
					lbl13.setIcon(null);
					lbl14.setIcon(null);
					lbl15.setIcon(null);
					lbl16.setIcon(null);
					lbl17.setIcon(null);
					lbl18.setIcon(null);
					lbl19.setIcon(null);
					lbl20.setIcon(null);
					lbl21.setIcon(null);
					lbl22.setIcon(null);
					lbl23.setIcon(null);
					lbl24.setIcon(null);
					rez1.setText("");
					rez2.setText("");
					rez3.setText("");
					rez4.setText("");
					rez5.setText("");
					rez6.setText("");
					lblRez1.setIcon(null);
					lblRez2.setIcon(null);
					lblRez3.setIcon(null);
					lblRez4.setIcon(null);
//					game.q = ThreadLocalRandom.current().nextInt(1, 7);
//					game.w = ThreadLocalRandom.current().nextInt(1, 7);
//					game.e = ThreadLocalRandom.current().nextInt(1, 7);
//					game.r = ThreadLocalRandom.current().nextInt(1, 7);
//					System.out.println("Resenje je: " + ispisiZnak(game.q) + " " + ispisiZnak(game.w) + " "
//							+ ispisiZnak(game.e) + " " + ispisiZnak(game.r));
				}
			});
			btnPokusajPonovo.setBounds(260, 612, 170, 36);
		}
		return btnPokusajPonovo;
	}

	//Pomocna metoda samo zbog ispisivanja resenja u konzoli
	public static String ispisiZnak(int x) {
		switch (x) {
		case 1:
			return "pik";
		case 2:
			return "tref";
		case 3:
			return "herz";
		case 4:
			return "karo";
		case 5:
			return "zvezda";
		case 6:
			return "joker";

		default:
			return "GRESKA";
		}
	}
}
