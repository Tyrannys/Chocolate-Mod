package tyrannus.chocolate.init.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class EntityChocolateSlime extends Mob implements Enemy {
    private static final EntityDataAccessor<Integer> SLIME_SIZE = SynchedEntityData.defineId(EntityChocolateSlime.class, EntityDataSerializers.INT);
    public float squishAmount;
    public float squishFactor;
    public float prevSquishFactor;
    private boolean wasOnGround;

    public EntityChocolateSlime(EntityType<EntityChocolateSlime> type, Level worldIn) {
        super(type, worldIn);
        this.moveControl = new net.minecraft.world.entity.ai.control.MoveControl(this);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new EntityChocolateSlime.FloatGoal(this));
        this.goalSelector.addGoal(2, new EntityChocolateSlime.AttackGoal(this));
        this.goalSelector.addGoal(3, new EntityChocolateSlime.FaceRandomGoal(this));
        this.goalSelector.addGoal(5, new EntityChocolateSlime.HopGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (p_213811_1_) -> Math.abs(p_213811_1_.getY() - this.getY()) <= 4.0D));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }
    @Override
    protected void defineSynchedData() {
        super.registerGoals();
        this.entityData.define(SLIME_SIZE, 1);
    }

    protected void setSlimeSize(int size, boolean resetHealth) {
        this.entityData.set(SLIME_SIZE, size);
        this.reapplyPosition();
        this.refreshDimensions();
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue((double)(size * size));
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double)(0.2F + 0.1F * (float)size));
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue((double)size);
        if (resetHealth) {
            this.setHealth(this.getMaxHealth());
        }

        this.xpReward = size;
    }

    /*public static Attributes getMutableAttributes() {
        return Monster.createMonsterAttributes().hasAttribute();
    }*/
    /**
     * Returns the size of the slime.
     */

    public int getSlimeSize() {
        return this.entityData.get(SLIME_SIZE);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Size", this.getSlimeSize() - 1);
        compound.putBoolean("wasOnGround", this.wasOnGround);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readAdditionalSaveData(CompoundTag p_33607_) {
        this.setSlimeSize(p_33607_.getInt("Size") + 1, false);
        super.readAdditionalSaveData(p_33607_);
        this.wasOnGround = p_33607_.getBoolean("wasOnGround");
    }

    public boolean isSmallSlime() {
        return this.getSlimeSize() <= 1;
    }

    protected ParticleOptions getSquishParticle() {
        return ParticleTypes.ITEM_SLIME;
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return this.getSlimeSize() > 0;
    }

    @Override
    public void tick() {
        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
        this.prevSquishFactor = this.squishFactor;
        super.tick();
        if (this.onGround && !this.wasOnGround) {
            int i = this.getSlimeSize();

            if (spawnCustomParticles()) i = 0; // don't spawn particles if it's handled by the implementation itself
            for(int j = 0; j < i * 8; ++j) {
                float f = this.random.nextFloat() * ((float)Math.PI * 2F);
                float f1 = this.random.nextFloat() * 0.5F + 0.5F;
                float f2 = Mth.sin(f) * (float)i * 0.5F * f1;
                float f3 = Mth.cos(f) * (float)i * 0.5F * f1;
                this.level.addParticle(this.getSquishParticle(), this.getX() + (double)f2, this.getY(), this.getZ() + (double)f3, 0.0D, 0.0D, 0.0D);
            }

            this.playSound(this.getSquishSound(), this.getSoundVolume(), ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            this.squishAmount = -0.5F;
        } else if (!this.onGround && this.wasOnGround) {
            this.squishAmount = 1.0F;
        }

        this.wasOnGround = this.onGround;
        this.alterSquishAmount();
    }

    protected void alterSquishAmount() {
        this.squishAmount *= 0.6F;
    }

    /**
     * Gets the amount of time the slime needs to wait between jumps.
     */

    protected int getJumpDelay() {
        return this.random.nextInt(20) + 10;
    }
    @Override
    public void refreshDimensions() {
        double d0 = this.getX();
        double d1 = this.getY();
        double d2 = this.getZ();
        super.refreshDimensions();
        this.setPos(d0, d1, d2);
    }
    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
        if (SLIME_SIZE.equals(key)) {
            this.refreshDimensions();
            this.setYRot(this.yHeadRot);
            this.yBodyRot = this.yHeadRot;
            if (this.isInWater() && this.random.nextInt(20) == 0) {
                this.doWaterSplashEffect();
            }
        }

        super.onSyncedDataUpdated(key);
    }
    @Override
    public EntityType<? extends EntityChocolateSlime> getType() { return (EntityType<? extends EntityChocolateSlime>)super.getType(); }

    @Override
    public void remove(Entity.RemovalReason keepData) {
        int i = this.getSlimeSize();
        if (!this.level.isClientSide && i > 1 && this.isDeadOrDying() && !this.isAlive()) {
            Component component = this.getCustomName();
            boolean flag = this.isNoAi();
            float f = (float)i / 4.0F;
            int j = i / 2;
            int k = 2 + this.random.nextInt(3);

            for(int l = 0; l < k; ++l) {
                float f1 = ((float)(l % 2) - 0.5F) * f;
                float f2 = ((float)(l / 2) - 0.5F) * f;
                EntityChocolateSlime slimeentity = this.getType().create(this.level);
                if (this.isPersistenceRequired()) {
                    slimeentity.setPersistenceRequired();
                }

                slimeentity.setCustomName(component);
                slimeentity.setNoAi(flag);
                slimeentity.setInvulnerable(this.isInvulnerable());
                slimeentity.setSlimeSize(j, true);
                slimeentity.moveTo(this.getX() + (double)f1, this.getY() + 0.5D, this.getZ() + (double)f2, this.random.nextFloat() * 360.0F, 0.0F);
                this.level.addFreshEntity(slimeentity);
            }
        }

        super.remove(keepData);
    }

    /**
     * Applies a velocity to the entities, to push them away from eachother.
     */
    @Override
    public void push(Entity entityIn) {
        super.push(entityIn);
        if (entityIn instanceof IronGolem && this.canDamagePlayer()) {
            this.dealDamage((LivingEntity) entityIn);
        }

    }

    /**
     * Called by a player entity when they collide with an entity
     */
    @Override
    public void playerTouch(Player entityIn) {
        if (this.canDamagePlayer()) {
            this.dealDamage(entityIn);
        }

    }

    protected void dealDamage(LivingEntity entityIn) {
        if (this.isAlive()) {
            int i = this.getSlimeSize();
            if (this.distanceToSqr(entityIn) < 0.6D * (double)i * 0.6D * (double)i && this.hasLineOfSight(entityIn) && entityIn.hurt(DamageSource.mobAttack(this), this.func_225512_er_())) {
                this.playSound(SoundEvents.SLIME_ATTACK, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
                this.doEnchantDamageEffects(this, entityIn);
            }
        }

    }
    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.625F * sizeIn.height;
    }

    /**
     * Indicates weather the slime is able to damage the player (based upon the slime's size)
     */

    protected boolean canDamagePlayer() {
        return !this.isSmallSlime() && this.hasImpulse;
    }

    protected float func_225512_er_() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return this.isSmallSlime() ? SoundEvents.SLIME_HURT_SMALL : SoundEvents.SLIME_HURT;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return this.isSmallSlime() ? SoundEvents.SLIME_DEATH : SoundEvents.SLIME_DEATH;
    }

    protected SoundEvent getSquishSound() {
        return this.isSmallSlime() ? SoundEvents.SLIME_SQUISH_SMALL : SoundEvents.SLIME_SQUISH;
    }
    @Override
    protected ResourceLocation getDefaultLootTable() {
        return this.getSlimeSize() == 1 ? this.getType().getDefaultLootTable() : BuiltInLootTables.EMPTY;
    }

    public static boolean checkSlimeSpawnRules(EntityType<EntityChocolateSlime> EntityType, LevelAccessor world, MobSpawnType reason, BlockPos pos, Random randomIn) {
        if (world.getDifficulty() != Difficulty.PEACEFUL) {
            if (Objects.equals(world.getBiomeName(pos), Optional.of(Biomes.SWAMP)) && pos.getY() > 50 && pos.getY() < 70 && randomIn.nextFloat() < 0.5F && randomIn.nextFloat() < world.getMoonBrightness() && world.getMaxLocalRawBrightness(pos) <= randomIn.nextInt(8)) {
                return checkMobSpawnRules(EntityType, world, reason, pos, randomIn);
            }

            if (!(pos instanceof WorldGenLevel)) {
                return false;
            }

            ChunkPos chunkpos = new ChunkPos(pos);
            boolean flag = WorldgenRandom.seedSlimeChunk(chunkpos.x, chunkpos.z, ((WorldGenLevel)world).getSeed(), 987234911L).nextInt(10) == 0;
            if (randomIn.nextInt(10) == 0 && flag && pos.getY() < 40) {
                return checkMobSpawnRules(EntityType, world, reason, pos, randomIn);
            }
        }

        return false;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume() {
        return 0.4F * (float)this.getSlimeSize();
    }

    /**
     * Returns true if the slime makes a sound when it jumps (based upon the slime's size)
     */
    protected boolean makesSoundOnJump() {
        return this.getSlimeSize() > 0;
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    protected void jumpFromGround() {
        Vec3 vec3 = this.getDeltaMovement();
        this.setDeltaMovement(vec3.x, (double)this.getJumpPower(), vec3.z);
        this.hasImpulse = true;
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
        int i = this.random.nextInt(3);
        if (i < 2 && this.random.nextFloat() < 0.5F * difficultyIn.getSpecialMultiplier()) {
            ++i;
        }

        int j = 1 << i;
        this.setSlimeSize(j, true);
        return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    private float func_234304_m_() {
        float f = this.isSmallSlime() ? 1.4F : 0.8F;
        return ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * f;
    }

    protected SoundEvent getJumpSound() {
        return this.isSmallSlime() ? SoundEvents.SLIME_JUMP_SMALL : SoundEvents.SLIME_JUMP;
    }
    @Override
    public EntityDimensions getDimensions(Pose poseIn) {
        return super.getDimensions(poseIn).scale(0.255F * (float)this.getSlimeSize());
    }

    /**
     * Called when the slime spawns particles on landing, see onUpdate.
     * Return true to prevent the spawning of the default particles.
     */

    protected boolean spawnCustomParticles() { return false; }

    static class AttackGoal extends Goal {
        private final EntityChocolateSlime slime;
        private int growTiredTimer;

        public AttackGoal(EntityChocolateSlime slimeIn) {
            this.slime = slimeIn;
            this.setFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        @Override
        public boolean canUse() {
            LivingEntity livingentity = this.slime.getTarget();
            if (livingentity == null) {
                return false;
            } else {
                return this.slime.canAttack(livingentity) && this.slime.getMoveControl() instanceof Entity.MoveFunction;
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        @Override
        public void start() {
            this.growTiredTimer = 300;
            super.start();
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        @Override
        public boolean canContinueToUse() {
            LivingEntity livingentity = this.slime.getTarget();
            if (livingentity == null) {
                return false;
            } else if (!this.slime.canAttack(livingentity)) {
                return false;
            } else {
                return --this.growTiredTimer > 0;
            }
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        @Override
        public void tick() {
            this.slime.lookAt(Objects.requireNonNull(this.slime.getTarget()), 10.0F, 10.0F);
            ((EntityChocolateSlime.MoveHelperController)this.slime.getMoveControl()).setDirection(this.slime.getYRot(), this.slime.canDamagePlayer());
        }
    }

    static class FaceRandomGoal extends Goal {
        private final EntityChocolateSlime slime;
        private float chosenDegrees;
        private int nextRandomizeTime;

        public FaceRandomGoal(EntityChocolateSlime slimeIn) {
            this.slime = slimeIn;
            this.setFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canUse() {
            return this.slime.getTarget() == null && (this.slime.onGround || this.slime.isInWater() || this.slime.isInLava() || this.slime.hasEffect(MobEffects.LEVITATION)) && this.slime.getMoveControl() instanceof EntityChocolateSlime.MoveHelperController;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            if (--this.nextRandomizeTime <= 0) {
                this.nextRandomizeTime = 40 + this.slime.getRandom().nextInt(60);
                this.chosenDegrees = (float)this.slime.getRandom().nextInt(360);
            }

            ((EntityChocolateSlime.MoveHelperController)this.slime.getMoveControl()).setDirection(this.chosenDegrees, false);
        }
    }

    static class FloatGoal extends Goal {
        private final EntityChocolateSlime slime;

        public FloatGoal(EntityChocolateSlime slimeIn) {
            this.slime = slimeIn;
            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
            slimeIn.getNavigation().setCanFloat(true);
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canUse() {
            return (this.slime.isInWater() || this.slime.isInLava()) && this.slime.getMoveControl() instanceof EntityChocolateSlime.MoveHelperController;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            if (this.slime.getRandom().nextFloat() < 0.8F) {
                this.slime.getJumpControl().jump();
            }

            ((EntityChocolateSlime.MoveHelperController)this.slime.getMoveControl()).setWantedMovement(1.2D);
        }
    }

    static class HopGoal extends Goal {
        private final EntityChocolateSlime slime;

        public HopGoal(EntityChocolateSlime slimeIn) {
            this.slime = slimeIn;
            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canUse() {
            return !this.slime.isPassenger();
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            ((EntityChocolateSlime.MoveHelperController)this.slime.getMoveControl()).setWantedMovement(1.0D);
        }
    }

    static class MoveHelperController extends MoveControl {
        private float yRot;
        private int jumpDelay;
        private final EntityChocolateSlime slime;
        private boolean isAggressive;

        public MoveHelperController(EntityChocolateSlime slimeIn) {
            super(slimeIn);
            this.slime = slimeIn;
            this.yRot = 180.0F * slimeIn.getYRot() / (float) Math.PI;
        }

        public void setDirection(float yRotIn, boolean aggressive) {
            this.yRot = yRotIn;
            this.isAggressive = aggressive;
        }

        public void setWantedMovement(double speedIn) {
            this.speedModifier = speedIn;
            this.operation = MoveControl.Operation.MOVE_TO;
        }

        public void tick() {
            this.mob.setYRot(this.rotlerp(this.mob.getYRot(), this.yRot, 90.0F));
            this.mob.yHeadRot = this.mob.getYRot();
            this.mob.yBodyRot = this.mob.getYRot();
            if (this.operation != MoveControl.Operation.MOVE_TO) {
                this.mob.setZza(0.0F);
            } else {
                this.operation = MoveControl.Operation.WAIT;
                if (this.mob.isOnGround()) {
                    this.mob.setSpeed((float) (this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                    if (this.jumpDelay-- <= 0) {
                        this.jumpDelay = this.slime.getJumpDelay();
                        if (this.isAggressive) {
                            this.jumpDelay /= 3;
                        }

                        this.slime.getJumpControl().jump();
                        if (this.slime.makesSoundOnJump()) {
                            this.slime.playSound(this.slime.getJumpSound(), this.slime.getSoundVolume(), this.slime.func_234304_m_());
                        }
                    } else {
                        this.slime.xxa = 0.0F;
                        this.slime.zza = 0.0F;
                        this.mob.setSpeed(0.0F);
                    }
                } else {
                    this.mob.setSpeed((float) (this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                }

            }
        }
    }
}
