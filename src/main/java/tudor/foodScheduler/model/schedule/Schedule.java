package tudor.foodScheduler.model.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tudor.foodScheduler.utils.Counter;
import tudor.foodScheduler.utils.Stats;
import tudor.foodScheduler.model.*;

import java.util.*;

@SuppressWarnings("StringConcatenationInLoop")
public class Schedule {
    private static final Logger logger = LoggerFactory.getLogger(Schedule.class);

    public static final int nrChannels = 5;

    // month -> week -> channel -> Recipe
    // channels: 0 F1, 1 F2, 3, AUX
    Map<Integer, Map<Integer, Map<Integer, ScheduleEntry>>> recipes = new HashMap<>();
    int[] weeksInMonth;
    int numberOfWeeks;
    Map<Integer, Map<Integer, String>> comments = new HashMap<>();

    public Schedule(int[] weeksInMonth) {
        this.weeksInMonth = weeksInMonth;
        calculateNumberOfWeeks();
        for (int month=0; month<12; month++) {
            Map<Integer, Map<Integer, ScheduleEntry>> monthContainer = new HashMap<>();
            recipes.put(month, monthContainer);
            Map<Integer, String> commentsContainer = new HashMap<>();
            comments.put(month, commentsContainer);
            for (int week=0; week<weeksInMonth[month]; week++) {
                Map<Integer, ScheduleEntry> weekContainer = new HashMap<>();
                monthContainer.put(week, weekContainer);
                commentsContainer.put(week, "");
            }
        }
    }

    private Schedule(int[] weeksInMonth, Map<Integer, Map<Integer, Map<Integer, ScheduleEntry>>> recipes, Map<Integer, Map<Integer, String>> inputComments) {
        this.weeksInMonth = weeksInMonth;
        calculateNumberOfWeeks();
        for (int month=0; month<12; month++) {
            Map<Integer, Map<Integer, ScheduleEntry>> monthContainer = new HashMap<>();
            this.recipes.put(month, monthContainer);
            Map<Integer, String> commentsContainer = new HashMap<>();
            comments.put(month, commentsContainer);
            for (int week=0; week<weeksInMonth[month]; week++) {
                Map<Integer, ScheduleEntry> weekContainer = new HashMap<>();
                monthContainer.put(week, weekContainer);

                Map<Integer, ScheduleEntry> otherWeekContainer = recipes.get(month).get(week);

                weekContainer.putAll(otherWeekContainer);
                for (ScheduleEntry entry : otherWeekContainer.values()) {
                    recipeCounts.count(entry.recipe);
                }

                commentsContainer.put(week, inputComments.get(month).get(week));
            }
        }
    }

    private void calculateNumberOfWeeks() {
        for (int i=0; i<12; i++) {
            numberOfWeeks += weeksInMonth[i];
        }
    }

    /** Real month and week numbers, starting from 1 */
    public void add(int humanMonth, int humanWeek, Recipe recipe, boolean initialConstraint) {
        ScheduleEntry oldEntry = recipes.get(humanMonth-1).get(humanWeek-1).put(recipe.fel.channel, new ScheduleEntry(recipe, initialConstraint));
        recipeCounts.count(recipe);
        if (oldEntry != null) recipeCounts.deCount(recipe);
    }

    public void add(ScheduleSlot slot, Recipe recipe) {
        ScheduleEntry oldEntry = recipes.get(slot.month).get(slot.week).put(recipe.fel.channel, new ScheduleEntry(recipe, false));
        recipeCounts.count(recipe);
        if (oldEntry != null) recipeCounts.deCount(recipe);
    }

    public boolean isRecipePresent(Recipe recipe) {
        return recipeCounts.get(recipe) > 0;
    }

    public String toString() {
        String result = "";
        for (int month=0; month<12; month++) {
            for (int week=0; week<weeksInMonth[month]; week++) {
                result += toString(month, week);
            }
        }
        result += countIngredientsAndSpices();
        return result;
    }

