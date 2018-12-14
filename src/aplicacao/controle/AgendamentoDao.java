package aplicacao.controle;

import aplicacao.exception.AgendamentoException;
import aplicacao.utils.Conexao;
import aplicacao.modelo.Agendamento;
import aplicacao.utils.GravaLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDao {
    GravaLog log = new GravaLog();
    
    public void insert(Agendamento agendamento) throws AgendamentoException {
        
        if( agendamento.getDataIni()== null || agendamento.getDataIni().equals("")) {
            throw new AgendamentoException("A inclusao da Data Inicial e obrigatoria. ");
        }
        if( agendamento.getHoraIni()== null || agendamento.getHoraIni().equals("")) {                
            throw new AgendamentoException("A inclusao da Hora Inicial e obrigatoria. ");
        }
        if( agendamento.getKmIni()== null || agendamento.getKmIni() == 0) {                
            throw new AgendamentoException("A inclusao do km Inicial e obrigatoria. ");
        }
        if( agendamento.getDataFin()== null || agendamento.getDataFin().equals("")) {
            throw new AgendamentoException("A inclusao da Data Final e obrigatoria. ");
        }
        if( agendamento.getHorafin()== null || agendamento.getHorafin().equals("")) {                
            throw new AgendamentoException("A inclusao da Hora Final e obrigatoria. ");
        }
        if( agendamento.getKmFin()== null || agendamento.getKmFin() == 0) {                
            throw new AgendamentoException("A inclusao do km Final e obrigatoria. ");
        }
        if( agendamento.getCodMot()== null || agendamento.getCodMot() == 0) {                
            throw new AgendamentoException("A inclusao do Motorista e obrigatoria. ");
        }
        if( agendamento.getCodVei()== null || agendamento.getCodVei() == 0) {                
            throw new AgendamentoException("A inclusao do Veiculo e obrigatoria. ");
        }
        
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "insert into agendamentos (codAgend, dataIni, horaIni, kmIni, dataFin, horafin, kmFin, codMot, codVei, obs, status) values((select coalesce(max(codAgend), 0) + 1 from agendamentos),?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, agendamento.getDataIni());
            ps.setString(2, agendamento.getHoraIni());
            ps.setInt(3, agendamento.getKmIni());
            ps.setString(4, agendamento.getDataFin());
            ps.setString(5, agendamento.getHorafin());
            ps.setInt(6, agendamento.getKmFin());
            ps.setInt(7, agendamento.getCodMot());
            ps.setInt(8, agendamento.getCodVei());
            ps.setString(9, agendamento.getObs());
            ps.setInt(10, agendamento.getStatus());

            ps.execute();

            conn.commit();

        } catch(SQLException e) {
            log.logPrintStackTrace(e);

            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    log.logPrintStackTrace(ex);
                    throw new AgendamentoException("Erro de SQL");
                }
            }

        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    log.logPrintStackTrace(ex);
                    throw new AgendamentoException("Erro de SQL");
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    log.logPrintStackTrace(ex);
                    throw new AgendamentoException("Erro de SQL");
                }
            }
        }
    }

    public void update(Agendamento agendamento) throws AgendamentoException {
        
        if( agendamento.getDataIni()== null || agendamento.getDataIni().equals("")) {
            throw new AgendamentoException("A inclusao da Data Inicial e obrigatoria. ");
        }
        if( agendamento.getHoraIni()== null || agendamento.getHoraIni().equals("")) {                
            throw new AgendamentoException("A inclusao da Hora Inicial e obrigatoria. ");
        }
        if( agendamento.getKmIni()== null || agendamento.getKmIni() == 0) {                
            throw new AgendamentoException("A inclusao do km Inicial e obrigatoria. ");
        }
        if( agendamento.getDataFin()== null || agendamento.getDataFin().equals("")) {
            throw new AgendamentoException("A inclusao da Data Final e obrigatoria. ");
        }
        if( agendamento.getHorafin()== null || agendamento.getHorafin().equals("")) {                
            throw new AgendamentoException("A inclusao da Hora Final e obrigatoria. ");
        }
        if( agendamento.getKmFin()== null || agendamento.getKmFin() == 0) {                
            throw new AgendamentoException("A inclusao do km Final e obrigatoria. ");
        }
        if( agendamento.getCodMot()== null || agendamento.getCodMot() == 0) {                
            throw new AgendamentoException("A inclusao do Motorista e obrigatoria. ");
        }
        if( agendamento.getCodVei()== null || agendamento.getCodVei() == 0) {                
            throw new AgendamentoException("A inclusao do Veiculo e obrigatoria. ");
        }
        
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "update agendamentos set dataIni = ?, horaIni = ?, kmIni = ?, dataFin = ?, horafin = ?, kmFin = ?, codMot = ?, codVei = ?, obs = ?, status = ? where codAgend = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, agendamento.getDataIni());
            ps.setString(2, agendamento.getHoraIni());
            ps.setInt(3, agendamento.getKmIni());
            ps.setString(4, agendamento.getDataFin());
            ps.setString(5, agendamento.getHorafin());
            ps.setInt(6, agendamento.getKmFin());
            ps.setInt(7, agendamento.getCodMot());
            ps.setInt(8, agendamento.getCodVei());
            ps.setString(9, agendamento.getObs());
            ps.setInt(10, agendamento.getStatus());
            ps.setInt(11, agendamento.getCodAgend());
            ps.execute();

            conn.commit();
        } catch(SQLException e) {
            log.logPrintStackTrace(e);

            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    log.logPrintStackTrace(ex);
                    throw new AgendamentoException("Erro de SQL");
                }
            }


        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    log.logPrintStackTrace(ex);
                    throw new AgendamentoException("Erro de SQL");
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    log.logPrintStackTrace(ex);
                    throw new AgendamentoException("Erro de SQL");
                }
            }
        }
    }
    
    public void delete(Agendamento agendamento) throws AgendamentoException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "delete from agendamentos where codAgend = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, agendamento.getCodAgend());
            ps.execute();

            conn.commit();
        } catch(SQLException e) {
            log.logPrintStackTrace(e);

            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    log.logPrintStackTrace(ex);
                    throw new AgendamentoException("Erro de SQL");
                }
            }


        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    log.logPrintStackTrace(ex);
                    throw new AgendamentoException("Erro de SQL");
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    log.logPrintStackTrace(ex);
                    throw new AgendamentoException("Erro de SQL");
                }
            }
        }
    }

    public List<Agendamento> getAll() throws AgendamentoException {
        List<Agendamento> lista = new ArrayList<Agendamento>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "select codAgend, dataIni, horaIni, kmIni, dataFin, horafin, kmFin, codMot, codVei, obs, status from agendamentos";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Agendamento a = new Agendamento();
                a.setCodAgend(rs.getInt(1));
                a.setDataIni(rs.getString(2));
                a.setHoraIni(rs.getString(3));
                a.setKmIni(rs.getInt(4));
                a.setDataFin(rs.getString(5));
                a.setHorafin(rs.getString(6));
                a.setKmFin(rs.getInt(7));
                a.setCodMot(rs.getInt(8));
                a.setCodVei(rs.getInt(9));
                a.setObs(rs.getString(10));
                a.setStatus(rs.getInt(11));
                lista.add(a);
            }
        } catch(SQLException e) {
            log.logPrintStackTrace(e);
        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    log.logPrintStackTrace(ex);
                    throw new AgendamentoException("Erro de SQL");
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    log.logPrintStackTrace(ex);
                    throw new AgendamentoException("Erro de SQL");
                }
            }
        }
        return lista;
    }

    public Agendamento getAgendamento(Integer codigo) throws AgendamentoException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "select codAgend, dataIni, horaIni, kmIni, dataFin, horafin, kmFin, codMot, codVei, obs, status from agendamentos where codAgend = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Agendamento a = new Agendamento();
                a.setCodAgend(rs.getInt(1));
                a.setDataIni(rs.getString(2));
                a.setHoraIni(rs.getString(3));
                a.setKmIni(rs.getInt(4));
                a.setDataFin(rs.getString(5));
                a.setHorafin(rs.getString(6));
                a.setKmFin(rs.getInt(7));
                a.setCodMot(rs.getInt(8));
                a.setCodVei(rs.getInt(9));
                a.setObs(rs.getString(10));
                a.setStatus(rs.getInt(11));
                return a;
            }
        } catch(SQLException e) {
            log.logPrintStackTrace(e);
        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    log.logPrintStackTrace(ex);
                    throw new AgendamentoException("Erro de SQL");
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    log.logPrintStackTrace(ex);
                    throw new AgendamentoException("Erro de SQL");
                }
            }
        }
        return null;
    }
    
    public Boolean existis(Integer codigo) throws AgendamentoException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "select count(*) n_agend from agendamentos where codAgend = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                if(rs.getInt(1) > 0){
                    return true;
                } else {
                    return false;
                }
            }
        } catch(SQLException e) {
            log.logPrintStackTrace(e);
        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    log.logPrintStackTrace(ex);
                    throw new AgendamentoException("Erro de SQL");
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    log.logPrintStackTrace(ex);
                    throw new AgendamentoException("Erro de SQL");
                }
            }
        }
        return false;
    }
}
