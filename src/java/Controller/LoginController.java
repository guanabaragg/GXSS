/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author SQL
 */
@SessionScoped
@ManagedBean(name = "loginController")
public class LoginController implements HttpSessionListener {

    private HttpSession session;
    String usuario = "";
    String login = "";
    String senha = "";
    private String vEmail = null;
    private String color = "-blue";
    String home;

    private StreamedContent logo;

    public void mudarPagina(String pPagina) {
        try {
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesContext.getCurrentInstance().getExternalContext().redirect(ctx.getExternalContext().getRequestContextPath() + pPagina);

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarlogo() {
        try {
            //FileInputStream in = new FileInputStream(new File("C:\\Projetos\\CIM\\web\\images\\logo1pqn.png"));
            //System.out.println("C:\\Projetos\\CIM\\web\\images\\logo.png");
            //logo = new DefaultStreamedContent(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void log() {

        FacesContext ctx = FacesContext.getCurrentInstance();

        if (login.equals("alex") && senha.equals("123")) {
            mudarPagina("/principal/principal.jsf");
        }
        System.out.println("Login: " + login + " | Senha: " + senha);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ou senha invalido!", ""));
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public String getvEmail() {
        return vEmail;
    }

    public void setvEmail(String vEmail) {
        this.vEmail = vEmail;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHome() {
        return home;
    }

    public void sair() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession s = (HttpSession) fc.getExternalContext().getSession(false);
        s.invalidate();
        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(ctx.getExternalContext().getRequestContextPath() + "/");

        } catch (IOException ex) {
            System.out.println("deu merda no sair");
        }
    }

    public void setHome(String home) {
        this.home = home;
    }

    public StreamedContent getLogo() {
        return logo;
    }

    public void setLogo(StreamedContent logo) {
        this.logo = logo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