    String toString(int month, int week) {
        String result = (month + 1) + "\t" + (week + 1);
        for (int i = 0; i< nrChannels; i++) {
            result += '\t' + getName(month, week, i);
        }
        result += '\t' + buildComments(month, week) + '\n';

        return result;
    }

    public String countIngredientsAndSpices() {
        Counter<Ingredient> ingredientsCount = new Counter<>();
        Counter<Spice> spicesCount = new Counter<>();
        for (int month=0; month<12; month++) {
            for (int week=0; week<weeksInMonth[month]; week++) {
                for (int channel = 0; channel < nrChannels; channel++) {
                    ScheduleEntry entry = recipes.get(month).get(week).get(channel);
                    if (entry == null) continue;
                    for (Ingredient ingredient : entry.recipe.ingredients) {
                        ingredientsCount.count(ingredient);
                    }
                    for (Spice spice : entry.recipe.spices) {
                        spicesCount.count(spice);
                    }
                }
            }
        }

        String result = "\nIngredients:\n";
        for (Map.Entry<Ingredient, Integer> entry : ingredientsCount.getSortedDescending()) {
            result += entry.getKey() + "\t" + entry.getValue() + "\n";
        }
        result += "\nSpices:\n";
        for (Map.Entry<Spice, Integer> entry : spicesCount.getSortedDescending()) {
            result += entry.getKey() + "\t" + entry.getValue() + "\n";
        }
        result += "\n END \n";
        return result;
    }

    String getName(int month, int week, int channel) {
        ScheduleEntry entry = recipes.get(month).get(week).get(channel);
        if (entry == null) return "";
        return entry.recipe.name;
    }

    String buildComments(int month, int week) {
        String comment = comments.get(month).get(week);
        for (int channel = 0; channel < nrChannels; channel++) {
            ScheduleEntry entry = recipes.get(month).get(week).get(channel);
            if (entry == null) continue;
            for (Spice spice : entry.recipe.spices) {
                if (spice.perishable) {
                    if (comment.isBlank()) {
                        comment = spice.toString();
                    } else {
                        comment += ", "+spice;
                    }
                }
            }
        }
        return comment;
    }

    public List<ScheduleSlot> getDomesticSlots(Recipe recipe) {
        return getSlotsForMonths(recipe.getDomesticSlots(), recipe.fel.channel);
    }

    public List<ScheduleSlot> getImportSlots(Recipe recipe) {
        return getSlotsForMonths(recipe.getImportSlots(), recipe.fel.channel);
    }

    private List<ScheduleSlot> getSlotsForMonths(List<Integer> months, int channel) {
        List<ScheduleSlot> slots = new ArrayList<>();

        for (Integer humanMonth : months) {
            int scheduleMonth = humanMonth - 1;
            for (int week = 0; week < weeksInMonth[scheduleMonth]; week++) {
                if (recipes.get(scheduleMonth).get(week).get(channel) == null) {
                    slots.add(new ScheduleSlot(scheduleMonth, week));
                }
            }
        }

        return slots;
    }

    public boolean hasFreeSlots() {
        for (int month=0; month<12; month++) {
            for (int week=0; week<weeksInMonth[month]; week++) {
                if (recipes.get(month).get(week).get(0) == null) return true;
                if (recipes.get(month).get(week).get(1) == null) return true;
                if (recipes.get(month).get(week).get(2) == null) return true;
                if (recipes.get(month).get(week).get(3) == null) return true;
            }
        }
        return false;
    }

