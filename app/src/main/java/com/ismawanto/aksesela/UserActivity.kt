package com.ismawanto.aksesela

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ismawanto.aksesela.databinding.ActivityPengunaBinding


class UserActivity : AppCompatActivity() {
    lateinit var binding: ActivityPengunaBinding
    var idPengguna = ""

    companion object {
        const val PENGGUNA = "nama"
        const val ELA = "https://elearning.utdi.ac.id/login/index.php"
        const val SIAKAD = "https://siakad.akakom.ac.id/"
    }
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        //membuka layout activity_penguna
        binding = ActivityPengunaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Saat tbSiakad diklik
        binding.tbSiakad.setOnClickListener {
            //jalankan fungsi   siakad()
            siakad()
        }
        //Saat btn tbEla diklik
        binding.tbEla.setOnClickListener {
            //jalankan fungsi ela()
            ela()
        }
        //set idPengugna
        idPengguna = intent?.extras?.getString(PENGGUNA).toString()
        //textNama atribut text adalha idPengguna
        binding.textNama.text = idPengguna

    }
    private fun ela(){
        //menyiadakan url yang ela yang dituju
        val queryUrl: Uri = Uri.parse(ELA)
        //membuat intent untuk menuju alamat web yang akan dituju
        val intent = Intent(Intent.ACTION_VIEW, queryUrl)
        // aktifkan intent
        startActivity(intent)
    }
    private fun siakad(){
        //menyiadakan url yang siakad yang dituju
        val queryUrl: Uri = Uri.parse(SIAKAD)
        //membuat intent untuk menuju alamat web yang akan dituju
        val intent = Intent(Intent.ACTION_VIEW, queryUrl)
        // aktifkan intent
        startActivity(intent)
    }
}