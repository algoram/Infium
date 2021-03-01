package io.github.algoram.infium;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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
    }

}