    /** The higher the score, the greater the distance between various ingredients */
    public double getScore() {
        double ingredientSum = 0;
        double minIngredientScore = Integer.MAX_VALUE;
        List<Ingredient> minIngredientsList = new ArrayList<>();
        Set<Ingredient> akas = new HashSet<>();
        for (Ingredient ingredient : Ingredient.values()) {
            if (akas.contains(ingredient) || !ingredient.score) continue;
            akas.addAll(ingredient.akas);
            List<ScheduleSlot> slots = getSlots(ingredient);
            double score = ScheduleSlot.computeDistanceHybrid(slots, weeksInMonth);
            if (score < minIngredientScore) {
                minIngredientScore = score;
                minIngredientsList.clear();
                minIngredientsList.add(ingredient);
            } else if (score == minIngredientScore) {
                minIngredientsList.add(ingredient);
            }
            ingredientSum += score;
        }

        for (Ingredient ingredient : minIngredientsList) {
            Stats.addMinScoreIngredient(ingredient);
        }

        double spiceSum = 0;
        for (Spice spice : Spice.values()) {
            if (spice.perishable) continue;
            List<ScheduleSlot> slots = getSlots(spice);
            spiceSum += ScheduleSlot.computeDistanceHybrid(slots, weeksInMonth);
        }
        double avgIngredients = ingredientSum / Ingredient.values().length;
        double avgSpices = spiceSum / Spice.values().length;
//        logger.info("MinDupliates {} \t avgIngredients {} \t avgSpices {} \t", minIngredientDuplicates, avgIngredients, avgSpices);
        return 2 * avgIngredients + avgSpices;
    }

    List<ScheduleSlot> getSlots(Ingredient ingredient) {
        List<Ingredient> pool = new ArrayList<>();
        pool.add(ingredient);
        pool.addAll(ingredient.akas);
        List<ScheduleSlot> slots = new ArrayList<>();
        for (int month=0; month<12; month++) {
            for (int week = 0; week < weeksInMonth[month]; week++) {
                Map<Integer, ScheduleEntry> channelsContainer = recipes.get(month).get(week);
                if (channelsContainer == null) throw new RuntimeException("Schedule is not filled");

                for (ScheduleEntry entry : channelsContainer.values()) {
                    if (entry == null) continue;
                    for (Ingredient pooledIngredient : pool) {
                        if (entry.recipe.ingredients.contains(pooledIngredient)) {
                            slots.add(new ScheduleSlot(month, week));
                        }
                    }
                }
            }
        }
        return slots;
    }

    List<ScheduleSlot> getSlots(Spice spice) {
        List<ScheduleSlot> slots = new ArrayList<>();
        for (int month=0; month<12; month++) {
            for (int week = 0; week < weeksInMonth[month]; week++) {
                Map<Integer, ScheduleEntry> channelsContainer = recipes.get(month).get(week);
                if (channelsContainer == null) throw new RuntimeException("Schedule is not filled");

                for (ScheduleEntry entry : channelsContainer.values()) {
                    if (entry == null) continue;
                    if (entry.recipe.spices.contains(spice)) {
                        slots.add(new ScheduleSlot(month, week));
                    }
                }
            }
        }
        return slots;
    }

    public Schedule copy() {
        return new Schedule(weeksInMonth, recipes, comments);
    }

    public Counter<Recipe> recipeCounts = new Counter<>();
    public void countRecipes() {
        recipeCounts.clear();
        for (int month=0; month<12; month++) {
            for (int week = 0; week < weeksInMonth[month]; week++) {
                for (int channel = 0; channel < nrChannels; channel ++) {
                    ScheduleEntry entry = recipes.get(month).get(week).get(channel);
                    if (entry == null) continue; // especially channel 3 recipes are optional
                    recipeCounts.count(entry.recipe);
                }
            }
        }
    }

