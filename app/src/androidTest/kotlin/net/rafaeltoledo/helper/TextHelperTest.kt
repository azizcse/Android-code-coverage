package net.rafaeltoledo.helper

import org.junit.After
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/*
 *  ****************************************************************************
 *  * Created by : Md. Azizul Islam on 12/21/2018 at 2:34 PM.
 *  * Email : azizul@w3engineers.com
 *  *
 *  * Purpose:
 *  *
 *  * Last edited by : Md. Azizul Islam on 12/21/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

class TextHelperTest{
    private var textHelper: TextHelper? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        textHelper = TextHelper.getInstance()
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        textHelper = null
    }

    @Test
    fun testGetProgress() {
        Assert.assertEquals(textHelper!!.getProgress(30), "LOW")
    }

    @Test
    fun testHigh() {
        Assert.assertEquals(textHelper!!.getProgress(51), "HIGH")
    }
}