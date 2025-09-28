package tudor.foodScheduler.model;

public class IngredientEntry {
    public Ingredient ingredient;
    int quantity;
    UnitOfMeasure unitOfMeasure;
    public boolean isDistinguished = false;

    public IngredientEntry(Ingredient ingredient, int quantity, UnitOfMeasure unitOfMeasure) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
    }

    public float getIngredientInGrams() {
        switch (unitOfMeasure) {
            case gram -> {
                return quantity;
            }
            case bucati -> {
                switch (ingredient) {
                    case Avocado_Hass -> {
                        return 120 * quantity; // copilot
                    }
                    case Ardei_Rosu -> {
                        return 100 * quantity;
                    }
                    case Broccoli -> {
                        return 1000 * quantity;
                    }
                    case Castraveti -> {
                        return 200 * quantity;
                    }
                    case Ceapa -> {
                        return 150 * quantity;
                    }
                    case Ceapa_Verde -> {
                        return 100 * quantity;
                    }
                    case Conopida -> {
                        return 1500 * quantity;
                    }
                    case DovleacPlacintar -> {
                        return 3000 * quantity;
                    }
                    case Dovlecei -> {
                        return 750 * quantity; // TODO
                    }
                    case Morcov -> {
                        return 100 * quantity;
                    }
                    case Ou -> {
                        return 60 * quantity; // ou mediu (Eat & Track)
                    }
                    case Pastarnac -> {
                        return 100 * quantity;
                    }
                    case Praz -> {
                        return 200 * quantity; // partea alba
                    }
                    case Radacina_Patrunjel -> {
                        return 100 * quantity;
                    }
                    case Rosii -> {
                        return 250 * quantity;
                    }
                    case Salata -> {
                        return 750 * quantity;
                    }
                    case Telina -> {
                        return 900 * quantity;
                    }
                    case Usturoi -> {
                        return 5 * quantity;
                    }
                    default -> {
                        throw new RuntimeException("Unknown bucati for ingredient "+ingredient.name());
                    }
                }
            }
            case linguri -> {
                switch (ingredient) {
                    case Faina_Grau_65 -> {
                        return 25 * quantity;// cu varf
                    }
                    case Gris -> {
                        return 17 * quantity; // cantarit
                    }
                    case Tahini -> {
                        return 20 * quantity; // cantarit
                    }
                    case Ulei_Floarea_Soarelui -> {
                        return 15 * quantity;
                    }
                    case Ulei_Masline -> {
                        return 15 * quantity;
                    }
                    case Zahar -> {
                        return 19 * quantity;
                    }
                    default -> {
                        throw new RuntimeException("Unknown linguri for ingredient "+ingredient.name());
                    }
                }
            }
            default -> {
                throw new RuntimeException("Unknown unit of measure: "+unitOfMeasure.name());
            }
        }
    }
}
