package gildiarz.mattermod.creativetabs;

import gildiarz.mattermod.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModTab extends CreativeTabs {

    public ModTab() {
        super(Reference.NAME);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.IRON_INGOT);
    }

    
}