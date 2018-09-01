/**
 * ********************************************************************************
 */
/*CRIADO DE FORMA AUTOMATICA PELO GERADOR DE CÓDIGO DA CROSSYSTEM*/
/*Data:  2016-08-06 */
/**
 * ********************************************************************************
 */
package Controller;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "parceiroController")
@ViewScoped
public class ParceiroController {

    String pesquisa;
    Integer tela = 0;

    String id = "";
    String tituloPagina;

    private boolean dispLocal;
    private boolean custoHospedagem;
    private boolean custoAlimentacao;
    private String[] localDescDisponibiliza;
    private String localHospedagem = "";
    private String localDescDisponibilizaOutro = "";
    private Date dataHospInicial;
    private Date dataHospFinal;
    private String Observacoes = "";

    public void iniciar() {

    }

    public void novo() {
        tela = 1;
    }

    public void mudarTela(Integer pTela) {
        tela = pTela;
    }

    public void limiteData() {

        if (getDataHospFinal() != null) {
            if (getDataHospInicial().after(getDataHospFinal())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data Incial não pode ser superior a Data Final.", ""));
                return;
            }
            if (getDataHospInicial() != null) {
                if (getDataHospFinal().after(getDataHospInicial())) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data Final não pode ser inferior a Data Inicial.", ""));
                    return;
                }
            }
        }
    }

    public boolean isDispLocal() {
        return dispLocal;
    }

    public void setDispLocal(boolean dispLocal) {
        this.dispLocal = dispLocal;
    }

    public boolean isCustoHospedagem() {
        return custoHospedagem;
    }

    public void setCustoHospedagem(boolean custoHospedagem) {
        this.custoHospedagem = custoHospedagem;
    }

    public boolean isCustoAlimentacao() {
        return custoAlimentacao;
    }

    public void setCustoAlimentacao(boolean custoAlimentacao) {
        this.custoAlimentacao = custoAlimentacao;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public Integer getTela() {
        return tela;
    }

    public void setTela(Integer tela) {
        this.tela = tela;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTituloPagina() {
        return tituloPagina;
    }

    public void setTituloPagina(String tituloPagina) {
        this.tituloPagina = tituloPagina;
    }

    public String[] getLocalDescDisponibiliza() {
        return localDescDisponibiliza;
    }

    public void setLocalDescDisponibiliza(String[] localDescDisponibiliza) {
        this.localDescDisponibiliza = localDescDisponibiliza;
    }

    public String getLocalDescDisponibilizaOutro() {
        return localDescDisponibilizaOutro;
    }

    public void setLocalDescDisponibilizaOutro(String localDescDisponibilizaOutro) {
        this.localDescDisponibilizaOutro = localDescDisponibilizaOutro;
    }

    public String getLocalHospedagem() {
        return localHospedagem;
    }

    public void setLocalHospedagem(String localHospedagem) {
        this.localHospedagem = localHospedagem;
    }

    public Date getDataHospFinal() {
        return dataHospFinal;
    }

    public void setDataHospFinal(Date dataHospFinal) {
        this.dataHospFinal = dataHospFinal;
    }

    public Date getDataHospInicial() {
        return dataHospInicial;
    }

    public void setDataHospInicial(Date dataHospInicial) {
        this.dataHospInicial = dataHospInicial;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String Observacoes) {
        this.Observacoes = Observacoes;
    }

}
