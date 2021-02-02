package observer;
import competition.*;
import observer.*;

public class JournalistCompetition implements CompetitionListener {

	/**
   	 * Announces the start of a competition
   	 */
	public void annonceCompetition(CompetitionEvent event) {
		Competition competition = (Competition) event.getSource();
		System.out.println("");
		System.out.println("Bienvenus dans cette Compétition qui va vous propeser des très belles affiches opposant "+competition.getCompetitors().size()+" grands Compétiteurs !");
	}

	/**
   	 * Announces the end of a competition
   	 */
	public void reactEnd(CompetitionEvent event) {
		Competition competition = (Competition) event.getSource();
		System.out.println("");
		System.out.println("Fin de la competiton!");
		System.out.println("");
		System.out.println("Voici le classement final :");
		System.out.println("");
		competition.ranking();
		System.out.println("");
		System.out.println("Le grand gagnant de cette édition est : "+competition.winner().getName()+" !!!");
		System.out.println("");
		System.out.println("Merci d'avoir été avec nous et à très bientôt pour une nouvelle édition!");
	}
}
