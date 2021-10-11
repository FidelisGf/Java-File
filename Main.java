import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Tst tt = new Tst();
    static Products_Controller action = new Products_Controller();
    static  Categoria_Controller cat = new Categoria_Controller();
    public static void main(String[] args) throws IOException {
        menu_categoria();
        //menu_produto();
    }
    public static void menu_produto() throws IOException {
        System.out.printf("\n\n");
        Scanner lendo = new Scanner(System.in);
        System.out.printf("----------------------------------------------------\n");
        System.out.printf("|              MENU PRODUTOS                       |\n\n");
        System.out.printf("|(1)  [ Cadastrar Novo(s) Produto(s) no estoque ]  |\n\n");
        System.out.printf("|(2)  [ Ver produtos em estoque ]                  |\n\n");
        System.out.printf("|(3)  [ Excluir um produto do estoque ]            |\n\n");
        System.out.printf("|(4)  [ Voltar ao menu Categoria ]                 |\n\n");
        System.out.printf("|(5)  [ Sair ]                                     |\n");
        System.out.printf("----------------------------------------------------\n");
        int op = lendo.nextInt();
        lendo.nextLine();
        System.out.printf("\n\n");
        switch (op){
            case 1:
                action.criar_produto();
                break;
            case 2:
                tt.mostra_estoque();
                break;
            case 3:
                tt.excluir_estoque();
                break;
            case 4:
                menu_categoria();
                break;
        }
    }
    public static void menu_categoria() throws IOException {
        System.out.printf("\n\n");
        Scanner lendo = new Scanner(System.in);
        System.out.printf("              Menu Categorias\n\n");
        System.out.printf(" (1)  [ Cadastrar Novo(s) Categoria(s) ]\n\n");
        System.out.printf(" (2)  [ Ver Categorias ]\n\n");
        System.out.printf(" (3)  [ Excluir uma Categoria ]\n\n");
        System.out.printf(" (4)  [ Ir para o menu de produtos ]\n\n");
        System.out.printf(" (5)  [ Sair ]\n");
        int op = lendo.nextInt();
        lendo.nextLine();
        System.out.printf("\n\n");
        switch (op){
            case 1:
                cat.cadastraCategoria();
                break;
            case 2:
                cat.listarCategorias();
                break;
            case 3:
                cat.excluirCategoria();
                break;
            case 4:
                menu_produto();
                break;
            case 5:
                break;
        }
    }

}
