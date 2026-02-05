package te.oldpa.myroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope // 建議改用這個
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import te.oldpa.myroom.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var database: EmpDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        database = EmpDatabase.getInstance(requireContext().applicationContext)

        binding.btnSave.setOnClickListener {
            // Lambda 的開始
            when {
                binding.etEmpId.text.toString().isEmpty() -> {
                    binding.etEmpId.error = "請輸入員工編號"
                }
                binding.etNamw.text.toString().isEmpty() -> {
                    binding.etNamw.error = "name is required"

                }
                binding.etAddress.text.toString().isEmpty() -> {
                    binding.etAddress.error = "address is required"

                }
                binding.etExp.text.toString().isEmpty() -> {
                    binding.etExp.error = "experience is required"

                }
                binding.etDepart.text.toString().isEmpty() -> {
                    binding.etDepart.error = "department is required"

                }
                else -> {
                    // --- 只有資料正確時才執行以下動作 ---
                    val empId = binding.etEmpId.text.toString().toInt()

                    // 執行存檔
                    GlobalScope.launch {
                        database.empDao().InsertEmpliyee(
                            Empliyee(
                                empId, binding.etNamw.text.toString(),
                                binding.etAddress.text.toString(),
                                binding.etExp.text.toString(),
                                binding.etDepart.text.toString()
                            )
                        )
                    }



                     // 【修正點 2】這是 else 的最後一行，也是整個 Lambda 的最後一行，回傳 Boolean
                }
            }
            Toast.makeText(requireContext(), "Records inserted sussfully ", Toast.LENGTH_SHORT).show()
            binding.etEmpId.text?.clear()
            binding.etNamw.text?.clear()
            binding.etAddress.text?.clear()
            binding.etExp.text?.clear()
            binding.etDepart.text?.clear()// when 結束，因為它是最後的敘述，其結果(Boolean)會被回傳
        }
    }
}