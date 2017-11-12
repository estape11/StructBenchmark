package cr.ac.tec.ce1103.structures.benchmark;
import java.awt.EventQueue;
import cr.ac.tec.ce1103.structures.simple.*;
import cr.ac.tec.ce1103.structures.trees.*;
import cr.ac.tec.ce1103.structures.sort.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JCheckBox;
import java.awt.List;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.JScrollPane;

public class Interfaz {
	public static String algoritmo="";
	private boolean estadoBorrar=false;
	private boolean estadoInsertar=false;
	private boolean estadoBuscar=false;
	public static ListaEnlazada listaTree;
	public static DoubleLinkedList listaDoble;
	String typeTree="";
	static List tiempos = new List();
	static List datos1=new List();
	int cont=0;
	AVLTree arbolAVL=new AVLTree();
	Splaytree arbolSplay=new Splaytree();
	BinarySearchTree arbolBinario=new BinarySearchTree();
	public JPanel ventana = null;
	public JMenuItem off = null;
	Integer[] inputArr;
	static int SizeIN = 0;
	private JFrame frame;
	private JTextField txtLinked;
	private JTextField txtTrees;
	private JTextField txtSearch;
	private JTextField txtinputSorting;
	private JTextField txtInSearch;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
					window.frame.setTitle("StructBenchmark");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SortingAlgorithm<Integer> Sort=new SortingAlgorithm<Integer>();
		frame = new JFrame();
		frame.setBounds(100, 100, 440, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setResizable(false);

		JPanel panelPrincipal = new JPanel();
		frame.getContentPane().add(panelPrincipal, "name_5069446921495");
		panelPrincipal.setLayout(null);

		JButton button = new JButton("Sorting Algorithms");
		button.setBounds(0, 58, 447, 27);
		panelPrincipal.add(button);

		JButton button_1 = new JButton("Search Algorithms");
		button_1.setBounds(0, 118, 447, 27);
		panelPrincipal.add(button_1);

		JButton button_2 = new JButton("Linked List");
		button_2.setBounds(0, 176, 447, 27);
		panelPrincipal.add(button_2);

		JButton button_3 = new JButton("Trees");
		button_3.setBounds(0, 239, 447, 27);
		panelPrincipal.add(button_3);

		JPanel panelSorting = new JPanel();
		frame.getContentPane().add(panelSorting, "name_4992490940608");
		panelSorting.setLayout(null);

		JButton btnSort = new JButton("Sort");
		btnSort.setBounds(66, 307, 129, 15);
		panelSorting.add(btnSort);

		JLabel lblDato = new JLabel("=>");
		lblDato.setBounds(201, 135, 29, 15);
		panelSorting.add(lblDato);

		JButton btnAddSort = new JButton("New List");
		btnAddSort.setBounds(259, 44, 97, 15);
		panelSorting.add(btnAddSort);

		JCheckBox checkBubble = new JCheckBox("BubbleSort");
		checkBubble.setBounds(66, 237, 129, 23);
		panelSorting.add(checkBubble);

		JCheckBox checkInsertion = new JCheckBox("InsertionSort");
		checkInsertion.setBounds(66, 256, 129, 23);
		panelSorting.add(checkInsertion);

		JCheckBox checkQuick = new JCheckBox("QuickSort");
		checkQuick.setBounds(66, 276, 129, 23);
		panelSorting.add(checkQuick);

		JCheckBox checkSelection = new JCheckBox("SelectionSort");
		checkSelection.setBounds(227, 237, 129, 23);
		panelSorting.add(checkSelection);

		JCheckBox checkMerge = new JCheckBox("MergeSort");
		checkMerge.setBounds(227, 256, 129, 23);
		panelSorting.add(checkMerge);

		JCheckBox checkHeap = new JCheckBox("HeapSort");
		checkHeap.setBounds(227, 276, 129, 23);
		panelSorting.add(checkHeap);

		List list = new List();
		list.setBounds(66, 86, 129, 145);
		panelSorting.add(list);

		List list_1 = new List();
		list_1.setBounds(231, 86, 125, 145);
		panelSorting.add(list_1);

		txtinputSorting = new JTextField();
		txtinputSorting.setBounds(133, 42, 114, 19);
		panelSorting.add(txtinputSorting);
		txtinputSorting.setColumns(10);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(66, 44, 70, 15);
		panelSorting.add(lblQuantity);

		JCheckBox checkRandomList = new JCheckBox("Random List");
		checkRandomList.setSelected(true);
		checkRandomList.setBounds(8, 0, 129, 23);
		panelSorting.add(checkRandomList);

		JCheckBox checkEntryList = new JCheckBox("Entry List");
		checkEntryList.setEnabled(false);
		checkEntryList.setBounds(345, 0, 92, 23);
		panelSorting.add(checkEntryList);

		JButton btnGraphSort = new JButton("Graph");
		btnGraphSort.setBounds(227, 307, 125, 15);
		panelSorting.add(btnGraphSort);
		
		JLabel lblCont = new JLabel("Cont:");
		lblCont.setBounds(183, 8, 38, 15);
		panelSorting.add(lblCont);
		
		JLabel lblContSorting = new JLabel("0");
		lblContSorting.setBounds(222, 8, 45, 15);
		panelSorting.add(lblContSorting);
		
		JButton btnGraphVs = new JButton("Graph VS");
		btnGraphVs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GraficaVS window = new GraficaVS();
					window.frame.setVisible(true);
					window.frame.setTitle("Grafica Algoritmo VS Algoritmo");
				} catch (Exception z) {
					z.printStackTrace();
				}
			}
		});
		btnGraphVs.setBounds(66, 333, 129, 15);
		panelSorting.add(btnGraphVs);

		JPanel panelSearch = new JPanel();
		frame.getContentPane().add(panelSearch, "name_4995466946637");
		panelSearch.setLayout(null);

		JButton btnSearchS = new JButton("Search");
		btnSearchS.setBounds(222, 160, 132, 15);
		panelSearch.add(btnSearchS);

		JLabel lblSearch = new JLabel("Quantity");
		lblSearch.setBounds(76, 65, 70, 15);
		panelSearch.add(lblSearch);

		JButton btnAddS = new JButton("New List");
		btnAddS.setBounds(259, 65, 95, 15);
		panelSearch.add(btnAddS);

		JCheckBox checkBinaryS = new JCheckBox("BinarySearch");
		checkBinaryS.setBounds(76, 273, 129, 23);
		panelSearch.add(checkBinaryS);

		JCheckBox checkLinearS = new JCheckBox("LinearSearch");
		checkLinearS.setBounds(237, 273, 129, 23);
		panelSearch.add(checkLinearS);

		txtSearch = new JTextField();
		txtSearch.setBounds(222, 129, 132, 19);
		panelSearch.add(txtSearch);
		txtSearch.setColumns(10);

		JLabel lblValue = new JLabel("Value");
		lblValue.setBounds(222, 110, 70, 15);
		panelSearch.add(lblValue);

		JButton btnGraph = new JButton("Graph");
		btnGraph.setBounds(222, 197, 132, 15);
		panelSearch.add(btnGraph);

		txtInSearch = new JTextField();
		txtInSearch.setColumns(10);
		txtInSearch.setBounds(143, 63, 114, 19);
		panelSearch.add(txtInSearch);

		List list_2 = new List();
		list_2.setBounds(76, 107, 129, 160);
		panelSearch.add(list_2);

		JCheckBox checkRandomSearch = new JCheckBox("Random List");
		checkRandomSearch.setSelected(true);
		checkRandomSearch.setBounds(8, 8, 129, 23);
		panelSearch.add(checkRandomSearch);

		JCheckBox checkEntrySearch = new JCheckBox("Entry List");
		checkEntrySearch.setEnabled(false);
		checkEntrySearch.setBounds(330, 8, 92, 23);
		panelSearch.add(checkEntrySearch);
		
		JLabel lblCont_1 = new JLabel("Cont:");
		lblCont_1.setBounds(184, 16, 38, 15);
		panelSearch.add(lblCont_1);
		
		JLabel lblContSearch = new JLabel("0");
		lblContSearch.setBounds(222, 16, 70, 15);
		panelSearch.add(lblContSearch);
		
		JButton btnGraphVs_1 = new JButton("Graph VS");
		btnGraphVs_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GraficaVS2 window = new GraficaVS2();
					window.frame.setVisible(true);
					window.frame.setTitle("Grafica Algoritmo VS Algoritmo");
				} catch (Exception z) {
					z.printStackTrace();
				}
			}
		});
		btnGraphVs_1.setBounds(222, 233, 132, 15);
		panelSearch.add(btnGraphVs_1);

		JPanel panelLinked = new JPanel();
		frame.getContentPane().add(panelLinked, "name_4998163025164");
		panelLinked.setLayout(null);

		JButton btnInsertLinked = new JButton("Insert");
		btnInsertLinked.setBounds(84, 273, 85, 15);
		panelLinked.add(btnInsertLinked);

		txtLinked = new JTextField();
		txtLinked.setColumns(10);
		txtLinked.setBounds(179, 240, 114, 19);
		panelLinked.add(txtLinked);

		JLabel label_1 = new JLabel("Value");
		label_1.setBounds(132, 242, 45, 15);
		panelLinked.add(label_1);

		JButton btnDeleteLinked = new JButton("Delete");
		btnDeleteLinked.setBounds(181, 273, 85, 15);
		panelLinked.add(btnDeleteLinked);

		JButton btnSearchLinked = new JButton("Search");
		btnSearchLinked.setBounds(278, 273, 84, 15);
		panelLinked.add(btnSearchLinked);
		
		List list_3 = new List();
		list_3.setBounds(131, 83, 162, 130);
		panelLinked.add(list_3);
		
		JLabel label = new JLabel("Quantity");
		label.setBounds(84, 45, 70, 15);
		panelLinked.add(label);
		
		JButton button_4 = new JButton("New List");
		button_4.setBounds(267, 45, 95, 15);
		panelLinked.add(button_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(151, 43, 114, 19);
		panelLinked.add(textField);
		
		JCheckBox checkBox = new JCheckBox("Random List");
		checkBox.setSelected(true);
		checkBox.setBounds(15, 0, 129, 23);
		panelLinked.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Entry List");
		checkBox_1.setEnabled(false);
		checkBox_1.setBounds(337, 0, 92, 23);
		panelLinked.add(checkBox_1);
		
		JLabel lblContTypeLinked = new JLabel("Cont");
		lblContTypeLinked.setBounds(152, 4, 70, 15);
		panelLinked.add(lblContTypeLinked);
		
		JLabel lblContLinked = new JLabel("0");
		lblContLinked.setBounds(223, 4, 70, 15);
		panelLinked.add(lblContLinked);

		JPanel panelTrees = new JPanel();
		frame.getContentPane().add(panelTrees, "name_5002274970361");
		panelTrees.setLayout(null);

		JButton btnInsertTrees = new JButton("Insert");
		btnInsertTrees.setBounds(50, 263, 85, 15);
		panelTrees.add(btnInsertTrees);
		txtTrees = new JTextField();
		txtTrees.setColumns(10);
		txtTrees.setBounds(138, 41, 114, 19);
		panelTrees.add(txtTrees);

		JLabel label_2 = new JLabel("Value");
		label_2.setBounds(138, 27, 70, 15);
		panelTrees.add(label_2);

		JButton btndeleteTrees = new JButton("Delete");
		btndeleteTrees.setBounds(159, 263, 85, 15);
		panelTrees.add(btndeleteTrees);

		JButton btnSearchTree = new JButton("Search");
		btnSearchTree.setBounds(269, 263, 85, 15);
		panelTrees.add(btnSearchTree);

		JCheckBox checkBTree = new JCheckBox("Binary Search Tree");
		checkBTree.setBounds(219, 83, 164, 23);
		panelTrees.add(checkBTree);

		JCheckBox checkSplayTree = new JCheckBox("Splay Tree");
		checkSplayTree.setBounds(219, 212, 106, 23);
		panelTrees.add(checkSplayTree);

		JCheckBox checkAVLTree = new JCheckBox("AVL Tree");
		checkAVLTree.setBounds(219, 150, 92, 23);
		panelTrees.add(checkAVLTree);
		
		List list_4 = new List();
		list_4.setBounds(50, 83, 158, 160);
		panelTrees.add(list_4);
		
		JLabel lblContTypeTree = new JLabel("Cont:");
		lblContTypeTree.setBounds(297, 12, 86, 15);
		panelTrees.add(lblContTypeTree);
		
		JLabel lblContTrees = new JLabel("0");
		lblContTrees.setBounds(307, 27, 70, 15);
		panelTrees.add(lblContTrees);
		
		JButton btnGraphTree = new JButton("Graph");
		btnGraphTree.setBounds(159, 308, 117, 15);
		panelTrees.add(btnGraphTree);
		
		JButton btnGraphVs_2 = new JButton("Graph VS");
		btnGraphVs_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GraficaVS3 window = new GraficaVS3();
					window.frame.setVisible(true);
					window.frame.setTitle("Grafica Algoritmo VS Algoritmo");
				} catch (Exception z) {
					z.printStackTrace();
				}
			}
		});
		btnGraphVs_2.setBounds(159, 334, 117, 15);
		panelTrees.add(btnGraphVs_2);
		checkBTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBTree.isSelected()) {
					checkSplayTree.setEnabled(false);
					checkAVLTree.setEnabled(false);
				} else {
					cont=0;
					lblContTrees.setText("");
					list_4.removeAll();
					txtTrees.setText("");
					checkSplayTree.setEnabled(true);
					checkAVLTree.setEnabled(true);
				}
			}
		});
		checkSplayTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkSplayTree.isSelected()) {
					checkBTree.setEnabled(false);
					checkAVLTree.setEnabled(false);
				} else {
					cont=0;
					lblContTrees.setText("");
					list_4.removeAll();
					txtTrees.setText("");
					checkBTree.setEnabled(true);
					checkAVLTree.setEnabled(true);
				}
			}
		});
		checkAVLTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkAVLTree.isSelected()) {
					checkSplayTree.setEnabled(false);
					checkBTree.setEnabled(false);
				} else {
					cont=0;
					lblContTrees.setText("");
					list_4.removeAll();
					txtTrees.setText("");
					checkSplayTree.setEnabled(true);
					checkBTree.setEnabled(true);
				}
			}
		});
		checkBinaryS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBinaryS.isSelected()) {
					checkLinearS.setEnabled(false);

				} else {
					algoritmo="";
					cont=0;
					tiempos.removeAll();
					datos1.removeAll();
					lblContSearch.setText("0");
					checkLinearS.setEnabled(true);
				}
			}
		});
		checkLinearS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkLinearS.isSelected()) {
					checkBinaryS.setEnabled(false);

				} else {
					algoritmo="";
					cont=0;
					tiempos.removeAll();
					datos1.removeAll();
					lblContSearch.setText("0");
					checkBinaryS.setEnabled(true);
				}
			}
		});
		checkBubble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBubble.isSelected()) {
					checkInsertion.setEnabled(false);
					checkMerge.setEnabled(false);
					checkHeap.setEnabled(false);
					checkQuick.setEnabled(false);
					checkSelection.setEnabled(false);
				} else {
					algoritmo="";
					cont=0;
					tiempos.removeAll();
					datos1.removeAll();
					lblContSorting.setText("0");
					checkInsertion.setEnabled(true);
					checkMerge.setEnabled(true);
					checkHeap.setEnabled(true);
					checkQuick.setEnabled(true);
					checkSelection.setEnabled(true);
				}
			}
		});
		checkInsertion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkInsertion.isSelected()) {
					checkBubble.setEnabled(false);
					checkMerge.setEnabled(false);
					checkHeap.setEnabled(false);
					checkQuick.setEnabled(false);
					checkSelection.setEnabled(false);
				} else {
					algoritmo="";
					cont=0;
					tiempos.removeAll();
					datos1.removeAll();
					lblContSorting.setText("0");
					checkBubble.setEnabled(true);
					checkMerge.setEnabled(true);
					checkHeap.setEnabled(true);
					checkQuick.setEnabled(true);
					checkSelection.setEnabled(true);
				}
			}
		});
		checkMerge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkMerge.isSelected()) {
					checkInsertion.setEnabled(false);
					checkBubble.setEnabled(false);
					checkHeap.setEnabled(false);
					checkQuick.setEnabled(false);
					checkSelection.setEnabled(false);
				} else {
					algoritmo="";
					cont=0;
					tiempos.removeAll();
					datos1.removeAll();
					lblContSorting.setText("0");
					checkInsertion.setEnabled(true);
					checkBubble.setEnabled(true);
					checkHeap.setEnabled(true);
					checkQuick.setEnabled(true);
					checkSelection.setEnabled(true);
				}
			}
		});
		checkHeap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkHeap.isSelected()) {
					checkInsertion.setEnabled(false);
					checkMerge.setEnabled(false);
					checkBubble.setEnabled(false);
					checkQuick.setEnabled(false);
					checkSelection.setEnabled(false);
				} else {
					algoritmo="";
					cont=0;
					tiempos.removeAll();
					datos1.removeAll();
					lblContSorting.setText("0");
					checkInsertion.setEnabled(true);
					checkMerge.setEnabled(true);
					checkBubble.setEnabled(true);
					checkQuick.setEnabled(true);
					checkSelection.setEnabled(true);
				}
			}
		});
		checkQuick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkQuick.isSelected()) {
					checkInsertion.setEnabled(false);
					checkMerge.setEnabled(false);
					checkHeap.setEnabled(false);
					checkBubble.setEnabled(false);
					checkSelection.setEnabled(false);
				} else {
					algoritmo="";
					cont=0;
					tiempos.removeAll();
					datos1.removeAll();
					lblContSorting.setText("0");
					checkInsertion.setEnabled(true);
					checkMerge.setEnabled(true);
					checkHeap.setEnabled(true);
					checkBubble.setEnabled(true);
					checkSelection.setEnabled(true);
				}
			}
		});
		checkSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkSelection.isSelected()) {
					checkInsertion.setEnabled(false);
					checkMerge.setEnabled(false);
					checkHeap.setEnabled(false);
					checkQuick.setEnabled(false);
					checkBubble.setEnabled(false);
				} else {
					algoritmo="";
					cont=0;
					tiempos.removeAll();
					datos1.removeAll();
					lblContSorting.setText("0");
					checkInsertion.setEnabled(true);
					checkMerge.setEnabled(true);
					checkHeap.setEnabled(true);
					checkQuick.setEnabled(true);
					checkBubble.setEnabled(true);
				}
			}
		});
		checkRandomList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtinputSorting.setText("");
				if (checkRandomList.isSelected()) {
					checkEntryList.setEnabled(false);
					lblQuantity.setText("Quantity");
					btnAddSort.setText("New List");
				} else {
					checkEntryList.setEnabled(true);
				}
			}
		});
		checkEntryList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtinputSorting.setText("");
				if (checkEntryList.isSelected()) {
					checkRandomList.setEnabled(false);
					lblQuantity.setText("List");
					btnAddSort.setText("Add List");
					SizeIN = 0;

				} else {
					checkRandomList.setEnabled(true);
				}
			}
		});
		checkRandomSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInSearch.setText("");
				if (checkRandomSearch.isSelected()) {
					checkEntrySearch.setEnabled(false);
					lblSearch.setText("Quantity");
					btnAddS.setText("New List");
				} else {
					checkEntrySearch.setEnabled(true);
				}
			}
		});
		checkEntrySearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInSearch.setText("");
				if (checkEntrySearch.isSelected()) {
					checkRandomSearch.setEnabled(false);
					lblSearch.setText("List");
					btnAddS.setText("Add List");
				} else {
					checkRandomSearch.setEnabled(true);
				}
			}
		});
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenuItem mntmMenu = new JMenuItem("Menu");
		mntmMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.setVisible(true);
				Ventana(mntmMenu, ventana);
				ventana = panelPrincipal;

			}
		});
		menuBar.add(mntmMenu);

		JMenuItem mntmSorting = new JMenuItem("Sorting");
		mntmSorting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSorting.setVisible(true);
				Ventana(mntmSorting, ventana);
				ventana = panelSorting;
			}
		});
		menuBar.add(mntmSorting);

		JMenuItem mntmSearch = new JMenuItem("Search");
		mntmSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSearch.setVisible(true);
				Ventana(mntmSearch, ventana);
				ventana = panelSearch;
			}
		});
		menuBar.add(mntmSearch);

		JMenuItem mntmLinked = new JMenuItem("Linked");
		mntmLinked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLinked.setVisible(true);
				Ventana(mntmLinked, ventana);
				ventana = panelLinked;
			}
		});
		menuBar.add(mntmLinked);

		JMenuItem mntmTrees = new JMenuItem("Trees");
		mntmTrees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTrees.setVisible(true);
				Ventana(mntmTrees, ventana);
				ventana = panelTrees;
			}
		});
		menuBar.add(mntmTrees);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSorting.setVisible(true);
				Ventana(mntmSorting, ventana);
				ventana = panelSorting;
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSearch.setVisible(true);
				Ventana(mntmSearch, ventana);
				ventana = panelSearch;
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLinked.setVisible(true);
				Ventana(mntmLinked, ventana);
				ventana = panelLinked;
			}
		});
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTrees.setVisible(true);
				Ventana(mntmTrees, ventana);
				ventana = panelTrees;
			}
		});
		btnAddSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SizeIN = 0;
				list.removeAll();
				if (checkRandomList.isSelected()) {
					SizeIN = Integer.parseInt(txtinputSorting.getText());
					inputArr = new Integer[SizeIN];
					for (int i = 0; i < RandomArray().length; i++) {
						StringBuilder sb = new StringBuilder();
						sb.append("");
						sb.append(RandomArray()[i]);
						String strI = sb.toString();
						list.add(strI);
						inputArr[i] = Integer.parseInt(strI);
					}
				} else if (checkEntryList.isSelected()) {
					String listin = txtinputSorting.getText();
					System.out.println(listin);
					getSize(listin);
					getList(listin);
					for (int i = 0; i < inputArr.length; i++) {
						list.add(inputArr[i].toString());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un metodo de entrada de datos.");
				}
			}
		});
		btnAddS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SizeIN = 0;
				list_2.removeAll();
				if (checkRandomSearch.isSelected()) {
					
					SizeIN = Integer.parseInt(txtInSearch.getText());
					inputArr = new Integer[SizeIN];
					for (int i = 0; i < RandomArray().length; i++) {
						StringBuilder sb = new StringBuilder();
						sb.append("");
						sb.append(RandomArray()[i]);
						String strI = sb.toString();
						list_2.add(strI);
						inputArr[i] = Integer.parseInt(strI);
					}
				} else if (checkEntrySearch.isSelected()) {
					String listin = txtInSearch.getText();
					getSize(listin);
					getList(listin);
					for (int i = 0; i < inputArr.length; i++) {
						list_2.add(inputArr[i].toString());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un metodo de entrada de datos.");
				}

			}
		});
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cont++;
				StringBuilder sb = new StringBuilder();
				sb.append("");
				sb.append(cont);
				String var = sb.toString();
				lblContSorting.setText(var);
				list_1.removeAll();
				if (checkBubble.isSelected()) {
					algoritmo="BubbleSort";
					System.out.println("BubbleSort");
					Integer[] array2=inputArr;
					double tiempo1=System.nanoTime();
					Sort.BubbleSort(array2);
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					StringBuilder sb2 = new StringBuilder();
					StringBuilder sb3 = new StringBuilder();
					sb2.append(prom);
					sb3.append(SizeIN);
					tiempos.add(sb2.toString());
					datos1.add(sb3.toString());
					System.out.println(sb3+","+prom);
					for (int i = 0; i < array2.length; i++) {
						StringBuilder sb1 = new StringBuilder();
						sb1.append("");
						sb1.append(array2[i]);
						String strI = sb1.toString();
						list_1.add(strI);
					}
					
				} else if (checkInsertion.isSelected()) {
					algoritmo="InsertionSort";
					System.out.println("InsertionSort");
					Integer[] array2=inputArr;
					double tiempo1=System.nanoTime();
					Sort.InsertionSort(array2);
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					StringBuilder sb2 = new StringBuilder();
					StringBuilder sb3 = new StringBuilder();
					sb2.append(prom);
					sb3.append(SizeIN);
					tiempos.add(sb2.toString());
					datos1.add(sb3.toString());
					System.out.println(sb3+","+prom);
					for (int i = 0; i < array2.length; i++) {
						StringBuilder sb1 = new StringBuilder();
						sb1.append("");
						sb1.append(array2[i]);
						String strI = sb1.toString();
						list_1.add(strI);
					}
					
				} else if (checkMerge.isSelected()) {
					algoritmo="MergeSort";
					Integer[] array2=inputArr;
					double tiempo1=System.nanoTime();
					Sort.mergeSort(array2);
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					StringBuilder sb2 = new StringBuilder();
					StringBuilder sb3 = new StringBuilder();
					sb3.append(SizeIN);
					sb2.append(prom);
					String promedio=sb2.toString();
					tiempos.add(promedio);
					datos1.add(sb3.toString());
					System.out.println(sb3+","+promedio);
					for (int i = 0; i < array2.length; i++) {
						StringBuilder sb1 = new StringBuilder();
						sb1.append("");
						sb1.append(array2[i]);
						String strI = sb1.toString();
						list_1.add(strI);
					}
					
				} else if (checkSelection.isSelected()) {
					algoritmo="SelectionSort";
					System.out.println("SelectionSort");
					Integer[] array2=inputArr;
					double tiempo1=System.nanoTime();
					Sort.SelectionSort(array2);
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					StringBuilder sb2 = new StringBuilder();
					StringBuilder sb3 = new StringBuilder();
					sb2.append(prom);
					sb3.append(SizeIN);
					tiempos.add(sb2.toString());
					datos1.add(sb3.toString());
					System.out.println(sb3+","+prom);
					for (int i = 0; i < array2.length; i++) {
						StringBuilder sb1 = new StringBuilder();
						sb1.append("");
						sb1.append(array2[i]);
						String strI = sb1.toString();
						list_1.add(strI);
					}

				} else if (checkQuick.isSelected()) {
					algoritmo="QuickSort";
					System.out.println("QuickSort");
					Integer[] array2=inputArr;
					double tiempo1=System.nanoTime();
					Sort.QuickSort(array2);
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					StringBuilder sb2 = new StringBuilder();
					StringBuilder sb3 = new StringBuilder();
					sb2.append(prom);
					sb3.append(SizeIN);
					tiempos.add(sb2.toString());
					datos1.add(sb3.toString());
					System.out.println(sb3+","+prom);
					for (int i = 0; i < array2.length; i++) {
						StringBuilder sb1 = new StringBuilder();
						sb1.append("");
						sb1.append(array2[i]);
						String strI = sb1.toString();
						list_1.add(strI);
					}

				} else if (checkHeap.isSelected()) {
					algoritmo="HeapSort";
					System.out.println("HeapSort");
					Integer[] array2=inputArr;
					double tiempo1=System.nanoTime();
					Sort.HeapSort(array2);
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					StringBuilder sb2 = new StringBuilder();
					StringBuilder sb3 = new StringBuilder();
					sb2.append(prom);
					sb3.append(SizeIN);
					tiempos.add(sb2.toString());
					datos1.add(sb3.toString());
					System.out.println(sb3+","+prom);
					for (int i = 0; i < array2.length; i++) {
						StringBuilder sb1 = new StringBuilder();
						sb1.append("");
						sb1.append(array2[i]);
						String strI = sb1.toString();
						list_1.add(strI);
					}
					
				} else {
					cont=0;
					lblContSorting.setText("0");
					JOptionPane.showMessageDialog(null, "Debe seleccionar un metodo de ordenamiento de datos.");
				}

			}
		});
		btnSearchS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cont++;
				StringBuilder sb = new StringBuilder();
				sb.append("");
				sb.append(cont);
				String var = sb.toString();
				lblContSearch.setText(var);
				if (checkLinearS.isSelected()) {
					linearSearch linea=new linearSearch();
					algoritmo="LinearSearch";
					double tiempo1=System.nanoTime();
					linea.search(inputArr, Integer.parseInt(txtSearch.getText()));
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					StringBuilder sb2 = new StringBuilder();
					StringBuilder sb3 = new StringBuilder();
					sb2.append(prom);
					sb3.append(SizeIN);
					tiempos.add(sb2.toString());
					datos1.add(sb3.toString());
					System.out.println(sb3+","+prom);
					if (linearSearch.result) {
						list_2.select(linearSearch.pointer);
					} else {
						JOptionPane.showMessageDialog(null, "Elemento no encontrado");
					}
				} else if (checkBinaryS.isSelected()) {
					 BinarySearch<Integer> binary=new BinarySearch<Integer>();
	                    for (int i=0;i<inputArr.length;i++){
	                        System.out.println(i);

	                    }
	                    algoritmo="BinarySearch";
	                    Integer[] newArray=binary.Ordenar(inputArr);
	                    double tiempo1=System.nanoTime();
	                    int indice=binary.Busqueda( newArray, Integer.parseInt(txtSearch.getText()));
	                    System.out.println(newArray[indice]);
	                    System.out.println(indice);
	                    double tiempo2=System.nanoTime();
	                    double prom=tiempo2-tiempo1;
	                    StringBuilder sb2 = new StringBuilder();
	                    StringBuilder sb3 = new StringBuilder();
	                    StringBuilder sb4 = new StringBuilder();
	                    sb2.append(prom);
	                    sb3.append(SizeIN);
	                    tiempos.add(sb2.toString());
	                    datos1.add(sb3.toString());
	                    System.out.println(sb3+","+prom);
	                    for(int a=0;a<inputArr.length;a++){
	                    	 sb4.append(inputArr[a]);
	                    	if(newArray[indice]==inputArr[a]){
	                    		indice=a;
	                    	}
	                    }
	                    if (indice!=-1) {
	                        list_2.select(indice);
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Elemento no encontrado");
	                    }

				} else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un metodo de búsqueda de datos.");
				}
			}
		});
		btnInsertTrees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(estadoInsertar==false){
					cont=0;
					lblContTrees.setText("1");
					tiempos.removeAll();
					datos1.removeAll();
					estadoInsertar=true;
					estadoBorrar=false;
					estadoBuscar=false;
				}
				lblContTypeTree.setText("Insert:");
				cont++;
				StringBuilder sb = new StringBuilder();
				sb.append("");
				sb.append(cont);
				String var = sb.toString();
				lblContTrees.setText(var);
				if(txtTrees.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Debe ingresar un dato.");
					cont=0;
					lblContTrees.setText("0");
				}
				else if(checkSplayTree.isSelected()){
					algoritmo="Insert SplayTree";
					listaTree=new ListaEnlazada();
					double tiempo1=System.nanoTime();
					arbolSplay.put(Integer.parseInt(txtTrees.getText()),Integer.parseInt(txtTrees.getText()));
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					arbolSplay.enOrden(arbolSplay.root);
					StringBuilder sb1 = new StringBuilder();
					StringBuilder sb2 = new StringBuilder();
					sb2.append(prom);
					sb1.append("");
					sb1.append(list_4.getItemCount());
					tiempos.add(sb2.toString());
					datos1.add(sb1.toString());
					arbolAVL.cont=0;
					list_4.removeAll();
					for(int i=0;i<listaTree.size();i++){
						StringBuilder sb3 = new StringBuilder();
						sb3.append(listaTree.get(i));
						list_4.add(sb3.toString());
					}
					
				} else if(checkAVLTree.isSelected()){
					algoritmo="Insert AVLTree";
					listaTree=new ListaEnlazada();
					double tiempo1=System.nanoTime();
					arbolAVL.insertar(Integer.parseInt(txtTrees.getText()));
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					arbolAVL.enOrden(arbolAVL.obtenerRaiz());
					StringBuilder sb1 = new StringBuilder();
					StringBuilder sb2 = new StringBuilder();
					sb2.append(prom);
					sb1.append("");
					sb1.append(list_4.getItemCount());
					tiempos.add(sb2.toString());
					datos1.add(sb1.toString());
					arbolAVL.cont=0;
					list_4.removeAll();
					for(int i=0;i<listaTree.size();i++){
						StringBuilder sb3 = new StringBuilder();
						sb3.append(listaTree.get(i));
						list_4.add(sb3.toString());
					}
					
				}else if(checkBTree.isSelected()){
					algoritmo="Insert BinaryTree";
					listaTree=new ListaEnlazada();
					double tiempo1=System.nanoTime();
					arbolBinario.Insert(Integer.parseInt(txtTrees.getText()));
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					arbolBinario.enOrden(arbolBinario.raiz);
					StringBuilder sb1 = new StringBuilder();
					StringBuilder sb2 = new StringBuilder();
					sb2.append(prom);
					sb1.append("");
					sb1.append(list_4.getItemCount());
					tiempos.add(sb2.toString());
					datos1.add(sb1.toString());
					arbolBinario.cont=0;
					list_4.removeAll();
					for(int i=0;i<listaTree.size();i++){
						StringBuilder sb3 = new StringBuilder();
						sb3.append(listaTree.get(i));
						list_4.add(sb3.toString());
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Debe seleccionar un árbol binario de búsqueda.");
				}
			}
		});
		btndeleteTrees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(estadoBorrar==false){
					cont=0;
					lblContTrees.setText("1");
					tiempos.removeAll();
					datos1.removeAll();
					estadoBorrar=true;
					estadoInsertar=false;
					estadoBuscar=false;
				}
				lblContTypeTree.setText("Delete:");
				cont++;
				StringBuilder sb = new StringBuilder();
				sb.append("");
				sb.append(cont);
				String var = sb.toString();
				lblContTrees.setText(var);
				if(txtTrees.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Debe ingresar un dato.");
					cont=0;
					lblContTrees.setText("0");
				}
				else if(checkSplayTree.isSelected()){
					algoritmo="Delete SplayTree";
					listaTree=new ListaEnlazada();
					double tiempo1=System.nanoTime();
					arbolSplay.remove(Integer.parseInt(txtTrees.getText()));
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					arbolSplay.enOrden(arbolSplay.root);
					StringBuilder sb1 = new StringBuilder();
					StringBuilder sb2 = new StringBuilder();
					sb2.append(prom);
					sb1.append("");
					sb1.append(list_4.getItemCount());
					tiempos.add(sb2.toString());
					datos1.add(sb1.toString());
					arbolAVL.cont=0;
					list_4.removeAll();
					for(int i=0;i<listaTree.size();i++){
						StringBuilder sb3 = new StringBuilder();
						sb3.append(listaTree.get(i));
						list_4.add(sb3.toString());
					}
				} else if(checkAVLTree.isSelected()){
					algoritmo="Delete AVLTree";
					listaTree=new ListaEnlazada();
					double tiempo1=System.nanoTime();
					arbolAVL.eliminarAVL(Integer.parseInt(txtTrees.getText()),arbolAVL.obtenerRaiz());
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					arbolAVL.enOrden(arbolAVL.obtenerRaiz());
					StringBuilder sb1 = new StringBuilder();
					StringBuilder sb2 = new StringBuilder();
					sb2.append(prom);
					sb1.append("");
					sb1.append(list_4.getItemCount());
					tiempos.add(sb2.toString());
					datos1.add(sb1.toString());
					arbolAVL.cont=0;
					list_4.removeAll();
					for(int i=0;i<listaTree.size();i++){
						StringBuilder sb3 = new StringBuilder();
						sb3.append(listaTree.get(i));
						list_4.add(sb3.toString());
					}
					
				}else if(checkBTree.isSelected()){
					algoritmo="Delete BinaryTree";
					listaTree=new ListaEnlazada();
					double tiempo1=System.nanoTime();
					arbolBinario.Delete(Integer.parseInt(txtTrees.getText()));
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					arbolBinario.enOrden(arbolBinario.raiz);
					StringBuilder sb1 = new StringBuilder();
					StringBuilder sb2 = new StringBuilder();
					sb2.append(prom);
					sb1.append("");
					sb1.append(list_4.getItemCount());
					tiempos.add(sb2.toString());
					datos1.add(sb1.toString());
					arbolBinario.cont=0;
					list_4.removeAll();
					for(int i=0;i<listaTree.size();i++){
						StringBuilder sb3 = new StringBuilder();
						sb3.append(listaTree.get(i));
						list_4.add(sb3.toString());
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Debe seleccionar un árbol binario de búsqueda.");
				}
			}
		});
		btnSearchTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(estadoBuscar==false){
					cont=0;
					lblContTrees.setText("1");
					tiempos.removeAll();
					datos1.removeAll();
					estadoBuscar=true;
					estadoBorrar=false;
					estadoInsertar=false;
				}
				lblContTypeTree.setText("Search:");
				cont++;
				StringBuilder sb = new StringBuilder();
				sb.append("");
				sb.append(cont);
				String var = sb.toString();
				lblContTrees.setText(var);
				if(txtTrees.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Debe ingresar un dato.");
					cont=0;
					lblContTrees.setText("0");
				}
				else if(checkSplayTree.isSelected()){
					algoritmo="Search SplayTree";
					listaTree=new ListaEnlazada();
					double tiempo1=System.nanoTime();
					arbolSplay.get(Integer.parseInt(txtTrees.getText()));
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					int valorc=(int) arbolSplay.get(Integer.parseInt(txtTrees.getText()));
					StringBuilder sb1 = new StringBuilder();
					StringBuilder sb2 = new StringBuilder();
					StringBuilder sb3 = new StringBuilder();
					sb2.append(prom);
					sb3.append(valorc);
					sb1.append("");
					sb1.append(list_4.getItemCount());
					tiempos.add(sb2.toString());
					datos1.add(sb1.toString());
					arbolAVL.cont=0;
					for(int i=0;i<list_4.getItemCount();i++){
						if(sb3.toString().equals(list_4.getItem(i))){
							list_4.select(i);
						}
					}
				} else if(checkAVLTree.isSelected()){
					
					algoritmo="Search AVLTree";
					listaTree=new ListaEnlazada();
					double tiempo1=System.nanoTime();
					arbolAVL.buscar(Integer.parseInt(txtTrees.getText()),arbolAVL.obtenerRaiz());
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					int valorc=arbolAVL.buscar(Integer.parseInt(txtTrees.getText()),arbolAVL.obtenerRaiz()).dato;
					StringBuilder sb1 = new StringBuilder();
					StringBuilder sb2 = new StringBuilder();
					StringBuilder sb3 = new StringBuilder();
					sb2.append(prom);
					sb3.append(valorc);
					sb1.append("");
					sb1.append(list_4.getItemCount());
					tiempos.add(sb2.toString());
					datos1.add(sb1.toString());
					arbolAVL.cont=0;
					for(int i=0;i<list_4.getItemCount();i++){
						if(sb3.toString().equals(list_4.getItem(i))){
							list_4.select(i);
						}
					}
					
				}else if(checkBTree.isSelected()){
					algoritmo="Search BinaryTree";
					listaTree=new ListaEnlazada();
					double tiempo1=System.nanoTime();
					arbolBinario.Search(Integer.parseInt(txtTrees.getText()));
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					int valorc=(int)arbolBinario.Search(Integer.parseInt(txtTrees.getText()));
					StringBuilder sb1 = new StringBuilder();
					StringBuilder sb2 = new StringBuilder();
					StringBuilder sb3 = new StringBuilder();
					sb2.append(prom);
					sb3.append(valorc);
					sb1.append("");
					sb1.append(list_4.getItemCount());
					tiempos.add(sb2.toString());
					datos1.add(sb1.toString());
					arbolAVL.cont=0;
					for(int i=0;i<list_4.getItemCount();i++){
						if(sb3.toString().equals(list_4.getItem(i))){
							list_4.select(i);
						}
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Debe seleccionar un árbol binario de búsqueda.");
				}
			}
		});
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaDoble=new DoubleLinkedList();
				SizeIN = 0;
				list_3.removeAll();
				if (checkBox.isSelected()) {
					SizeIN = Integer.parseInt(textField.getText());
					inputArr = new Integer[SizeIN];
					for (int i = 0; i < RandomArray().length; i++) {
						StringBuilder sb = new StringBuilder();
						sb.append("");
						sb.append(RandomArray()[i]);
						String strI = sb.toString();
						listaDoble.addLast(Integer.parseInt(sb.toString()));
						list_3.add(strI);
					}
				} else if (checkBox_1.isSelected()) {
					String listin = txtinputSorting.getText();
					System.out.println(listin);
					getSize(listin);
					getList(listin);
					for (int i = 0; i < inputArr.length; i++) {
						list_3.add(inputArr[i].toString());
						listaDoble.addLast(inputArr[i]);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un metodo de entrada de datos.");
				}
			
			}
		});
		btnInsertLinked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(estadoInsertar==false){
					cont=0;
					lblContLinked.setText("1");
					tiempos.removeAll();
					datos1.removeAll();
					estadoInsertar=true;
					estadoBorrar=false;
					estadoBuscar=false;
				}
				lblContTypeLinked.setText("Insert:");
				cont++;
				StringBuilder sb = new StringBuilder();
				sb.append("");
				sb.append(cont);
				String var = sb.toString();
				lblContLinked.setText(var);
				if(txtLinked.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Debe ingresar un dato.");
					cont=0;
					lblContLinked.setText("0");
				}
				else {
					algoritmo="Insert DoubleLinkedList";
					listaTree=new ListaEnlazada();
					double tiempo1=System.nanoTime();
					listaDoble.addLast(Integer.parseInt(txtLinked.getText()));
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					listaDoble.search(-1,listaDoble.head,0);
					StringBuilder sb1 = new StringBuilder();
					StringBuilder sb2 = new StringBuilder();
					sb2.append(prom);
					sb1.append("");
					sb1.append(list_3.getItemCount());
					tiempos.add(sb2.toString());
					datos1.add(sb1.toString());
					list_3.removeAll();
					for(int i=0;i<listaTree.size();i++){
						StringBuilder sb3 = new StringBuilder();
						sb3.append(listaTree.get(i));
						list_3.add(sb3.toString());
					}
			}}
		});
		btnDeleteLinked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(estadoBorrar==false){
					cont=0;
					lblContLinked.setText("1");
					tiempos.removeAll();
					datos1.removeAll();
					estadoBorrar=true;
					estadoInsertar=false;
					estadoBuscar=false;
				}
				lblContTypeLinked.setText("Delete:");
				cont++;
				StringBuilder sb = new StringBuilder();
				sb.append("");
				sb.append(cont);
				String var = sb.toString();
				lblContLinked.setText(var);
				if(txtLinked.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Debe ingresar un dato.");
					cont=0;
					lblContLinked.setText("0");
				}
				else {
					algoritmo="Delete DoubleLinkedList";
					listaTree=new ListaEnlazada();
					double tiempo1=System.nanoTime();
					listaDoble.remove(Integer.parseInt(txtLinked.getText()), listaDoble.head,0);
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					listaDoble.search(-1,listaDoble.head,0);
					StringBuilder sb1 = new StringBuilder();
					StringBuilder sb2 = new StringBuilder();
					sb2.append(prom);
					sb1.append("");
					sb1.append(list_3.getItemCount());
					tiempos.add(sb2.toString());
					datos1.add(sb1.toString());
					list_3.removeAll();
					for(int i=0;i<listaTree.size();i++){
						StringBuilder sb3 = new StringBuilder();
						sb3.append(listaTree.get(i));
						list_3.add(sb3.toString());
					}
				} 
			}
		});
		btnSearchLinked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(estadoBuscar==false){
					cont=0;
					lblContLinked.setText("1");
					tiempos.removeAll();
					datos1.removeAll();
					estadoBuscar=true;
					estadoBorrar=false;
					estadoInsertar=false;
				}
				lblContTypeLinked.setText("Search:");
				cont++;
				StringBuilder sb = new StringBuilder();
				sb.append("");
				sb.append(cont);
				String var = sb.toString();
				lblContLinked.setText(var);
				if(txtLinked.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Debe ingresar un dato.");
					cont=0;
					lblContLinked.setText("0");
				}
				else {
					algoritmo="Search DoubleLinkedList";
					listaTree=new ListaEnlazada();
					double tiempo1=System.nanoTime();
					listaDoble.search(Integer.parseInt(txtLinked.getText()),listaDoble.head,0);
					double tiempo2=System.nanoTime();
					double prom=tiempo2-tiempo1;
					int valorc=listaDoble.search(Integer.parseInt(txtLinked.getText()),listaDoble.head,0);
					StringBuilder sb1 = new StringBuilder();
					StringBuilder sb2 = new StringBuilder();
					StringBuilder sb3 = new StringBuilder();
					sb2.append(prom);
					sb3.append(valorc);
					sb1.append("");
					sb1.append(list_3.getItemCount());
					tiempos.add(sb2.toString());
					datos1.add(sb1.toString());
					if(valorc==-1){
						JOptionPane.showMessageDialog(null, "Elemento no encontrado.");
					}else{
						list_3.select(valorc);
					}
				} 
			}
		});
		btnGraphTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(algoritmo.equals("")){
					JOptionPane.showMessageDialog(null, "No se a seleccionado ningun árbol para graficar.");
				}else{
					Graficar();
				
			}
			}
		});
		btnGraphSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(algoritmo.equals("")){
					JOptionPane.showMessageDialog(null, "No se a seleccionado ningun algoritmo para graficar.");
				}else{
					Graficar();
				
			}}
		});
		btnGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(algoritmo.equals("")){
					JOptionPane.showMessageDialog(null, "No se a seleccionado ningun algoritmo para graficar.");
				}else{
				Graficar();
				
			}
			}
		});
		panelSorting.setVisible(false);
		panelSearch.setVisible(false);
		panelLinked.setVisible(false);
		panelTrees.setVisible(false);
		ventana = panelPrincipal;
	}

	public JMenuBar getMenuBar() {
		return getMenuBar();
	}

	public void Ventana(JMenuItem item, JPanel panel) {
		panel.setVisible(false);
		item.setEnabled(false);
		if (off != null) {
			off.setEnabled(true);
		}
		off = item;
	}

	public static int[] RandomArray() {
		int arreglo[] = new int[SizeIN];
		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = (int) (Math.random() * 1000);
		}
		return arreglo;
	}

	public void getList(String lista) {
		String tempValue = "";
		lista = lista + ",";
		int cont = 0;
		for (int i = 0; i < lista.length(); i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("");
			sb.append(lista.charAt(i));
			String var = sb.toString();
			if (var.equals(",")) {
				inputArr[cont] = Integer.parseInt(tempValue);
				cont++;
				tempValue = "";
			} else {
				if (tempValue.equals("")) {
					tempValue = var;
				} else {
					tempValue = tempValue + var;
				}
			}
//
		}
	}

	private void getSize(String lista) {
		lista = lista + ",";
		for (int i = 0; i < lista.length(); i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("");
			sb.append(lista.charAt(i));
			String var = sb.toString();
			if (var.equals(",")) {
				SizeIN++;
			}
		}
		inputArr = new Integer[SizeIN];
	}
	private void Graficar(){
		try {
			Grafica window = new Grafica();
			window.frame.setVisible(true);
			window.frame.setTitle("Grafica de "+algoritmo);
		} catch (Exception z) {
			z.printStackTrace();
		}
	}
}