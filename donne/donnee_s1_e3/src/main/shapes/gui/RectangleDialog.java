/* RectangleDialog.java
 *
 * Created on 13. septembre 2001, 11:05
 */

package shapes.gui;

import shapes.WorkShapes;
import shapes.Rectangle;

/**
 *
 * @author  fuhrer
 */
public class RectangleDialog extends javax.swing.JDialog {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 3257572784618944824L;
	private WorkShapes w;
    private Rectangle callingShape;
    
    /** Creates new form CircleDialog */
    public RectangleDialog(java.awt.Frame parent) {
        super(parent, true);
        w = (WorkShapes)parent;
        initComponents();
    }
    
    public RectangleDialog(Rectangle e) {
        super();
        setModal(true);
        callingShape = e;
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        topPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        downPanel = new javax.swing.JPanel();
        OKbutton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        xposlabel = new javax.swing.JLabel();
        xpos = new javax.swing.JTextField();
        yposlabel = new javax.swing.JLabel();
        ypos = new javax.swing.JTextField();
        sizelabela = new javax.swing.JLabel();
        sizelabelb = new javax.swing.JLabel();
        sizea = new javax.swing.JTextField();
        sizeb = new javax.swing.JTextField();
        
        setTitle("Create/Edit a Rectangle");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        
        jLabel4.setText("Enter Rectangle Data");
        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18));
        topPanel.add(jLabel4);
        
        getContentPane().add(topPanel, java.awt.BorderLayout.NORTH);
        
        OKbutton.setText("OK");
        OKbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKbuttonActionPerformed(evt);
            }
        });
        
        downPanel.add(OKbutton);
        
        getContentPane().add(downPanel, java.awt.BorderLayout.SOUTH);
        
        mainPanel.setLayout(new java.awt.GridLayout(4, 2));
        
        xposlabel.setText("X Pos :");
        xposlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainPanel.add(xposlabel);
        
        mainPanel.add(xpos);
        
        yposlabel.setText("Y Pos :");
        yposlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainPanel.add(yposlabel);
        
        mainPanel.add(ypos);
        
        sizelabela.setText("Size a :");
        sizelabela.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainPanel.add(sizelabela);
        
        mainPanel.add(sizea);
        
        sizelabelb.setText("Size b :");
        sizelabelb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainPanel.add(sizelabelb);
        
        mainPanel.add(sizeb);
        
        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);
        
        pack();
    }//GEN-END:initComponents
    
    private void OKbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKbuttonActionPerformed
        // Add your handling code here:
        if (callingShape != null) {
            callingShape.change(
            Integer.valueOf(xpos.getText()).intValue(),
            Integer.valueOf(ypos.getText()).intValue(),
            Integer.valueOf(sizea.getText()).intValue(),
            Integer.valueOf(sizeb.getText()).intValue());
            setVisible(false);
            dispose();
        } else {
            w.createNewRectangle(
            Integer.valueOf(xpos.getText()).intValue(),
            Integer.valueOf(ypos.getText()).intValue(),
            Integer.valueOf(sizea.getText()).intValue(),
            Integer.valueOf(sizeb.getText()).intValue());
            setVisible(false);
            dispose();}
    }//GEN-LAST:event_OKbuttonActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel downPanel;
    private javax.swing.JButton OKbutton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel xposlabel;
    private javax.swing.JTextField xpos;
    private javax.swing.JLabel yposlabel;
    private javax.swing.JTextField ypos;
    private javax.swing.JLabel sizelabela;
    private javax.swing.JLabel sizelabelb;
    private javax.swing.JTextField sizea;
    private javax.swing.JTextField sizeb;
    // End of variables declaration//GEN-END:variables
    
}