    public Duplication getIngredientDuplicate() {
        int prevMonth = 11;
        int prevWeek = weeksInMonth[11]-1;
        Map<Integer, ScheduleEntry> prevRow = recipes.get(prevMonth).get(prevWeek); // december 31st
        for (int month=0; month<12; month++) {
            for (int week = 0; week < weeksInMonth[month]; week++) {
                for (int channel = 0; channel < nrChannels; channel++) {
                    ScheduleEntry prevEntry = prevRow.get(channel);
                    ScheduleEntry entry = recipes.get(month).get(week).get(channel);
                    if (prevEntry == null || entry == null) continue; // we could have empty slots, especially on channel 3
                    if (prevEntry.recipe.hasIngredientsInCommon(entry.recipe) && !(prevEntry.initialConstraint && entry.initialConstraint)) {
                        return new Duplication(
                                new ScheduleSlot(prevMonth, prevWeek, hasConstraints(prevEntry)),
                                prevEntry.recipe,
                                new ScheduleSlot(month, week, hasConstraints(entry)),
                                entry.recipe);
                    }
                }
                prevMonth = month;
                prevWeek = week;
                prevRow = recipes.get(month).get(week);
            }
        }
        return null;
    }

    boolean hasConstraints(ScheduleEntry entry) {
        if (entry.initialConstraint) {
//            logger.debug("{} is initial constraint", entry.recipe);
            return true;
        }

        Recipe recipe = entry.recipe;

        if (recipe.multiplicity == Multiplicity.AtLeastOnce && recipeCounts.get(recipe) < 2) {
//            logger.debug("{} at least once and exists", recipe);
            return true;
        }

        //noinspection RedundantIfStatement
        if (recipe.multiplicity == Multiplicity.Once) {
//            logger.debug("{} is at least once", recipe);
            return true;
        }

        return false;
    }

    public List<Recipe> getSuitableReplacements(ScheduleSlot slot, Recipe recipe) {
        int greatestDistance = Integer.MIN_VALUE;
        List<Recipe> bestRecipes = new ArrayList<>();
        for (Recipe candidate : Recipe.all.values()) {
            if (candidate.fel != recipe.fel) continue;

            if (!canAdd(candidate)) continue;

            if (!candidate.isInSeason(slot.getHumanMonth())) continue;

            int distance = getDistance(slot, candidate.ingredients, recipe.fel.channel, null);
            if (distance>greatestDistance) {
                greatestDistance = distance;
                bestRecipes.clear();
                bestRecipes.add(candidate);
            } else if (distance == greatestDistance) {
                bestRecipes.add(candidate);
            }
        }
        return bestRecipes;
    }

    private boolean canAdd(Recipe recipe) {
        switch (recipe.multiplicity) {
            case AtLeastOnce -> {
                if (recipe.limit != null && recipe.limit >= recipeCounts.get(recipe)) return false;
                //noinspection RedundantIfStatement
                if (recipeCounts.get(recipe) >= recipe.fel.cap) return false;
                return true;
            }
            case AtMostOnce, Once -> {
                return recipeCounts.get(recipe) == 0;
            }
            case Disabled -> {
                return false;
            }
            case Optional -> {
                return true;
            }
        }
        throw new RuntimeException("Stupid java");
    }

    /** Exception is used for permutation, not to compare with the origin slot */
    int getDistance(ScheduleSlot slot, List<Ingredient> ingredients, int channel, ScheduleSlot exception) {
        List<Ingredient> akaPool = new ArrayList<>(ingredients);
        for (Ingredient ingredient : ingredients) {
            akaPool.addAll(ingredient.akas);
        }
        ScheduleSlot forwardIterator = slot.copy();
        ScheduleSlot backwardIterator = slot.copy();
        int counter = 0;
        do {
            forwardIterator.increment(weeksInMonth);
            if (hasCommonIngredients(forwardIterator, akaPool, channel, exception)) return counter;
            backwardIterator.decrement(weeksInMonth);
            if (hasCommonIngredients(backwardIterator, akaPool, channel, exception)) return counter;

            counter++;
        } while (counter<numberOfWeeks);
        return counter;
    }

