/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author guana
 */
@ManagedBean
public class UsuarioController {

    private int id;
    private String name;
    private String login;
    private String password;
    private String cpf;
    private String tel;
    private String whatsapp;
    private String emaill;
    private Date DtCadastro;
    private String dataFormatada;
    private String situacao;
    private String situacaoA = "Ativo";
    private String situacaoI = "Inativo";
    private List<usuariosBean> listaUsers = new ArrayList<>();

    private Integer tela = 0;

    public void selecionar() throws SQLException {
        usuariosBean userBean = new usuariosBean();
        usuariosDAO userDAO = new usuariosDAO();

        userBean.getId();
        userBean.getNome();
        userBean.getLogin();
        userBean.getSenha();
        userBean.getCpf();
        userBean.getTel();
        userBean.getWhatsapp();
        userBean.getSituacao();
        userDAO.selecionar(userBean);
        tela = 1;
    }

    public void mudarTela(Integer pTela) {
        tela = pTela;
    }

    public void validacaoLogin() {
        usuariosDAO userDAO = new usuariosDAO();
        userDAO.validacaoLogin(login, password);
    }

    public void lista() throws SQLException {

        usuariosDAO userdao = new usuariosDAO();
        listaUsers = userdao.getListaUsers();

        usuariosBean userBean = new usuariosBean();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        userBean.setDataFormatada(formato.format(userBean.getDtCadastro()));

        System.out.println(userBean.getDataFormatada());

        userdao.lista();
    }

    public void salvar() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        usuariosBean user = new usuariosBean();
        usuariosDAO userdao = new usuariosDAO();

        user.setNome(name);
        user.setLogin(login);
        user.setSenha(password);
        user.setCpf(cpf);
        user.setTel(tel);
        user.setWhatsapp(whatsapp);
        user.setEmail(emaill);
        user.setDtCadastro(DtCadastro);
        user.setSituacao(situacao);

        userdao.salvar(user);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário salvo com sucesso!", ""));
        tela = 0;
        System.out.println("Salvo com sucesso. id: " + user.getId());

    }

    public void deletar() {

        usuariosBean user = new usuariosBean();
        usuariosDAO userdao = new usuariosDAO();

        user.setId(user.getId());
        user.setNome(name);
        user.setLogin(login);
        user.setSenha(password);
        user.setCpf(cpf);
        user.setTel(tel);
        user.setWhatsapp(whatsapp);
        user.setEmail(emaill);
        user.setDtCadastro(DtCadastro);
        user.setSituacao(situacao);

        userdao.deletar(user);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário deletado com sucesso!", ""));
        System.out.println("Deletado com sucesso.");
        setName("");
        setPassword("");
        setEmaill("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<usuariosBean> getListaUsers() {
        return listaUsers;
    }

    public void setListaUsers(List<usuariosBean> listaUsers) {
        this.listaUsers = listaUsers;
    }

    public Integer getTela() {
        return tela;
    }

    public void setTela(Integer tela) {
        this.tela = tela;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDtCadastro() {
        return DtCadastro;
    }

    public void setDtCadastro(Date DtCadastro) {
        this.DtCadastro = DtCadastro;
    }

    public String getSituacaoA() {
        return situacaoA;
    }

    public void setSituacaoA(String situacaoA) {
        this.situacaoA = situacaoA;
    }

    public String getSituacaoI() {
        return situacaoI;
    }

    public void setSituacaoI(String situacaoI) {
        this.situacaoI = situacaoI;
    }
}
