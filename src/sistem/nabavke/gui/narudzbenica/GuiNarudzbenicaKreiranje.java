/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.nabavke.gui.narudzbenica;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import sistem.nabavke.conteiner.narudzbenica.KreiranjeNarudzbeniceCounteiner;
import sistem.nabavke.conteiner.cenaObserver.CenaObserver;
import sistem.nabavke.controler.Controler;
import sistem.nabavke.domain.Dobavljac;
import sistem.nabavke.domain.Proizvod;

/**
 *
 * @author skiljevic
 */
public class GuiNarudzbenicaKreiranje extends javax.swing.JFrame implements CenaObserver{

    /**
     * Creates new form GuiNarudzbenicaKreiranje
     */
    public GuiNarudzbenicaKreiranje() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
                this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			Controler.zatvoriProzorKreiranjeNarudzbenice();
			}
		});
        this.listSviProizvodi.setModel(new AbstractListModel(){
            String [] values = KreiranjeNarudzbeniceCounteiner.vratiFormatiraneProizvode();
            
            public int getSize(){
            return values.length;
            }
            
            public Object getElementAt(int index){
            return values[index];
            }
        });
                
    }
    
    public GuiNarudzbenicaKreiranje(String sifra, String datum, double cena, String dobavljac, String stavke) {
        this();
        panelKreiranje.setVisible(false);
        txtSifra.setText(sifra);
        txtDatum.setText(datum);
        txtDobavljac.setText(dobavljac);
        txtStavkeNarudzbenice.setText(stavke);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSifra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDatum = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtStavkeNarudzbenice = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtDobavljac = new javax.swing.JTextField();
        btnIzborDobavljaca = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblCena = new javax.swing.JTextField();
        panelKreiranje = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSviProizvodi = new javax.swing.JList<>();
        btnDodajProizvod = new javax.swing.JButton();
        btnOduzmiProizvod = new javax.swing.JButton();
        btnKreirajNarudzbenicu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kreiranje narudzbenice");
        setResizable(false);

        jLabel1.setText("Sifra:");

        jLabel2.setText("Datum:");

        txtDatum.setText("DD.MM.YYYY");
        txtDatum.setToolTipText("");
        txtDatum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDatumFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDatumFocusLost(evt);
            }
        });
        txtDatum.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtDatumInputMethodTextChanged(evt);
            }
        });

        jLabel3.setText("Cena:");

        txtStavkeNarudzbenice.setEditable(false);
        txtStavkeNarudzbenice.setColumns(20);
        txtStavkeNarudzbenice.setRows(5);
        jScrollPane2.setViewportView(txtStavkeNarudzbenice);

        jLabel5.setText("Dobavljac:");

        txtDobavljac.setEditable(false);

        btnIzborDobavljaca.setText("Izbor dobavljaca");

        jLabel6.setText("Stavke narudzbenice");

        lblCena.setEditable(false);

        jLabel4.setText("Proizvodi");

        listSviProizvodi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSviProizvodiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listSviProizvodi);

        btnDodajProizvod.setText("Dodaj u stavke");
        btnDodajProizvod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajProizvodActionPerformed(evt);
            }
        });

        btnOduzmiProizvod.setText("Oduzmi iz stavki");
        btnOduzmiProizvod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOduzmiProizvodActionPerformed(evt);
            }
        });

        btnKreirajNarudzbenicu.setText("Kreiraj");

        javax.swing.GroupLayout panelKreiranjeLayout = new javax.swing.GroupLayout(panelKreiranje);
        panelKreiranje.setLayout(panelKreiranjeLayout);
        panelKreiranjeLayout.setHorizontalGroup(
            panelKreiranjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKreiranjeLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnDodajProizvod)
                .addGap(18, 18, 18)
                .addComponent(btnOduzmiProizvod)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKreiranjeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelKreiranjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKreiranjeLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKreiranjeLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKreiranjeLayout.createSequentialGroup()
                        .addComponent(btnKreirajNarudzbenicu, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );
        panelKreiranjeLayout.setVerticalGroup(
            panelKreiranjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKreiranjeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelKreiranjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajProizvod)
                    .addComponent(btnOduzmiProizvod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKreirajNarudzbenicu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDobavljac, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnIzborDobavljaca))
                                    .addComponent(lblCena, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 117, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(panelKreiranje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDatum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(txtSifra, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDobavljac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIzborDobavljaca))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panelKreiranje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listSviProizvodiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSviProizvodiMouseClicked
//        if(evt.getClickCount() == 2){
//            Controler.addClickedProizvod(listSviProizvodi.getSelectedValue());
//        }
    }//GEN-LAST:event_listSviProizvodiMouseClicked

    private void btnDodajProizvodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajProizvodActionPerformed
        if(listSviProizvodi.getSelectedValue() != null)Controler.dodajProizvodUnarudzbenice(listSviProizvodi.getSelectedValue());
    }//GEN-LAST:event_btnDodajProizvodActionPerformed

    private void btnOduzmiProizvodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOduzmiProizvodActionPerformed
        if(listSviProizvodi.getSelectedValue() != null)Controler.izbaciProizvodIzNarudzbenice(listSviProizvodi.getSelectedValue());
    }//GEN-LAST:event_btnOduzmiProizvodActionPerformed

    private void txtDatumInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtDatumInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatumInputMethodTextChanged

    private void txtDatumFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDatumFocusLost
        if(txtDatum.getText().equalsIgnoreCase(""))txtDatum.setText("DD.MM.YYYY");
    }//GEN-LAST:event_txtDatumFocusLost

    private void txtDatumFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDatumFocusGained
        if(txtDatum.getText().equalsIgnoreCase("DD.MM.YYYY"))txtDatum.setText("");
    }//GEN-LAST:event_txtDatumFocusGained

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajProizvod;
    private javax.swing.JButton btnIzborDobavljaca;
    private javax.swing.JButton btnKreirajNarudzbenicu;
    private javax.swing.JButton btnOduzmiProizvod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lblCena;
    private javax.swing.JList<String> listSviProizvodi;
    private javax.swing.JPanel panelKreiranje;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtDobavljac;
    private javax.swing.JTextField txtSifra;
    private javax.swing.JTextArea txtStavkeNarudzbenice;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void update(double cena) {
        lblCena.setText(cena + "");
        System.out.println("cena psotavljena na " + cena);
    }
    
    public void setNarudzbenice(String text){
        txtStavkeNarudzbenice.setText(text);
    }
    public String getNarudzbenice(){
        return txtStavkeNarudzbenice.getText();
    }
}
