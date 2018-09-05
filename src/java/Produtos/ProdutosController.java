package Produtos;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class ProdutosController {

    private int id;
    private String codigo;
    private String nome;
    private int qtd;
    private double valor;
    private Date dtCadastro;

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    String dataFormatada = formato.format(dtCadastro);

    private List<ProdutosBean> listaProdutos = new ArrayList<>();

    private Integer tela = 0;

    ProdutosBean produtosBean = new ProdutosBean();

    public void novo() {
        tela = 1;
    }

    public void mudarTela(Integer pTela) {
        tela = pTela;
    }

    public void lista() throws SQLException {

        ProdutosDAO produtosDAO = new ProdutosDAO();
        listaProdutos = produtosDAO.getListaProdutos();
        produtosDAO.lista();
        //System.out.println("Listou com sucesso, Produtos.");
    }

    public void salvar() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        ProdutosBean produtosBean = new ProdutosBean();
        ProdutosDAO produtosDAO = new ProdutosDAO();

        produtosBean.setCodigo(codigo);
        produtosBean.setNome(nome);
        produtosBean.setQtd(qtd);
        produtosBean.setValor(valor);
        produtosBean.setDtCadastro(dtCadastro);

        produtosDAO.salvar(produtosBean);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto salvo com sucesso!", ""));
        System.out.println("Produto Salvo com sucesso. id: " + produtosBean.getId());

    }

    public void deletar() {

        ProdutosBean user = new ProdutosBean();
        ProdutosDAO userdao = new ProdutosDAO();

//        user.setId(user.getId());
//        user.setNome(name);
//        user.setLogin(login);
//        user.setSenha(password);
        userdao.deletar(user);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário deletado com sucesso!", ""));
        System.out.println("Deletado com sucesso.");

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public List<ProdutosBean> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<ProdutosBean> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Integer getTela() {
        return tela;
    }

    public void setTela(Integer tela) {
        this.tela = tela;
    }

    public ProdutosBean getProdutosBean() {
        return produtosBean;
    }

    public void setProdutosBean(ProdutosBean produtosBean) {
        this.produtosBean = produtosBean;
    }

    public SimpleDateFormat getFormato() {
        return formato;
    }

    public void setFormato(SimpleDateFormat formato) {
        this.formato = formato;
    }

    public String getDataFormatada() {
        return dataFormatada;
    }

    public void setDataFormatada(String dataFormatada) {
        this.dataFormatada = dataFormatada;
    }

}
