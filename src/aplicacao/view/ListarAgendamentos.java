package aplicacao.view;


import aplicacao.controle.AgendamentoDao;
import aplicacao.controle.MotoristaDao;
import aplicacao.controle.VeiculoDao;
import aplicacao.exception.AgendamentoException;
import aplicacao.modelo.Agendamento;
import aplicacao.utils.GravaLog;
import aplicacao.modelo.Motorista;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListarAgendamentos extends JInternalFrame {
    
    
    public ListarAgendamentos() {
        initComponents();
        GravaLog log = new GravaLog();
        try {
            log.acessoLog(this.getTitle());   
        } catch (Exception ex) {
            log.logPrintStackTrace(ex);
        }
        
        VeiculoDao daoV = new VeiculoDao();
        MotoristaDao daoM = new MotoristaDao();
        AgendamentoDao daoA = new AgendamentoDao();
        
        DefaultTableModel model = new DefaultTableModel();
        
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        
        model.addColumn("Código");
        model.addColumn("Veículo");
        model.addColumn("Motorista");
        model.addColumn("Data Ini");
        model.addColumn("Hora Ini");
        model.addColumn("Km Ini");
        model.addColumn("Data Fim");
        model.addColumn("Hora Fim");
        model.addColumn("Km Fim");
        model.addColumn("Status");
        model.addColumn("Observações");
        
        try {
            for(Agendamento m : daoA.getAll() ) {
                String veiculo = daoV.getVeiculo(m.getCodVei()).getDescricao();
                String motorista = daoM.getMotorista(m.getCodMot()).getNome();
                model.addRow(new Object[] { m.getCodAgend(), veiculo, motorista, m.getDataIni(), m.getHoraIni(), m.getKmIni(), m.getDataFin(), m.getHorafin(), m.getKmFin(), m.getStatusDesc(), m.getObs()});
            }
        } catch (AgendamentoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Atenção!!!", 0);
        }
        tableDados.setModel(model);   
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDados = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de Agendamentos");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("LISTA DE AGENDAMENTOS");

        tableDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Placa", "Renavan", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableDados;
    // End of variables declaration//GEN-END:variables
}
