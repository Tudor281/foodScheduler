package tudor.foodScheduler;

import tudor.foodScheduler.model.Recipe;
import tudor.foodScheduler.model.schedule.Schedule;
import tudor.foodScheduler.model.schedule.SchedulingException;
import tudor.foodScheduler.utils.Stats;

import java.util.Random;

/**
 * Hello world!
 */
public class InitialRun {
    public static Random random;
    static {
        Random random1 = new Random();
        long seed = -3641413982555598708L;
//        long seed = random1.nextLong();
        System.out.println("Seed: "+seed);
        random = new Random(seed);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Starting...");

        // 2025
        Schedule template = new Schedule(new int[]{4, 4, 5, 4, 4, 5, 4, 5, 4, 4, 5, 4});

        addConstraints(template);

        completeRecipe(template);
    }

    public static void completeRecipe(Schedule template) throws Exception {
        Scheduler scheduler = new Scheduler();

        Schedule bestSchedule = template.copy();
        scheduler.addAtLeastOnceRecipes(bestSchedule);
        scheduler.fillInOtherRecipes(bestSchedule);
        double bestScore = bestSchedule.getScore();
        System.out.println("Score before optimization: "+bestScore);
        System.out.println(bestSchedule);
        bestSchedule = bestSchedule.optimize();

//        for (int i=0; i<100; i++) {
//            Schedule candidate = template.copy();
//            scheduler.addAtLeastOnceRecipes(candidate);
//            scheduler.fillInOtherRecipes(candidate);
//            candidate.optimize();
//            try {
//                scheduler.eliminateDuplicates(candidate);
//            } catch (SchedulingException ignored) {
//                Stats.countOptimalInsertFailure();
//            }
//            catch (Exception e) {
//                logger.error("Failure", e);
//                Stats.countOptimalInsertFailure();
//            }
//
//            double candidateScore = candidate.getScore();
//            if (candidateScore > bestScore) {
//                bestScore = candidateScore;
//                bestSchedule = candidate;
//            }
//
//            if (i % 1000 == 0) {
//                System.out.println(i + "\t"+bestScore);
//            }
//        }

        Stats.report();

        bestScore = bestSchedule.getScore();
        System.out.println("Best score: "+bestScore);
        System.out.println("Schedule: ");
        System.out.println(bestSchedule);
    }

    public static void addConstraints(Schedule schedule) {
        // ziua mea
//        Recipe musacaCuCarne = Recipe.get("Musaca cu carne");
//        schedule.add(1, 2, musacaCuCarne, true);
//        Recipe supaRosii = Recipe.get("Supă de roșii"); // sinergie apio
//        schedule.add(1, 2, supaRosii, true);
        Recipe nakkikeito = Recipe.get("Nakkikeitto");
        schedule.add(1, 2, nakkikeito, true);
        schedule.addComment(1, 2, "Ziua mea");

        // ziua Greciei
        Recipe ciorbaGrec = Recipe.get("Ciorbă de pui a la Grec");
        schedule.add(3,4, ciorbaGrec, true);
        Recipe gigantesPlaki = Recipe.get("Gigantes Plaki");
        schedule.add(3, 4, gigantesPlaki, true);
        Recipe tzatziki = Recipe.get("Tzatziki");
        schedule.add(3, 4, tzatziki, true);
        schedule.addComment(3, 4, "Ziua Greciei");

        // pastele
//        Recipe cozonac = Recipe.get("Cozonac");
//        schedule.add(4, 3, cozonac, true);
        schedule.addComment(4, 3, "Paștele");

        // ziua italiei
        Recipe melanzane = Recipe.get("Melanzane alla parmigiano");
        schedule.add(6, 1, melanzane, true);
        schedule.addComment(6, 1, "Ziua Italiei");

        // ziua USA
        Recipe potatoSalad = Recipe.get("American Potato Salad");
        schedule.add(7, 1, potatoSalad, true);
        Recipe applePie = Recipe.get("Apple Pie");
        schedule.add(7, 1, applePie, true);
        schedule.addComment(7, 1, "Ziua USA");

        // ziua frantei
        Recipe gratinBroccoli = Recipe.get("Gratin de cartofi cu broccoli și brânză");
        schedule.add(7, 2, gratinBroccoli, true);
        schedule.addComment(7, 2, "Ziua Franței");

        // ziua egiptului
        Recipe humus = Recipe.get("Humus");
        schedule.add(7, 3, humus, true);
        schedule.addComment(7, 3, "Ziua Egiptului");

        // ziua ungariei
        Recipe gulas = Recipe.get("Gulaș");
        schedule.add(8, 3, gulas, true);
        schedule.addComment(8,3,"Ziua Ungariei");

        // ziua spaniei
        Recipe paella = Recipe.get("Pilaf - Paella cu pui");
        schedule.add(10, 2, paella, true);
        schedule.addComment(10, 2, "Ziua Spaniei");

        // ziua turciei
        Recipe sarmale = Recipe.get("Pilaf - Sarmale viță de vie cu carne");
        schedule.add(10,4, sarmale, true);
        schedule.addComment(10, 4, "Ziua Turciei");

        // ziua finlandei
        Recipe nakki = Recipe.get("Nakkikeitto - V");
        schedule.add(12, 1, nakki, true);
        schedule.addComment(12, 1,"Ziua Finlandei");

        // craciun ? il fac mereu cu familia, nu prea are sens. Dar răcitura ar trebui să țină mult și bine?
        Recipe racitura = Recipe.get("Răcitură");
        schedule.add(12, 3, racitura, true);
        schedule.addComment(12, 3, "Crăciunul");

        Recipe fasoleChimen = Recipe.get("Ciorbă de fasole - Cu chimen");
        schedule.add(12, 4, fasoleChimen, true);
        schedule.addComment(12, 4, "Anul nou");
    }
}
