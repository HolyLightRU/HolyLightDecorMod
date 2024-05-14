package com.HolyLight.decor.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.Minecraft;
import com.HolyLight.decor.*;
import com.HolyLight.decor.tiles.*;

import cpw.mods.fml.common.registry.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class BlockDecor extends Block implements ITileEntityProvider, IDecor
{
    private final String modelPath;
    private final String texturePath;
    private final boolean collide;
	private String setBlockTextureName;
	private int setLight;
	private int creativeTab;

    public BlockDecor(final String name, final String modelPath, final String texturePath, final boolean collide, final String setBlockTextureName, final int setLight, final int creativeTab) {
        super(Material.iron);
        this.modelPath = modelPath;
        this.texturePath = texturePath;
        this.collide = collide;
        switch (setLight) {
        case 1:
        	this.setLightLevel(15.0F);
        	break;
        case 2:
        	this.setLightLevel(14.0F);
        	break;
        case 3:
        	this.setLightLevel(13.0F);
        	break;
        case 4:
        	this.setLightLevel(12.0F);
        	break;
        case 5:
        	this.setLightLevel(11.0F);
        	break;
        case 6:
        	this.setLightLevel(10.0F);
        	break;
        case 7:
        	this.setLightLevel(9.0F);
        	break;
        case 8:
        	this.setLightLevel(8.0F);
        	break;
        case 9:
        	this.setLightLevel(7.0F);
        	break;
        case 10:
        	this.setLightLevel(6.0F);
        	break;
        case 11:
        	this.setLightLevel(5.0F);
        	break;
        case 12:
        	this.setLightLevel(4.0F);
        	break;
        case 13:
        	this.setLightLevel(3.0F);
        	break;
        case 14:
        	this.setLightLevel(2.0F);
        	break;
        case 15:
        	this.setLightLevel(1.0F);
        	break;
        default:
        	this.setLightLevel(0F);
        	break;
        }
        
        
        if (setBlockTextureName == null) {
        	this.setBlockTextureName("decor-mod:decor_icon");	
        }
        else if (setBlockTextureName == "") {
        	this.setBlockTextureName("decor-mod:decor_icon");
        }
        else {
        	this.setBlockTextureName("decor-mod" + ":" + setBlockTextureName);
        }
        this.setResistance(99999.0f);
        if (creativeTab == 1) {
        	this.setCreativeTab(Main.DECOR_TAB1);
        }
        else if (creativeTab == 2) {
        	this.setCreativeTab(Main.DECOR_TAB2);
        }
        else if (creativeTab == 3) {
        	this.setCreativeTab(Main.DECOR_TAB3);
        }
        else if (creativeTab == 4) {
        	this.setCreativeTab(Main.DECOR_TAB4);
        }
        else {
        	this.setCreativeTab(Main.DECOR_TAB5);
        }
        this.setBlockName(name);
        LanguageRegistry.addName(this, name);
    }

	@Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World p_149668_1_, final int p_149668_2_, final int p_149668_3_, final int p_149668_4_) {
        if (!this.collide)
            return null;
        return super.getCollisionBoundingBoxFromPool(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
    }

    @SideOnly(Side.CLIENT)
    public boolean canCollideCheck(int p149678_1, boolean p149678_2)
    {
        if (!this.collide)
            if (!Minecraft.getMinecraft().thePlayer.capabilities.isCreativeMode)
                return false;
            else return true;
        else return true;
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
        if (!Minecraft.getMinecraft().thePlayer.capabilities.isCreativeMode)
            return AxisAlignedBB.getBoundingBox(0,0,0,0,0,0);
        else return super.getSelectedBoundingBoxFromPool(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
    }

    @Override
    public TileEntity createNewTileEntity(final World p_149915_1_, final int p_149915_2_) {
        return new TileDecor();
    }

    @Override
    public void onBlockPlacedBy(final World world, final int x, final int y, final int z, final EntityLivingBase entity, final ItemStack is) {
        final int l = MathHelper.floor_double(entity.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3;
        world.setBlockMetadataWithNotify(x, y, z, l, 2);
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public String getModelPath() {
        return this.modelPath;
    }
    
    @Override
    public int getcreativeTab() {
        return this.creativeTab;
    }

    @Override
    public String getTexturePath() {
        return this.texturePath;
    }
    @Override
    public int getsetLight() {
        return this.setLight;
    }
    @Override
    public String getsetBlockTextureName() {
        return this.setBlockTextureName;
    }
}
