package net.codecision.startask.http.code.sample

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.codecision.startask.http.code.HttpStatusCode
import net.codecision.startask.http.code.sample.network.ApiService
import net.codecision.startask.http.code.sample.network.PersonResponse
import net.codecision.startask.http.code.sample.network.toHttpStatusCode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val apiService: ApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create<ApiService>(ApiService::class.java)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {

        initListeners()
    }

    private fun initListeners() {
        doJobButton.setOnClickListener {
            try {
                val personId = personInputView.text.toString().toInt()
                fetchPerson(personId)
            } catch (e: NumberFormatException) {
                showToast("")
            }
        }
    }

    private fun fetchPerson(id: Int) {
        toggleProgressView(true)

        apiService.getPerson(id).enqueue(object : Callback<PersonResponse> {
            override fun onFailure(call: Call<PersonResponse>, t: Throwable) {
                toggleProgressView(false)

                updatePerson(null)
                showToast("Something went wrong!")
            }

            override fun onResponse(
                call: Call<PersonResponse>,
                response: Response<PersonResponse>
            ) {
                toggleProgressView(false)

                when (response.toHttpStatusCode()) {
                    HttpStatusCode.OK -> {
                        updatePerson(response.body())
                    }
                    HttpStatusCode.NotFound -> {
                        updatePerson(null)
                        showToast("NotFound")
                    }
                    else -> {
                        updatePerson(null)
                        showToast("Something went wrong!")
                    }
                }
            }
        })
    }

    private fun toggleProgressView(isVisible: Boolean) {
        progressView.visibility = if (isVisible) View.VISIBLE else (View.GONE)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetTextI18n")
    private fun updatePerson(person: PersonResponse?) {
        nameView.text = "Name: ${person?.name ?: ""}"
        heightView.text = "Height: ${person?.height ?: ""}"
        massView.text = "Mass: ${person?.mass ?: ""}"
        hairColorView.text = "Hair Color: ${person?.hairColor ?: ""}"
        skinColorView.text = "Skin Color: ${person?.skinColor ?: ""}"
        eyeColorView.text = "Eye Color: ${person?.eyeColor ?: ""}"
    }

    companion object {

        private const val BASE_URL = "https://swapi.co/api/"

    }

}