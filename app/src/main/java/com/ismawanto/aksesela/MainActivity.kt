package com.ismawanto.aksesela

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ismawanto.aksesela.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        //membuka layout activity_main
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Saat btn tbLogin diklik
        binding.tbLogin.setOnClickListener {
            //jalankan fungsi   cekLogin()
            cekLogin()
        }
    }
    private fun cekLogin() {
        // mengambil data dari input text txtNama dan txtPass simapan dalam string
        val namaPengguna = binding.txtNama.text.toString()
        val passwordPengguna = binding.txtPass.text.toString()


        //jika inputan kosong
        if (namaPengguna.isEmpty() || passwordPengguna.isEmpty()) {
            Toast.makeText(this, "Isi semua input", Toast.LENGTH_SHORT).show()
            return
        }

        //cek apakah password 123456
        if(passwordPengguna == "123456"){
          //membuat intent ke class UserActivity
            val intent = Intent(this, UserActivity::class.java)

           //kirim txtNama atribut text
            intent.putExtra("nama", binding.txtNama.text.toString())

            // activity UserActivity dimulai
            startActivity(intent)


        }else{
            Toast.makeText(this, "Password salah", Toast.LENGTH_SHORT).show()
            return
        }
    }
}