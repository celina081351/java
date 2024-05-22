import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class JeuDeQuestions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Liste des questions et réponses
        List<QuestionReponse> questionsReponses = new ArrayList<>();
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région des Lagunes ?", "Abidjan"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Haut-Sassandra ?", "Daloa"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région des Savanes ?", "Korhogo"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Sud-Comoé ?", "Aboisso"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région de la Vallée du Bandama ?", "Bouaké"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région de la Nawa ?", "Soubré"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Gbêkê ?", "Bouaké"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Guémon ?", "Duékoué"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Poro ?", "Korhogo"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Bélier ?", "Yamoussoukro"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Tonkpi ?", "Man"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Lôh-Djiboua ?", "Divo"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Moronou ?", "Bongouanou"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Hambol ?", "Katiola"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Gôh ?", "Gagnoa"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Bafing ?", "Touba"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Béré ?", "Mankono"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Folon ?", "Minignan"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Kabadougou ?", "Odienné"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du N'Zi ?", "Dimbokro"));
        // Nouvelles questions
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Cavally ?", "Guiglo"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région de l'Iffou ?", "Daoukro"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Bounkani ?", "Bouna"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Gontougo ?", "Bondoukou"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Indénié-Djuablin ?", "Abengourou"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Lôh-Djiboua ?", "Divo"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Mé ?", "Adzopé"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du San Pedro ?", "San Pedro"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Sud-Bandama ?", "Lakota"));
        questionsReponses.add(new QuestionReponse("Quel est le chef-lieu de la région du Worodougou ?", "Séguéla"));

        int meilleurScore = 0;
        String meilleurJoueur = "";

        boolean rejouer;
        do {
            // Mélange les questions pour chaque session
            Collections.shuffle(questionsReponses);

            System.out.print("Entrez votre pseudo: ");
            String pseudo = scanner.nextLine();

            int score = 0;
            long startTime = System.currentTimeMillis();

            // Limite à 10 questions pour chaque session
            for (int i = 0; i < 10; i++) {
                QuestionReponse qr = questionsReponses.get(i);
                System.out.println("Question " + (i + 1) + ": " + qr.getQuestion());
                String reponse = scanner.nextLine();

                if (reponse.equalsIgnoreCase(qr.getReponse())) {
                    System.out.println("Bravo !");
                    score++;
                } else {
                    System.out.println("Faux ! La bonne réponse est " + qr.getReponse());
                }
            }

            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
            long seconds = TimeUnit.MILLISECONDS.toSeconds(duration) - TimeUnit.MINUTES.toSeconds(minutes);

            System.out.println("Fin du jeu, " + pseudo + " !");
            System.out.println("Votre score est de : " + score + " / 10");
            System.out.println("Temps total : " + minutes + " minutes et " + seconds + " secondes.");

            if (score > meilleurScore) {
                meilleurScore = score;
                meilleurJoueur = pseudo;
                System.out.println("Nouveau meilleur score !");
            }

            System.out.println("Le meilleur score actuel est de : " + meilleurScore + " par " + meilleurJoueur);

            System.out.print("Voulez-vous rejouer ? (oui/non): ");
            String reponseRejouer = scanner.nextLine();
            rejouer = reponseRejouer.equalsIgnoreCase("oui");

        } while (rejouer);

        System.out.println("Merci d'avoir joué !");
        scanner.close();
    }
}
