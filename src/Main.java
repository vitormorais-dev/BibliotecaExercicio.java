import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        //Aqui faremos o cadastro dos livros
        System.out.print("Quantos livros deseja cadastrar? ");
        int nLivros = sc.nextInt();
        sc.nextLine(); // limpar buffer
        for (int i = 0; i < nLivros; i++) {
            Livro livro = new Livro();
            System.out.println("\nCadastro do livro " + (i + 1));
            System.out.print("Codigo: ");
            livro.codigo = sc.nextInt();
            sc.nextLine();
            System.out.print("Titulo: ");
            livro.titulo = sc.nextLine();
            System.out.print("Autor: ");
            livro.autor = sc.nextLine();
            System.out.print("Quantidade disponível: ");
            livro.qtdDisponivel = sc.nextInt();
            sc.nextLine();

            biblioteca.addLivro(livro);
        }
        //Aqui de forma semelhante, faremos o cadastro de usuarios
        System.out.print("\nQuantos usuários deseja cadastrar? ");
        int nUsuarios = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < nUsuarios; i++) {
            Usuario usuario = new Usuario();
            System.out.println("\nCadastro do usuário " + (i + 1));
            System.out.print("ID: ");
            usuario.idPessoa = sc.nextInt();
            sc.nextLine();
            System.out.print("Nome: ");
            usuario.nomePessoa = sc.nextLine();

            biblioteca.addUsuario(usuario);
        }

        biblioteca.mostrarLivros();
        biblioteca.mostrarUsuarios();

        //emprestimo de livros
        System.out.print("\nDigite o ID do usuario que vai pegar um livro: ");
        int idUsuario = sc.nextInt();
        sc.nextLine();
        Usuario usuarioSelecionado = null;
        for (Usuario u : biblioteca.usuarios) {
            if (u.idPessoa == idUsuario) {
                usuarioSelecionado = u;
                break;
            }
        }
        if (usuarioSelecionado == null) {
            System.out.println("Usuario não cadastrado!");
            sc.close();
            return;
        }

        System.out.print("Digite o codigo do livro que vai ser emprestado: ");
        int codLivro = sc.nextInt();
        sc.nextLine();
        Livro livroSelecionado = null;
        for (Livro l : biblioteca.livros) {
            if (l.codigo == codLivro) {
                livroSelecionado = l;
                break;
            }
        }
        if (livroSelecionado == null) {
            System.out.println("Livro não foi encontrado!");
            sc.close();
            return;
        }
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.usuario = usuarioSelecionado;
        emprestimo.livro = livroSelecionado;
        emprestimo.emprestar();
        //Sobre a devolucao
        System.out.print("\nDeseja devolver o livro? (s/n): ");
        String opc = sc.nextLine();
        if (opc.equalsIgnoreCase("s")) {
            emprestimo.devolver();
        }

        sc.close();
    }
}
