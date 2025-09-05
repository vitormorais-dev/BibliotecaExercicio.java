import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    public List<Livro> livros = new ArrayList<>();
    public List<Usuario> usuarios = new ArrayList<>();

    public void addLivro(Livro l) {
        livros.add(l);
    }

    public void addUsuario(Usuario u) {
        usuarios.add(u);
    }

    public void mostrarLivros() {
        System.out.println("Livros");
        for (int i = 0; i < livros.size(); i++) {
            Livro l = livros.get(i);
            System.out.println((i + 1) + ": " + l.titulo + " Disponivel: " + l.qtdDisponivel);
        }
    }

    public void mostrarUsuarios() {
        System.out.println("Usuarios");
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            System.out.println((i + 1) + ": " + u.nomePessoa + "  ID: " + u.idPessoa);
        }
    }
}