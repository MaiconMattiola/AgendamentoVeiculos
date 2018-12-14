package aplicacao.controle;

import aplicacao.utils.Conexao;
import aplicacao.modelo.Agendamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDao {
    public void insert(Agendamento agendamento) {
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
            System.out.println("ERRO: " + e.getMessage());

            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }

    public void update(Agendamento agendamento) {
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
            System.out.println("ERRO: " + e.getMessage());

            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }


        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }
    
    public void delete(Agendamento agendamento) {
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
            System.out.println("ERRO: " + e.getMessage());

            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }


        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }

    public List<Agendamento> getAll() {
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
            System.out.println("ERRO: " + e.getMessage());
        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        return lista;
    }

    public Agendamento getAgendamento(Integer codigo) {
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
            System.out.println("ERRO: " + e.getMessage());
        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        return null;
    }
    
    public Boolean existis(Integer codigo) {
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
            System.out.println("ERRO: " + e.getMessage());
        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        return false;
    }
}
