import java.util.*;
public class Product {
    Scanner le = new Scanner(System.in);
    private String Nome;
    private String Valor;
    public Product(String nome, String valor) {
        this.Nome = nome;
        this.Valor = valor;
    }

    public Product() {
    }

    public String getNome() {
        return Nome;
    }

    @Override
    public String toString() {
        return "Constr{" +
                "Nome='" + Nome + '\'' +
                ", Valor='" + Valor + '\'' +
                '}';
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        this.Valor = valor;
    }


}
