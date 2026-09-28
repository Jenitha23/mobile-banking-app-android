package com.example.mobilebankingapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilebankingapp.databinding.FragmentHistoryBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryFragment : Fragment(R.layout.fragment_history) {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: TransferHistoryAdapter
    private var transferList = mutableListOf<TransferRequest>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHistoryBinding.bind(view)

        setupRecyclerView()
        loadHistoryData()
    }

    private fun setupRecyclerView() {
        adapter = TransferHistoryAdapter(transferList)
        binding.rvTransferHistory.adapter = adapter
        binding.rvTransferHistory.layoutManager = LinearLayoutManager(requireContext())

        // Add Swipe-to-Delete
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val itemToDelete = transferList[position]

                lifecycleScope.launch(Dispatchers.IO) {
                    val db = AppDatabase.getInstance(requireContext())
                    db.transferDao().delete(itemToDelete)

                    withContext(Dispatchers.Main) {
                        transferList.removeAt(position)
                        adapter.notifyItemRemoved(position)
                        checkEmptyState()
                        Toast.makeText(requireContext(), "Transfer record deleted", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        itemTouchHelper.attachToRecyclerView(binding.rvTransferHistory)
    }

    private fun loadHistoryData() {
        lifecycleScope.launch(Dispatchers.IO) {
            val db = AppDatabase.getInstance(requireContext())
            val list = db.transferDao().getAll()

            withContext(Dispatchers.Main) {
                transferList.clear()
                transferList.addAll(list)
                adapter.notifyDataSetChanged()
                checkEmptyState()
            }
        }
    }

    private fun checkEmptyState() {
        if (transferList.isEmpty()) {
            binding.rvTransferHistory.visibility = View.GONE
            binding.tvEmptyState.visibility = View.VISIBLE
        } else {
            binding.rvTransferHistory.visibility = View.VISIBLE
            binding.tvEmptyState.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}