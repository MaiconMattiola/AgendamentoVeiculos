package aplicacao.controle;

import aplicacao.modelo.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoControle {
    public void insert(Veiculo veiculo) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "insert into veiculos (codvei, descricao, placa, renavan, tipo) values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, veiculo.getCodVei());
            ps.setString(2, veiculo.getDescricao());
            ps.setString(3, veiculo.getPlaca());
            ps.setString(4, veiculo.getRenavan());
            ps.setInt(5, veiculo.getTipo());
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

    public void update(Veiculo veiculo) {
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
    
    public void delete(Veiculo veiculo) {
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

    public List<Veiculo> getAll() {
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

    public Veiculo getVeiculo(Integer codigo) {
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



}
