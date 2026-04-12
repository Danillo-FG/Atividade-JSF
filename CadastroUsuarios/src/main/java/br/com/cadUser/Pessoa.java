package br.com.cadUser;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 * ManagedBean para cadastro de usuários.
 *
 * @Named        — substitui o @ManagedBean descontinuado no JSF 2.3
 * @SessionScoped — mantém a lista acumulando durante toda a sessão do navegador
 * Serializable  — obrigatório para beans com escopo de sessão no WildFly
 */
@Named
@SessionScoped
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    // ── Atributos ──────────────────────────────────

    private String nome;
    private ArrayList<String> nomes = new ArrayList<String>();

    // ── Getters e Setters ──────────────────────────

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getNomes() {
        return nomes;
    }

    public void setNomes(ArrayList<String> nomes) {
        this.nomes = nomes;
    }

    // ── Ação do formulário ─────────────────────────

    public void cadastrar() {
        if (nome != null && !nome.trim().isEmpty()) {
            nomes.add(nome.trim());
            nome = "";
        }
    }
}
