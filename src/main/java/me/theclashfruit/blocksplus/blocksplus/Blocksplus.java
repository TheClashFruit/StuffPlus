package me.theclashfruit.blocksplus.blocksplus;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Blocksplus implements ModInitializer {

    public static final Block SPRUCE_BOOKSHELF = new Block(FabricBlockSettings.of(Material.WOOD).strength(1.5f));
    public static final Block BIRCH_BOOKSHELF = new Block(FabricBlockSettings.of(Material.WOOD).strength(1.5f));
    public static final Block JUNGLE_BOOKSHELF = new Block(FabricBlockSettings.of(Material.WOOD).strength(1.5f));
    public static final Block ACACIA_BOOKSHELF = new Block(FabricBlockSettings.of(Material.WOOD).strength(1.5f));
    public static final Block DARK_OAK_BOOKSHELF = new Block(FabricBlockSettings.of(Material.WOOD).strength(1.5f));
    public static final Block MANGROVE_BOOKSHELF = new Block(FabricBlockSettings.of(Material.WOOD).strength(1.5f));

    public static final Item FOOD_ORANGE = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(2.4f).build()).group(ItemGroup.FOOD));
    public static final Item FOOD_CHERRY = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(3.8f).build()).group(ItemGroup.FOOD));

    public static final ItemGroup BLOCKSPLUS_GROUP = FabricItemGroupBuilder.build(
            new Identifier("blocksplus", "general"),
            () -> new ItemStack(Blocks.BOOKSHELF));

    // https://github.com/koellecraft/Right-Click-Harvest
    public static final IReplantHandler DEFAULT_HANDLER = (world, hit, state, player, tileEntity) -> {
        List<Crop> crops = Lists.newArrayList();

        crops.add(new Crop(Blocks.WHEAT.getDefaultState().with(Properties.AGE_7, 7)));
        crops.add(new Crop(Blocks.POTATOES.getDefaultState().with(Properties.AGE_7, 7)));
        crops.add(new Crop(Blocks.CARROTS.getDefaultState().with(Properties.AGE_7, 7)));
        crops.add(new Crop(Blocks.BEETROOTS.getDefaultState().with(Properties.AGE_3, 3)));
        crops.add(new Crop(Blocks.NETHER_WART.getDefaultState().with(Properties.AGE_3, 3)));

        Crop crop = crops.stream().filter(c -> c.test(state)).findFirst().orElse(null);
        if (crop == null) {
            return ActionResult.PASS;
        }

        BlockPos pos = hit.getBlockPos();
        List<ItemStack> drops = Block.getDroppedStacks(state, world, pos, tileEntity, player, player.getStackInHand(Hand.MAIN_HAND));
        boolean foundSeed = false;
        for (ItemStack drop : drops) {
            Item dropItem = drop.getItem();
            if (dropItem instanceof BlockItem && ((BlockItem)dropItem).getBlock() == state.getBlock()) {
                foundSeed = true;
                drop.decrement(1);
                break;
            }
        }

        if (foundSeed) {
            drops.forEach(stack -> ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), stack));
            world.setBlockState(pos, state.getBlock().getDefaultState());
            return ActionResult.SUCCESS;
        }

        return ActionResult.FAIL;
    };

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

        ///////////////////////////////////////////

        Registry.register(Registry.ITEM, new Identifier("blocksplus", "orange"), FOOD_ORANGE);
        Registry.register(Registry.ITEM, new Identifier("blocksplus", "cherries"), FOOD_CHERRY);

        ///////////////////////////////////////////

        UseBlockCallback.EVENT.register((player, world, hand, hit) -> {
            if (!(world instanceof ServerWorld))
                return ActionResult.PASS;

            if (hand != Hand.MAIN_HAND)
                return ActionResult.PASS;

            BlockState state = world.getBlockState(hit.getBlockPos());
            ActionResult result = DEFAULT_HANDLER.handlePlant((ServerWorld) world, hit, state, player, world.getBlockEntity(hit.getBlockPos()));
            if (result == ActionResult.SUCCESS) {
                player.swingHand(hand);
                player.addExhaustion(0.005f);
            }

            return result;
        });
    }
}