    boolean hasCommonIngredients(ScheduleSlot slot, List<Ingredient> ingredients, int channel, ScheduleSlot exception) {
        if (exception != null && slot.month == exception.month && slot.week == exception.week) return false;

        ScheduleEntry entry = recipes.get(slot.month).get(slot.week).get(channel);
        if (entry == null) return false;
        for (Ingredient ingredient : ingredients) {
            if (entry.recipe.ingredients.contains(ingredient)) return true;
        }
        return false;
    }

    public boolean reachedLimit(Recipe recipe) {
        int count = recipeCounts.get(recipe);
        return recipe.multiplicity == Multiplicity.AtLeastOnce && ((recipe.limit != null && recipe.limit >= count) || count >= recipe.fel.cap);
    }

    public void optimize() {
        for (int iteration = 0; iteration < 10; iteration ++) {
            boolean madeASwap = false;

            for (int month = 0; month < 12; month++) {
                for (int week = 0; week < weeksInMonth[month]; week++) {
                    for (int channel = 0; channel < nrChannels; channel++) {
                        // calculate current distance score
                        ScheduleEntry entry = recipes.get(month).get(week).get(channel);
                        if (entry == null || entry.initialConstraint) continue;

                        Recipe recipe = entry.recipe;
                        ScheduleSlot currentSlot = new ScheduleSlot(month, week);
                        int currentDistance = getDistance(currentSlot, recipe.ingredients, channel, null);
                        if (currentDistance > 3) continue;
                        int bestCandidateDistance = 0;
                        ScheduleSlot bestSwap = null;
                        // find best possible slot
                        for (int candidateMonth = 0; candidateMonth < 12; candidateMonth++) {
                            for (int candidateWeek = 0; candidateWeek < weeksInMonth[candidateMonth]; candidateWeek++) {
                                if (!recipe.isInSeason(candidateMonth+1)) continue;

                                ScheduleSlot candidateSlot = new ScheduleSlot(candidateMonth, candidateWeek);
                                int targetDistance = getDistance(candidateSlot, recipe.ingredients, channel, currentSlot);
                                if (targetDistance <= bestCandidateDistance || targetDistance < currentDistance) continue;

                                ScheduleEntry candidateEntry = recipes.get(candidateMonth).get(candidateWeek).get(channel);
                                if (candidateEntry != null) {
                                    if (candidateEntry.initialConstraint) continue;

                                    Recipe candidateRecipe = candidateEntry.recipe;
                                    if (candidateRecipe.hasIngredientsInCommon(recipe)) continue;
                                    if (!candidateRecipe.isInSeason(month+1)) continue;

                                    int candidateCurrentDistance = getDistance(candidateSlot, candidateRecipe.ingredients, channel, null);
                                    int swapDistance = getDistance(currentSlot, candidateRecipe.ingredients, channel, candidateSlot);
                                    if (swapDistance < candidateCurrentDistance) continue; // we want a mutually beneficial swap
                                }

                                bestCandidateDistance = targetDistance;
                                bestSwap = candidateSlot;
                            }
                        }

                        if (bestSwap != null) {
                            madeASwap = true;
                            Stats.countSwapsExecuted();
                            ScheduleEntry targetEntry = recipes.get(bestSwap.month).get(bestSwap.week).get(channel);
                            recipes.get(bestSwap.month).get(bestSwap.week).put(channel, entry);
                            recipes.get(month).get(week).put(channel, targetEntry);
                        }
                    }
                }
            }

            if (!madeASwap) {
                Stats.countSwapsEndedPrematurely();
                return;
            }
        }
    }

    public void addComment(int humanMonth, int humanWeek, String comment) {
        String existingComment = comments.get(humanMonth-1).get(humanWeek-1);
        if (existingComment.isEmpty()) {
            existingComment = comment;
        } else {
            existingComment = existingComment + "; " + comment;
        }
        comments.get(humanMonth-1).put(humanWeek-1, existingComment);
    }
}
