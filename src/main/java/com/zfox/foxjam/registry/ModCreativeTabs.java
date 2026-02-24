package com.zfox.foxjam.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public final class ModCreativeTabs {
    public static final CreativeModeTab FOX_JAM_TAB = new CreativeModeTab("fox_jam") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SWEET_BERRY_JAM.get());
        }
    };

    private ModCreativeTabs() {}
}
