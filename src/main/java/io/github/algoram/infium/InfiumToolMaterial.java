package io.github.algoram.infium;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class InfiumToolMaterial implements ToolMaterial {

    public static final InfiumToolMaterial INSTANCE = new InfiumToolMaterial();

    @Override
    public int getDurability() {
        return 500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.0f;
    }

    @Override
    public float getAttackDamage() {
        return 3.0f;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(InitializerClass.INFIUM_ITEM);
    }
}
