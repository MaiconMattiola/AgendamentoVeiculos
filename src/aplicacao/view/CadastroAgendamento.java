package aplicacao.view;


import aplicacao.utils.GravaLog;
import aplicacao.controle.AgendamentoActionListener;
import aplicacao.controle.MotoristaDao;
import aplicacao.controle.VeiculoDao;
import aplicacao.modelo.Agendamento;
import aplicacao.modelo.Motorista;
import aplicacao.modelo.Veiculo;
import aplicacao.utils.ComboItem;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;

public class CadastroAgendamento extends JInternalFrame {
    private AgendamentoActionListener action = new AgendamentoActionListener(this);
    
    public CadastroAgendamento() {
        initComponents();
        
        btnCancelar.addActionListener(action);
        btnSalvar.addActionListener(action);
        btnExcluir.addActionListener(action);
        
        GravaLog log = new GravaLog();
        try {    
            log.acessoLog(this.getTitle());
        } catch (Exception ex) {
            log.logPrintStackTrace(ex);
        }
        loadComboVei();
        loadComboMot();
    }
    
    private void loadComboVei(){
        VeiculoDao dao = new VeiculoDao();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(Veiculo m : dao.getAll() ) {
            model.addElement(new ComboItem(m.getCodVei(), m.getDescricao()));
        }
        
        comboCodVeiculo.setModel(model);
    }
    
    private void loadComboMot(){
        MotoristaDao dao = new MotoristaDao();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(Motorista m : dao.getAll() ) {
            model.addElement(new ComboItem(m.getCodMot(), m.getNome()));
        }
        
        comboCodMotorista.setModel(model);
    }
    
    public Agendamento getAgendamento() {
        Agendamento a = new Agendamento();
        if (txtCodigoAgendamento.getText().equals("")) {
            a.setCodAgend(0);
        } else {
            a.setCodAgend(Integer.valueOf(txtCodigoAgendamento.getText()));
        }
        
        a.setDataIni(txtDataIni.getText());
        a.setHoraIni(txtHoraIni.getText());
        a.setKmIni(Integer.valueOf(txtKMInicial.getText()));
        a.setHorafin(txtHoraFin.getText());
        a.setDataFin(txtDataFin.getText());
        a.setKmFin(Integer.valueOf(txtKMFinal.getText()));
        a.setCodMot(((ComboItem)comboCodMotorista.getSelectedItem()).getValue());
        a.setCodVei(((ComboItem)comboCodVeiculo.getSelectedItem()).getValue());
        a.setObs(txtObs.getText());
        a.setStatus(comboStatus.getSelectedIndex());
        return a;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblCodigoAgendamento = new javax.swing.JLabel();
        lblDataSaida = new javax.swing.JLabel();
        lblHoraSaida = new javax.swing.JLabel();
        lblDataRetorno = new javax.swing.JLabel();
        lblHoraRetorno = new javax.swing.JLabel();
        lblKmInicial = new javax.swing.JLabel();
        lblKmFinal = new javax.swing.JLabel();
        lblCodigoVeiculo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblItininerario = new javax.swing.JLabel();
        txtCodigoAgendamento = new javax.swing.JTextField();
        txtKMInicial = new javax.swing.JTextField();
        txtKMFinal = new javax.swing.JTextField();
        txtObs = new javax.swing.JTextField();
        txtDataIni = new javax.swing.JFormattedTextField();
        txtHoraIni = new javax.swing.JFormattedTextField();
        txtHoraFin = new javax.swing.JFormattedTextField();
        txtDataFin = new javax.swing.JFormattedTextField();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        comboCodVeiculo = new javax.swing.JComboBox<>();
        comboCodMotorista = new javax.swing.JComboBox<>();
        btnExcluir = new javax.swing.JButton();
        comboStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Agendamentos");

        btnCancelar.setText("Cancelar");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("CADASTRO DE AGENDAMENTOS");

        lblCodigoAgendamento.setText("Código:");

        lblDataSaida.setText("Data saída:");

        lblHoraSaida.setText("Hora saída:");

        lblDataRetorno.setText("Data retorno:");

        lblHoraRetorno.setText("Hora retorno:");

        lblKmInicial.setText("KM inicial:");

        lblKmFinal.setText("KM final:");

        lblCodigoVeiculo.setText("Código do veículo:");

        jLabel10.setText("Código do motorista:");

        jLabel11.setText("Status:");

        lblItininerario.setText("Observações:");

        try {
            txtDataIni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtHoraIni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHoraIni.setText("  :  ");

        try {
            txtHoraFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHoraFin.setText("  :  ");

        try {
            txtDataFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnLimpar.setText("Limpar");

        btnSalvar.setText("Salvar");

        btnExcluir.setText("Excluir");

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agendado", "Em Andamento", "Finalizado" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCodigoAgendamento)
                                    .addComponent(jLabel11)
                                    .addComponent(comboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCodigoAgendamento))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDataFin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDataIni, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDataSaida)
                                    .addComponent(lblDataRetorno)))
                            .addComponent(comboCodVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 18, Short.MAX_VALUE)
                                                .addComponent(txtHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblHoraRetorno)
                                                    .addComponent(lblHoraSaida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtHoraIni, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblKmInicial)
                                            .addComponent(lblKmFinal)
                                            .addComponent(txtKMFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(txtKMInicial))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(comboCodMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblItininerario)
                            .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCodigoVeiculo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnLimpar)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigoAgendamento)
                            .addComponent(lblDataSaida)
                            .addComponent(lblHoraSaida)
                            .addComponent(lblKmInicial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKMInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoraIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblKmFinal)
                                .addComponent(lblHoraRetorno)
                                .addComponent(lblDataRetorno)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDataFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKMFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigoVeiculo)
                            .addComponent(jLabel10))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboCodVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCodMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(lblItininerario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)
                    .addComponent(btnLimpar)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboCodMotorista;
    private javax.swing.JComboBox<String> comboCodVeiculo;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCodigoAgendamento;
    private javax.swing.JLabel lblCodigoVeiculo;
    private javax.swing.JLabel lblDataRetorno;
    private javax.swing.JLabel lblDataSaida;
    private javax.swing.JLabel lblHoraRetorno;
    private javax.swing.JLabel lblHoraSaida;
    private javax.swing.JLabel lblItininerario;
    private javax.swing.JLabel lblKmFinal;
    private javax.swing.JLabel lblKmInicial;
    private javax.swing.JTextField txtCodigoAgendamento;
    private javax.swing.JFormattedTextField txtDataFin;
    private javax.swing.JFormattedTextField txtDataIni;
    private javax.swing.JFormattedTextField txtHoraFin;
    private javax.swing.JFormattedTextField txtHoraIni;
    private javax.swing.JTextField txtKMFinal;
    private javax.swing.JTextField txtKMInicial;
    private javax.swing.JTextField txtObs;
    // End of variables declaration//GEN-END:variables
}
