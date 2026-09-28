package com.example.mobilebankingapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.BundleCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class ConfirmationFragment : Fragment() {

    companion object {
        const val ARG_TRANSFER_REQUEST = "transfer_request"
    }

    private lateinit var transferRequest: TransferRequest

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        transferRequest = BundleCompat.getParcelable(
            requireArguments(), ARG_TRANSFER_REQUEST, TransferRequest::class.java
        )!!

        view.findViewById<TextView>(R.id.tvConfirmRecipient).text =
            "To: ${transferRequest.recipientName} (${transferRequest.recipientAccount})"
        view.findViewById<TextView>(R.id.tvConfirmAmount).text =
            "Amount: LKR ${transferRequest.amount}"
        view.findViewById<TextView>(R.id.tvConfirmRemarks).text =
            "Remarks: ${transferRequest.remarks.ifEmpty { "None" }}"

        view.findViewById<Button>(R.id.btnEditTransfer).setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        view.findViewById<Button>(R.id.btnConfirm).setOnClickListener {
            lifecycleScope.launch {
                AppDatabase.getInstance(requireContext()).transferDao().insert(transferRequest)

                val prefs = requireContext().getSharedPreferences(
                    "banking_app_prefs", Context.MODE_PRIVATE
                )
                prefs.edit()
                    .putString("last_recipient_account", transferRequest.recipientAccount)
                    .putString("last_recipient_name", transferRequest.recipientName)
                    .apply()

                (requireActivity() as MainActivity).showSuccessFragment(transferRequest)
            }
        }
    }
}