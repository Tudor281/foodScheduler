package tudor.foodScheduler.model.schedule;

import tudor.foodScheduler.InitialRun;
import tudor.foodScheduler.model.cookbook.Cookbook;
import tudor.foodScheduler.utils.Counter;
import tudor.foodScheduler.utils.Stats;
import tudor.foodScheduler.model.*;

import java.util.*;

@SuppressWarnings("StringConcatenationInLoop")
public class Schedule {
    // month -> week -> channel -> Recipe
    // channels: 0 F1, 1 F2, 3, AUX
    Map<Integer, Map<Integer, Map<Integer, ScheduleEntry>>> recipes = new HashMap<>();
    int[] weeksInMonth;
    int numberOfWeeks;
    Map<Integer, Map<Integer, String>> comments = new HashMap<>();
    public Cookbook cookbook;

    public Schedule(int[] weeksInMonth, Cookbook cookbook) {
        cookbook.calculateDistinguishedIngredients();
        this.weeksInMonth = weeksInMonth;
        this.cookbook = cookbook;
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

    private Schedule(int[] weeksInMonth, Map<Integer, Map<Integer, Map<Integer, ScheduleEntry>>> recipes, Map<Integer, Map<Integer, String>> inputComments, Cookbook cookbook) {
        this.cookbook = cookbook;
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
    public void add(int humanMonth, int humanWeek, Recipe recipe, boolean initialConstraint, int channel) {
        ScheduleEntry oldEntry = recipes.get(humanMonth-1).get(humanWeek-1).put(channel, new ScheduleEntry(recipe, initialConstraint));
        recipeCounts.count(recipe);
        if (oldEntry != null) recipeCounts.deCount(recipe);
    }

    public void add(ScheduleSlot slot, Recipe recipe) {
        ScheduleEntry oldEntry = recipes.get(slot.computerMonth).get(slot.computerWeek).put(recipe.fel.channel, new ScheduleEntry(recipe, false));
        recipeCounts.count(recipe);
        if (oldEntry != null) recipeCounts.deCount(recipe);
    }

    public boolean isRecipePresent(Recipe recipe) {
        return recipeCounts.get(recipe) > 0;
    }

    public String toString() {
        String result = "";
        int rowCounter = 2;
        for (int month=0; month<12; month++) {
            for (int week=0; week<weeksInMonth[month]; week++) {
                result += toString(month, week, ++rowCounter);
            }
        }
        result += countIngredientsAndSpices();
        return result;
    }

    String toString(int month, int week, int row) {
        String result = (month + 1) + "\t" + (week + 1);
        NutrientsSummer nutrientSummer = new NutrientsSummer();
        int startingColumn = 2+1;
        //2
        HashSet<Integer> breadIngredients = new HashSet<>();
        for (int i = 0; i< cookbook.nrChannels; i++) {
            Recipe recipe = getRecipe(month, week, i);
            result += '\t' + (recipe.getName());
            nutrientSummer.sum(recipe, i+startingColumn+cookbook.nrChannels);
            if (recipe.gotAnyIngredients(Ingredient.Paine)) breadIngredients.add(i);
        }
        for (int i=0; i<cookbook.nrChannels; i++) {
            result += '\t' + (breadIngredients.contains(i) ? "B" : "Y");
        }
        result += '\t' + nutrientSummer.toString(row,startingColumn+cookbook.nrChannels*2);
        result += '\t' + buildComments(month, week) + '\n';

        return result;
    }

    public String countIngredientsAndSpices() {
        Counter<Ingredient> ingredientsCount = new Counter<>();
        Counter<Spice> spicesCount = new Counter<>();
        for (int month=0; month<12; month++) {
            for (int week=0; week<weeksInMonth[month]; week++) {
                for (int channel = 0; channel < cookbook.nrChannels; channel++) {
                    ScheduleEntry entry = recipes.get(month).get(week).get(channel);
                    if (entry == null) continue;
                    for (IngredientEntry ingredientEntry : entry.recipe.ingredients) {
                        ingredientsCount.count(ingredientEntry.ingredient, Math.round(ingredientEntry.getIngredientInGrams()));
                    }
                    for (Spice spice : entry.recipe.spices) {
                        spicesCount.count(spice);
                    }
                }
            }
        }

        String result = "\nIngredients:\n";
        for (Map.Entry<Ingredient, Integer> entry : ingredientsCount.getSortedDescending()) {
            result += entry.getKey() + "\t" + (float) entry.getValue() / 1000 + "Kg\n";
        }
        result += "\nSpices:\n";
        for (Map.Entry<Spice, Integer> entry : spicesCount.getSortedDescending()) {
            result += entry.getKey() + "\t" + entry.getValue() + "\n";
        }
        result += "\n END \n";
        return result;
    }

    Recipe getRecipe(int month, int week, int channel) {
        ScheduleEntry entry = recipes.get(month).get(week).get(channel);
        if (entry == null) return null;
        return entry.recipe;
    }

    String buildComments(int month, int week) {
        return comments.get(month).get(week);
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
                for (int channel=0; channel<cookbook.nrChannels; channel++) {
                    if (recipes.get(month).get(week).get(channel) == null) return true;
                }
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
                        if (entry.recipe.hasIngredient(pooledIngredient)) {
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
        return new Schedule(weeksInMonth, recipes, comments, cookbook);
    }

    public Counter<Recipe> recipeCounts = new Counter<>();
    public void countRecipes() {
        recipeCounts.clear();
        for (int month=0; month<12; month++) {
            for (int week = 0; week < weeksInMonth[month]; week++) {
                for (int channel = 0; channel < cookbook.nrChannels; channel ++) {
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
                for (int channel = 0; channel < cookbook.nrChannels; channel++) {
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

    public List<Recipe> getSuitableReplacements(float greatestDistance, ScheduleSlot slot, Recipe recipe) {
        if (!canRemove(recipe)) return List.of();
        List<Recipe> bestRecipes = new ArrayList<>();
        for (Recipe candidate : cookbook.all.values()) {
            if (candidate.fel != recipe.fel) continue;

            if (!canAdd(candidate)) {
//                System.out.println("Can't add "+candidate.name);
                continue;
            }

            if (!candidate.isInSeason(slot.getHumanMonth())) {
//                System.out.println(candidate.name + " not in season");
                continue;
            }

            float distance = getWeightedDistance(slot, candidate.ingredients, recipe.fel.channel, null);
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

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private boolean canRemove(Recipe recipe) {
        switch (recipe.multiplicity) {
            case AtLeastOnce, Once -> {
                return recipeCounts.get(recipe) > 1;
            }
            default -> {
                return true;
            }
        }
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
                //noinspection RedundantIfStatement
                if (recipe.limit != null && recipe.limit >= recipeCounts.get(recipe)) return false;
                return true;
            }
        }
        throw new RuntimeException("Stupid java");
    }

    /** Exception is used for permutation, not to compare with the origin slot */
    float getWeightedDistance(ScheduleSlot slot, List<IngredientEntry> ingredients, int channel, ScheduleSlot exception) {
        List<Ingredient> akaPool = new ArrayList<>();
        Map<Ingredient, IngredientEntry> akaQuantityMapping = new HashMap<>();
        for (IngredientEntry ingredientEntry : ingredients) {
            if (!ingredientEntry.isDistinguished) continue;
            akaPool.add(ingredientEntry.ingredient);
            akaQuantityMapping.put(ingredientEntry.ingredient, ingredientEntry);
            akaPool.addAll(ingredientEntry.ingredient.akas);
            for (Ingredient ingredient : ingredientEntry.ingredient.akas) {
                akaQuantityMapping.put(ingredient, ingredientEntry);
            }
        }

        float weightedDistance = 0;

        for (Ingredient ingredient : akaPool) {
            if (!ingredient.score) continue; // we ignore non scored ingredients (we don't distance them)
            ScheduleSlot forwardIterator = slot.copy();
            ScheduleSlot backwardIterator = slot.copy();
            int counter = 0;
            do {
                boolean foundCommon = false;

                forwardIterator.increment(weeksInMonth);
                if (hasCommonIngredient(forwardIterator, ingredient, channel, exception)) {
                    foundCommon = true;
                    float quantity =  recipes.get(forwardIterator.computerMonth).get(forwardIterator.computerWeek).get(channel).recipe.getQuantityInGrams(ingredient);
                    weightedDistance += (float) counter / (quantity + akaQuantityMapping.get(ingredient).getIngredientInGrams());
                }

                backwardIterator.decrement(weeksInMonth);
                if (hasCommonIngredient(backwardIterator, ingredient, channel, exception)) {
                    foundCommon = true;
                    float quantity =  recipes.get(backwardIterator.computerMonth).get(backwardIterator.computerWeek).get(channel).recipe.getQuantityInGrams(ingredient);
                    weightedDistance += (float) counter / (quantity + akaQuantityMapping.get(ingredient).getIngredientInGrams());
                }

                if (foundCommon) break;
                counter++;
            } while (counter<numberOfWeeks);

        }
        return weightedDistance;
    }

    @SuppressWarnings("RedundantIfStatement")
    boolean hasCommonIngredient(ScheduleSlot slot, Ingredient ingredient, int channel, ScheduleSlot exception) {
        if (exception != null && slot.computerMonth == exception.computerMonth && slot.computerWeek == exception.computerWeek) return false;

        ScheduleEntry entry = recipes.get(slot.computerMonth).get(slot.computerWeek).get(channel);
        if (entry == null) return false;
        if (entry.recipe.hasIngredient(ingredient)) return true;
        return false;
    }

    public boolean reachedLimit(Recipe recipe) {
        int count = recipeCounts.get(recipe);
        return recipe.multiplicity == Multiplicity.AtLeastOnce && ((recipe.limit != null && recipe.limit >= count) || count >= recipe.fel.cap);
    }

    public Schedule optimize() {
        Schedule bestSchedule = this.copy();
        double score = getScore();
        int localExplorationCounter = 0;
        for (int iteration = 0; iteration < 10000; iteration ++) {
            float minimumDistance = Float.MAX_VALUE;
            List<ScheduleSlot> minDistanceSlots = new ArrayList<>();
            List<Recipe> minDistanceRecipes = new ArrayList<>();

            for (int month = 0; month < 12; month++) {
                for (int week = 0; week < weeksInMonth[month]; week++) {
                    for (int channel = 0; channel < cookbook.nrChannels; channel++) {
                        // calculate current distance score
                        ScheduleEntry entry = recipes.get(month).get(week).get(channel);
                        if (entry == null || entry.initialConstraint) continue;

                        Recipe recipe = entry.recipe;
                        ScheduleSlot currentSlot = new ScheduleSlot(month, week);
                        float currentDistance = getWeightedDistance(currentSlot, recipe.ingredients, channel, null);
                        if (currentDistance < minimumDistance) {
                            minDistanceSlots.clear();
                            minDistanceRecipes.clear();
                            minimumDistance = currentDistance;
                        }
                        if (currentDistance < minimumDistance * 10 && currentDistance > minimumDistance / 10) {
                            minDistanceSlots.add(currentSlot);
                            minDistanceRecipes.add(recipe);
                        }
//                        if (currentDistance > 3) continue;
                        float bestCandidateDistance = 0;
                        ScheduleSlot bestSwap = null;
                        // find best possible slot
                        for (int candidateMonth = 0; candidateMonth < 12; candidateMonth++) {
                            for (int candidateWeek = 0; candidateWeek < weeksInMonth[candidateMonth]; candidateWeek++) {
                                if (!recipe.isInSeason(candidateMonth+1)) continue;

                                ScheduleSlot candidateSlot = new ScheduleSlot(candidateMonth, candidateWeek);
                                float targetDistance = getWeightedDistance(candidateSlot, recipe.ingredients, channel, currentSlot);
                                if (targetDistance <= bestCandidateDistance || targetDistance >= currentDistance) continue;

                                ScheduleEntry candidateEntry = recipes.get(candidateMonth).get(candidateWeek).get(channel);
                                if (candidateEntry != null) {
                                    if (candidateEntry.initialConstraint) continue;

                                    Recipe candidateRecipe = candidateEntry.recipe;
//                                    if (candidateRecipe.hasIngredientsInCommon(recipe)) continue;
                                    if (!candidateRecipe.isInSeason(month+1)) continue;

                                    float candidateCurrentDistance = getWeightedDistance(candidateSlot, candidateRecipe.ingredients, channel, null);
                                    float swapDistance = getWeightedDistance(currentSlot, candidateRecipe.ingredients, channel, candidateSlot);
                                    if (swapDistance <= candidateCurrentDistance) continue; // we want a mutually beneficial swap
                                }

                                bestCandidateDistance = targetDistance;
                                bestSwap = candidateSlot;
                            }
                        }

                        if (bestSwap != null) {
                            Stats.countSwapsExecuted();
//                            if (random.nextInt(10) > 8) {
//                                performOptimalInsert(currentSlot, recipe, currentDistance);
//                            } else {
                                ScheduleEntry targetEntry = recipes.get(bestSwap.computerMonth).get(bestSwap.computerWeek).get(channel);
                                recipes.get(bestSwap.computerMonth).get(bestSwap.computerWeek).put(channel, entry);
                                recipes.get(month).get(week).put(channel, targetEntry);
//                            }
                        }
                    }
                }
            }

            double newScore = getScore();
            if (newScore <= score) {
                localExplorationCounter++;
                if (!minDistanceSlots.isEmpty()) {
                    performOptimalInsert(minDistanceSlots, minDistanceRecipes, minimumDistance);
                }
            } else {
                score = newScore;
                localExplorationCounter = 0;
                bestSchedule = this.copy();
            }
            if (localExplorationCounter > 50) return bestSchedule;

//            System.out.println("Score: "+score);

        }
        return bestSchedule;
    }

    private void performOptimalInsert(List<ScheduleSlot> minDistanceSlots, List<Recipe> minDistanceRecipes, float currentDistance) {
        int counter = 0;
        do {
            counter++;
            if (counter > 10) {
//                System.out.println("Gave up for "+minDistanceSlots.size()+" recipes");
                return;
            }
            int index = InitialRun.random.nextInt(minDistanceSlots.size());
            Recipe recipe = minDistanceRecipes.get(index);
            if (!canRemove(recipe)) {
//                System.out.println("Bottomed out "+recipe.getName());
                continue;
            }
            ScheduleSlot slot = minDistanceSlots.get(index);
            ScheduleEntry entry = recipes.get(slot.computerMonth).get(slot.computerWeek).get(recipe.fel.channel);
            if (entry.initialConstraint) return;

            List<Recipe> suitableReplacements = getSuitableReplacements(currentDistance, slot, recipe);
            if (suitableReplacements.isEmpty()) {
                continue;
            }
            add(slot, suitableReplacements.get(InitialRun.random.nextInt(suitableReplacements.size())));
            break;
        } while (true);
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
