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

import cr.ac.tec.ce1103.structures.simple.BinarySearch;
import cr.ac.tec.ce1103.structures.simple.linearSearch;
import cr.ac.tec.ce1103.structures.sort.SortingAlgorithm;
import cr.ac.tec.ce1103.structures.sort.mergeSort;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
/**
 * Clase encargada de la graficacion
 * @author Esteban Agï¿½ero Pï¿½rez
 *
 */
public class GraficaVS2{
	/**
	 * Medodos encargados de la graficacion
	 */
	public JFrame frame;
	private JTextField numDatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public GraficaVS2() {
			
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void peorCaso(){
		
		
		
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 626, 680);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		panel.setBounds(87, 11, 450, 478);
		frame.getContentPane().add(panel);

		
		
		numDatos = new JTextField();
		numDatos.setBounds(324, 585, 86, 20);
		frame.getContentPane().add(numDatos);
		numDatos.setColumns(10);
		
		JLabel lblNmeroDeDatos = new JLabel("N\u00FAmero de Datos");
		lblNmeroDeDatos.setBounds(189, 587, 123, 14);
		frame.getContentPane().add(lblNmeroDeDatos);
		
		JRadioButton teorico = new JRadioButton("Te\u00F3rico");
		teorico.setFont(new Font("Tahoma", Font.PLAIN, 17));
		teorico.setBounds(102, 496, 86, 23);
		frame.getContentPane().add(teorico);
		
		JRadioButton practico = new JRadioButton("Pr\u00E1ctico");
		practico.setFont(new Font("Tahoma", Font.PLAIN, 17));
		practico.setBounds(275, 496, 109, 23);
		frame.getContentPane().add(practico);
		
		JButton btnGraficar = new JButton("Graficar");
		btnGraficar.setBounds(255, 616, 117, 25);
		frame.getContentPane().add(btnGraficar);
		
		JLabel lblPeorCaso = new JLabel("Caso promedio");
		lblPeorCaso.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblPeorCaso.setBounds(189, 502, 77, 17);
		frame.getContentPane().add(lblPeorCaso);
		
		JRadioButton mejor = new JRadioButton("Mejor caso");
		mejor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mejor.setBounds(441, 496, 143, 23);
		frame.getContentPane().add(mejor);
		
		JRadioButton ls = new JRadioButton("LinearSearch");
		ls.setBounds(173, 536, 109, 23);
		frame.getContentPane().add(ls);
		
		JRadioButton bs = new JRadioButton("BinarySearch");
		bs.setBounds(369, 536, 109, 23);
		frame.getContentPane().add(bs);
		
		btnGraficar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				int size=Integer.parseInt(numDatos.getText());
				SortingAlgorithm<Integer> Sort=new SortingAlgorithm<Integer>();
				linearSearch LS=new linearSearch();
				BinarySearch<Integer> BS=new BinarySearch<>();
				int validar = 1;
				XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
				XYSeriesCollection dataset = new XYSeriesCollection();
				
				ValueAxis x = new NumberAxis();
				ValueAxis y = new NumberAxis();
				XYSeries serie = new XYSeries("practico");
				XYSeries serie1 = new XYSeries("teorico");
				XYSeries lis = new XYSeries("LinearSearch");
				XYSeries bis = new XYSeries("BinarySearch");
				
				XYPlot plot;
				
				if (practico.isSelected()){
					Integer[] Arreglo= Sort.RandomArray(size);
					Integer buscar=Arreglo[size/2];
					System.out.println("HELLO");
					if (ls.isSelected()){
						System.out.println("HELLO");
						long t1= System.nanoTime();
						LS.search(Arreglo, buscar);
						System.out.println("HE");
						long t2= System.nanoTime();
						lis.add(0, 0);
						long prome=(t2-t1);
						lis.add(size, prome);
						dataset.addSeries(lis);
					}			
					if (bs.isSelected()){
						Integer[] arreglo2=BS.Ordenar(Arreglo);
						long t1= System.nanoTime();
						BS.Busqueda(arreglo2, buscar);
						long t2= System.nanoTime();
						bis.add(0, 0);
						long prome=(t2-t1);
						bis.add(size, prome);
						dataset.addSeries(bis);
					}
				} 
				else if(teorico.isSelected()){
					if (ls.isSelected()){
						for (int i=1;i<size;i++){
							lis.add(i,i);
						}
						dataset.addSeries(lis);
					}			
					if (bs.isSelected()){
						for (int i=1;i<size;i++){
							bis.add(i,Math.log10(i));
						}
						dataset.addSeries(bis);
					}
				}
				else if(mejor.isSelected()){
					if (ls.isSelected()){
						for (int i=1;i<size;i++){
							lis.add(i,1);
						}
						dataset.addSeries(lis);
					}			
					if (bs.isSelected()){
						for (int i=1;i<size;i++){
							bis.add(i,1);
						}
						dataset.addSeries(bis);
					}
				}
				
				
				panel.removeAll();
				x.setLabel("Número de elementos en la lista");
				y.setLabel("Tiempo");
				plot = new XYPlot(dataset, x, y, renderer);
				JFreeChart chart = new JFreeChart(plot);
				chart.setTitle("VS");
				ChartPanel pan = new ChartPanel(chart);
				pan.setBounds(5, 10, 450, 400);
				panel.add(pan);
				panel.repaint();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Entrada invalida, verifique su seleccion");

				}
			}
		});
	
	}
}
