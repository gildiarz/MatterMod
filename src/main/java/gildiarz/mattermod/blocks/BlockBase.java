package gildiarz.mattermod.blocks;

import gildiarz.mattermod.MatterMod;
import gildiarz.mattermod.init.ModBlocks;
import gildiarz.mattermod.init.ModItems;
import gildiarz.mattermod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel
{
    public BlockBase(String name, Material material) 
    {
        super(material);

        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(MatterMod.MOD_TAB);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    @Override
    public void registerModels() 
    {
        MatterMod.proxy.registerModel(Item.getItemFromBlock(this), 0);
    }
}