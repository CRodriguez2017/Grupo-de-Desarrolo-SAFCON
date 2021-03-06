package safcon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestionDeActividades extends javax.swing.JInternalFrame {
ConexionBD cone;
    public GestionDeActividades() {
        initComponents();
        cone=new ConexionBD();
        cargarDocente();
        cargarCursos();
    
    }
    public void cargarId(){
            try {
             ResultSet rs=cone.consultaBD("SELECT max(id) FROM actividad");
             if(rs.next()){
                 int cod=rs.getInt("max(id)")+1;
                 lbidAct.setText(cod+"");
             }
         } catch (SQLException ex) {
             Logger.getLogger(GestionDeActividades.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void cargarDocente(){
     //traer docente del login
    }
    public void cargarCursos(){
        String docenteLog=lbdocente.getText();
         try {
            ResultSet rs=cone.consultaBD("SELECT * FROM cursos where docente="+docenteLog);
            cbxcursos.removeAllItems();
            while(rs.next()){
                cbxcursos.addItem(rs.getString("Nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cargarMateria(){
         try {
            ResultSet rs=cone.consultaBD("SELECT * FROM materia where ="+cbxcursos.getSelectedItem());
            cbxcursos.removeAllItems();
            while(rs.next()){
                cbxcursos.addItem(rs.getString("Nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void cargarPeriodo(){
        try {
            ResultSet rs=cone.consultaBD("SELECT * FROM periodo where ="+cbxmateria.getSelectedItem());
            cbxcursos.removeAllItems();
            while(rs.next()){
                cbxcursos.addItem(rs.getString("Nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void cargarLogro(){
       try {
            ResultSet rs=cone.consultaBD("SELECT * FROM logros where ="+cbxperiodo.getSelectedItem());
            cbxcursos.removeAllItems();
            while(rs.next()){
                cbxcursos.addItem(rs.getString("Nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbidAct = new javax.swing.JLabel();
        cbxlogro = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        lbdocente = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbxcursos = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtporc = new javax.swing.JTextField();
        cbxmateria = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cbxperiodo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel3.setText("DOCENTE");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel4.setText("Actividades");

        jLabel10.setText("DESCRIPCION");

        jLabel6.setText("CURSOS");

        jLabel11.setText("PORCENTAJE");

        cbxcursos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxcursosItemStateChanged(evt);
            }
        });

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("MATERIA");

        cbxmateria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxmateriaItemStateChanged(evt);
            }
        });

        jLabel8.setText("PERIODO");

        cbxperiodo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxperiodoItemStateChanged(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel9.setText("LOGRO ACADEMICO");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(177, 177, 177))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbidAct, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtporc, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxcursos, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbdocente, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxmateria, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxlogro, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(380, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbidAct, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbdocente, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(cbxcursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxmateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxlogro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtporc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxcursosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxcursosItemStateChanged
        cargarMateria();
    }//GEN-LAST:event_cbxcursosItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int id=Integer.parseInt(lbidAct.getText());
        String descr=jTextArea1.getText();
        int porc=Integer.parseInt(txtporc.getText());
        int per=Integer.parseInt((String) cbxperiodo.getSelectedItem());
        int id_logro=Integer.parseInt((String) cbxlogro.getSelectedItem());
        cone.modificaBD("insert into actividades values("+id+",'"+descr+"',"+porc+","+id_logro+"')");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxmateriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxmateriaItemStateChanged
        cargarPeriodo();
    }//GEN-LAST:event_cbxmateriaItemStateChanged

    private void cbxperiodoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxperiodoItemStateChanged
        cargarLogro();
    }//GEN-LAST:event_cbxperiodoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxcursos;
    private javax.swing.JComboBox cbxlogro;
    private javax.swing.JComboBox cbxmateria;
    private javax.swing.JComboBox cbxperiodo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbdocente;
    private javax.swing.JLabel lbidAct;
    private javax.swing.JTextField txtporc;
    // End of variables declaration//GEN-END:variables
}
