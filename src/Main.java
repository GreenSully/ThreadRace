import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {

	public static void main(final String[] args) {
		JFrame f = new JFrame("caricamento");
		f.setPreferredSize(new Dimension(600, 300));

		f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.X_AXIS));
		Barretta[] barre = new Barretta[100];
		JButton bot = new JButton("START");
		f.add(bot);
		for (int i = 0; i < barre.length; i++) {
			barre[i] = new Barretta(i);
			f.add(barre[i]);
		}



		bot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				for (int i = 0; i < barre.length; i++) {

					Thread t = new Thread(barre[i]);
					t.setPriority((int) (Math.random() * 10) + 1);
					t.start();
				}
			}
		});

		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
