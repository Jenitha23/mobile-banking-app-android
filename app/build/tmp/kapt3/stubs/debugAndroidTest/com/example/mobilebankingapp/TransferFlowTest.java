package com.example.mobilebankingapp;

@org.junit.runner.RunWith(value = androidx.test.ext.junit.runners.AndroidJUnit4.class)
@androidx.test.filters.LargeTest()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0007R\u0013\u0010\u0004\u001a\u00020\u00058G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R!\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t8G\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/example/mobilebankingapp/TransferFlowTest;", "", "<init>", "()V", "permissionRule", "Landroidx/test/rule/GrantPermissionRule;", "getPermissionRule", "()Landroidx/test/rule/GrantPermissionRule;", "activityRule", "Landroidx/test/ext/junit/rules/ActivityScenarioRule;", "Lcom/example/mobilebankingapp/MainActivity;", "kotlin.jvm.PlatformType", "getActivityRule", "()Landroidx/test/ext/junit/rules/ActivityScenarioRule;", "validTransferShowsConfirmationScreen", "", "app_debugAndroidTest"})
public final class TransferFlowTest {
    @org.jetbrains.annotations.NotNull()
    private final androidx.test.rule.GrantPermissionRule permissionRule = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.test.ext.junit.rules.ActivityScenarioRule<com.example.mobilebankingapp.MainActivity> activityRule = null;
    
    public TransferFlowTest() {
        super();
    }
    
    @org.junit.Rule(order = 0)
    @org.jetbrains.annotations.NotNull()
    public final androidx.test.rule.GrantPermissionRule getPermissionRule() {
        return null;
    }
    
    @org.junit.Rule(order = 1)
    @org.jetbrains.annotations.NotNull()
    public final androidx.test.ext.junit.rules.ActivityScenarioRule<com.example.mobilebankingapp.MainActivity> getActivityRule() {
        return null;
    }
    
    @org.junit.Test()
    public final void validTransferShowsConfirmationScreen() {
    }
}