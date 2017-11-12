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
 * @author Esteban Ag�ero P�rez
 *
 */
public class GraficaVS{
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
	public GraficaVS() {

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

		JRadioButton bb = new JRadioButton("BubbleSort");
		bb.setBounds(102, 522, 141, 23);
		frame.getContentPane().add(bb);

		JRadioButton hs = new JRadioButton("HeapSort");
		hs.setBounds(275, 523, 135, 23);
		frame.getContentPane().add(hs);

		JRadioButton is = new JRadioButton("InsertionSort");
		is.setBounds(441, 548, 135, 23);
		frame.getContentPane().add(is);

		JRadioButton qs = new JRadioButton("QuickSort");
		qs.setBounds(441, 522, 109, 23);
		frame.getContentPane().add(qs);

		JRadioButton ss = new JRadioButton("SelectionSort");
		ss.setBounds(102, 548, 152, 23);
		frame.getContentPane().add(ss);

		JRadioButton ms = new JRadioButton("MergeSort");
		ms.setBounds(275, 549, 109, 23);
		frame.getContentPane().add(ms);

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

		btnGraficar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int size=Integer.parseInt(numDatos.getText());
					SortingAlgorithm<Integer> Sort=new SortingAlgorithm<Integer>();
					int validar = 1;
					XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
					XYSeriesCollection dataset = new XYSeriesCollection();

					ValueAxis x = new NumberAxis();
					ValueAxis y = new NumberAxis();
					XYSeries serie = new XYSeries("practico");
					XYSeries serie1 = new XYSeries("teorico");
					XYSeries merge = new XYSeries("MergeSort");
					XYSeries bubble = new XYSeries("BubbleSort");
					XYSeries quick = new XYSeries("QuickSort");
					XYSeries Select = new XYSeries("SelectionSort");
					XYSeries heap = new XYSeries("HeapSort");
					XYSeries insert = new XYSeries("InsertionSort");
					XYPlot plot;

					if (practico.isSelected()){
						if (bb.isSelected()){

							Integer[] Arreglo= Sort.RandomArray(size);
							long t1= System.nanoTime();
							Sort.BubbleSort(Arreglo);
							long t2= System.nanoTime();
							bubble.add(0, 0);
							long prome=(t2-t1)/1000000;
							//bubble.add(size, t2-t1);
							final long duro=(size/prome);
							System.out.println(prome);
							System.out.println(duro);
							long j=0;
							for (long i=1;i<(prome);i++){
								j+=duro;
								bubble.add(j,i);
							}
							System.out.println(j);
							bubble.add(size,prome);
							dataset.addSeries(bubble);
						}			
						if (ss.isSelected()){

							Integer[] Arreglo= Sort.RandomArray(size);
							long t1= System.nanoTime();
							Sort.SelectionSort(Arreglo);
							long t2= System.nanoTime();
							Select.add(0, 0);
							long prome=t2-t1;
							try{
								prome=(t2-t1)/1000000;
								long j=0;
								final long duro=(size/prome);

								for (long i=1;i<(prome);i++){
									j+=duro;
									Select.add(j,i);
								}
							}catch(Exception f){}
							finally{
								Select.add(size, prome);
								dataset.addSeries(Select);
							}
						}
						if (qs.isSelected()){

							Integer[] Arreglo= Sort.RandomArray(size);
							long t1= System.nanoTime();
							Sort.QuickSort(Arreglo);
							long t2= System.nanoTime();
							quick.add(0, 0);
							long prome=t2-t1;
							try{
								prome=(t2-t1)/1000000;
								long j=0;
								final long duro=(size/prome);

								for (long i=1;i<(prome);i++){
									j+=duro;
									quick.add(j,i);
								}
							}catch(Exception g){}
							finally{
								quick.add(size, prome);
								dataset.addSeries(quick);
							}
						}
						if(hs.isSelected()){

							Integer[] Arreglo= Sort.RandomArray(size);
							long t1= System.nanoTime();
							Sort.HeapSort(Arreglo);
							long t2= System.nanoTime();
							heap.add(0, 0);
							long prome=t2-t1;
							try{
								prome=(t2-t1)/1000000;
								long j=0;
								final long duro=(size/prome);

								for (long i=1;i<(prome);i++){
									j+=duro;
									heap.add(j,i);
								}
							}catch(Exception je){}
							heap.add(size, prome);
							dataset.addSeries(heap);
						}
						if (is.isSelected()){

							Integer[] Arreglo= Sort.RandomArray(size);
							long t1= System.nanoTime();
							Sort.InsertionSort(Arreglo);
							long t2= System.nanoTime();
							insert.add(0, 0);
							long prome=t2-t1;
							try{
								prome=(t2-t1)/1000000;
								long j=0;
								final long duro=(size/prome);

								for (long i=1;i<(prome);i++){
									j+=duro;
									insert.add(j,i);
								}
							}catch(Exception err){}
							insert.add(size, prome);
							dataset.addSeries(insert);
						}
						if (ms.isSelected()){
							Integer[] Arreglo= Sort.RandomArray(size);
							long t1= System.nanoTime();
							Sort.mergeSort(Arreglo);
							long t2= System.nanoTime();
							merge.add(0, 0);
							long prome=(t2-t1);
							try{
								prome=(t2-t1)/1000000;
								long j=0;
								final long duro=(size/prome);

								for (long i=1;i<(prome);i++){
									j+=duro;
									merge.add(j,i);
								}
							}catch(Exception k){}
							finally{
								merge.add(size, prome);
								dataset.addSeries(merge);}
						}
					} 
					else if(teorico.isSelected()){
						if (bb.isSelected()){
							for (int i=1;i<size;i++){
								bubble.add(i,Math.pow(i,2));
							}
							dataset.addSeries(bubble);
						}			
						if (ss.isSelected()){
							for (int i=1;i<size;i++){
								Select.add(i,Math.pow(i,2));
							}
							dataset.addSeries(Select);
						}
						if (qs.isSelected()){

							for (int i=1;i<size;i++){
								quick.add(i,i*Math.log10(i));
							}
							dataset.addSeries(quick);
						}
						if(hs.isSelected()){

							for (int i=1;i<size;i++){
								heap.add(i,i*Math.log10(i));
							}
							dataset.addSeries(heap);
						}
						if (is.isSelected()){

							for (int i=1;i<size;i++){
								insert.add(i,Math.pow(i,2));
							}
							dataset.addSeries(insert);
						}
						if (ms.isSelected()){

							for (int i=1;i<size;i++){
								merge.add(i,i*Math.log10(i));
							}
							dataset.addSeries(merge);
						}
					}
					else if(mejor.isSelected()){
						if (bb.isSelected()){
							for (int i=1;i<size;i++){
								bubble.add(i,i);
							}
							dataset.addSeries(bubble);
						}			
						if (ss.isSelected()){
							for (int i=1;i<size;i++){
								Select.add(i,Math.pow(i,2));
							}
							dataset.addSeries(Select);
						}
						if (qs.isSelected()){

							for (int i=1;i<size;i++){
								quick.add(i,i*Math.log10(i));
							}
							dataset.addSeries(quick);
						}
						if(hs.isSelected()){

							for (int i=1;i<size;i++){
								heap.add(i,i*Math.log10(i));
							}
							dataset.addSeries(heap);
						}
						if (is.isSelected()){

							for (int i=1;i<size;i++){
								insert.add(i,1);
							}
							dataset.addSeries(insert);
						}
						if (ms.isSelected()){
							for (int i=1;i<size;i++){
								merge.add(i,i*(Math.log10(i)));
							}
							dataset.addSeries(merge);
						}
					}


					panel.removeAll();
					x.setLabel("Datos");
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
