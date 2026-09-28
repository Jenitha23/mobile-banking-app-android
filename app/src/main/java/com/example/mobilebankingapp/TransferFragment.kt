package com.example.mobilebankingapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.mobilebankingapp.databinding.FragmentTransferBinding

class TransferFragment : Fragment() {

    companion object {
        private val BANKS = listOf(
            "Commercial Bank of Ceylon",
            "Sampath Bank",
            "Hatton National Bank (HNB)",
            "Bank of Ceylon (BOC)",
            "People's Bank",
            "Seylan Bank",
            "DFCC Bank",
            "National Savings Bank (NSB)",
            "Nations Trust Bank",
            "Pan Asia Bank"
        )
    }

    private var _binding: FragmentTransferBinding? = null
    private val binding get() = _binding!!

    // Challenge Exercise: contacts-based autocomplete for the recipient name field.
    private val contactsPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) loadContactSuggestions()
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransferBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupBankDropdown()
        prefillLastRecipient()
        requestContactsAutocomplete()

        // Submit stays disabled until the required fields are non-empty.
        binding.btnSubmit.isEnabled = false
        binding.etRecipientAccount.doOnTextChanged { _, _, _, _ -> validateForm() }
        binding.etRecipientName.doOnTextChanged { _, _, _, _ -> validateForm() }
        binding.etAmount.doOnTextChanged { _, _, _, _ -> validateForm() }
        binding.etBank.doOnTextChanged { _, _, _, _ -> validateForm() }

        binding.btnSubmit.setOnClickListener { onSubmitTransfer() }
        binding.btnCancel.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        // Re-check enable state now in case the pre-fill above already
        // satisfied the recipient account/name fields.
        validateForm()
    }

    private fun prefillLastRecipient() {
        val prefs = requireContext().getSharedPreferences(
            "banking_app_prefs", Context.MODE_PRIVATE
        )
        binding.etRecipientAccount.setText(
            prefs.getString("last_recipient_account", "")
        )
        binding.etRecipientName.setText(
            prefs.getString("last_recipient_name", "")
        )
    }

    private fun requestContactsAutocomplete() {
        val hasPermission = ContextCompat.checkSelfPermission(
            requireContext(), Manifest.permission.READ_CONTACTS
        ) == PackageManager.PERMISSION_GRANTED

        if (hasPermission) {
            loadContactSuggestions()
        } else {
            contactsPermissionLauncher.launch(Manifest.permission.READ_CONTACTS)
        }
    }

    private fun loadContactSuggestions() {
        val names = mutableListOf<String>()
        val cursor = requireContext().contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            arrayOf(ContactsContract.Contacts.DISPLAY_NAME),
            null,
            null,
            "${ContactsContract.Contacts.DISPLAY_NAME} ASC"
        )
        cursor?.use {
            val nameIndex = it.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
            while (it.moveToNext()) {
                if (nameIndex >= 0) {
                    it.getString(nameIndex)?.let { name -> names.add(name) }
                }
            }
        }

        // The fragment's view may already be torn down by the time this
        // returns (permission dialogs are asynchronous), so bail safely.
        if (_binding == null) return

        val adapter = ArrayAdapter(
            requireContext(), android.R.layout.simple_list_item_1, names.distinct()
        )
        binding.etRecipientName.setAdapter(adapter)
        binding.etRecipientName.threshold = 1
    }

    private fun setupBankDropdown() {
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, BANKS)
        binding.etBank.setAdapter(adapter)

        // The field is set to non-editable text input in XML, so tapping it
        // anywhere should pop the list open, same as an exposed dropdown.
        binding.etBank.setOnClickListener {
            binding.etBank.showDropDown()
        }
        binding.etBank.setOnItemClickListener { _, _, _, _ ->
            binding.tvBankError.visibility = View.GONE
            validateForm()
        }
    }

    private fun validateForm() {
        val account = binding.etRecipientAccount.text.toString().trim()
        val name = binding.etRecipientName.text.toString().trim()
        val amount = binding.etAmount.text.toString().trim()
        val bank = binding.etBank.text.toString().trim()
        binding.btnSubmit.isEnabled =
            account.isNotEmpty() && name.isNotEmpty() && amount.isNotEmpty() && bank.isNotEmpty()
    }

    private fun onSubmitTransfer() {
        val account = binding.etRecipientAccount.text.toString().trim()
        val name = binding.etRecipientName.text.toString().trim()
        val bank = binding.etBank.text.toString().trim()
        val amountText = binding.etAmount.text.toString().trim()
        val remarks = binding.etRemarks.text.toString().trim()

        // Lab 08: account / name / amount rules now live in TransferValidator.
        val error = TransferValidator.validate(account, name, amountText)
        if (error != null) {
            // Only decides WHICH field shows the message; the rules are not repeated here.
            when {
                account.isBlank() -> binding.etRecipientAccount.error = error
                name.isBlank() -> binding.etRecipientName.error = error
                else -> binding.etAmount.error = error
            }
            return
        }

        // The bank check stays here on purpose: it drives views (tvBankError, the dropdown),
        // so it is UI behaviour, not a pure rule.
        if (bank.isEmpty() || !BANKS.contains(bank)) {
            binding.tvBankError.visibility = View.VISIBLE
            binding.etBank.showDropDown()
            return
        }

        // Safe: validate() already returned null, so the amount parses and is in range.
        val amount = TransferValidator.parseAmount(amountText)!!

        val remarksWithBank = if (remarks.isEmpty()) "Bank: $bank" else "$remarks | Bank: $bank"
        val request = TransferRequest(account, name, amount, remarksWithBank)
        (requireActivity() as MainActivity).showConfirmationFragment(request)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}