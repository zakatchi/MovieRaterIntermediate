package sit.it2107.nyp.movieraterintermediate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox

class edit_review : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_review)

        val checkBoxFirst = findViewById<CheckBox>(R.id.edit_checkbox1)
        val checkBoxSecond = findViewById<CheckBox>(R.id.edit_checkbox2)
        val checkBoxThird = findViewById<CheckBox>(R.id.edit_checkbox3)

        checkBoxFirst?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                checkBoxSecond.setVisibility(View.VISIBLE)
                checkBoxThird.setVisibility(View.VISIBLE)



            } else {
                checkBoxSecond.setVisibility(View.INVISIBLE)
                checkBoxThird.setVisibility(View.INVISIBLE)
            }
        }

        //No Logic for intermediate
        //Only for advance separately
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_for_edit_review, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // No Logic for options item selected(for advance only)
}
