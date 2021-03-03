package io.github.algoram.infium;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class InfiumPickaxeItem extends PickaxeItem {
    protected InfiumPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
