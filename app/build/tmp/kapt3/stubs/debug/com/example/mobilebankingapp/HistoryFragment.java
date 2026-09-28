package com.example.mobilebankingapp;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/mobilebankingapp/HistoryFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/example/mobilebankingapp/databinding/FragmentHistoryBinding;", "binding", "getBinding", "()Lcom/example/mobilebankingapp/databinding/FragmentHistoryBinding;", "adapter", "Lcom/example/mobilebankingapp/TransferHistoryAdapter;", "transferList", "", "Lcom/example/mobilebankingapp/TransferRequest;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupRecyclerView", "loadHistoryData", "checkEmptyState", "onDestroyView", "app_debug"})
public final class HistoryFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.mobilebankingapp.databinding.FragmentHistoryBinding _binding;
    private com.example.mobilebankingapp.TransferHistoryAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.mobilebankingapp.TransferRequest> transferList;
    
    public HistoryFragment() {
        super();
    }
    
    private final com.example.mobilebankingapp.databinding.FragmentHistoryBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void loadHistoryData() {
    }
    
    private final void checkEmptyState() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}