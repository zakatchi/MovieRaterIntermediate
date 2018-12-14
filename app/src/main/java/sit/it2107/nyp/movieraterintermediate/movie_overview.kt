package sit.it2107.nyp.movieraterintermediate

import android.content.Intent
import android.graphics.Movie
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.RatingBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movie_overview.*
import android.widget.TextView



class movie_overview : AppCompatActivity() {

    var titleString: String =""
    var overviewString: String=""
    var languageString: String=""
    var dateString: String=""
    var suitableString: String= ""
    var review1String: String=""
    var review2String: String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_overview)

        val movie = intent.extras.get("key") as MovieEntity
        val suitable_bool: String
        val ratingBar = findViewById(R.id.review_ratingBarReal) as RatingBar
        titleID.text = movie.title
        overviewID.text = movie.desc
        languageID.text = movie.language
        dateID.text = movie.date
        review_ratingbar.text = movie.review1
        review_text.text = movie.review2

        titleString= movie.title
        overviewString = movie.desc
        languageString = movie.language
        dateString = movie.date
        review1String = movie.review1
        review2String = movie.review2
        if(movie.suitable == "true")
            suitable_bool = "No"
        else
            suitable_bool = "Yes"

        suitableID.text = suitable_bool
        suitableString = suitable_bool

        if(!(review1String == "No Reviews yet."))
        {
            ratingBar.setRating(movie.review1.toFloat())
            ratingBar.setVisibility(View.VISIBLE)
            val tv = findViewById(R.id.review_ratingbar) as TextView
            tv.setVisibility(View.GONE)
        }
        registerForContextMenu(review_text)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        if(v?.id== R.id.review_text){
            menu?.add(1, 3001, 1, "Add review")
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == 3001) {
            val obj = MovieEntity(titleString, overviewString, languageString, dateString, suitableString, review1String, review2String)
            val intent = Intent(this, submit_review::class.java)
            intent.putExtra("submitKey", obj)
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
        super.onBackPressed()
    }
}