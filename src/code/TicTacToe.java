package code;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class TicTacToe {

	JFrame window = new JFrame();
	JRadioButton player1 = new JRadioButton();
	JRadioButton player2 = new JRadioButton();
	JLabel playerScore = new JLabel();
	ButtonGroup group = new ButtonGroup();
	int player1Scorecount = 0;
	int player2Scorecount = 0;
	int counter = 0;
	private JButton[][] buttons;
	private JButton newGame = new JButton();

	public TicTacToe() {

		buttons = new JButton[3][3];
		window.setTitle("TicTacToe");
		window.getContentPane();
		window.setLayout(new GridLayout(4, 2));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setBackground(Color.white);
				buttons[i][j].setBorder(new LineBorder(Color.BLACK));
				buttons[i][j].addActionListener(new ButtonPress());
				window.add(buttons[i][j]);
			}
		}

		group.add(player1);
		group.add(player2);

		player1.setText("Player 1");
		player2.setText("Player 2");

		window.add(player1);
		window.add(player2);

		playerScore.setText(
				"<html><body>Player 1: " + player1Scorecount + "<br>Player 2: " + player2Scorecount + "</body></html>");
		window.add(playerScore);

		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				restart();
			}
		});
		newGame.setText("New Game");

		window.repaint();
		window.setVisible(true);
		window.setSize(500, 500);

		choosePlayer();

	}

	private void choosePlayer() {

		String[] options = { "Player 1", "Player 2", "Random" };

		int choosePlayer = JOptionPane.showOptionDialog(null, "Who should make the first move?", "Start",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

		if (choosePlayer == 0) {
			player1.setSelected(true);
		} else if (choosePlayer == 1) {
			player2.setSelected(true);

		} else {
			Random random = new Random();
			boolean bool = random.nextBoolean();

			if (bool == true) {
				player1.setSelected(true);
			} else if (bool == false) {
				player2.setSelected(true);
			}
		}
	}

	private void restart() {

		counter = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j].setEnabled(true);
				buttons[i][j].setBackground(Color.white);
			}
		}
		choosePlayer();
	}

	private void checkWin() {

		counter++;
		
		for (int i = 0; i < 3; i++) {
			if (buttons[i][0].getBackground() == Color.red && buttons[i][1].getBackground() == Color.red
					&& buttons[i][2].getBackground() == Color.red) {
				player1Scorecount++;
				playerScore.setText("<html><body>Player 1: " + player1Scorecount + "<br>Player 2: " + player2Scorecount
						+ "</body></html>");
				JOptionPane.showMessageDialog(window, "Player 1 has won");
				int newGame = JOptionPane.showConfirmDialog(window, "New Game?", null, JOptionPane.YES_NO_OPTION);

				if (newGame == 0) {
					restart();
				}

			} else if (buttons[i][0].getBackground() == Color.green && buttons[i][1].getBackground() == Color.green
					&& buttons[i][2].getBackground() == Color.green) {
				player2Scorecount++;
				playerScore.setText("<html><body>Player 1: " + player1Scorecount + "<br>Player 2: " + player2Scorecount
						+ "</body></html>");
				JOptionPane.showMessageDialog(window, "Player 2 has won");
				int newGame = JOptionPane.showConfirmDialog(window, "New Game?", null, JOptionPane.YES_NO_OPTION);

				if (newGame == 0) {
					restart();
				}

			} else if (buttons[0][i].getBackground() == Color.red && buttons[1][i].getBackground() == Color.red
					&& buttons[2][i].getBackground() == Color.red) {
				player1Scorecount++;
				playerScore.setText("<html><body>Player 1: " + player1Scorecount + "<br>Player 2: " + player2Scorecount
						+ "</body></html>");
				JOptionPane.showMessageDialog(window, "Player 1 has won");
				int newGame = JOptionPane.showConfirmDialog(window, "New Game?", null, JOptionPane.YES_NO_OPTION);

				if (newGame == 0) {
					restart();
				}
			}

			else if (buttons[0][i].getBackground() == Color.green && buttons[1][i].getBackground() == Color.green
					&& buttons[2][i].getBackground() == Color.green) {
				player2Scorecount++;
				playerScore.setText("<html><body>Player 1: " + player1Scorecount + "<br>Player 2: " + player2Scorecount
						+ "</body></html>");
				JOptionPane.showMessageDialog(window, "Player 2 has won");
				int newGame = JOptionPane.showConfirmDialog(window, "New Game?", null, JOptionPane.YES_NO_OPTION);

				if (newGame == 0) {
					restart();
				}
			}

		}

		if (buttons[0][2].getBackground() == Color.red && buttons[1][1].getBackground() == Color.red
				&& buttons[2][0].getBackground() == Color.red) {
			player1Scorecount++;
			playerScore.setText("<html><body>Player 1: " + player1Scorecount + "<br>Player 2: " + player2Scorecount
					+ "</body></html>");
			JOptionPane.showMessageDialog(window, "Player 1 has won");
			int newGame = JOptionPane.showConfirmDialog(window, "New Game?", null, JOptionPane.YES_NO_OPTION);

			if (newGame == 0) {
				restart();
			}
		}

		else if (buttons[0][2].getBackground() == Color.green && buttons[1][1].getBackground() == Color.green
				&& buttons[2][0].getBackground() == Color.green) {
			player2Scorecount++;
			playerScore.setText("<html><body>Player 1: " + player1Scorecount + "<br>Player 2: " + player2Scorecount
					+ "</body></html>");
			JOptionPane.showMessageDialog(window, "Player 2 has won");
			int newGame = JOptionPane.showConfirmDialog(window, "New Game?", null, JOptionPane.YES_NO_OPTION);
			if (newGame == 0) {
				restart();
			}
		}

		else if (buttons[0][0].getBackground() == Color.red && buttons[1][1].getBackground() == Color.red
				&& buttons[2][2].getBackground() == Color.red) {
			player1Scorecount++;
			playerScore.setText("<html><body>Player 1: " + player1Scorecount + "<br>Player 2: " + player2Scorecount
					+ "</body></html>");
			JOptionPane.showMessageDialog(window, "Player 1 has won");
			int newGame = JOptionPane.showConfirmDialog(window, "New Game?", null, JOptionPane.YES_NO_OPTION);

			if (newGame == 0) {
				restart();
			}
		}

		else if (buttons[0][0].getBackground() == Color.green && buttons[1][1].getBackground() == Color.green
				&& buttons[2][2].getBackground() == Color.green) {
			player2Scorecount++;
			playerScore.setText("<html><body>Player 1: " + player1Scorecount + "<br>Player 2: " + player2Scorecount
					+ "</body></html>");
			JOptionPane.showMessageDialog(window, "Player 2 has won");
			int newGame = JOptionPane.showConfirmDialog(window, "New Game?", null, JOptionPane.YES_NO_OPTION);

			if (newGame == 0) {
				restart();
			}
		}
		
		if(counter == 9) {
			JOptionPane.showMessageDialog(window, "Draw");
			int newGame = JOptionPane.showConfirmDialog(window, "New Game?", null, JOptionPane.YES_NO_OPTION);

			if (newGame == 0) {
				restart();
			}
		}
		
	}

	private class ButtonPress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (player1.isSelected()) {
				group.clearSelection();
				player2.setSelected(true);

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (((JButton) e.getSource()).equals(buttons[i][j])) {
							buttons[i][j].setBackground(Color.red);
							buttons[i][j].setEnabled(false);
						}
					}
				}
				checkWin();
			} else {
				group.clearSelection();
				player1.setSelected(true);

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (((JButton) e.getSource()).equals(buttons[i][j])) {
							buttons[i][j].setBackground(Color.green);
							buttons[i][j].setEnabled(false);
						}
					}
				}
				checkWin();
			}
		}
	}
}
