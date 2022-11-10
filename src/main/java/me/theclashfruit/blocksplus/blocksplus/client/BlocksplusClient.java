package me.theclashfruit.blocksplus.blocksplus.client;

import me.theclashfruit.blocksplus.blocksplus.Blocksplus;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class BlocksplusClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(Blocksplus.CHERRY_LEAVES, RenderLayer.getTranslucent());
    }
}
