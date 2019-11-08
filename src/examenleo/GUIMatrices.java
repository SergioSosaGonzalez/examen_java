/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenleo;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author sergiososa
 */
public class GUIMatrices extends JFrame implements ActionListener{

    private JLabel lTitle,lMatrizA,lMatrizB,lColumMatrizA,lFilasMatrizA,lColumMatrizB,lFilasMatrizB,lResultado;
    private JTextPane jTxtMatrizA,jTxtMatrizB,jTxtResultado;
    private JScrollPane jScrollMatrizA,jScrollMatrizB,jScrollResultado;
    private JPanel pTitle,pMatrices,pFooter;
    private JTextField txtColumMatrizA,txtColumMatrizB,txtFilaMatrizA,txtFilaMatrizB;
    private JButton bEjecutar;
    private Font f = new Font("Arial", Font.BOLD, 25);
    CMatrices matrices = new CMatrices();
    /**
     * Creates new form GUIMatrices
     */

    private JLabel jLabel1;
    public GUIMatrices() {
        super("Martices by DeeperLag3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        setSize(900,500);
        initComponents();
    }

    private void initComponents() {
        
        /*==================== En esta parte son solo datos esteticos.================================== */
        //Aqui va el titulo
        lTitle = new JLabel("Examen - matrices");
        lTitle.setFont(f);
        pTitle = new JPanel();
        pTitle.setLayout(new FlowLayout());
        pTitle.add(lTitle);
        
        //Contenido Principal
        pMatrices = new JPanel();
        pMatrices.setLayout(new MigLayout("", "[50px,grow,fill][50px,grow,fill][50px,grow,fill][50px,grow,fill][50px,grow,fill][50px,grow,fill][50px,grow,fill][50px,grow,fill][50px,grow,fill][50px,grow,fill][50px,grow,fill]", "[33.00px,grow,fill][33.00px,grow,fill][33.00px,grow,fill][33.00px,grow,fill][33.00px,grow,fill][33.00px,grow,fill][33.00px,grow,fill][33.00px,grow,fill][33.00px,grow,fill][33.00px,grow,fill]"));
        
        lMatrizA = new JLabel("Matriz A");
        lColumMatrizA = new JLabel("Columna: ");
        lFilasMatrizA = new JLabel("Filas: ");
        txtColumMatrizA = new JTextField();
        txtFilaMatrizA = new JTextField();
        jTxtMatrizA = new JTextPane();
        jTxtMatrizA.setEditable(false);
        centerJTextPane(jTxtMatrizA);
        jScrollMatrizA = new JScrollPane(jTxtMatrizA);
        lMatrizB = new JLabel("Matriz B");
        lColumMatrizA = new JLabel("Columna: ");
        lFilasMatrizA = new JLabel("Filas: ");
        lMatrizB = new JLabel("Matriz B");
        lFilasMatrizB = new JLabel("Filas: ");
        txtFilaMatrizB = new JTextField();
        lColumMatrizB = new JLabel("Columnas: ");
        txtColumMatrizB = new JTextField();
        jTxtMatrizB = new JTextPane();
        jTxtMatrizB.setEditable(false);
        jScrollMatrizB = new JScrollPane(jTxtMatrizB);
        centerJTextPane(jTxtMatrizB);
        
        lResultado = new JLabel("Resultado: ");
        jTxtResultado = new JTextPane();
        jTxtResultado.setEditable(false);
        centerJTextPane(jTxtResultado);
        jScrollResultado = new JScrollPane(jTxtResultado);
        
        pMatrices.add(lMatrizA,"cell 1 0 1 1");
        pMatrices.add(lFilasMatrizA,"cell 1 1");
        pMatrices.add(txtFilaMatrizA,"cell 2 1");
        pMatrices.add(lColumMatrizA,"cell 1 2");
        pMatrices.add(txtColumMatrizA,"cell 2 2");
        pMatrices.add(jScrollMatrizA,"cell 1 3 2 8");
        pMatrices.add(lResultado,"cell 4 0");
        pMatrices.add(jScrollResultado,"cell 4 1 3 9");
        
        pMatrices.add(lMatrizB,"cell 8 0");
        pMatrices.add(lFilasMatrizB,"cell 8 1");
        pMatrices.add(txtFilaMatrizB,"cell 9 1");
        pMatrices.add(lColumMatrizB,"cell 8 2");
        pMatrices.add(txtColumMatrizB,"cell 9 2");
        pMatrices.add(jScrollMatrizB,"cell 8 3 2 8");
        
        //Footer de botones
        pFooter = new JPanel();
        pFooter.setLayout(new FlowLayout());
        bEjecutar = new JButton("Ejecutar");
        bEjecutar.addActionListener(this);
        pFooter.add(bEjecutar);
        //Se agregan al panel principal
        this.add(pTitle,BorderLayout.NORTH);
        this.add(pMatrices,BorderLayout.CENTER);
        this.add(pFooter,BorderLayout.SOUTH);
        /*=========================== Termina parte de declaraciones esteticas ========================== */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(bEjecutar)){
            int[][] matrizA = matrices.generateArrays(Integer.parseInt(txtFilaMatrizA.getText()),Integer.parseInt(txtColumMatrizA.getText()));
            int[][] matrizB = matrices.generateArrays(Integer.parseInt(txtFilaMatrizB.getText()),Integer.parseInt(txtColumMatrizB.getText()));
            String formatMatrizA = matrices.formatString(matrizA);
            String formatMatrizB = matrices.formatString(matrizB);
            jTxtMatrizA.setText(formatMatrizA);
            jTxtMatrizB.setText(formatMatrizB);
            cleanForm();
        }
    }
    
    private void cleanForm(){
        txtColumMatrizA.setText("");
        txtFilaMatrizA.setText("");
        txtColumMatrizB.setText("");
        txtFilaMatrizB.setText("");
    }
    
    private void centerJTextPane(JTextPane pTextPane){
        StyledDocument doc = pTextPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }
}
