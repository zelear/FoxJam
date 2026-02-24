package com.zfox.foxjam.item;

import java.util.function.Supplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class JarFoodItem extends Item {
    private final Supplier<? extends Item> containerItem;

    public JarFoodItem(Properties properties, Supplier<? extends Item> containerItem) {
        super(properties);
        this.containerItem = containerItem;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        ItemStack resultStack = super.finishUsingItem(stack, level, livingEntity);

        if (livingEntity instanceof Player player && player.getAbilities().instabuild) {
            return resultStack;
        }

        ItemStack containerStack = new ItemStack(containerItem.get());

        if (resultStack.isEmpty()) {
            return containerStack;
        }

        if (livingEntity instanceof Player player && !player.getInventory().add(containerStack)) {
            player.drop(containerStack, false);
        }

        return resultStack;
    }
}
