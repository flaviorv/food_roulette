package com.example.food.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/example/food/activities/AgendaActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/food/ClickUpdateInterface;", "Lcom/example/food/ClickDeleteInterface;", "()V", "mAdView", "Lcom/google/android/gms/ads/AdView;", "getMAdView", "()Lcom/google/android/gms/ads/AdView;", "setMAdView", "(Lcom/google/android/gms/ads/AdView;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "viewModel", "Lcom/example/food/FoodViewModel;", "getViewModel", "()Lcom/example/food/FoodViewModel;", "setViewModel", "(Lcom/example/food/FoodViewModel;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteInterface", "food", "Lcom/example/food/database/Food;", "onUpdateInterface", "app_debug"})
public final class AgendaActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.food.ClickUpdateInterface, com.example.food.ClickDeleteInterface {
    public com.example.food.FoodViewModel viewModel;
    public androidx.recyclerview.widget.RecyclerView recyclerView;
    public com.google.android.gms.ads.AdView mAdView;
    
    public AgendaActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.food.FoodViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull()
    com.example.food.FoodViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerView() {
        return null;
    }
    
    public final void setRecyclerView(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.ads.AdView getMAdView() {
        return null;
    }
    
    public final void setMAdView(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.ads.AdView p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onUpdateInterface(@org.jetbrains.annotations.NotNull()
    com.example.food.database.Food food) {
    }
    
    @java.lang.Override()
    public void onDeleteInterface(@org.jetbrains.annotations.NotNull()
    com.example.food.database.Food food) {
    }
}