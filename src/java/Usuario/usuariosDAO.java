package Usuario;

import Controller.LoginController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import util.Conexao;

@ManagedBean
public class usuariosDAO {

    private List<usuariosBean> listaUsers = new ArrayList<>();

    public void salvar(usuariosBean user) {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("INSERT INTO `usuarios` (`nome`,`login`,`senha`,`cpf`,`tel`,`whatsapp`,`email`,`dtCadastro`,`situacao`) VALUES (?,?,?,?,?,?,?,?,?)");

            ps.setString(1, user.getNome());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getSenha());
            ps.setString(4, user.getCpf());
            ps.setString(5, user.getTel());
            ps.setString(6, user.getWhatsapp());
            ps.setString(7, user.getEmail());
            ps.setDate(8, new java.sql.Date(user.getDtCadastro().getTime()));
            ps.setString(9, user.getSituacao());
            ps.execute();
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            System.out.println("deu merda ao salvar" + ex);
        }
    }

    public List<usuariosBean> lista() throws SQLException {

        try {

            Connection conexao = Conexao.getConexao();

            PreparedStatement ps = conexao.prepareStatement("select * from usuarios");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                usuariosBean user = new usuariosBean();

                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                user.setCpf(rs.getString("cpf"));
                user.setTel(rs.getString("tel"));
                user.setWhatsapp(rs.getString("whatsapp"));
                user.setEmail(rs.getString("email"));
                user.setDtCadastro(rs.getDate("dtCadastro"));
                user.setSituacao(rs.getString("situacao"));
                listaUsers.add(user);

            }
            ps.execute();
            ps.close();

            return listaUsers;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public void alterar(usuariosBean user) {
// nome,login,senha,cpf,tel,whatsapp,email,dtCadastro,situacao
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("update usuarios set senha = ?, email = ? where nome = ?");

            ps.setString(1, user.getSenha());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getNome());
            ps.execute();
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            System.out.println("Erro ao tentar salvar!" + ex);
        }

    }

    public void deletar(usuariosBean user) {

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from usuarios where nome = ?");
            ps.setString(1, user.getNome());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("deu merda ao deletar " + ex);
        }
    }

    public List<usuariosBean> validacaoLogin(String nome, String senha) {

        List<usuariosBean> usuarios = new ArrayList<>();

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from usuarios");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                usuariosBean user = new usuariosBean();
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                user.setCpf(rs.getString("cpf"));
                user.setTel(rs.getString("tel"));
                user.setWhatsapp(rs.getString("whatsapp"));
                user.setEmail(rs.getString("email"));
                user.setDtCadastro(rs.getDate("dtCadastro"));
                user.setSituacao(rs.getString("situacao"));
                usuarios.add(user);

                if (nome.equals(user.getLogin()) && senha.equals(user.getSenha())) {
                    //JOptionPane.showMessageDialog(null, "Sucesso guanabara,\nlogin: " + usuario.getNome() + "\nId: " + usuario.getId());
                    System.out.println("Sucesso guanabara,\n  login: " + user.getLogin() + "\n  Id: " + user.getId());
                    LoginController logincon = new LoginController();
                    logincon.mudarPagina("/principal/principal.jsf");
                    Conexao.fecharConexao();
                    //System.exit(0);
                }
            }

            System.out.println("erro ao validar login");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ou senha invalido!", ""));
            //JOptionPane.showMessageDialog(null, "Deu merda na validação de login guanabara\nLogin/Senha Incorretos!\nCrie um novo usuário");
            //novoUser();

            Conexao.fecharConexao();
            return usuarios;
        } catch (SQLException ex) {
            //System.out.println("deu merda ao validar login. " + ex);
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "deu merda ao validar login. " + ex, ""));
        }
        return usuarios;
    }

    public List<usuariosBean> selecionar(usuariosBean userBean) throws SQLException {

        try {

            Connection conexao = Conexao.getConexao();

            PreparedStatement ps = conexao.prepareStatement("select * from usuarios");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                usuariosBean user = new usuariosBean();

                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                user.setCpf(rs.getString("cpf"));
                user.setTel(rs.getString("tel"));
                user.setWhatsapp(rs.getString("whatsapp"));
                user.setEmail(rs.getString("email"));
                user.setDtCadastro(rs.getDate("dtCadastro"));
                user.setSituacao(rs.getString("situacao"));
                listaUsers.add(user);

            }
            ps.execute();
            ps.close();

            return listaUsers;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public List<usuariosBean> getListaUsers() {
        return listaUsers;
    }

    public void setListaUsers(List<usuariosBean> listaUsers) {
        this.listaUsers = listaUsers;
    }

}
