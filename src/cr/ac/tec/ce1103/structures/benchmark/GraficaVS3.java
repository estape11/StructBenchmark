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
import cr.ac.tec.ce1103.structures.trees.AVLTree;
import cr.ac.tec.ce1103.structures.trees.BinarySearchTree;
import cr.ac.tec.ce1103.structures.trees.Splaytree;

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
public class GraficaVS3{
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
	public GraficaVS3() {
			
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
		
		JLabel lblSearch = new JLabel("Search ->");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSearch.setBounds(10, 500, 86, 14);
		frame.getContentPane().add(lblSearch);
		
		JRadioButton bst = new JRadioButton("Binary Search Tree");
		bst.setBounds(102, 536, 135, 23);
		frame.getContentPane().add(bst);
		
		JRadioButton avl = new JRadioButton("AVL Tree");
		avl.setBounds(275, 536, 109, 23);
		frame.getContentPane().add(avl);
		
		JRadioButton st = new JRadioButton("Splay Tree");
		st.setBounds(441, 536, 109, 23);
		frame.getContentPane().add(st);
		
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
				XYSeries bint = new XYSeries("BinarySearch Tree");
				XYSeries avlt = new XYSeries("AVL Tree");
				XYSeries splt = new XYSeries("Splay Tree");
				XYPlot plot;
				
				if (practico.isSelected()){
					Integer[] Arreglo= Sort.RandomArray(size);
					int buscar=Arreglo[size/2];
					if (bst.isSelected()){
						BinarySearchTree<Integer> binario=new BinarySearchTree<>();
						for(int i=0;i<size;i++){
							binario.Insert(Arreglo[i]);
						}
						long t1= System.nanoTime();
						binario.Search(buscar);
						long t2= System.nanoTime();
						bint.add(0, 0);
						long prome=(t2-t1);
						bint.add(size, prome);
						dataset.addSeries(bint);
					}			
					if (avl.isSelected()){
						AVLTree avltree=new AVLTree();
						for(int i=0;i<size;i++){
							System.out.println("HELL2"+i);
							avltree.insertar(Arreglo[i]);
						}
						System.out.println("HELL");
						long t1= System.nanoTime();
						avltree.buscar(buscar, avltree.raiz);
						long t2= System.nanoTime();
						avlt.add(0, 0);
						long prome=(t2-t1);
						avlt.add(size, prome);
						dataset.addSeries(avlt);
					}
					if (st.isSelected()){
						Splaytree<Integer, Integer> splay=new Splaytree<>();
						for(int i=0;i<size;i++){
							splay.put(Arreglo[i],Arreglo[i]);
						}
						long t1= System.nanoTime();
						splay.get(buscar);
						long t2= System.nanoTime();
						splt.add(0, 0);
						long prome=(t2-t1);
						splt.add(size, prome);
						dataset.addSeries(splt);
					}
				} 
				else if(teorico.isSelected()){
					if (bst.isSelected()){
						for (int i=1;i<size;i++){
							bint.add(i,Math.log10(i));
						}
						dataset.addSeries(bint);
					}			
					if (avl.isSelected()){
						for (int i=1;i<size;i++){
							avlt.add(i,Math.log10(i));
						}
						dataset.addSeries(avlt);
					}
					if (st.isSelected()){
						
						for (int i=1;i<size;i++){
							splt.add(i,Math.log10(i));
						}
						dataset.addSeries(splt);
					}
				}
				else if(mejor.isSelected()){
					if (bst.isSelected()){
						for (int i=1;i<size;i++){
							bint.add(i,i);
						}
						dataset.addSeries(bint);
					}			
					if (avl.isSelected()){
						for (int i=1;i<size;i++){
							avlt.add(i,Math.log10(i));
						}
						dataset.addSeries(avlt);
					}
					if (st.isSelected()){
						
						for (int i=1;i<size;i++){
							splt.add(i,Math.log10(i));
						}
						dataset.addSeries(splt);
					}
				}
				
				
				panel.removeAll();
				x.setLabel("Número de elementos en el árbol");
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
