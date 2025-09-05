public class Livro {
    public String autor;
    public String titulo;
    public int codigo;
    public int qtdDisponivel;

    void mostrarStatus(){
        System.out.println("Livro :"+ titulo + " | Autor :" + autor + "| disponivel: " + qtdDisponivel);
    }
}