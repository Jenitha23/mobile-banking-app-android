package com.example.mobilebankingapp;

/**
 * Pure Kotlin validation for the transfer form.
 * No Fragment, no View Binding, no Context: that is what lets
 * TransferValidatorTest run on the plain JVM in milliseconds.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ \u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/mobilebankingapp/TransferValidator;", "", "<init>", "()V", "MAX_TRANSFER_AMOUNT", "", "parseAmount", "amountText", "", "(Ljava/lang/String;)Ljava/lang/Double;", "validate", "account", "name", "app_debug"})
public final class TransferValidator {
    public static final double MAX_TRANSFER_AMOUNT = 500000.0;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.mobilebankingapp.TransferValidator INSTANCE = null;
    
    private TransferValidator() {
        super();
    }
    
    /**
     * Turns what the user typed ("LKR 1,500.00", "2500", "abc") into a number,
     * or null if it is not a number. Same cleanup TransferFragment did inline before.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double parseAmount(@org.jetbrains.annotations.NotNull()
    java.lang.String amountText) {
        return null;
    }
    
    /**
     * Returns null if the input is valid, or an error message naming
     * the first problem found, in the same order onSubmitTransfer()
     * checked them.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String validate(@org.jetbrains.annotations.NotNull()
    java.lang.String account, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String amountText) {
        return null;
    }
}