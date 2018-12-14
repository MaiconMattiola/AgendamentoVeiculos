package aplicacao.controle;

import aplicacao.exception.AgendamentoException;
import aplicacao.utils.Conexao;
import aplicacao.modelo.Motorista;
import aplicacao.utils.GravaLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotoristaDao {
    GravaLog log = new GravaLog();
    
    public void insert(Motorista motorista) throws AgendamentoException {
        
        if( motorista.getNome()== null || motorista.getNome().equals("")) {
            throw new AgendamentoException("A inclusao da Nome e obrigatoria. ");
        }
        if( motorista.getCNH()== null || motorista.getCNH() == 0) {                
            throw new AgendamentoException("A inclusao da CNH e obrigatoria. ");
        }
        if( motorista.getValCNH()== null || motorista.getValCNH().equals("")) {                
            throw new AgendamentoException("A inclusao do Renavan e obrigatoria. ");
        }
        
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "insert into motoristas (codMot, nome, CNH, tipoCNH, valCNH) values((select coalesce(max(codMot), 0) + 1 from motoristas),?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, motorista.getNome());
            ps.setInt(2, motorista.getCNH());
            ps.setInt(3, motorista.getTipoCNH());
            ps.setString(4, motorista.getValCNH());
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

    public void update(Motorista motorista) throws AgendamentoException {
        
        if( motorista.getNome()== null || motorista.getNome().equals("")) {
            throw new AgendamentoException("A inclusao da Nome e obrigatoria. ");
        }
        if( motorista.getCNH()== null || motorista.getCNH() == 0) {                
            throw new AgendamentoException("A inclusao da CNH e obrigatoria. ");
        }
        if( motorista.getValCNH()== null || motorista.getValCNH().equals("")) {                
            throw new AgendamentoException("A inclusao do Renavan e obrigatoria. ");
        }
        
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "update motoristas set nome = ?, CNH = ?, tipoCNH = ?, valCNH = ? where codMot = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, motorista.getNome());
            ps.setInt(2, motorista.getCNH());
            ps.setInt(3, motorista.getTipoCNH());
            ps.setString(4, motorista.getValCNH());
            ps.setInt(5, motorista.getCodMot());
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
    
    public void delete(Motorista motorista) throws AgendamentoException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "delete from motoristas where codMot = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, motorista.getCodMot());
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

    public List<Motorista> getAll() throws AgendamentoException {
        List<Motorista> lista = new ArrayList<Motorista>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "select codMot, nome, CNH, tipoCNH, valCNH from motoristas";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Motorista p = new Motorista();
                p.setCodMot(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setCNH(rs.getInt(3));
                p.setTipoCNH(rs.getInt(4));
                p.setValCNH(rs.getString(5));
                lista.add(p);
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

    public Motorista getMotorista(Integer codigo) throws AgendamentoException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "select codMot, nome, CNH, tipoCNH, valCNH from motoristas where codMot = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Motorista p = new Motorista();
                p.setCodMot(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setCNH(rs.getInt(3));
                p.setTipoCNH(rs.getInt(4));
                p.setValCNH(rs.getString(5));
                return p;
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
            String sql = "select count(*) n_motoristas from motoristas where codMot = ?";
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
