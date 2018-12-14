package aplicacao.controle;

import aplicacao.exception.AgendamentoException;
import aplicacao.utils.Conexao;
import aplicacao.modelo.Veiculo;
import aplicacao.utils.GravaLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDao {
    GravaLog log = new GravaLog();
    
    public void insert(Veiculo veiculo) throws AgendamentoException {  
        if( veiculo.getDescricao()== null || veiculo.getDescricao().equals("")) {
            throw new AgendamentoException("A inclusao da Descrição e obrigatoria. ");
        }
        if( veiculo.getPlaca() == null || veiculo.getPlaca().equals("")) {                
            throw new AgendamentoException("A inclusao da Placa e obrigatoria. ");
        }
        if( veiculo.getRenavan()== null || veiculo.getRenavan().equals("")) {                
            throw new AgendamentoException("A inclusao do Renavan e obrigatoria. ");
        }
        
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "insert into veiculos (codvei, descricao, placa, renavan, tipo) values((select coalesce(max(codvei), 0) + 1 from veiculos),?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, veiculo.getDescricao());
            ps.setString(2, veiculo.getPlaca());
            ps.setString(3, veiculo.getRenavan());
            ps.setInt(4, veiculo.getTipo());
            ps.execute();

            conn.commit();

        } catch(SQLException e) {
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

    public void update(Veiculo veiculo) throws AgendamentoException {
        if( veiculo.getDescricao()== null || veiculo.getDescricao().equals("")) {
            throw new AgendamentoException("A inclusao da Descrição e obrigatoria. ");
        }
        if( veiculo.getPlaca()== null || veiculo.getPlaca().equals("")) {                
            throw new AgendamentoException("A inclusao da Placa e obrigatoria. ");
        }
        if( veiculo.getRenavan()== null || veiculo.getRenavan().equals("")) {                
            throw new AgendamentoException("A inclusao do Renavan e obrigatoria. ");
        }
        
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "update veiculos set descricao = ?, placa = ?, renavan = ?, tipo = ? where codvei = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, veiculo.getDescricao());
            ps.setString(2, veiculo.getPlaca());
            ps.setString(3, veiculo.getRenavan());
            ps.setInt(4, veiculo.getTipo());
            ps.setInt(5, veiculo.getCodVei());
            ps.execute();

            conn.commit();
        } catch(SQLException e) {
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
    
    public void delete(Veiculo veiculo) throws AgendamentoException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "delete from veiculos where codvei = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, veiculo.getCodVei());
            ps.execute();

            conn.commit();
        } catch(SQLException e) {
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

    public List<Veiculo> getAll() throws AgendamentoException {
        List<Veiculo> lista = new ArrayList<Veiculo>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "select codvei, descricao, placa, renavan, tipo from veiculos";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Veiculo p = new Veiculo();
                p.setCodVei(rs.getInt(1));
                p.setDescricao(rs.getString(2));
                p.setPlaca(rs.getString(3));
                p.setRenavan(rs.getString(4));
                p.setTipo(rs.getInt(5));
                lista.add(p);
            }
        } catch(SQLException ex) {
            log.logPrintStackTrace(ex);
            throw new AgendamentoException("Erro de SQL");
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

    public Veiculo getVeiculo(Integer codigo) throws AgendamentoException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "select codvei, descricao, placa, renavan, tipo from veiculos where codvei = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Veiculo p = new Veiculo();
                p.setCodVei(rs.getInt(1));
                p.setDescricao(rs.getString(2));
                p.setPlaca(rs.getString(3));
                p.setRenavan(rs.getString(4));
                p.setTipo(rs.getInt(5));
                return p;
            }
        } catch(SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            throw new AgendamentoException("Erro de SQL");
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
            String sql = "select count(*) n_veiculos from veiculos where codvei = ?";
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
            System.out.println("ERRO: " + e.getMessage());
            throw new AgendamentoException("Erro de SQL");
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
