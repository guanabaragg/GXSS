package Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import util.Conexao;

@ManagedBean
public class ProdutosDAO {

    private List<ProdutosBean> listaProdutos = new ArrayList<>();

    public static void main(String[] args) {
        ProdutosBean pr = new ProdutosBean();
        pr.setCodigo("0006");
        pr.setNome("Caneca Java Branca");
        pr.setQtd(30);
        pr.setValor(29.90);
        pr.setDtCadastro(new Date());

        salvar(pr);
        System.out.println("salvou bb");

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formato.format(pr.getDtCadastro());

        System.out.println(dataFormatada);

        /*
         Date data = rs.getDate("Data");
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
         String dataFormatada = formato.format(data);
         */
    }

    public static void salvar(ProdutosBean produtos) {

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("INSERT INTO `produtos` (`codigo`,`nome`,`qtd`,`valor`,`dtCadastro`) VALUES (?,?,?,?,?)");

            ps.setString(1, produtos.getCodigo());
            ps.setString(2, produtos.getNome());
            ps.setInt(3, produtos.getQtd());
            ps.setDouble(4, produtos.getValor());
            ps.setDate(5, new java.sql.Date(produtos.getDtCadastro().getTime()));

            ps.execute();
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            System.out.println("deu merda ao salvar" + ex);
        }
    }

    public List<ProdutosBean> lista() throws SQLException {

        try {

            Connection conexao = Conexao.getConexao();

            PreparedStatement ps = conexao.prepareStatement("select * from produtos");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ProdutosBean produtos = new ProdutosBean();

                produtos.setId(rs.getInt("id"));
                produtos.setCodigo(rs.getString("codigo"));
                produtos.setNome(rs.getString("nome"));
                produtos.setQtd(rs.getInt("qtd"));
                produtos.setValor(rs.getDouble("valor"));                        
                produtos.setDtCadastro(rs.getDate("dtCadastro"));
                listaProdutos.add(produtos);

            }
            ps.execute();
            ps.close();

            return listaProdutos;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public void alterar(ProdutosBean pProdutos) {

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("update produtos set nome = ?, qtd = ?, valor = ?, where codigo = ?");

            ps.setString(1, pProdutos.getNome());
            ps.setInt(2, pProdutos.getQtd());
            ps.setDouble(3, pProdutos.getValor());
            ps.setString(4, pProdutos.getCodigo());
            ps.execute();
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            System.out.println("Erro ao tentar salvar!" + ex);
        }

    }

    public void deletar(ProdutosBean pProdutos) {

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from usuarios where nome = ?");
            ps.setString(1, pProdutos.getNome());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("deu merda ao deletar " + ex);
        }
    }

    public List<ProdutosBean> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<ProdutosBean> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

}
