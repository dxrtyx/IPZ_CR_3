package ua.edu.lntu.cw3.affirmations.data

import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

class Datasource() {
    fun loadAffirmations(): List<itemAffirmation> {
        return listOf<itemAffirmation>(
            AffirmationItem(R.string.affirmation1, R.drawable.image1),
            AffirmationItem(R.string.affirmation2, R.drawable.image2),
            AffirmationItem(R.string.affirmation3, R.drawable.image3),
    }
}
