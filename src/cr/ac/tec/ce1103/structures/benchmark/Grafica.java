package cr.ac.tec.ce1103.structures.benchmark;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import org.jfree.chart.*;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Clase encargada de la graficacion
 * @author Esteban Agüero Pérez
 *
 */
public class Grafica {
	/**
	 * Medodos encargados de la graficacion
	 */
	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 */
	public Grafica() {
			
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void peorCaso(){
		
		
		
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 626, 603);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		panel.setBounds(72, 47, 450, 478);
		frame.getContentPane().add(panel);

		JButton btnGraficar = new JButton("Graficar");
		btnGraficar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int validar = 1;
				XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
				XYSeriesCollection dataset = new XYSeriesCollection();
				ValueAxis x = new NumberAxis();
				ValueAxis y = new NumberAxis();
				XYSeries serie = new XYSeries("practico");
				XYSeries serie1 = new XYSeries("teorico");
				XYPlot plot;
				panel.removeAll();
				for(int i=0;i<Interfaz.datos1.getItemCount();i++){
					int dato=Integer.parseInt(Interfaz.datos1.getItem(i));
					double tiempo=Double.parseDouble(Interfaz.tiempos.getItem(i))/1E9;
					serie.add( dato,tiempo);
				}
				serie.add(0, 0);
				if (Interfaz.algoritmo.equals("BubbleSort")){
					for (int i=1;i<Interfaz.SizeIN;i++){
						serie1.add(i,Math.pow(i,2)/1E7);
					}
					dataset.addSeries(serie1);
				}
				/*serie.add(0, 0);
				serie.add(1, 3);
				serie.add(3, 4);
				serie.add(5, 7);
				serie.add(6, 9);
				serie.add(8, 12);
				serie.add(10, 15);
				serie1.add(0, 0);
				serie1.add(1, 2);
				serie1.add(2, 3);
				serie1.add(5, 6);
				serie1.add(6, 7);
				serie1.add(7, 11);
				serie1.add(10, 13);*/
				dataset.addSeries(serie);
				
				x.setLabel("Datos");
				y.setLabel("Tiempo");
				plot = new XYPlot(dataset, x, y, renderer);
				JFreeChart chart = new JFreeChart(plot);
				chart.setTitle(Interfaz.algoritmo);
				ChartPanel pan = new ChartPanel(chart);
				pan.setBounds(5, 10, 450, 400);
				panel.add(pan);
				panel.repaint();
			}
		});
		btnGraficar.setBounds(253, 537, 117, 25);
		frame.getContentPane().add(btnGraficar);
	}
}
