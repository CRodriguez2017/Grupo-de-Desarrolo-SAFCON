/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safcon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class GestionDeLogros extends javax.swing.JInternalFrame {

    /**
     * Creates new form GestionDeLogros
     */
    ConexionBD cone, cone2, cone3, cone4, cone5, cone9, cone10, cone12;
    DefaultTableModel modelo;
    int idMaterias;
    int idPeriodo;
    int PorcentajeValido, numero2;
    public GestionDeLogros() {
        cone = new ConexionBD();
        cone2 = new ConexionBD();
        cone3 = new ConexionBD();
        cone4 = new ConexionBD();
        cone5 = new ConexionBD();
        cone9 = new ConexionBD();
        cone10 = new ConexionBD();
        cone12 = new ConexionBD();
        initComponents();
        cargarId();
        cargarMaterias();
        cargarPeriodo();
        consultar("");
        cargarPorcentaje();
        jButton2.setVisible(false);
        SNumeros(jTextField1);    
    }
     
    public void cargarId(){ 
        try{
            ResultSet rs = cone.consultaBD("SELECT max(Id) FROM Logros"); 
            if (rs.next()) {
                int codigo = rs.getInt("max(Id)")+1;
                jLabel12.setText(codigo+"");
            } 
        } 
        catch(SQLException ex){
            Logger.getLogger(GestionDeLogros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cargarPorcentaje(){ 
        try{
            ResultSet rs = cone5.consultaBD("SELECT SUM(Porcentaje) From Logros "
                    + " where id_Materia="+idMaterias+" AND id_Periodo="+idPeriodo+""); 
            if (rs.next()) {
                 int porcentaje = rs.getInt("SUM(Porcentaje)");
                jLabel4.setText(porcentaje+"");
            } 
        } 
        catch(SQLException ex){
            Logger.getLogger(GestionDeLogros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
    public void cargarPeriodo(){ 
        try{
            ResultSet rs = cone2.consultaBD("SELECT Nombre FROM Periodo");
            while(rs.next()){
                jComboBox3.addItem(rs.getString("Nombre"));
            }
            
        } 
        catch(SQLException ex){
            Logger.getLogger(GestionDeLogros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargarMaterias(){ 
        try{
            ResultSet rs = cone3.consultaBD("SELECT Nombre FROM Materias");
            while(rs.next()){
                jComboBox2.addItem(rs.getString("Nombre"));
            }
            
        } 
        catch(SQLException ex){
            Logger.getLogger(GestionDeLogros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
    public void consultar(String valor){
        String columnNames[]={"ID Logro", "Nombre Logro", "Porcentaje", "Tipo"}; 
        modelo = new DefaultTableModel(null, columnNames); 
        try{
            ResultSet rs = cone4.consultaBD("SELECT id, Nombre, Porcentaje, tipo_logro FROM Logros"
                    + " where id_Materia="+idMaterias+" AND id_Periodo="+idPeriodo+" AND Nombre like '%"+valor+"%' order by id ASC");
            String fila[]= new String[4];
            while (rs.next()){
                fila[0]=rs.getString("id");
                fila[1]=rs.getString("Nombre");
                fila[2]=rs.getString("Porcentaje");
                fila[3]=rs.getString("tipo_logro");
                
                modelo.addRow(fila);
            }
            jTable2.setModel(modelo);
            cargarPorcentaje();
            cargarId();
        }
        catch(SQLException ex){
            Logger.getLogger(GestionDeLogros.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void SNumeros(JTextField a){
        a.addKeyListener(new KeyAdapter() {
            public void KeyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (Character.isLetter(c)) {
                    getToolkit().beep();
                    e.consume();
                    System.out.println("Entra "+c);
                }
            }
        });    
        
    }
    public void SLetras(JTextField a){
        a.addKeyListener(new KeyAdapter() {
            public void KeyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });    
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPopupMenu1.setComponentPopupMenu(jPopupMenu1);

        jMenuItem1.setText("Eliminar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Modificar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion de Logros");

        jLabel1.setText("Id");

        jLabel8.setText("Materia");

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel9.setText("Periodo");

        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });

        jLabel6.setText("Nombre del logro");

        jLabel10.setText("Porcentaje (Valor del Logro)");

        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel11.setText("Descripcion del Logro");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Crear Logro");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel13.setText("Tipo de Logro");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Institucional", "Academico" }));

        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.setComponentPopupMenu(jPopupMenu1);
        jScrollPane3.setViewportView(jTable2);

        jLabel2.setText("Total:");

        jLabel5.setText("Buscar");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/safcon/img/Logoo.jpeg"))); // NOI18N

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(126, 126, 126)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(241, 241, 241)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13)
                            .addComponent(jLabel8))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel5)
                                .addGap(54, 54, 54)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(97, 97, 97))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(23, 23, 23))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addGap(2, 2, 2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jLabel11)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    cargarPorcentaje();
    
    int id= Integer.parseInt(jLabel12.getText()); 
    int Porcentaje= Integer.parseInt(jTextField1.getText()); 
    String Nombre= jTextField2.getText(); 
    String Descripcion= jTextArea1.getText(); 
    String Tipo = (String) jComboBox1.getSelectedItem();
    
    
        if ((PorcentajeValido <= 100) && (Porcentaje > 0)) {
            ConexionBD cone9 = new ConexionBD();
            cone9.modificaBD("Insert into Logros values("+id+",'"+Nombre+"','"+Tipo+"',"+idMaterias+","+idPeriodo+","+Porcentaje+",'"+Descripcion+"')");
            consultar("");
            cargarId();
             JOptionPane.showMessageDialog(rootPane,"Logro creado satisfatoriamente");
             jTextField1.setText("");
             jTextField2.setText("");
             jTextArea1.setText("");
        }else{
            JOptionPane.showMessageDialog(rootPane,"Valor invalido, intente nuevamente.");
        }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        consultar(jTextField3.getText());
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        try{
            ConexionBD cone7 = new ConexionBD();
            ResultSet rs = cone7.consultaBD("SELECT id FROM Materias WHERE Nombre='"+jComboBox2.getSelectedItem()+"'");
            while(rs.next()){
                 idMaterias = rs.getInt("id");
                 consultar("");
            }
            
        } 
        catch(SQLException ex){
            Logger.getLogger(GestionDeLogros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        try{
            ConexionBD cone8 = new ConexionBD();
            ResultSet rs = cone8.consultaBD("SELECT id FROM Periodo WHERE Nombre='"+jComboBox3.getSelectedItem()+"'");
            while(rs.next()){
                 idPeriodo = rs.getInt("id");
                      consultar("");
            }
        } 
        catch(SQLException ex){
            Logger.getLogger(GestionDeLogros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String id = (String) modelo.getValueAt(jTable2.getSelectedRow(),0);
        int idEntero = Integer.parseInt(id);
        if (jTable2.getSelectedRow()== -1) {
                JOptionPane.showConfirmDialog(rootPane,"Debe seleccionar una registro de la tabla");
            }else{
                int confirm=JOptionPane.showConfirmDialog(rootPane,"Desea eliminar el regristro");
                    if (confirm==0) {
                        String ClaveReservada = "123";
                            JPanel panel = new JPanel();
                            JLabel label = new JLabel("Ingrese su contraseña:");
                            JPasswordField pass = new JPasswordField(10);
                            panel.add(label);
                            panel.add(pass);
        
                        String[] Opciones = new String[]{"OK", "Cancel"};
                    int option = JOptionPane.showOptionDialog(null, panel, "Verificacion de Usuario",
                                     JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                     null, Opciones, Opciones[1]);
                        if(option == 0){
                            char[] password = pass.getPassword();
                            String password2 = pass.getText();
                                if (ClaveReservada.equals(password2)) {
                                    String cod=(String)modelo.getValueAt(jTable2.getSelectedRow(),0);
                                            cone10.modificaBD("DELETE FROM Logros WHERE id= "+ idEntero+"");
                                            consultar("");
                                    JOptionPane.showMessageDialog(rootPane,"Logro Eliminado");        
                                }else{
                                    JOptionPane.showMessageDialog(rootPane,"No se puede eliminar, datos incoherentes");
                                }
                         }
                        
                    }
            }
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        
        int numero1 = Integer.parseInt(jLabel4.getText());
        numero2 = Integer.parseInt(jTextField1.getText());
        int resultado = numero1 + numero2;
        PorcentajeValido = resultado ;
    }//GEN-LAST:event_jButton1MousePressed

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2FocusLost

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        jButton2.setVisible(true);
        jButton1.setVisible(false);
        try {
            
            String id=(String)modelo.getValueAt(jTable2.getSelectedRow(),0);
            ConexionBD cone11=new ConexionBD();
            ResultSet rs5 = cone11.consultaBD("SELECT * FROM Logros WHERE id= " + id);
                
            while(rs5.next()){
                    jLabel12.setText(rs5.getString("id"));
                    jTextField2.setText(rs5.getString("Nombre"));
                    jComboBox1.setSelectedItem(rs5.getString("tipo_logro"));
                    jComboBox2.setSelectedItem(rs5.getString("id_Materia"));
                    jComboBox3.setSelectedItem(rs5.getString("id_Periodo"));
                    jTextField1.setText(rs5.getString("Porcentaje"));
//                    jTextArea1.setText(rs5.getString("Descripcion"));
                    
                }
                
        }  catch (SQLException ex) {
           Logger.getLogger(GestionDeLogros.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int id= Integer.parseInt(jLabel12.getText()); 
        int Porcentaje= Integer.parseInt(jTextField1.getText()); 
        String Nombre= jTextField2.getText(); 
        String Descripcion= jTextArea1.getText(); 
        String Tipo = (String) jComboBox1.getSelectedItem();
         
        if ((PorcentajeValido <= 100) && (Porcentaje > 0)) {
            ConexionBD cone9 = new ConexionBD();
            cone12.modificaBD("update Logros set Nombre = '"+Nombre+"', Porcentaje = "+Porcentaje+", "
                + " Descripcion =  '"+Descripcion+"', id_Periodo = "+idPeriodo+", id_Materia = "+idMaterias+", tipo_logro = '"+Tipo+"' where "
                + "id = "+id+""); 
            consultar("");
            cargarId();
             JOptionPane.showMessageDialog(rootPane,"Logro actualizado satisfatoriamente");
             jTextField1.setText("");
             jTextField2.setText("");
             jTextArea1.setText("");
        }else{
            JOptionPane.showMessageDialog(rootPane,"Valor invalido, intente nuevamente.");
        }
        // TODO add your handling code here:
        jButton2.setVisible(false);
        jButton1.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
         if (jTextField2.getText().length() >= 11) {
            evt.consume();
        }
        char c = evt.getKeyChar();
                if (Character.isDigit(c)) {
                    getToolkit().beep();
                    evt.consume();
                }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        numero2 = Integer.parseInt(jTextField1.getText());
        if (numero2 == 0) {
            JOptionPane.showMessageDialog(null, "Valor no valido. \n "
                    + "Por favor intente de nuevo");
            jTextField1.setText("");
        }
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        char c = evt.getKeyChar();
                if (Character.isLetter(c)) {
                    getToolkit().beep();
                    evt.consume();
                    System.out.println("Entra "+c);
                }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
            char c = evt.getKeyChar();
                if (Character.isDigit(c)) {
                    getToolkit().beep();
                    evt.consume();
                }
    }//GEN-LAST:event_jTextArea1KeyTyped

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        
    }//GEN-LAST:event_jTextField2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
