
import repository.LivroRepositoryImplement;
import views.TelaPrincipal;

public class Main {
    public static void main(String[] args) {
        try {
        TelaPrincipal window = new TelaPrincipal();
        window.frame.setVisible(true);

        LivroRepositoryImplement repository = new LivroRepositoryImplement();
        repository.testConnection();

        } catch (Exception e) {
        e.printStackTrace();
    }
    }
}