package me.theclashfruit.blocksplus.blocksplus.classes;

import me.theclashfruit.blocksplus.blocksplus.Blocksplus;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class CheerySaplingGenerator extends SaplingGenerator {
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return Blocksplus.TREE_CHERRY;
    }
}
