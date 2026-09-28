package com.example.mobilebankingapp;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/mobilebankingapp/TransferDao_Impl;", "Lcom/example/mobilebankingapp/TransferDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfTransferRequest", "Landroidx/room/EntityInsertAdapter;", "Lcom/example/mobilebankingapp/TransferRequest;", "__deleteAdapterOfTransferRequest", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "insert", "", "request", "(Lcom/example/mobilebankingapp/TransferRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "getAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
@javax.annotation.processing.Generated(value = {"androidx.room.RoomProcessor"})
@kotlin.Suppress(names = {"UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"})
public final class TransferDao_Impl implements com.example.mobilebankingapp.TransferDao {
    @org.jetbrains.annotations.NotNull()
    private final androidx.room.RoomDatabase __db = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.room.EntityInsertAdapter<com.example.mobilebankingapp.TransferRequest> __insertAdapterOfTransferRequest = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.room.EntityDeleteOrUpdateAdapter<com.example.mobilebankingapp.TransferRequest> __deleteAdapterOfTransferRequest = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.mobilebankingapp.TransferDao_Impl.Companion Companion = null;
    
    public TransferDao_Impl(@org.jetbrains.annotations.NotNull()
    androidx.room.RoomDatabase __db) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.example.mobilebankingapp.TransferRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.example.mobilebankingapp.TransferRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.mobilebankingapp.TransferRequest>> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u00a8\u0006\u0007"}, d2 = {"Lcom/example/mobilebankingapp/TransferDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<kotlin.reflect.KClass<?>> getRequiredConverters() {
            return null;
        }
    }
}