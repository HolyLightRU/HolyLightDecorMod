package com.HolyLight.decor.client.render;

import net.minecraft.client.renderer.tileentity.*;
import java.util.*;
import net.minecraft.tileentity.*;
import net.minecraftforge.client.model.obj.*;
import net.minecraft.util.*;
import net.minecraftforge.client.model.*;
import org.lwjgl.opengl.*;

import com.HolyLight.decor.blocks.*;
import com.HolyLight.decor.tiles.*;

public class RenderDecor extends TileEntitySpecialRenderer
{
    public static final HashMap<String, IModelCustom> CACHE;
    private IModelCustom model;
    private String modelPath;
    private String texturePath;

    @Override
    public void renderTileEntityAt(final TileEntity tile, final double x, final double y, final double z, final float f) {
        this.render((TileDecor)tile, x, y, z);
    }

    private void render(final TileDecor tile, final double x, final double y, final double z) {
        if (tile.getBlockType() instanceof IDecor) {
            this.modelPath = ((IDecor)tile.getBlockType()).getModelPath();
            this.texturePath = ((IDecor)tile.getBlockType()).getTexturePath();
        }
        if (!RenderDecor.CACHE.containsKey(this.modelPath)) {
            this.model = new ModelWrapperDisplayList((WavefrontObject)AdvancedModelLoader.loadModel(new ResourceLocation("decor-mod", this.modelPath)));
            RenderDecor.CACHE.put(this.modelPath, this.model);
        }
        else {
            this.model = RenderDecor.CACHE.get(this.modelPath);
        }
        if (this.model != null) {
            this.bindTexture(new ResourceLocation("decor-mod", this.texturePath));
            GL11.glPushMatrix();
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(3042);
            GL11.glTranslated(x + 0.5, y, z + 0.5);
            this.setupRotation(tile);
            GL11.glRotated(tile.getRotation(), 0.0, 1.0, 0.0);
            this.model.renderAll();
            GL11.glDisable(3042);
            GL11.glPopMatrix();
        }
    }

    private void setupRotation(final TileDecor tile) {
        if (tile != null) {
            switch (tile.getBlockMetadata()) {
                case 0: {
                    GL11.glRotatef(360.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 1: {
                    GL11.glRotatef(270.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 2: {
                    GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 3: {
                    GL11.glRotatef(450.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
            }
        }
    }

    static {
        CACHE = new HashMap<String, IModelCustom>();
    }
}
