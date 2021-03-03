package io.github.algoram.infium;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class InitializerClass {

    // basic item
    public static final Item INFIUM_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC));

    // ore and ore generation
    public static final Block INFIUM_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0f, 3.0f));
    private static final ConfiguredFeature<?, ?> ORE_INFIUM_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, INFIUM_ORE.getDefaultState(), 9))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 64)))
            .spreadHorizontally()
            .repeat(20);

    // block
    public static final Block INFIUM_BLOCK = new Block(FabricBlockSettings.copy(Blocks.DIAMOND_BLOCK));

    // tools
    public static ToolItem INFIUM_SHOVEL =  new ShovelItem(InfiumToolMaterial.INSTANCE,         1.5f,   -3.0f, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem INFIUM_SWORD =   new SwordItem(InfiumToolMaterial.INSTANCE,          3,      -2.4f, new Item.Settings().group(ItemGroup.COMBAT));
    public static ToolItem INFIUM_PICKAXE = new InfiumPickaxeItem(InfiumToolMaterial.INSTANCE,  1,      -2.8f, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem INFIUM_HOE =     new InfiumHoeItem(InfiumToolMaterial.INSTANCE,      7,      -3.2f, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem INFIUM_AXE =     new InfiumAxeItem(InfiumToolMaterial.INSTANCE,      7.0f,   -3.2f, new Item.Settings().group(ItemGroup.TOOLS));

    public static void initialize() {
        // register basic item
        Registry.register(Registry.ITEM, new Identifier(Infium.modId, "infium"), INFIUM_ITEM);

        // register ore
        Registry.register(Registry.BLOCK, new Identifier(Infium.modId, "infium_ore"), INFIUM_ORE);
        Registry.register(Registry.ITEM, new Identifier(Infium.modId, "infium_ore"), new BlockItem(INFIUM_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        // register ore generation
        RegistryKey<ConfiguredFeature<?, ?>> oreInfiumOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier(Infium.modId, "ore_infium_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreInfiumOverworld.getValue(), ORE_INFIUM_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreInfiumOverworld);

        // register block
        Registry.register(Registry.BLOCK, new Identifier(Infium.modId, "infium_block"), INFIUM_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Infium.modId, "infium_block"), new BlockItem(INFIUM_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        // register tools
        Registry.register(Registry.ITEM, new Identifier(Infium.modId, "infium_shovel"),     INFIUM_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier(Infium.modId, "infium_sword"),      INFIUM_SWORD);
        Registry.register(Registry.ITEM, new Identifier(Infium.modId, "infium_pickaxe"),    INFIUM_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(Infium.modId, "infium_axe"),        INFIUM_AXE);
        Registry.register(Registry.ITEM, new Identifier(Infium.modId, "infium_hoe"),        INFIUM_HOE);
    }

}
