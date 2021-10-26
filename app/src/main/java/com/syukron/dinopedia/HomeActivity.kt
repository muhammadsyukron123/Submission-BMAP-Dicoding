package com.syukron.dinopedia


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    private  lateinit var rvDino: RecyclerView
    private var list: ArrayList<Dino> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvDino = findViewById(R.id.rv_dinos)
        rvDino.setHasFixedSize(true)

        list.addAll(DinosData.listData)
        showRecyclerList()
    }


    private fun showRecyclerList(){
        rvDino.layoutManager = LinearLayoutManager(this)
        val listDinoAdapter = ListDinoAdapter(list)
        rvDino.adapter = listDinoAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.btProfile -> {
                val myProfile = Intent(this@HomeActivity,
                    Profile::class.java)
                startActivity(myProfile)
            }
        }
    }
}