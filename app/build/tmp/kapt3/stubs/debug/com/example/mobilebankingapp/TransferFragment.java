package com.example.mobilebankingapp;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\t\u001a\u0015\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n\u00a2\u0006\u0002\b\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/mobilebankingapp/TransferFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/example/mobilebankingapp/databinding/FragmentTransferBinding;", "binding", "getBinding", "()Lcom/example/mobilebankingapp/databinding/FragmentTransferBinding;", "contactsPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "Lorg/jspecify/annotations/NonNull;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "prefillLastRecipient", "requestContactsAutocomplete", "loadContactSuggestions", "setupBankDropdown", "validateForm", "onSubmitTransfer", "onDestroyView", "Companion", "app_debug"})
public final class TransferFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> BANKS = null;
    @org.jetbrains.annotations.Nullable()
    private com.example.mobilebankingapp.databinding.FragmentTransferBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> contactsPermissionLauncher = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.mobilebankingapp.TransferFragment.Companion Companion = null;
    
    public TransferFragment() {
        super();
    }
    
    private final com.example.mobilebankingapp.databinding.FragmentTransferBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void prefillLastRecipient() {
    }
    
    private final void requestContactsAutocomplete() {
    }
    
    private final void loadContactSuggestions() {
    }
    
    private final void setupBankDropdown() {
    }
    
    private final void validateForm() {
    }
    
    private final void onSubmitTransfer() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/mobilebankingapp/TransferFragment$Companion;", "", "<init>", "()V", "BANKS", "", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}