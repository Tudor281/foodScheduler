package tudor.foodScheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tudor.foodScheduler.model.Recipe;
import tudor.foodScheduler.model.Schedule;

/**
 * Hello world!
 */
public class InitialRun {
    private static final Logger logger = LoggerFactory.getLogger(InitialRun.class);

    public static void main(String[] args) throws Exception {
        logger.info("Starting");

        // 2025
        Schedule schedule = new Schedule(new int[]{4, 4, 5, 4, 4, 5, 4, 5, 4, 4, 5, 4});

        addConstraints(schedule);

        new AtLeastOnceScheduler().addAtLeastOnceRecipes(schedule);

        logger.info("Schedule: ");
        logger.info(schedule.toString());
    }

    private static void addConstraints(Schedule schedule) {
        // ziua mea
        Recipe musacaCuCarne = Recipe.get("Musaca cu carne");
        schedule.add(1, 2, musacaCuCarne);

        // pastele
        Recipe cozonac = Recipe.get("Cozonac");
        schedule.add(4, 3, cozonac);

        // ziua italiei
        Recipe melanzane = Recipe.get("Melanzane alla parmigiano");
        schedule.add(6, 1, melanzane);

        // ziua USA
        Recipe potatoSalad = Recipe.get("American Potato Salad");
        schedule.add(7, 1, potatoSalad);
        Recipe applePie = Recipe.get("Apple Pie");
        schedule.add(7, 1, applePie);

        // ziua frantei
        Recipe gratinBroccoli = Recipe.get("Gratin de cartofi cu broccoli și brânză");
        schedule.add(7, 2, gratinBroccoli);

        // ziua egiptului
        Recipe humus = Recipe.get("Humus");
        schedule.add(7, 3, humus);

        // ziua ungariei
        Recipe gulas = Recipe.get("Gulaș");
        schedule.add(8, 3, gulas);

        // ziua spaniei
        Recipe paella = Recipe.get("Pilaf - Paella cu pui");
        schedule.add(10, 2, paella);

        // ziua turciei
        Recipe sarmale = Recipe.get("Pilaf - Sarmale viță de vie cu carne");
        schedule.add(10,4, sarmale);

        // ziua finlandei
        Recipe nakki = Recipe.get("Nakkikeitto - V");
        schedule.add(12, 1, nakki);

        // craciun ? il fac mereu cu familia, nu prea are sens
        Recipe racitura = Recipe.get("Răcitură");
        schedule.add(12, 3, racitura);
    }
}
