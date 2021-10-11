import java.util.*;
import java.io.*;
public class Categoria_Controller {
    String nome;
    boolean control = false;
    Main main = new Main();
    Scanner le = new Scanner(System.in);
    public List<String> getTmp() {
        return tmp;
    }
    File slvcat = new File("C:\\Users\\Fifo\\Desktop\\area\\Projetos\\JAVA\\Categorias\\listaCategorias.txt");
    List<String> tmp = new ArrayList<String>();
    void cadastraCategoria() throws IOException{
        tmp.clear();//limpa lista.
        System.out.println("Insira o nome da Nova categoria");
        nome = le.nextLine();
        tmp.add(nome);
        File categoria = new File("C:\\Users\\Fifo\\Desktop\\area\\Projetos\\JAVA\\Categorias\\" + nome+".txt");
        FileWriter fw = new FileWriter(slvcat, true);
        BufferedWriter bw = new BufferedWriter(fw);

        try {
            if(!categoria.exists()){
                categoria.createNewFile();
            }
            if(!slvcat.exists()){
                slvcat.createNewFile();
            }
            for(int i = 0; i < tmp.size(); i++){
                String tmpe = tmp.get(i);
                bw.write(tmpe);
                bw.newLine();
                bw.flush();
            }
            bw.close();
            fw.close();
            main.menu_categoria();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    void excluirCategoria() throws IOException{
        int i = 0;
        tmp.clear();
        System.out.println("Escolha a Categoria a ser excluida");
        FileInputStream fr = new FileInputStream(slvcat);
        BufferedReader br = new BufferedReader(new InputStreamReader(fr));
        while (br.ready()){
            String linha = br.readLine();
            System.out.println(linha);
            tmp.add(linha);
        }
        int op = le.nextInt();
        le.nextLine();
        fr.getChannel().position(0);
        br = new BufferedReader(new InputStreamReader(fr));
        nome = tmp.get(op);
        File categoria = new File("C:\\Users\\Fifo\\Desktop\\area\\Projetos\\JAVA\\Categorias\\" + nome+".txt");
        try {
            if(categoria.exists()){
                categoria.delete();
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        tmp.remove(op);
        try {
            FileWriter fw = new FileWriter(slvcat);
            PrintWriter bw2 = new PrintWriter(fw);
            while ( i < tmp.size()){
                String tmpe = tmp.get(i);
                bw2.println(tmpe);
                bw2.flush();
                i++;
            }
            br.close();
            fr.close();
            bw2.close();
            fw.close();
            main.menu_categoria();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    void escolherCategoria(List<String> lista) throws IOException{
        int i = 0;
        Scanner lendo = new Scanner(System.in);
        System.out.println("Por Favor, selecione a categoria que deseja cadastrar produtos : ");
        FileInputStream fr = new FileInputStream(slvcat);
        BufferedReader br = new BufferedReader(new InputStreamReader(fr));
        while (br.ready()){
            String linha = br.readLine();
            System.out.println(i + " " + linha);
            lista.add(linha);
            i++;
        }
        br.close();
        fr.close();

    }
    void listarCategorias() throws IOException{
        System.out.println("Categorias disponiveis:");
        int i = 0;
        FileInputStream fr = new FileInputStream(slvcat);
        BufferedReader br = new BufferedReader(new InputStreamReader(fr));
        while (br.ready()){
            String linha = br.readLine();
            System.out.println(linha);
            tmp.add(linha);
        }
        System.out.printf("Pressione ENTER para voltar");
        String temp = le.nextLine();
        System.out.printf("\n\n\n\n\n\n\n\n");
        br.close();
        fr.close();
        main.menu_categoria();
    }

}
