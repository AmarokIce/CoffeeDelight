package lcyzsdh.coffee_delight.util;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

public enum CoffeeType {
    BLACK_COFFEE("black_coffee", 3, 0.2F),
    DOUBLE_ESPRESSO("double_espresso_coffee", 7, 0.5F),
    ARABIC_COFFEE("arabic_coffee", 3, 0.2F),
    TURKEY_COFFEE("turkey_coffee", 3, 0.2F,new Holder[]{MobEffects.MOVEMENT_SPEED},20*30,1),
    LATTE("latte_coffee", 5, 0.3F),
    MOKA("moka_coffee", 7, 0.3F),
    CAPPUCCINO("cappuccino", 6, 0.4F),
    USA("usa_coffee", 4, 0.2F),
    MACCHIATO("macchiato", 9, 0.6F,new Holder[]{MobEffects.MOVEMENT_SPEED,MobEffects.DIG_SPEED},20*30,1),
    MILK_COFFEE("milk_coffee", 6, 0.5F),
    COCO("coco", 8, 0.6F),
    ICED_LATTE("iced_latte_coffee", 6, 0.4F),
    ICED_MOKA("iced_moka", 8, 0.4F),
    ICED_CAPPUCCINO("iced_cappuccino", 7, 0.5F),
    ICED_USA("iced_usa_coffee", 5, 0.2F),
    ICED_MACCHIATO("iced_macchiato", 10, 0.7F),
    ICED_COCO("iced_coco", 9, 0.8F),
    FAIL_COFFEE("fail_coffee", 1, 0.1F, new Holder[]{MobEffects.BAD_OMEN, MobEffects.HUNGER},20*30,1);
    private final String name;
    private final int hunger;
    private final float saturation;
    private final Holder<MobEffect>[] effects;
    private final int effectTime;
    private final int effectLevel;
    CoffeeType(String name, int hunger, float saturation, Holder<MobEffect>[] effects, int effectTime, int effectLevel) {
        this.name = name;
        this.hunger = hunger;
        this.saturation = saturation;
        this.effects = effects;
        this.effectTime = effectTime;
        this.effectLevel = effectLevel;
    }
    CoffeeType(String name, int hunger, float saturation) {
        this(name, hunger, saturation, null,0,0);
    }
    public String getName() {
        return this.name;
    }
    public int getHunger() {
        return this.hunger;
    }
    public float getSaturation() {
        return this.saturation;
    }
    public Holder<MobEffect>[] getEffects() {
        return this.effects;
    }
    public int getEffectTime() {
        return this.effectTime;
    }
    public int getEffectLevel() {
        return this.effectLevel;
    }
}
