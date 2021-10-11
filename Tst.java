import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
public class Tst {
    static Products_Controller cad = new Products_Controller();
    static Categoria_Controller cat = new Categoria_Controller();
    Scanner le = new Scanner(System.in);
    String nome;
    String valor;
    boolean control = false;
    double vl;
    Main main = new Main();

    List<String> list1 = new ArrayList<String>();
    List<String> list2 = new ArrayList<String>();
    public List<String> getList1() {
        return list1;
    }

    public void setList1(List<String> list1) {
        this.list1 = list1;
    }

    public List<String> getList2() {
        return list2;
    }

    public void setList2(List<String> list2) {
        this.list2 = list2;
    }

    void mostra_estoque() throws IOException{
        list1.clear();
        cat.escolherCategoria(list1);
        System.out.println("Escolha a categoria que voce deseja ver os produtos");
        int op = le.nextInt();
        le.nextLine();
        nome = list1.get(op);
        File categoria = new File("C:\\Users\\Fifo\\Desktop\\area\\Projetos\\JAVA\\Categorias\\" + nome+".txt");
        FileInputStream fr = new FileInputStream(categoria);
        BufferedReader br = new BufferedReader(new InputStreamReader(fr));
        fr.getChannel().position(0);
        br = new BufferedReader(new InputStreamReader(fr));
        try {
            if(categoria.exists()){
                while (br.ready()){
                    String l = br.readLine();
                    Double i = Double.parseDouble(br.readLine());
                    System.out.println("||  Nome : " + l + "    Com Valor de : R$ " + i + " ||");
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.printf("Pressione Enter para voltar\n");
        String tp = le.nextLine();
        main.menu_produto();
    }
    void excluir_estoque() throws IOException {
        list1.clear();
        int op;
        System.out.println("Selecione a categoria do produto");
        cat.escolherCategoria(list1);
        op = le.nextInt();
        le.nextLine();
        nome = list1.get(op);
        File categoria = new File("C:\\Users\\Fifo\\Desktop\\area\\Projetos\\JAVA\\Categorias\\" + nome + ".txt");
        FileInputStream fr = new FileInputStream(categoria);
        BufferedReader br = new BufferedReader(new InputStreamReader(fr));
        System.out.println("Escolha o produto a ser removido");
        int escolha;
        int index = 1;
        try {
            if (categoria.exists()) {
                while (br.ready()) {
                    String l = br.readLine();
                    String i = br.readLine();
                    System.out.println(  index + " ||  Nome : " + l + "    Com Valor de : R$ " + i + " ||");
                    list2.add(l);
                    list2.add(i);
                    index++;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        fr.getChannel().position(0);
        br = new BufferedReader(new InputStreamReader(fr));
        escolha = le.nextInt();
        le.nextLine();
        if(escolha != 1 && escolha % 2 == 0){
            escolha++;
        }
        list2.remove(escolha);
        list2.remove(escolha-1);
        escreveinCategoria(categoria, list2);
    }
    void escreveinCategoria(File categoria, List<String> lista) throws IOException {
        FileWriter fw = new FileWriter(categoria);
        BufferedWriter bw2 = new BufferedWriter(fw);
        for(int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
            bw2.write(lista.get(i));
            bw2.newLine();
            bw2.flush();
        }
        bw2.close();
        fw.close();
    }
}
