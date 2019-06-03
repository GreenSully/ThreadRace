import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Barretta extends JPanel implements Runnable {
	private int name;
	private Dimension dim;
	private static Integer a = new Integer(1816);

	public Barretta(final int i) {
		super();
		name = i;
		this.setBackground(Color.GREEN);
		dim = new Dimension(10, 10);
		this.setSize(dim);
	}

	@Override
	public void run() {
		synchronized (a) {
			a = 1816;
			dim = new Dimension(10, 10);
			this.setSize(dim);
			this.setBackground(Color.getHSBColor((float) Math.random(), (float) Math.random(),
					(float) Math.random()));
		}
		while (true) {
			synchronized (a) {
				if (a == 0) {
					break;
				}
				dim.setSize(dim.width, dim.height + (int) (Math.random() * 10) + 1);
				this.setSize(dim);
				this.setBackground(Color.getHSBColor((float) Math.random(), (float) Math.random(),
						(float) Math.random()));
				if (dim.height > 700) {
					a = 0;
					this.setBackground(Color.BLUE);
					System.out.println("Vince il numero " + (name + 1));

				}

			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
