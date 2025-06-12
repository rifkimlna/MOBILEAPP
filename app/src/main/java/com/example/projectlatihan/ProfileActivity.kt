package com.example.projectlatihan


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectlatihan.adapter.MahasiswaAdapter
import com.example.projectlatihan.database.AppDatabase
import com.example.projectlatihan.databinding.ActivityProfileBinding
import com.example.projectlatihan.databinding.DialogTambahMahasiswaBinding
import com.example.projectlatihan.entity.MahasiswaEntity


class ProfileActivity : AppCompatActivity() {
    private lateinit var database: AppDatabase
    private lateinit var binding: ActivityProfileBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val name = intent.getStringExtra("name")
        binding.tvName.text = "Hello, $name"


        database = AppDatabase.getDatabase(this)


        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        binding.btnTambah.setOnClickListener {
            showInputDialog()
        }


        refreshData()
    }


    private fun refreshData() {
        val data = database.mahasiswaDao().getAll()
        val adapter = MahasiswaAdapter(
            data,
            onEdit = { showInputDialog(it) },
            onDelete = {
                database.mahasiswaDao().delete(it)
                refreshData()
            }
        )
        binding.recyclerView.adapter = adapter
    }


    private fun showInputDialog(mahasiswa: MahasiswaEntity? = null) {
        val dialogBinding = DialogTambahMahasiswaBinding.inflate(layoutInflater)


        // Jika edit, set data ke inputan
        mahasiswa?.let {
            dialogBinding.etNim.setText(it.nim)
            dialogBinding.etNamaLengkap.setText(it.namaLengkap)
            dialogBinding.etUmur.setText(it.umur.toString())
            dialogBinding.etAlamat.setText(it.alamat)
            dialogBinding.etDomisili.setText(it.domisili)
            dialogBinding.etGambar.setText(it.gambar)
        }


        val dialogTitle = if (mahasiswa == null) "Tambah Mahasiswa" else "Edit Mahasiswa"


        val dialog = AlertDialog.Builder(this)
            .setTitle(dialogTitle)
            .setView(dialogBinding.root)
            .setPositiveButton("Simpan") { dialogInterface, _ ->
                val nim = dialogBinding.etNim.text.toString().trim()
                val nama = dialogBinding.etNamaLengkap.text.toString().trim()
                val umurStr = dialogBinding.etUmur.text.toString().trim()
                val alamat = dialogBinding.etAlamat.text.toString().trim()
                val domisili = dialogBinding.etDomisili.text.toString().trim()
                val gambar = dialogBinding.etGambar.text.toString().trim()


                if (nim.isEmpty() || nama.isEmpty() || umurStr.isEmpty()) {
                    Toast.makeText(this, "NIM, Nama, dan Umur wajib diisi", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val umur = umurStr.toIntOrNull() ?: 0


                    if (mahasiswa == null) {
                        val newMahasiswa = MahasiswaEntity(
                            nim = nim,
                            namaLengkap = nama,
                            umur = umur,
                            alamat = alamat,
                            domisili = domisili,
                            gambar = gambar
                        )
                        database.mahasiswaDao().insert(newMahasiswa)
                    } else {
                        val updatedMahasiswa = mahasiswa.copy(
                            nim = nim,
                            namaLengkap = nama,
                            umur = umur,
                            alamat = alamat,
                            domisili = domisili,
                            gambar = gambar
                        )
                        database.mahasiswaDao().update(updatedMahasiswa)
                    }
                    refreshData()
                    dialogInterface.dismiss()
                }
            }
            .setNegativeButton("Batal") { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            .create()


        dialog.show()
    }
}
