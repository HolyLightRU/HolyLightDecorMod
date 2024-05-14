package com.HolyLight.decor.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public interface IDecor
{
    String getModelPath();

    String getTexturePath();
    
    String getsetBlockTextureName();

	int getsetLight();
	
	int getcreativeTab();

	
	

}


