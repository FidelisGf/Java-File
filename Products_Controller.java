import java.io.*;
import  java.util.*;
public class Products_Controller {
    Scanner le = new Scanner(System.in);
    Categoria_Controller cat = new Categoria_Controller();
    public String getNome() {
        return nome;
    }

    public String getValor() {
        return valor;
    }

    private String nome;
    private String valor;
    private List<String> valores = new ArrayList<String>();
    private List<String> nomes = new ArrayList<String>();

    Main main = new Main();
    public List<String> getValores() {
        return valores;
    }

    public List<String> getNomes() {
        return nomes;
    }


    Tst tst = new Tst();


    List<String> tmp = new ArrayList<String>();

    Product cad = new Product(nome, valor);

    void criar_produto() throws IOException {
        tmp.clear();
        int op ;
        cat.escolherCategoria(tmp);
        op = le.nextInt();
        le.nextLine();
        System.out.println(tmp.get(op));
        File categoria = new File("C:\\Users\\Fifo\\Desktop\\area\\Projetos\\JAVA\\Categorias\\" + tmp.get(op) +".txt");
        FileWriter fw = new FileWriter(categoria, true);
        PrintWriter bw2 = new PrintWriter(fw);
        System.out.println("Deseja cadastrar mais de um produto ? [1]Sim [2]Nao");
        op = le.nextInt();
        le.nextLine();

        if(op == 2){
            System.out.print("Insira o nome do produto:");
            nome = le.nextLine();
            System.out.print("Insira o valor do produto:");
            valor = le.nextLine();
            cad.setNome(nome);
            cad.setValor(valor);
            System.out.println(getNome());
            System.out.println(getValor());
            try {

                if(categoria.exists()){
                    bw2.println(nome);
                    bw2.println(valor);
                    bw2.flush();
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
            main.menu_produto();

        }else{
            while (true){
                System.out.print("Insira o nome do produto:");
                nome = le.nextLine();
                System.out.print("Insira o valor do produto:");
                valor = le.nextLine();
                cad.setNome(nome);
                cad.setValor(valor);
                try {

                    if(categoria.exists()){
                        bw2.println(nome);
                        bw2.println(valor);
                        bw2.flush();
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                System.out.println("Deseja continuar ? ");
                op = le.nextInt();;
                le.nextLine();
                if(op == 2){

                    main.menu_produto();
                    break;
                }
                pular_linha();
            }
        }

    }
    void pular_linha(){
        System.out.printf("\n\n\n\n\n");
    }
}
