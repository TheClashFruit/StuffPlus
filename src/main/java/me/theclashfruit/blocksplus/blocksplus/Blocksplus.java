package me.theclashfruit.blocksplus.blocksplus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.*;

public class Blocksplus implements ModInitializer {

    public static final Block SPRUCE_BOOKSHELF = new Block(FabricBlockSettings.of(Material.WOOD).strength(1.5f));
    public static final Block BIRCH_BOOKSHELF = new Block(FabricBlockSettings.of(Material.WOOD).strength(1.5f));
    public static final Block JUNGLE_BOOKSHELF = new Block(FabricBlockSettings.of(Material.WOOD).strength(1.5f));
    public static final Block ACACIA_BOOKSHELF = new Block(FabricBlockSettings.of(Material.WOOD).strength(1.5f));
    public static final Block DARK_OAK_BOOKSHELF = new Block(FabricBlockSettings.of(Material.WOOD).strength(1.5f));
    public static final Block MANGROVE_BOOKSHELF = new Block(FabricBlockSettings.of(Material.WOOD).strength(1.5f));

    public static final ItemGroup BLOCKSPLUS_GROUP = FabricItemGroupBuilder.build(
            new Identifier("blocksplus", "general"),
            () -> new ItemStack(Blocks.BOOKSHELF));

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("blocksplus", "spruce_bookshelf"), SPRUCE_BOOKSHELF);
        Registry.register(Registry.BLOCK, new Identifier("blocksplus", "birch_bookshelf"), BIRCH_BOOKSHELF);
        Registry.register(Registry.BLOCK, new Identifier("blocksplus", "jungle_bookshelf"), JUNGLE_BOOKSHELF);
        Registry.register(Registry.BLOCK, new Identifier("blocksplus", "acacia_bookshelf"), ACACIA_BOOKSHELF);
        Registry.register(Registry.BLOCK, new Identifier("blocksplus", "dark_oak_bookshelf"), DARK_OAK_BOOKSHELF);
        Registry.register(Registry.BLOCK, new Identifier("blocksplus", "mangrove_bookshelf"), MANGROVE_BOOKSHELF);

        Registry.register(Registry.ITEM, new Identifier("blocksplus", "spruce_bookshelf"), new BlockItem(SPRUCE_BOOKSHELF, new FabricItemSettings().group(BLOCKSPLUS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("blocksplus", "birch_bookshelf"), new BlockItem(BIRCH_BOOKSHELF, new FabricItemSettings().group(BLOCKSPLUS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("blocksplus", "jungle_bookshelf"), new BlockItem(JUNGLE_BOOKSHELF, new FabricItemSettings().group(BLOCKSPLUS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("blocksplus", "acacia_bookshelf"), new BlockItem(ACACIA_BOOKSHELF, new FabricItemSettings().group(BLOCKSPLUS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("blocksplus", "dark_oak_bookshelf"), new BlockItem(DARK_OAK_BOOKSHELF, new FabricItemSettings().group(BLOCKSPLUS_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("blocksplus", "mangrove_bookshelf"), new BlockItem(MANGROVE_BOOKSHELF, new FabricItemSettings().group(BLOCKSPLUS_GROUP)));

        FlammableBlockRegistry.getDefaultInstance().add(SPRUCE_BOOKSHELF, 30, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BIRCH_BOOKSHELF, 30, 5);
        FlammableBlockRegistry.getDefaultInstance().add(JUNGLE_BOOKSHELF, 30, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ACACIA_BOOKSHELF, 30, 5);
        FlammableBlockRegistry.getDefaultInstance().add(DARK_OAK_BOOKSHELF, 30, 5);
        FlammableBlockRegistry.getDefaultInstance().add(MANGROVE_BOOKSHELF, 30, 5);
    }
}
