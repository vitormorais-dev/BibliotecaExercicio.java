public class Emprestimo {
    public Livro livro;
    public Usuario usuario;
    public boolean ativo = false;

    public void emprestar() {
        System.out.println("Status antes do emprestimo: " + livro.titulo + "  Disponivel: " + livro.qtdDisponivel);
        if (livro.qtdDisponivel > 0) {
            livro.qtdDisponivel--;
            ativo = true;
            System.out.println("Emprestimo realizado para: " + usuario.nomePessoa + " pegou emprestado o livro: " + livro.titulo
            );
        } else {
            System.out.println("Livro indisponível para emprestimo.");
        }
        System.out.println("Status depois do empréstimo: " + livro.titulo + "   Disponivel: " + livro.qtdDisponivel);
    }

    public void devolver() {
        if (ativo) {
            livro.qtdDisponivel++;
            ativo = false;
            System.out.println("Livro devolvido: " + livro.titulo + " por " + usuario.nomePessoa);
            System.out.println("Status depois da devolução: " + livro.titulo + "  Disponivel: " + livro.qtdDisponivel);
        } else {
            System.out.println("Emprestimo ainda não realizado.");
        }
    }
}

