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
                    case Avocado_Hass_Raw -> {
                        return 120 * quantity; // copilot
                    }
                    case Ardei_Rosu_Raw -> {
                        return 100 * quantity;
                    }
                    case Broccoli_Raw -> {
                        return 1000 * quantity;
                    }
                    case Castraveti_Cornichon -> {
                        return 100 * quantity; // checked
                    }
                    case Castraveti_Murati -> {
                        return 150 * quantity;
                    }
                    case Ceapa_Galbena_Raw -> {
                        return 150 * quantity;
                    }
                    case Ceapa_Verde_Raw -> {
                        return 100 * quantity;
                    }
                    case Conopida_Raw -> {
                        return 1500 * quantity;
                    }
                    case DovleacPlacintar_Raw -> {
                        return 3000 * quantity;
                    }
                    case Dovlecei_Raw -> {
                        return 450 * quantity; // checked
                    }
                    case Kaki -> {
                        return 200 * quantity; // weighted at 180 and something but it seemed a bit small
                    }
                    case Morcov_Raw -> {
                        return 100 * quantity;
                    }
                    case Ou_Raw -> {
                        return 60 * quantity; // ou mediu (Eat & Track)
                    }
                    case Paine -> {
                        return 28 * quantity;
                    }
                    case Pastarnac_Raw -> {
                        return 100 * quantity;
                    }
                    case Praz_Raw -> {
                        return 200 * quantity; // partea alba
                    }
                    case Radacina_Patrunjel -> {
                        return 100 * quantity;
                    }
                    case Rosii -> {
                        return 250 * quantity;
                    }
                    case Salata_Raw -> {
                        return 750 * quantity;
                    }
                    case Telina_Raw -> {
                        return 900 * quantity;
                    }
                    case Usturoi_Raw -> {
                        return 5 * quantity;
                    }
                    default -> throw new RuntimeException("Unknown bucati for ingredient "+ingredient.name());
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
                    case Lapte -> {
                        return 10 * quantity; // cantarit
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
                        return 19 * quantity; // cantarit
                    }
                    default -> throw new RuntimeException("Unknown linguri for ingredient "+ingredient.name());
                }
            }
            default -> throw new RuntimeException("Unknown unit of measure: "+unitOfMeasure.name());
        }
    }
}
