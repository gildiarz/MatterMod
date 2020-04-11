package gildiarz.mattermod.items;

import gildiarz.mattermod.MatterMod;
import gildiarz.mattermod.init.ModItems;
import gildiarz.mattermod.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{
    public ItemBase(String name) 
    {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(MatterMod.MOD_TAB);

        ModItems.ITEMS.add(this);
    }    

    @Override
    public void registerModels() 
    {
        MatterMod.proxy.registerModel(this, 0);
    }

}