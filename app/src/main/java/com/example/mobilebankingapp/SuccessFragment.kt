package com.example.mobilebankingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.BundleCompat
import androidx.fragment.app.Fragment

/**
 * Shown after a transfer has been confirmed and saved to Room.
 * Challenge Exercise: replaces the direct jump back to Dashboard with a
 * dedicated success screen (built from Lab 3's activity_success.xml, now
 * fragment_success.xml).
 */
class SuccessFragment : Fragment() {

    companion object {
        const val ARG_TRANSFER_REQUEST = "transfer_request"
    }

    private lateinit var transferRequest: TransferRequest

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_success, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        transferRequest = BundleCompat.getParcelable(
            requireArguments(), ARG_TRANSFER_REQUEST, TransferRequest::class.java
        )!!

        view.findViewById<TextView>(R.id.tvSuccessDetails).text =
            "${CurrencyFormatter.format(transferRequest.amount)} sent to ${transferRequest.recipientAccount}"

        view.findViewById<TextView>(R.id.tvSuccessDate).text =
            java.text.SimpleDateFormat("dd MMM yyyy, hh:mm a", java.util.Locale.getDefault())
                .format(java.util.Date())

        view.findViewById<Button>(R.id.btnDone).setOnClickListener {
            (requireActivity() as MainActivity).showDashboardFragment()
        }

        view.findViewById<Button>(R.id.btnViewHistory).setOnClickListener {
            (requireActivity() as MainActivity).showHistoryFragment()
        }
    }
}