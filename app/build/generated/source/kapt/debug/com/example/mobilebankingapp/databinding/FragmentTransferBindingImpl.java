package com.example.mobilebankingapp.databinding;
import com.example.mobilebankingapp.R;
import com.example.mobilebankingapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentTransferBindingImpl extends FragmentTransferBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.btnCancel, 1);
        sViewsWithIds.put(R.id.tvTransferHeader, 2);
        sViewsWithIds.put(R.id.lblRecipientName, 3);
        sViewsWithIds.put(R.id.fieldRecipientName, 4);
        sViewsWithIds.put(R.id.etRecipientName, 5);
        sViewsWithIds.put(R.id.lblRecipientAccount, 6);
        sViewsWithIds.put(R.id.fieldRecipientAccount, 7);
        sViewsWithIds.put(R.id.etRecipientAccount, 8);
        sViewsWithIds.put(R.id.lblBank, 9);
        sViewsWithIds.put(R.id.fieldBank, 10);
        sViewsWithIds.put(R.id.etBank, 11);
        sViewsWithIds.put(R.id.tvBankError, 12);
        sViewsWithIds.put(R.id.lblAmount, 13);
        sViewsWithIds.put(R.id.fieldAmount, 14);
        sViewsWithIds.put(R.id.etAmount, 15);
        sViewsWithIds.put(R.id.tvAmountHelper, 16);
        sViewsWithIds.put(R.id.lblRemarks, 17);
        sViewsWithIds.put(R.id.fieldRemarks, 18);
        sViewsWithIds.put(R.id.etRemarks, 19);
        sViewsWithIds.put(R.id.btnSubmit, 20);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentTransferBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }
    private FragmentTransferBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.button.MaterialButton) bindings[1]
            , (android.widget.Button) bindings[20]
            , (android.widget.EditText) bindings[15]
            , (android.widget.AutoCompleteTextView) bindings[11]
            , (android.widget.EditText) bindings[8]
            , (android.widget.AutoCompleteTextView) bindings[5]
            , (android.widget.EditText) bindings[19]
            , (android.widget.FrameLayout) bindings[14]
            , (android.widget.FrameLayout) bindings[10]
            , (android.widget.FrameLayout) bindings[7]
            , (android.widget.FrameLayout) bindings[4]
            , (android.widget.FrameLayout) bindings[18]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}