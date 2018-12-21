package net.rafaeltoledo.helper


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/21/2018 at 2:33 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Purpose:
*  *
*  * Last edited by : Md. Azizul Islam on 12/21/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

class TextHelper {
    companion object {
        private var textHelper: TextHelper? = null

        fun getInstance(): TextHelper {
            if (textHelper == null) {
                textHelper = TextHelper()
            }

            return textHelper!!
        }
    }



    fun getProgress(progress: Int): String {
        return if (progress > 0 && progress < 50) {
            "LOW"
        } else {
            "HIGH"
        }
    }
}