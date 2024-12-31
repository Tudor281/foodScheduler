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

    public static void main(String[] args) {
        logger.info("Starting");

        // 2025
        Schedule schedule = new Schedule(new int[]{4, 4, 5, 4, 4, 5, 4, 5, 4, 4, 5, 4});

        // ziua mea
        Recipe musacaCuCarne = Recipe.get("Musaca cu carne");
        schedule.add(0, 1, musacaCuCarne);

        // pastele
        Recipe cozonac = Recipe.get("Cozonac");
        schedule.add(3, 2, cozonac);

        // ziua italiei
        Recipe melanzane = Recipe.get("Melanzane alla parmigiano");
        schedule.add(5, 0, melanzane);

        // ziua USA
        Recipe potatoSalad = Recipe.get("American Potato Salad");
        schedule.add(6, 0, potatoSalad);
        Recipe applePie = Recipe.get("Apple Pie");
        schedule.add(6, 0, applePie);

        // ziua frantei
        Recipe gratinBroccoli = Recipe.get("Gratin de cartofi cu broccoli și brânză");
        schedule.add(6, 1, gratinBroccoli);

        // ziua egiptului
        Recipe humus = Recipe.get("Humus");
        schedule.add(6, 2, humus);

        // ziua ungariei
        Recipe gulas = Recipe.get("Gulaș");
        schedule.add(7, 2, gulas);

        // ziua spaniei
        Recipe paella = Recipe.get("Pilaf - Paella cu pui");
        schedule.add(9, 1, paella);

        // ziua turciei
        Recipe sarmale = Recipe.get("Pilaf - Sarmale viță de vie cu carne");
        schedule.add(9,3, sarmale);

        // ziua finlandei
        Recipe nakki = Recipe.get("Nakkikeitto - V");
        schedule.add(11, 0, nakki);

        // craciun ? il fac mereu cu familia, nu prea are sens
        Recipe racitura = Recipe.get("Răcitură");
        schedule.add(11, 2, racitura);

        logger.info("Schedule: ");
        logger.info(schedule.toString());
    }
}
