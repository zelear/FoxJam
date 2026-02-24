package com.zfox.foxjam.registry;

import com.zfox.foxjam.Main;
import com.zfox.foxjam.item.JarFoodItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    public static final RegistryObject<Item> JAR = ITEMS.register("jar",
            () -> new Item(new Item.Properties().tab(ModCreativeTabs.FOX_JAM_TAB)));

    public static final RegistryObject<Item> SUGAR_CUBE = ITEMS.register("sugar_cube",
            () -> new Item(new Item.Properties().tab(ModCreativeTabs.FOX_JAM_TAB)));

    public static final RegistryObject<Item> SWEET_BERRY_JAM = ITEMS.register("sweet_berry_jam",
            () -> new JarFoodItem(new Item.Properties()
                    .tab(ModCreativeTabs.FOX_JAM_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(12)
                            .saturationMod(0.33333334f)
                            .build()),
                    JAR));

    public static final RegistryObject<Item> GOLDEN_SWEET_BERRY_JAM = ITEMS.register("golden_sweet_berry_jam",
            () -> new JarFoodItem(new Item.Properties()
                    .tab(ModCreativeTabs.FOX_JAM_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(8)
                            .saturationMod(0.9375f)
                            .build()),
                    JAR));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private ModItems() {}
}
